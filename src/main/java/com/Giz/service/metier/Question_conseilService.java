package com.Giz.service.metier;

import java.util.List;
import java.util.Optional;

import com.Giz.data.domain.Question_conseil;

public interface Question_conseilService {

	List<Question_conseil> ListQuestion_conseil(String code_prod);
	
	public void addQC(long id, String code_pro, String question_symrise, String conseil_rural, String etat_vanille, String assistance);

	List<Question_conseil> ListQuestion_conseilAll();
	
	Optional<Question_conseil> existCodeProd(String code_prod);

	List<Question_conseil> ListQuestion_conseilAllFkt(String zone);

	List<Question_conseil> ListQuestion_conseilAllProd(String code_fkt);

}
