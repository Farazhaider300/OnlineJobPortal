package com.example.JobPortal.repository;

import com.example.JobPortal.entity.Job;
import com.example.JobPortal.entity.PostJob;
import com.example.JobPortal.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostJobRepository extends JpaRepository<PostJob, Long> {
 public PostJob findJobByUser_id(long id);

}
