package com.example.JobPortal.model;

import com.example.JobPortal.entity.User;
import lombok.Data;

@Data
public class UserModel {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private boolean status;
    private String role;
    public User dissemble() {
        User user = new User();
        user.setEmail(this.email);
        user.setFirstName(this.firstName);
        user.setLastName(this.lastName);
        user.setPassword(this.password);

        return user;

    }

//    public  UserModel() {
//         user = new User();
//        user.setEmail(this.email);
//        user.setFirstName(this.firstName);
//        user.setLastName(this.lastName);
//        user.setPassword(this.password);
//
//    }

    public UserModel assemble(User user) {
        UserModel userModel = new UserModel();
        userModel.setEmail(user.getEmail());
        userModel.setFirstName(user.getFirstName());
        userModel.setLastName(user.getLastName());
        userModel.setPassword(user.getPassword());
        return userModel;
    }


}



