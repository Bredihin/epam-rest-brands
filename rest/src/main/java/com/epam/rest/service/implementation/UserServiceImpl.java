package com.epam.rest.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.epam.rest.dao.UserDao;
import com.epam.rest.entity.User;
import com.epam.rest.service.UserService;

public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Transactional
	public boolean addUser(User user) throws Exception {
		return userDao.addUser(user);
	}

	@Transactional
	public User getUserById(int id) throws Exception {
		return userDao.getUserById(id);
	}

	@Transactional
	public List<User> getUserList() throws Exception {
		return userDao.getUserList();
	}

	@Transactional
	public boolean deleteUser(int id) throws Exception {
		return userDao.deleteUser(id);
	}

	@Transactional
	public boolean editUser(int id) throws Exception {
		return userDao.editUser(id);
	}

}
