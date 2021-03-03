package com.Giz.service.metier;

import java.util.Date;
import java.util.List;

import com.Giz.data.domain.Leaders;

public interface LeadersService {

	public List<Leaders> ListLeaders();

	public void deleteLeaders(Long id_lds);
	
	public void addLeaders(String code_village, String nomPrenom, String genre_pt, int annee_naiss,
			boolean operationnel, Date date_mise, Date date_suivi);
	
	public void modifyLeaders(Leaders leaders,String code_village, String nomPrenom, String genre_pt, int annee_naiss,
			boolean operationnel, Date date_mise, Date date_suivi, Long id_lds);
	
}
