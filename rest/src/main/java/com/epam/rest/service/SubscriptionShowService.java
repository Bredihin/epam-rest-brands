package com.epam.rest.service;

import com.epam.rest.entity.SubscriptionShow;

public interface SubscriptionShowService {
	public void addSubscriptionShow(SubscriptionShow subscriptionShow) throws Exception;

	public SubscriptionShow getSubscriptionShowById(int id) throws Exception;

	public void deleteSubscriptionShow(int id) throws Exception;
}