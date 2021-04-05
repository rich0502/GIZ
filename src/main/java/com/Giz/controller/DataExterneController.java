package com.Giz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Giz.data.domain.Activite;
import com.Giz.data.domain.Fertilisant_culture;
import com.Giz.data.domain.Fertilisant_vanille;
import com.Giz.data.domain.Info_generale;
import com.Giz.data.domain.Info_parcelle;
import com.Giz.data.domain.Info_parcelle_divers;
import com.Giz.data.domain.Main_oeuvre;
import com.Giz.data.domain.Parasite_maladie;
import com.Giz.data.domain.Parasite_maladie_divers;
import com.Giz.data.domain.Producteur;
import com.Giz.data.domain.Question_conseil;
import com.Giz.data.domain.Technique_vanille;
import com.Giz.service.metier.ActiviteService;
import com.Giz.service.metier.Fertilisant_cultureService;
import com.Giz.service.metier.Fertilisant_vanilleService;
import com.Giz.service.metier.Info_generaleService;
import com.Giz.service.metier.Info_parcelleService;
import com.Giz.service.metier.Info_parcelle_diversService;
import com.Giz.service.metier.Main_oeuvreService;
import com.Giz.service.metier.Parasite_maladieService;
import com.Giz.service.metier.Parasite_maladie_diversService;
import com.Giz.service.metier.ProducteurService;
import com.Giz.service.metier.Question_conseilService;
import com.Giz.service.metier.Technique_vanilleService;

@Controller
public class DataExterneController {
	
	@Autowired
	ActiviteService activiteService;
	
	@Autowired
	Fertilisant_cultureService fertilisant_cultureService;
	
	@Autowired
	Info_parcelle_diversService info_parcelle_diversService;
	
	@Autowired
	Parasite_maladie_diversService parasite_maladie_diversService;
	
	@Autowired
	Fertilisant_vanilleService fertilisant_vanilleService;
	
	@Autowired
	Info_generaleService info_generaleService;

	@Autowired
	Info_parcelleService info_parcelleService;

	@Autowired
	Main_oeuvreService main_oeuvreService;

	@Autowired
	Parasite_maladieService parasite_maladieService;

	@Autowired
	Question_conseilService question_conseilService;

	@Autowired
	Technique_vanilleService technique_vanilleService;
	
	@Autowired
	ProducteurService producteurService;
	
	@RequestMapping("/dataExterne")
	public String dataExterne(Model model) {
	
		List<Producteur> prod = producteurService.ListZone();
		model.addAttribute("prod", prod);
		return "data-externe/dataExterne";
	}
	
	@RequestMapping("/listActivite")
	public String listActivite(Model model) {
		List<Activite> activite = activiteService.ListActivite();
		model.addAttribute("activite", activite);			
		return "data-externe/listActivite";
	}
	
	@RequestMapping("/listActiviteProd")
	public String listActiviteProd(@RequestParam("ls_prod") String ls_prod,
			@RequestParam("etat_prod") String etat_prod
			,Model model) {
		String[] list_prod = ls_prod.split(",");
		model.addAttribute("etat_prod", etat_prod);
		model.addAttribute("list_prod", list_prod);
		return "data-externe/listActiviteProd";
	}
	
	@RequestMapping("/FindData")
	public String FindData(@RequestParam(value = "suivi", required = false) String suivi,
			@RequestParam(value = "zone", required = false) String zone,
			@RequestParam(value = "code_fkt", required = false) String code_fkt,
			@RequestParam(value = "code_prod", required = false) String code_prod, Model model) {
		
		if (code_fkt.equalsIgnoreCase("")) {
			List<Producteur> prod = producteurService.ListFkt(zone);
			model.addAttribute("prod", prod);
		} else if (code_prod.equalsIgnoreCase("")) {
			List<Producteur> prod = producteurService.ListProd(code_fkt);
			model.addAttribute("prod", prod);
		}
		
		if (suivi.equalsIgnoreCase("listActivite")) {
			List<Activite> activite = activiteService.ListActivite();
			model.addAttribute("activite", activite);			
			return "data-externe/listActivite";
		} else if (suivi.equalsIgnoreCase("listFertilisant_culture")) {
			List<Fertilisant_culture> fertilisant_culture = fertilisant_cultureService.ListFertilisant_culture(code_prod);
			model.addAttribute("fertilisant_culture", fertilisant_culture);
			return "data-externe/listFertilisant_culture";
		} else if (suivi.equalsIgnoreCase("listInfo_parcelle_divers")) {
			List<Info_parcelle_divers> info_parcelle_divers = info_parcelle_diversService.ListInfo_parcelle_divers(code_prod);
			model.addAttribute("info_parcelle_divers", info_parcelle_divers);
			return "data-externe/listInfo_parcelle_divers";
		} else if (suivi.equalsIgnoreCase("listParasite_maladie_divers")) {
			List<Parasite_maladie_divers> parasite_maladie_divers = parasite_maladie_diversService.ListParasite_maladie_divers(code_prod);
			model.addAttribute("parasite_maladie_divers", parasite_maladie_divers);
			return "data-externe/listParasite_maladie_divers";
		} else if (suivi.equalsIgnoreCase("listFertilisant_vanille")) {
			List<Fertilisant_vanille> fertilisant_vanille = fertilisant_vanilleService.ListFertilisant_vanille(code_prod);
			model.addAttribute("fertilisant_vanille", fertilisant_vanille);
			return "data-externe/listFertilisant_vanille";
		} else if (suivi.equalsIgnoreCase("listInfo_generale")) {
			List<Info_generale> info_generale = info_generaleService.ListInfo_generale(code_prod);
			model.addAttribute("info_generale", info_generale);
			return "data-externe/listInfo_generale";
		} else if (suivi.equalsIgnoreCase("listInfo_parcelle")) {
			List<Info_parcelle> info_parcelle = info_parcelleService.ListInfo_parcelle(code_prod);
			model.addAttribute("info_parcelle", info_parcelle);
			return "data-externe/listInfo_parcelle";
		} else if (suivi.equalsIgnoreCase("listMain_oeuvre")) {
			List<Main_oeuvre> main_oeuvre = main_oeuvreService.ListMain_oeuvre(code_prod);
			model.addAttribute("main_oeuvre", main_oeuvre);
			return "data-externe/listMain_oeuvre";
		} else if (suivi.equalsIgnoreCase("listParasite_maladie")) {
			List<Parasite_maladie> parasite_maladie = parasite_maladieService.ListParasite_maladie(code_prod);
			model.addAttribute("parasite_maladie", parasite_maladie);
			return "data-externe/listParasite_maladie";
		} else if (suivi.equalsIgnoreCase("listQuestion_conseil")) {
			List<Question_conseil> question_conseil = question_conseilService.ListQuestion_conseil(code_prod);
			model.addAttribute("question_conseil", question_conseil);
			return "data-externe/listQuestion_conseil";
		} else if (suivi.equalsIgnoreCase("listTechnique_vanille")) {
			List<Technique_vanille> technique_vanille = technique_vanilleService.ListTechnique_vanille(code_prod);
			model.addAttribute("technique_vanille", technique_vanille);
			return "data-externe/listTechnique_vanille";
		}
				
		return "data-externe/dataExterne";
	}
}
