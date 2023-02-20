package com.nns.job.system.db.repository;

import com.nns.job.system.db.entity.JobEntity;
import org.springframework.stereotype.Repository;

@Repository
public class JobRepository {

    public JobEntity findByJobCode(String jobCode){
        return new JobEntity();
    }
}
