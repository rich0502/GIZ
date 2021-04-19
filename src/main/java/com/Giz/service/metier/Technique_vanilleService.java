package com.Giz.service.metier;

import java.util.List;
import java.util.Optional;

import com.Giz.data.domain.Technique_vanille;

public interface Technique_vanilleService {

	List<Technique_vanille> ListTechnique_vanille(String code_prod);

	List<Technique_vanille> ListTechnique_vanilleAll();
	
	Optional<Technique_vanille> existCodeProd(String code_prod);
	
	
	public void addTechnique (long id,String code_pro, String ptv, String taille, String selectLiane,String  plantVao, String descentBoucl,String  entretienCan,
			String desherbFaush, String prepaBouton, String pollinisation, String limitGousse, String nettoyMort, String arretCoeur, String nettoyaParasit,
			String adyGasy, String appliCompo);

}
