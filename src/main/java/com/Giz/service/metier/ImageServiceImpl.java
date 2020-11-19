package com.Giz.service.metier;


import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.Giz.data.domain.Image;
import com.Giz.repository.ImageRepository;

@Service
public class ImageServiceImpl implements ImageService{
	
	@Autowired
	ImageRepository repository;
	

	@Override
	public Iterable<Image> getAllImage() {
		return repository.findAll();
	}

	@Override
	public Image createImage(Image image) throws IOException {
		return image = repository.save(image);
	}

	@Override
	public Image getImageById(Long id) throws Exception {
		return repository.findById(id).orElseThrow(() -> new Exception("This page no exist"));
	}


	@Override
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public void deleteImage(Long id) throws Exception {
		Image image = getImageById(id);
		repository.delete(image);
	}
	
	@Override
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public void deleteGalerieImage(Long id) throws Exception {
		repository.deleteImageGalerie(id);
	}
	
	@Override
	public Image findImage(Long id) {
		return repository.findById(id).get();

	}
	


}
