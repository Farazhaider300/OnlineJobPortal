package com.example.JobPortal.controller;

import com.example.JobPortal.entity.User;
import com.example.JobPortal.model.JobModel;
import com.example.JobPortal.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/job")
public class JobController
{
    @Autowired
    private JobService jobService;
    @PostMapping(path = "/postjob")
    public JobModel postJob(@RequestBody JobModel jobModel, User user)
    {
        JobModel response= jobService.savejob(jobModel);
        return response;
    }
}
