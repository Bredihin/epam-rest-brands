package com.epam.rest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "rest.subscriptionshow")
public class SubscriptionShow {
	@Id
	@GeneratedValue
	@Column(name = "subscriptionShowId")
	private int subscriptionShowId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "User_userId", nullable = false)
	private User subscriptionUser;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Show_showId", nullable = false)
	private Show subscriptionShow;

	public int getSubscriptionShowId() {
		return subscriptionShowId;
	}

	public void setSubscriptionShowId(int subscriptionShowId) {
		this.subscriptionShowId = subscriptionShowId;
	}

	public User getSubscriptionUser() {
		return subscriptionUser;
	}

	public void setSubscriptionUser(User subscriptionUser) {
		this.subscriptionUser = subscriptionUser;
	}

	public Show getSubscriptionShow() {
		return subscriptionShow;
	}

	public void setSubscriptionShow(Show subscriptionShow) {
		this.subscriptionShow = subscriptionShow;
	}

}
