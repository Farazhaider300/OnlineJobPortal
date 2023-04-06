package com.example.JobPortal.service.implementation;
import com.example.JobPortal.entity.Role;
import com.example.JobPortal.entity.User;
import com.example.JobPortal.entity.UserRole;
import com.example.JobPortal.model.UserLoginModel;
import com.example.JobPortal.model.UserModel;
import com.example.JobPortal.repository.JobRepository;
import com.example.JobPortal.repository.RoleRepository;
import com.example.JobPortal.repository.UserRepository;
import com.example.JobPortal.repository.UserRoleRepository;
import com.example.JobPortal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceimpl implements UserService {

    @Autowired
    public UserRepository userRepository;
    @Autowired
    public RoleRepository roleRepository;

    @Autowired
    public UserRoleRepository userRoleRepository;
    @Autowired
    public JobRepository jobRepository;
    @Override
    public String saveuser(UserModel userModel) {

        String incomingEmail = userModel.getEmail();
        User userExist = userRepository.findUserByEmail(incomingEmail);
        if (userExist != null) {
            return "User already exist with same email id!";
        } else {

            Role role = new Role();
            role.setId(userModel.getRoleid());
            User user=userRepository.save(userModel.dissemble());
            UserRole userRole = new UserRole();
            userRole.setRole(role);
            userRole.setUser(user);
            userRoleRepository.save(userRole);
            return "User saved successfully!";
        }
    }
    @Override
    public String isUserExist(UserLoginModel userLoginModel){
        String incomingEmail= userLoginModel.getEmail();
        String incomingPassword=userLoginModel.getPassword();
        User confirmDetail= userRepository.findByEmailAndPassword(incomingEmail,incomingPassword);
        if (confirmDetail!=null)
        {
            return "Login successfully" ;

        }else {
            return "No User Found...";

        }
    }
}


