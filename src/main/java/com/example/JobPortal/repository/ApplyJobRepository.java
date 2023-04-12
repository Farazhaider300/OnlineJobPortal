package com.example.JobPortal.repository;

import com.example.JobPortal.entity.ApplyJob;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplyJobRepository extends JpaRepository<ApplyJob,Long> {
    public List<ApplyJob> findAllJobByUser_Id(long userId);
    public List<ApplyJob> findAllApplyJobByUser_Email(String email);
}
