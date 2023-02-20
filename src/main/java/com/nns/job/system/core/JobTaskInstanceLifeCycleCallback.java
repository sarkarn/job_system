package com.nns.job.system.core;

import com.nns.job.system.db.entity.JobTaskInstance;
import com.nns.job.system.service.JobTaskInstanceServiceImpl;
import com.nns.job.system.util.BeanUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;


@Slf4j
public class JobTaskInstanceLifeCycleCallback {
    private JobTaskInstance jobTaskInstance;
    private JobTaskInstanceServiceImpl jobTaskInstanceServiceImpl;

    public JobTaskInstanceLifeCycleCallback(JobTaskInstance jobTaskInstance) {
        this.jobTaskInstance = jobTaskInstance;
        jobTaskInstanceServiceImpl = BeanUtil.getBean(JobTaskInstanceServiceImpl.class);
    }

    void onStart() {
        log.info("Starting Job Task Instance"+jobTaskInstance.getId());
        jobTaskInstance.setStartTime(LocalDateTime.now());
        jobTaskInstance.setStatus("RUNNING");
        jobTaskInstanceServiceImpl.createJobInstance(jobTaskInstance);
    }

    void onEnd() {
        log.info("Completed Job Task Instance"+jobTaskInstance.getId());
        jobTaskInstance.setEndTime(LocalDateTime.now());
        jobTaskInstance.setStatus("SUCCEEDED");
        jobTaskInstance.setLastModifiedDateTime(LocalDateTime.now());
        jobTaskInstanceServiceImpl.updateJobInstance(jobTaskInstance);
    }

    void onError(Exception ex) {
        log.info("Failed Job Task Instance"+jobTaskInstance.getId());
        jobTaskInstance.setEndTime(LocalDateTime.now());
        jobTaskInstance.setStatus("FAILED");
        jobTaskInstance.setLastModifiedDateTime(LocalDateTime.now());

        String errorReason = ex.toString();
        if(!StringUtils.isEmpty(errorReason)) {
            int length = errorReason.length();
            if( length > 3500){
                length = 3500;
                errorReason = errorReason.substring(0,length);
            }
        }
        jobTaskInstance.setFailureReason(errorReason);

        jobTaskInstanceServiceImpl.updateJobInstance(jobTaskInstance);
    }


}
