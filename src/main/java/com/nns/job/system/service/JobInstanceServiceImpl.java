package com.nns.job.system.service;

import com.nns.job.system.db.entity.JobInstance;
import com.nns.job.system.db.repository.JobInstanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobInstanceServiceImpl implements JobInstanceService {

    @Autowired
    JobInstanceRepository jobInstanceRepository;
    public JobInstance createJobInstance(JobInstance jobInstance){
        return jobInstanceRepository.createJobInstance(jobInstance);
    }

    public JobInstance updateJobInstance(JobInstance jobInstance){
        return jobInstanceRepository.updateJobInstance(jobInstance);
    }

    public void deleteJobInstanceOlderThanNinetyDays() {

    }

}
