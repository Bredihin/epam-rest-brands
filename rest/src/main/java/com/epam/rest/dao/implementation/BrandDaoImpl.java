package com.epam.rest.dao.implementation;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.epam.rest.dao.BrandDao;
import com.epam.rest.entity.Brand;

@Repository
public class BrandDaoImpl implements BrandDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void addBrand(Brand brand) throws Exception {
		sessionFactory.getCurrentSession().save(brand);
	}

	public Brand getBrandById(int id) throws Exception {
		return (Brand) sessionFactory.getCurrentSession().load(Brand.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Brand> getBrandList() throws Exception {
		return sessionFactory.getCurrentSession().createCriteria(Brand.class).list();
	}

	public void deleteBrand(int id) throws Exception {
		Brand contact = (Brand) sessionFactory.getCurrentSession().load(Brand.class, id);
		if (null != contact) {
			sessionFactory.getCurrentSession().delete(contact);
		}

	}

	public void editBrand(Brand brand) throws Exception {
		sessionFactory.getCurrentSession().update(brand);
	}

}
