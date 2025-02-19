package com.smarvel.springboot.backend.services;

import java.util.List;

import com.smarvel.springboot.backend.entities.Brand;


public interface IBrandService {

	
	public List<Brand> showBrands();
	
	public Brand findById(Long id);
	
	public Brand save(Brand brand);
	
	public void delete(Long id);
}
