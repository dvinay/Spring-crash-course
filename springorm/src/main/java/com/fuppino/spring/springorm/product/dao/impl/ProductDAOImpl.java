package com.fuppino.spring.springorm.product.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.fuppino.spring.springorm.product.dao.ProductDAO;
import com.fuppino.spring.springorm.product.entity.Product;

@Component
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public int create(Product product) {
		// TODO Auto-generated method stub
		return 0;
	}
}
