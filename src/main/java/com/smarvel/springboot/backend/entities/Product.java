package com.smarvel.springboot.backend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="products")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 30)
	@NotNull
	@NotEmpty
	@Size(max = 30)
	private String name;
	
	@Column(nullable = false)
	@NotNull
	private float price;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	
	

	public Product(Long id, @NotNull @NotEmpty @Size(max = 30) String name, @NotNull float price, Category category) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.category = category;
	}
	
	

	public Product(@NotNull @NotEmpty @Size(max = 30) String name, @NotNull float price, Category category) {
		super();
		this.name = name;
		this.price = price;
		this.category = category;
	}

	


	public Product() {
		super();
	}



	public Product(@NotNull @NotEmpty @Size(max = 30) String name) {
		super();
		this.name = name;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	
	
	
	
	

}
