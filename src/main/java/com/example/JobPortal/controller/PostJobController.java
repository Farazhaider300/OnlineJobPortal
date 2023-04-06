package com.example.JobPortal.controller;

import com.example.JobPortal.model.PostJobModel;
import com.example.JobPortal.service.implementation.JobServiceImp;
import com.example.JobPortal.service.implementation.PostJobImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
public class PostJobController {
@Autowired
    JobServiceImp jobServiceImp;

@PostMapping("/get")
    public  String getData(){
    return  jobServiceImp.check();
}

    /*    @Autowired
    private PostJobImpl postJobimpl;
    @PostMapping(path = "postjob")
    public String postJob(@RequestBody PostJobModel postJobModel){

     return postJobimpl.postNewJob(postJobModel);
    }*/
}
