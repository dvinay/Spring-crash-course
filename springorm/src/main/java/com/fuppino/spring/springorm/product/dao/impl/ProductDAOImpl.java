package com.fuppino.spring.springorm.product.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fuppino.spring.springorm.product.dao.ProductDAO;
import com.fuppino.spring.springorm.product.entity.Product;

@Component("productDAO")
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
	@Transactional
	public int create(Product product) {
		Integer result = (Integer) hibernateTemplate.save(product);
		return result;
	}

	@Override
	@Transactional
	public void update(Product product) {
		hibernateTemplate.update(product);
	}

	@Override
	@Transactional
	public void delete(Product product) {
		hibernateTemplate.delete(product);
	}

	@Override
	public Product read(int id) {
		Product product = hibernateTemplate.get(Product.class,id);
		return product;
	}

	@Override
	public List<Product> readALL() {
		List<Product> products = hibernateTemplate.loadAll(Product.class);
		return products;
	}
}
