package com.Giz.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.Giz.data.domain.Galerie;
import com.Giz.service.metier.GalerieService;

@Controller
public class GalerieControlleur {
	@Autowired
	GalerieService galerieService;

	@RequestMapping(value = "/galerie")
	public String galeriePage(Model model) {
		model.addAttribute("galerieList", galerieService.getAllGalerie());
		return "galerie-page/galerie-view";
	}
	
	@RequestMapping("/saveGalerie")
	public String createGalerie(@RequestParam("nom_album") String nom_album) {
		Galerie galerie = new Galerie(nom_album);
		try {
			galerieService.creategalerie(galerie);
		} catch (Exception e) {
			System.out.print(e.toString());
		}
		return "redirect:/galerie";
	}
	
	@RequestMapping(value = "/deleteGalerie/{id}")
	public String deleteGalerie(Model model, @PathVariable(name = "id") Long id) {
		try {
			galerieService.deleteGalerie(id);
		} catch (Exception e) {
			System.out.print(e.toString());
		}
		return "redirect:/galerie";
	}
	
	@RequestMapping(value="/editeGalerie") 
	public String editGalerie(@RequestParam("id") Long id, @RequestParam("nom_album") String nom_album) {
		try {
			galerieService.updateGalerie(id, nom_album);
		} catch (Exception e) {
			System.out.print(e.toString());
		}
		return "redirect:/galerie";
	}
	
	

}
