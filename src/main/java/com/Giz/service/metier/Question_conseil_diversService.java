package com.Giz.service.metier;

import java.util.List;
import java.util.Optional;

import com.Giz.data.domain.Question_conseil_divers;


public interface Question_conseil_diversService {

	List<Question_conseil_divers> ListQuestion_conseil_diversAll();

	List<Question_conseil_divers> ListQuestion_conseil_divers(String code_prod);
	
	public void addQCDivers(long id,String code_pro, String question_symrise, String conseil_rural, String etat_vanille, String assistance);
	
	Optional<Question_conseil_divers> existCodeProd(String code_prod);

}
