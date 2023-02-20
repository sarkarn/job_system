package com.nns.job.system.service;

import com.nns.job.system.db.entity.JobInstance;

public interface JobInstanceService {

    public JobInstance createJobInstance(JobInstance jobInstance);

    public JobInstance updateJobInstance(JobInstance jobInstance);

    public void deleteJobInstanceOlderThanNinetyDays();

}
