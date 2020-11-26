package com.Giz.service.metier;

import java.util.Date;
import java.util.List;

import com.Giz.data.domain.Wp3EppFram;

public interface Wp3EppFramService {

	public List<Wp3EppFram> ListWp3EppFram();

	public void addWp3EppFram(String code_village, String nom_ecole, boolean projet_fram, boolean projet_valide,
			String type_projet, Date date_validation);
}
