package com.fuppino.spring.springmvcorm.user.dao;

import java.util.List;

import com.fuppino.spring.springmvcorm.user.entity.User;

public interface UserDao {
	int create(User user);
	List<User> findUsers();
}
