package com.example.JobPortal.controller;

import com.example.JobPortal.model.PostJobModel;
import com.example.JobPortal.service.implementation.PostJobImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostJobController {
/*    @Autowired
    private PostJobImpl postJobimpl;
    @PostMapping(path = "postjob")
    public String postJob(@RequestBody PostJobModel postJobModel){

     return postJobimpl.postNewJob(postJobModel);
    }*/
}
