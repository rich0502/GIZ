package com.Giz.service.metier;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import com.Giz.data.domain.Info_generale;

public interface Info_generaleService {

	List<Info_generale> ListInfo_generale(String code_prod);

	public void addInfoGeneral(long id, String code_pro, int nbr_parcel_prod,String appris_culture, String autre, String moyen, String technic_conseil,String change_tech, @RequestParam("prepare") String prepare,
   	 int dernier_compagne, String place_dedie);

	List<Info_generale> ListInfo_generaleAll();

}
