package com.smarvel.springboot.backend.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smarvel.springboot.backend.dao.IProductDao;
import com.smarvel.springboot.backend.entities.Product;
import com.smarvel.springboot.backend.services.IProductService;

@Service
public class ProductServiceImpl implements IProductService{
	
	@Autowired
	private IProductDao productDao;

	@Override
	public List<Product> showProducts() {
		
		return productDao.findAll();
	}

	@Override
	public Product saveProduct(Product product) {
		
		return productDao.save(product);
	}

	@Override
	public void delete(Long id) {
		productDao.deleteById(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Product findById(Long id) {
		
		return productDao.findById(id).orElseThrow(null);
	}

}
