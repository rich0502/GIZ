package com.Giz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Giz.data.constants.theme.ListeWp;

@Controller
public class EditionController {
	
	@RequestMapping("/edition")
	public String edition(Model model) {
		String[][] scList = ListeWp.wp();
		model.addAttribute("scList", scList);
		return "edition";
	}	
}
