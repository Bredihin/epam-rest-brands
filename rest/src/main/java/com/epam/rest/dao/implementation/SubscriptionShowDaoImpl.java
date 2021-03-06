package com.epam.rest.dao.implementation;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.epam.rest.dao.SubscriptionShowDao;
import com.epam.rest.entity.SubscriptionShow;

public class SubscriptionShowDaoImpl implements SubscriptionShowDao {
	@Autowired
	private SessionFactory sessionFactory;

	public void addSubscriptionShow(SubscriptionShow subscriptionShow) throws Exception {
		sessionFactory.getCurrentSession().save(subscriptionShow);
	}

	public SubscriptionShow getSubscriptionShowById(long id) throws Exception {
		return (SubscriptionShow) sessionFactory.getCurrentSession().load(SubscriptionShow.class, id);
	}

	public void deleteSubscriptionShow(long id) throws Exception {
		SubscriptionShow subscriptionShow = (SubscriptionShow) sessionFactory.getCurrentSession().load(SubscriptionShow.class, id);
		if (null != subscriptionShow) {
			sessionFactory.getCurrentSession().delete(subscriptionShow);
		}
	}

}
