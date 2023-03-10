package com.example.JobPortal.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "user_role")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userrole_id")
    private long userRoleId;
   @ManyToOne
   @JoinColumn(name = "user_id")
   private User user;
   @ManyToOne
   @JoinColumn(name = "role_id")
    private Role role;
}
