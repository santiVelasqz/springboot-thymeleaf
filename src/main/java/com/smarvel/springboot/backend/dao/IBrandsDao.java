package com.smarvel.springboot.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smarvel.springboot.backend.entities.Brand;

public interface IBrandsDao extends JpaRepository<Brand, Long>{

}
