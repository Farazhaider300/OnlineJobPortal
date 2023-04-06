package com.example.JobPortal.repository;

import com.example.JobPortal.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public User findUserByEmail(String incomingEmail);

    public User findByEmailAndPassword (String incomingEmail, String incomingPassword);

}
