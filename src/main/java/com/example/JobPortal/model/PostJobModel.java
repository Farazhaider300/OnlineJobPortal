package com.example.JobPortal.model;

import com.example.JobPortal.entity.Job;
import com.example.JobPortal.entity.User;
import com.example.JobPortal.entity.UserRole;
import lombok.Data;

import java.util.Date;

@Data
public class PostJobModel {

    private String title;
    private String description;
    private Date date;
    private long salary;
    private String address;
    private String email;
    private String password;

    // convert UI/model object to entity object
    public PostJobModel assemble(Job job){
        PostJobModel postJobModel =new PostJobModel();
        postJobModel.setTitle(job.getTitle());
        postJobModel.setDescription(job.getDescription());
        postJobModel.setAddress(job.getAddress());
        postJobModel.setSalary(job.getSalary());
        return postJobModel;
    }

    // convert Entity object to UI/model  object
    public Job dissemble(){
        Job job=new Job();
        job.setTitle(this.title);
        job.setDescription(this.description);
        job.setAddress(this.address);
        job.setSalary(this.salary);
        job.setPostJob(this.dissemble().getPostJob());
        return job;
    }


}
