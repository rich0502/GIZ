package com.Giz.service.metier;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Giz.data.domain.Parcelle_test;
import com.Giz.repository.Parcelle_testRepository;

@Service
public class ParcelleTestServiceImpl implements ParcelleTestService {

	@Autowired
	Parcelle_testRepository parcelle_testRepository;
	
	@Override
	public List<Parcelle_test> ListParcelle_test() {
		// TODO Auto-generated method stub
		return parcelle_testRepository.findAll();
	}

	@Override
	public void deleteParcelle_test(Long id_pt) {
		parcelle_testRepository.deleteById(id_pt);
		
	}

	@Override
	public void addParcelle_test(String code_village, float x, float y, String nomResponsable, String genre_pt,
			int annee_naiss, String pratique_realise, Date date_mise, float superficies, boolean operationnel,
			Date date_suivi, String technique_exergue, long nbr_participant, String type) {
		Parcelle_test parcelle_test = new Parcelle_test();
		parcelle_test.setCode_village(code_village);
		parcelle_test.setX(x);
		parcelle_test.setY(y);
		parcelle_test.setNomResponsable(nomResponsable);
		parcelle_test.setGenre_pt(genre_pt.toLowerCase());
		parcelle_test.setAnnee_naiss(annee_naiss);
		parcelle_test.setPratique_realise(pratique_realise);
		parcelle_test.setDate_mise(date_mise);
		parcelle_test.setSuperficies(superficies);
		parcelle_test.setOperationnel(operationnel);
		parcelle_test.setDate_suivi(date_suivi);
		parcelle_test.setTechnique_exergue(technique_exergue);
		parcelle_test.setNbr_participant(nbr_participant);
		parcelle_test.setNbr_participant(nbr_participant);
		parcelle_test.setType(type);
		parcelle_testRepository.save(parcelle_test);
		
	}

	@Override
	public void modifyParcelle_test(Parcelle_test parcelle_test, String code_village, float x, float y,
			String nomResponsable, String genre_pt, int annee_naiss, String pratique_realise, Date date_mise,
			float superficies, boolean operationnel, Date date_suivi, String technique_exergue, long nbr_participant,
			String type, Long id_pt) {
		parcelle_test.setCode_village(code_village);
		parcelle_test.setX(x);
		parcelle_test.setY(y);
		parcelle_test.setNomResponsable(nomResponsable);
		parcelle_test.setGenre_pt(genre_pt.toLowerCase());
		parcelle_test.setAnnee_naiss(annee_naiss);
		parcelle_test.setPratique_realise(pratique_realise);
		parcelle_test.setDate_mise(date_mise);
		parcelle_test.setSuperficies(superficies);
		parcelle_test.setOperationnel(operationnel);
		parcelle_test.setDate_suivi(date_suivi);
		parcelle_test.setTechnique_exergue(technique_exergue);
		parcelle_test.setNbr_participant(nbr_participant);
		parcelle_test.setNbr_participant(nbr_participant);
		parcelle_test.setType(type);
		parcelle_testRepository.save(parcelle_test);
	}

	@Override
	public void addParcelle_AGC(String code_village, float x, float y, String nomResponsable, String genre_pt,
			int annee_naiss, float superficies, boolean operationnel, Date date_suivi, String technique_exergue) {
		Parcelle_test parcelle_test = new Parcelle_test();
		parcelle_test.setCode_village(code_village);
		parcelle_test.setX(x);
		parcelle_test.setY(y);
		parcelle_test.setNomResponsable(nomResponsable);
		parcelle_test.setGenre_pt(genre_pt.toLowerCase());
		parcelle_test.setAnnee_naiss(annee_naiss);
		parcelle_test.setSuperficies(superficies);
		parcelle_test.setOperationnel(operationnel);
		parcelle_test.setDate_suivi(date_suivi);
		parcelle_test.setTechnique_exergue(technique_exergue);
		parcelle_testRepository.save(parcelle_test);
		
	}

	@Override
	public void addParcelleParticipant(String code_village, float x, float y, String nomResponsable, String genre_pt,
			int annee_naiss,Long nbr_participant, long nbr_homme, long nbr_femme,
			Date date_suivi) {
		Parcelle_test parcelle_test = new Parcelle_test();
		parcelle_test.setCode_village(code_village);
		parcelle_test.setX(x);
		parcelle_test.setY(y);
		parcelle_test.setNomResponsable(nomResponsable);
		parcelle_test.setGenre_pt(genre_pt.toLowerCase());
		parcelle_test.setAnnee_naiss(annee_naiss);
		parcelle_test.setNbr_participant(nbr_participant);;
		parcelle_test.setDate_suivi(date_suivi);
		parcelle_test.setNbr_femme(nbr_femme);
		parcelle_test.setNbr_homme(nbr_homme);
		parcelle_testRepository.save(parcelle_test);
		
	}

	@Override
	public List<Parcelle_test> ListParcellTestVanille(String type) {
		return parcelle_testRepository.findByIdParcellTestVanille(type);
	}

	@Override
	public float countParcellTestVanille() {
		return parcelle_testRepository.countParcelVanille("TESTS VANILLES");
	}
	
	
}
