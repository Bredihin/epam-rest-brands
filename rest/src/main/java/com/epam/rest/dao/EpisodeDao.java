package com.epam.rest.dao;

import java.util.List;

import com.epam.rest.entity.Episode;

public interface EpisodeDao {
	public void addEpisode(Episode episode) throws Exception;

	public Episode getEpisodeById(int id) throws Exception;

	public List<Episode> getEpisodeList() throws Exception;

	public void editEpisode(Episode episode) throws Exception;

	public void deleteEpisode(int id) throws Exception;
}
