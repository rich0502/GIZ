package com.Giz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Giz.service.metier.ValiderService;

@Controller
public class IndicateurValiderController {
	
	@Autowired
	ValiderService validerService;
	
	@RequestMapping("/indicateurWP2")
	public String indicateur(@RequestParam("nom_bf") String nom_bf,Model model) {
		System.out.println("any zani" + nom_bf);
		return "indicateur";
	}
	
	@RequestMapping("/indicateurWP2Liste")
	public String indicateurWP2(Model model) {
		
		//lakile telo operationnel
		float target = 421;
		float l3_operationnel = (float) ((validerService.countLakileteloOperatoinnel()/target)*100.0);
		int l3H_operationnel = validerService.countHLakileteloOperationnel();
		int l3F_operationnel = validerService.countFLakileteloOperationnel();
		
		target = 157;
		float l3_vsla_ope = (float) ((validerService.countL3VSLAOperationnel()/target)*100.0);
		int l3H_vsla_operationnel = validerService.countL3VSLAOperationnelH();
		int l3F_vsla_operationnel = validerService.countL3VSLAOperationnelF();
		
		target = 3000;
		float l3_gec = (float) ((validerService.countL3GEC()/target)*100.0);
		int l3H_gec = validerService.countL3GECH();
		int l3F_gec = validerService.countL3GECF();
		
		//VSLA
		int vsla = 0;
		if(validerService.countVSLAOperationnel() >= 1) {
			vsla = 100;
		}
		
		//mobile money
		target = 1800;
		float mobil = (float) ((validerService.countMobileMoney()/target)*100.0);
		int mobilH = validerService.countHMobileMoney();
		int mobilF = validerService.countFMobileMoney();
		
		//Finance
		target = 1200;
		float finance = (float) ((validerService.countFinance()/target)*100.0);
		int financeH = validerService.countHFinance();
		int financeF = validerService.countFFinance();
		
		//Producteur
		target = 3500;
		float producteur = (float)((validerService.countProducteur()/target)*100.0);
		int producteurH = validerService.countHProducteur();
		int producteurF = validerService.countFProducteur();
		
		//Adhesion
		target = 500;
		float adhesion = (float)((validerService.countAdhesion()/target)*100.0);
		int adhesionH = validerService.countHAdhesion();
		int adhesionF = validerService.countFAdhesion();
		
		//Menage
		target = 1150;
		float menage = (float)((validerService.countMenage()/target)*100.0);
		int menageH = validerService.countHMenage();
		int menageF = validerService.countFMenage();
		
		model.addAttribute("l3_operationnel", l3_operationnel);
		model.addAttribute("l3H_operationnel", l3H_operationnel);
		model.addAttribute("l3F_operationnel", l3F_operationnel);
		model.addAttribute("l3_vsla_ope", l3_vsla_ope);
		model.addAttribute("l3H_vsla_operationnel", l3H_vsla_operationnel);
		model.addAttribute("l3F_vsla_operationnel", l3F_vsla_operationnel);
		model.addAttribute("l3_gec", l3_gec);
		model.addAttribute("l3H_gec", l3H_gec);
		model.addAttribute("l3F_gec", l3F_gec);
		model.addAttribute("vsla", vsla);
		model.addAttribute("mobil", mobil);
		model.addAttribute("mobilH", mobilH);
		model.addAttribute("mobilF", mobilF);
		model.addAttribute("finance", finance);
		model.addAttribute("financeH", financeH);
		model.addAttribute("financeF", financeF);
		model.addAttribute("producteur", producteur);
		model.addAttribute("producteurH", producteurH);
		model.addAttribute("producteurF", producteurF);
		model.addAttribute("adhesion", adhesion);
		model.addAttribute("adhesionH", adhesionH);
		model.addAttribute("adhesionF", adhesionF);
		model.addAttribute("menage", menage);
		model.addAttribute("menageH", menageH);
		model.addAttribute("menageF", menageF);
		return "indicateurWp2/indicateurWp2";
	}

}
