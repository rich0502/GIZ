package com.Giz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Giz.data.domain.Activite;
import com.Giz.data.domain.Fertilisant_culture;
import com.Giz.data.domain.Fertilisant_vanille;
import com.Giz.data.domain.Info_generale;
import com.Giz.data.domain.Info_parcelle;
import com.Giz.data.domain.Info_parcelle_divers;
import com.Giz.data.domain.Main_oeuvre;
import com.Giz.data.domain.Parasite_maladie;
import com.Giz.data.domain.Parasite_maladie_divers;
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
	
	@RequestMapping("/listActivite")
	public String listActivite(Model model) {
		List<Activite> activite = activiteService.ListActivite();
		model.addAttribute("activite", activite);
		return "data-externe/listActivite";
	}
	
	@RequestMapping("/listFertilisant_culture")
	public String listFertilisant_culture(Model model) {
		List<Fertilisant_culture> fertilisant_culture = fertilisant_cultureService.ListFertilisant_culture();
		model.addAttribute("fertilisant_culture", fertilisant_culture);
		return "data-externe/listFertilisant_culture";
	}
	
	@RequestMapping("/listInfo_parcelle_divers")
	public String listInfo_parcelle_divers(Model model) {
		List<Info_parcelle_divers> info_parcelle_divers = info_parcelle_diversService.ListInfo_parcelle_divers();
		model.addAttribute("info_parcelle_divers", info_parcelle_divers);
		return "data-externe/listInfo_parcelle_divers";
	}
	
	@RequestMapping("/listParasite_maladie_divers")
	public String listParasite_maladie_divers(Model model) {
		List<Parasite_maladie_divers> parasite_maladie_divers = parasite_maladie_diversService.ListParasite_maladie_divers();
		model.addAttribute("parasite_maladie_divers", parasite_maladie_divers);
		return "data-externe/listParasite_maladie_divers";
	}
	
	@RequestMapping("/listFertilisant_vanille")
	public String listFertilisant_vanille(Model model) {
		List<Fertilisant_vanille> fertilisant_vanille = fertilisant_vanilleService.ListFertilisant_vanille();
		model.addAttribute("fertilisant_vanille", fertilisant_vanille);
		return "data-externe/listFertilisant_vanille";
	}
	
	@RequestMapping("/listInfo_generale")
	public String listInfo_generale(Model model) {
		List<Info_generale> info_generale = info_generaleService.ListInfo_generale();
		model.addAttribute("info_generale", info_generale);
		return "data-externe/listInfo_generale";
	}

	@RequestMapping("/listInfo_parcelle")
	public String listInfo_parcelle(Model model) {
		List<Info_parcelle> info_parcelle = info_parcelleService.ListInfo_parcelle();
		model.addAttribute("info_parcelle", info_parcelle);
		return "data-externe/listInfo_parcelle";
	}

	@RequestMapping("/listMain_oeuvre")
	public String listMain_oeuvre(Model model) {
		List<Main_oeuvre> main_oeuvre = main_oeuvreService.ListMain_oeuvre();
		model.addAttribute("main_oeuvre", main_oeuvre);
		return "data-externe/listMain_oeuvre";
	}

	@RequestMapping("/listParasite_maladie")
	public String listParasite_maladie(Model model) {
		List<Parasite_maladie> parasite_maladie = parasite_maladieService.ListParasite_maladie();
		model.addAttribute("parasite_maladie", parasite_maladie);
		return "data-externe/listParasite_maladie";
	}

	@RequestMapping("/listQuestion_conseil")
	public String listQuestion_conseil(Model model) {
		List<Question_conseil> question_conseil = question_conseilService.ListQuestion_conseil();
		model.addAttribute("question_conseil", question_conseil);
		return "data-externe/listQuestion_conseil";
	}

	@RequestMapping("/listTechnique_vanille")
	public String listTechnique_vanille(Model model) {
		List<Technique_vanille> technique_vanille = technique_vanilleService.ListTechnique_vanille();
		model.addAttribute("technique_vanille", technique_vanille);
		return "data-externe/listTechnique_vanille";
	}
}
