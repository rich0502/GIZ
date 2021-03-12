package com.Giz.controller;

import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Giz.data.constants.theme.ListeWp;
import com.Giz.data.domain.Village;
import com.Giz.entity.User;
import com.Giz.service.UserService;
import com.Giz.service.metier.AtelierMFRService;
import com.Giz.service.metier.DocCapService;
import com.Giz.service.metier.PlateformeService;
import com.Giz.service.metier.VillageService;
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

	@Autowired
	VillageService villageService;

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
		List<Village> villages = villageService.ListVillage();
		model.addAttribute("scList", scList);
		model.addAttribute("villages", villages);
		return "analyses";
	}

	@RequestMapping("/carte")
	public String carte(@RequestParam("theme") int theme, @RequestParam("date_fin") String date_fin,
			@RequestParam("subdivision") String subdivision, @RequestParam("genre") String genre,
			@RequestParam(defaultValue = "null") String villages, Model model) throws Exception {
		System.out.println("genre" + genre);
		java.sql.Date fin = Date.valueOf(date_fin);
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentUserName = authentication.getName();
		User nomUser = userService.getUserByName(currentUserName);
		String xmlcheck = subdivision + genre;
		System.out.println("xmlcheck" + xmlcheck);
		URL url = new URL("http://localhost:8083/geoserver/styles/" + xmlcheck + ".xml");
		HttpURLConnection huc = (HttpURLConnection) url.openConnection();
		int responseCode = huc.getResponseCode();
		if (responseCode == 404) {
			xmlcheck = subdivision;
		}
		System.out.println("responseCode" + responseCode);
		String type_atelier = canevas(theme);
		String date_debut = "2020-01-01";
		model.addAttribute("date_fin", fin);
		model.addAttribute("date_debut", date_debut);
		model.addAttribute("theme", theme);
		model.addAttribute("type_atelier", type_atelier);
		model.addAttribute("subdivision", subdivision);
		model.addAttribute("villages", villages);
		model.addAttribute("genre", genre);
		model.addAttribute("xmlcheck", xmlcheck);
		model.addAttribute("type", nomUser.getLastName());
		return "carte";
	}

	@RequestMapping("/tableau")
	public String tableau(@RequestParam("theme") String theme,
			@RequestParam(defaultValue = "not exist") String villages, @RequestParam("genre") String genre,
			@RequestParam("date_fin") String date_fin, @RequestParam("subdivision") String subdivision, Model model)
			throws Exception {
		List<Object[]> tps = null;
		List<Object[]> tpsGenre = null;
		List<Object[]> tpsGenreAll = null;
		List<Object[]> tpsCom = null;
		List<Object[]> tpsComAll = null;
		List<Object[]> tpsDist = null;
		List<Object[]> tpsDistAll = null;
		List<Object[]> tpsComH = null;
		List<Object[]> tpsDistH = null;
		List<Object[]> tpsGenreH = null;
		List<Object[]> tpsComF = null;
		List<Object[]> tpsDistF = null;
		List<Object[]> tpsGenreF = null;
		String nb = null;
		List<Object[]> plate_village = null;
		List<Object[]> plate_com = null;
		List<Object[]> plate_dist = null;
		String type_atelier = null;
		String nameCanevas = null;
		List<String> params = null;
		java.sql.Date debut_date = Date.valueOf("2020-01-01");
		java.sql.Date fin = Date.valueOf(date_fin);
		System.out.println("subdivision" + subdivision);
		String replaceString = villages.replaceAll("\\s+", "");
		params = new ArrayList<String>(Arrays.asList(replaceString.split(";")));
		switch (theme) {
		case "37":
			nameCanevas = "activité economique réalisée";
			// ayant un champ nom_prenom count
			if (genre.isEmpty()) {
				if (subdivision.equalsIgnoreCase("district")) {
					tpsDistAll = wp3ActivEcoJeuneService.ListTableauDistAll(debut_date, fin);
				} else if (subdivision.equalsIgnoreCase("commune")) {
					tpsComAll = wp3ActivEcoJeuneService.ListTableauCommuneAll(debut_date, fin);
				} else {
					tpsGenreAll = wp3ActivEcoJeuneService.ListTableauAll(debut_date, fin, params);
				}
			} else {
				if (subdivision.equalsIgnoreCase("district")) {
					tpsDist = wp3ActivEcoJeuneService.ListTableauDist(debut_date, fin, genre);
				} else if (subdivision.equalsIgnoreCase("commune")) {
					tpsCom = wp3ActivEcoJeuneService.ListTableauCommune(debut_date, fin, genre);
				} else {
					tpsGenre = wp3ActivEcoJeuneService.ListTableau(debut_date, fin, params, genre);
				}
			}
			break;
		case "38":
			nameCanevas = "youth committée actif";
			// sum F et H
			if (genre.equalsIgnoreCase("F")) {
				if (subdivision.equalsIgnoreCase("district")) {
					tpsDistF = wp3CommitteeActifService.ListTableauDist(debut_date, fin);
				} else if (subdivision.equalsIgnoreCase("commune")) {
					tpsComF = wp3CommitteeActifService.ListTableauCommune(debut_date, fin);
				} else {
					tpsGenreF = wp3CommitteeActifService.ListTableau(debut_date, fin, params);
				}

			} else if (genre.equalsIgnoreCase("H")) {
				if (subdivision.equalsIgnoreCase("district")) {
					tpsDistH = wp3CommitteeActifService.ListTableauDist(debut_date, fin);
				} else if (subdivision.equalsIgnoreCase("commune")) {
					tpsComH = wp3CommitteeActifService.ListTableauCommune(debut_date, fin);
				} else {
					tpsGenreH = wp3CommitteeActifService.ListTableau(debut_date, fin, params);
				}
			} else {
				if (subdivision.equalsIgnoreCase("district")) {
					tpsDistAll = wp3CommitteeActifService.ListTableauDist(debut_date, fin);
				} else if (subdivision.equalsIgnoreCase("commune")) {
					tpsComAll = wp3CommitteeActifService.ListTableauCommune(debut_date, fin);
				} else {
					tpsGenreAll = wp3CommitteeActifService.ListTableau(debut_date, fin, params);
				}
			}
			break;
		case "39":
			nameCanevas = "formation sur les techniques/metiers";
			if (genre.isEmpty()) {
				if (subdivision.equalsIgnoreCase("district")) {
					tpsDistAll = wp3FormTechMetierJeuneService.ListTableauDistAll(debut_date, fin);
				} else if (subdivision.equalsIgnoreCase("commune")) {
					tpsComAll = wp3FormTechMetierJeuneService.ListTableauCommuneAll(debut_date, fin);
				} else {
					tpsGenreAll = wp3FormTechMetierJeuneService.ListTableauAll(debut_date, fin, params);
				}
			} else {
				if (subdivision.equalsIgnoreCase("district")) {
					tpsDist = wp3FormTechMetierJeuneService.ListTableauDist(debut_date, fin, genre);
				} else if (subdivision.equalsIgnoreCase("commune")) {
					tpsCom = wp3FormTechMetierJeuneService.ListTableauCommune(debut_date, fin, genre);
				} else {
					tpsGenre = wp3FormTechMetierJeuneService.ListTableau(debut_date, fin, params, genre);
				}
			}
			break;
		case "40":
			nameCanevas = "élévage en adoptant les bonnes pratiques";
			// ayant un champ nom_prenom count
			if (genre.isEmpty()) {
				if (subdivision.equalsIgnoreCase("district")) {
					tpsDistAll = wp3UniteElevJeuneService.ListTableauDistAll(debut_date, fin);
				} else if (subdivision.equalsIgnoreCase("commune")) {
					tpsComAll = wp3UniteElevJeuneService.ListTableauCommuneAll(debut_date, fin);
				} else {
					tpsGenreAll = wp3UniteElevJeuneService.ListTableauAll(debut_date, fin, params);
				}
			} else {
				if (subdivision.equalsIgnoreCase("district")) {
					tpsDist = wp3UniteElevJeuneService.ListTableauDist(debut_date, fin, genre);
				} else if (subdivision.equalsIgnoreCase("commune")) {
					tpsCom = wp3UniteElevJeuneService.ListTableauCommune(debut_date, fin, genre);
				} else {
					tpsGenre = wp3UniteElevJeuneService.ListTableau(debut_date, fin, params, genre);
				}
			}
			break;
		case "41":
			nameCanevas = "élèves inscrits dans les MFR";
			// ayant un champ nom_prenom count
			if (genre.isEmpty()) {
				if (subdivision.equalsIgnoreCase("district")) {
					tpsDistAll = wp3ElevMfrService.ListTableauDistAll(debut_date, fin);
				} else if (subdivision.equalsIgnoreCase("commune")) {
					tpsComAll = wp3ElevMfrService.ListTableauCommuneAll(debut_date, fin);
				} else {
					tpsGenreAll = wp3ElevMfrService.ListTableauAll(debut_date, fin, params);
				}
			} else {
				if (subdivision.equalsIgnoreCase("district")) {
					tpsDist = wp3ElevMfrService.ListTableauDist(debut_date, fin, genre);
				} else if (subdivision.equalsIgnoreCase("commune")) {
					tpsCom = wp3ElevMfrService.ListTableauCommune(debut_date, fin, genre);
				} else {
					tpsGenre = wp3ElevMfrService.ListTableau(debut_date, fin, params, genre);
				}
			}
			break;
		case "42":
			nameCanevas = "jeunes formés des MFR ";
			// ayant un champ nom_prenom count
			if (genre.isEmpty()) {
				if (subdivision.equalsIgnoreCase("district")) {
					tpsDistAll = wp3JeuneFormeMfrService.ListTableauDistAll(debut_date, fin);
				} else if (subdivision.equalsIgnoreCase("commune")) {
					tpsComAll = wp3JeuneFormeMfrService.ListTableauCommuneAll(debut_date, fin);
				} else {
					tpsGenreAll = wp3JeuneFormeMfrService.ListTableauAll(debut_date, fin, params);
				}
			} else {
				if (subdivision.equalsIgnoreCase("district")) {
					tpsDist = wp3JeuneFormeMfrService.ListTableauDist(debut_date, fin, genre);
				} else if (subdivision.equalsIgnoreCase("commune")) {
					tpsCom = wp3JeuneFormeMfrService.ListTableauCommune(debut_date, fin, genre);
				} else {
					tpsGenre = wp3JeuneFormeMfrService.ListTableau(debut_date, fin, params, genre);
				}
			}
			break;
		case "43":
			nameCanevas = "Federation régionale MFR";
			// ayant un champ nom_prenom count
			if (genre.isEmpty()) {
				if (subdivision.equalsIgnoreCase("district")) {
					tpsDistAll = wp3FedeMfrService.ListTableauDistAll(debut_date, fin);
				} else if (subdivision.equalsIgnoreCase("commune")) {
					tpsComAll = wp3FedeMfrService.ListTableauCommuneAll(debut_date, fin);
				} else {
					tpsGenreAll = wp3FedeMfrService.ListTableauAll(debut_date, fin, params);
				}
			} else {
				if (subdivision.equalsIgnoreCase("district")) {
					tpsDist = wp3FedeMfrService.ListTableauDist(debut_date, fin, genre);
				} else if (subdivision.equalsIgnoreCase("commune")) {
					tpsCom = wp3FedeMfrService.ListTableauCommune(debut_date, fin, genre);
				} else {
					tpsGenre = wp3FedeMfrService.ListTableau(debut_date, fin, params, genre);
				}
			}
			break;
		case "44":
			nameCanevas = "Equipe technique MFR";
			// ayant un champ nom_prenom count
			if (genre.isEmpty()) {
				if (subdivision.equalsIgnoreCase("district")) {
					tpsDistAll = wp3EquipeTechMfrService.ListTableauDistAll(debut_date, fin);
				} else if (subdivision.equalsIgnoreCase("commune")) {
					tpsComAll = wp3EquipeTechMfrService.ListTableauCommuneAll(debut_date, fin);
				} else {
					tpsGenreAll = wp3EquipeTechMfrService.ListTableauAll(debut_date, fin, params);
				}
			} else {
				if (subdivision.equalsIgnoreCase("district")) {
					tpsDist = wp3EquipeTechMfrService.ListTableauDist(debut_date, fin, genre);
				} else if (subdivision.equalsIgnoreCase("commune")) {
					tpsCom = wp3EquipeTechMfrService.ListTableauCommune(debut_date, fin, genre);
				} else {
					tpsGenre = wp3EquipeTechMfrService.ListTableau(debut_date, fin, params, genre);
				}
			}
			break;
		case "45":
			nameCanevas = "AGR développé MFR";
			// ayant un champ nom_prenom count
			if (genre.isEmpty()) {
				if (subdivision.equalsIgnoreCase("district")) {
					tpsDistAll = wp3AgrDevMfrService.ListTableauDistAll(debut_date, fin);
				} else if (subdivision.equalsIgnoreCase("commune")) {
					tpsComAll = wp3AgrDevMfrService.ListTableauCommuneAll(debut_date, fin);
				} else {
					tpsGenreAll = wp3AgrDevMfrService.ListTableauAll(debut_date, fin, params);
				}
			} else {
				if (subdivision.equalsIgnoreCase("district")) {
					tpsDist = wp3AgrDevMfrService.ListTableauDist(debut_date, fin, genre);
				} else if (subdivision.equalsIgnoreCase("commune")) {
					tpsCom = wp3AgrDevMfrService.ListTableauCommune(debut_date, fin, genre);
				} else {
					tpsGenre = wp3AgrDevMfrService.ListTableau(debut_date, fin, params, genre);
				}
			}
			break;
		case "46":
			nameCanevas = "jeune ayant terminé formation pathway";
			// ayant un champ nom_prenom count
			if (genre.isEmpty()) {
				if (subdivision.equalsIgnoreCase("district")) {
					tpsDistAll = wp3JeunePathwayService.ListTableauDistAll(debut_date, fin);
				} else if (subdivision.equalsIgnoreCase("commune")) {
					tpsComAll = wp3JeunePathwayService.ListTableauCommuneAll(debut_date, fin);
				} else {
					tpsGenreAll = wp3JeunePathwayService.ListTableauAll(debut_date, fin, params);
				}
			} else {
				if (subdivision.equalsIgnoreCase("district")) {
					tpsDist = wp3JeunePathwayService.ListTableauDist(debut_date, fin, genre);
				} else if (subdivision.equalsIgnoreCase("commune")) {
					tpsCom = wp3JeunePathwayService.ListTableauCommune(debut_date, fin, genre);
				} else {
					tpsGenre = wp3JeunePathwayService.ListTableau(debut_date, fin, params, genre);
				}
			}
			break;
		case "47":
			nameCanevas = "EPP FRAM draft";
			// ayant un champ nom_prenom count
			if (genre.isEmpty()) {
				if (subdivision.equalsIgnoreCase("district")) {
					tpsDistAll = wp3EppFramService.ListTableauDistAll(debut_date, fin);
				} else if (subdivision.equalsIgnoreCase("commune")) {
					tpsComAll = wp3EppFramService.ListTableauCommuneAll(debut_date, fin);
				} else {
					tpsGenreAll = wp3EppFramService.ListTableauAll(debut_date, fin, params);
				}
			} else {

				if (subdivision.equalsIgnoreCase("district")) {
					tpsDist = wp3EppFramService.ListTableauDist(debut_date, fin, genre);
				} else if (subdivision.equalsIgnoreCase("commune")) {
					tpsCom = wp3EppFramService.ListTableauCommune(debut_date, fin, genre);
				} else {
					tpsGenre = wp3EppFramService.ListTableau(debut_date, fin, params, genre);
				}
			}
			break;
		case "48":
			nameCanevas = "service santé par communauté";
			// ayant un champ nom_prenom count
			if (genre.isEmpty()) {
				if (subdivision.equalsIgnoreCase("district")) {
					tpsDistAll = wp3SanteeCommService.ListTableauDistAll(debut_date, fin);
				} else if (subdivision.equalsIgnoreCase("commune")) {
					tpsComAll = wp3SanteeCommService.ListTableauCommuneAll(debut_date, fin);
				} else {
					tpsGenreAll = wp3SanteeCommService.ListTableauAll(debut_date, fin, params);
				}
			} else {
				if (subdivision.equalsIgnoreCase("district")) {
					tpsDist = wp3SanteeCommService.ListTableauDist(debut_date, fin, genre);
				} else if (subdivision.equalsIgnoreCase("commune")) {
					tpsCom = wp3SanteeCommService.ListTableauCommune(debut_date, fin, genre);
				} else {
					tpsGenre = wp3SanteeCommService.ListTableau(debut_date, fin, params, genre);
				}
			}
			break;
		case "49":
			nameCanevas = "peer educator";
			// ayant un champ nom_prenom count
			if (genre.isEmpty()) {
				if (subdivision.equalsIgnoreCase("district")) {
					tpsDistAll = wp3PeerEducatorService.ListTableauDistAll(debut_date, fin);
				} else if (subdivision.equalsIgnoreCase("commune")) {
					tpsComAll = wp3PeerEducatorService.ListTableauCommuneAll(debut_date, fin);
				} else {
					tpsGenreAll = wp3PeerEducatorService.ListTableauAll(debut_date, fin, params);
				}
			} else {
				if (subdivision.equalsIgnoreCase("district")) {
					tpsDist = wp3PeerEducatorService.ListTableauDist(debut_date, fin, genre);
				} else if (subdivision.equalsIgnoreCase("commune")) {
					tpsCom = wp3PeerEducatorService.ListTableauCommune(debut_date, fin, genre);
				} else {
					tpsGenre = wp3PeerEducatorService.ListTableau(debut_date, fin, params, genre);
				}
			}
			break;

		case "51":
			nameCanevas = "document de capitalisation";
			tps = docCapService.ListGraphe(debut_date, fin);
			break;
		case "52":
			nameCanevas = "ateliers MFR ";
			type_atelier = "CANEVAS ATELIERS/EVENEMENTS PROMOTIONNELS DU RESEAU DE MFR DANS LA REGION";
			// sum F et H
			if (subdivision.equalsIgnoreCase("district")) {
				tpsDist = atelierMFRService.ListTableauDist(type_atelier, debut_date, fin);
			} else if (subdivision.equalsIgnoreCase("commune")) {
				tpsCom = atelierMFRService.ListTableauCommune(type_atelier, debut_date, fin);
			} else {
				tps = atelierMFRService.ListTableau(type_atelier, params, debut_date, fin);
			}
			break;
		case "53":
			nameCanevas = "Dialogue rÃ©gion";
			type_atelier = "CANEVAS DIALOGUE REGIONAL SUR L'ACCES AU FINANCEMENT";
			// sum F et H
			if (subdivision.equalsIgnoreCase("district")) {
				tpsDist = atelierMFRService.ListTableauDist(type_atelier, debut_date, fin);
			} else if (subdivision.equalsIgnoreCase("commune")) {
				tpsCom = atelierMFRService.ListTableauCommune(type_atelier, debut_date, fin);
			} else {
				tps = atelierMFRService.ListTableau(type_atelier, params, debut_date, fin);
			}
			break;
		case "54":
			nameCanevas = "Atelier de capitalisation";
			type_atelier = "CANEVAS ATELIERS DE CAPITALISATION ET PARTAGE DES ACQUIS";
			// sum F et H
			if (subdivision.equalsIgnoreCase("district")) {
				tpsDist = atelierMFRService.ListTableauDist(type_atelier, debut_date, fin);
			} else if (subdivision.equalsIgnoreCase("commune")) {
				tpsCom = atelierMFRService.ListTableauCommune(type_atelier, debut_date, fin);
			} else {
				tps = atelierMFRService.ListTableau(type_atelier, params, debut_date, fin);
			}
			break;
		case "55":
			nameCanevas = "Atelier promotion Mahavelona";
			type_atelier = "CANEVAS ATELIERS/EVENEMENTS PROMOTIONNELS DE MAHAVELONA DANS LA SAVA";
			// sum F et H
			if (subdivision.equalsIgnoreCase("district")) {
				tpsDist = atelierMFRService.ListTableauDist(type_atelier, debut_date, fin);
			} else if (subdivision.equalsIgnoreCase("commune")) {
				tpsCom = atelierMFRService.ListTableauCommune(type_atelier, debut_date, fin);
			} else {
				tps = atelierMFRService.ListTableau(type_atelier, params, debut_date, fin);
			}
			break;
		case "56":
			nameCanevas = "Outils aux producteurs de vanille";
			type_atelier = "CANEVAS ATELIERS DE PARTAGES DES BONNES PRATIQUES ET OUTILS AUX PRODUCTEURS DE VANILLE";
			// sum F et H
			if (subdivision.equalsIgnoreCase("district")) {
				tpsDist = atelierMFRService.ListTableauDist(type_atelier, debut_date, fin);
			} else if (subdivision.equalsIgnoreCase("commune")) {
				tpsCom = atelierMFRService.ListTableauCommune(type_atelier, debut_date, fin);
			} else {
				tps = atelierMFRService.ListTableau(type_atelier, params, debut_date, fin);
			}
			break;
		case "57":
			nb = "ok";
			nameCanevas = "Suivi et protection des enfants";
			type_atelier = "CANEVAS EXISTENCE DE DISPOSITIF CONCERTE DE SUIVI ET PROTECTION DES ENFANTS";
			if (subdivision.equalsIgnoreCase("district")) {
				tpsDist = plateformeService.ListTableauDist(type_atelier, debut_date, fin);
			} else if (subdivision.equalsIgnoreCase("commune")) {
				tpsCom = plateformeService.ListTableauCommune(type_atelier, debut_date, fin);
			} else {
				tps = plateformeService.ListTableau(type_atelier, params, debut_date, fin);
			}
			break;
		case "58":
			nb = "ok";
			nameCanevas = "plateforme de reflexion et planification";
			type_atelier = "CANEVAS PLATE FORME DE REFLEXION ET DE PLANIFICATION DE L'AMELIORATION DE LA FORMATION PROFESSIONNELLE";
			if (subdivision.equalsIgnoreCase("district")) {
				tpsDist = plateformeService.ListTableauDist(type_atelier, debut_date, fin);
			} else if (subdivision.equalsIgnoreCase("commune")) {
				tpsCom = plateformeService.ListTableauCommune(type_atelier, debut_date, fin);
			} else {
				tps = plateformeService.ListTableau(type_atelier, params, debut_date, fin);
			}
			break;
		case "59":
			nb = "ok";
			nameCanevas = "plateforme de concertation et de planification";
			type_atelier = "CANEVAS PLATE FORME DE CONCERTATION ET DE PLANIFICATION SUR L'ENVIRONNEMENT, BIODIVERSITE ET CHANGEMENT CLIMATIQUE DANS LA REGION SAVA";
			if (subdivision.equalsIgnoreCase("district")) {
				tpsDist = plateformeService.ListTableauDist(type_atelier, debut_date, fin);
			} else if (subdivision.equalsIgnoreCase("commune")) {
				tpsCom = plateformeService.ListTableauCommune(type_atelier, debut_date, fin);
			} else {
				tps = plateformeService.ListTableau(type_atelier, params, debut_date, fin);
			}
			break;
		default:
			System.out.println("not exist");
		}

		model.addAttribute("nameCanevas", nameCanevas);
		model.addAttribute("tpsGenre", tpsGenre);
		model.addAttribute("tpsGenreH", tpsGenreH);
		model.addAttribute("tpsGenreF", tpsGenreF);
		model.addAttribute("tpsGenreAll", tpsGenreAll);
		model.addAttribute("nb", nb);
		model.addAttribute("tps", tps);
		model.addAttribute("tpsCom", tpsCom);
		model.addAttribute("tpsComH", tpsComH);
		model.addAttribute("tpsComF", tpsComF);
		model.addAttribute("tpsComAll", tpsComAll);
		model.addAttribute("tpsDist", tpsDist);
		model.addAttribute("tpsDistH", tpsDistH);
		model.addAttribute("tpsDistF", tpsDistF);
		model.addAttribute("tpsDistAll", tpsDistAll);
		return "tableau/listTableau";
	}

	@RequestMapping("/graphe")
	public String graphe(@RequestParam("date_fin") String date_fin, @RequestParam("theme") String theme,
			@RequestParam("subdivision") String subdivision, Model model) throws ParseException {
		List<Object[]> tps = null;
		String type_atelier = null;
		int tot = 0;
		String nameCanevas = null;
		// List<GraphDistrict> fr= formerService.ListFormees();
		List<Object[]> crosshair = null;
		int camembertTot = 0;
		java.sql.Date debut_date = Date.valueOf("2020-01-01");
		java.sql.Date fin = Date.valueOf(date_fin);
		switch (theme) {
		case "49":
			nameCanevas = "peer educator";
			tot = (int) wp3PeerEducatorService.TotTotal(debut_date, fin);
			crosshair = wp3PeerEducatorService.ListFetch();
			camembertTot = (int) wp3PeerEducatorService.CamembertTot();
			tps = wp3PeerEducatorService.ListGraphe(debut_date, fin);
			break;
		case "48":
			nameCanevas = "service santeÌ� par communauteÌ�";
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
			nameCanevas = "jeune ayant termineÌ� formation pathway";
			tot = (int) wp3JeunePathwayService.TotTotal(debut_date, fin);
			crosshair = wp3JeunePathwayService.ListFetch();
			camembertTot = (int) wp3JeunePathwayService.CamembertTot();
			tps = wp3JeunePathwayService.ListGraphe(debut_date, fin);
			break;
		case "45":
			nameCanevas = "AGR deÌ�veloppeÌ� MFR";
			tot = (int) wp3AgrDevMfrService.TotTotal(debut_date, fin);
			crosshair = wp3AgrDevMfrService.ListFetch();
			camembertTot = (int) wp3AgrDevMfrService.CamembertTot();
			tps = wp3AgrDevMfrService.ListGraphe(debut_date, fin);
			break;
		case "44":
			nameCanevas = "eÌ�quipe technique MFR";
			tot = (int) wp3EquipeTechMfrService.TotTotal(debut_date, fin);
			crosshair = wp3EquipeTechMfrService.ListFetch();
			camembertTot = (int) wp3EquipeTechMfrService.CamembertTot();
			tps = wp3EquipeTechMfrService.ListGraphe(debut_date, fin);
			break;
		case "43":
			nameCanevas = "feÌ�deÌ�ration reÌ�gionale MFR";
			tot = (int) wp3FedeMfrService.TotTotal(debut_date, fin);
			crosshair = wp3FedeMfrService.ListFetch();
			camembertTot = (int) wp3FedeMfrService.CamembertTot();
			tps = wp3FedeMfrService.ListGraphe(debut_date, fin);
			break;
		case "42":
			nameCanevas = "jeunes formÃ©s des MFR ";
			tot = (int) wp3JeuneFormeMfrService.TotTotal(debut_date, fin);
			crosshair = wp3JeuneFormeMfrService.ListFetch();
			camembertTot = (int) wp3JeuneFormeMfrService.CamembertTot();
			tps = wp3JeuneFormeMfrService.ListGraphe(debut_date, fin);
			break;
		case "41":
			nameCanevas = "Ã©lÃ¨ves inscrits dans les MFR";
			tot = (int) wp3ElevMfrService.TotTotal(debut_date, fin);
			crosshair = wp3ElevMfrService.ListFetch();
			camembertTot = (int) wp3ElevMfrService.CamembertTot();
			tps = wp3ElevMfrService.ListGraphe(debut_date, fin);
			break;
		case "40":
			nameCanevas = "Ã©lÃ©vage en adoptant les bonnes pratiques";
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
			nameCanevas = "youth committÃ©e actif";
			tot = (int) wp3CommitteeActifService.TotTotal(debut_date, fin);
			crosshair = wp3CommitteeActifService.ListFetch();
			camembertTot = (int) wp3CommitteeActifService.CamembertTot();
			tps = wp3CommitteeActifService.ListGraphe(debut_date, fin);
			break;
		case "37":
			nameCanevas = "activitÃ© economique rÃ©alisÃ©e";
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
			nameCanevas = "Dialogue rÃ©gion";
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
			type_atelier = "CANEVAS EXISTENCE DE DISPOSITIF CONCERTE DE SUIVI ET PROTECTION DES ENFANTS";
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
