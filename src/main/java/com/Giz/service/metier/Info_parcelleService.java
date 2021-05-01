package com.Giz.service.metier;

import java.util.List;
import java.util.Optional;

import com.Giz.data.domain.Info_parcelle;

public interface Info_parcelleService {

	List<Info_parcelle> ListInfo_parcelle(String code_prod);
	
	public void addInfoParcelle (long id,String code_prod, String nom_parcel, String annee_plan_liane, int nbr_liane, String recolt_estime, float surf_parcel,
			int nbr_liane_total, float rende_parcel, int vol_anne_prec, String culture_asocie, String asocie_autre, String inclinaison, String mise_anti_errosif,
			String technic_use, String photo_technique, String qualite_ombrage, String couverture_vegetal, String avant, String provien_liane, String spec_autre, String photo_parcelle);

	List<Info_parcelle> ListInfo_parcelleAll();
	
	Optional<Info_parcelle> existCodeProd(String code_prod);

	List<Info_parcelle> ListInfo_parcelleAllFkt(String zone);

	List<Info_parcelle> ListInfo_parcelleAllProd(String code_fkt);

}
