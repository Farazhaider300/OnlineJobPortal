package com.example.JobPortal.model;

import com.example.JobPortal.entity.Job;
import lombok.Data;

import java.util.Date;

@Data
public class JobModel {

    private String title;
    private String description;
    private Date date;
    private long salary;
    private String address;

    // convert UI/model object to entity object
    public JobModel assemble(Job job){
        JobModel jobModel=new JobModel();
        jobModel.setTitle(job.getTitle());
        jobModel.setDescription(job.getDescription());
        jobModel.setAddress(job.getAddress());
        jobModel.setSalary(job.getSalary());
        return jobModel;
    }

    // convert Entity object to UI/model  object
    public Job dissemble(){
        Job job=new Job();
        job.setTitle(this.title);
        job.setDescription(this.description);
        return job;
    }


}
