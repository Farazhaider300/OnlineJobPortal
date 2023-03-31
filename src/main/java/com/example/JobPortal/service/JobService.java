package com.example.JobPortal.service;

import com.example.JobPortal.model.ApplyJobModel;
import com.example.JobPortal.model.JobModel;
import com.example.JobPortal.model.PostJobModel;


import java.util.List;

public interface JobService {
    List<JobModel> showAllJobs();
    List<JobModel> showAllJobsByTitle(String searchJob);
    List<JobModel> showAllJobsByAddress(String address);
    String postNewJob(PostJobModel postJobModel);
    String ApplyForJob(ApplyJobModel applyJobModel);

    String removeJob(Long jobId);
}
