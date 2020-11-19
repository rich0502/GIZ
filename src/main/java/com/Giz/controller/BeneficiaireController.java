package com.Giz.controller;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Giz.data.domain.Beneficiaire;
import com.Giz.repository.BeneficiaireRepository;
import com.Giz.service.metier.BeneficiaireService;




@Controller
public class BeneficiaireController {
	
	@Autowired
	BeneficiaireService beneficiaireService;
	
	@Autowired
	BeneficiaireRepository beneficiaireRepository;

	@RequestMapping("/beneficiaire")
	public String listSuccess(Model model) {
		List<Beneficiaire> beneficiaire = beneficiaireService.ListBeneficiaire();
		model.addAttribute("Beneficiaire", beneficiaire);
		return "crud-form/Form_list_Beneficiaire";
	}
	
	@RequestMapping("/success")
	public String success(Model model) {
		List<Beneficiaire> success = beneficiaireService.ListSuccessStories();
		model.addAttribute("Success", success);
		return "crud-form/Form_list_success";
	}

	@RequestMapping("/deleteBeneficiaire/{id_bf}")
	public String deleteBeneficiaire(@PathVariable(name = "id_bf") Long id_bf) {
		beneficiaireService.deleteBeneficiaire(id_bf);
		return "redirect:/beneficiaire";
	}

	@RequestMapping("/addBeneficiaire")
	public String addHistoriqueAsaForme(Model model) {

		return "crud-form/Form_add_Beneficiaire";
	}

	@RequestMapping("/saveBeneficiaire")
	public String saveBeneficiaire(@RequestParam("nom_bf") String nom_bf,
			@RequestParam("prenom_bf") String prenom_bf, @RequestParam("adresse_bf") String adresse_bf,
			@RequestParam("contact_bf") String contact_bf,
			@RequestParam("date_naiss_bf") String date_naiss_bf,@RequestParam(value="success", required=false, defaultValue="false") Boolean success, RedirectAttributes redirectAttributes)
			throws ParseException {	
		beneficiaireService.addBeneficiaire(nom_bf, prenom_bf, adresse_bf, success, contact_bf, date_naiss_bf);
		return "redirect:/beneficiaire";
	}

	@RequestMapping("/editBeneficiaire/{id_bf}")
	public ModelAndView editBeneficiaire(@PathVariable(name = "id_bf") Long id_bf, Model model) throws ParseException {
		ModelAndView mav = new ModelAndView("crud-form/Form_modif_Beneficiaire");
		Beneficiaire bf = beneficiaireRepository.findByIdBeneficiaire(id_bf);
		mav.addObject("beneficiaire", bf);
		return mav;
	}

	@RequestMapping(value = "/saveEditBeneficiaire", method = RequestMethod.POST)
	public String saveEditBeneficiaire(@RequestParam("id_bf") Long id_bf,@RequestParam("nom_bf") String nom_bf,
			@RequestParam("prenom_bf") String prenom_bf,
			@RequestParam("adresse_bf") String adresse_bf,
			@RequestParam("contact_bf") String contact_bf,
			@RequestParam("date_naiss_bf") String date_naiss_bf, @RequestParam(value="success", required=false, defaultValue="false") Boolean success,
			RedirectAttributes redirectAttributes) throws ParseException {
		Beneficiaire beneficiaire = beneficiaireRepository.findByIdBeneficiaire(id_bf);
		beneficiaireService.modifyBeneficiaire(beneficiaire, nom_bf, prenom_bf, adresse_bf, success, contact_bf, date_naiss_bf, id_bf);
		return "redirect:/beneficiaire";
	}
}
