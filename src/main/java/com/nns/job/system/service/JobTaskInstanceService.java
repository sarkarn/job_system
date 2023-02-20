package com.nns.job.system.service;


import com.nns.job.system.db.entity.JobTaskInstance;


public interface JobTaskInstanceService {

    public JobTaskInstance createJobInstance(JobTaskInstance jobTaskInstance);

    public JobTaskInstance updateJobInstance(JobTaskInstance jobTaskInstance);

    public void deleteTaskInstanceOlderThanNinetyDays();

}
