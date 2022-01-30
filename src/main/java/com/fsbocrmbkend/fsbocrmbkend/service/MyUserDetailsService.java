package com.fsbocrmbkend.fsbocrmbkend.service;

import com.fsbocrmbkend.fsbocrmbkend.security.MyUserDetails;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = (User) userService.findUserByEmailAddress(email);
        return new MyUserDetails((com.fsbocrmbkend.fsbocrmbkend.model.User) user);
    }
}