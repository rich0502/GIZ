package com.Giz.service.metier;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Giz.data.domain.Person_res;
import com.Giz.repository.Person_resRepository;

@Service
public class Person_resServiceImpl implements Person_resService {
	
	@Autowired
	Person_resRepository person_resRepository; 

	@Override
	public List<Person_res> ListPerson_res() {
		// TODO Auto-generated method stub
		return person_resRepository.findAll();
	}

	@Override
	public void deletePerson_res(Long id_pr) {
		person_resRepository.deleteById(id_pr);
		
	}

	@Override
	public void addPerson_res(String code_village, String nomPrenom, String genre_pr, int annee_naiss,
			boolean operationnalite, Date date_suivi, String types_services_dev) {
		Person_res person_res = new Person_res();
		person_res.setCode_village(code_village);
		person_res.setNomPrenom(nomPrenom);
		person_res.setGenre_pr(genre_pr.toLowerCase());
		person_res.setAnnee_naiss(annee_naiss);
		person_res.setOperationnalite(operationnalite);
		person_res.setDate_suivi(date_suivi);
		person_res.setTypes_services_dev(types_services_dev);
		
		person_resRepository.save(person_res);
		
	}

	@Override
	public void modifyPerson_res(Person_res person_res, String code_village, String nomPrenom, String genre_pr,
			int annee_naiss, boolean operationnalite, Date date_suivi, String types_services_dev, Long id_pr) {
		person_res.setCode_village(code_village);
		person_res.setGenre_pr(genre_pr.toLowerCase());
		person_res.setAnnee_naiss(annee_naiss);
		person_res.setOperationnalite(operationnalite);
		person_res.setDate_suivi(date_suivi);
		person_res.setTypes_services_dev(types_services_dev);
		
		person_resRepository.save(person_res);
		
	}

	@Override
	public void deleteAllPr() {
		// TODO Auto-generated method stub
		person_resRepository.deleteAll();
	}

	

}
