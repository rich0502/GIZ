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

import com.Giz.data.domain.Beneficiaire;
import com.Giz.data.domain.Formation;
import com.Giz.data.domain.Former;
import com.Giz.data.domain.GraphDistrict;
import com.Giz.data.domain.TpsFormes;
import com.Giz.entity.User;
import com.Giz.repository.BeneficiaireRepository;
import com.Giz.service.UserService;
import com.Giz.service.metier.BeneficiaireService;
import com.Giz.service.metier.FormerService;




@Controller
public class IndicateurController {
	@Autowired
	UserService userService;
	
	@Autowired
	BeneficiaireService beneficiaireService;
	
	@Autowired
	FormerService formerService;
	
	@RequestMapping("/indicateur")
	public String indicateur(Model model) {
		return "indicateur";
	}
	
	@RequestMapping("/carte")
	public String carte(@RequestParam("date_debut") String date_debut,
			@RequestParam("date_fin") String date_fin, @RequestParam("subdivision") String subdivision, Model model) throws Exception {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentUserName = authentication.getName();
		User nomUser = userService.getUserByName(currentUserName);
		model.addAttribute("date_debut", date_debut);
		model.addAttribute("date_fin", date_fin);
		model.addAttribute("subdivision", subdivision);
		model.addAttribute("type", nomUser.getLastName());
		return "carte";
	}	

	@RequestMapping("/graphe")
	public String graphe(@RequestParam("date_debut") Date debut_date,
			@RequestParam("date_fin") Date fin_date, @RequestParam("subdivision") String subdivision,Model model) {
		List<GraphDistrict>  fr= formerService.ListFormees();
		List<TpsFormes>  tps = formerService.TpsFormer(debut_date, fin_date);
		int tot = formerService.TotForms();
		model.addAttribute("tot", tot);
		model.addAttribute("fr", fr);
		model.addAttribute("tps", tps);
		return "graphe";
	}

}
