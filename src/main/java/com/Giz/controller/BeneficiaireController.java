package com.Giz.controller;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Giz.data.domain.Beneficiaire;
import com.Giz.repository.BeneficiaireRepository;
import com.Giz.service.metier.BeneficiaireService;

@Controller
public class BeneficiaireController {
	
	@Autowired
	BeneficiaireService beneficiaireService;
	
	@Autowired
	BeneficiaireRepository beneficiaireRepository;

	@RequestMapping("/listbeneficiaireWP2")
	public String listbeneficiaireWP2(Model model) {
		List<Beneficiaire> beneficiaireWP2 = beneficiaireService.getBeneficiereWP2();
		int year = Calendar.getInstance().get(Calendar.YEAR);
		model.addAttribute("Beneficiaire", beneficiaireWP2);
		model.addAttribute("annee", year);
		return "beneficiaire/listbeneficiaireWP2";
	}
	
	@RequestMapping("/listbeneficiaireWP3")
	public String listbeneficiaireWP3(Model model) {
		System.out.println("miditra");
		List<Beneficiaire> beneficiaireWP3 = beneficiaireService.getBeneficiereWP3();
		int year = Calendar.getInstance().get(Calendar.YEAR);
		model.addAttribute("Beneficiaire", beneficiaireWP3);
		model.addAttribute("annee", year);
		System.out.println("qsqdsqdsqd" + beneficiaireWP3);
		return "beneficiaire/listbeneficiaireWP3";
	}
	
	@RequestMapping("/listbeneficiaire")
	public String listbeneficiaire(Model model) {
		// wp2
		int beneficiaireWP2Garcon = beneficiaireService.getGarconWP2();
		int beneficiaireWP2Homme = beneficiaireService.getHommeWP2();
		int beneficiaireWP2Fille = beneficiaireService.getFilleWP2();
		int beneficiaireWP2Femme = beneficiaireService.getFemmeWP2();
		
		//wp3
		int beneficiaireWP3Garcon = beneficiaireService.getGarconWP3();
		int beneficiaireWP3Homme = beneficiaireService.getHommeWP3();
		int beneficiaireWP3Fille = beneficiaireService.getFilleWP3();
		int beneficiaireWP3Femme = beneficiaireService.getFemmeWP3();
		
				
		int totalGarcon = beneficiaireWP2Garcon + beneficiaireWP3Garcon;
		int totalHomme = beneficiaireWP2Homme + beneficiaireWP3Homme;
		int totalFille = beneficiaireWP2Fille + beneficiaireWP3Fille;
		int totalFemme = beneficiaireWP2Femme + beneficiaireWP3Femme;
		int total = totalGarcon + totalHomme + totalFille + totalFemme;
		float totalMenage =  total / 5;
		
		
		model.addAttribute("beneficiaireWP2Garcon", beneficiaireWP2Garcon);
		model.addAttribute("beneficiaireWP2Homme", beneficiaireWP2Homme);
		model.addAttribute("beneficiaireWP2Fille", beneficiaireWP2Fille);
		model.addAttribute("beneficiaireWP2Femme", beneficiaireWP2Femme);
		
		model.addAttribute("beneficiaireWP3Garcon", beneficiaireWP3Garcon);
		model.addAttribute("beneficiaireWP3Homme", beneficiaireWP3Homme);
		model.addAttribute("beneficiaireWP3Fille", beneficiaireWP3Fille);
		model.addAttribute("beneficiaireWP3Femme", beneficiaireWP3Femme);
		
				
		model.addAttribute("totalGarcon", totalGarcon);
		model.addAttribute("totalHomme", totalHomme);
		model.addAttribute("totalFille", totalFille);
		model.addAttribute("totalFemme", totalFemme);
		model.addAttribute("total", total);
		model.addAttribute("totalMenage", totalMenage);
		return "beneficiaire/listbeneficiaire";
	}
	
	
}
