package com.nns.job.system.exec;

import com.nns.job.system.core.JobTaskInstancePostExecuteCallback;
import com.nns.job.system.db.entity.JobTaskInstance;

public class TestJobTaskInstancePostExecuteCallback implements JobTaskInstancePostExecuteCallback {

    @Override
    public void postJobTaskExecute(JobTaskInstance jobTaskInstance) {
        System.out.println("Performing post task execution work");
    }
}
