package com.fuppino.spring.springmvcorm.user.services;

import java.util.List;

import com.fuppino.spring.springmvcorm.user.entity.User;

public interface UserService {
	int save(User user);
	List<User> getUsers();
}
