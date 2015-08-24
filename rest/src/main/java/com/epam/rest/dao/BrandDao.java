package com.epam.rest.dao;

import java.util.List;

import com.epam.rest.entity.Brand;

public interface BrandDao {
	public void addBrand(Brand brand) throws Exception;

	public Brand getBrandById(int id) throws Exception;

	public List<Brand> getBrandList() throws Exception;

	public void deleteBrand(int id) throws Exception;
}
