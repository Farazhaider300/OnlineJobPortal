package com.example.JobPortal.service.implementation;
import com.example.JobPortal.entity.*;
import com.example.JobPortal.model.*;
import com.example.JobPortal.repository.*;
import com.example.JobPortal.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImp implements JobService {
    @Autowired
    JobRepository jobRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
   UserRoleRepository userRoleRepository;
    @Autowired
   ApplyJobRepository applyJobRepository;
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
        List<ApplyJob> checkApplyAlready= applyJobRepository.findAllJobByUser_Id(incomingJobId);
        if (checkApplyAlready!=null ){
            checkApplyAlready.stream().filter(e-> e.getJob().getId().equals(incomingJobId));
           /* List<ApplyJobModel>applyJobModels=new ArrayList<>();
            for (ApplyJob applyJob:checkApplyAlready) {
                applyJobModels.add(new ApplyJobModel().getJobId());
            }*/
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
    public List<ViewUserJobmodel> showUserJob(ViewUserJobmodel viewUserJobmodel){
        UserRole userRole= userRoleRepository.findUserRoleByUser_email(viewUserJobmodel.getEmail());
        List<ViewUserJobmodel> listOfUserPostJobs= new ArrayList<>();
        List<PostJob> listOfPostJob=  postJobRepository.findAllPostJobByUser_email(viewUserJobmodel.getEmail());
        if (listOfPostJob!=null && userRole.getUser()!=null && userRole.getRole().getRoleName().equals("Job_Poster")) {
            for (PostJob postJob : listOfPostJob) {
                listOfUserPostJobs.add(new ViewUserJobmodel().assemble(postJob));

            }
        } else  {
            return listOfUserPostJobs;
        }
        return listOfUserPostJobs;
    }
@Override
    public List<ViewApplyJobModel> showAppliedJob(ViewApplyJobModel viewApplyJobModel){
        UserRole userRole= userRoleRepository.findUserRoleByUser_email(viewApplyJobModel.getEmail());
        List<ViewApplyJobModel> listViewApplyJobModel= new ArrayList<>();
        List<ApplyJob> listOfApplyJob=  applyJobRepository.findAllApplyJobByUser_Email(viewApplyJobModel.getEmail());
        if (listOfApplyJob!=null && userRole.getUser()!=null && userRole.getRole().getRoleName().equals("Job_Seeker") ){
            for (ApplyJob applyJob : listOfApplyJob) {
                listViewApplyJobModel.add(new ViewApplyJobModel().assemble(applyJob.getJob()));

            }
        }
        return listViewApplyJobModel;
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