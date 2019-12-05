package com.qrq.jpastudy_1.repositories;

import com.qrq.jpastudy_1.pojo.User;
import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;

/*
 * 使用Query时用类表示表
 * */
public interface UserRepository extends JpaRepository<User, Integer> {
    @Override
    List<User> findAll();

    /*
     * 使用?后接数字代表方法传入的第n个参数
     */
    @Query("SELECT u FROM User u where u.name=?1")
    List<User> findByName_1(String name);

    /**
     * 使用:后接参数名,并在传入参数时使用@Param指定参数名称
     *
     * @param name
     * @return user
     */
    @Query("SELECT u FROM User u where u.name=:name")
    List<User> finaByName_2(@Param("name") String name);

    /**
     * 一个参数，匹配两个字段 开启nativeQuery=true，在value里可以用原生SQL语句完成查询
     *
     * @param name
     * @return userlist
     */
    @Query(nativeQuery = true, value = "select * from user where user.name like concat('%' ,?1,'%') ")
    List<User> findByName_3(String name);

    @Query("SELECT u FROM User u WHERE u.uid<?1")
    List<User> findByUid(Integer uid);

    /**
     * 将Sort作为参数传入
     * 
     * @param name
     */
    @Query("SELECT u FROM User u WHERE u.uid<:id")
    List<User> findByNameAndSort(@Param("id") Integer uid, Sort sort);

    /**
     * 
     */
    @QueryHints(value = { @QueryHint(name = "name", value = "value") }, forCounting = false)
    @Query("SELECT u FROM User u WHERE u.uid<:id")
    Page<User> findByUidPageable(@Param("id") Integer uid, Pageable pageable);
}
