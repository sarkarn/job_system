package com.nns.job.system.db.repository;


import com.nns.job.system.db.entity.JobInstance;
import com.nns.job.system.db.entity.JobTaskInstance;
import org.springframework.stereotype.Repository;

@Repository
public class JobInstanceRepository {

    public JobInstance createJobInstance(JobInstance jobTaskInstance){
        return new JobInstance();
    }

    public JobInstance updateJobInstance(JobInstance jobTaskInstance){
        return new JobInstance();
    }
}
