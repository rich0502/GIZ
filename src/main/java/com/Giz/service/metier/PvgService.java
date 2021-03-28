package com.Giz.service.metier;

import java.util.Date;
import java.util.List;

import com.Giz.data.domain.ParcelleVG;


public interface PvgService {


	public List<ParcelleVG> ListParcelleVG();

	public void deleteParcelleVG(Long id_pvg);
	
	public void createParcelleVG(String code_village, float x, float y, boolean exist, String nomResp,
			String genre_pvg, int annee_naiss, boolean suivi_numeric, boolean diffusion_resultat, Date date_suivi);
	
	public void addParcelleVG(String code_village, float x, float y, boolean exist, String nomResp,
			String genre_pvg, int annee_naiss, boolean suivi_numeric, boolean diffusion_resultat, Date date_suivi);
	
	
	public void modifyParcelleVG(ParcelleVG parcelleVG,String code_village, float x, float y, boolean exist, String nomResp,
			String genre_pvg, int annee_naiss, boolean suivi_numeric, boolean diffusion_resultat, Date date_suivi, Long id_pvg);

	public void deleteAllPvg();
	
}
