package com.example.jeongwoosung_201930327.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserDetailService {
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

    UserDetails loadUserByUserId(String userid) throws  UsernameNotFoundException;
}
