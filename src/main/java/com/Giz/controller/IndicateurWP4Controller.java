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
public class IndicateurWP4Controller {
	
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
	
	
	@RequestMapping("/indicateurWP4")
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
	

}
