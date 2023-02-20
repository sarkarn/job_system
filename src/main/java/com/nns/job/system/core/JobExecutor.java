package com.nns.job.system.core;

import com.nns.job.system.db.entity.JobEntity;
import com.nns.job.system.db.entity.JobInstance;
import com.nns.job.system.service.*;
import com.nns.job.system.util.BeanUtil;
import jdk.nashorn.internal.objects.annotations.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;


@Slf4j
public class JobExecutor {
    private final List<JobTaskExecutor> executorList = new ArrayList<>();
    private final JobInstancePreExecuteCallback jobInstancePreExecuteCallback;
    private final JobInstanceLifeCycleCallback jobInstanceLifeCycleCallback;
    private final String jobCode;
    private final JobTaskInstanceService jobTaskInstanceService;
    private final JobInstanceService jobInstanceService;
    private final JobService jobService;
    private final JobEntity jobEntity;

    public JobExecutor(JobInstancePreExecuteCallback jobInstancePreExecuteCallback,
                       String jobCode){
        this.jobTaskInstanceService = BeanUtil.getBean(JobTaskInstanceServiceImpl.class);
        this.jobInstanceService =  BeanUtil.getBean(JobInstanceServiceImpl.class);
        this.jobService = BeanUtil.getBean(JobServiceImpl.class);
        this.jobInstancePreExecuteCallback = jobInstancePreExecuteCallback;
        this.jobEntity = jobService.getJobInfo(jobCode);
        JobInstance jobInstance = new JobInstance();
        jobInstance.setJobId(jobEntity.getId());
        this.jobInstanceLifeCycleCallback = new JobInstanceLifeCycleCallback(jobInstance);
        this.jobCode = jobCode;
    }

    public void add(JobTaskExecutor jobTaskExecutor){
        if("Y".equalsIgnoreCase(jobEntity.getIsActive())) {
            executorList.add(jobTaskExecutor);
        }
    }

    public void executeTask(ExecutorService executorService) {
        jobTaskInstanceService.deleteTaskInstanceOlderThanNinetyDays();
        jobInstanceService.deleteJobInstanceOlderThanNinetyDays();
        if(jobInstancePreExecuteCallback != null) {
            jobInstancePreExecuteCallback.beforeStart();
        }
        JobInstance jobInstance = jobInstanceLifeCycleCallback.onStart();

        List<Future<JobTaskResult>> futureJobTaskResultList = new ArrayList<>();
        for(JobTaskExecutor taskExecutor : executorList){
            taskExecutor.setJobInstanceId(jobInstance.getId());
            taskExecutor.setJobId(jobEntity.getId());
            Future<JobTaskResult>
                    futureTaskResult = executorService.submit(taskExecutor);
            futureJobTaskResultList.add(futureTaskResult);
        }

        int index = 0;
        while(futureJobTaskResultList.size() > 0) {
            Future<JobTaskResult> futureTaskResult = futureJobTaskResultList.get(0);
            try{
                if(futureTaskResult != null) {
                    if(futureTaskResult.isDone()){
                        JobTaskResult jobTaskResult = futureTaskResult.get();
                        if(jobTaskResult == null){
                            log.error("Job Execution failed");
                            jobInstanceLifeCycleCallback.onError(new Exception("Job Failed"));
                        }
                        futureJobTaskResultList.remove(futureTaskResult);
                    }
                }
            }catch(Exception ex){
                log.error("Job Execution failed");
                jobInstanceLifeCycleCallback.onError(ex);
                futureJobTaskResultList.remove(futureTaskResult);
            }
        }
        jobInstanceLifeCycleCallback.onEnd();
    }
}
