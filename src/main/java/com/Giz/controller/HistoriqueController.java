package com.Giz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Giz.data.constants.theme.ListeWp;
import com.Giz.service.metier.AtelierMFRService;
import com.Giz.service.metier.DocCapService;
import com.Giz.service.metier.PlateformeService;
import com.Giz.service.metier.ValiderService;
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
import com.Giz.service.metier.Wp3JeuneTechService;
import com.Giz.service.metier.Wp3PeerEducatorService;
import com.Giz.service.metier.Wp3SanteeCommService;
import com.Giz.service.metier.Wp3UniteElevJeuneService;

@Controller
public class HistoriqueController {
	
	@Autowired
	ValiderService validerservice;
	
	@Autowired
	Wp3ActivEcoJeuneService wp3ActivEcoJeuneService;

	@Autowired
	Wp3AgrDevMfrService wp3AgrDevMfrService;

	@Autowired
	Wp3CommitteeActifService wp3CommitteeActifService;

	@Autowired
	Wp3ElevMfrService wp3ElevMfrService;

	@Autowired
	Wp3EppFramService wp3EppFramService;

	@Autowired
	Wp3EquipeTechMfrService wp3EquipeTechMfrService;

	@Autowired
	Wp3FedeMfrService wp3FedeMfrService;

	@Autowired
	Wp3JeuneFormeMfrService wp3JeuneFormeMfrService;

	@Autowired
	Wp3JeunePathwayService wp3JeunePathwayService;

	@Autowired
	Wp3JeuneTechService wp3JeuneTechService;

	@Autowired
	Wp3PeerEducatorService wp3PeerEducatorService;

	@Autowired
	Wp3SanteeCommService wp3SanteeCommService;

	@Autowired
	Wp3UniteElevJeuneService wp3UniteElevJeuneService;

	@Autowired
	Wp3FormTechMetierJeuneService wp3FormTechMetierJeuneService;
	
	@Autowired
	DocCapService docCapService;
	
	@Autowired
	AtelierMFRService atelierMFRService;
	
	@Autowired
	PlateformeService plateformeService;
	
	@RequestMapping("/historique")
	public String historique(Model model) {
		String[][] scList = ListeWp.wp();
		model.addAttribute("scList", scList);
		return "historique/historique";
	}
	
	@RequestMapping("/historiqueList")
	public String historiqueList(@RequestParam("theme") String theme,Model model) {

		if (theme.equalsIgnoreCase("1")) {
			//detailList = wp3ActivEcoJeuneService.TableauCountDetailGenre();
		} else if (theme.equalsIgnoreCase("2")) {
			//detailList = wp3FormTechMetierJeuneService.TableauCountDetailGenre();
		} else if (theme.equalsIgnoreCase("3")) {
			//detailList = wp3UniteElevJeuneService.TableauCountDetailGenre();
		} else if (theme.equalsIgnoreCase("4")) {
			//detailList = wp3ElevMfrService.TableauCountDetailGenre();
		} else if (theme.equalsIgnoreCase("6")) {
			//detailList = wp3FedeMfrService.TableauCountDetailGenre();
		} else if (theme.equalsIgnoreCase("7")) {
			//detailList = wp3EquipeTechMfrService.TableauCountDetailGenre();
		} else if (theme.equalsIgnoreCase("8")) {
			//detailList = wp3AgrDevMfrService.TableauCountDetailGenre();
		} else if (theme.equalsIgnoreCase("9")) {
			//detailList = wp3JeunePathwayService.TableauCountDetailGenre();
		} else if (theme.equalsIgnoreCase("10")) {
			//detailList = wp3EppFramService.TableauCountDetailGenre();
		} else if (theme.equalsIgnoreCase("11")) {
			//detailList = wp3SanteeCommService.TableauCountDetailGenre();
		} else if (theme.equalsIgnoreCase("12")) {
			//detailList = wp3PeerEducatorService.TableauCountDetailGenre();
		} else if (theme.equalsIgnoreCase("13")) {
			//detailList = wp3PeerEducatorService.TableauCountDetailGenre();
		} else if (theme.equalsIgnoreCase("14")) {
			//detailList = wp3PeerEducatorService.TableauCountDetailGenre();
		} else if (theme.equalsIgnoreCase("15")) {
			//detailList = wp3PeerEducatorService.TableauCountDetailGenre();
		} else if (theme.equalsIgnoreCase("16")) {
			//detailList = wp3PeerEducatorService.TableauCountDetailGenre();
		} else if (theme.equalsIgnoreCase("17")) {
			//detailList = wp3PeerEducatorService.TableauCountDetailGenre();
		} else if (theme.equalsIgnoreCase("18")) {
			//detailList = wp3PeerEducatorService.TableauCountDetailGenre();
		} else if (theme.equalsIgnoreCase("19")) {
			//detailList = wp3PeerEducatorService.TableauCountDetailGenre();
		} else if (theme.equalsIgnoreCase("20")) {
			//detailList = wp3PeerEducatorService.TableauCountDetailGenre();
		} else if (theme.equalsIgnoreCase("21")) {
			//detailList = wp3PeerEducatorService.TableauCountDetailGenre();
		} else if (theme.equalsIgnoreCase("22")) {
			//detailList = wp3PeerEducatorService.TableauCountDetailGenre();
		} else if (theme.equalsIgnoreCase("23")) {
			//detailList = wp3PeerEducatorService.TableauCountDetailGenre();
		} else if (theme.equalsIgnoreCase("24")) {
			//detailList = wp3PeerEducatorService.TableauCountDetailGenre();
		} else if (theme.equalsIgnoreCase("25")) {
			//detailList = wp3PeerEducatorService.TableauCountDetailGenre();
		} else if (theme.equalsIgnoreCase("26")) {
			//detailList = wp3PeerEducatorService.TableauCountDetailGenre();
		} else if (theme.equalsIgnoreCase("27")) {
			////detailList = wp3PeerEducatorService.TableauCountDetailGenre();
		} else if (theme.equalsIgnoreCase("28")) {
			//detailList = wp3PeerEducatorService.TableauCountDetailGenre();
		} else if (theme.equalsIgnoreCase("29")) {
			String titre="canevas lakile telo";
			List<Object[]> historiqueList = validerservice.historiqueList("L3");
			model.addAttribute("historiqueList", historiqueList);
			model.addAttribute("titre", titre);
		} else if (theme.equalsIgnoreCase("30")) {
			String titre="canevas VSLA Municipal";
			List<Object[]> historiqueList = validerservice.historiqueList("VSLA");
			model.addAttribute("historiqueList", historiqueList);
			model.addAttribute("titre", titre);
		} else if (theme.equalsIgnoreCase("31")) {
			String titre="canevas intégration de l'education";
			List<Object[]> historiqueList = validerservice.historiqueList("FBS");
			model.addAttribute("historiqueList", historiqueList);
			model.addAttribute("titre", titre);
		} else if (theme.equalsIgnoreCase("32")) {
			String titre="canevas mobile money";
			List<Object[]> historiqueList = validerservice.historiqueList("Mobile");
			model.addAttribute("historiqueList", historiqueList);
			model.addAttribute("titre", titre);
		} else if (theme.equalsIgnoreCase("33")) {
			String titre="canevas finance";
			List<Object[]> historiqueList = validerservice.historiqueList("Finance");
			model.addAttribute("historiqueList", historiqueList);
			model.addAttribute("titre", titre);
		} else if (theme.equalsIgnoreCase("34")) {
			String titre="canevas production";
			List<Object[]> historiqueList = validerservice.historiqueList("Producteur");
			model.addAttribute("historiqueList", historiqueList);
			model.addAttribute("titre", titre);
		} else if (theme.equalsIgnoreCase("35")) {
			String titre="canevas adhesion";
			List<Object[]> historiqueList = validerservice.historiqueList("Adhesion");
			model.addAttribute("historiqueList", historiqueList);
			model.addAttribute("titre", titre);
		} else if (theme.equalsIgnoreCase("36")) {
			String titre="canevas menage";
			List<Object[]> historiqueList = validerservice.historiqueList("Menage");
			model.addAttribute("historiqueList", historiqueList);
			model.addAttribute("titre", titre);
		} else if (theme.equalsIgnoreCase("37")) {
			String titre="canevas activité economique réalisée";
			List<Object[]> historiqueList = wp3ActivEcoJeuneService.historiqueList();
			model.addAttribute("historiqueList", historiqueList);
			model.addAttribute("titre", titre);
		} else if (theme.equalsIgnoreCase("38")) {
			String titre="canevas youth committée actif";
			List<Object[]> historiqueList = wp3CommitteeActifService.historiqueList();
			model.addAttribute("historiqueList", historiqueList);
			model.addAttribute("titre", titre);
		} else if (theme.equalsIgnoreCase("39")) {
			String titre="canevas formation sur les techniques/metiers";
			List<Object[]> historiqueList = wp3FormTechMetierJeuneService.historiqueList();
			model.addAttribute("historiqueList", historiqueList);
			model.addAttribute("titre", titre);
		} else if (theme.equalsIgnoreCase("40")) {
			String titre="élévage en adoptant les bonnes pratiques";
			List<Object[]> historiqueList = wp3UniteElevJeuneService.historiqueList();
			model.addAttribute("historiqueList", historiqueList);
			model.addAttribute("titre", titre);
		} else if (theme.equalsIgnoreCase("41")) {
			String titre="canevas élèves inscrits dans les MFR";
			List<Object[]> historiqueList = wp3ElevMfrService.historiqueList();
			model.addAttribute("historiqueList", historiqueList);
			model.addAttribute("titre", titre);
		} else if (theme.equalsIgnoreCase("42")) {
			String titre="canevas jeunes formés des MFR";
			List<Object[]> historiqueList = wp3JeuneFormeMfrService.historiqueList();
			model.addAttribute("historiqueList", historiqueList);
			model.addAttribute("titre", titre);
		} else if (theme.equalsIgnoreCase("43")) {
			String titre="canevas federation régionale MFR";
			List<Object[]> historiqueList = wp3FedeMfrService.historiqueList();
			model.addAttribute("historiqueList", historiqueList);
			model.addAttribute("titre", titre);
		} else if (theme.equalsIgnoreCase("44")) {
			String titre="canevas équipe technique MFR";
			List<Object[]> historiqueList = wp3EquipeTechMfrService.historiqueList();
			model.addAttribute("historiqueList", historiqueList);
			model.addAttribute("titre", titre);
		} else if (theme.equalsIgnoreCase("45")) {
			String titre="canevas AGR développé MFR";
			List<Object[]> historiqueList = wp3AgrDevMfrService.historiqueList();
			model.addAttribute("historiqueList", historiqueList);
			model.addAttribute("titre", titre);		
		} else if (theme.equalsIgnoreCase("46")) {
			String titre="canevas jeune ayant terminé formation pathway";
			List<Object[]> historiqueList = wp3JeunePathwayService.historiqueList();
			model.addAttribute("historiqueList", historiqueList);
			model.addAttribute("titre", titre);	
		} else if (theme.equalsIgnoreCase("47")) {
			String titre="canevas EPP FRAM draft";
			List<Object[]> historiqueList = wp3EppFramService.historiqueList();
			model.addAttribute("historiqueList", historiqueList);
			model.addAttribute("titre", titre);	
		} else if (theme.equalsIgnoreCase("48")) {
			String titre="canevas service santé par communauté";
			List<Object[]> historiqueList = wp3SanteeCommService.historiqueList();
			model.addAttribute("historiqueList", historiqueList);
			model.addAttribute("titre", titre);	
		} else if (theme.equalsIgnoreCase("49")) {
			String titre="canevas peer educator";
			List<Object[]> historiqueList = wp3PeerEducatorService.historiqueList();
			model.addAttribute("historiqueList", historiqueList);
			model.addAttribute("titre", titre);	
		} else if (theme.equalsIgnoreCase("51")) {
			String titre="canevas partage de document de capitalisation aux acteurs";
			List<Object[]> historiqueList = docCapService.historiqueList();
			model.addAttribute("historiqueList", historiqueList);
			model.addAttribute("titre", titre);	
		} else if (theme.equalsIgnoreCase("52")) {
			String titre="canevas ateliers/evenements promotionnels du reseau de mfr dans la region";
			List<Object[]> historiqueList = atelierMFRService.historiqueList("CANEVAS ATELIERS/EVENEMENTS PROMOTIONNELS DU RESEAU DE MFR DANS LA REGION");
			model.addAttribute("historiqueList", historiqueList);
			model.addAttribute("titre", titre);	
		} else if (theme.equalsIgnoreCase("53")) {
			String titre="canevas dialogue regional sur l'acces au financement";
			List<Object[]> historiqueList = atelierMFRService.historiqueList("CANEVAS DIALOGUE REGIONAL SUR L'ACCES AU FINANCEMENT");
			model.addAttribute("historiqueList", historiqueList);
			model.addAttribute("titre", titre);
		} else if (theme.equalsIgnoreCase("54")) {
			String titre="canevas ateliers de capitalisation et partage des acquis";
			List<Object[]> historiqueList = atelierMFRService.historiqueList("CANEVAS ATELIERS DE CAPITALISATION ET PARTAGE DES ACQUIS");
			model.addAttribute("historiqueList", historiqueList);
			model.addAttribute("titre", titre);
		} else if (theme.equalsIgnoreCase("55")) {
			String titre="canevas ateliers/evenements promotionnels de mahavelona dans la sava";
			List<Object[]> historiqueList = atelierMFRService.historiqueList("CANEVAS ATELIERS/EVENEMENTS PROMOTIONNELS DE MAHAVELONA DANS LA SAVA");
			model.addAttribute("historiqueList", historiqueList);
			model.addAttribute("titre", titre);
		} else if (theme.equalsIgnoreCase("56")) {
			String titre="canevas existence de dispositif concerte de suivi et protection des enfants";
			List<Object[]> historiqueList = atelierMFRService.historiqueList("CANEVAS ATELIERS DE PARTAGES DES BONNES PRATIQUES ET OUTILS AUX PRODUCTEURS DE VANILLE");
			model.addAttribute("historiqueList", historiqueList);
			model.addAttribute("titre", titre);
		} else if (theme.equalsIgnoreCase("57")) {
			String titre="canevas plate forme de reflexion et de planification de l'amelioration de la formation professionnelle";
			List<Object[]> historiqueList = plateformeService.historiqueList("CANEVAS EXISTENCE DE DISPOSITIF CONCERTE DE SUIVI ET PROTECTION DES ENFANTS");
			model.addAttribute("historiqueList", historiqueList);
			model.addAttribute("titre", titre);
		} else if (theme.equalsIgnoreCase("58")) {
			String titre="canevas plate forme de concertation et de planification sur l'environnement, biodiversite et changement climatique dans la region sava";
			List<Object[]> historiqueList = plateformeService.historiqueList("CANEVAS PLATE FORME DE REFLEXION ET DE PLANIFICATION DE L'AMELIORATION DE LA FORMATION PROFESSIONNELLE");
			model.addAttribute("historiqueList", historiqueList);
			model.addAttribute("titre", titre);
		} else if (theme.equalsIgnoreCase("59")) {
			String titre="canevas ateliers de partages des bonnes pratiques et outils aux producteurs de vanille";
			List<Object[]> historiqueList = plateformeService.historiqueList("CANEVAS PLATE FORME DE CONCERTATION ET DE PLANIFICATION SUR L'ENVIRONNEMENT, BIODIVERSITE ET CHANGEMENT CLIMATIQUE DANS LA REGION SAVA");
			model.addAttribute("historiqueList", historiqueList);
			model.addAttribute("titre", titre);
		}
		
			return "historique/historiqueList";
	}
	
	
}
