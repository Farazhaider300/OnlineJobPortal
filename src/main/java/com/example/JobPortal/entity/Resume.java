package com.example.JobPortal.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "resume")
public class Resume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "upload_resume")
    private String uploadResume;
}
