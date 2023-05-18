package com.example.JobPortal.model;

import com.example.JobPortal.entity.Role;
import com.example.JobPortal.entity.User;
import com.example.JobPortal.entity.UserRole;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class UserModel {
   /* @Autowired
    private  BCryptPasswordEncoder passwordEncoder;*/
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private boolean status;
    private long roleid;
/*    private List<RoleModel> roles = new ArrayList<>();
    public UserModel() {
        User user=new User();
        this.id = user.getId();
        this.email = user.getEmail();
        this.roles = user.getUserRole().stream().map((UserRole t) -> new RoleModel(t.getRole())).collect(Collectors.toList());
    }*/

    // Convert model to entity
    public User dissemble() {
        User user = new User();
        user.setId(this.id);
        user.setEmail(this.email);
        user.setFirstName(this.firstName);
        user.setLastName(this.lastName);
       /* System.out.println(this.password);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();*/
        user.setPassword(/*passwordEncoder.encode(this.password)*/ this.password);
        return user;

    }

// Convert entity to model
    public UserModel assemble(User user) {
        UserModel userModel = new UserModel();
        userModel.setEmail(user.getEmail());
        userModel.setFirstName(user.getFirstName());
        userModel.setLastName(user.getLastName());
        userModel.setPassword(user.getPassword());
        return userModel;
    }


}
//We can also use same thing using constructor
 /*   public  UserModel() {
        user = new User();
        user.setEmail(this.email);
        user.setFirstName(this.firstName);
        user.setLastName(this.lastName);
        user.setPassword(this.password);

    }*/
/*    public UserModel(User user)
    {
        this.email=user.getEmail();
        this.firstName=user.getFirstName();
        this.lastName=user.getLastName();
        this.password=user.getPassword();
    }*/

