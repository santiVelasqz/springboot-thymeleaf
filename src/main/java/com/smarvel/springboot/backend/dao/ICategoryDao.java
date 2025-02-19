package com.smarvel.springboot.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smarvel.springboot.backend.entities.Category;

public interface ICategoryDao extends JpaRepository<Category, Long> {
	
	

}
