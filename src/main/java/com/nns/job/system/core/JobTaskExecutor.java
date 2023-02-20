package com.nns.job.system.core;

import com.nns.job.system.db.entity.JobTaskInstance;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.Callable;

public class JobTaskExecutor extends AbstractJobTaskExecutor implements Callable<JobTaskResult> {

    private Task task;
    private JobTaskInstance jobTaskInstance;

    @Getter
    @Setter
    private Long jobInstanceId;

    @Getter
    @Setter
    private Long jobId;

    public JobTaskExecutor(Task task){
        super(task);
        jobTaskInstance = new JobTaskInstance();
        task.setJobTaskInstance(jobTaskInstance);

    }

    @Override
    public JobTaskResult call() throws Exception {
        jobTaskInstance.setJobInstanceId(getJobInstanceId());
        jobTaskInstance.setJobId(getJobId());
        JobTaskInstanceLifeCycleCallback
                jobTaskInstanceLifeCycleCallback = new JobTaskInstanceLifeCycleCallback(jobTaskInstance);

        return executeWith(jobTaskInstanceLifeCycleCallback);

    }

}
