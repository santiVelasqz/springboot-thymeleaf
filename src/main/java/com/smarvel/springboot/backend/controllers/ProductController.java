package com.smarvel.springboot.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.smarvel.springboot.backend.dao.ICategoryDao;
import com.smarvel.springboot.backend.entities.Category;
import com.smarvel.springboot.backend.entities.Product;
import com.smarvel.springboot.backend.services.IProductService;

@Controller
public class ProductController {
	
	@Autowired
	private IProductService productService;
	
	@Autowired
	private ICategoryDao categoryDao;
	
	@GetMapping("/products")
	public String showProducts(Model model) {
		
		List<Product> products = productService.showProducts();
		
		model.addAttribute("products", products);
		
		return "products";
	}
	
	@GetMapping("/product-form")
	public String productForm(Model model) {
		
		List<Category> categories = categoryDao.findAll();
		Product product = new Product();
		model.addAttribute("product", product);
		model.addAttribute("categories", categories);
		return "/product-form";
	}
	
	@PostMapping("/save-product")
	public String saveProduct(@ModelAttribute Product product) {
		productService.saveProduct(product);
		return "redirect:/products";
	}
	
	@GetMapping("/edit-product/{id}")
	public String editProduct(@PathVariable Long id, Model model) {
		Product product = productService.findById(id);
		model.addAttribute("product", product);
		model.addAttribute("categories", categoryDao.findAll());
		return "product-form";
	}
	
	@GetMapping("/delete-product/{id}")
	public String deleteProduct(@PathVariable Long id) {
		productService.delete(id);
		return "redirect:/products";
	}

}
