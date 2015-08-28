package com.epam.rest.service;

import java.util.List;

import com.epam.rest.entity.User;

public interface UserService {
	public boolean addUser(User user) throws Exception;

	public User getUserById(int id) throws Exception;

	public List<User> getUserList() throws Exception;

	public boolean editUser(User user) throws Exception;

	public boolean deleteUser(int id) throws Exception;

	// public boolean getSubscriptionShow(int id) throws Exception;
}
