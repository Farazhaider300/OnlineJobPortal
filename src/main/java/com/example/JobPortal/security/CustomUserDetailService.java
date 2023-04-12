package com.example.JobPortal.security;

import com.example.JobPortal.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUserDetails appUserDetails = null;

        User user = this.userRepository.findUserByEmailId(username);

        if(user == null)
        {
            throw new UsernameNotFoundException("User does not exist for emailId = " +username);
        }

        appUserDetails = new AppUserDetails(user);

        return appUserDetails;
    }
}
