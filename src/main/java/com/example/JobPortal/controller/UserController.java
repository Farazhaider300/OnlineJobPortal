package com.example.JobPortal.controller;

import com.example.JobPortal.model.UserModel;
import com.example.JobPortal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController
{
    @Autowired
    public UserService userService;

    @PostMapping("signup")
    public UserModel signin(@RequestBody UserModel userModel)
    {
      return userService.saveuser(userModel);
    }

}
