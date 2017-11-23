package com.learn.hateoas.springhateos.resource;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.hateoas.ResourceSupport;

import com.learn.hateoas.springhateos.controllers.ImageController;
import com.learn.hateoas.springhateos.domain.Image;

public class ImageResource extends ResourceSupport {

	
	private final Image image;
	
	public ImageResource(final Image image) {
		
		this.image = image;
		final Long id = image.getId();
		
		try {
			add(linkTo(methodOn(ImageController.class).retrieve(id)).withSelfRel());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public Image getImage() {
		return image;
	}
	
}
