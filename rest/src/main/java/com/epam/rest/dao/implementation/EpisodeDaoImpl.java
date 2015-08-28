package com.epam.rest.dao.implementation;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.epam.rest.dao.EpisodeDao;
import com.epam.rest.entity.Episode;

@Repository
public class EpisodeDaoImpl implements EpisodeDao {
	@Autowired
	private SessionFactory sessionFactory;

	public void addEpisode(Episode episode) throws Exception {
		sessionFactory.getCurrentSession().save(episode);
	}

	public Episode getEpisodeById(int id) throws Exception {
		return (Episode) sessionFactory.getCurrentSession().load(Episode.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Episode> getEpisodeList() throws Exception {
		return sessionFactory.getCurrentSession().createCriteria(Episode.class).list();
	}

	public void deleteEpisode(int id) throws Exception {
		Episode episode = (Episode) sessionFactory.getCurrentSession().load(Episode.class, id);
		if (null != episode) {
			sessionFactory.getCurrentSession().delete(episode);
		}
	}

	public void editEpisode(Episode episode) throws Exception {
		sessionFactory.getCurrentSession().update(episode);
	}

}
