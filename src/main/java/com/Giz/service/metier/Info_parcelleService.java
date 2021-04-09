package com.Giz.service.metier;

import java.util.List;

import com.Giz.data.domain.Info_parcelle;

public interface Info_parcelleService {

	List<Info_parcelle> ListInfo_parcelle(String code_prod);
	
	public void addInfoParcelle (String code_prod, String nom_parcel, String annee_plan_liane, int nbr_liane, String recolt_estime, float surf_parcel,
			int nbr_liane_total, float rende_parcel, int vol_anne_prec, String culture_asocie, String asocie_autre, String inclinaison, String mise_anti_errosif,
			String technic_use, String photo_technique, String qualite_ombrage, String couverture_vegetal, String avant, String provien_liane, String spec_autre, String photo_parcelle);

	List<Info_parcelle> ListInfo_parcelleAll();

}
