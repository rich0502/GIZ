package com.Giz.service.metier;

import java.util.List;

import com.Giz.data.domain.Question_conseil;

public interface Question_conseilService {

	List<Question_conseil> ListQuestion_conseil(String code_prod);
	
	public void addQC(String code_pro, String question_symrise, String conseil_rural, String etat_vanille, String assistance);

	List<Question_conseil> ListQuestion_conseilAll();

}
