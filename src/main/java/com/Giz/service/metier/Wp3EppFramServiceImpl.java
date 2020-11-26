package com.Giz.service.metier;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Giz.data.domain.Wp3EppFram;
import com.Giz.repository.Wp3EppFramRepository;

@Service
public class Wp3EppFramServiceImpl implements Wp3EppFramService {

	@Autowired
	Wp3EppFramRepository wp3EppFramRepository;

	@Override
	public List<Wp3EppFram> ListWp3EppFram() {
		// TODO Auto-generated method stub
		return wp3EppFramRepository.findAll();
	}

	@Override
	public void addWp3EppFram(String code_village, String nom_ecole, boolean projet_fram, boolean projet_valide,
			String type_projet, Date date_validation) {

		Wp3EppFram wp3EppFram = new Wp3EppFram();

		wp3EppFram.setCode_village(code_village);
		wp3EppFram.setNom_ecole(nom_ecole);
		wp3EppFram.setProjet_fram(projet_fram);
		wp3EppFram.setProjet_valide(projet_valide);
		wp3EppFram.setType_projet(type_projet);
		wp3EppFram.setDate_validation(date_validation);

		wp3EppFramRepository.save(wp3EppFram);

	}
}
