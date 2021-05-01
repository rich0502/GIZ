package com.Giz.service.metier;

import java.util.List;
import java.util.Optional;

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

	@Override
	public void addQCDivers(long id,String code_pro, String question_symrise, String conseil_rural, String etat_vanille,
			String assistance) {
		Question_conseil_divers qc = new Question_conseil_divers();
		Optional<Question_conseil_divers> getId = question_conseil_diversRepository.existCodeProd(code_pro); 

		qc.setCode_prod(code_pro);
		qc.setQuestion_symrise(question_symrise);
		qc.setConseil_rural(conseil_rural);
		qc.setEtat_vanille(etat_vanille);
		qc.setAssistance(assistance);

		
		if(existCodeProd(code_pro).isPresent()) {
			qc.setId(getId.get().getId());
			question_conseil_diversRepository.save(qc);
		}else {
			qc.setId(id);
			question_conseil_diversRepository.save(qc);
		}
		
	}
	
	@Override
	public Optional<Question_conseil_divers> existCodeProd(String code_prod) {
		return question_conseil_diversRepository.existCodeProd(code_prod);
	}

	@Override
	public List<Question_conseil_divers> ListQuestion_conseil_diversAllFkt(String zone) {
		// TODO Auto-generated method stub
		return question_conseil_diversRepository.ListQuestion_conseil_diversAllFkt(zone);
	}

	@Override
	public List<Question_conseil_divers> ListQuestion_conseil_diversAllProd(String code_fkt) {
		// TODO Auto-generated method stub
		return question_conseil_diversRepository.ListQuestion_conseil_diversAllProd(code_fkt);
	}

}
