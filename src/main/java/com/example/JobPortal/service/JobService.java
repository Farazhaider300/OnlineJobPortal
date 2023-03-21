package com.example.JobPortal.service;
import com.example.JobPortal.entity.Job;
import com.example.JobPortal.entity.Role;
import com.example.JobPortal.entity.User;
import com.example.JobPortal.entity.UserRole;
import com.example.JobPortal.model.JobModel;
import com.example.JobPortal.repository.JobRepository;
import com.example.JobPortal.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Objects;

@Service
public class JobService {
@Autowired
public JobRepository jobRepository;
@Transactional
public JobModel savejob(JobModel jobModel)
{
    return jobModel.assemble(jobRepository.save(jobModel.dissemble()));
}

}
