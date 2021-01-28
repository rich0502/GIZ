package com.Giz.service.metier;

import java.sql.Date;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import com.Giz.data.domain.Beneficiaire;
import com.Giz.data.domain.Valider;


public interface BeneficiaireService {

	public List<Beneficiaire> getBeneficiereWP2();
	
	public int getGarconWP2();
	
	public int getHommeWP2();
	
	public int getFemmeWP2();
	
	public int getFilleWP2();
	
	
	public List<Beneficiaire> getBeneficiereWP3();
	
	public int getGarconWP3();
	
	public int getHommeWP3();
	
	public int getFemmeWP3();
	
	public int getFilleWP3();
	
}
