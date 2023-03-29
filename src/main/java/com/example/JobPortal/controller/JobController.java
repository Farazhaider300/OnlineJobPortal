package com.example.JobPortal.controller;

import com.example.JobPortal.entity.Job;
import com.example.JobPortal.model.JobModel;
import com.example.JobPortal.model.PostJobModel;
import com.example.JobPortal.service.implementation.JobServiceImp;
import com.example.JobPortal.service.implementation.PostJobImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "home")
public class JobController
{
    @Autowired
    private JobServiceImp JobServiceImp;
    @Autowired
    private PostJobImpl postJobimpl;
    @GetMapping(path = "findjob")
    public List<JobModel> ShowAllJobs(){
        return JobServiceImp.showAllJobs();
    }
    @GetMapping(path = "findjob/{JobTitle}")
    public List<JobModel> findJobByTitle(@PathVariable("JobTitle") String SearchJob){
        return JobServiceImp.showAllJobsByTitle( "%"+SearchJob+ "%");
    }
    @PostMapping(path = "postjob")
    public String postJob(@RequestBody PostJobModel postJobModel)
    {

        return postJobimpl.postNewJob(postJobModel);
    }

}
