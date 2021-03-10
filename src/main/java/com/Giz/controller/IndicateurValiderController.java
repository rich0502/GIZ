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
	
	@RequestMapping("/indicateurWP2Liste")
	public String indicateurWP2(@RequestParam("chronologie") String dateChronologique, Model model) {
		
		//lakile telo operationnel
		float target = 421;
		float l3_operationnel = (float) ((validerService.countLakileteloOperatoinnel(dateChronologique)/target)*100.0);
		int l3H_operationnel = validerService.countHLakileteloOperationnel(dateChronologique);
		int l3F_operationnel = validerService.countFLakileteloOperationnel(dateChronologique);
		
		target = 157;
		float l3_vsla_ope = (float) ((validerService.countL3VSLAOperationnel(dateChronologique)/target)*100.0);
		int l3H_vsla_operationnel = validerService.countL3VSLAOperationnelH(dateChronologique);
		int l3F_vsla_operationnel = validerService.countL3VSLAOperationnelF(dateChronologique);
		
		target = 3000;
		float l3_gec = (float) ((validerService.countL3GEC(dateChronologique)/target)*100.0);
		int l3H_gec = validerService.countL3GECH(dateChronologique);
		int l3F_gec = validerService.countL3GECF(dateChronologique);
		
		//VSLA
		int vsla = 0;
		if(validerService.countVSLAOperationnel() >= 1) {
			vsla = 100;
		}
		
		//canevas31 FBS iNTEGRATION EDUCATION FINANCIERE
		float FBS = (float) ((validerService.countFBS(dateChronologique)));
		
		//mobile money
		target = 1800;
		float mobil = (float) ((validerService.countMobileMoney(dateChronologique)/target)*100.0);
		int mobilH = validerService.countHMobileMoney(dateChronologique);
		int mobilF = validerService.countFMobileMoney(dateChronologique);
		
		//Finance
		target = 1200;
		float finance = (float) ((validerService.countFinance(dateChronologique)/target)*100.0);
		int financeH = validerService.countHFinance(dateChronologique);
		int financeF = validerService.countFFinance(dateChronologique);
		
		//Producteur
		target = 3500;
		float producteur = (float)((validerService.countProducteur(dateChronologique)/target)*100.0);
		int producteurH = validerService.countHProducteur(dateChronologique);
		int producteurF = validerService.countFProducteur(dateChronologique);
		
		//Adhesion
		target = 500;
		float adhesion = (float)((validerService.countAdhesion(dateChronologique)/target)*100.0);
		int adhesionH = validerService.countHAdhesion(dateChronologique);
		int adhesionF = validerService.countFAdhesion(dateChronologique);
		
		//Menage
		target = 1150;
		float menage = (float)((validerService.countMenage(dateChronologique)/target)*100.0);
		int menageH = validerService.countHMenage(dateChronologique);
		int menageF = validerService.countFMenage(dateChronologique);
		
		model.addAttribute("FBS", FBS);
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
