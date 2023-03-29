package com.example.JobPortal.repository;

import com.example.JobPortal.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface JobRepository extends JpaRepository<Job,Long> {
    public  Job findByTitleContaining(String SearchJob);
}
