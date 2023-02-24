package com.nns.job.system.exec;

import com.nns.job.system.core.JobInstancePreExecuteCallback;

public class TestJobInstancePreExecuteCallback implements JobInstancePreExecuteCallback {
    @Override
    public void beforeStart() {
        System.out.println("Performing Pre-Job Exection work");
    }
}
