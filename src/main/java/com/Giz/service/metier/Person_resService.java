package com.Giz.service.metier;

import java.util.Date;
import java.util.List;

import com.Giz.data.domain.Person_res;



public interface Person_resService {


	public List<Person_res> ListPerson_res();

	public void deletePerson_res(Long id_pr);
	
	public void addPerson_res(String code_village, String nomPrenom, String genre_pr, int annee_naiss, boolean operationnalite,
			Date date_suivi, String types_services_dev);
	
	
	public void modifyPerson_res(Person_res person_res, String code_village, String nomPrenom, String genre_pr, int annee_naiss, boolean operationnalite,
			Date date_suivi, String types_services_dev, Long id_pr);
	
}
