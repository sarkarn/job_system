package com.nns.job.system.core;

import com.nns.job.system.db.entity.JobTaskInstance;

public interface JobTaskInstancePostExecuteCallback {

    public void postJobTaskExecute(JobTaskInstance jobTaskInstance);
}
