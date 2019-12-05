package com.qrq.jpastudy_1.testJPA;

import com.qrq.jpastudy_1.pojo.User;
import com.qrq.jpastudy_1.service.UserService;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public void testFind() {
        // List<User> userlist = userService.findAll();
        // List<User> userlist2 = userService.findByName1("name22");
        // List<User> userlist1 = userService.findByName2("name23");
        // List<User> userlist3 = userService.findByName3("ame3");
        // List<User> userlist4 = userService.findByUid(34, new
        // Sort(Sort.Direction.DESC, "uid"));
        Pageable pageable = new PageRequest(0, 3, Sort.Direction.DESC, "uid");
        Page<User> page = userService.findByUidPageable(44, pageable);
        List<User> forpage = page.getContent();
        Integer num = page.getNumberOfElements();
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
