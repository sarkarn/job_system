package com.nns.job.system.service;

import com.nns.job.system.db.entity.JobEntity;

public interface JobService {

    public JobEntity getJobInfo(String jobCode);
}
