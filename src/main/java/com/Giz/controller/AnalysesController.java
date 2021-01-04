package com.Giz.controller;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Giz.data.constants.theme.ListeWp;
import com.Giz.data.domain.Beneficiaire;
import com.Giz.data.domain.DocCap;
import com.Giz.data.domain.Formation;
import com.Giz.data.domain.Former;
import com.Giz.data.domain.GraphDist;
import com.Giz.data.domain.GraphDistrict;
import com.Giz.data.domain.TpsFormes;
import com.Giz.entity.User;
import com.Giz.repository.BeneficiaireRepository;
import com.Giz.service.UserService;
import com.Giz.service.metier.AtelierMFRService;
import com.Giz.service.metier.BeneficiaireService;
import com.Giz.service.metier.DocCapService;
import com.Giz.service.metier.FormerService;
import com.Giz.service.metier.PlateformeService;
import com.Giz.service.metier.Wp3ActivEcoJeuneService;
import com.Giz.service.metier.Wp3AgrDevMfrService;
import com.Giz.service.metier.Wp3CommitteeActifService;
import com.Giz.service.metier.Wp3ElevMfrService;
import com.Giz.service.metier.Wp3EppFramService;
import com.Giz.service.metier.Wp3EquipeTechMfrService;
import com.Giz.service.metier.Wp3FedeMfrService;
import com.Giz.service.metier.Wp3FormTechMetierJeuneService;
import com.Giz.service.metier.Wp3JeuneFormeMfrService;
import com.Giz.service.metier.Wp3JeunePathwayService;
import com.Giz.service.metier.Wp3PeerEducatorService;
import com.Giz.service.metier.Wp3SanteeCommService;
import com.Giz.service.metier.Wp3UniteElevJeuneService;




@Controller
public class AnalysesController {
	@Autowired
	UserService userService;
	
	@Autowired
	BeneficiaireService beneficiaireService;
	
	@Autowired
	FormerService formerService;
	
	@Autowired
	DocCapService docCapService;
	
	@Autowired
	PlateformeService plateformeService;
	
	@Autowired
	AtelierMFRService atelierMFRService;
	
	@Autowired
	Wp3ActivEcoJeuneService wp3ActivEcoJeuneService;
	
	@Autowired
	Wp3CommitteeActifService wp3CommitteeActifService;
	
	@Autowired
	Wp3FormTechMetierJeuneService wp3FormTechMetierJeuneService;
	
	@Autowired
	Wp3UniteElevJeuneService wp3UniteElevJeuneService;
	
	@Autowired
	Wp3ElevMfrService wp3ElevMfrService;
	
	@Autowired
	Wp3JeuneFormeMfrService wp3JeuneFormeMfrService;
	
	@Autowired
	Wp3FedeMfrService wp3FedeMfrService;
	
	@Autowired
	Wp3EquipeTechMfrService wp3EquipeTechMfrService;
	
	@Autowired
	Wp3AgrDevMfrService wp3AgrDevMfrService;
	
	@Autowired
	Wp3JeunePathwayService wp3JeunePathwayService;
	
	@Autowired
	Wp3EppFramService wp3EppFramService;
	
	@Autowired
	Wp3SanteeCommService wp3SanteeCommService;
	
	@Autowired
	Wp3PeerEducatorService wp3PeerEducatorService;
	
	public String canevas(int nbr_canevas) {
	    String result;
	    switch (nbr_canevas) {
	        case 52:
	            result = "CANEVAS ATELIERS/EVENEMENTS PROMOTIONNELS DU RESEAU DE MFR DANS LA REGION"; 
	            break;
	        case 53:
	            result = "CANEVAS DIALOGUE REGIONAL SUR L'ACCES AU FINANCEMENT";
	            break;
	        case 54:
	            result = "CANEVAS ATELIERS DE CAPITALISATION ET PARTAGE DES ACQUIS";
	            break;
	        case 55:
	            result = "CANEVAS ATELIERS/EVENEMENTS PROMOTIONNELS DE MAHAVELONA DANS LA SAVA";
	            break;
	        case 57:
	            result = "CANEVAS EXISTENCE DE DISPOSITIF CONCERTE DE SUIVI ET PROTECTION DES ENFANTS";
	            break;
	        case 58:
	            result = "CANEVAS PLATE FORME DE REFLEXION ET DE PLANIFICATION";
	            break;
	        case 59:
	            result = "CANEVAS PLATE FORME DE CONCERTATION ET DE PLANIFICAT";
	            break;
	        default:
	            result = "CANEVAS ATELIERS DE PARTAGES DES BONNES PRATIQUES ET OUTILS AUX PRODUCTEURS DE VANILLE";
	            break;
	    }
	    return result;
	}
	
	@RequestMapping("/analyses")
	public String analyses(Model model) {
		String[][] scList = ListeWp.wp();
		model.addAttribute("scList", scList);
		return "analyses";
	}
	
	@RequestMapping("/carte")
	public String carte(@RequestParam("theme") int theme,
			@RequestParam("date_fin") String date_fin, @RequestParam("subdivision") String subdivision, Model model) throws Exception {
		System.out.println("theme" + theme);
		java.sql.Date fin=  Date.valueOf(date_fin);
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentUserName = authentication.getName();
		User nomUser = userService.getUserByName(currentUserName);
		String type_atelier = canevas(theme);
		String date_debut = "2020-01-01";
		model.addAttribute("date_fin", fin);
		model.addAttribute("date_debut", date_debut);
		model.addAttribute("theme", theme);
		model.addAttribute("type_atelier", type_atelier);
		model.addAttribute("subdivision", subdivision);
		model.addAttribute("type", nomUser.getLastName());
		return "carte";
	}	
	
	@RequestMapping("/tableau")
	public String tableau(@RequestParam("theme") String theme,
			@RequestParam("date_fin") String date_fin, @RequestParam("subdivision") String subdivision, Model model) throws Exception {
		List<Object[]>  tps =null;
		String type_atelier = null;
		String nameCanevas = null;
		java.sql.Date debut_date=Date.valueOf("2020-01-01");
		java.sql.Date fin=  Date.valueOf(date_fin);
		switch (theme) {
		 case "49":
			  nameCanevas = "peer educator";
			  tps = wp3PeerEducatorService.ListGraphe(debut_date, fin);
		    break;
		 case "48":
			  nameCanevas = "service santé par communauté";
			  tps = wp3SanteeCommService.ListGraphe(debut_date, fin);
		    break;
		 case "47":
			  nameCanevas = "EPP FRAM draft";
			  tps = wp3EppFramService.ListGraphe(debut_date, fin);
		    break;
		 case "46":
			  nameCanevas = "jeune ayant terminé formation pathway";
			  tps = wp3JeunePathwayService.ListGraphe(debut_date, fin);
		    break;
		 case "45":
			  nameCanevas = "AGR développé MFR";
			  tps = wp3AgrDevMfrService.ListGraphe(debut_date, fin);
		    break;
		 case "44":
			  nameCanevas = "équipe technique MFR";
			  tps = wp3EquipeTechMfrService.ListGraphe(debut_date, fin);
		    break;
		 case "43":
			  nameCanevas = "fédération régionale MFR";
			  tps = wp3FedeMfrService.ListGraphe(debut_date, fin);
		    break;
		 case "42":
			  nameCanevas = "jeunes formés des MFR ";
			  tps = wp3JeuneFormeMfrService.ListGraphe(debut_date, fin);
		    break;
		 case "41":
			  nameCanevas = "élèves inscrits dans les MFR";
			  tps = wp3ElevMfrService.ListGraphe(debut_date, fin);
		    break;
		 case "40":
			  nameCanevas = "élévage en adoptant les bonnes pratiques";
			  tps = wp3UniteElevJeuneService.ListGraphe(debut_date, fin);
		    break;
		 case "39":
			  nameCanevas = "formation sur les techniques/metiers";
			  tps = wp3FormTechMetierJeuneService.ListGraphe(debut_date, fin);
		    break;
		  case "38":
			  nameCanevas = "youth committée actif";
			  tps = wp3CommitteeActifService.ListGraphe(debut_date, fin);
		    break;
		  case "37":
			  nameCanevas = "activité economique réalisée";
			  tps = wp3ActivEcoJeuneService.ListGraphe(debut_date, fin);
		    break;
		  case "51":
			  nameCanevas = "document de capitalisation";
			  tps = docCapService.ListGraphe(debut_date, fin);
		    break;
		  case "52":
			  nameCanevas = "ateliers MFR ";
			  type_atelier = "CANEVAS ATELIERS/EVENEMENTS PROMOTIONNELS DU RESEAU DE MFR DANS LA REGION";
			  tps = atelierMFRService.TpsAtelierMFR(type_atelier, debut_date, fin);
		    break;
		  case "53":
			  nameCanevas = "Dialogue région";
			  type_atelier = "CANEVAS DIALOGUE REGIONAL SUR L'ACCES AU FINANCEMENT";
			  tps = atelierMFRService.TpsAtelierMFR(type_atelier, debut_date, fin);
			  System.out.println("tps" + tps);
		    break;
		  case "54":
			  nameCanevas = "Atelier de capitalisation";
			  type_atelier = "CANEVAS ATELIERS DE CAPITALISATION ET PARTAGE DES ACQUIS";
			  tps = atelierMFRService.TpsAtelierMFR(type_atelier, debut_date, fin);
		    break;
		  case "55":
			  nameCanevas = "Atelier promotion Mahavelona";
			  type_atelier = "CANEVAS ATELIERS/EVENEMENTS PROMOTIONNELS DE MAHAVELONA DANS LA SAVA";
			  tps = atelierMFRService.TpsAtelierMFR(type_atelier, debut_date, fin);
		    break;
		  case "56":
			  nameCanevas = "Outils aux producteurs de vanille";
			  type_atelier = "CANEVAS ATELIERS DE PARTAGES DES BONNES PRATIQUES ET OUTILS AUX PRODUCTEURS DE VANILLE";
			  tps = atelierMFRService.TpsAtelierMFR(type_atelier, debut_date, fin);
		    break;
		  case "57":
			  nameCanevas = "Suivi et protection des enfants";
			  type_atelier =  "CANEVAS EXISTENCE DE DISPOSITIF CONCERTE DE SUIVI ET PROTECTION DES ENFANTS";
			  tps = plateformeService.TpsPlateforme(type_atelier, debut_date, fin);
		    break;
		  case "58":
			  nameCanevas = "plateforme de reflexion et planification";
			  type_atelier = "CANEVAS PLATE FORME DE REFLEXION ET DE PLANIFICATION DE L'AMELIORATION DE LA FORMATION PROFESSIONNELLE";
			  tps = plateformeService.TpsPlateforme(type_atelier, debut_date, fin);
		    break;
		  case "59":
			  nameCanevas = "plateforme de concertation et de planification";
			  type_atelier = "CANEVAS PLATE FORME DE CONCERTATION ET DE PLANIFICATION SUR L'ENVIRONNEMENT, BIODIVERSITE ET CHANGEMENT CLIMATIQUE DANS LA REGION SAVA";
			  tps = plateformeService.TpsPlateforme(type_atelier, debut_date, fin);
		    break;
		  default:
		    System.out.println("not exist");
		}
		model.addAttribute("nameCanevas", nameCanevas);
		model.addAttribute("tps", tps);
		return "tableau/listTableau";
	}	

	@RequestMapping("/graphe")
	public String graphe(@RequestParam("date_fin") String date_fin,@RequestParam("theme") String theme, @RequestParam("subdivision") String subdivision,Model model) throws ParseException {
		List<Object[]>  tps =null;
		 String type_atelier = null;
		int tot = 0;
		String nameCanevas = null;
		//List<GraphDistrict>  fr= formerService.ListFormees();
		List<Object[]> crosshair = null ;
		int camembertTot = 0;
		java.sql.Date debut_date=Date.valueOf("2020-01-01");
		java.sql.Date fin=  Date.valueOf(date_fin);
		switch (theme) {
		 case "49":
			  nameCanevas = "peer educator";
			  tot = (int) wp3PeerEducatorService.TotTotal(debut_date, fin);
			  crosshair = wp3PeerEducatorService.ListFetch();
			  camembertTot = (int) wp3PeerEducatorService.CamembertTot();
			  tps = wp3PeerEducatorService.ListGraphe(debut_date, fin);
		    break;
		 case "48":
			  nameCanevas = "service santé par communauté";
			  tot = (int) wp3SanteeCommService.TotTotal(debut_date, fin);
			  crosshair = wp3SanteeCommService.ListFetch();
			  camembertTot = (int) wp3SanteeCommService.CamembertTot();
			  tps = wp3SanteeCommService.ListGraphe(debut_date, fin);
		    break;
		 case "47":
			  nameCanevas = "EPP FRAM draft";
			  tot = (int) wp3EppFramService.TotTotal(debut_date, fin);
			  crosshair = wp3EppFramService.ListFetch();
			  camembertTot = (int) wp3EppFramService.CamembertTot();
			  tps = wp3EppFramService.ListGraphe(debut_date, fin);
		    break;
		 case "46":
			  nameCanevas = "jeune ayant terminé formation pathway";
			  tot = (int) wp3JeunePathwayService.TotTotal(debut_date, fin);
			  crosshair = wp3JeunePathwayService.ListFetch();
			  camembertTot = (int) wp3JeunePathwayService.CamembertTot();
			  tps = wp3JeunePathwayService.ListGraphe(debut_date, fin);
		    break;
		 case "45":
			  nameCanevas = "AGR développé MFR";
			  tot = (int) wp3AgrDevMfrService.TotTotal(debut_date, fin);
			  crosshair = wp3AgrDevMfrService.ListFetch();
			  camembertTot = (int) wp3AgrDevMfrService.CamembertTot();
			  tps = wp3AgrDevMfrService.ListGraphe(debut_date, fin);
		    break;
		 case "44":
			  nameCanevas = "équipe technique MFR";
			  tot = (int) wp3EquipeTechMfrService.TotTotal(debut_date, fin);
			  crosshair = wp3EquipeTechMfrService.ListFetch();
			  camembertTot = (int) wp3EquipeTechMfrService.CamembertTot();
			  tps = wp3EquipeTechMfrService.ListGraphe(debut_date, fin);
		    break;
		 case "43":
			  nameCanevas = "fédération régionale MFR";
			  tot = (int) wp3FedeMfrService.TotTotal(debut_date, fin);
			  crosshair = wp3FedeMfrService.ListFetch();
			  camembertTot = (int) wp3FedeMfrService.CamembertTot();
			  tps = wp3FedeMfrService.ListGraphe(debut_date, fin);
		    break;
		 case "42":
			  nameCanevas = "jeunes formés des MFR ";
			  tot = (int) wp3JeuneFormeMfrService.TotTotal(debut_date, fin);
			  crosshair = wp3JeuneFormeMfrService.ListFetch();
			  camembertTot = (int) wp3JeuneFormeMfrService.CamembertTot();
			  tps = wp3JeuneFormeMfrService.ListGraphe(debut_date, fin);
		    break;
		 case "41":
			  nameCanevas = "élèves inscrits dans les MFR";
			  tot = (int) wp3ElevMfrService.TotTotal(debut_date, fin);
			  crosshair = wp3ElevMfrService.ListFetch();
			  camembertTot = (int) wp3ElevMfrService.CamembertTot();
			  tps = wp3ElevMfrService.ListGraphe(debut_date, fin);
		    break;
		 case "40":
			  nameCanevas = "élévage en adoptant les bonnes pratiques";
			  tot = (int) wp3UniteElevJeuneService.TotTotal(debut_date, fin);
			  crosshair = wp3UniteElevJeuneService.ListFetch();
			  camembertTot = (int) wp3UniteElevJeuneService.CamembertTot();
			  tps = wp3UniteElevJeuneService.ListGraphe(debut_date, fin);
		    break;
		 case "39":
			  nameCanevas = "formation sur les techniques/metiers";
			  tot = (int) wp3FormTechMetierJeuneService.TotTotal(debut_date, fin);
			  crosshair = wp3FormTechMetierJeuneService.ListFetch();
			  camembertTot = (int) wp3FormTechMetierJeuneService.CamembertTot();
			  tps = wp3FormTechMetierJeuneService.ListGraphe(debut_date, fin);
		    break;
		  case "38":
			  nameCanevas = "youth committée actif";
			  tot = (int) wp3CommitteeActifService.TotTotal(debut_date, fin);
			  crosshair = wp3CommitteeActifService.ListFetch();
			  camembertTot = (int) wp3CommitteeActifService.CamembertTot();
			  tps = wp3CommitteeActifService.ListGraphe(debut_date, fin);
		    break;
		  case "37":
			  nameCanevas = "activité economique réalisée";
			  tot = (int) wp3ActivEcoJeuneService.TotTotal(debut_date, fin);
			  crosshair = wp3ActivEcoJeuneService.ListFetch();
			  camembertTot = (int) wp3ActivEcoJeuneService.CamembertTot();
			  tps = wp3ActivEcoJeuneService.ListGraphe(debut_date, fin);
		    break;
		  case "51":
			  nameCanevas = "document de capitalisation";
			  tot = (int) docCapService.TotTotal(debut_date, fin);
			  tps = docCapService.ListGraphe(debut_date, fin);
		    break;
		  case "52":
			  nameCanevas = "ateliers MFR ";
			  type_atelier = "CANEVAS ATELIERS/EVENEMENTS PROMOTIONNELS DU RESEAU DE MFR DANS LA REGION";
			  crosshair = atelierMFRService.ListAtelierFetch(type_atelier);
			  camembertTot = (int) atelierMFRService.TotAtelierMFR(type_atelier);
			  tot = (int) atelierMFRService.TotAtelierParticipant(type_atelier, debut_date, fin);
			  tps = atelierMFRService.TpsAtelierMFR(type_atelier, debut_date, fin);
		    break;
		  case "53":
			  nameCanevas = "Dialogue région";
			  type_atelier = "CANEVAS DIALOGUE REGIONAL SUR L'ACCES AU FINANCEMENT";
			  crosshair = atelierMFRService.ListAtelierFetch(type_atelier);
			  camembertTot = (int) atelierMFRService.TotAtelierMFR(type_atelier);
			  tot = (int) atelierMFRService.TotAtelierParticipant(type_atelier, debut_date, fin);
			  tps = atelierMFRService.TpsAtelierMFR(type_atelier, debut_date, fin);
			  System.out.println("tps" + tps);
		    break;
		  case "54":
			  nameCanevas = "Atelier de capitalisation";
			  type_atelier = "CANEVAS ATELIERS DE CAPITALISATION ET PARTAGE DES ACQUIS";
			  crosshair = atelierMFRService.ListAtelierFetch(type_atelier);
			  camembertTot = (int) atelierMFRService.TotAtelierMFR(type_atelier);
			  tot = (int) atelierMFRService.TotAtelierParticipant(type_atelier, debut_date, fin);
			  tps = atelierMFRService.TpsAtelierMFR(type_atelier, debut_date, fin);
		    break;
		  case "55":
			  nameCanevas = "Atelier promotion Mahavelona";
			  type_atelier = "CANEVAS ATELIERS/EVENEMENTS PROMOTIONNELS DE MAHAVELONA DANS LA SAVA";
			  crosshair = atelierMFRService.ListAtelierFetch(type_atelier);
			  camembertTot = (int) atelierMFRService.TotAtelierMFR(type_atelier);
			  tot = (int) atelierMFRService.TotAtelierParticipant(type_atelier, debut_date, fin);
			  tps = atelierMFRService.TpsAtelierMFR(type_atelier, debut_date, fin);
		    break;
		  case "56":
			  nameCanevas = "Outils aux producteurs de vanille";
			  type_atelier = "CANEVAS ATELIERS DE PARTAGES DES BONNES PRATIQUES ET OUTILS AUX PRODUCTEURS DE VANILLE";
			  crosshair = atelierMFRService.ListAtelierFetch(type_atelier);
			  camembertTot = (int) atelierMFRService.TotAtelierMFR(type_atelier);
			  tot = (int) atelierMFRService.TotAtelierParticipant(type_atelier, debut_date, fin);
			  tps = atelierMFRService.TpsAtelierMFR(type_atelier, debut_date, fin);
		    break;
		  case "57":
			  nameCanevas = "Suivi et protection des enfants";
			  type_atelier =  "CANEVAS EXISTENCE DE DISPOSITIF CONCERTE DE SUIVI ET PROTECTION DES ENFANTS";
			  crosshair = plateformeService.ListPlateformeFetch(type_atelier);
			  camembertTot = (int) plateformeService.TotPlateforme(type_atelier);
			  tot = (int) plateformeService.TotPlateformeParticipant(type_atelier, debut_date, fin);
			  tps = plateformeService.TpsPlateforme(type_atelier, debut_date, fin);
		    break;
		  case "58":
			  nameCanevas = "plateforme de reflexion et planification";
			  type_atelier = "CANEVAS PLATE FORME DE REFLEXION ET DE PLANIFICATION DE L'AMELIORATION DE LA FORMATION PROFESSIONNELLE";
			  crosshair = plateformeService.ListPlateformeFetch(type_atelier);
			  camembertTot = (int) plateformeService.TotPlateforme(type_atelier);
			  tot = (int) plateformeService.TotPlateformeParticipant(type_atelier, debut_date, fin);
			  tps = plateformeService.TpsPlateforme(type_atelier, debut_date, fin);
		    break;
		  case "59":
			  nameCanevas = "plateforme de concertation et de planification";
			  type_atelier = "CANEVAS PLATE FORME DE CONCERTATION ET DE PLANIFICATION SUR L'ENVIRONNEMENT, BIODIVERSITE ET CHANGEMENT CLIMATIQUE DANS LA REGION SAVA";
			  crosshair = plateformeService.ListPlateformeFetch(type_atelier);
			  camembertTot = (int) plateformeService.TotPlateforme(type_atelier);
			  tot = (int) plateformeService.TotPlateformeParticipant(type_atelier, debut_date, fin);
			  tps = plateformeService.TpsPlateforme(type_atelier, debut_date, fin);
		    break;
		  default:
		    System.out.println("not exist");
		}
		model.addAttribute("tot", tot);
		model.addAttribute("crosshair", crosshair);
		model.addAttribute("tps", tps);
		model.addAttribute("nameCanevas", nameCanevas);
		model.addAttribute("camembertTot", camembertTot);
		return "graphe";
	}


}
