package com.smarvel.springboot.backend.services;

import java.util.List;

import com.smarvel.springboot.backend.entities.Product;

public interface IProductService {
	
	public List<Product> showProducts();
	
	public Product findById(Long id);
	
	public Product saveProduct(Product product);
	
	public void delete(Long id);

}
