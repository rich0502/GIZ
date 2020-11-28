package com.Giz.service.metier;

import java.util.Date;
import java.util.List;

import com.Giz.data.domain.Wp3PeerEducator;

public interface Wp3PeerEducatorService {

	public List<Wp3PeerEducator> ListWp3PeerEducator();

	public void addWp3PeerEducator(String code_village, String nom_prenom, String sexe, int annee_naissance,
			boolean operationnelle, Date date_suivi);
}