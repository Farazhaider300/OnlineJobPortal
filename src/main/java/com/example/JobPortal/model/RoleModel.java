package com.example.JobPortal.model;

import com.example.JobPortal.entity.Role;
import com.example.JobPortal.entity.User;
import lombok.Data;

@Data
public class RoleModel {
    private long roleId;
    private String role;
    public RoleModel(Role role)
    {
        this.roleId = role.getId();
        this.role = role.getRoleName();
    }

}
