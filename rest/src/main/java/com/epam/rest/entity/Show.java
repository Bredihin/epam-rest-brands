package com.epam.rest.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "rest.show")
// @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Show {
	@Id
	@GeneratedValue
	@Column(name = "showId")
	private int showId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "showBrandId", nullable = false)
	@JsonBackReference
	private Brand showBrand;

	@Column(name = "showName")
	private String showName;

	@Column(name = "showDescription")
	private String showDescription;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "episodeShow")
	@JsonManagedReference
	private Set<Episode> episodes = new HashSet<Episode>();

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "subscriptionShow")
	@JsonManagedReference
	private Set<SubscriptionShow> subscriptions = new HashSet<SubscriptionShow>();

	public Set<SubscriptionShow> getSubscriptions() {
		return subscriptions;
	}

	public void setSubscriptions(Set<SubscriptionShow> subscriptions) {
		this.subscriptions = subscriptions;
	}

	public Show() {

	}

	public Show(String name, String description) {
		this.showName = name;
		this.showDescription = description;
	}

	public String getShowName() {
		return showName;
	}

	public void setShowName(String name) {
		this.showName = name;
	}

	public String getShowDescription() {
		return showDescription;
	}

	public void setShowDescription(String description) {
		this.showDescription = description;
	}

	public int getShowId() {
		return showId;
	}

	public void setShowId(int showId) {
		this.showId = showId;
	}

	public Set<Episode> getEpisodes() {
		return episodes;
	}

	public void setEpisodes(Set<Episode> episodes) {
		this.episodes = episodes;
	}

	public Brand getShowBrand() {
		return showBrand;
	}

	public void setShowBrand(Brand showBrand) {
		this.showBrand = showBrand;
	}
}
