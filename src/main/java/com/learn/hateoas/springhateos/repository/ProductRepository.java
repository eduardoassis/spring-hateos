package com.learn.hateoas.springhateos.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.learn.hateoas.springhateos.domain.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

	public Product findByName(String name);
	
	public List<Product> findByParent(Product parent);
}
