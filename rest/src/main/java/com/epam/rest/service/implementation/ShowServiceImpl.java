package com.epam.rest.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.epam.rest.dao.ShowDao;
import com.epam.rest.entity.Show;
import com.epam.rest.service.ShowService;

public class ShowServiceImpl implements ShowService {
	@Autowired
	private ShowDao showDAO;

	@Transactional
	public void addShow(Show show) throws Exception {
		showDAO.addShow(show);
	}

	@Transactional
	public Show getShowById(int id) throws Exception {
		return showDAO.getShowById(id);
	}

	@Transactional
	public List<Show> getShowList() throws Exception {
		return showDAO.getShowList();
	}

	@Transactional
	public void deleteShow(int id) throws Exception {
		showDAO.deleteShow(id);
	}

	@Transactional
	public void editShow(Show show) throws Exception {
		showDAO.editShow(show);
	}

}
