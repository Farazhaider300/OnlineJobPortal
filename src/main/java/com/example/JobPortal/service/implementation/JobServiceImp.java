package com.example.JobPortal.service.implementation;
import com.example.JobPortal.entity.Job;
import com.example.JobPortal.entity.Role;
import com.example.JobPortal.entity.UserRole;
import com.example.JobPortal.model.ApplyJobModel;
import com.example.JobPortal.model.JobModel;
import com.example.JobPortal.model.PostJobModel;
import com.example.JobPortal.repository.*;
import com.example.JobPortal.service.JobService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImp implements JobService {
    @Autowired
    public JobRepository jobRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Autowired
    private ApplyJobRepository applyJobRepository;
    @Autowired
    private PostJobRepository postJobRepository;

    @Override
    public List<JobModel> showAllJobs()
    {
    List<JobModel> jobModels = new ArrayList<>();
    for (Job job : jobRepository.findAll()) {
        jobModels.add(new JobModel().assemble(job));
    }
   return jobModels;
    }

    @Override
    public List<JobModel> showAllJobsByTitle(String searchJob)
    {

        List<JobModel> jobModel = new ArrayList<>();
        List<Job> listJobs = jobRepository.findByTitleLike( searchJob);
        for (Job job : listJobs ) {
            jobModel.add(new JobModel().assemble(job));
        }
        return jobModel;
    }

    @Override
    public List<JobModel> showAllJobsByAddress(String address)
    {

        List<JobModel> jobModel = new ArrayList<>();
        List<Job> listJobs = jobRepository.findByTitleLike( address);
        for (Job job : listJobs ) {
            jobModel.add(new JobModel().assemble(job));
        }
        return jobModel;
    }

    @Override
    public String postNewJob(PostJobModel postJobModel){
        String incomingEmail= postJobModel.getEmail();
        /*User user= userRepository.findUserByEmail(incomingEmail);*/
        Role role= roleRepository.getRoleByEmail(incomingEmail);
        if (role!=null && role.getRoleName().equals("Job_Poster"))
        {
           /* UserRole userRole=new UserRole();
            userRole.getUser().getEmail().equals(incomingEmail);*/
            return "Job Post successfully";
        }
        else
        {
            return "User Permission not allowed";
        }
    }
    @Override
    public String ApplyForJob(ApplyJobModel applyJobModel){
    String IncomingEmail=applyJobModel.getEmail();
    Long IncomingJobId=applyJobModel.getId();
    Role role= roleRepository.getRoleByEmail(IncomingEmail);
    Job job=jobRepository.findJobById(IncomingJobId);
    if ( job!=null && role!=null && role.getRoleName().equals("Job_seeker") ){
     /*   ApplyJob applyJob=applyJobRepository.save(job.getApplyJob());*/
        return "Apply Successfully";
    }else
    {
        return "Error";
    }
    }
    @Override
    public String removeJob(Long jobId){

        Job job= jobRepository.findJobById(jobId);
        if (job!=null){
            jobRepository.deleteById(jobId);
            return job.getTitle()+" "+ "Deleted Successfully" ;
        }else {
            return "Enable to Delete";
        }
    }

}
