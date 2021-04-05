package com.Giz.service.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Giz.data.domain.Info_generale;
import com.Giz.repository.Info_generaleRepository;

@Service
public class Info_generaleServiceImpl implements Info_generaleService{
	
	@Autowired
	Info_generaleRepository info_generaleRepository;
	
	@Override
	public List<Info_generale> ListInfo_generale(String code_prod) {
		// TODO Auto-generated method stub
		return info_generaleRepository.findByCodeProd(code_prod);
	}

}
