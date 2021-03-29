package com.Giz.service.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Giz.data.domain.Info_parcelle;
import com.Giz.repository.Info_parcelleRepository;

@Service
public class Info_parcelleServiceImpl implements Info_parcelleService {
	
	@Autowired
	private Info_parcelleRepository info_parcelleRepository ;
	
	@Override
	public List<Info_parcelle> ListInfo_parcelle() {
		// TODO Auto-generated method stub
		return info_parcelleRepository.findAll();
	}

}
