package com.example.JobPortal.service.implementation;
import com.example.JobPortal.entity.*;
import com.example.JobPortal.model.ApplyJobModel;
import com.example.JobPortal.model.JobModel;
import com.example.JobPortal.model.PostJobModel;
import com.example.JobPortal.repository.*;
import com.example.JobPortal.service.JobService;
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
        List<Job> listJobs = jobRepository.findByTitleLike(searchJob);
        for (Job job : listJobs ) {
            jobModel.add(new JobModel().assemble(job));
        }
        return jobModel;
    }
    @Override
    public List<JobModel> showAllJobsByAddress(String address)
    {

        List<JobModel> jobModel = new ArrayList<>();
        List<Job> listJobs = jobRepository.findByAddressLike(address);
        for (Job job : listJobs ) {
            jobModel.add(new JobModel().assemble(job));
        }
        return jobModel;
    }
    @Override
    public String postNewJob(PostJobModel postJobModel){


        String incomingEmail= postJobModel.getEmail();
        //native Query
        /*Role role= roleRepository.getRoleByEmail(incomingEmail);*/
        UserRole userRole=userRoleRepository.findUserRoleByUser_email(incomingEmail);

        if (userRole!=null && userRole.getRole().getRoleName().equals("Job_Poster"))
        {
            Job job = jobRepository.save(postJobModel.dissemble());
            PostJob postJob=new PostJob();
            postJob.setUser(userRole.getUser());
            postJob.setJob(job);
            postJobRepository.save(postJob);


            return "Job Post successfully";
        }
        else
        {
            return "User Permission not allowed";
        }
    }
    @Override
    public String applyForJob(ApplyJobModel applyJobModel)
    {
    String incomingEmail=applyJobModel.getEmail();
    Long incomingJobId=applyJobModel.getJobId();
    UserRole userRole=userRoleRepository.findUserRoleByUser_email(incomingEmail);
    Job job=jobRepository.findJobById(incomingJobId);
    ApplyJob checkApplyAlready= applyJobRepository.findAllJobByUser_Id(userRole.getUser().getId());
    if (checkApplyAlready!=null && checkApplyAlready.getJob().getId()==incomingJobId){
        return "Already Applied";
    }
    else if ( job!=null && userRole!=null && userRole.getRole().getRoleName().equals("Job_Seeker") )
    {
        ApplyJob applyJob=new ApplyJob();
        applyJob.setUser(userRole.getUser());
        applyJob.setJob(job);
        applyJobRepository.save(applyJob);
        return "Apply Successfully";
    }else
    {
        return "Something went Wrong";
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
    @Override
    public List<JobModel> viewUserPostJob(String incomingEmail){

       /* List<JobModel> listOfJob = new ArrayList<>();*/
        User user=userRepository.findUserByEmail(incomingEmail);
       PostJob listOfPostJob=  postJobRepository.findJobByUser_id(user.getId());

        if (listOfPostJob!=null){
           /* for (Job job: listOfPostJob  ) {
                listOfJob.add(new JobModel().assemble((Job) listOfPostJob));
            }*/
            return null;
        }
        return null;
    }


    public String check(){
        //UserRole userRole=userRoleRepository.findUserRoleByUser_IdAndRole_Id(3L,2L);
        UserRole userRole=userRoleRepository.findUserRoleByUser_email("farazhaider300@gmail.com");
        if(userRole!=null)
        {
            return userRole.getRole().getId()+" "+ userRole.getRole().getRoleName();
        }else {
            return "No Data Found";
        }

    }

}
