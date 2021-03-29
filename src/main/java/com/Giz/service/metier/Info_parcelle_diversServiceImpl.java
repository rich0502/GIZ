package com.Giz.service.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Giz.data.domain.Info_parcelle_divers;
import com.Giz.repository.Info_parcelle_diversRepository;

@Service
public class Info_parcelle_diversServiceImpl implements Info_parcelle_diversService {

	@Autowired
	private Info_parcelle_diversRepository info_parcelle_diversRepository ;
	
	@Override
	public List<Info_parcelle_divers> ListInfo_parcelle_divers() {
		// TODO Auto-generated method stub
		return info_parcelle_diversRepository.findAll();
	}

}