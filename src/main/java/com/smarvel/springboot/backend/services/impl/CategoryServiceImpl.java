package com.smarvel.springboot.backend.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smarvel.springboot.backend.dao.ICategoryDao;
import com.smarvel.springboot.backend.entities.Category;
import com.smarvel.springboot.backend.services.ICategoryService;

@Service
public class CategoryServiceImpl implements ICategoryService{
	
	@Autowired
	private ICategoryDao categoryDao;

	@Override
	@Transactional(readOnly = true)
	public List<Category> showCategories() {
		
		return categoryDao.findAll();
	}

	@Override
	@Transactional
	public Category saveCategory(Category category) {
		
		return categoryDao.save(category);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		categoryDao.deleteById(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Category findById(Long id) {
		
		return categoryDao.findById(id).orElseThrow(null);
	}

}
