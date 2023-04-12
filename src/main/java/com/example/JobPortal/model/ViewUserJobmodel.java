package com.example.JobPortal.model;

import com.example.JobPortal.entity.Job;
import com.example.JobPortal.entity.PostJob;
import lombok.Data;

import java.util.Date;
@Data
public class ViewUserJobmodel {

    private String title;
    private String description;
    private Date date;
    private long salary;
    private String address;
    private String email;
    private String company;
    public ViewUserJobmodel assemble(PostJob postJob){
        ViewUserJobmodel viewUserJobmodel=new ViewUserJobmodel();
        viewUserJobmodel.setTitle(postJob.getJob().getTitle());
        viewUserJobmodel.setDescription(postJob.getJob().getDescription());
        viewUserJobmodel.setAddress(postJob.getJob().getAddress());
        viewUserJobmodel.setSalary(postJob.getJob().getSalary());
        viewUserJobmodel.setDate(postJob.getJob().getDate());
        viewUserJobmodel.setCompany(postJob.getJob().getCompany());
        return viewUserJobmodel;
    }



}
