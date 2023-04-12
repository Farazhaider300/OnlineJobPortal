package com.example.JobPortal.controller;

import com.example.JobPortal.entity.Job;
import com.example.JobPortal.entity.PostJob;
import com.example.JobPortal.model.*;
import com.example.JobPortal.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(path = "home")
public class JobController {
    @Autowired
    private JobService JobService;


    @GetMapping(path = "findjob")
    public List<JobModel> showAllJobs() {
        return JobService.showAllJobs();
    }

    @GetMapping(path = "findjob/{JobTitle}")
    public List<JobModel> findJobByTitle(@PathVariable("JobTitle") String searchJob) {
        return JobService.showAllJobsByTitle("%" + searchJob + "%");
    }

    @GetMapping(path = "findjob/location/{Address}")
    public List<JobModel> findByAddressContaining(@PathVariable("Address") String address) {
        return JobService.showAllJobsByAddress("%" + address + "%");
    }

    @PostMapping(path = "postjob")
    public String postJob(@RequestBody PostJobModel postJobModel) {

        return JobService.postNewJob(postJobModel);
    }

    @PostMapping(path = "applyjob")
    public String applyForJob(@RequestBody ApplyJobModel applyJobModel) {
        return JobService.applyForJob(applyJobModel);
    }
    @DeleteMapping(path = "job/{jobId}")
    public String deleteJobId(@PathVariable("jobId") Long jobId){
        return JobService.removeJob(jobId);
    }
    @GetMapping(path = "view/postjob")
    public List<ViewUserJobmodel> viewUserPostJob(@RequestBody ViewUserJobmodel viewUserJobmodel){

        return JobService.showUserJob(viewUserJobmodel);
    }
    @GetMapping(path = "view/appliedJob")
    public List<ViewApplyJobModel> showApplyJob(@RequestBody ViewApplyJobModel viewApplyJobModel){
        return JobService.showAppliedJob(viewApplyJobModel);
    }
}