package com.Giz.controller;

import java.net.URISyntaxException;
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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Giz.data.domain.Beneficiaire;
import com.Giz.data.domain.Former;
import com.Giz.data.domain.GraphDistrict;
import com.Giz.entity.User;
import com.Giz.repository.BeneficiaireRepository;
import com.Giz.service.UserService;
import com.Giz.service.metier.BeneficiaireService;
import com.Giz.service.metier.FormerService;

import org.springframework.web.bind.annotation.RestController;



@RestController
public class WSController {

	@Autowired
	BeneficiaireService beneficiaireService;
	
	@Autowired
	FormerService formerService;
	
	@Autowired
	UserService userService;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	BeneficiaireRepository beneficiaireRepository;
	
    @GetMapping("/bene")
    public List<Beneficiaire> getCities() {

        return beneficiaireService.ListBeneficiaire();
    }
    
    @GetMapping("/formGraphe")
    public List<GraphDistrict> formGraphe() {
        return formerService.ListFormees();
    }
    
    @GetMapping("/wsBeneficiaire")
    public List<Beneficiaire> wsBeneficiaire() {
        return beneficiaireService.ListBeneficiaire();
    }
    
    @GetMapping("/loginUser")
	public List<User> loginUser(@RequestParam("email") String email,@RequestParam("password") String password,
			RedirectAttributes redirectAttributes) throws Exception {	
    	BCryptPasswordEncoder b = new BCryptPasswordEncoder();
    	//System.out.println(b.matches(password, "$2a$04$n6WIRDQlIByVFi.5rtQwEOTAzpzLPzIIG/O6quaxRKY2LlIHG8uiy"));
    	if(b.matches(password, userService.getUserByEmail(email).get(0).getPassword())) {
    		return userService.getUserByEmail(email);
    	}else {
    		return null;
    	}
	}
    
    @PostMapping("/deleteBenef")
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
    }
    
    
}