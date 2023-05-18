package com.example.JobPortal.entity;
import lombok.Data;
import jakarta.persistence.*;
import java.util.List;


@Entity
@Data
@Table(name = "user_role")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    //Creating relation between userRole and User

   @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
   @JoinColumn(name = "user_id")
   private User user;

   //Creating relation between userRole and role

   @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
   @JoinColumn(name = "role_id")
    private Role role;
/*
   //Creating job_seeker relation
   @OneToMany(mappedBy = "userRole")
    private List<ApplyJob> applyJob;

   //Creating relation between userRole and post job
    @OneToMany(mappedBy = "userRole")
    private List<PostJob>postJobs;*/
}
