package com.qrq.jpastudy_1.testJPA;

import java.util.List;

import com.qrq.jpastudy_1.pojo.User;
import com.qrq.jpastudy_1.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestRep {
    @Autowired
    private UserService userService;

    @Test
    public void saveTest() {
        User user = new User();
        user.setAge(12);
        user.setName("11");
        userService.save(user);
    }

    @Test
    public void saveTestFind() {
        List<User> userlist = userService.findAll();
        User user = userService.findByName1("name22");
        User user1 = userService.findByName2("name23");
        System.out.println();
    }

    @Test
    public void insert() {
        for (int i = 0; i < 100; i++) {
            User user = new User();
            user.setAge(12);
            user.setName("name" + String.valueOf(i));
            userService.save(user);
        }
    }

}
