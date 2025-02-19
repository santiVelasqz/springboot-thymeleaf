package com.smarvel.springboot.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.smarvel.springboot.backend.entities.Brand;
import com.smarvel.springboot.backend.services.IBrandService;

@Controller
public class BrandController {

	@Autowired
	private IBrandService brandService;
	
	@GetMapping("/brands")
	public String showBrands(Model model) {
		
		List<Brand> brands = brandService.showBrands();
		
		model.addAttribute("brands", brands);
		
		return "brands";
	}
	
	@GetMapping("/brand-form")
	public String brandForm(Model model) {
		
		Brand brand = new Brand();
		model.addAttribute("brand", brand);
		return "brand-form";
	}
	
	@PostMapping("/save")
	public String saveBrand(@ModelAttribute Brand brand) {
		brandService.save(brand);
		return "redirect:/brands" ;
	}
	
	@GetMapping("/edit/{id}")
	public String editBrand(@PathVariable Long id, Model model) {
		Brand brand = brandService.findById(id);
		model.addAttribute("brand", brand);
		return "brand-form";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteBrand(@PathVariable Long id) {
		brandService.delete(id);
		return "redirect:/brands";
	}
}
