package com.smarvel.springboot.backend.services;

import java.util.List;

import com.smarvel.springboot.backend.entities.Category;

public interface ICategoryService {
	
	public List<Category> showCategories();
	
	public Category findById(Long id);
	
	public Category saveCategory(Category category);
	
	public void delete(Long id);
	

}
