package com.example.JobPortal.model;

import com.example.JobPortal.entity.Job;
import lombok.Data;

import java.util.Date;
@Data
public class ViewApplyJobModel {
    private String title;
    private String description;
    private Date date;
    private long salary;
    private String address;
    private String email;
    private String company;
    public ViewApplyJobModel assemble(Job job){
        ViewApplyJobModel viewApplyJobModel=new ViewApplyJobModel();
        viewApplyJobModel.setTitle(job.getTitle());
        viewApplyJobModel.setDescription(job.getDescription());
        viewApplyJobModel.setAddress(job.getAddress());
        viewApplyJobModel.setSalary(job.getSalary());
        viewApplyJobModel.setDate(job.getDate());
        viewApplyJobModel.setCompany(job.getCompany());
        return viewApplyJobModel;
    }
}
