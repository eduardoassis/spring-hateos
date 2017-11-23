package com.learn.hateoas.springhateos.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.hateoas.springhateos.domain.Image;
import com.learn.hateoas.springhateos.repository.ImageRepository;
import com.learn.hateoas.springhateos.service.ImageService;

@Service
public class ImageServiceImpl implements ImageService {

	@Autowired
	private ImageRepository imageRepository;
	
	@Override
	public Image create(Image image) {
		
		try {
			
			Image imageCreated = imageRepository.save(image);
			return imageCreated;
			
		} catch (Exception e) {
			System.out.println("Error when try to create an image");
			e.printStackTrace();
			throw e;
		}
		
	}

	@Override
	public Image retrieve(Long id) {
		
		try {
			Image image = imageRepository.findOne(id);
			return image;
		} catch (Exception e) {
			System.out.println("Error when try to retrieve an image");
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public Image update(Image currentImage,  Image newImage) {
		
		try {

			currentImage.updateData(newImage);
			return this.imageRepository.save(currentImage);
			
		} catch (Exception ex) {
			System.out.println("Error when update image with id: " + currentImage.getId());
			ex.printStackTrace();
			throw ex;
		}
		
	}

	@Override
	public void delete(Image image) {
		
		try {
			
			this.imageRepository.delete(image);
			
		} catch (Exception ex) {
			System.out.println("Error when delete image with id: " + image.getId());
			ex.printStackTrace();
			throw ex;
		}
		
	}

	@Override
	public List<Image> findAll() {
		try {
			
			return (List<Image>) this.imageRepository.findAll();
			
		} catch (Exception ex) {
			System.out.println("Error when retrieve all images");
			ex.printStackTrace();
			throw ex;
		}
	}
}
