package com.nns.job.system.db.repository;


import com.nns.job.system.db.entity.JobInstance;
import com.nns.job.system.db.entity.JobTaskInstance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobTaskInstanceRepository extends JpaRepository<JobTaskInstance, Long> {


}
