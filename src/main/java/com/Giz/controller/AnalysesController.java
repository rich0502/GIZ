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
import com.Giz.service.metier.ValiderService;
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
	ValiderService validerService;

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
		if (genre == "F") {
			genre = "H";
		} else {
			genre = "F";
		}
		java.sql.Date fin = Date.valueOf(date_fin);
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentUserName = authentication.getName();
		User nomUser = userService.getUserByName(currentUserName);
		String xmlcheck = subdivision + theme + "T";
		URL url = new URL("http://168.119.185.165:8080/geoserver/styles/" + xmlcheck + ".xml");
		HttpURLConnection huc = (HttpURLConnection) url.openConnection();
		int responseCode = huc.getResponseCode();
		if (responseCode == 404) {
			xmlcheck = subdivision + theme;
		}
		System.out.println("responseCode" + responseCode);
		System.out.println("xmlcheck" + xmlcheck);
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

	////////////////////////////////// WP2 DETAILS TABLEAU
	////////////////////////////////// /////////////////////////////////////////////////////

	// VILLAGE DETAIL TABLEAU AVEC ATRRIBUT SEXE

	@RequestMapping("/detailGenreCount")
	public String detailGenreCount(@RequestParam("village") String village, @RequestParam("canevas") String canevas,
			@RequestParam("sexe") String sexe, Model model) throws Exception {
		List<Object[]> detailList = validerService.TableauCountDetailGenre(village, canevas, sexe);
		model.addAttribute("detailList", detailList);
		return "tableau/TableauDetail";
	}

	@RequestMapping("/detailGenreCountAll")
	public String detailGenreCountAll(@RequestParam("village") String village, @RequestParam("canevas") String canevas,
			Model model) throws Exception {
		List<Object[]> detailList = validerService.TableauCountDetailGenreAll(village, canevas);
		model.addAttribute("detailList", detailList);
		return "tableau/TableauDetail";
	}

	// COMMUNE DETAIL TABLEAU AVEC ATRRIBUT SEXE

	@RequestMapping("/detailGenreCountComm")
	public String detailGenreCountComm(@RequestParam("commune") String commune, @RequestParam("canevas") String canevas,
			@RequestParam("sexe") String sexe, Model model) throws Exception {
		List<Object[]> detailList = validerService.TableauCountDetailGenreComm(commune, canevas, sexe);
		model.addAttribute("detailList", detailList);
		return "tableau/TableauDetail";
	}

	@RequestMapping("/detailGenreCountAllComm")
	public String detailGenreCountAllComm(@RequestParam("commune") String commune,
			@RequestParam("canevas") String canevas, Model model) throws Exception {
		List<Object[]> detailList = validerService.TableauCountDetailGenreAllComm(commune, canevas);
		model.addAttribute("detailList", detailList);
		return "tableau/TableauDetail";
	}

	// DISTRICT DETAIL TABLEAU AVEC ATRRIBUT SEXE

	@RequestMapping("/detailGenreCountDist")
	public String detailGenreCountDist(@RequestParam("district") String district,
			@RequestParam("canevas") String canevas, @RequestParam("sexe") String sexe, Model model) throws Exception {
		List<Object[]> detailList = validerService.TableauCountDetailGenreDist(district, canevas, sexe);
		model.addAttribute("detailList", detailList);
		return "tableau/TableauDetail";
	}

	@RequestMapping("/detailGenreCountAllDist")
	public String detailGenreCountAllDist(@RequestParam("district") String district,
			@RequestParam("canevas") String canevas, Model model) throws Exception {
		List<Object[]> detailList = validerService.TableauCountDetailGenreAllDist(district, canevas);
		model.addAttribute("detailList", detailList);
		return "tableau/TableauDetail";
	}

	////////////////////////////////// WP3 DETAILS TABLEAU
	////////////////////////////////// /////////////////////////////////////////////////////

	// PAR VILLAGE ET SEXE
	@RequestMapping("/detailWP3")
	public String detailWP3(@RequestParam("village") String village, @RequestParam("sexe") String sexe,
			@RequestParam("nameCanevas") String nameCanevas, Model model) throws Exception {
		List<Object[]> detailList = null;
		if (nameCanevas.equalsIgnoreCase("activité economique réalisée")) {
			detailList = wp3ActivEcoJeuneService.TableauCountDetailGenre(village, sexe);
		} else if (nameCanevas.equalsIgnoreCase("formation sur les techniques/metiers")) {
			detailList = wp3FormTechMetierJeuneService.TableauCountDetailGenre(village, sexe);
		} else if (nameCanevas.equalsIgnoreCase("élévage en adoptant les bonnes pratiques")) {
			detailList = wp3UniteElevJeuneService.TableauCountDetailGenre(village, sexe);
		} else if (nameCanevas.equalsIgnoreCase("élèves inscrits dans les MFR")) {
			detailList = wp3ElevMfrService.TableauCountDetailGenre(village, sexe);
		} else if (nameCanevas.equalsIgnoreCase("jeunes formés des MFR")) {
			detailList = wp3JeuneFormeMfrService.TableauCountDetailGenre(village, sexe);
		} else if (nameCanevas.equalsIgnoreCase("Federation régionale MFR")) {
			detailList = wp3FedeMfrService.TableauCountDetailGenre(village, sexe);
		} else if (nameCanevas.equalsIgnoreCase("Equipe technique MFR")) {
			detailList = wp3EquipeTechMfrService.TableauCountDetailGenre(village, sexe);
		} else if (nameCanevas.equalsIgnoreCase("AGR développé MFR")) {
			detailList = wp3AgrDevMfrService.TableauCountDetailGenre(village, sexe);
		} else if (nameCanevas.equalsIgnoreCase("jeune ayant terminé formation pathway")) {
			detailList = wp3JeunePathwayService.TableauCountDetailGenre(village, sexe);
		} else if (nameCanevas.equalsIgnoreCase("EPP FRAM draft")) {
			detailList = wp3EppFramService.TableauCountDetailGenre(village, sexe);
		} else if (nameCanevas.equalsIgnoreCase("service santé par communauté")) {
			detailList = wp3SanteeCommService.TableauCountDetailGenre(village, sexe);
		} else if (nameCanevas.equalsIgnoreCase("peer educator")) {
			detailList = wp3PeerEducatorService.TableauCountDetailGenre(village, sexe);
		}
		model.addAttribute("detailList", detailList);
		return "tableau/TableauDetail";
	}

	// PAR VILLAGE
	@RequestMapping("/detailWP3All")
	public String detailWP3All(@RequestParam("village") String village, @RequestParam("nameCanevas") String nameCanevas,
			Model model) throws Exception {
		List<Object[]> detailList = null;
		if (nameCanevas.equalsIgnoreCase("activité economique réalisée")) {
			detailList = wp3ActivEcoJeuneService.TableauCountDetailGenreAll(village);
		} else if (nameCanevas.equalsIgnoreCase("formation sur les techniques/metiers")) {
			detailList = wp3FormTechMetierJeuneService.TableauCountDetailGenreAll(village);
		} else if (nameCanevas.equalsIgnoreCase("élévage en adoptant les bonnes pratiques")) {
			detailList = wp3UniteElevJeuneService.TableauCountDetailGenreAll(village);
		} else if (nameCanevas.equalsIgnoreCase("élèves inscrits dans les MFR")) {
			detailList = wp3ElevMfrService.TableauCountDetailGenreAll(village);
		} else if (nameCanevas.equalsIgnoreCase("jeunes formés des MFR")) {
			detailList = wp3JeuneFormeMfrService.TableauCountDetailGenreAll(village);
		} else if (nameCanevas.equalsIgnoreCase("Federation régionale MFR")) {
			detailList = wp3FedeMfrService.TableauCountDetailGenreAll(village);
		} else if (nameCanevas.equalsIgnoreCase("Equipe technique MFR")) {
			detailList = wp3EquipeTechMfrService.TableauCountDetailGenreAll(village);
		} else if (nameCanevas.equalsIgnoreCase("AGR développé MFR")) {
			detailList = wp3AgrDevMfrService.TableauCountDetailGenreAll(village);
		} else if (nameCanevas.equalsIgnoreCase("jeune ayant terminé formation pathway")) {
			detailList = wp3JeunePathwayService.TableauCountDetailGenreAll(village);
		} else if (nameCanevas.equalsIgnoreCase("EPP FRAM draft")) {
			detailList = wp3EppFramService.TableauCountDetailGenreAll(village);
		} else if (nameCanevas.equalsIgnoreCase("service santé par communauté")) {
			detailList = wp3SanteeCommService.TableauCountDetailGenreAll(village);
		} else if (nameCanevas.equalsIgnoreCase("peer educator")) {
			detailList = wp3PeerEducatorService.TableauCountDetailGenreAll(village);
		}
		model.addAttribute("detailList", detailList);
		return "tableau/TableauDetail";
	}
	
	// PAR COMMUNE ET SEXE
	@RequestMapping("/detailWP3Comm")
	public String detailWP3Comm(@RequestParam("commune") String commune, @RequestParam("sexe") String sexe,
			@RequestParam("nameCanevas") String nameCanevas, Model model) throws Exception {
		List<Object[]> detailList = null;
		if (nameCanevas.equalsIgnoreCase("activité economique réalisée")) {
			detailList = wp3ActivEcoJeuneService.TableauCountDetailGenreComm(commune, sexe);
		} else if (nameCanevas.equalsIgnoreCase("formation sur les techniques/metiers")) {
			detailList = wp3FormTechMetierJeuneService.TableauCountDetailGenreComm(commune, sexe);
		} else if (nameCanevas.equalsIgnoreCase("élévage en adoptant les bonnes pratiques")) {
			detailList = wp3UniteElevJeuneService.TableauCountDetailGenreComm(commune, sexe);
		} else if (nameCanevas.equalsIgnoreCase("élèves inscrits dans les MFR")) {
			detailList = wp3ElevMfrService.TableauCountDetailGenreComm(commune, sexe);
		} else if (nameCanevas.equalsIgnoreCase("jeunes formés des MFR")) {
			detailList = wp3JeuneFormeMfrService.TableauCountDetailGenreComm(commune, sexe);
		} else if (nameCanevas.equalsIgnoreCase("Federation régionale MFR")) {
			detailList = wp3FedeMfrService.TableauCountDetailGenreComm(commune, sexe);
		} else if (nameCanevas.equalsIgnoreCase("Equipe technique MFR")) {
			detailList = wp3EquipeTechMfrService.TableauCountDetailGenreComm(commune, sexe);
		} else if (nameCanevas.equalsIgnoreCase("AGR développé MFR")) {
			detailList = wp3AgrDevMfrService.TableauCountDetailGenreComm(commune, sexe);
		} else if (nameCanevas.equalsIgnoreCase("jeune ayant terminé formation pathway")) {
			detailList = wp3JeunePathwayService.TableauCountDetailGenreComm(commune, sexe);
		} else if (nameCanevas.equalsIgnoreCase("EPP FRAM draft")) {
			detailList = wp3EppFramService.TableauCountDetailGenreComm(commune, sexe);
		} else if (nameCanevas.equalsIgnoreCase("service santé par communauté")) {
			detailList = wp3SanteeCommService.TableauCountDetailGenreComm(commune, sexe);
		} else if (nameCanevas.equalsIgnoreCase("peer educator")) {
			detailList = wp3PeerEducatorService.TableauCountDetailGenreComm(commune, sexe);
		}
		model.addAttribute("detailList", detailList);
		return "tableau/TableauDetail";
	}

	// PAR COMMUNE
	@RequestMapping("/detailWP3AllComm")
	public String detailWP3AllComm(@RequestParam("commune") String commune, @RequestParam("nameCanevas") String nameCanevas,
			Model model) throws Exception {
		List<Object[]> detailList = null;
		if (nameCanevas.equalsIgnoreCase("activité economique réalisée")) {
			detailList = wp3ActivEcoJeuneService.TableauCountDetailGenreAllComm(commune);
		} else if (nameCanevas.equalsIgnoreCase("formation sur les techniques/metiers")) {
			detailList = wp3FormTechMetierJeuneService.TableauCountDetailGenreAllComm(commune);
		} else if (nameCanevas.equalsIgnoreCase("élévage en adoptant les bonnes pratiques")) {
			detailList = wp3UniteElevJeuneService.TableauCountDetailGenreAllComm(commune);
		} else if (nameCanevas.equalsIgnoreCase("élèves inscrits dans les MFR")) {
			detailList = wp3ElevMfrService.TableauCountDetailGenreAllComm(commune);
		} else if (nameCanevas.equalsIgnoreCase("jeunes formés des MFR")) {
			detailList = wp3JeuneFormeMfrService.TableauCountDetailGenreAllComm(commune);
		} else if (nameCanevas.equalsIgnoreCase("Federation régionale MFR")) {
			detailList = wp3FedeMfrService.TableauCountDetailGenreAllComm(commune);
		} else if (nameCanevas.equalsIgnoreCase("Equipe technique MFR")) {
			detailList = wp3EquipeTechMfrService.TableauCountDetailGenreAllComm(commune);
		} else if (nameCanevas.equalsIgnoreCase("AGR développé MFR")) {
			detailList = wp3AgrDevMfrService.TableauCountDetailGenreAllComm(commune);
		} else if (nameCanevas.equalsIgnoreCase("jeune ayant terminé formation pathway")) {
			detailList = wp3JeunePathwayService.TableauCountDetailGenreAllComm(commune);
		} else if (nameCanevas.equalsIgnoreCase("EPP FRAM draft")) {
			detailList = wp3EppFramService.TableauCountDetailGenreAllComm(commune);
		} else if (nameCanevas.equalsIgnoreCase("service santé par communauté")) {
			detailList = wp3SanteeCommService.TableauCountDetailGenreAllComm(commune);
		} else if (nameCanevas.equalsIgnoreCase("peer educator")) {
			detailList = wp3PeerEducatorService.TableauCountDetailGenreAllComm(commune);
		}
		model.addAttribute("detailList", detailList);
		return "tableau/TableauDetail";
	}
	
	// PAR DISTRICT ET SEXE
		@RequestMapping("/detailWP3Dist")
		public String detailWP3Dist(@RequestParam("district") String district, @RequestParam("sexe") String sexe,
				@RequestParam("nameCanevas") String nameCanevas, Model model) throws Exception {
			List<Object[]> detailList = null;
			if (nameCanevas.equalsIgnoreCase("activité economique réalisée")) {
				detailList = wp3ActivEcoJeuneService.TableauCountDetailGenreDist(district, sexe);
			} else if (nameCanevas.equalsIgnoreCase("formation sur les techniques/metiers")) {
				detailList = wp3FormTechMetierJeuneService.TableauCountDetailGenreDist(district, sexe);
			} else if (nameCanevas.equalsIgnoreCase("élévage en adoptant les bonnes pratiques")) {
				detailList = wp3UniteElevJeuneService.TableauCountDetailGenreDist(district, sexe);
			} else if (nameCanevas.equalsIgnoreCase("élèves inscrits dans les MFR")) {
				detailList = wp3ElevMfrService.TableauCountDetailGenreDist(district, sexe);
			} else if (nameCanevas.equalsIgnoreCase("jeunes formés des MFR")) {
				detailList = wp3JeuneFormeMfrService.TableauCountDetailGenreDist(district, sexe);
			} else if (nameCanevas.equalsIgnoreCase("Federation régionale MFR")) {
				detailList = wp3FedeMfrService.TableauCountDetailGenreDist(district, sexe);
			} else if (nameCanevas.equalsIgnoreCase("Equipe technique MFR")) {
				detailList = wp3EquipeTechMfrService.TableauCountDetailGenreDist(district, sexe);
			} else if (nameCanevas.equalsIgnoreCase("AGR développé MFR")) {
				detailList = wp3AgrDevMfrService.TableauCountDetailGenreDist(district, sexe);
			} else if (nameCanevas.equalsIgnoreCase("jeune ayant terminé formation pathway")) {
				detailList = wp3JeunePathwayService.TableauCountDetailGenreDist(district, sexe);
			} else if (nameCanevas.equalsIgnoreCase("EPP FRAM draft")) {
				detailList = wp3EppFramService.TableauCountDetailGenreDist(district, sexe);
			} else if (nameCanevas.equalsIgnoreCase("service santé par communauté")) {
				detailList = wp3SanteeCommService.TableauCountDetailGenreDist(district, sexe);
			} else if (nameCanevas.equalsIgnoreCase("peer educator")) {
				detailList = wp3PeerEducatorService.TableauCountDetailGenreDist(district, sexe);
			}
			model.addAttribute("detailList", detailList);
			return "tableau/TableauDetail";
		}

		// PAR COMMUNE
		@RequestMapping("/detailWP3AllDist")
		public String detailWP3AllDist(@RequestParam("district") String district, @RequestParam("nameCanevas") String nameCanevas,
				Model model) throws Exception {
			List<Object[]> detailList = null;
			if (nameCanevas.equalsIgnoreCase("activité economique réalisée")) {
				detailList = wp3ActivEcoJeuneService.TableauCountDetailGenreAllDist(district);
			} else if (nameCanevas.equalsIgnoreCase("formation sur les techniques/metiers")) {
				detailList = wp3FormTechMetierJeuneService.TableauCountDetailGenreAllDist(district);
			} else if (nameCanevas.equalsIgnoreCase("élévage en adoptant les bonnes pratiques")) {
				detailList = wp3UniteElevJeuneService.TableauCountDetailGenreAllDist(district);
			} else if (nameCanevas.equalsIgnoreCase("élèves inscrits dans les MFR")) {
				detailList = wp3ElevMfrService.TableauCountDetailGenreAllDist(district);
			} else if (nameCanevas.equalsIgnoreCase("jeunes formés des MFR")) {
				detailList = wp3JeuneFormeMfrService.TableauCountDetailGenreAllDist(district);
			} else if (nameCanevas.equalsIgnoreCase("Federation régionale MFR")) {
				detailList = wp3FedeMfrService.TableauCountDetailGenreAllDist(district);
			} else if (nameCanevas.equalsIgnoreCase("Equipe technique MFR")) {
				detailList = wp3EquipeTechMfrService.TableauCountDetailGenreAllDist(district);
			} else if (nameCanevas.equalsIgnoreCase("AGR développé MFR")) {
				detailList = wp3AgrDevMfrService.TableauCountDetailGenreAllDist(district);
			} else if (nameCanevas.equalsIgnoreCase("jeune ayant terminé formation pathway")) {
				detailList = wp3JeunePathwayService.TableauCountDetailGenreAllDist(district);
			} else if (nameCanevas.equalsIgnoreCase("EPP FRAM draft")) {
				detailList = wp3EppFramService.TableauCountDetailGenreAllDist(district);
			} else if (nameCanevas.equalsIgnoreCase("service santé par communauté")) {
				detailList = wp3SanteeCommService.TableauCountDetailGenreAllDist(district);
			} else if (nameCanevas.equalsIgnoreCase("peer educator")) {
				detailList = wp3PeerEducatorService.TableauCountDetailGenreAllDist(district);
			}
			model.addAttribute("detailList", detailList);
			return "tableau/TableauDetail";
		}

	
	////////////////////////////////// TABLEAU WP2, WP3, WP4 //////////////////////////////////

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
		List<Object[]> tpsDC = null;
		List<Object[]> tpsGenreWP3 = null;
		List<Object[]> tpsGenreAllWP3 = null;
		List<Object[]> tpsComWP3 = null;
		List<Object[]> tpsComAllWP3 = null;
		List<Object[]> tpsDistWP3 = null;
		List<Object[]> tpsDistAllWP3 = null;
		List<Object[]> tpsComAllSum = null;
		List<Object[]> tpsDistAllSum = null;
		List<Object[]> tpsGenreAllSum = null;
		String nb = null;
		String namePlace = null;
		List<Object[]> plate_village = null;
		List<Object[]> plate_com = null;
		List<Object[]> plate_dist = null;
		String type_atelier = null;
		String nameCanevas = null;
		String canevas = null;
		List<Object[]> tpsNosexe = null;
		List<String> params = null;
		java.sql.Date debut_date = Date.valueOf("2020-01-01");
		java.sql.Date fin = Date.valueOf(date_fin);
		System.out.println("subdivision" + subdivision);
		String replaceString = villages.replaceAll("\\s+", "");
		params = new ArrayList<String>(Arrays.asList(replaceString.split(";")));
		switch (theme) {
		case "29":
			nameCanevas = "Lakile telo";
			canevas = "L3";
			// sum F et H
			if (genre.equalsIgnoreCase("F")) {
				if (subdivision.equalsIgnoreCase("district")) {
					tpsDistF = validerService.ListTableauDistSum(debut_date, fin, canevas);
				} else if (subdivision.equalsIgnoreCase("commune")) {
					tpsComF = validerService.ListTableauCommuneSum(debut_date, fin, canevas);
				} else {
					tpsGenreF = validerService.ListTableauSum(debut_date, fin, params, canevas);
				}

			} else if (genre.equalsIgnoreCase("H")) {
				if (subdivision.equalsIgnoreCase("district")) {
					tpsDistH = validerService.ListTableauDistSum(debut_date, fin, canevas);
				} else if (subdivision.equalsIgnoreCase("commune")) {
					tpsComH = validerService.ListTableauCommuneSum(debut_date, fin, canevas);
				} else {
					tpsGenreH = validerService.ListTableauSum(debut_date, fin, params, canevas);
				}
			} else {
				if (subdivision.equalsIgnoreCase("district")) {
					tpsDistAllSum = validerService.ListTableauDistSum(debut_date, fin, canevas);
				} else if (subdivision.equalsIgnoreCase("commune")) {
					tpsComAllSum = validerService.ListTableauCommuneSum(debut_date, fin, canevas);
				} else {
					tpsGenreAllSum = validerService.ListTableauSum(debut_date, fin, params, canevas);
				}
			}
			break;
		case "30":
			nameCanevas = "VSLA Municipal";
			canevas = "VSLA";
			// ayant un champ nom_prenom count
			if (subdivision.equalsIgnoreCase("district")) {
				namePlace = "District";
				tpsNosexe = validerService.ListTableauDistCountNoSexe(debut_date, fin, canevas);
			} else if (subdivision.equalsIgnoreCase("commune")) {
				namePlace = "Commune";
				tpsNosexe = validerService.ListTableauCommuneCountNoSexe(debut_date, fin, canevas);
			} else {
				namePlace = "Village";
				tpsNosexe = validerService.ListTableauCountNoSexe(debut_date, fin, params, canevas);
			}
			break;
		case "31":
			nameCanevas = "Integration de l'education";
			canevas = "FBS";
			// ayant un champ nom_prenom count
			if (subdivision.equalsIgnoreCase("district")) {
				namePlace = "District";
				tpsNosexe = validerService.ListTableauDistCountNoSexe(debut_date, fin, canevas);
			} else if (subdivision.equalsIgnoreCase("commune")) {
				namePlace = "Commune";
				tpsNosexe = validerService.ListTableauCommuneCountNoSexe(debut_date, fin, canevas);
			} else {
				namePlace = "Village";
				tpsNosexe = validerService.ListTableauCountNoSexe(debut_date, fin, params, canevas);
			}
			break;
		case "32":
			nameCanevas = "Mobile money";
			canevas = "Mobile";
			// ayant un champ nom_prenom count
			if (genre.isEmpty()) {
				if (subdivision.equalsIgnoreCase("district")) {
					tpsDistAll = validerService.ListTableauDistAllCount(debut_date, fin, canevas);
				} else if (subdivision.equalsIgnoreCase("commune")) {
					tpsComAll = validerService.ListTableauCommuneAllCount(debut_date, fin, canevas);
				} else {
					tpsGenreAll = validerService.ListTableauAllCount(debut_date, fin, params, canevas);
				}
			} else {
				if (subdivision.equalsIgnoreCase("district")) {
					tpsDist = validerService.ListTableauDistCount(debut_date, fin, genre, canevas);
				} else if (subdivision.equalsIgnoreCase("commune")) {
					tpsCom = validerService.ListTableauCommuneCount(debut_date, fin, genre, canevas);
				} else {
					tpsGenre = validerService.ListTableauCount(debut_date, fin, params, genre, canevas);
				}
			}
			break;
		case "33":
			nameCanevas = "Finance";
			canevas = "Finance";
			// ayant un champ nom_prenom count
			if (genre.isEmpty()) {
				if (subdivision.equalsIgnoreCase("district")) {
					tpsDistAll = validerService.ListTableauDistAllCount(debut_date, fin, canevas);
				} else if (subdivision.equalsIgnoreCase("commune")) {
					tpsComAll = validerService.ListTableauCommuneAllCount(debut_date, fin, canevas);
				} else {
					tpsGenreAll = validerService.ListTableauAllCount(debut_date, fin, params, canevas);
				}
			} else {
				if (subdivision.equalsIgnoreCase("district")) {
					tpsDist = validerService.ListTableauDistCount(debut_date, fin, genre, canevas);
				} else if (subdivision.equalsIgnoreCase("commune")) {
					tpsCom = validerService.ListTableauCommuneCount(debut_date, fin, genre, canevas);
				} else {
					tpsGenre = validerService.ListTableauCount(debut_date, fin, params, genre, canevas);
				}
			}
		case "34":
			nameCanevas = "Producteur";
			canevas = "Producteur";
			// ayant un champ nom_prenom count
			if (genre.isEmpty()) {
				if (subdivision.equalsIgnoreCase("district")) {
					tpsDistAll = validerService.ListTableauDistAllCountNoDate(canevas);
				} else if (subdivision.equalsIgnoreCase("commune")) {
					tpsComAll = validerService.ListTableauCommuneAllCountNoDate(canevas);
				} else {
					tpsGenreAll = validerService.ListTableauAllCountNoDate(params, canevas);
				}
			} else {
				if (subdivision.equalsIgnoreCase("district")) {
					tpsDist = validerService.ListTableauDistCountNoDate(genre, canevas);
				} else if (subdivision.equalsIgnoreCase("commune")) {
					tpsCom = validerService.ListTableauCommuneCountNoDate(genre, canevas);
				} else {
					tpsGenre = validerService.ListTableauCountNoDate(params, genre, canevas);
				}
			}
			break;
		case "35":
			nameCanevas = "Adhesion";
			canevas = "Adhesion";
			// ayant un champ nom_prenom count
			if (genre.isEmpty()) {
				if (subdivision.equalsIgnoreCase("district")) {
					tpsDistAll = validerService.ListTableauDistAllCount(debut_date, fin, canevas);
				} else if (subdivision.equalsIgnoreCase("commune")) {
					tpsComAll = validerService.ListTableauCommuneAllCount(debut_date, fin, canevas);
				} else {
					tpsGenreAll = validerService.ListTableauAllCount(debut_date, fin, params, canevas);
				}
			} else {
				if (subdivision.equalsIgnoreCase("district")) {
					tpsDist = validerService.ListTableauDistCount(debut_date, fin, genre, canevas);
				} else if (subdivision.equalsIgnoreCase("commune")) {
					tpsCom = validerService.ListTableauCommuneCount(debut_date, fin, genre, canevas);
				} else {
					tpsGenre = validerService.ListTableauCount(debut_date, fin, params, genre, canevas);
				}
			}
			break;
		case "36":
			nameCanevas = "Menage";
			canevas = "Menage";
			// ayant un champ nom_prenom count
			if (genre.isEmpty()) {
				if (subdivision.equalsIgnoreCase("district")) {
					tpsDistAll = validerService.ListTableauDistAllCountNoDate(canevas);
				} else if (subdivision.equalsIgnoreCase("commune")) {
					tpsComAll = validerService.ListTableauCommuneAllCountNoDate(canevas);
				} else {
					tpsGenreAll = validerService.ListTableauAllCountNoDate(params, canevas);
				}
			} else {
				if (subdivision.equalsIgnoreCase("district")) {
					tpsDist = validerService.ListTableauDistCountNoDate(genre, canevas);
				} else if (subdivision.equalsIgnoreCase("commune")) {
					tpsCom = validerService.ListTableauCommuneCountNoDate(genre, canevas);
				} else {
					tpsGenre = validerService.ListTableauCountNoDate(params, genre, canevas);
				}
			}
			break;
		case "37":
			nameCanevas = "activité economique réalisée";
			// ayant un champ nom_prenom count
			if (genre.isEmpty()) {
				if (subdivision.equalsIgnoreCase("district")) {
					tpsDistAllWP3 = wp3ActivEcoJeuneService.ListTableauDistAll(debut_date, fin);
				} else if (subdivision.equalsIgnoreCase("commune")) {
					tpsComAllWP3 = wp3ActivEcoJeuneService.ListTableauCommuneAll(debut_date, fin);
				} else {
					tpsGenreAllWP3 = wp3ActivEcoJeuneService.ListTableauAll(debut_date, fin, params);
				}
			} else {
				if (subdivision.equalsIgnoreCase("district")) {
					tpsDistWP3 = wp3ActivEcoJeuneService.ListTableauDist(debut_date, fin, genre);
				} else if (subdivision.equalsIgnoreCase("commune")) {
					tpsComWP3 = wp3ActivEcoJeuneService.ListTableauCommune(debut_date, fin, genre);
				} else {
					tpsGenreWP3 = wp3ActivEcoJeuneService.ListTableau(debut_date, fin, params, genre);
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
					tpsDistAllSum = wp3CommitteeActifService.ListTableauDist(debut_date, fin);
				} else if (subdivision.equalsIgnoreCase("commune")) {
					tpsComAllSum = wp3CommitteeActifService.ListTableauCommune(debut_date, fin);
				} else {
					tpsGenreAllSum = wp3CommitteeActifService.ListTableau(debut_date, fin, params);
				}
			}
			break;
		case "39":
			nameCanevas = "formation sur les techniques/metiers";
			if (genre.isEmpty()) {
				if (subdivision.equalsIgnoreCase("district")) {
					tpsDistAllWP3 = wp3FormTechMetierJeuneService.ListTableauDistAll(debut_date, fin);
				} else if (subdivision.equalsIgnoreCase("commune")) {
					tpsComAllWP3 = wp3FormTechMetierJeuneService.ListTableauCommuneAll(debut_date, fin);
				} else {
					tpsGenreAllWP3 = wp3FormTechMetierJeuneService.ListTableauAll(debut_date, fin, params);
				}
			} else {
				if (subdivision.equalsIgnoreCase("district")) {
					tpsDistWP3 = wp3FormTechMetierJeuneService.ListTableauDist(debut_date, fin, genre);
				} else if (subdivision.equalsIgnoreCase("commune")) {
					tpsComWP3 = wp3FormTechMetierJeuneService.ListTableauCommune(debut_date, fin, genre);
				} else {
					tpsGenreWP3 = wp3FormTechMetierJeuneService.ListTableau(debut_date, fin, params, genre);
				}
			}
			break;
		case "40":
			nameCanevas = "élévage en adoptant les bonnes pratiques";
			// ayant un champ nom_prenom count
			if (genre.isEmpty()) {
				if (subdivision.equalsIgnoreCase("district")) {
					tpsDistAllWP3 = wp3UniteElevJeuneService.ListTableauDistAll(debut_date, fin);
				} else if (subdivision.equalsIgnoreCase("commune")) {
					tpsComAllWP3 = wp3UniteElevJeuneService.ListTableauCommuneAll(debut_date, fin);
				} else {
					tpsGenreAllWP3 = wp3UniteElevJeuneService.ListTableauAll(debut_date, fin, params);
				}
			} else {
				if (subdivision.equalsIgnoreCase("district")) {
					tpsDistWP3 = wp3UniteElevJeuneService.ListTableauDist(debut_date, fin, genre);
				} else if (subdivision.equalsIgnoreCase("commune")) {
					tpsComWP3 = wp3UniteElevJeuneService.ListTableauCommune(debut_date, fin, genre);
				} else {
					tpsGenreWP3 = wp3UniteElevJeuneService.ListTableau(debut_date, fin, params, genre);
				}
			}
			break;
		case "41":
			nameCanevas = "élèves inscrits dans les MFR";
			// ayant un champ nom_prenom count
			if (genre.isEmpty()) {
				if (subdivision.equalsIgnoreCase("district")) {
					tpsDistAllWP3 = wp3ElevMfrService.ListTableauDistAll(debut_date, fin);
				} else if (subdivision.equalsIgnoreCase("commune")) {
					tpsComAllWP3 = wp3ElevMfrService.ListTableauCommuneAll(debut_date, fin);
				} else {
					tpsGenreAllWP3 = wp3ElevMfrService.ListTableauAll(debut_date, fin, params);
				}
			} else {
				if (subdivision.equalsIgnoreCase("district")) {
					tpsDistWP3 = wp3ElevMfrService.ListTableauDist(debut_date, fin, genre);
				} else if (subdivision.equalsIgnoreCase("commune")) {
					tpsComWP3 = wp3ElevMfrService.ListTableauCommune(debut_date, fin, genre);
				} else {
					tpsGenreWP3 = wp3ElevMfrService.ListTableau(debut_date, fin, params, genre);
				}
			}
			break;
		case "42":
			nameCanevas = "jeunes formés des MFR";
			// ayant un champ nom_prenom count
			if (genre.isEmpty()) {
				if (subdivision.equalsIgnoreCase("district")) {
					tpsDistAllWP3 = wp3JeuneFormeMfrService.ListTableauDistAll(debut_date, fin);
				} else if (subdivision.equalsIgnoreCase("commune")) {
					tpsComAllWP3 = wp3JeuneFormeMfrService.ListTableauCommuneAll(debut_date, fin);
				} else {
					tpsGenreAllWP3 = wp3JeuneFormeMfrService.ListTableauAll(debut_date, fin, params);
				}
			} else {
				if (subdivision.equalsIgnoreCase("district")) {
					tpsDistWP3 = wp3JeuneFormeMfrService.ListTableauDist(debut_date, fin, genre);
				} else if (subdivision.equalsIgnoreCase("commune")) {
					tpsComWP3 = wp3JeuneFormeMfrService.ListTableauCommune(debut_date, fin, genre);
				} else {
					tpsGenreWP3 = wp3JeuneFormeMfrService.ListTableau(debut_date, fin, params, genre);
				}
			}
			break;
		case "43":
			nameCanevas = "Federation régionale MFR";
			// ayant un champ nom_prenom count
			if (genre.isEmpty()) {
				if (subdivision.equalsIgnoreCase("district")) {
					tpsDistAllWP3 = wp3FedeMfrService.ListTableauDistAll(debut_date, fin);
				} else if (subdivision.equalsIgnoreCase("commune")) {
					tpsComAllWP3 = wp3FedeMfrService.ListTableauCommuneAll(debut_date, fin);
				} else {
					tpsGenreAllWP3 = wp3FedeMfrService.ListTableauAll(debut_date, fin, params);
				}
			} else {
				if (subdivision.equalsIgnoreCase("district")) {
					tpsDistWP3 = wp3FedeMfrService.ListTableauDist(debut_date, fin, genre);
				} else if (subdivision.equalsIgnoreCase("commune")) {
					tpsComWP3 = wp3FedeMfrService.ListTableauCommune(debut_date, fin, genre);
				} else {
					tpsGenreWP3 = wp3FedeMfrService.ListTableau(debut_date, fin, params, genre);
				}
			}
			break;
		case "44":
			nameCanevas = "Equipe technique MFR";
			// ayant un champ nom_prenom count
			if (genre.isEmpty()) {
				if (subdivision.equalsIgnoreCase("district")) {
					tpsDistAllWP3 = wp3EquipeTechMfrService.ListTableauDistAll(debut_date, fin);
				} else if (subdivision.equalsIgnoreCase("commune")) {
					tpsComAllWP3 = wp3EquipeTechMfrService.ListTableauCommuneAll(debut_date, fin);
				} else {
					tpsGenreAllWP3 = wp3EquipeTechMfrService.ListTableauAll(debut_date, fin, params);
				}
			} else {
				if (subdivision.equalsIgnoreCase("district")) {
					tpsDistWP3 = wp3EquipeTechMfrService.ListTableauDist(debut_date, fin, genre);
				} else if (subdivision.equalsIgnoreCase("commune")) {
					tpsComWP3 = wp3EquipeTechMfrService.ListTableauCommune(debut_date, fin, genre);
				} else {
					tpsGenreWP3 = wp3EquipeTechMfrService.ListTableau(debut_date, fin, params, genre);
				}
			}
			break;
		case "45":
			nameCanevas = "AGR développé MFR";
			// ayant un champ nom_prenom count
			if (genre.isEmpty()) {
				if (subdivision.equalsIgnoreCase("district")) {
					tpsDistAllWP3 = wp3AgrDevMfrService.ListTableauDistAll(debut_date, fin);
				} else if (subdivision.equalsIgnoreCase("commune")) {
					tpsComAllWP3 = wp3AgrDevMfrService.ListTableauCommuneAll(debut_date, fin);
				} else {
					tpsGenreAllWP3 = wp3AgrDevMfrService.ListTableauAll(debut_date, fin, params);
				}
			} else {
				if (subdivision.equalsIgnoreCase("district")) {
					tpsDistWP3 = wp3AgrDevMfrService.ListTableauDist(debut_date, fin, genre);
				} else if (subdivision.equalsIgnoreCase("commune")) {
					tpsComWP3 = wp3AgrDevMfrService.ListTableauCommune(debut_date, fin, genre);
				} else {
					tpsGenreWP3 = wp3AgrDevMfrService.ListTableau(debut_date, fin, params, genre);
				}
			}
			break;
		case "46":
			nameCanevas = "jeune ayant terminé formation pathway";
			// ayant un champ nom_prenom count
			if (genre.isEmpty()) {
				if (subdivision.equalsIgnoreCase("district")) {
					tpsDistAllWP3 = wp3JeunePathwayService.ListTableauDistAll(debut_date, fin);
				} else if (subdivision.equalsIgnoreCase("commune")) {
					tpsComAllWP3 = wp3JeunePathwayService.ListTableauCommuneAll(debut_date, fin);
				} else {
					tpsGenreAllWP3 = wp3JeunePathwayService.ListTableauAll(debut_date, fin, params);
				}
			} else {
				if (subdivision.equalsIgnoreCase("district")) {
					tpsDistWP3 = wp3JeunePathwayService.ListTableauDist(debut_date, fin, genre);
				} else if (subdivision.equalsIgnoreCase("commune")) {
					tpsComWP3 = wp3JeunePathwayService.ListTableauCommune(debut_date, fin, genre);
				} else {
					tpsGenreWP3 = wp3JeunePathwayService.ListTableau(debut_date, fin, params, genre);
				}
			}
			break;
		case "47":
			nameCanevas = "EPP FRAM draft";
			// ayant un champ nom_prenom count
			if (genre.isEmpty()) {
				if (subdivision.equalsIgnoreCase("district")) {
					tpsDistAllWP3 = wp3EppFramService.ListTableauDistAll(debut_date, fin);
				} else if (subdivision.equalsIgnoreCase("commune")) {
					tpsComAllWP3 = wp3EppFramService.ListTableauCommuneAll(debut_date, fin);
				} else {
					tpsGenreAllWP3 = wp3EppFramService.ListTableauAll(debut_date, fin, params);
				}
			} else {

				if (subdivision.equalsIgnoreCase("district")) {
					tpsDistWP3 = wp3EppFramService.ListTableauDist(debut_date, fin, genre);
				} else if (subdivision.equalsIgnoreCase("commune")) {
					tpsComWP3 = wp3EppFramService.ListTableauCommune(debut_date, fin, genre);
				} else {
					tpsGenreWP3 = wp3EppFramService.ListTableau(debut_date, fin, params, genre);
				}
			}
			break;
		case "48":
			nameCanevas = "service santé par communauté";
			// ayant un champ nom_prenom count
			if (genre.isEmpty()) {
				if (subdivision.equalsIgnoreCase("district")) {
					tpsDistAllWP3 = wp3SanteeCommService.ListTableauDistAll(debut_date, fin);
				} else if (subdivision.equalsIgnoreCase("commune")) {
					tpsComAllWP3 = wp3SanteeCommService.ListTableauCommuneAll(debut_date, fin);
				} else {
					tpsGenreAllWP3 = wp3SanteeCommService.ListTableauAll(debut_date, fin, params);
				}
			} else {
				if (subdivision.equalsIgnoreCase("district")) {
					tpsDistWP3 = wp3SanteeCommService.ListTableauDist(debut_date, fin, genre);
				} else if (subdivision.equalsIgnoreCase("commune")) {
					tpsComWP3 = wp3SanteeCommService.ListTableauCommune(debut_date, fin, genre);
				} else {
					tpsGenreWP3 = wp3SanteeCommService.ListTableau(debut_date, fin, params, genre);
				}
			}
			break;
		case "49":
			nameCanevas = "peer educator";
			// ayant un champ nom_prenom count
			if (genre.isEmpty()) {
				if (subdivision.equalsIgnoreCase("district")) {
					tpsDistAllWP3 = wp3PeerEducatorService.ListTableauDistAll(debut_date, fin);
				} else if (subdivision.equalsIgnoreCase("commune")) {
					tpsComAllWP3 = wp3PeerEducatorService.ListTableauCommuneAll(debut_date, fin);
				} else {
					tpsGenreAllWP3 = wp3PeerEducatorService.ListTableauAll(debut_date, fin, params);
				}
			} else {
				if (subdivision.equalsIgnoreCase("district")) {
					tpsDistWP3 = wp3PeerEducatorService.ListTableauDist(debut_date, fin, genre);
				} else if (subdivision.equalsIgnoreCase("commune")) {
					tpsComWP3 = wp3PeerEducatorService.ListTableauCommune(debut_date, fin, genre);
				} else {
					tpsGenreWP3 = wp3PeerEducatorService.ListTableau(debut_date, fin, params, genre);
				}
			}
			break;

		case "51":
			nameCanevas = "document de capitalisation";
			tpsDC = docCapService.ListGraphe(debut_date, fin);
			break;
		case "52":
			nameCanevas = "ateliers MFR ";
			type_atelier = "CANEVAS ATELIERS/EVENEMENTS PROMOTIONNELS DU RESEAU DE MFR DANS LA REGION";
			// sum F et H
			if (genre.equalsIgnoreCase("F")) {
				if (subdivision.equalsIgnoreCase("district")) {
					tpsDistF = atelierMFRService.ListTableauDist(type_atelier, debut_date, fin);
				} else if (subdivision.equalsIgnoreCase("commune")) {
					tpsComF = atelierMFRService.ListTableauCommune(type_atelier, debut_date, fin);
				} else {
					tpsGenreF = atelierMFRService.ListTableau(type_atelier, params, debut_date, fin);
				}

			} else if (genre.equalsIgnoreCase("H")) {
				if (subdivision.equalsIgnoreCase("district")) {
					tpsDistH = atelierMFRService.ListTableauDist(type_atelier, debut_date, fin);
				} else if (subdivision.equalsIgnoreCase("commune")) {
					tpsComH = atelierMFRService.ListTableauCommune(type_atelier, debut_date, fin);
				} else {
					tpsGenreH = atelierMFRService.ListTableau(type_atelier, params, debut_date, fin);
				}
			} else {
				if (subdivision.equalsIgnoreCase("district")) {
					tpsDistAllSum = atelierMFRService.ListTableauDist(type_atelier, debut_date, fin);
				} else if (subdivision.equalsIgnoreCase("commune")) {
					tpsComAllSum = atelierMFRService.ListTableauCommune(type_atelier, debut_date, fin);
				} else {
					tpsGenreAllSum = atelierMFRService.ListTableau(type_atelier, params, debut_date, fin);
				}
			}
			break;
		case "53":
			nameCanevas = "Dialogue région";
			type_atelier = "CANEVAS DIALOGUE REGIONAL SUR L'ACCES AU FINANCEMENT";
			// sum F et H
			if (genre.equalsIgnoreCase("F")) {
				if (subdivision.equalsIgnoreCase("district")) {
					tpsDistF = atelierMFRService.ListTableauDist(type_atelier, debut_date, fin);
				} else if (subdivision.equalsIgnoreCase("commune")) {
					tpsComF = atelierMFRService.ListTableauCommune(type_atelier, debut_date, fin);
				} else {
					tpsGenreF = atelierMFRService.ListTableau(type_atelier, params, debut_date, fin);
				}

			} else if (genre.equalsIgnoreCase("H")) {
				if (subdivision.equalsIgnoreCase("district")) {
					tpsDistH = atelierMFRService.ListTableauDist(type_atelier, debut_date, fin);
				} else if (subdivision.equalsIgnoreCase("commune")) {
					tpsComH = atelierMFRService.ListTableauCommune(type_atelier, debut_date, fin);
				} else {
					tpsGenreH = atelierMFRService.ListTableau(type_atelier, params, debut_date, fin);
				}
			} else {
				if (subdivision.equalsIgnoreCase("district")) {
					tpsDistAllSum = atelierMFRService.ListTableauDist(type_atelier, debut_date, fin);
				} else if (subdivision.equalsIgnoreCase("commune")) {
					tpsComAllSum = atelierMFRService.ListTableauCommune(type_atelier, debut_date, fin);
				} else {
					tpsGenreAllSum = atelierMFRService.ListTableau(type_atelier, params, debut_date, fin);
				}
			}
			break;
		case "54":
			nameCanevas = "Atelier de capitalisation";
			type_atelier = "CANEVAS ATELIERS DE CAPITALISATION ET PARTAGE DES ACQUIS";
			// sum F et H
			if (genre.equalsIgnoreCase("F")) {
				if (subdivision.equalsIgnoreCase("district")) {
					tpsDistF = atelierMFRService.ListTableauDist(type_atelier, debut_date, fin);
				} else if (subdivision.equalsIgnoreCase("commune")) {
					tpsComF = atelierMFRService.ListTableauCommune(type_atelier, debut_date, fin);
				} else {
					tpsGenreF = atelierMFRService.ListTableau(type_atelier, params, debut_date, fin);
				}

			} else if (genre.equalsIgnoreCase("H")) {
				if (subdivision.equalsIgnoreCase("district")) {
					tpsDistH = atelierMFRService.ListTableauDist(type_atelier, debut_date, fin);
				} else if (subdivision.equalsIgnoreCase("commune")) {
					tpsComH = atelierMFRService.ListTableauCommune(type_atelier, debut_date, fin);
				} else {
					tpsGenreH = atelierMFRService.ListTableau(type_atelier, params, debut_date, fin);
				}
			} else {
				if (subdivision.equalsIgnoreCase("district")) {
					tpsDistAllSum = atelierMFRService.ListTableauDist(type_atelier, debut_date, fin);
				} else if (subdivision.equalsIgnoreCase("commune")) {
					tpsComAllSum = atelierMFRService.ListTableauCommune(type_atelier, debut_date, fin);
				} else {
					tpsGenreAllSum = atelierMFRService.ListTableau(type_atelier, params, debut_date, fin);
				}
			}
			break;
		case "55":
			nameCanevas = "Atelier promotion Mahavelona";
			type_atelier = "CANEVAS ATELIERS/EVENEMENTS PROMOTIONNELS DE MAHAVELONA DANS LA SAVA";
			// sum F et H
			if (genre.equalsIgnoreCase("F")) {
				if (subdivision.equalsIgnoreCase("district")) {
					tpsDistF = atelierMFRService.ListTableauDist(type_atelier, debut_date, fin);
				} else if (subdivision.equalsIgnoreCase("commune")) {
					tpsComF = atelierMFRService.ListTableauCommune(type_atelier, debut_date, fin);
				} else {
					tpsGenreF = atelierMFRService.ListTableau(type_atelier, params, debut_date, fin);
				}

			} else if (genre.equalsIgnoreCase("H")) {
				if (subdivision.equalsIgnoreCase("district")) {
					tpsDistH = atelierMFRService.ListTableauDist(type_atelier, debut_date, fin);
				} else if (subdivision.equalsIgnoreCase("commune")) {
					tpsComH = atelierMFRService.ListTableauCommune(type_atelier, debut_date, fin);
				} else {
					tpsGenreH = atelierMFRService.ListTableau(type_atelier, params, debut_date, fin);
				}
			} else {
				if (subdivision.equalsIgnoreCase("district")) {
					tpsDistAllSum = atelierMFRService.ListTableauDist(type_atelier, debut_date, fin);
				} else if (subdivision.equalsIgnoreCase("commune")) {
					tpsComAllSum = atelierMFRService.ListTableauCommune(type_atelier, debut_date, fin);
				} else {
					tpsGenreAllSum = atelierMFRService.ListTableau(type_atelier, params, debut_date, fin);
				}
			}
			break;
		case "56":
			nameCanevas = "Outils aux producteurs de vanille";
			type_atelier = "CANEVAS ATELIERS DE PARTAGES DES BONNES PRATIQUES ET OUTILS AUX PRODUCTEURS DE VANILLE";
			// sum F et H
			if (genre.equalsIgnoreCase("F")) {
				if (subdivision.equalsIgnoreCase("district")) {
					tpsDistF = atelierMFRService.ListTableauDist(type_atelier, debut_date, fin);
				} else if (subdivision.equalsIgnoreCase("commune")) {
					tpsComF = atelierMFRService.ListTableauCommune(type_atelier, debut_date, fin);
				} else {
					tpsGenreF = atelierMFRService.ListTableau(type_atelier, params, debut_date, fin);
				}

			} else if (genre.equalsIgnoreCase("H")) {
				if (subdivision.equalsIgnoreCase("district")) {
					tpsDistH = atelierMFRService.ListTableauDist(type_atelier, debut_date, fin);
				} else if (subdivision.equalsIgnoreCase("commune")) {
					tpsComH = atelierMFRService.ListTableauCommune(type_atelier, debut_date, fin);
				} else {
					tpsGenreH = atelierMFRService.ListTableau(type_atelier, params, debut_date, fin);
				}
			} else {
				if (subdivision.equalsIgnoreCase("district")) {
					tpsDistAllSum = atelierMFRService.ListTableauDist(type_atelier, debut_date, fin);
				} else if (subdivision.equalsIgnoreCase("commune")) {
					tpsComAllSum = atelierMFRService.ListTableauCommune(type_atelier, debut_date, fin);
				} else {
					tpsGenreAllSum = atelierMFRService.ListTableau(type_atelier, params, debut_date, fin);
				}
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
		model.addAttribute("namePlace", namePlace);
		model.addAttribute("tpsGenre", tpsGenre);
		model.addAttribute("tpsGenreH", tpsGenreH);
		model.addAttribute("tpsGenreF", tpsGenreF);
		model.addAttribute("tpsGenreAll", tpsGenreAll);
		model.addAttribute("tpsGenreAllSum", tpsGenreAllSum);
		model.addAttribute("tpsNosexe", tpsNosexe);
		model.addAttribute("nb", nb);
		model.addAttribute("tpsDC", tpsDC);
		model.addAttribute("tps", tps);
		model.addAttribute("tpsCom", tpsCom);
		model.addAttribute("tpsComH", tpsComH);
		model.addAttribute("tpsComF", tpsComF);
		model.addAttribute("tpsComAll", tpsComAll);
		model.addAttribute("tpsComAllSum", tpsComAllSum);
		model.addAttribute("tpsDist", tpsDist);
		model.addAttribute("tpsDistH", tpsDistH);
		model.addAttribute("tpsDistF", tpsDistF);
		model.addAttribute("tpsDistAll", tpsDistAll);
		model.addAttribute("tpsDistAllSum", tpsDistAllSum);
		model.addAttribute("tpsGenreWP3", tpsGenreWP3);
		model.addAttribute("tpsGenreAllWP3", tpsGenreAllWP3);
		model.addAttribute("tpsComWP3", tpsComWP3);
		model.addAttribute("tpsComAllWP3", tpsComAllWP3);
		model.addAttribute("tpsDistWP3", tpsDistWP3);
		model.addAttribute("tpsDistAllWP3", tpsDistAllWP3);
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
