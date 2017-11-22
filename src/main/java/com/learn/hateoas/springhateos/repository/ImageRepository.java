package com.learn.hateoas.springhateos.repository;

import org.springframework.data.repository.CrudRepository;

import com.learn.hateoas.springhateos.domain.Image;

public interface ImageRepository extends CrudRepository<Image, Long> {

}
