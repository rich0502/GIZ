package com.Giz.service.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Giz.data.domain.Info_generale;
import com.Giz.repository.Info_generaleRepository;

@Service
public class Info_generaleServiceImpl implements Info_generaleService{
	
	@Autowired
	Info_generaleRepository info_generaleRepository;
	
	@Override
	public List<Info_generale> ListInfo_generale(String code_prod) {
		// TODO Auto-generated method stub
		return info_generaleRepository.findByCodeProd(code_prod);
	}

	@Override
	public void addInfoGeneral(long id,String code_pro, int nbr_parcel_prod, String appris_culture, String autre, String moyen,
			String technic_conseil, String change_tech, String prepare, int dernier_compagne, String place_dedie) {
		Info_generale info = new Info_generale();
		info.setId(id);
		info.setCode_pro(code_pro);
		info.setNbr_parcel_prod(nbr_parcel_prod);
		info.setAppris_culture(appris_culture);
		info.setAutre(autre);
		info.setMoyen(moyen);
		info.setTechnic_conseil(technic_conseil);
		info.setChange_tech(change_tech);
		info.setPrepare(prepare);
		info.setDernier_compagne(dernier_compagne);
		info.setPlace_dedie(place_dedie);
		info_generaleRepository.save(info);
			}
			
	public List<Info_generale> ListInfo_generaleAll() {
		// TODO Auto-generated method stub
		return info_generaleRepository.findAll();
	}

}
