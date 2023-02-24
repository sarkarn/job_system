package com.nns.job.system.exec;

import com.nns.job.system.core.JobTaskResult;
import com.nns.job.system.core.Task;


public class TestTask extends Task {

    public TestTask() {
        super( new TestJobTaskInstancePostExecuteCallback());
    }

    @Override
    public JobTaskResult execute() {
        System.out.println("Performing assigned Task");
        return new JobTaskResult();
    }
}
