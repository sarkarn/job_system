package com.nns.job.system.service;

import com.nns.job.system.db.entity.JobTaskInstance;
import com.nns.job.system.db.repository.JobTaskInstanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobTaskInstanceServiceImpl implements JobTaskInstanceService{

    @Autowired
    JobTaskInstanceRepository jobTaskInstanceRepository;
    public JobTaskInstance createJobInstance(JobTaskInstance jobTaskInstance){
        return jobTaskInstanceRepository.save(jobTaskInstance);
    }

    public JobTaskInstance updateJobInstance(JobTaskInstance jobTaskInstance){
        return jobTaskInstanceRepository.save(jobTaskInstance);
    }

    public void deleteTaskInstanceOlderThanNinetyDays() {

    }
}
