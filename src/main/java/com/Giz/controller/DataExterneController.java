package com.Giz.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Giz.data.domain.Activite;
import com.Giz.data.domain.Fertilisant_culture;
import com.Giz.data.domain.Fertilisant_vanille;
import com.Giz.data.domain.Formation_culture;
import com.Giz.data.domain.Info_generale;
import com.Giz.data.domain.Info_parcelle;
import com.Giz.data.domain.Info_parcelle_divers;
import com.Giz.data.domain.Main_oeuvre;
import com.Giz.data.domain.Parasite_maladie;
import com.Giz.data.domain.Parasite_maladie_divers;
import com.Giz.data.domain.Producteur;
import com.Giz.data.domain.Question_conseil;
import com.Giz.data.domain.Question_conseil_divers;
import com.Giz.data.domain.Technique_vanille;
import com.Giz.service.metier.ActiviteService;
import com.Giz.service.metier.Fertilisant_cultureService;
import com.Giz.service.metier.Fertilisant_vanilleService;
import com.Giz.service.metier.Formation_cultureService;
import com.Giz.service.metier.Info_generaleService;
import com.Giz.service.metier.Info_parcelleService;
import com.Giz.service.metier.Info_parcelle_diversService;
import com.Giz.service.metier.Main_oeuvreService;
import com.Giz.service.metier.Parasite_maladieService;
import com.Giz.service.metier.Parasite_maladie_diversService;
import com.Giz.service.metier.ProducteurService;
import com.Giz.service.metier.Question_conseilService;
import com.Giz.service.metier.Question_conseil_diversService;
import com.Giz.service.metier.Technique_vanilleService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
	Question_conseil_diversService question_conseil_diversService;

	@Autowired
	Formation_cultureService formation_cultureService;
	
	@Autowired
	ProducteurService producteurService;
	
	@RequestMapping("/dataExterne")
	public String dataExterne(Model model) {
		model.addAttribute("zoneList", producteurService.ListZone());
		return "data-externe/dataExterne";
	}
	
	@RequestMapping("/listProducteurs")
	public String listProducteurs(Model model) {
		List<Producteur> listProd = producteurService.ListProducteur();
		model.addAttribute("listProd", listProd);
		return "data-externe/listProducteur";
	}
	
	@GetMapping("/getData")
	public @ResponseBody String getData(@RequestParam String suivi)
	{
		String json = null;
		if (suivi.equalsIgnoreCase("2")) {
			List<Object> list = Arrays.asList("Fértilisants","Formation sur la culture","Information sur la culture", "Parasites et maladies","Questions et conseils");
			try {
				json = new ObjectMapper().writeValueAsString(list);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			return json;
		} else if (suivi.equalsIgnoreCase("1")) {
			List<Object> list = Arrays.asList("Fértilisant vanille", "Information generale sur la vanille", "Info parcelle vanille", "Main d’œuvre (Vanille et autres spéculations)", "Parasites & maladies", "Questions & conseils", "Technique vanille");
			try {
				json = new ObjectMapper().writeValueAsString(list);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			return json;
		}
		return json;
	}
	
	@GetMapping("/getFokontany")
	public @ResponseBody String getFokontany(@RequestParam String zone)
	{
		String json = null;
		List<Object[]> list = producteurService.ListFkt(zone);
		try {
			json = new ObjectMapper().writeValueAsString(list);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return json;
	}
	
	@GetMapping("/getProd")
	public @ResponseBody String getProd(@RequestParam String code_fkt)
	{
		String json = null;
		List<Object[]> list = producteurService.ListProd(code_fkt);
		try {
			json = new ObjectMapper().writeValueAsString(list);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return json;
	}
	
	@RequestMapping("/activite")
	public String activite(Model model) {		
		return "data-externe/activite";
	}
	
	@RequestMapping("/findActivite")
	public String findActivite(@RequestParam String type_intervention,
			@RequestParam String theme_principal,
			@RequestParam String sous_theme, Model model) {
		List<Activite> activite = activiteService.ListActiviteFind(type_intervention,theme_principal,sous_theme);
		model.addAttribute("activite", activite);
		return "data-externe/listActivite";
	}
	
	@GetMapping("/getActivite")
	public @ResponseBody String getActivite(@RequestParam String theme_principal)
	{
		String json = null;
		if (theme_principal.equalsIgnoreCase("FBS")) {
			List<Object> list = Arrays.asList("M1","M2","M3", "M4","M5","M6","M7","M8","M9","M10","M11","M12");
			try {
				json = new ObjectMapper().writeValueAsString(list);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			return json;
		} else if (theme_principal.equalsIgnoreCase("GEC")) {
			List<Object> list = Arrays.asList("Epargne", "Crédit");
			try {
				json = new ObjectMapper().writeValueAsString(list);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			return json;
		} else if (theme_principal.equalsIgnoreCase("Post FBS")) {
			List<Object> list = Arrays.asList("Epargne", "Crédit", "Planification", "Budgetisation", "Services financiers");
			try {
				json = new ObjectMapper().writeValueAsString(list);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			return json;
		} else if (theme_principal.equalsIgnoreCase("CUMA")) {
			List<Object> list = Arrays.asList("Légumes", "Ady gasy", "Compost");
			try {
				json = new ObjectMapper().writeValueAsString(list);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			return json;
		} else if (theme_principal.equalsIgnoreCase("AGC")) {
			List<Object> list = Arrays.asList("Courbe de niveau", "Antiérosif");
			try {
				json = new ObjectMapper().writeValueAsString(list);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			return json;
		} else if (theme_principal.equalsIgnoreCase("Riz")) {
			List<Object> list = Arrays.asList("SR", "SRA", "SRP");
			try {
				json = new ObjectMapper().writeValueAsString(list);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			return json;
		} else if (theme_principal.equalsIgnoreCase("Elevage")) {
			List<Object> list = Arrays.asList("Poulet de chair", "Poulet gasy", "Pisciculture", "Apiculture", "Porcin");
			try {
				json = new ObjectMapper().writeValueAsString(list);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			return json;
		} else if (theme_principal.equalsIgnoreCase("Vanille")) {
			List<Object> list = Arrays.asList("Floraison", "Arret de coeur", "Info parcelle vanille", "Ady gasy", "Bouclage", "Tuteur");
			try {
				json = new ObjectMapper().writeValueAsString(list);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			return json;
		}
		return json;
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
		//String[] params = ls_prod.split(",");
		//String replaceString = ls_prod.replaceAll("\\s+", "");
		List<String> params = new ArrayList<String>(Arrays.asList(ls_prod.split(",")));
		List<Object[]> list = activiteService.ListActiviteProd(params);
		model.addAttribute("etat_prod", etat_prod);
		model.addAttribute("list_prod", list);
		return "data-externe/listActiviteProd";
	}
	
	@RequestMapping("/FindData")
	public String FindData(@RequestParam("suivi") String suivi,@RequestParam("data") String data,
			@RequestParam("zone") String zone,@RequestParam("code_fkt") String code_fkt,
			@RequestParam("code_prod") String code_prod, Model model, RedirectAttributes redirAttrs) {
		
		if (suivi.equalsIgnoreCase("Activité")) {
			List<Activite> activite = activiteService.ListActivite();
			model.addAttribute("activite", activite);			
			return "data-externe/listActivite";
			
		} else if (data.equalsIgnoreCase("Fértilisants")) {
			if (zone.equalsIgnoreCase("Tout")) {
				List<Fertilisant_culture> fertilisant_culture = fertilisant_cultureService.ListFertilisant_cultureAll();
				model.addAttribute("fertilisant_culture", fertilisant_culture);
				return "data-externe/listFertilisant_culture";
			} else if (code_fkt.equalsIgnoreCase("Tout")) {
				List<Fertilisant_culture> fertilisant_culture = fertilisant_cultureService.ListFertilisant_cultureAllFkt(zone);
				model.addAttribute("fertilisant_culture", fertilisant_culture);
				return "data-externe/listFertilisant_culture";
			} else if (code_prod.equalsIgnoreCase("Tout")) {
				List<Fertilisant_culture> fertilisant_culture = fertilisant_cultureService.ListFertilisant_cultureAllProd(code_fkt);
				model.addAttribute("fertilisant_culture", fertilisant_culture);
				return "data-externe/listFertilisant_culture";
			} else {
				List<Fertilisant_culture> fertilisant_culture = fertilisant_cultureService.ListFertilisant_culture(code_prod);
				model.addAttribute("fertilisant_culture", fertilisant_culture);
				return "data-externe/listFertilisant_culture";
			}
			
		} else if (data.equalsIgnoreCase("Information sur la culture")) {
			if (zone.equalsIgnoreCase("Tout")) {
				List<Info_parcelle_divers> info_parcelle_divers = info_parcelle_diversService.ListInfo_parcelle_diversAll();
				model.addAttribute("info_parcelle_divers", info_parcelle_divers);
				return "data-externe/listInfo_parcelle_divers";
			} else if (code_fkt.equalsIgnoreCase("Tout")) {
				List<Info_parcelle_divers> info_parcelle_divers = info_parcelle_diversService.ListInfo_parcelle_diversAllFkt(zone);
				model.addAttribute("info_parcelle_divers", info_parcelle_divers);
				return "data-externe/listInfo_parcelle_divers";
			} else if (code_prod.equalsIgnoreCase("Tout")) {
				List<Info_parcelle_divers> info_parcelle_divers = info_parcelle_diversService.ListInfo_parcelle_diversAllProd(code_fkt);
				model.addAttribute("info_parcelle_divers", info_parcelle_divers);
				return "data-externe/listInfo_parcelle_divers";
			} else {
				List<Info_parcelle_divers> info_parcelle_divers = info_parcelle_diversService.ListInfo_parcelle_divers(code_prod);
				model.addAttribute("info_parcelle_divers", info_parcelle_divers);
				return "data-externe/listInfo_parcelle_divers";
			}
			
		} else if (data.equalsIgnoreCase("Parasites et maladies")) {
			if (zone.equalsIgnoreCase("Tout")) {
				List<Parasite_maladie_divers> parasite_maladie_divers = parasite_maladie_diversService.ListParasite_maladie_diversAll();
				model.addAttribute("parasite_maladie_divers", parasite_maladie_divers);
				return "data-externe/listParasite_maladie_divers";
			} else if (code_fkt.equalsIgnoreCase("Tout")) {
				List<Parasite_maladie_divers> parasite_maladie_divers = parasite_maladie_diversService.ListParasite_maladie_diversAllFkt(zone);
				model.addAttribute("parasite_maladie_divers", parasite_maladie_divers);
				return "data-externe/listParasite_maladie_divers";
			} else if (code_prod.equalsIgnoreCase("Tout")) {
				List<Parasite_maladie_divers> parasite_maladie_divers = parasite_maladie_diversService.ListParasite_maladie_diversAllProd(code_fkt);
				model.addAttribute("parasite_maladie_divers", parasite_maladie_divers);
				return "data-externe/listParasite_maladie_divers";
			} else {
				List<Parasite_maladie_divers> parasite_maladie_divers = parasite_maladie_diversService.ListParasite_maladie_divers(code_prod);
				model.addAttribute("parasite_maladie_divers", parasite_maladie_divers);
				return "data-externe/listParasite_maladie_divers";
			}
			
		} else if (data.equalsIgnoreCase("Fértilisant vanille")) {
			if (zone.equalsIgnoreCase("Tout")) {
				List<Fertilisant_vanille> fertilisant_vanille = fertilisant_vanilleService.ListFertilisant_vanilleAll();
				model.addAttribute("fertilisant_vanille", fertilisant_vanille);
				return "data-externe/listFertilisant_vanille";
			} else if (code_fkt.equalsIgnoreCase("Tout")) {
				List<Fertilisant_vanille> fertilisant_vanille = fertilisant_vanilleService.ListFertilisant_vanilleAllFkt(zone);
				model.addAttribute("fertilisant_vanille", fertilisant_vanille);
				return "data-externe/listFertilisant_vanille";
			} else if (code_prod.equalsIgnoreCase("Tout")) {
				List<Fertilisant_vanille> fertilisant_vanille = fertilisant_vanilleService.ListFertilisant_vanilleAllProd(code_fkt);
				model.addAttribute("fertilisant_vanille", fertilisant_vanille);
				return "data-externe/listFertilisant_vanille";
			} else {
				List<Fertilisant_vanille> fertilisant_vanille = fertilisant_vanilleService.ListFertilisant_vanille(code_prod);
				model.addAttribute("fertilisant_vanille", fertilisant_vanille);
				return "data-externe/listFertilisant_vanille";
			}
			
		} else if (data.equalsIgnoreCase("Information generale sur la vanille")) {
			if (zone.equalsIgnoreCase("Tout")) {
				List<Info_generale> info_generale = info_generaleService.ListInfo_generaleAll();
				model.addAttribute("info_generale", info_generale);
				return "data-externe/listInfo_generale";
			} else if (code_fkt.equalsIgnoreCase("Tout")) {
				List<Info_generale> info_generale = info_generaleService.ListInfo_generaleAllFkt(zone);
				model.addAttribute("info_generale", info_generale);
				return "data-externe/listInfo_generale";
			} else if (code_prod.equalsIgnoreCase("Tout")) {
				List<Info_generale> info_generale = info_generaleService.ListInfo_generaleAllProd(code_fkt);
				model.addAttribute("info_generale", info_generale);
				return "data-externe/listInfo_generale";
			} else {
				List<Info_generale> info_generale = info_generaleService.ListInfo_generale(code_prod);
				model.addAttribute("info_generale", info_generale);
				return "data-externe/listInfo_generale";
			}
			
		} else if (data.equalsIgnoreCase("Info parcelle vanille")) {
			if (zone.equalsIgnoreCase("Tout")) {
				List<Info_parcelle> info_parcelle = info_parcelleService.ListInfo_parcelleAll();
				model.addAttribute("info_parcelle", info_parcelle);
				return "data-externe/listInfo_parcelle";
			} else if (code_fkt.equalsIgnoreCase("Tout")) {
				List<Info_parcelle> info_parcelle = info_parcelleService.ListInfo_parcelleAllFkt(zone);
				model.addAttribute("info_parcelle", info_parcelle);
				return "data-externe/listInfo_parcelle";
			} else if (code_prod.equalsIgnoreCase("Tout")) {
				List<Info_parcelle> info_parcelle = info_parcelleService.ListInfo_parcelleAllProd(code_fkt);
				model.addAttribute("info_parcelle", info_parcelle);
				return "data-externe/listInfo_parcelle";
			} else {
				List<Info_parcelle> info_parcelle = info_parcelleService.ListInfo_parcelle(code_prod);
				model.addAttribute("info_parcelle", info_parcelle);
				return "data-externe/listInfo_parcelle";
			}
			
		} else if (data.equalsIgnoreCase("Main d’œuvre (Vanille et autres spéculations)")) {
			if (zone.equalsIgnoreCase("Tout")) {
				List<Main_oeuvre> main_oeuvre = main_oeuvreService.ListMain_oeuvreAll();
				model.addAttribute("main_oeuvre", main_oeuvre);
				return "data-externe/listMain_oeuvre";
			} else if (code_fkt.equalsIgnoreCase("Tout")) {
				List<Main_oeuvre> main_oeuvre = main_oeuvreService.ListMain_oeuvreAllFkt(zone);
				model.addAttribute("main_oeuvre", main_oeuvre);
				return "data-externe/listMain_oeuvre";
			} else if (code_prod.equalsIgnoreCase("Tout")) {
				List<Main_oeuvre> main_oeuvre = main_oeuvreService.ListMain_oeuvreAllProd(code_fkt);
				model.addAttribute("main_oeuvre", main_oeuvre);
				return "data-externe/listMain_oeuvre";
			} else {
				List<Main_oeuvre> main_oeuvre = main_oeuvreService.ListMain_oeuvre(code_prod);
				model.addAttribute("main_oeuvre", main_oeuvre);
				return "data-externe/listMain_oeuvre";
			}
			
		} else if (data.equalsIgnoreCase("Parasites & maladies")) {
			if (zone.equalsIgnoreCase("Tout")) {
				List<Parasite_maladie> parasite_maladie = parasite_maladieService.ListParasite_maladieAll();
				model.addAttribute("parasite_maladie", parasite_maladie);
				return "data-externe/listParasite_maladie";
			} else if (code_fkt.equalsIgnoreCase("Tout")) {
				List<Parasite_maladie> parasite_maladie = parasite_maladieService.ListParasite_maladieAllFkt(zone);
				model.addAttribute("parasite_maladie", parasite_maladie);
				return "data-externe/listParasite_maladie";
			} else if (code_prod.equalsIgnoreCase("Tout")) {
				List<Parasite_maladie> parasite_maladie = parasite_maladieService.ListParasite_maladieAllProd(code_fkt);
				model.addAttribute("parasite_maladie", parasite_maladie);
				return "data-externe/listParasite_maladie";
			} else {
				List<Parasite_maladie> parasite_maladie = parasite_maladieService.ListParasite_maladie(code_prod);
				model.addAttribute("parasite_maladie", parasite_maladie);
				return "data-externe/listParasite_maladie";
			}
			
		} else if (data.equalsIgnoreCase("Questions & conseils")) {
			if (zone.equalsIgnoreCase("Tout")) {
				List<Question_conseil> question_conseil = question_conseilService.ListQuestion_conseilAll();
				model.addAttribute("question_conseil", question_conseil);
				return "data-externe/listQuestion_conseil";
			} else if (code_fkt.equalsIgnoreCase("Tout")) {
				List<Question_conseil> question_conseil = question_conseilService.ListQuestion_conseilAllFkt(zone);
				model.addAttribute("question_conseil", question_conseil);
				return "data-externe/listQuestion_conseil";
			} else if (code_prod.equalsIgnoreCase("Tout")) {
				List<Question_conseil> question_conseil = question_conseilService.ListQuestion_conseilAllProd(code_fkt);
				model.addAttribute("question_conseil", question_conseil);
				return "data-externe/listQuestion_conseil";
			} else {
				List<Question_conseil> question_conseil = question_conseilService.ListQuestion_conseil(code_prod);
				model.addAttribute("question_conseil", question_conseil);
				return "data-externe/listQuestion_conseil";
			}
			
		} else if (data.equalsIgnoreCase("Technique vanille")) {
			if (zone.equalsIgnoreCase("Tout")) {
				List<Technique_vanille> technique_vanille = technique_vanilleService.ListTechnique_vanilleAll();
				model.addAttribute("technique_vanille", technique_vanille);
				return "data-externe/listTechnique_vanille";
			} else if (code_fkt.equalsIgnoreCase("Tout")) {
				List<Technique_vanille> technique_vanille = technique_vanilleService.ListTechnique_vanilleAllFkt(zone);
				model.addAttribute("technique_vanille", technique_vanille);
				return "data-externe/listTechnique_vanille";
			} else if (code_prod.equalsIgnoreCase("Tout")) {
				List<Technique_vanille> technique_vanille = technique_vanilleService.ListTechnique_vanilleAllProd(code_fkt);
				model.addAttribute("technique_vanille", technique_vanille);
				return "data-externe/listTechnique_vanille";
			} else {
				List<Technique_vanille> technique_vanille = technique_vanilleService.ListTechnique_vanille(code_prod);
				model.addAttribute("technique_vanille", technique_vanille);
				return "data-externe/listTechnique_vanille";
			}
			
		} else if (data.equalsIgnoreCase("Formation sur la culture")) {
			if (zone.equalsIgnoreCase("Tout")) {
				List<Formation_culture> formation_culture = formation_cultureService.ListFormation_cultureAll();
				model.addAttribute("formation_culture", formation_culture);
				return "data-externe/listFormation_culture";
			} else if (code_fkt.equalsIgnoreCase("Tout")) {
				List<Formation_culture> formation_culture = formation_cultureService.ListFormation_cultureAllFkt(zone);
				model.addAttribute("formation_culture", formation_culture);
				return "data-externe/listFormation_culture";
			} else if (code_prod.equalsIgnoreCase("Tout")) {
				List<Formation_culture> formation_culture = formation_cultureService.ListFormation_cultureAllProd(code_fkt);
				model.addAttribute("formation_culture", formation_culture);
				return "data-externe/listFormation_culture";
			} else {
				List<Formation_culture> formation_culture = formation_cultureService.ListFormation_culture(code_prod);
				model.addAttribute("formation_culture", formation_culture);
				return "data-externe/listFormation_culture";
			}
			
		} else if (data.equalsIgnoreCase("Questions et conseils")) {
			if (zone.equalsIgnoreCase("Tout")) {
				List<Question_conseil_divers> question_conseil_divers = question_conseil_diversService.ListQuestion_conseil_diversAll();
				model.addAttribute("question_conseil_divers", question_conseil_divers);
				return "data-externe/listQuestion_conseil_divers";
			} else if (code_fkt.equalsIgnoreCase("Tout")) {
				List<Question_conseil_divers> question_conseil_divers = question_conseil_diversService.ListQuestion_conseil_diversAllFkt(zone);
				model.addAttribute("question_conseil_divers", question_conseil_divers);
				return "data-externe/listQuestion_conseil_divers";
			} else if (code_prod.equalsIgnoreCase("Tout")) {
				List<Question_conseil_divers> question_conseil_divers = question_conseil_diversService.ListQuestion_conseil_diversAllProd(code_fkt);
				model.addAttribute("question_conseil_divers", question_conseil_divers);
				return "data-externe/listQuestion_conseil_divers";
			} else {
				List<Question_conseil_divers> question_conseil_divers = question_conseil_diversService.ListQuestion_conseil_divers(code_prod);
				model.addAttribute("question_conseil_divers", question_conseil_divers);
				return "data-externe/listQuestion_conseil_divers";
			}
			
		} else {
			redirAttrs.addFlashAttribute("success", "Selectionner pour afficher les données");
			return "redirect:/dataExterne";
		}
	
	}
}
