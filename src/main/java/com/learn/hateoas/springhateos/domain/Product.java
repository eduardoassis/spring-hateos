package com.learn.hateoas.springhateos.domain;

import java.util.List;

public class Product {

	private Long id;
	
	private String name;
	
	private String description;
	
	private Product parent;
	
	private List<Product> children;
	
	private List<Image> images;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Product getParent() {
		return parent;
	}

	public void setParent(Product parent) {
		this.parent = parent;
	}

	public List<Product> getChildren() {
		return children;
	}

	public void setChildren(List<Product> children) {
		this.children = children;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}
	
}
