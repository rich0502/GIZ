package com.Giz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EditionController {
	
	
	@RequestMapping("/edition")
	public String edition(Model model) {
		return "redirect:/listWp3ActivEcoJeune";
	}
	
	
}
