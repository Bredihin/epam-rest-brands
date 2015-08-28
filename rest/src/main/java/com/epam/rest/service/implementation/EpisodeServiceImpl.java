package com.epam.rest.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.epam.rest.dao.EpisodeDao;
import com.epam.rest.entity.Episode;
import com.epam.rest.service.EpisodeService;

public class EpisodeServiceImpl implements EpisodeService {
	@Autowired
	private EpisodeDao episodeDAO;

	public void addEpisode(Episode episode) throws Exception {
		episodeDAO.addEpisode(episode);
	}

	public Episode getEpisodeById(int id) throws Exception {
		return episodeDAO.getEpisodeById(id);
	}

	public List<Episode> getEpisodeList() throws Exception {
		return episodeDAO.getEpisodeList();
	}

	public void deleteEpisode(int id) throws Exception {
		episodeDAO.deleteEpisode(id);
	}

	public void editEpisode(Episode episode) throws Exception {
		episodeDAO.editEpisode(episode);
	}

}
