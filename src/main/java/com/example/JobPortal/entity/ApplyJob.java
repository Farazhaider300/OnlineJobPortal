package com.example.JobPortal.entity;
import lombok.Data;
import jakarta.persistence.*;
import java.util.Date;

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
    @JoinColumn(name = "user_id")
    private User user;

    //Creating relation between apply job and job
    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;
}
