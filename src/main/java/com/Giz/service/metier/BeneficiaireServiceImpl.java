package com.Giz.service.metier;

import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Giz.data.domain.Beneficiaire;
import com.Giz.data.domain.Valider;
import com.Giz.repository.BeneficiaireRepository;



@Service
public class BeneficiaireServiceImpl implements BeneficiaireService {
	@Autowired
	private BeneficiaireRepository beneficiaireRepository;

	@Override
	public List<Beneficiaire> getBeneficiereWP2() {
		return beneficiaireRepository.listBeneficiaireWP2();
	}

	@Override
	public int getGarconWP2() {
		return beneficiaireRepository.getGarcon();
	}

	@Override
	public int getHommeWP2() {
		return beneficiaireRepository.getHomme();
	}

	@Override
	public int getFemmeWP2() {
		return beneficiaireRepository.getFemme();
	}

	@Override
	public int getFilleWP2() {
		return beneficiaireRepository.getFille();
	}

	@Override
	public List<Beneficiaire> getBeneficiereWP3() {
		List<String> list = beneficiaireRepository.listBeneficiaireWP3();
		List<Beneficiaire> benef = new ArrayList<>();
		for(int i = 0; i < list.size(); i++) {
			String[] temp = list.get(i).split(",");
			Beneficiaire ben = new Beneficiaire(temp[0], temp[1], Integer.parseInt(temp[2]),0, temp[3]);
			benef.add(ben);
		}
		return benef;
	}

	@Override
	public int getGarconWP3() {
		return beneficiaireRepository.getGarconWP3();
	}

	@Override
	public int getHommeWP3() {
		return beneficiaireRepository.getHommeWP3();
	}

	@Override
	public int getFemmeWP3() {
		return beneficiaireRepository.getFemmeWP3();
	}

	@Override
	public int getFilleWP3() {
		return beneficiaireRepository.getFilleWP3();
	}
	
	




	

}
