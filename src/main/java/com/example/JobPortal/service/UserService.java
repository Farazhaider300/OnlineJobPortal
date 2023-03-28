package com.example.JobPortal.service;

import com.example.JobPortal.entity.User;
import com.example.JobPortal.model.UserLoginModel;
import com.example.JobPortal.model.UserModel;

public interface UserService {

    String saveuser(UserModel userModel);

    String isUserExist(UserLoginModel userLoginModel);
}
