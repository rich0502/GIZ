package com.Giz.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Giz.data.domain.Commune;
import com.Giz.data.domain.District;
import com.Giz.data.domain.Fokontany;
import com.Giz.data.domain.Formation;
import com.Giz.repository.FormationRepository;
import com.Giz.repository.DistrictRepository;
import com.Giz.service.metier.FormationService;
import com.Giz.service.metier.ZoneService;
import com.fasterxml.jackson.databind.ObjectMapper;




@Controller
public class FormationController {
	
	@Autowired
	FormationService formationService;
	
	@Autowired
	FormationRepository formationRepository;
	
	@Autowired
	ZoneService zoneService;
	
	@RequestMapping("/formation")
	public String formation(Model model) {
		List<Formation> formation = formationService.ListFormation();
		model.addAttribute("Formation", formation);
		return "crud-form/Form_list_Formation";
	}

	@RequestMapping("/deleteFormation/{id_form}")
	public String deleteFormation(@PathVariable(name = "id_form") Long id_form) {
		formationService.deleteFormation(id_form);
		return "redirect:/formation";
	}

	@RequestMapping("/addFormation")
	public String addFormation(Model model) {
		List<String> districts = new ArrayList<>();
		List<String> communes = new ArrayList<>();
		List<String> fkt = new ArrayList<>();
		List<District> districtEntity = zoneService.getDistrict();
		List<Commune> communeEntity = zoneService.getCommune();
		List<Fokontany> fktEntity = zoneService.getFokontany();
		for(int i= 0 ; i < districtEntity.size(); i++) {
			districts.add(districtEntity.get(i).getAdm2_en());
		}
		for(int i= 0; i < communeEntity.size() ; i++) {
			communes.add(communeEntity.get(i).getadm3_en());
		}
		for(int i= 0; i < fktEntity.size() ; i++) {
			fkt.add(fktEntity.get(i).getadm4_en());
		}
       model.addAttribute("districts", districts);
       model.addAttribute("communes", communes);
       model.addAttribute("fkt", fkt);
		return "crud-form/Form_add_Formation";
	}

	private boolean istPalindrom(char[] cs) {
		// TODO Auto-generated method stub
		return false;
	}

	@RequestMapping("/saveFormation")
	public String saveFormation(@RequestParam("nom_form") String nom_form,
			@RequestParam("type_form") String type_form, @RequestParam("district_form") String district_form,
			@RequestParam("commune_form") String commune_form,
			@RequestParam("fkt_form") String fkt_form, RedirectAttributes redirectAttributes)
			throws ParseException {	
		formationService.addFormation(nom_form, type_form, district_form, commune_form, fkt_form);
		return "redirect:/formation";
	}

	@RequestMapping("/editFormation/{id_form}")
	public ModelAndView editFormation(@PathVariable(name = "id_form") Long id_form, Model model) throws ParseException {
		ModelAndView mav = new ModelAndView("crud-form/Form_modif_Formation");
		Formation fr = formationRepository.findByIdFormation(id_form);
		mav.addObject("formation", fr);
		return mav;
	}

	@RequestMapping(value = "/saveEditFormation", method = RequestMethod.POST)
	public String saveEditBeneficiaire(@RequestParam("id_form") Long id_form,@RequestParam("nom_form") String nom_form,
			@RequestParam("type_form") String type_form,
			@RequestParam("commune_form") String commune_form,
			@RequestParam("district_form") String district_form,
			@RequestParam("fkt_form") String fkt_form,
			RedirectAttributes redirectAttributes) throws ParseException {
		Formation formation = formationRepository.findByIdFormation(id_form);
		formationService.modifyFormation(formation, nom_form, type_form, district_form, commune_form, fkt_form, id_form);
		return "redirect:/formation";
	}
}
