package com.epam.rest.service;

import java.util.List;

import com.epam.rest.entity.Brand;

public interface BrandService {
	public void addBrand(Brand brand) throws Exception;

	public Brand getBrandById(int id) throws Exception;

	public List<Brand> getBrandList() throws Exception;

	public void editBrand(Brand brand) throws Exception;

	public void deleteBrand(int id) throws Exception;
}
