package com.example.JobPortal.service;
import com.example.JobPortal.entity.Role;
import com.example.JobPortal.entity.User;
import com.example.JobPortal.entity.UserRole;
import com.example.JobPortal.model.UserModel;
import com.example.JobPortal.repository.RoleRepository;
import com.example.JobPortal.repository.UserRepository;
import com.example.JobPortal.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceimpl implements  UserService {

    @Autowired
    public UserRepository userRepository;
    @Autowired
    public RoleRepository roleRepository;

    @Autowired
    public UserRoleRepository userRoleRepository;



    public UserModel saveuser(UserModel userModel) {

        Role role=new Role();
        role.setRoleName(userModel.getRole());
        roleRepository.save(role);
        User user=new User();
        user = userModel.dissemble();
        userRepository.save(user);
        UserRole userRole =new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);
        userRoleRepository.save(userRole);
        return userModel;
 /*       Role role = new Role();
        role.setRoleName(userModel.getRole());
        roleRepository.save(role);
        User user=new User();
        userModel.setUser(user);
        userRepository.save(user);
        UserRole userRole = new UserRole();
        userRole.setRole(role);
        userRole.setUser(user);
        userRoleRepository.save(userRole);
        return userModel;*/
    }
}


