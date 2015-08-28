package com.epam.rest.dao;

import com.epam.rest.entity.SubscriptionShow;

public interface SubscriptionShowDao {
	public void addSubscriptionShow(SubscriptionShow subscriptionShow) throws Exception;

	public SubscriptionShow getSubscriptionShowById(int id) throws Exception;

	public void deleteSubscriptionShow(int id) throws Exception;
}
