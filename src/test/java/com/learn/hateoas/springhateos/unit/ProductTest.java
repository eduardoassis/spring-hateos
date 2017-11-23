package com.learn.hateoas.springhateos.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.learn.hateoas.springhateos.domain.Image;
import com.learn.hateoas.springhateos.domain.Product;
import com.learn.hateoas.springhateos.repository.ImageRepository;
import com.learn.hateoas.springhateos.repository.ProductRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
public class ProductTest {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ImageRepository imageRepository;
	
	@Test
	public void shouldCreateProduct() {
		
		Product product = new Product();
		
		product.setName("Smartphone A");
		product.setDescription("The best smartphone on market");
		
		productRepository.save(product);
		
		Product p = productRepository.findByName("Smartphone A");
		
		assertNotNull("Expected product", p);
		
	}

	@Test
	public void shouldCreateProductWithParent() {
		
		Product child = new Product();
		
		child.setName("Smartphone Child");
		child.setDescription("The best smartphone on market");
		
		Product parent = new Product();
		
		parent.setName("Smartphone parent");
		parent.setDescription("The best smartphone on market");
		
		child.setParent(parent);
		
		productRepository.save(child);
		
		List<Product> children = productRepository.findByParent(parent);
		
		assertNotNull(children);
		assertEquals(1, children.size());
		
	}
	
	@Test
	public void shouldCreateProductWithChildren() {
		
		Product parent = new Product();
		
		parent.setName("Smartphone parent");
		parent.setDescription("The best smartphone on market");
		
		Product child1 = new Product();
		
		child1.setName("Smartphone Child 1");
		child1.setDescription("The best smartphone on market");

		Product child2 = new Product();
		
		child2.setName("Smartphone Child 2");
		child2.setDescription("The best smartphone on market");

		parent.setChildren(new ArrayList<Product>() {{
			add(child1);
			add(child2);
		}});
		
		productRepository.save(parent);

		Product p = productRepository.findOne(parent.getId());
		
		assertNotNull(p);
		assertNotNull(p.getChildren());
		assertEquals(2, p.getChildren().size());
		
	}
	
	@Test
	public void shouldCreateProductWithImages() {
		
		Image image1 = new Image();
		image1.setType("jpg");

		Image image2 = new Image();
		image2.setType("png");
		
		imageRepository.save(image2);
		
		String name = "Product with images";
		
		Product product = new Product();
		
		product.setName(name);
		product.setDescription("Product with images");
		
		product.setImages(new ArrayList<Image>() {{
			add(image1);
			add(image2);
		}});
		
		productRepository.save(product);
		
		Product p = productRepository.findByName(name);
		
		assertNotNull(p);
		assertNotNull(p.getImages());
		assertEquals(2, p.getImages().size());
		
	}
	
}