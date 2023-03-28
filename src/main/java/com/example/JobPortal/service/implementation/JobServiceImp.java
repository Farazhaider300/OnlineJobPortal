package com.example.JobPortal.service.implementation;
import com.example.JobPortal.entity.Job;
import com.example.JobPortal.model.JobModel;
import com.example.JobPortal.repository.JobRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImp   {
    @Autowired
    public JobRepository jobRepository;
@Transactional
public List<JobModel> showAllJobs()
{
    List<JobModel> jobModels = new ArrayList<>();
    for (Job job : (List<Job>) jobRepository.findAll()) {
        jobModels.add(new JobModel().assemble(job));
    }


    return jobModels;
}

}
