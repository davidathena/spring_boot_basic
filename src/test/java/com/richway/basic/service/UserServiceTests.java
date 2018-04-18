package com.richway.basic.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.richway.basic.domain.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTests {
	
	@Autowired
	private UserService userService;

	@Before
	public void setUp() {
		userService.createUserTable();
		userService.deleteAllUsers();
	}

	@Test
	public void test() {
		userService.create("张三", 24);
		userService.create("李四", 25);
		userService.create("王二", 21);

		List<User> list=userService.getAllUsersList();
		for(User user:list) {
			System.out.println(user.getName());
		}
		Assert.assertEquals(3, userService.getAllUsers().intValue());
		userService.deleteByName("张三");
		Assert.assertEquals(2, userService.getAllUsers().intValue());
	}
}
