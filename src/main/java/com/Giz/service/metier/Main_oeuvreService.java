package com.Giz.service.metier;

import java.util.List;
import java.util.Optional;

import com.Giz.data.domain.Main_oeuvre;

public interface Main_oeuvreService {

	List<Main_oeuvre> ListMain_oeuvre(String code_prod);

	public void addMainOeuvre (long id, String code_prod, int nbr_empl_perm, String empl_jour_saison, int nbr_empl_jour, int pay_empl_jour, String mois_tw_empl, String tw, String autre, String activite_vanille);

	List<Main_oeuvre> ListMain_oeuvreAll();
	
	Optional<Main_oeuvre> existCodeProd(String code_prod);

	List<Main_oeuvre> ListMain_oeuvreAllFkt(String zone);

	List<Main_oeuvre> ListMain_oeuvreAllProd(String code_fkt);

}
