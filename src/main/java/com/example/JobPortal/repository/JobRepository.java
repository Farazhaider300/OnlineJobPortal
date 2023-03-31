package com.example.JobPortal.repository;

import com.example.JobPortal.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JobRepository extends JpaRepository<Job,Long> {
    public List<Job> findByTitleContaining(String SearchJob);
    public List<Job> findByTitleLike(String SearchJob);
    public Job findJobById(Long IncomingJobId);

}
