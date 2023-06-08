package com.example.jeongwoosung_201930327.service.impl;

import com.example.jeongwoosung_201930327.dao.UserDAO;
import com.example.jeongwoosung_201930327.dto.UserDto;
import com.example.jeongwoosung_201930327.entity.User;
import com.example.jeongwoosung_201930327.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;
    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<UserDto> listAll() {
        List<User> userList = userDAO.listAll();
        List<UserDto> userDAOList = userList.stream().map(
                UserDto::new).collect(Collectors.toList());
        return userDAOList;
    }
}
