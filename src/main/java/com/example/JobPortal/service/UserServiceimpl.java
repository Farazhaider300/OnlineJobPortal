package com.example.JobPortal.service;

import com.example.JobPortal.entity.User;
import com.example.JobPortal.entity.UserRole;
import com.example.JobPortal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceimpl implements UserService {

@Autowired
public UserRepository userRepository;
    @Override
    public User signup(User adduser) {
        userRepository.save(adduser);
        return adduser;
    }

/*    @Override
    public User signup(String firstName, String lastName, String email, String password) {

        return userRepository.save(signup(firstName,lastName,email,password));
    }*/
}
