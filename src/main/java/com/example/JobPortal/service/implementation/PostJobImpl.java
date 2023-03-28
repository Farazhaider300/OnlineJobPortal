package com.example.JobPortal.service.implementation;

import com.example.JobPortal.entity.Role;
import com.example.JobPortal.entity.User;
import com.example.JobPortal.model.PostJobModel;
import com.example.JobPortal.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class PostJobImpl {
    @Autowired
    private PostJobRepository postJobRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private RoleRepository roleRepository;

    public String postNewJob(PostJobModel postJobModel){
        String incomingEmail= postJobModel.getEmail();
        String incomingPassword=postJobModel.getPassword();
        User confirmDetail= userRepository.findByEmailAndPassword(incomingEmail,incomingPassword);
        if (confirmDetail!=null)
        {

            jobRepository.save(postJobModel.dissemble());
/*            PostJob postJob=new PostJob();
            postJob.setId(userRole.getId());*/
                return "Job Post successfully";
        }else {
            return "User Permission not allowed";

        }
    }
}
