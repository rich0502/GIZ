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

import com.Giz.data.domain.GraphDistrict;
import com.Giz.service.metier.AdopteInnovationService;
import com.Giz.service.metier.FormationBpaService;
import com.Giz.service.metier.ParcelleTestService;
import com.Giz.service.metier.PepiniereService;
import com.Giz.service.metier.RechercheService;
import com.Giz.service.metier.Wp3ActivEcoJeuneService;
import com.Giz.service.metier.Wp3AgrDevMfrService;
import com.Giz.service.metier.Wp3CommitteeActifService;
import com.Giz.service.metier.Wp3ElevMfrService;
import com.Giz.service.metier.Wp3EppFramService;
import com.Giz.service.metier.Wp3EquipeTechMfrService;
import com.Giz.service.metier.Wp3FedeMfrService;
import com.Giz.service.metier.Wp3JeuneFormeMfrService;
import com.Giz.service.metier.Wp3JeunePathwayService;
import com.Giz.service.metier.Wp3JeuneTechService;
import com.Giz.service.metier.Wp3PeerEducatorService;
import com.Giz.service.metier.Wp3SanteeCommService;
import com.Giz.service.metier.Wp3UniteElevJeuneService;






@Controller
public class IndicateurController {
	
	@Autowired
	AdopteInnovationService adopteInnovationService;
	@Autowired
	RechercheService rechercheService;
	
	@Autowired
	FormationBpaService formationBpaService;
	
	@Autowired
	ParcelleTestService parcelleTestService;
	
	@Autowired
	PepiniereService pepiniereService; 
	
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
	
	@RequestMapping("/indicateur")
	public String indicateur(@RequestParam("nom_bf") String nom_bf,Model model) {
		System.out.println("any zani" + nom_bf);
		return "indicateur";
	}
	
	
	@RequestMapping("/indicateurWP1")
	public String indicateurWP1(Model model) {
		
		/* CANEVAS ADOPTION INNOVATION */
		float target_adop = 2100;
		float adopte = (float) ((adopteInnovationService.CountAdoption()/target_adop)*100.0);
		
		long hom_adop = adopteInnovationService.CountGenre("homme");
		long fem_adop = adopteInnovationService.CountGenre("femme");
		
		/* CANEVAS DE RESTITUTION DE  RECHERCHES */
		float target_rech = 3500;
		float recheche = (float) ((rechercheService.countRecherche()/target_rech)*100.0);
		
		/* CANEVAS FORMATION SUR LES BONNES PRATIQUES DES PRODUCTEURS */
		float target_bpa = 5300;
		float bpa = (float) ((formationBpaService.countbpa()/target_bpa)*100.0);
		
		/* CANEVAS PARCELLES TESTS VANILLES */
		float target_testva = 10;
		float test = (float) ((formationBpaService.countbpa()/target_testva)*100.0);
		
		/* CANEVAS PEPINIERE MISE EN PLACE */
		float target = 231;
		float pepiniere = (float) ((pepiniereService.countPepiniere()/target)*100.0);
		System.out.println("zzz" + pepiniere);
		long hom_pepi = adopteInnovationService.CountGenre("homme");
		long fem_pepi = pepiniereService.countPepiniere() - hom_pepi;
		
		model.addAttribute("adopte", adopte);
		model.addAttribute("fem_adop", fem_adop);
		model.addAttribute("hom_adop", hom_adop);
		model.addAttribute("adopte", adopte);
		model.addAttribute("recheche", recheche);
		model.addAttribute("bpa", bpa);
		model.addAttribute("test", test);
		model.addAttribute("pepiniere", pepiniere);
		model.addAttribute("hom_pepi", hom_pepi);
		model.addAttribute("fem_pepi", fem_pepi);
		return "indicateurWp1/indicateurWp1";
	}
	
	@RequestMapping("/indicateurWP3")
	public String indicateurWP3(@RequestParam("chronologie") String dateChronologique, Model model) {
		float target = 2760;
		float can37 = (float) ((wp3ActivEcoJeuneService.countActivEcoJeune(dateChronologique)/target)*100.0);
		float can37H = wp3ActivEcoJeuneService.countActivEcoJeuneGenre(dateChronologique, "homme");
		float can37F = wp3ActivEcoJeuneService.countActivEcoJeuneGenre(dateChronologique, "femme");
		
		target = 77;
		float can38 = (float) ((wp3AgrDevMfrService.countChronologique(dateChronologique)/target)*100.0);
		float can38H = wp3AgrDevMfrService.countChronologiqueGenre(dateChronologique, "homme");
		float can38F = wp3AgrDevMfrService.countChronologiqueGenre(dateChronologique, "femme");
		
		
		target = 2460; 
		float can39 = (float) ((wp3CommitteeActifService.countChronologique(dateChronologique)/target)*100.0);
		float can39H = wp3CommitteeActifService.countChronologiqueGenre(dateChronologique, "homme");
		float can39F = wp3CommitteeActifService.countChronologiqueGenre(dateChronologique, "femme");
		
		target = 800;
		float can40 = (float) ((wp3ElevMfrService.countChronologie(dateChronologique)/target)*100.0);
		float can40H = wp3ElevMfrService.countChronologieGenre(dateChronologique, "homme");
		float can40F = wp3ElevMfrService.countChronologieGenre(dateChronologique, "femme");
		
		target = 0; //1 => 100%
		// float can41 = (float) ((wp3EppFramService.countChronologique(dateChronologique)/target)*100.0);
		float can41 = 0.0f;
		if(wp3EppFramService.countChronologique(dateChronologique) > 0) {
			can41 = 100.0f;
		}
		float can41H = wp3EppFramService.countChronologiqueGenre(dateChronologique, "homme");
		float can41F = wp3EppFramService.countChronologiqueGenre(dateChronologique, "femme");
		
		target = 600;
		float can42 = (float) ((wp3EquipeTechMfrService.countChronologique(dateChronologique)/target)*100.0);
		float can42H = wp3EquipeTechMfrService.countChronologiqueGenre(dateChronologique, "homme");
		float can42F = wp3EquipeTechMfrService.countChronologiqueGenre(dateChronologique, "femme");
		
		target = 1; // oui plan
		// float can43 = (float) ((wp3FedeMfrService.countChronologique(dateChronologique)/target)*100.0);
		float can43 = 0.0f;
		if(wp3FedeMfrService.countChronologique(dateChronologique) > 0) {
			can43 = 100.0f;
		}
		float can43H = wp3FedeMfrService.countChronologiqueGenre(dateChronologique, "homme");
		float can43F = wp3FedeMfrService.countChronologiqueGenre(dateChronologique, "femme");
		
		target = 1;//ingeniori de formation
		// float can44 = (float) ((wp3JeuneFormeMfrService.countChronologique(dateChronologique)/target)*100.0);
		float can44 = 0.0f;
		if(wp3JeuneFormeMfrService.countChronologique(dateChronologique) > 0) {
			can44 = 100.0f;
		}
		float can44H = wp3JeuneFormeMfrService.countChronologiqueGenre(dateChronologique, "homme");
		float can44F = wp3JeuneFormeMfrService.countChronologiqueGenre(dateChronologique, "femme");
		
		target = 5;//existance agr
		// float can45 = (float) ((wp3JeunePathwayService.countChronologique(dateChronologique)/target)*100.0);
		float can45 = 0.0f;
		if(wp3JeunePathwayService.countChronologique(dateChronologique) > 5) {
			can45 = 100.0f;
		}
		float can45H = wp3JeunePathwayService.countChronologiqueGenre(dateChronologique, "homme");
		float can45F = wp3JeunePathwayService.countChronologiqueGenre(dateChronologique, "femme");
		
		target = 3850;
		float can46 = (float) ((wp3JeuneTechService.countChronologique(dateChronologique)/target)*100.0);
		float can46H = wp3JeuneTechService.countChronologiqueGenre(dateChronologique, "homme");
		float can46F = wp3JeuneTechService.countChronologiqueGenre(dateChronologique, "femme");
		
		target = 77; 
		float can47 = (float) ((wp3PeerEducatorService.countChronologique(dateChronologique)/target)*100.0);
		float can47H = wp3PeerEducatorService.countChronologiqueGenre(dateChronologique, "homme");
		float can47F = wp3PeerEducatorService.countChronologiqueGenre(dateChronologique, "femme");
		
		target = 1;
		// float can48 = (float) ((wp3SanteeCommService.countChronologique(dateChronologique)/target)*100.0);
		float can48 = 0.0f;
		if(wp3SanteeCommService.countChronologique(dateChronologique) > 1) {
			can48 = 100.0f;
		}
		float can48H = wp3SanteeCommService.countChronologiqueGenre(dateChronologique, "homme");
		float can48F = wp3SanteeCommService.countChronologiqueGenre(dateChronologique, "femme");
		
		target = 2; 
		// float can49 = (float) ((wp3UniteElevJeuneService.countChronologique(dateChronologique)/target)*100.0);
		float can49 = 0.0f;
		if(wp3UniteElevJeuneService.countChronologique(dateChronologique) > 2) {
			can49 = 100.0f;
		}
		float can49H = wp3UniteElevJeuneService.countChronologiqueGenre(dateChronologique, "homme");
		float can49F = wp3UniteElevJeuneService.countChronologiqueGenre(dateChronologique, "femme");
		
		model.addAttribute("can37", can37);
		model.addAttribute("can37H", can37H);
		model.addAttribute("can37F", can37F);
		model.addAttribute("can38", can38);
		model.addAttribute("can38H", can38H);
		model.addAttribute("can38F", can38F);
		model.addAttribute("can39", can39);
		model.addAttribute("can39H", can39H);
		model.addAttribute("can39F", can39F);
		model.addAttribute("can40", can40);
		model.addAttribute("can40H", can40H);
		model.addAttribute("can40F", can40F);
		model.addAttribute("can41", can41);
		model.addAttribute("can41H", can41H);
		model.addAttribute("can41F", can41F);
		model.addAttribute("can41", can41);
		model.addAttribute("can41H", can41H);
		model.addAttribute("can41F", can41F);
		model.addAttribute("can42", can42);
		model.addAttribute("can42H", can42H);
		model.addAttribute("can42F", can42F);
		model.addAttribute("can43", can43);
		model.addAttribute("can43H", can43H);
		model.addAttribute("can43F", can43F);
		model.addAttribute("can44", can44);
		model.addAttribute("can44H", can44H);
		model.addAttribute("can44F", can44F);
		model.addAttribute("can45", can45);
		model.addAttribute("can45H", can45H);
		model.addAttribute("can45F", can45F);
		model.addAttribute("can46", can46);
		model.addAttribute("can46H", can46H);
		model.addAttribute("can46F", can46F);
		model.addAttribute("can47", can47);
		model.addAttribute("can47H", can47H);
		model.addAttribute("can47F", can47F);
		model.addAttribute("can48", can48);
		model.addAttribute("can48H", can48H);
		model.addAttribute("can48F", can48F);
		model.addAttribute("can49", can49);
		model.addAttribute("can49H", can49H);
		model.addAttribute("can49F", can49F);
		
		
		return "indicateurWp3/indicateurWp3";
	}

}
