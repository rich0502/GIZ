package com.Giz.service.metier;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Giz.data.domain.Info_parcelle;
import com.Giz.repository.Info_parcelleRepository;

@Service
public class Info_parcelleServiceImpl implements Info_parcelleService {
	
	@Autowired
	private Info_parcelleRepository info_parcelleRepository ;
	
	@Override
	public List<Info_parcelle> ListInfo_parcelle(String code_prod) {
		// TODO Auto-generated method stub
		return info_parcelleRepository.findByCodeProd(code_prod);
	}

	@Override
	public void addInfoParcelle(long id,String code_prod, String nom_parcel, String annee_plan_liane, int nbr_liane,
			String recolt_estime, float surf_parcel, int nbr_liane_total, float rende_parcel, int vol_anne_prec,
			String culture_asocie, String asocie_autre, String inclinaison, String mise_anti_errosif,
			String technic_use, String photo_technique, String qualite_ombrage, String couverture_vegetal, String avant,
			String provien_liane, String spec_autre, String photo_parcelle) {
		Info_parcelle info = new Info_parcelle();
		Optional<Info_parcelle> getId = info_parcelleRepository.existCodeProd(code_prod);
		info.setCode_prod(code_prod);
		info.setNom_parcel(nom_parcel);
		info.setAnnee_plan_liane(annee_plan_liane);
		info.setNbr_liane(nbr_liane_total);
		info.setRecolt_estime(recolt_estime);
		info.setSurf_parcel(surf_parcel);
		info.setNbr_liane_total(nbr_liane_total);
		info.setRende_parcel(rende_parcel);
		info.setVol_anne_prec(vol_anne_prec);
		info.setCulture_asocie(culture_asocie);
		info.setAsocie_autre(asocie_autre);
		info.setInclinaison(inclinaison);
		info.setMise_anti_errosif(mise_anti_errosif);
		info.setTechnic_use(technic_use);
		info.setPhoto_technique(photo_technique);
		info.setQualite_ombrage(qualite_ombrage);
		info.setCouverture_vegetal(couverture_vegetal);
		info.setAvant(avant);
		info.setProvien_liane(provien_liane);
		info.setSpec_autre(spec_autre);
		info.setPhoto_parcelle(photo_parcelle);
		
		if(existCodeProd(code_prod).isPresent()) {
			info.setId(getId.get().getId());
			info_parcelleRepository.save(info);
		}else {
			info.setId(id);
			info_parcelleRepository.save(info);
		}	
		
			}
	public List<Info_parcelle> ListInfo_parcelleAll() {
		// TODO Auto-generated method stub
		return info_parcelleRepository.findAll();
	}

	@Override
	public Optional<Info_parcelle> existCodeProd(String code_prod) {
		// TODO Auto-generated method stub
		return info_parcelleRepository.existCodeProd(code_prod);
	}

	@Override
	public List<Info_parcelle> ListInfo_parcelleAllFkt(String zone) {
		// TODO Auto-generated method stub
		return info_parcelleRepository.ListInfo_parcelleAllFkt(zone);
	}

	@Override
	public List<Info_parcelle> ListInfo_parcelleAllProd(String code_fkt) {
		// TODO Auto-generated method stub
		return info_parcelleRepository.ListInfo_parcelleAllProd(code_fkt);
	}

}
