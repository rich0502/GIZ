package com.Giz.service.metier;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Giz.data.domain.Leaders;
import com.Giz.repository.LeadersRepository;

@Service
public class LeadersServiceImpl implements LeadersService {
	
	@Autowired
	private LeadersRepository leadersRepository;

	@Override
	public List<Leaders> ListLeaders() {
		// TODO Auto-generated method stub
		return leadersRepository.findAll();
	}

	@Override
	public void deleteLeaders(Long id_lds) {
		leadersRepository.deleteById(id_lds);
		
	}

	@Override
	public void addLeaders(String code_village, String nomPrenom, String genre_pt, int annee_naiss,
			boolean operationnel, Date date_mise, Date date_suivi) {
		Leaders leaders = new Leaders();
		leaders.setCode_village(code_village);
		leaders.setNomPrenom(nomPrenom);
		leaders.setGenre_pt(genre_pt.toLowerCase());
		leaders.setAnnee_naiss(annee_naiss);
		leaders.setOperationnel(operationnel);
		leaders.setDate_mise(date_mise);
		leaders.setDate_suivi(date_suivi);
		leadersRepository.save(leaders);
		
	}

	@Override
	public void modifyLeaders(Leaders leaders, String code_village, String nomPrenom, String genre_pt,
			int annee_naiss, boolean operationnel, Date date_mise, Date date_suivi, Long id_lds) {
		leaders.setCode_village(code_village);
		leaders.setNomPrenom(nomPrenom);
		leaders.setGenre_pt(genre_pt.toLowerCase());
		leaders.setAnnee_naiss(annee_naiss);
		leaders.setOperationnel(operationnel);
		leaders.setDate_mise(date_mise);
		leaders.setDate_suivi(date_suivi);
		leadersRepository.save(leaders);
		
	}
	
	

	

}
