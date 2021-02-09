package com.Giz.service.metier;

import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
		Beneficiaire ben;
		ArrayList<String> listData = new ArrayList<String>();
		
		for(int i = 0; i < list.size(); i++) { 
			String[] data1 = list.get(i).split(",");
			String[] nom1 = data1[0].split(" ");
			ArrayList<String> listname1 = new ArrayList<String>();
			for(int n=0; n < nom1.length; n++) {
				listname1.add(nom1[n]);
			}
			Collections.sort(listname1);

			String nomText="";
			for(int n=0; n <listname1.size(); n++) {
				nomText = nomText + listname1.get(n) + " ";
			}
			listData.add(nomText.trim().toLowerCase());

		}
		Set<String> set = new HashSet<String>();
		set.addAll(listData);
		ArrayList<String> distinctList = new ArrayList<String>(set);
		ArrayList<String> efao = new ArrayList<String>();
		for(int i=0; i < list.size(); i++) {
			String[] data1 = list.get(i).split(",");
			for(int j=0; j < distinctList.size(); j++) {
				if(data1[0].trim().length() == distinctList.get(j).trim().length()) {
					String[] nom1 = data1[0].split(" ");
					ArrayList<String> listname1 = new ArrayList<String>();
					for(int n=0; n < nom1.length; n++) {
						listname1.add(nom1[n]);
					}
					Collections.sort(listname1);
					String nomText="";
					for(int n=0; n <listname1.size(); n++) {
						nomText = nomText + listname1.get(n) + " ";
					}
					if(nomText.trim().equalsIgnoreCase(distinctList.get(j))) {
						if(!efao.contains(nomText.toLowerCase())){
							efao.add(nomText.toLowerCase());
							ben = new Beneficiaire(data1[0], data1[1], Integer.parseInt(data1[2]), data1[3]);
							benef.add(ben);
							break;
						}
					}
				}
			}
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
