package com.epam.rest.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.epam.rest.dao.SubscriptionShowDao;
import com.epam.rest.entity.SubscriptionShow;
import com.epam.rest.service.SubscriptionShowService;

public class SubscriptionShowServiceImpl implements SubscriptionShowService {
	@Autowired
	private SubscriptionShowDao subscriptionShowDAO;

	@Transactional
	public void addSubscriptionShow(SubscriptionShow subscriptionShow) throws Exception {
		subscriptionShowDAO.addSubscriptionShow(subscriptionShow);
	}

	@Transactional
	public SubscriptionShow getSubscriptionShowById(int id) throws Exception {
		return subscriptionShowDAO.getSubscriptionShowById(id);
	}

	@Transactional
	public void deleteSubscriptionShow(int id) throws Exception {
		subscriptionShowDAO.deleteSubscriptionShow(id);
	}

}
