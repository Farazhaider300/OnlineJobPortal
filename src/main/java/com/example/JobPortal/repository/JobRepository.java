package com.example.JobPortal.repository;

import com.example.JobPortal.entity.Job;
import com.example.JobPortal.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobRepository extends JpaRepository<Job, Long> {
/*
    public List<User> finduserbyrole(String role);
*/

}
