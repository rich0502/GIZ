package com.Giz.service.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Giz.data.domain.Question_conseil_divers;
import com.Giz.repository.Question_conseil_diversRepository;

@Service
public class Question_conseil_diversServiceImpl implements Question_conseil_diversService{
	
	@Autowired
	Question_conseil_diversRepository question_conseil_diversRepository;
	
	@Override
	public List<Question_conseil_divers> ListQuestion_conseil_diversAll() {
		// TODO Auto-generated method stub
		return question_conseil_diversRepository.findAll();
	}

	@Override
	public List<Question_conseil_divers> ListQuestion_conseil_divers(String code_prod) {
		// TODO Auto-generated method stub
		return question_conseil_diversRepository.findByCodeProd(code_prod);
	}

}
