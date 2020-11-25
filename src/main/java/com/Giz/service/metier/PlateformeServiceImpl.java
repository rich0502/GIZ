package com.Giz.service.metier;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Giz.data.domain.Adoption_innovation;
import com.Giz.data.domain.AtelierMFR;
import com.Giz.data.domain.Plateforme;
import com.Giz.repository.Adopte_InnovationRepository;
import com.Giz.repository.AtelierMFRRepository;
import com.Giz.repository.PlateformRepository;

@Service
public class PlateformeServiceImpl implements PlateformeService {
	
	@Autowired
	private PlateformRepository plateformRepository;

	@Override
	public List<Plateforme> ListPlateforme() {
		// TODO Auto-generated method stub
		return plateformRepository.findAll();
	}

	@Override
	public List<Plateforme> fetchPlateforme(String type_plateform) {
		// TODO Auto-generated method stub
		return plateformRepository.fetchPlateforme(type_plateform);
	}

	@Override
	public void deletePlateforme(Long id_am) {
		plateformRepository.deleteById(id_am);
		
	}

	@Override
	public void addPlateforme(String code_village, boolean exist_platform, boolean operationnel, Date date_suivi,
			String commentaire, String type_plateform) {
		Plateforme plateforme = new Plateforme();
		plateforme.setCode_village(code_village);
		plateforme.setExist_platform(exist_platform);
		plateforme.setOperationnel(operationnel);
		plateforme.setDate_suivi(date_suivi);
		plateforme.setCommentaire(commentaire);
		plateforme.setType_plateform(type_plateform);
		plateformRepository.save(plateforme);
	}

	@Override
	public void modifyPlateforme(Plateforme plateforme, String code_village, boolean exist_platform,
			boolean operationnel, Date date_suivi, String commentaire, String type_plateform, Long id_am) {
		plateforme.setCode_village(code_village);
		plateforme.setExist_platform(exist_platform);
		plateforme.setOperationnel(operationnel);
		plateforme.setDate_suivi(date_suivi);
		plateforme.setCommentaire(commentaire);
		plateforme.setType_plateform(type_plateform);
		plateformRepository.save(plateforme);
	}

}
