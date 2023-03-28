package com.example.JobPortal.entity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "post_job")
public class PostJob {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    //Creating relation between userRole and job
    @ManyToOne
    private UserRole userRole;

    //Creating relation between post job and job
    @OneToMany(mappedBy = "postJob")
    private List<Job> Job;


}
