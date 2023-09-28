package com.example.spring.services;

import com.example.spring.dao.Users;
import com.example.spring.repositories.UserJpaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceJpa {

    @Autowired
    private UserJpaRepository userJpaRepository;

    @Transactional
    public void addUser(Users user) {
        userJpaRepository.save(user);
    }

    @Transactional
    public List<Users> findAllUsers() {
        return userJpaRepository.findAll();
    }
}
