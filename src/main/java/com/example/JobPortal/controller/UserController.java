package com.example.JobPortal.controller;

import com.example.JobPortal.entity.User;
import com.example.JobPortal.repository.UserRepository;
import com.example.JobPortal.service.UserService;
import com.example.JobPortal.service.UserServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    public UserServiceimpl userServiceimpl;
    @PostMapping("/sign-Up")
public User signup(@RequestBody User user) {

 return this.userServiceimpl.signup(user);
/*return this.userService.signup(user.getFirstName(),user.getLastName(),user.getEmail(),user.getPassword());*/
}
}
