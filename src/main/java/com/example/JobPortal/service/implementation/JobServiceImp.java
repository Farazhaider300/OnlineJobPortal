package com.example.JobPortal.service.implementation;
import com.example.JobPortal.model.JobModel;
import com.example.JobPortal.repository.JobRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobServiceImp   {
@Autowired
public JobRepository jobRepository;
@Transactional
public JobModel savejob(JobModel jobModel)
{
    return jobModel.assemble(jobRepository.save(jobModel.dissemble()));
}

}
