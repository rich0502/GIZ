package com.Giz.service.metier;

import java.util.List;

import com.Giz.data.domain.Parasite_maladie_divers;


public interface Parasite_maladie_diversService {

	List<Parasite_maladie_divers> ListParasite_maladie_divers(String code_prod);

	List<Parasite_maladie_divers> ListParasite_maladie_diversAll();

}
