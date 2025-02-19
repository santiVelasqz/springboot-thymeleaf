package com.smarvel.springboot.backend.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smarvel.springboot.backend.dao.IBrandsDao;
import com.smarvel.springboot.backend.entities.Brand;
import com.smarvel.springboot.backend.services.IBrandService;

@Service
public class BrandServiceImpl implements IBrandService {
	
	@Autowired
	private IBrandsDao brandDao;

	@Override
	@Transactional(readOnly = true)
	public List<Brand> showBrands() {
		
		return brandDao.findAll();
	}

	@Override
	@Transactional
	public Brand save(Brand brand) {
		
		return brandDao.save(brand);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		brandDao.deleteById(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Brand findById(Long id) {
		
		return brandDao.findById(id).orElseThrow(null);
	}

}
