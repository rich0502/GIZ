package com.Giz.service.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.Giz.data.domain.Galerie;
import com.Giz.repository.GalerieRepository;

@Service
public class GalerieServiceImpl implements GalerieService{

	@Autowired
	GalerieRepository repository;
	
	@Override
	public Iterable<Galerie> getAllGalerie() {
		return repository.findAll();
	}

	@Override
	public Galerie creategalerie(Galerie galerie) throws Exception {
		return galerie = repository.save(galerie);
	}

	@Override
	public Galerie getGalerieById(Long id) throws Exception {
		return repository.findById(id).orElseThrow(() -> new Exception("This page no exist"));
	}

	@Override
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public void deleteGalerie(Long id) throws Exception {
		Galerie galerie = getGalerieById(id);
		repository.delete(galerie);
		
	}
	
	@Override
	public void updateGalerie(Long id, String nom_album) throws Exception {
		repository.modifGalerie(id, nom_album);
	}

}
