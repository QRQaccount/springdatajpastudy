package com.qrq.jpastudy_1.testJPA;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.qrq.jpastudy_1.pojo.User;
import com.qrq.jpastudy_1.pojo.UserHead;
import com.qrq.jpastudy_1.service.UserHeadService;
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
	@Autowired
	private UserHeadService userHeadService;

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
			Set<UserHead> userHeads = new HashSet<UserHead>();
			user.setUserHeads(userHeads);
			userService.save(user);
		}
	}

	@Test
	public void insertUserHeads() {
		for (int i = 0; i < 100; i++) {
			User user = new User();
			user.setUid(i + 1);
			user.setAge(12);
			user.setName("name" + String.valueOf(i));
			Set<UserHead> userHeads = new HashSet<UserHead>();
			user.setUserHeads(userHeads);
			for (int j = 0; j < 10; j++) {
				UserHead userHead = new UserHead();
				userHead.setPath("c://");
				userHead.setUser(user);
				userHeadService.save(userHead);
			}
		}
	}

	@Test
	public void findUserHead() {
		UserHead userHead = userHeadService.findUserHeadById(Long.valueOf(120));
		System.out.println(userHead);
	}

	@Test
	public void findUser() {
		List<User> userList = userService.findAll();
		Set<UserHead> userHeads = userList.get(1).getUserHeads();
		Iterator<UserHead> userIterator = userHeads.iterator();
		while (userIterator.hasNext()) {
			UserHead userHead = (UserHead) userIterator.next();
			System.out.println(userHead);
		}
		System.out.println();
	}
}
