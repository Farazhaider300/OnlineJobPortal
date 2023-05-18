package com.example.JobPortal.entity;
import lombok.Data;
import jakarta.persistence.*;

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
