package com.example.jeongwoosung_201930327.repository;

import com.example.jeongwoosung_201930327.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User getByUid(String uid);

    List<User> findAllBy();
    List<User> findAllByOrderByName();


}
