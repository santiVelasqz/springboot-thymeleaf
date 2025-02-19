package com.smarvel.springboot.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.smarvel.springboot.backend.entities.Category;
import com.smarvel.springboot.backend.services.ICategoryService;


@Controller
public class CategoryController {
	
	@Autowired
	private ICategoryService categoryService;
	
	
	@GetMapping({"home","/"})
	public String home() {
		
		return "home";
	}
	
	@GetMapping("/categories")
	public String showCategories(Model model) {
		
		List<Category> categories = categoryService.showCategories();
		
		model.addAttribute("categories", categories);
		
		return "categories";
	}
	
	@GetMapping("/category-form")
	public String categoryForm(Model model) {
		Category category = new Category();
		model.addAttribute("category", category);
		return "category-form";
	}
	
	@PostMapping("/save-category")
	public String saveCategory(@ModelAttribute Category category) {
		categoryService.saveCategory(category);
		return "redirect:/categories";
	}
	
	@GetMapping("/edit-category/{id}")
	public String editCategory(@PathVariable Long id, Model model) {
		Category category = categoryService.findById(id);
		model.addAttribute("category", category);
		
		return "/category-form";
	}
	
	@GetMapping("/delete-category/{id}")
	public String deleteCategory(@PathVariable Long id) {
		categoryService.delete(id);
		return "redirect:/categories";
	}
	


}
