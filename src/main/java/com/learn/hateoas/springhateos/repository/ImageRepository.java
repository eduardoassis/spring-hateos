package com.learn.hateoas.springhateos.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.learn.hateoas.springhateos.domain.Image;
import com.learn.hateoas.springhateos.domain.Product;

public interface ImageRepository extends CrudRepository<Image, Long> {

	public Image findByType(String type);
	
	public List<Image> findByProduct(Product product);
}
