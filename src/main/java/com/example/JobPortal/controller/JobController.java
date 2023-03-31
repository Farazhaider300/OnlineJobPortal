package com.example.JobPortal.controller;

import com.example.JobPortal.model.ApplyJobModel;
import com.example.JobPortal.model.JobModel;
import com.example.JobPortal.model.PostJobModel;
import com.example.JobPortal.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "home")
public class JobController
{
    @Autowired
    private JobService JobService;


    @GetMapping(path = "findjob")
    public List<JobModel> ShowAllJobs()
    {
        return JobService.showAllJobs();
    }
    @GetMapping(path = "findjob/{JobTitle}")
    public List<JobModel> findJobByTitle(@PathVariable("JobTitle") String searchJob)
    {
            return JobService.showAllJobsByTitle( "%"+searchJob+ "%");
    }
    @GetMapping(path = "findjob/{Address}")
    public List<JobModel> findByAddressContaining(@PathVariable("JobTitle") String address)
    {
        return JobService.showAllJobsByAddress(address);
    }
    @PostMapping(path = "postjob")
    public String postJob(@RequestBody PostJobModel postJobModel)
    {

        return JobService.postNewJob(postJobModel);
    }
    @PostMapping(path = "applyjob")
    public String applyForJob(@RequestBody ApplyJobModel applyJobModel)
    {
        return JobService.ApplyForJob(applyJobModel);
    }
    @DeleteMapping(path = "job/{jobId}")
    public String DeleteJobd(@PathVariable("jobId") Long jobId){
        return JobService.removeJob(jobId);
    }

}
