package com.epam.rest.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "rest.brand")
// @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Brand {
	@Id
	@GeneratedValue
	@Column(name = "brandId")
	private int brandId;

	@Column(name = "brandName")
	private String brandName;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "showBrandId")
	@JsonManagedReference
	private Set<Show> shows = new HashSet<Show>();

	public Brand() {

	}

	public Brand(int brandId, String brandName) {
		this.brandId = brandId;
		this.brandName = brandName;
	}

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public Brand(String brandName) {
		this.brandName = brandName;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public Set<Show> getShows() {
		return shows;
	}

	public void setShows(Set<Show> shows) {
		this.shows = shows;
	}

}
