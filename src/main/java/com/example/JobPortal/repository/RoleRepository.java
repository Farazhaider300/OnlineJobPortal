package com.example.JobPortal.repository;

import com.example.JobPortal.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

//    public Role findRoleByEmail(String incomingEmail);

    @Query(value = "select r.* from jobportal.user_role ur inner join jobportal.user u on ur.user_id = u.id inner join\n" +
            "jobportal.role r on ur.role_id = r.id where u.email=?1  ", nativeQuery = true)
    public Role getRoleByEmail(String email);

}
