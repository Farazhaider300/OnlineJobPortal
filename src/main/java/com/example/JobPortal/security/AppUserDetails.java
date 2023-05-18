package com.example.JobPortal.security;

import com.example.JobPortal.entity.Role;
import com.example.JobPortal.entity.UserRole;
import com.example.JobPortal.model.UserLoginModel;
/*import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;*/

import java.util.stream.Collectors;

public class AppUserDetails /*extends User*/ {
  /*  private UserLoginModel userLoginModel;
    public AppUserDetails(com.example.JobPortal.entity.User user)
    {
        super(user.getEmail(),user.getPassword(),true,
                true,true,true,
              user.getUserRole()
                        .stream()
                        .map((UserRole userRole) ->  new SimpleGrantedAuthority(userRole.getRole().getRoleName()))
                        .collect(Collectors.toList()));

        this.userLoginModel =  new UserLoginModel(user);
    }

    public UserLoginModel getUserModel() {
        return userLoginModel;
    }

    public void setUserModel(UserLoginModel userLoginModel) {
        this.userLoginModel = userLoginModel;
    }*/
}
