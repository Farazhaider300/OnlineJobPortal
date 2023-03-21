package com.example.JobPortal.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "applyjob")
public class ApplyJob {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "date")
    private Date date;
  //Creating relation between UserRole and apply jobs
    @ManyToOne
    @JoinColumn(name = "user_role_id")
    private UserRole userRole;

    //Creating relation between apply job and job
    @OneToMany(mappedBy = "applyJob")
    private List<Job> job;
}
