package com.example.jeongwoosung_201930327.service.impl;

import com.example.jeongwoosung_201930327.repository.UserRepository;
import com.example.jeongwoosung_201930327.service.UserDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor//Constructor 넣는 역할 대신 해줌
public class UserDetailServiceImpl implements UserDetailService {

    private final UserRepository userRepository;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.getByUid(username);
    }

    @Override
    public UserDetails loadUserByUserId(String userid) throws UsernameNotFoundException {
        return null;
    }
}
