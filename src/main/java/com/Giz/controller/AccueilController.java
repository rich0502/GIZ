package com.Giz.controller;

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

import com.Giz.data.domain.Accueil;
import com.Giz.repository.AccueilRepository;
import com.Giz.service.metier.AccueilService;

@Controller
public class AccueilController {
	
	@Autowired
	AccueilService accueilService;
	
	@Autowired
	AccueilRepository accueilRepository;
	
	@RequestMapping("/acc")
	public String accueil(Model model) {
		List<Accueil> accueil = accueilService.ListAccueil();
		model.addAttribute("Accueil", accueil);
		return "crud-form/Form_list_Accueil";
	}
	
	@RequestMapping("/editAccueil/{id_acc}")
	public ModelAndView editAccueil(@PathVariable(name = "id_acc") Long id_acc, Model model) throws ParseException {
		ModelAndView mav = new ModelAndView("crud-form/Form_modif_Accueil");
		Accueil acc = accueilRepository.findByIdAccueil(id_acc);
		mav.addObject("accueil", acc);
		return mav;
	}

	@RequestMapping(value = "/saveEditAccueil", method = RequestMethod.POST)
	public String saveEditAccueil(
			@RequestParam("id_acc") Long id_acc,
			@RequestParam("contenu_acc") String contenu_acc,
			RedirectAttributes redirectAttributes) throws ParseException {
		Accueil accueil = accueilRepository.findByIdAccueil(id_acc);
		accueilService.modifyAccueil(accueil, contenu_acc, id_acc);
		return "redirect:/acc";
	}
	
}
