package com.epam.rest.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "rest.user")
// @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "userId")
	private int userId;

	@Column(name = "userFirstName")
	private String userFirstName;
	@Column(name = "userLastName")
	private String userLastName;
	@Column(name = "userIdentifier")
	private long userUniqueIdentity;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "subscriptionUser")
	@JsonManagedReference
	private Set<SubscriptionShow> subscriptionsShow = new HashSet<SubscriptionShow>();

	public User() {

	}

	public Set<SubscriptionShow> getSubscriptionsShow() {
		return subscriptionsShow;
	}

	public void setSubscriptionsShow(Set<SubscriptionShow> subscriptionsShow) {
		this.subscriptionsShow = subscriptionsShow;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String firstName) {
		this.userFirstName = firstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String lastName) {
		this.userLastName = lastName;
	}

	public long getUserUniqueIdentity() {
		return userUniqueIdentity;
	}

	public void setUserUniqueIdentity(long uniqueIdentity) {
		this.userUniqueIdentity = uniqueIdentity;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return userId + "," + userFirstName + "," + userLastName + "," + userUniqueIdentity + "]";
	}
}
