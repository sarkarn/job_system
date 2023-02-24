package com.nns.job.system.exec;

import com.nns.job.system.core.JobExecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestJobExecutor
{

    private JobExecutor buildJobExecutor() {
        JobExecutor jobExecutor = new JobExecutor( new TestJobInstancePreExecuteCallback(), "test job");
        for(int i=0;i<10;i++){
            TestTask testTask = new TestTask();
            jobExecutor.add(testTask);
        }
        return jobExecutor;
    }

    public void submitJob() {
        JobExecutor jobExecutor = buildJobExecutor();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        jobExecutor.executeJob(executorService);
    }

}
