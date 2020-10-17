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
import com.Giz.data.domain.Former;
import com.Giz.data.domain.GraphDistrict;
import com.Giz.service.metier.BeneficiaireService;
import com.Giz.service.metier.FormerService;

import org.springframework.web.bind.annotation.RestController;



@RestController
public class MyController {

	@Autowired
	BeneficiaireService beneficiaireService;
	
	@Autowired
	FormerService formerService;

    @GetMapping("/bene")
    public List<Beneficiaire> getCities() {

        return beneficiaireService.ListBeneficiaire();
    }
    
    @GetMapping("/formGraphe")
    public List<GraphDistrict> formGraphe() {
        return formerService.ListFormees();
    }
}