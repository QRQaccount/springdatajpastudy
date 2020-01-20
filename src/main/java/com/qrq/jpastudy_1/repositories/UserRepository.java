package com.qrq.jpastudy_1.repositories;

import com.qrq.jpastudy_1.pojo.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


/*
 * 使用Query时用类表示表
 * */
public interface UserRepository extends JpaRepository<User, Integer> {
    @Override
    List<User> findAll();

    /*
     * 使用?后接数字代表方法传入的第n个参数
     * */
    @Query("SELECT u FROM User u where u.name=?1")
    User findByName_1(String name);

    /*
     * 使用:后接参数名,并在传入参数时使用@Param指定参数名称
     * */
    @Query("SELECT u FROM User u where u.name=:name")
    User finaByName_2(@Param("name") String name);
    
}
