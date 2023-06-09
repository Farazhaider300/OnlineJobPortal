package com.example.JobPortal.controller;

import com.example.JobPortal.entity.User;
import com.example.JobPortal.model.UserLoginModel;
import com.example.JobPortal.model.UserModel;
import com.example.JobPortal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController
{
    @Autowired
    public UserService userService;

    @PostMapping(path = "signup")
    public String signup(@RequestBody UserModel userModel)
    {
      return userService.saveuser(userModel);
    }
    @GetMapping(path = "login")
    public String login(@RequestBody UserLoginModel userLoginModel)
    {

        return userService.isUserExist(userLoginModel);
    }
}
