package com.learn.hateoas.springhateos.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.learn.hateoas.springhateos.domain.Image;
import com.learn.hateoas.springhateos.resource.ImageResource;
import com.learn.hateoas.springhateos.service.ImageService;

import javassist.NotFoundException;

@RestController
@RequestMapping(value="/image", produces="application/json")
public class ImageController extends AbstractController<ImageResource> {

	@Autowired
	private ImageService imageService;
	
	private void validateIfFound(Object object, String msg) throws NotFoundException {
		if (object == null) {
			throw new NotFoundException(msg);
		}
	}
	
	@GetMapping
	public ResponseEntity<Resources<ImageResource>> all()  throws Exception {
		
		final List<ImageResource> collection = imageService.findAll().stream().map(ImageResource::new).collect(Collectors.toList());
	    final Resources<ImageResource> resources = new Resources<>(collection);
	    final String uriString = ServletUriComponentsBuilder.fromCurrentRequest().build().toUriString();
	    resources.add(new Link(uriString, "self"));
	    return ResponseEntity.ok(resources);
		
	}

	@GetMapping("/{id}")
	public ResponseEntity<ImageResource> retrieve(@PathVariable final Long id) throws Exception {
		
		if (id == null) {
			return new ResponseEntity<ImageResource>(HttpStatus.BAD_REQUEST);
		}

		Image image = this.imageService.retrieve(id);
		
		validateIfFound(image, "Image with id " + id + " not found.");
		
		return ResponseEntity.ok(new ImageResource(image));
	}

	@PostMapping
	public ResponseEntity<ImageResource> create(@RequestBody final Image image) throws Exception {
		
		if (image == null) {
			return new ResponseEntity<ImageResource>(HttpStatus.BAD_REQUEST);
		}

		Image createdImage = this.imageService.create(image);
		
		final URI uri =	MvcUriComponentsBuilder
						.fromController(getClass())
						.path("/{id}")
						.buildAndExpand(createdImage.getId())
						.toUri();
		
		return ResponseEntity.created(uri).body(new ImageResource(createdImage));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable final Long id, @RequestBody final Image image) throws Exception {
		
		if (image == null || id == null) {
			return new ResponseEntity<ImageResource>(HttpStatus.BAD_REQUEST);
		}

		Image currentImage = this.imageService.retrieve(id);
		
		validateIfFound(currentImage, "Image with id " + id + " not found");
		
		this.imageService.update(currentImage, image);
		
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable final Long id) throws Exception {
		
		if (id == null) {
			return new ResponseEntity<ImageResource>(HttpStatus.BAD_REQUEST);
		}

		Image currentImage = this.imageService.retrieve(id);
		
		validateIfFound(currentImage, "Image with id " + id + " not found");
		
		this.imageService.delete(currentImage);
		
		return ResponseEntity.noContent().build();
	}
}