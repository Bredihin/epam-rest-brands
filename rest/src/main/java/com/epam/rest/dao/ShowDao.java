package com.epam.rest.dao;

import java.util.List;

import com.epam.rest.entity.Show;

public interface ShowDao {
	public void addShow(Show show) throws Exception;

	public Show getShowById(int id) throws Exception;

	public List<Show> getShowList() throws Exception;

	public void deleteShow(int id) throws Exception;
}
