package com.Giz.service.metier;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Giz.data.domain.Question_conseil;
import com.Giz.repository.Question_conseilRepository;

@Service
public class Question_conseilServiceImpl implements Question_conseilService{
	
	@Autowired
	private Question_conseilRepository question_conseilRepository ;
	
	@Override
	public List<Question_conseil> ListQuestion_conseil(String code_prod) {
		// TODO Auto-generated method stub
		return question_conseilRepository.findByCodeProd(code_prod);
	}

	@Override
	public void addQC(long id, String code_pro, String question_symrise, String conseil_rural, String etat_vanille,
			String assistance) {
		Question_conseil qc = new Question_conseil();
		Optional<Question_conseil> getId = question_conseilRepository.existCodeProd(code_pro);
		qc.setCode_pro(code_pro);
		qc.setQuestion_symrise(question_symrise);
		qc.setConseil_rural(conseil_rural);
		qc.setEtat_vanille(etat_vanille);
		qc.setAssistance(assistance);
		
		if(existCodeProd(code_pro).isPresent()) {
			qc.setId(getId.get().getId());
			question_conseilRepository.save(qc);
		}else {
			qc.setId(id);
			question_conseilRepository.save(qc);
		}	
	}
	public List<Question_conseil> ListQuestion_conseilAll() {
		// TODO Auto-generated method stub
		return question_conseilRepository.findAll();
	}

	@Override
	public Optional<Question_conseil> existCodeProd(String code_prod) {
		// TODO Auto-generated method stub
		return question_conseilRepository.existCodeProd(code_prod);
	}

	@Override
	public List<Question_conseil> ListQuestion_conseilAllFkt(String zone) {
		// TODO Auto-generated method stub
		return question_conseilRepository.ListQuestion_conseilAllFkt(zone);
	}

	@Override
	public List<Question_conseil> ListQuestion_conseilAllProd(String code_fkt) {
		// TODO Auto-generated method stub
		return question_conseilRepository.ListQuestion_conseilAllProd(code_fkt);
	}

}
