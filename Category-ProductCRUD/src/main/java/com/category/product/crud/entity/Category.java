package com.category.product.crud.entity;

import org.springframework.data.annotation.Id;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Category 
{
	@Id
	@GenerateValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	private set<Product> products;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public set<Product> getProducts() {
		return products;
	}

	public void setProducts(set<Product> products) {
		this.products = products;
	}
	

}
