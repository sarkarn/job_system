package com.nns.job.system.core;

import com.nns.job.system.db.entity.JobTaskInstance;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Task {
    private JobTaskInstancePostExecuteCallback jobTaskInstancePostExecuteCallback;
    private JobTaskInstance jobTaskInstance;

    public Task(JobTaskInstancePostExecuteCallback jobTaskInstancePostExecuteCallback){
        this.jobTaskInstancePostExecuteCallback = jobTaskInstancePostExecuteCallback;
    }

    public abstract JobTaskResult execute() throws Exception;
}
