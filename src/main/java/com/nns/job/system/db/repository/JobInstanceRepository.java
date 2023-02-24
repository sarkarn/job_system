package com.nns.job.system.db.repository;


import com.nns.job.system.db.entity.JobInstance;
import com.nns.job.system.db.entity.JobTaskInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public interface JobInstanceRepository extends JpaRepository<JobInstance, Long> {


}
