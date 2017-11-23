package com.learn.hateoas.springhateos.service;

import java.util.List;

import com.learn.hateoas.springhateos.domain.Image;

public interface ImageService {

	public Image create(Image image);
	
	public Image retrieve(Long id);
	
	public Image update(Image currentImage,  Image newImage);
	
	public void delete(Image image);
	
	public List<Image> findAll();
}
