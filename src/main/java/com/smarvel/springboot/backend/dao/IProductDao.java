package com.smarvel.springboot.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smarvel.springboot.backend.entities.Product;

public interface IProductDao extends JpaRepository<Product, Long>{

}
