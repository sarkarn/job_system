package com.nns.job.system.db.repository;


import com.nns.job.system.db.entity.JobInstance;
import com.nns.job.system.db.entity.JobTaskInstance;
import org.springframework.stereotype.Repository;

@Repository
public class JobTaskInstanceRepository {

    public JobTaskInstance createJobTaskInstance(JobTaskInstance jobTaskInstance){
        return new JobTaskInstance();
    }

    public JobTaskInstance updateJobTaskInstance(JobTaskInstance jobTaskInstance){
        return new JobTaskInstance();
    }
}
