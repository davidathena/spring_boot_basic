package com.richway.basic.service;

import java.util.List;

import com.richway.basic.domain.User;

public interface UserService {
	void createUserTable();

	/**
	 * 新增用户
	 * 
	 * @param name
	 * @param age
	 */
	void create(String name, Integer age);

	/**
	 * 根据name删除一个用户高
	 * 
	 * @param name
	 */
	void deleteByName(String name);

	/**
	 * 获取用户总量
	 */
	Integer getAllUsers();

	public List<User> getAllUsersList();

	/**
	 * 删除所有用户
	 */
	void deleteAllUsers();
}
