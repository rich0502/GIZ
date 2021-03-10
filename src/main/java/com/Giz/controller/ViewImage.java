package com.Giz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Giz.data.domain.Image;
import com.Giz.service.metier.ImageService;

@RestController
public class ViewImage {
	@Autowired
	ImageService imageService;
	
	@RequestMapping(value = "/image/{image_id}", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> getImage(@PathVariable("image_id") Long imageId) throws Exception {
			Image image = imageService.getImageById(imageId);
			byte[] imageContent = image.getPhoto();
	        final HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.parseMediaType("application/octet-stream"));
	        return new ResponseEntity<byte[]>(imageContent, headers, HttpStatus.OK);
    }

}
