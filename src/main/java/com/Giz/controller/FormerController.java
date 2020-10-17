package com.Giz.controller;

import java.sql.Date;
import java.text.ParseException;
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
import com.Giz.data.domain.Formation;
import com.Giz.data.domain.Former;
import com.Giz.repository.BeneficiaireRepository;
import com.Giz.repository.FormerRepository;
import com.Giz.service.metier.BeneficiaireService;
import com.Giz.service.metier.FormationService;
import com.Giz.service.metier.FormerService;




@Controller
public class FormerController {
	
	@Autowired
	FormerService formerService;
	
	@Autowired
	FormerRepository formerRepository;

	@Autowired
	BeneficiaireService beneficiaireService;
	
	@Autowired
	FormationService formationService;
	
	@RequestMapping("/former")
	public String former(Model model) {
		List<Former> former = formerService.ListFormer();
		model.addAttribute("Former", former);
		return "crud-form/Form_list_Former";
	}

	@RequestMapping("/deleteFormer/{id}")
	public String deleteFormer(@PathVariable(name = "id") Long id) {
		formerService.deleteFormer(id);
		return "redirect:/former";
	}

	@RequestMapping("/addFormer")
	public String addFormer(Model model) {
		List<Beneficiaire> beneficiaire = beneficiaireService.ListBeneficiaire();
		List<Formation> formation = formationService.ListFormation();
		model.addAttribute("Formation", formation);
		model.addAttribute("Beneficiaire", beneficiaire);
		return "crud-form/Form_add_Former";
	}

	@RequestMapping("/saveFormer")
	public String saveFormer(@RequestParam("date_frm") Date date_frm,
			@RequestParam("id_bf") Long id_bf, @RequestParam("id_form") Long id_form,
			RedirectAttributes redirectAttributes)
			throws ParseException {	
		formerService.addFormer(date_frm, id_bf, id_form);
		return "redirect:/former";
	}

	@RequestMapping("/editFormer/{id}")
	public ModelAndView editFormer(@PathVariable(name = "id") Long id, Model model) throws ParseException {
		ModelAndView mav = new ModelAndView("crud-form/Form_modif_Former");
		Former fr = formerRepository.findByIdFormer(id);
		List<Beneficiaire> beneficiaire = beneficiaireService.ListBeneficiaire();
		List<Formation> formation = formationService.ListFormation();
		model.addAttribute("Formation", formation);
		model.addAttribute("Beneficiaire", beneficiaire);
		mav.addObject("former", fr);
		return mav;
	}

	@RequestMapping(value = "/saveEditFormer", method = RequestMethod.POST)
	public String saveEditFormer(@RequestParam("id") Long id,@RequestParam("date_frm") Date date_frm,
			@RequestParam("id_bf") Long id_bf,
			@RequestParam("id_form") Long id_form,
			RedirectAttributes redirectAttributes) throws ParseException {
		Former former = formerRepository.findByIdFormer(id);
		formerService.modifyFormer(former, date_frm, id_bf, id_form, id_form);
		return "redirect:/former";
	}
}
