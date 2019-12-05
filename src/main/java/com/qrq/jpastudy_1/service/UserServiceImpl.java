package com.qrq.jpastudy_1.service;

import java.util.List;

import com.qrq.jpastudy_1.pojo.User;
import com.qrq.jpastudy_1.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public List<User> findByName1(String name) {
        return userRepository.findByName_1(name);
    }

    @Override
    public List<User> findByName2(String name) {
        return userRepository.finaByName_2(name);
    }

    @Override
    public List<User> findByName3(String name) {
        return userRepository.findByName_3(name);
    }

    @Override
    public List<User> findByUid(Integer uid, Sort sort) {
        return userRepository.findByNameAndSort(uid, sort);
    }

    @Override
    public List<User> findByUid1(Integer uid) {
        return userRepository.findByUid(uid);
    }

    @Override
    public Page<User> findByUidPageable(Integer uid, Pageable pageable) {
        return userRepository.findByUidPageable(uid, pageable);
    }
}
