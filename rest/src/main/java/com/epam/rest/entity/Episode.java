package com.epam.rest.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "rest.episode")
// @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Episode {
	@Id
	@GeneratedValue
	@Column(name = "episodeId")
	private int episodeId;

	@Column(name = "episodeName")
	private String episodeName;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "episodeShowId", nullable = false)
	@JsonBackReference
	private Show episodeShow;

	@Column(name = "episodeDescription")
	private String episodeDescription;

	@Column(name = "episodeDate")
	private Date episodeDate;

	public Episode() {

	}

	public Episode(String name, String description, Date date) {
		this.episodeName = name;
		this.episodeDescription = description;
		this.episodeDate = date;
	}

	public String getEpisodeName() {
		return episodeName;
	}

	public void setEpisodeName(String name) {
		this.episodeName = name;
	}

	public String getEpisodeDescription() {
		return episodeDescription;
	}

	public void setEpisodeDescription(String description) {
		this.episodeDescription = description;
	}

	public Date getEpisodeDate() {
		return episodeDate;
	}

	public void setEpisodeDate(Date date) {
		this.episodeDate = date;
	}

	public Show getEpisodeShow() {
		return episodeShow;
	}

	public void setEpisodeShow(Show episodeShow) {
		this.episodeShow = episodeShow;
	}

	public int getEpisodeId() {
		return episodeId;
	}

	public void setEpisodeId(int episodeId) {
		this.episodeId = episodeId;
	}

}
