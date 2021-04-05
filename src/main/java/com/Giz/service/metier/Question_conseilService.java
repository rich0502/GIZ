package com.Giz.service.metier;

import java.util.List;

import com.Giz.data.domain.Question_conseil;

public interface Question_conseilService {

	List<Question_conseil> ListQuestion_conseil(String code_prod);

}
