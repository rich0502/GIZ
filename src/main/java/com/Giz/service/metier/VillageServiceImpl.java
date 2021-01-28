package com.Giz.service.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Giz.data.domain.Village;
import com.Giz.repository.VillageRepository;

@Service
public class VillageServiceImpl implements VillageService{
	
	@Autowired
	VillageRepository villageRepository;
	
	@Override
	public List<Village> ListVillage() {
		// TODO Auto-generated method stub
		return villageRepository.findAll();
	}
	

}
