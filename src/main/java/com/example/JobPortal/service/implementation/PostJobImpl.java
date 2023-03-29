package com.example.JobPortal.service.implementation;

import com.example.JobPortal.entity.*;
import com.example.JobPortal.model.PostJobModel;
import com.example.JobPortal.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service

public class PostJobImpl {
    @Autowired
    private PostJobRepository postJobRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;

    public String postNewJob(PostJobModel postJobModel){
        String incomingEmail= postJobModel.getEmail();
        /*String incomingPassword=postJobModel.getPassword()*/;
        /*User confirmDetail=userRepository.getRoleByEmail();*/
        User user= userRepository.findUserByEmail(incomingEmail);
        Role role= roleRepository.getRoleByEmail(incomingEmail);
        if (role!=null && role.getRoleName().equals("Job_Poster"))
        {
            return "Job Post successfully";
        }
       else
       {
            return "User Permission not allowed";
        }
    }
}
