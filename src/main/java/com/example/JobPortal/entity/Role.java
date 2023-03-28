package com.example.JobPortal.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Data
@Table(name = "role")
public class Role {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "role_name")
    private String roleName;
    @OneToMany(mappedBy = "role")
    private List<UserRole> userRoles;

}
