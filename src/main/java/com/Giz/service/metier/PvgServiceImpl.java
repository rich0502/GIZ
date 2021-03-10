package com.Giz.service.metier;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Giz.data.domain.ParcelleVG;
import com.Giz.repository.PvgRepository;

@Service
public class PvgServiceImpl implements PvgService {
	
	@Autowired
	private PvgRepository pvgRepository;

	@Override
	public List<ParcelleVG> ListParcelleVG() {
		// TODO Auto-generated method stub
		return pvgRepository.findAll();
	}

	@Override
	public void deleteParcelleVG(Long id_pvg) {
		pvgRepository.deleteById(id_pvg);
	}
	
	@Override
	public void createParcelleVG(String code_village, float x, float y, boolean exist, String nomResp, String genre_pvg,
			int annee_naiss, boolean suivi_numeric, boolean diffusion_resultat, Date date_suivi) {
		ParcelleVG parcelleVG = new ParcelleVG();
		parcelleVG.setCode_village(code_village);
		parcelleVG.setX(x);
		parcelleVG.setY(y);
		parcelleVG.setExist(exist);
		parcelleVG.setNomResp(nomResp);
		parcelleVG.setSuivi_numeric(suivi_numeric);
		parcelleVG.setGenre_pvg(genre_pvg);
		parcelleVG.setAnnee_naiss(annee_naiss);
		parcelleVG.setSuivi_numeric(suivi_numeric);
		parcelleVG.setDiffusion_resultat(diffusion_resultat);
		parcelleVG.setDate_suivi(date_suivi);
		pvgRepository.save(parcelleVG);
		
	}

	@Override
	public void addParcelleVG(String code_village, float x, float y, boolean exist, String nomResp, String genre_pvg,
			int annee_naiss, boolean suivi_numeric, boolean diffusion_resultat, Date date_suivi) {
		ParcelleVG parcelleVG = new ParcelleVG();
		parcelleVG.setCode_village(code_village);
		parcelleVG.setX(x);
		parcelleVG.setY(y);
		parcelleVG.setSuivi_numeric(suivi_numeric);
		parcelleVG.setDiffusion_resultat(diffusion_resultat);
		parcelleVG.setDate_suivi(date_suivi);
		pvgRepository.save(parcelleVG);
		
	}

	@Override
	public void modifyParcelleVG(ParcelleVG parcelleVG, String code_village, float x, float y, boolean exist,
			String nomResp, String genre_pvg, int annee_naiss, boolean suivi_numeric, boolean diffusion_resultat,
			Date date_suivi, Long id_pvg) {
		parcelleVG.setCode_village(code_village);
		parcelleVG.setX(x);
		parcelleVG.setY(y);
		parcelleVG.setSuivi_numeric(suivi_numeric);
		parcelleVG.setDiffusion_resultat(diffusion_resultat);
		parcelleVG.setDate_suivi(date_suivi);
		pvgRepository.save(parcelleVG);
		
	}
	
	

	

}
