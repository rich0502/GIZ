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
import com.Giz.data.domain.Wp3ActivEcoJeune;
import com.Giz.dto.ChangePasswordForm;
import com.Giz.entity.User;
import com.Giz.repository.Info_generaleRepository;
import com.Giz.service.UserService;
import com.Giz.service.metier.Info_generaleService;

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
    
   
    
  /*  @PostMapping("/editUsers/changePasswords")
	public String changePasswords(@Valid @RequestBody ChangePasswordForm form, Errors errors) {
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
    */
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
    
    @RequestMapping(value="/createInfo_generale",method = RequestMethod.POST)
	public Info_generale createInfo_generale(
			@RequestParam("id") Long id,
			@RequestParam("code_pro") String code_pro,
   			@RequestParam("nbr_parcel_prod") int nbr_parcel_prod, 
   			@RequestParam("appris_culture") String appris_culture,
   			@RequestParam("autre") String autre,
   			@RequestParam("moyen") String moyen,
   			@RequestParam("technic_conseil") String technic_conseil,
   			@RequestParam("change_tech") String change_tech, @RequestParam("prepare") String prepare,
   			@RequestParam("dernier_compagne") int dernier_compagne,
   			@RequestParam("place_dedie") String place_dedie) {
	
			Info_generale _info_generale = info_generaleRepository
					.save(new Info_generale(
							id,
							code_pro,
							nbr_parcel_prod,
							appris_culture,
							autre,
							moyen,
							technic_conseil,
							change_tech, 
							prepare,
							dernier_compagne,
							place_dedie));
			return _info_generale;
		
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