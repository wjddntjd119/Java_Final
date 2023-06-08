package com.example.jeongwoosung_201930327.dao.impl;

import com.example.jeongwoosung_201930327.dao.UserDAO;
import com.example.jeongwoosung_201930327.entity.User;
import com.example.jeongwoosung_201930327.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDAOImpl implements UserDAO {
    private final UserRepository userRepository;

    public  UserDAOImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public List<User> listAll() {
        return userRepository.findAllBy();
    }
}
