package com.example.JobPortal.model;

import com.example.JobPortal.entity.User;
import com.example.JobPortal.entity.UserRole;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class UserLoginModel {
    private Long userId;
    private String email;
    private String password;
  /*  private List<RoleModel> roles = new ArrayList<>();
    public UserLoginModel(User user) {
            this.userId = user.getId();
        this.email = user.getEmail();
        this.roles = user.getUserRole().stream().map((UserRole role) -> new RoleModel(role.getRole())).collect(Collectors.toList());;
    }*/
}
