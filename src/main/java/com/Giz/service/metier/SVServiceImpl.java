package com.Giz.service.metier;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Giz.data.domain.Adoption_innovation;
import com.Giz.data.domain.SupportVideo;
import com.Giz.repository.Adopte_InnovationRepository;
import com.Giz.repository.SupportVideoRepository;

@Service
public class SVServiceImpl implements SVService {

	@Autowired
	private SupportVideoRepository svRepository ;
	
	@Override
	public List<SupportVideo> ListSV() {
		// TODO Auto-generated method stub
		return svRepository.findAll();
	}

	@Override
	public void deleteSupportVideo(Long id_sv) {
		svRepository.deleteById(id_sv);
		
	}

	@Override
	public void addSupportVideo(String code_village, String nom_support, Date date_dissemination, String receptionnaire,
			String genre_sv, String responsable, Date date_suivi) {
		SupportVideo supportVideo = new SupportVideo();
		supportVideo.setCode_village(code_village);
		supportVideo.setNom_support(nom_support);
		supportVideo.setDate_dissemination(date_dissemination);
		supportVideo.setReceptionnaire(receptionnaire);
		supportVideo.setGenre_sv(genre_sv);
		supportVideo.setReceptionnaire(receptionnaire);
		supportVideo.setResponsable(responsable);
		supportVideo.setDate_suivi(date_suivi);
		
		svRepository.save(supportVideo);
		
	}

	@Override
	public void modifySupportVideo(SupportVideo supportVideo, String code_village, String nom_support,
			Date date_dissemination, String receptionnaire, String genre_sv, String responsable, Date date_suivi,
			Long id_sv) {
		supportVideo.setCode_village(code_village);
		supportVideo.setNom_support(nom_support);
		supportVideo.setDate_dissemination(date_dissemination);
		supportVideo.setReceptionnaire(receptionnaire);
		supportVideo.setGenre_sv(genre_sv);
		supportVideo.setReceptionnaire(receptionnaire);
		supportVideo.setResponsable(responsable);
		supportVideo.setDate_suivi(date_suivi);
		
		svRepository.save(supportVideo);
		
	}
	

	
}
