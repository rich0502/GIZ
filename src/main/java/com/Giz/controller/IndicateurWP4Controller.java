package com.Giz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Giz.service.metier.AtelierMFRService;
import com.Giz.service.metier.DocCapService;
import com.Giz.service.metier.PlateformeService;

@Controller
public class IndicateurWP4Controller {
	
	@Autowired
	DocCapService docCapService;
	
	@Autowired
	AtelierMFRService atelierMFRService;
	
	@Autowired
	PlateformeService plateformeService;
	
	@RequestMapping("/indicateurWP4")
	public String indicateurWP1(@RequestParam("chronologie") String dateChronologique, Model model) {
		
		
		float can51 = docCapService.countDocCap(dateChronologique);
		if(can51 >= 1) {
			can51=100;
		}else {
			can51=0;
		}
		float target = 12;
		float can52 = (float) ((atelierMFRService.countAtelier(dateChronologique, "CANEVAS ATELIERS/EVENEMENTS PROMOTIONNELS DU RESEAU DE MFR DANS LA REGION")/target)*100.0);
		float can52H = atelierMFRService.getCountHomme(dateChronologique, "CANEVAS ATELIERS/EVENEMENTS PROMOTIONNELS DU RESEAU DE MFR DANS LA REGION");
		float can52F = atelierMFRService.getCountFemme(dateChronologique, "CANEVAS ATELIERS/EVENEMENTS PROMOTIONNELS DU RESEAU DE MFR DANS LA REGION");
		
		float target53 = 1;
		float can53 = (float) ((atelierMFRService.countAtelier(dateChronologique, "CANEVAS DIALOGUE REGIONAL SUR L'ACCES AU FINANCEMENT")/target53)*100.0);
		float can53H = atelierMFRService.getCountHomme(dateChronologique, "CANEVAS DIALOGUE REGIONAL SUR L'ACCES AU FINANCEMENT");
		float can53F = atelierMFRService.getCountFemme(dateChronologique, "CANEVAS DIALOGUE REGIONAL SUR L'ACCES AU FINANCEMENT");
		
		float target54 = 1;
		float can54 = (float) ((atelierMFRService.countAtelier(dateChronologique, "CANEVAS ATELIERS DE CAPITALISATION ET PARTAGE DES ACQUIS")/target54)*100.0);
		float can54H = atelierMFRService.getCountHomme(dateChronologique, "CANEVAS ATELIERS DE CAPITALISATION ET PARTAGE DES ACQUIS");
		float can54F = atelierMFRService.getCountFemme(dateChronologique, "CANEVAS ATELIERS DE CAPITALISATION ET PARTAGE DES ACQUIS");
		
		float target55 = 3;
		float can55 = (float) ((atelierMFRService.countAtelier(dateChronologique, "CANEVAS ATELIERS/EVENEMENTS PROMOTIONNELS DE MAHAVELONA DANS LA SAVA")/target55)*100.0);
		float can55H = atelierMFRService.getCountHomme(dateChronologique, "CANEVAS ATELIERS/EVENEMENTS PROMOTIONNELS DE MAHAVELONA DANS LA SAVA");
		float can55F = atelierMFRService.getCountFemme(dateChronologique, "CANEVAS ATELIERS/EVENEMENTS PROMOTIONNELS DE MAHAVELONA DANS LA SAVA");
		
		float target56 = 2;
		float can56 = (float) ((atelierMFRService.countAtelier(dateChronologique, "CANEVAS ATELIERS DE PARTAGES DES BONNES PRATIQUES ET OUTILS AUX PRODUCTEURS DE VANILLE")/target56)*100.0);
		float can56H = atelierMFRService.getCountHomme(dateChronologique, "CANEVAS ATELIERS DE PARTAGES DES BONNES PRATIQUES ET OUTILS AUX PRODUCTEURS DE VANILLE");
		float can56F = atelierMFRService.getCountFemme(dateChronologique, "CANEVAS ATELIERS DE PARTAGES DES BONNES PRATIQUES ET OUTILS AUX PRODUCTEURS DE VANILLE");
		
		float target57 = 1;
		float can57 = (float) ((plateformeService.countPlateforme(dateChronologique, "CANEVAS EXISTENCE DE DISPOSITIF CONCERTE DE SUIVI ET PROTECTION DES ENFANTS")/target57)*100.0);
		float can57T = plateformeService.getCount(dateChronologique, "CANEVAS EXISTENCE DE DISPOSITIF CONCERTE DE SUIVI ET PROTECTION DES ENFANTS");
		
		float target58 = 1;
		float can58 = (float) ((plateformeService.countPlateforme(dateChronologique, "CANEVAS PLATE FORME DE REFLEXION ET DE PLANIFICATION DE L'AMELIORATION DE LA FORMATION PROFESSIONNELLE")/target58)*100.0);
		float can58T = plateformeService.getCount(dateChronologique, "CANEVAS PLATE FORME DE REFLEXION ET DE PLANIFICATION DE L'AMELIORATION DE LA FORMATION PROFESSIONNELLE");
		
		float target59 = 1;
		float can59 = (float) ((plateformeService.countPlateforme(dateChronologique, "CANEVAS PLATE FORME DE CONCERTATION ET DE PLANIFICATION SUR L'ENVIRONNEMENT, BIODIVERSITE ET CHANGEMENT CLIMATIQUE DANS LA REGION SAVA")/target59)*100.0);
		float can59T = plateformeService.getCount(dateChronologique, "CANEVAS PLATE FORME DE CONCERTATION ET DE PLANIFICATION SUR L'ENVIRONNEMENT, BIODIVERSITE ET CHANGEMENT CLIMATIQUE DANS LA REGION SAVA");
		
		model.addAttribute("can51", can51);
		model.addAttribute("can52H", can52H);
		model.addAttribute("can52F", can52F);
		model.addAttribute("can52", can52);
		
		model.addAttribute("can53H", can53H);
		model.addAttribute("can53F", can53F);
		model.addAttribute("can53", can53);
		
		model.addAttribute("can54H", can54H);
		model.addAttribute("can54F", can54F);
		model.addAttribute("can54", can54);
		
		model.addAttribute("can55H", can55H);
		model.addAttribute("can55F", can55F);
		model.addAttribute("can55", can55);
		
		model.addAttribute("can56H", can56H);
		model.addAttribute("can56F", can56F);
		model.addAttribute("can56", can56);
		
		model.addAttribute("can57T", can57T);
		model.addAttribute("can57", can57);
		
		model.addAttribute("can58T", can58T);
		model.addAttribute("can58", can58);
		
		model.addAttribute("can59T", can59T);
		model.addAttribute("can59", can59);
		return "indicateurWp4/indicateurWp4";
	}
	

}
