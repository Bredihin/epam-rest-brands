package com.epam.rest.service;

import java.util.List;

import com.epam.rest.entity.Show;

public interface ShowService {
	public void addShow(Show show) throws Exception;

	public Show getShowById(int id) throws Exception;

	public List<Show> getShowList() throws Exception;

	public void editShow(Show show) throws Exception;

	public void deleteShow(int id) throws Exception;
}
