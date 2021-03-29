package com.Giz.service.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Giz.data.domain.Question_conseil;
import com.Giz.repository.Question_conseilRepository;

@Service
public class Question_conseilServiceImpl implements Question_conseilService{
	
	@Autowired
	private Question_conseilRepository question_conseilRepository ;
	
	@Override
	public List<Question_conseil> ListQuestion_conseil() {
		// TODO Auto-generated method stub
		return question_conseilRepository.findAll();
	}

}
