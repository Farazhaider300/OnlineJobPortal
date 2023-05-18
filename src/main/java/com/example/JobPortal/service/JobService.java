package com.example.JobPortal.service;

import com.example.JobPortal.model.*;
import org.springframework.stereotype.Component;


import java.util.List;

public interface JobService {
    List<JobModel> showAllJobs();
    List<JobModel> showAllJobsByTitle(String searchJob);
    List<JobModel> showAllJobsByAddress(String address);
    String postNewJob(PostJobModel postJobModel);
    String applyForJob(ApplyJobModel applyJobModel);

    String removeJob(Long jobId);

    List<ViewUserJobmodel> showUserJob(ViewUserJobmodel viewUserJobmodel);

    List<ViewApplyJobModel> showAppliedJob(ViewApplyJobModel viewApplyJobModel);
}