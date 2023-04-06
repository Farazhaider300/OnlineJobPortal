package com.example.JobPortal.repository;

import com.example.JobPortal.entity.ApplyJob;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplyJobRepository extends JpaRepository<ApplyJob,Long> {
    public ApplyJob findAllJobByUser_Id(long userId);
}
