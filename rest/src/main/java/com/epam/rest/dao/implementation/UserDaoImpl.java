package com.epam.rest.dao.implementation;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.epam.rest.dao.UserDao;
import com.epam.rest.entity.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	SessionFactory sessionFactory;

	;

	public boolean addUser(User user) {
		sessionFactory.getCurrentSession().save(user);
		return false;
	}

	public User getUserById(int id) {
		return (User) sessionFactory.getCurrentSession().load(User.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<User> getUserList() {
		return sessionFactory.getCurrentSession().createCriteria(User.class).list();
	}

	public boolean deleteUser(int id) {
		User user = (User) sessionFactory.getCurrentSession().load(User.class, id);
		if (null != user) {
			sessionFactory.getCurrentSession().delete(user);
		}
		return false;
	}

	public boolean addSubscription(int id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean editUser(int id) throws Exception {
		return false;
	}
}
