package com.batch.controller;


import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class JobBatchController {

    private static final Logger log = Logger.getLogger(JobBatchController.class.getName());

    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    Job job;

    @GetMapping("/copyFilesCsvToDb")
    public String jobLauncher()
    {
        final JobParameters jobParameters=new JobParametersBuilder()
                .addLong("startAt",System.currentTimeMillis()).toJobParameters();

        try {
            final JobExecution jobExecution=jobLauncher.run(job,jobParameters);
            return jobExecution.getStatus().toString();
        }
        catch (Exception e)
        {
            log.info("");
            return "Job Failed";
        }

    }


}
