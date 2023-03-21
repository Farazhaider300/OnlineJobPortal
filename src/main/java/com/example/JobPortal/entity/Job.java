package com.example.JobPortal.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "job_detail")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "date")
    private Date date;
    @Column(name = "salary")
    private long salary;
    @Column(name = "address")
    private String address;

    //Creating relation between job and apply jobs
    @ManyToOne
    private ApplyJob applyJob;

    //Creating relation between job and post job
    @ManyToOne
    private PostJob postJob;

}
