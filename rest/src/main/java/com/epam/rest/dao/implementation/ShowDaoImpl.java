package com.epam.rest.dao.implementation;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.epam.rest.dao.ShowDao;
import com.epam.rest.entity.Show;

@Repository
public class ShowDaoImpl implements ShowDao {
	@Autowired
	private SessionFactory sessionFactory;

	public void addShow(Show show) throws Exception {
		sessionFactory.getCurrentSession().save(show);
	}

	public Show getShowById(int id) throws Exception {
		return (Show) sessionFactory.getCurrentSession().load(Show.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Show> getShowList() throws Exception {
		return sessionFactory.getCurrentSession().createCriteria(Show.class).list();
	}

	public void deleteShow(int id) throws Exception {
		Show show = (Show) sessionFactory.getCurrentSession().load(Show.class, id);
		if (null != show) {
			this.sessionFactory.getCurrentSession().delete(show);
		}
	}

}
