package com.Giz.service.metier;

import java.util.List;

import com.Giz.data.domain.Question_conseil_divers;


public interface Question_conseil_diversService {

	List<Question_conseil_divers> ListQuestion_conseil_diversAll();

	List<Question_conseil_divers> ListQuestion_conseil_divers(String code_prod);

}
