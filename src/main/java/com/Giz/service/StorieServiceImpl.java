package com.Giz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Giz.data.domain.Storie;
import com.Giz.repository.StorieRepository;

@Service
@Transactional
public class StorieServiceImpl implements StorieService {
	
	@Autowired
	private StorieRepository storieRepository;
	
	@Override
	public Storie addStorie(Storie storie) throws Exception {
		return storie = storieRepository.save(storie);
	}

	@Override
	public List<Storie> getStorie() throws Exception {
		List<Storie> list = storieRepository.ListStorie();
		return list;
	}

}
