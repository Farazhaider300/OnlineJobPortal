package com.example.JobPortal.configuration;

import com.example.JobPortal.entity.User;
import com.example.JobPortal.entity.UserRole;
import com.example.JobPortal.repository.UserRepository;
import com.example.JobPortal.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;


public class UserDetailsServiceImpl /*implements UserDetailsService*/ {
   /* @Autowired
    UserRoleRepository userRoleRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserRole userRole= userRoleRepository.findUserRoleByUser_email(username);
        if (userRole==null){
            throw new UsernameNotFoundException("Could not found user");
        }
        CustomUserDetails customUserDetails=new CustomUserDetails(userRole);
        return customUserDetails;
    }*/
}
