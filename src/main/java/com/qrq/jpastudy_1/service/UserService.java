package com.qrq.jpastudy_1.service;

import java.util.List;

import com.qrq.jpastudy_1.pojo.User;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public interface UserService {
     void save(User user);

     List<User> findAll();

     List<User> findByName1(String name);

     List<User> findByName2(String name);

     List<User> findByName3(String name);

     List<User> findByUid1(Integer uid);

     List<User> findByUid(Integer uid, Sort sort);

     Page<User> findByUidPageable(Integer uid, Pageable pageable);
}
