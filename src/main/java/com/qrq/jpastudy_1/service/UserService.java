package com.qrq.jpastudy_1.service;

import java.util.List;

import com.qrq.jpastudy_1.pojo.User;

public interface UserService {
    void save(User user);

    List<User> findAll();

    User findByName1(String name);

    User findByName2(String name);
}
