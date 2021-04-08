package com.Giz.service.metier;

import java.util.List;

import com.Giz.data.domain.Technique_vanille;

public interface Technique_vanilleService {

	List<Technique_vanille> ListTechnique_vanille(String code_prod);

	List<Technique_vanille> ListTechnique_vanilleAll();

}
