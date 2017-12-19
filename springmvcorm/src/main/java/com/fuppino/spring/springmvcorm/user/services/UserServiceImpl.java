package com.fuppino.spring.springmvcorm.user.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fuppino.spring.springmvcorm.user.dao.UserDao;
import com.fuppino.spring.springmvcorm.user.entity.User;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao dao;

	public UserDao getDao() {
		return dao;
	}

	public void setDao(UserDao dao) {
		this.dao = dao;
	}

	@Override
	@Transactional
	public int save(User user) {
		int result = dao.create(user);
		return result;
	}

}
