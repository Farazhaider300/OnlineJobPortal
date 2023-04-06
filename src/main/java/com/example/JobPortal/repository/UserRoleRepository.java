package com.example.JobPortal.repository;

import com.example.JobPortal.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    UserRole findUserRoleByUser_IdAndRole_Id(Long userId,Long roleId);
    UserRole findUserRoleByUser_email(String email);
}
