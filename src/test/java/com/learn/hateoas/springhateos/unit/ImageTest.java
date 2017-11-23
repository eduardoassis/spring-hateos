package com.learn.hateoas.springhateos.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.learn.hateoas.springhateos.domain.Image;
import com.learn.hateoas.springhateos.domain.Product;
import com.learn.hateoas.springhateos.service.ImageService;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
@ContextConfiguration
@Transactional
public class ImageTest {

	@Autowired
	private ImageService imageService;

	
	@Test
	public void shouldCreateImageAndRetrieve() {
		
		Image image = new Image();
		image.setType("png_teste");
		Image newImage = imageService.create(image);
		
		assertNotNull("Expected not null after image saved", newImage);
		assertNotNull(newImage.getId());
		
		Image i = imageService.retrieve(newImage.getId());
		
		assertNotNull("Expected not null when retrieve image", i);
	}
	
	@Test
	public void shouldRetrieveAllImages() {

		int numberOfImages = 3;
		
		for(int i = 0; i < numberOfImages; i++) {
			Image image = new Image();
			image.setType("png_teste");
			imageService.create(image);
		}
		
		List<Image> images = imageService.findAll();
		
		assertNotNull(images);
		assertEquals(3, images.size());
		
	}

	@Test
	public void shouldUpdateImage() {

		Image image = new Image();
		image.setType("png_teste");
		image = imageService.create(image);

		Product product = new Product();
		product.setName("Smart phone");
		product.setDescription("Smart phone");
		
		image.setType(".smart");
		image.setProduct(product);
		
		Image currentImage = imageService.retrieve(image.getId());
		
		imageService.update(currentImage, image);
		
		Image i = imageService.retrieve(image.getId());
		
		assertNotNull(i);
		assertNotNull(i.getProduct());
		assertEquals(".smart", i.getType());
		
	}

	@Test
	public void shouldDeleteImage() {

		Image image = new Image();
		image.setType("png_teste");
		image = imageService.create(image);
		
		Long id = image.getId();
		
		imageService.delete(image);
		Image i = imageService.retrieve(id);
		
		assertNull(i);
	}
}
