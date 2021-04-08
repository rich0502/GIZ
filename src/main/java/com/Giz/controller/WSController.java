package com.Giz.controller;

import java.net.URISyntaxException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Giz.data.domain.GraphDistrict;
import com.Giz.data.domain.Info_generale;
import com.Giz.data.domain.Info_parcelle_divers;
import com.Giz.data.domain.Wp3ActivEcoJeune;
import com.Giz.dto.ChangePasswordForm;
import com.Giz.entity.User;
import com.Giz.repository.Info_generaleRepository;
import com.Giz.service.UserService;
import com.Giz.service.metier.ActiviteService;
import com.Giz.service.metier.Fertilisant_cultureService;
import com.Giz.service.metier.Fertilisant_vanilleService;
import com.Giz.service.metier.Info_generaleService;
import com.Giz.service.metier.Info_parcelleService;
import com.Giz.service.metier.Info_parcelle_diversService;
import com.Giz.service.metier.Main_oeuvreService;
import com.Giz.service.metier.Parasite_maladieService;
import com.Giz.service.metier.Question_conseilService;

import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class WSController {


	
	@Autowired
	UserService userService;
	
	@Autowired
	Info_generaleRepository info_generaleRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	ActiviteService activiteService;
	
	@Autowired
	Fertilisant_cultureService fertilisant_cultureService;
	
	@Autowired
	Info_parcelle_diversService info_parcelle_diversService;
	
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
    
    @GetMapping("/loginUser")
	public List<User> loginUser(@RequestParam("username") String username,@RequestParam("password") String password,
			RedirectAttributes redirectAttributes) throws Exception {	
    	BCryptPasswordEncoder b = new BCryptPasswordEncoder();
    	//System.out.println(b.matches(password, "$2a$04$n6WIRDQlIByVFi.5rtQwEOTAzpzLPzIIG/O6quaxRKY2LlIHG8uiy"));
    	if(b.matches(password, userService.getUserByName(username).getPassword())) {
    		return userService.getUserByEmail(userService.getUserByName(username).getEmail());
    	}else {
    		return null;
    	}
	}
    
   
    
    @PostMapping("/editUsers/changePasswords")
	public String changePasswords(@RequestParam("newPassword") String newPassword,@RequestParam("confirmPassword") String confirmPassword, Errors errors) {
    	ChangePasswordForm form = new ChangePasswordForm();
    	form.setCurrentPassword("Blank");
    	form.setNewPassword(newPassword);
    	form.setConfirmPassword(confirmPassword);
		try {
			if (errors.hasErrors()) {
				String result = errors.getAllErrors().stream().map(x -> x.getDefaultMessage())
						.collect(Collectors.joining(""));

				throw new Exception(result);
			}
			userService.ChangePasswordDto(form);
		} catch (Exception e) {
			return "error";
		}
		return "Success";
	}
    
  /*  @PostMapping("/deleteBenef")
	public void deleteBenef(@RequestParam(value = "id_bf") Long id_bf)  throws URISyntaxException {
		beneficiaireService.deleteBeneficiaire(id_bf);
	}
    
    @PostMapping("/saveEditBenef")
	public void saveEditBenef(@RequestParam(value = "id_bf") Long id_bf,@RequestParam(value = "nom_bf") String nom_bf,
			@RequestParam(value = "prenom_bf") String prenom_bf,
			@RequestParam(value = "adresse_bf") String adresse_bf,
			@RequestParam(value = "contact_bf") String contact_bf,
			@RequestParam(value = "date_naiss_bf") String date_naiss_bf,
			RedirectAttributes redirectAttributes) throws URISyntaxException {
		Beneficiaire beneficiaire = beneficiaireRepository.findByIdBeneficiaire(id_bf);
		beneficiaireService.modifyBeneficiaire(beneficiaire, nom_bf, prenom_bf, adresse_bf, null, contact_bf, date_naiss_bf, id_bf);
	}   
       
    @PostMapping("/saveBenef")
    public void saveBenef(@RequestParam(value = "nom_bf") String nom_bf,
			@RequestParam(value = "prenom_bf") String prenom_bf, @RequestParam(value = "adresse_bf") String adresse_bf,
			@RequestParam(value = "contact_bf") String contact_bf,
			@RequestParam(value = "date_naiss_bf") String date_naiss_bf) throws URISyntaxException {
		beneficiaireService.addBeneficiaire(nom_bf, prenom_bf, adresse_bf, null, contact_bf, date_naiss_bf);
    }*/
    
    /* Activité  */
    @PostMapping("/saveActivite")
    public void saveActivite(@RequestParam(value = "type_intervention", defaultValue = "null") String type_intervention,
			@RequestParam(value = "theme_principal", defaultValue = "null") String theme_principal, @RequestParam(value = "sous_theme", defaultValue = "null") String sous_theme,
			@RequestParam(value = "date_enreg", defaultValue = "null") String date_enreg,
			@RequestParam(value = "nom_utilisateur", defaultValue = "null") String nom_utilisateur,@RequestParam(value = "gps_lat", defaultValue = "null") String gps_lat, @RequestParam(value = "gps_long", defaultValue = "null") String gps_long,
			@RequestParam(value = "formateur", defaultValue = "null") String formateur,@RequestParam(value = "code_formateur", defaultValue = "null") String code_formateur, @RequestParam(value = "lieu_formation", defaultValue = "null") String lieu_formation,
			@RequestParam(value = "prod_present", defaultValue = "null") String prod_present, @RequestParam(value = "prod_externe", defaultValue = "null") String prod_externe, @RequestParam(value = "participant_externe", defaultValue = "null") String participant_externe,
			@RequestParam(value = "image1", defaultValue = "null") String image1, @RequestParam(value = "image2", defaultValue = "null") String image2, @RequestParam(value = "image3", defaultValue = "null") String image3, @RequestParam(value = "remarques", defaultValue = "null") String remarques) throws URISyntaxException {
		activiteService.addActivite(type_intervention, theme_principal, sous_theme, date_enreg, nom_utilisateur, gps_lat, gps_long, formateur, code_formateur, lieu_formation, prod_present, prod_externe, participant_externe, image1, image2, image3, remarques);
    }
    
    /* Fertilisant culture */
    @PostMapping("/saveFertil")
    public void saveFertil(@RequestParam(value = "code_prod", defaultValue = "null") String code_prod,
			@RequestParam(value = "use_fertilisant", defaultValue = "null") String use_fertilisant, @RequestParam(value = "type_use", defaultValue = "null") String type_use,
			@RequestParam(value = "autre", defaultValue = "null") String autre,
			@RequestParam(value = "qte", defaultValue = "null") String nom_utilisateur,@RequestParam(value = "qte", defaultValue = "null") String qte, @RequestParam(value = "nbr_ans") int nbr_ans) throws URISyntaxException {
    	fertilisant_cultureService.addFertilisantCulture(code_prod, use_fertilisant, type_use, autre, qte, nbr_ans);
    }
    
    /* Information parcelle diversification */
    @PostMapping("/saveInfoParcelDiver")
    public void saveInfoParcelDiver(@RequestParam(value = "code_prod", defaultValue = "null") String code_prod,
			@RequestParam(value = "type_culture", defaultValue = "null") String type_culture, @RequestParam(value = "nom_parcel" , defaultValue = "null") String nom_parcel,
			@RequestParam(value = "periode_mise_culture", defaultValue = "null") String periode_mise_culture,@RequestParam(value = "periode_culture", defaultValue = "null") String periode_culture,@RequestParam(value = "occupation_sol", defaultValue = "null") String occupation_sol, @RequestParam(value = "autre_occupation_sol", defaultValue = "null") String autre_occupation_sol
			,@RequestParam(value = "volume_annee_precedent") float volume_annee_precedent, @RequestParam(value = "volume_annee_venir") float volume_annee_venir, 
			@RequestParam(value = "surface_parcelle") float surface_parcelle,@RequestParam(value = "rendement") float rendement,
			@RequestParam(value = "nbr_pieds") int nbr_pieds, @RequestParam(value = "etape_visite", defaultValue = "null") String etape_visite,
			@RequestParam(value = "systeme_protection_sol", defaultValue = "null") String systeme_protection_sol,@RequestParam(value = "systeme_utilise", defaultValue = "null") String systeme_utilise,
			@RequestParam(value = "associe_parcel", defaultValue = "null") String associe_parcel, @RequestParam(value = "autre_associe_parcel", defaultValue = "null") String autre_associe_parcel,@RequestParam(value = "inclinaison", defaultValue = "null") String inclinaison,
			@RequestParam(value = "mise_anti_errosif", defaultValue = "null") String mise_anti_errosif,@RequestParam(value = "technic_use", defaultValue = "null") String technic_use,
			@RequestParam(value = "photo_technique", defaultValue = "null") String photo_technique,@RequestParam(value = "photo_culture", defaultValue = "null") String photo_culture) throws URISyntaxException {
    	info_parcelle_diversService.addInfoParcelleDivers(code_prod, type_culture, nom_parcel, periode_mise_culture, periode_culture, occupation_sol, autre_occupation_sol, 
    			volume_annee_precedent, volume_annee_venir, surface_parcelle, rendement, nbr_pieds, etape_visite, systeme_protection_sol, systeme_utilise, associe_parcel, autre_associe_parcel, inclinaison, mise_anti_errosif, technic_use, photo_technique, photo_culture);
    }
    
    /* Fertilisant vanille */
    @PostMapping("/saveFertilisantVanille")
    public void saveFertilisantVanille(@RequestParam(value = "code_prod", defaultValue = "null") String code_prod,
			@RequestParam(value = "use_fertilisant", defaultValue = "null") String use_fertilisant, @RequestParam(value = "type_use", defaultValue = "null") String type_use,
			@RequestParam(value = "autre", defaultValue = "null") String autre,
			@RequestParam(value = "qte", defaultValue = "null") String nom_utilisateur,@RequestParam(value = "qte", defaultValue = "null") String qte, @RequestParam(value = "nbr_ans") int nbr_ans) throws URISyntaxException {
    	fertilisant_vanilleService.addFertilisantVanille(code_prod, use_fertilisant, type_use, autre, qte, nbr_ans);
    }
    
    /* information général vanille */
    @RequestMapping(value="/saveInfo_generale",method = RequestMethod.POST)
	public void saveInfo_generale(
			@RequestParam(value = "code_pro", defaultValue = "null") String code_pro,
   			@RequestParam(value = "nbr_parcel_prod") int nbr_parcel_prod, 
   			@RequestParam(value = "appris_culture", defaultValue = "null") String appris_culture,
   			@RequestParam(value = "autre", defaultValue = "null") String autre,
   			@RequestParam(value = "moyen", defaultValue = "null") String moyen,
   			@RequestParam(value = "technic_conseil", defaultValue = "null") String technic_conseil,
   			@RequestParam(value = "change_tech", defaultValue = "null") String change_tech, @RequestParam(value = "prepare") String prepare,
   			@RequestParam(value = "dernier_compagne") int dernier_compagne,
   			@RequestParam(value = "place_dedie", defaultValue = "null") String place_dedie) {
    	info_generaleService.addInfoGeneral(code_pro, nbr_parcel_prod, appris_culture, autre, moyen, technic_conseil, change_tech, prepare, dernier_compagne, place_dedie);
		
	}
    
    /* information parcelle vanille */
    @RequestMapping(value="/saveInfoParcelle",method = RequestMethod.POST)
   	public void saveInfoParcelle(
   			@RequestParam(value ="code_prod", defaultValue = "null") String code_prod,
      			@RequestParam(value ="nom_parcel", defaultValue = "null") String nom_parcel, 
      			@RequestParam(value ="annee_plan_liane", defaultValue = "null") String annee_plan_liane,
      			@RequestParam(value ="nbr_liane") int nbr_liane,
      			@RequestParam(value ="recolt_estime", defaultValue = "null") String recolt_estime,
      			@RequestParam(value ="surf_parcel") float surf_parcel,
      			@RequestParam(value ="nbr_liane_total") int nbr_liane_total, @RequestParam(value ="rende_parcel") float rende_parcel,
      			@RequestParam(value ="vol_anne_prec") int vol_anne_prec,
      			@RequestParam(value = "culture_asocie", defaultValue = "null") String culture_asocie,@RequestParam(value = "asocie_autre", defaultValue = "null") String asocie_autre,@RequestParam(value = "inclinaison", defaultValue = "null") String inclinaison,
      			@RequestParam(value = "mise_anti_errosif", defaultValue = "null") String mise_anti_errosif,@RequestParam(value = "technic_use", defaultValue = "null") String technic_use,@RequestParam(value = "photo_technique", defaultValue = "null")  String photo_technique,@RequestParam(value = "qualite_ombrage", defaultValue = "null")  String qualite_ombrage,
      			@RequestParam(value = "couverture_vegetal", defaultValue = "null")  String couverture_vegetal, @RequestParam(value = "avant", defaultValue = "null")  String avant, @RequestParam(value = "provien_liane", defaultValue = "null")  String provien_liane, 
      			 @RequestParam(value = "spec_autre", defaultValue = "null")  String spec_autre,  @RequestParam(value = "photo_parcelle", defaultValue = "null")  String photo_parcelle) {
       	
    	info_parcelleService.addInfoParcelle(code_prod, nom_parcel, annee_plan_liane, nbr_liane, recolt_estime, surf_parcel, nbr_liane_total, rende_parcel, vol_anne_prec, culture_asocie, asocie_autre, inclinaison, mise_anti_errosif, technic_use, photo_technique, qualite_ombrage, couverture_vegetal, avant, provien_liane, spec_autre, photo_parcelle);
   	}
    
    /* main oeuvre */
    @RequestMapping(value="/saveMainOeuvre",method = RequestMethod.POST)
   	public void saveMainOeuvre(
   			@RequestParam(value = "code_prod", defaultValue = "null") String code_prod,
      			@RequestParam(value = "nbr_empl_perm") int nbr_empl_perm, 
      			@RequestParam(value = "empl_jour_saison", defaultValue = "null") String empl_jour_saison,
      			@RequestParam(value = "nbr_empl_jour") int nbr_empl_jour,
      			@RequestParam(value = "pay_empl_jour") int pay_empl_jour,
      			@RequestParam(value = "mois_tw_empl", defaultValue = "null") String mois_tw_empl,
      			@RequestParam(value = "tw", defaultValue = "null") String tw, @RequestParam(value = "autre", defaultValue = "null") String autre,
      			@RequestParam(value = "activite_vanille", defaultValue = "null") String activite_vanille) {
       	
    	main_oeuvreService.addMainOeuvre(code_prod, nbr_empl_perm, empl_jour_saison, nbr_empl_jour, pay_empl_jour, mois_tw_empl, tw, autre, activite_vanille);
   	}
    
    /* parasite vanille*/
    @RequestMapping(value="/saveParasiteVanille",method = RequestMethod.POST)
   	public void saveParasiteVanille(
   			@RequestParam(value = "code_prod", defaultValue = "null") String code_prod,
      			@RequestParam(value = "constate", defaultValue = "null") String constate, 
      			@RequestParam(value = "nom_mp", defaultValue = "null") String nom_mp,
      			@RequestParam(value = "periode", defaultValue = "null") String periode,
      			@RequestParam(value = "pourcentage", defaultValue = "null") String pourcentage,
      			@RequestParam(value = "traitement", defaultValue = "null") String traitement,
      			@RequestParam(value = "type_traitement", defaultValue = "null") String type_traitement, @RequestParam(value = "mecanique", defaultValue = "null") String mecanique,
      			@RequestParam(value = "chimique", defaultValue = "null") String chimique,
      			@RequestParam(value = "chimique_qte", defaultValue = "null") String chimique_qte, @RequestParam(value = "biologique", defaultValue = "null") String biologique, @RequestParam(value = "autre", defaultValue = "null") String autre, @RequestParam(value = "frequence", defaultValue = "null") String frequence, @RequestParam(value = "effets", defaultValue = "null") String effets) {
    	parasite_maladieService.addParasiteMaladieDivers(code_prod, constate, nom_mp, periode, pourcentage, type_traitement, mecanique, chimique, chimique_qte, biologique, autre, frequence, effets);
   		
   	}
    
    /* Question conseil vanille*/
    @RequestMapping(value="/saveQuestionConseil",method = RequestMethod.POST)
   	public void saveQuestionConseil(
   			@RequestParam(value = "code_prod", defaultValue = "null") String code_prod,
      			@RequestParam(value = "question_symrise", defaultValue = "null") String question_symrise, 
      			@RequestParam(value = "conseil_rural", defaultValue = "null") String conseil_rural,
      			@RequestParam(value = "etat_vanille", defaultValue = "null") String etat_vanille,
      			@RequestParam(value = "assistance", defaultValue = "null") String assistance) {
    	question_conseilService.addQC(code_prod, question_symrise, conseil_rural, etat_vanille, assistance);
   		
   	}
   /* @RequestMapping(value="/createInfo_generale",method = RequestMethod.POST)
   	public String createInfo_generale()
   			throws Exception {
   		Info_generale info_generale = new Info_generale();
   		info_generale.getCode_pro(),
   		info_generale.getNbr_parcel_prod(),
   		info_generale.getAppris_culture(),
   		info_generale.getAutre(),
   		info_generale.getMoyen(),
   		info_generale.getTechnic_conseil(),
   		info_generale.getChange_tech(), 
   		info_generale.getPrepare(),
   		info_generale.getDernier_compagne(),
   		info_generale.getPlace_dedie();
   		Info_generaleService.createWp3ActivEcoJeune(wp3ActivEcoJeune);
   	}
   	*/
}