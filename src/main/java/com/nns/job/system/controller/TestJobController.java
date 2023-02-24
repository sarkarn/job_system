package com.nns.job.system.controller;


import com.nns.job.system.exec.TestJobExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestJobController {


    @GetMapping(value = "/job")
    public void executeJob() {
        TestJobExecutor testJobExecutor = new TestJobExecutor();
        testJobExecutor.submitJob();
    }
}
