package com.Giz.service.metier;

import java.util.Date;
import java.util.List;

import com.Giz.data.domain.SupportVideo;

public interface SVService {

	public List<SupportVideo> ListSV();

	public void deleteSupportVideo(Long id_sv);
	
	public void deleteAllSv();
	
	public void addSupportVideo( String code_village, String nom_support, Date date_dissemination,
			String receptionnaire, String genre_sv, String responsable, Date date_suivi);
	
	public void modifySupportVideo(SupportVideo supportVideo, String code_village, String nom_support, Date date_dissemination,
			String receptionnaire, String genre_sv, String responsable, Date date_suivi, Long id_sv);
	
}
