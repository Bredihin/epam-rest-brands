package com.epam.rest.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.epam.rest.dao.BrandDao;
import com.epam.rest.entity.Brand;
import com.epam.rest.service.BrandService;

public class BrandServiceImpl implements BrandService {
	@Autowired
	private BrandDao brandDAO;

	@Transactional
	public void addBrand(Brand brand) throws Exception {
		brandDAO.addBrand(brand);
	}

	@Transactional
	public Brand getBrandById(int id) throws Exception {
		return brandDAO.getBrandById(id);
	}

	@Transactional
	public List<Brand> getBrandList() throws Exception {
		return brandDAO.getBrandList();
	}

	@Transactional
	public void deleteBrand(int id) throws Exception {
		brandDAO.deleteBrand(id);
	}

}
