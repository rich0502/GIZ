package com.Giz.service.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Giz.data.domain.Activite;
import com.Giz.repository.ActiviteRepository;

@Service
public class ActiviteServiceImpl implements ActiviteService {
	
	@Autowired
	ActiviteRepository activiteRepository;
	
	@Override
	public List<Activite> ListActivite() {
		// TODO Auto-generated method stub
		return activiteRepository.findAll();
	}
}
