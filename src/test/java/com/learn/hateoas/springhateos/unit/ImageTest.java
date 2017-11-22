package com.learn.hateoas.springhateos.unit;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.learn.hateoas.springhateos.domain.Image;
import com.learn.hateoas.springhateos.repository.ImageRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
public class ImageTest {

	@Autowired
	private ImageRepository imageRepository;
	
	@Test
	public void shouldCreateImage() {
		
		String type = "png_teste";
		
		Image image = new Image();
		image.setType("png_teste");
		imageRepository.save(image);
		
		Image i = imageRepository.findByType(type);
		
		assertNotNull("Expected not null when retrieve image", i);
	}
	
}
