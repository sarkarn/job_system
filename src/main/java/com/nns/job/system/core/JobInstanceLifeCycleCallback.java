package com.nns.job.system.core;

import com.nns.job.system.db.entity.JobInstance;
import com.nns.job.system.service.JobInstanceService;
import com.nns.job.system.service.JobInstanceServiceImpl;
import com.nns.job.system.util.BeanUtil;
import lombok.extern.slf4j.Slf4j;
import org.omg.CORBA.Environment;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;

@Slf4j
public class JobInstanceLifeCycleCallback {

    private JobInstanceService jobInstanceService;
    private JobInstance jobInstance;
    private Environment env;

    public JobInstanceLifeCycleCallback(JobInstance jobInstance) {
        this.jobInstance = jobInstance;
        jobInstanceService = BeanUtil.getBean(JobInstanceServiceImpl.class);
    }

    JobInstance onStart() {
        log.info("Starting Job : " + jobInstance.getId());
        jobInstance.setStartTime(LocalDateTime.now());
        jobInstance.setStatus("RUNNING");
        jobInstanceService.createJobInstance(jobInstance);
        return jobInstance;
    }

    void onEnd() {
        log.info("Completed Job : " + jobInstance.getId());
        jobInstance.setEndTime(LocalDateTime.now());
        jobInstance.setStatus("SUCCEEDED");
        jobInstanceService.updateJobInstance(jobInstance);
    }

    void onError(Exception ex) {
        jobInstance.setEndTime(LocalDateTime.now());
        jobInstance.setStatus("FAILED");
        jobInstanceService.updateJobInstance(jobInstance);

        String errorReason = ex.toString();
        if(!StringUtils.isEmpty(errorReason)) {
            int length = errorReason.length();
            if( length > 3500){
                length = 3500;
                errorReason = errorReason.substring(0,length);
            }
        }
        jobInstance.setFailureReason(errorReason);
    }
}
