package com.nns.job.system.service;

import com.nns.job.system.db.entity.JobEntity;
import com.nns.job.system.db.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class JobServiceImpl implements JobService {
    @Autowired
    JobRepository jobRepository;

    public JobEntity getJobInfo(String jobCode) {
        return jobRepository.findByJobCode(jobCode);
    }
}
