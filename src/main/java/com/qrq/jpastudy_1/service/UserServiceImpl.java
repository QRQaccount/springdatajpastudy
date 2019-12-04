package com.qrq.jpastudy_1.service;

import java.util.List;

import com.qrq.jpastudy_1.pojo.User;
import com.qrq.jpastudy_1.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();

    }

    @Override
    public User findByName1(String name) {
        return userRepository.findByName_1(name);
    }

    @Override
    public User findByName2(String name) {
        return userRepository.finaByName_2(name);
    }
}
