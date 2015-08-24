package com.epam.rest.dao;

import java.util.List;

import com.epam.rest.entity.User;

public interface UserDao {
	public boolean addUser(User user) throws Exception;

	public User getUserById(int id) throws Exception;

	public List<User> getUserList() throws Exception;

	public boolean deleteUser(int id) throws Exception;

	public boolean editUser(int id) throws Exception;

	public boolean addSubscription(int id) throws Exception;
}
