package com.example.JobPortal.configuration;

import com.example.JobPortal.entity.User;
import com.example.JobPortal.entity.UserRole;
/*import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;*/

import java.util.Collection;
import java.util.List;

public class CustomUserDetails /*implements UserDetails*/ {
    /*private UserRole userRole;

    public CustomUserDetails(UserRole userRole) {
        this.userRole = userRole;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority simpleGrantedAuthority=new SimpleGrantedAuthority(userRole.getRole().getRoleName());
        return List.of(simpleGrantedAuthority);
    }

    @Override
    public String getPassword() {
        return userRole.getUser().getPassword();
    }

    @Override
    public String getUsername() {
        return userRole.getUser().getEmail();
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }*/
}
