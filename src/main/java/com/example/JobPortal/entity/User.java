package com.example.JobPortal.entity;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;



@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "status")
    private boolean status;
    @OneToMany(mappedBy = "user")
    private List<UserRole> userRole;
}
