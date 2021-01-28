package com.Giz.controller;


import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.Giz.data.constants.theme.ListeWp;
import com.Giz.data.domain.Adoption_innovation;
import com.Giz.data.domain.Elevage;
import com.Giz.data.domain.Formateur;
import com.Giz.data.domain.Formation_bpa;
import com.Giz.data.domain.MiseForme;
import com.Giz.data.domain.Parcelle_test;
import com.Giz.data.domain.Pepiniere;
import com.Giz.data.domain.Person_res;
import com.Giz.data.domain.Recherche;
import com.Giz.data.domain.Sante_animal;
import com.Giz.repository.FormateursRepository;
import com.Giz.service.metier.AdopteInnovationService;
import com.Giz.service.metier.BeneficiaireService;
import com.Giz.service.metier.ElevageService;
import com.Giz.service.metier.FormateurService;
import com.Giz.service.metier.FormationBpaService;
import com.Giz.service.metier.ParcelleTestService;
import com.Giz.service.metier.PepiniereService;
import com.Giz.service.metier.Person_resService;
import com.Giz.service.metier.RechercheService;
import com.Giz.service.metier.Sante_animalService;


@Controller
public class Wp1Controller {
	
	
	@Autowired
	AdopteInnovationService adopteInnovationService;
	
	@Autowired
	RechercheService rechercheService;
	
	@Autowired
	ElevageService elevageService;
	
	@Autowired
	FormationBpaService formationBpaService;
	
	
	@Autowired
	ParcelleTestService parcelleTestService; 
	
	@Autowired
	PepiniereService pepiniereService;
	
	@Autowired
	Sante_animalService sante_animalService;
	
	@Autowired
	Person_resService person_resService;
	
	@Autowired
	FormateurService formateursService;

	XSSFWorkbook workbook;
	
	@PostMapping("/importWp1")
	public String mapReapExcelDatatoDB(@RequestParam("file") MultipartFile reapExcelDataFile, @RequestParam("benef") String benef, Model model ) throws IOException, ParseException {
				
	    workbook = new XSSFWorkbook(reapExcelDataFile.getInputStream());
	    XSSFSheet worksheet = workbook.getSheetAt(0);
	    XSSFRow row1 = worksheet.getRow(0);
	    MiseForme mForm = null;
	    ArrayList<MiseForme> msForm = new ArrayList<MiseForme>();
	    for(int i=0 ; i< row1.getLastCellNum() ; i++) {
	    	String headers = row1.getCell(i).getStringCellValue();
	    	mForm = new MiseForme(headers, i);
	    	msForm.add(mForm);
	    }
	   model.addAttribute("headerLists", msForm);
        return "mise_form";
	}
	
	
	
	
	/* CANEVAS ADOPTION INNOVATION  */

	@RequestMapping("/uploadAI")
	public String uploadFile(Model model) {
		String[][] scList = ListeWp.wp();
		model.addAttribute("scList", scList);
		return "wp1/AI/uploadAI";
	}
	
	@PostMapping("/importAI")
	public String importAI(@RequestParam("file") MultipartFile reapExcelDataFile, Model model ) throws IOException, ParseException {
				
	    workbook = new XSSFWorkbook(reapExcelDataFile.getInputStream());
	    XSSFSheet worksheet = workbook.getSheetAt(0);
	    XSSFRow row1 = worksheet.getRow(0);
	    MiseForme mForm = null;
	    ArrayList<MiseForme> msForm = new ArrayList<MiseForme>();
	    for(int i=0 ; i< row1.getLastCellNum() ; i++) {
	    	String headers = row1.getCell(i).getStringCellValue();
	    	mForm = new MiseForme(headers, i);
	    	msForm.add(mForm);
	    }
	   model.addAttribute("headerLists", msForm);
        return "wp1/AI/mise_formAI";
	}
	
	@PostMapping("/saveAI")
	public String saveAI(@RequestParam("code_pro") int code_pro,
			@RequestParam("nomPrenom_ai") int nomPrenom_ai, @RequestParam("genre_ai") int genre_ai,
			@RequestParam("annee_naiss") int annee_naiss,
			@RequestParam("date_suivi") int date_suivi , @RequestParam("type") int type, Model model ) throws IOException, ParseException {
	    XSSFSheet worksheet = workbook.getSheetAt(0);	
	    for(int i=1;i<worksheet.getPhysicalNumberOfRows() ;i++) {
	        XSSFRow row = worksheet.getRow(i);
	        String code_pr = row.getCell(code_pro).getStringCellValue();
	        String nomPr = row.getCell(nomPrenom_ai).getStringCellValue();
	        String genre = row.getCell(genre_ai).getStringCellValue();
	        String annee_nais = row.getCell(annee_naiss).getStringCellValue();
	        java.util.Date date_suiv = row.getCell(date_suivi).getDateCellValue();
	        String type_ai = row.getCell(type).getStringCellValue();
	        adopteInnovationService.addAdoption_innovation(code_pr, nomPr, genre, annee_nais, date_suiv, type_ai);
	        
	    }

	    return "redirect:/listAI";
	}
	
	@RequestMapping("/listAI")
	public String listAI(Model model) {
		List<Adoption_innovation> adopteInnovation = adopteInnovationService.ListAdoption_innovation();
		model.addAttribute("adopteInnovation", adopteInnovation);
		return "wp1/AI/listAI";
	}
	
	/* CANEVAS DE RESTITUTION DE  RECHERCHES */
	
	@RequestMapping("/uploadRecherche")
	public String uploadRecherche(Model model) {
		String[][] scList = ListeWp.wp();
		model.addAttribute("scList", scList);
		return "wp1/recherche/uploadRecherche";
	}
	
	@PostMapping("/importRecherche")
	public String importRecherche(@RequestParam("file") MultipartFile reapExcelDataFile, Model model ) throws IOException, ParseException {
				
	    workbook = new XSSFWorkbook(reapExcelDataFile.getInputStream());
	    XSSFSheet worksheet = workbook.getSheetAt(0);
	    XSSFRow row1 = worksheet.getRow(0);
	    MiseForme mForm = null;
	    ArrayList<MiseForme> msForm = new ArrayList<MiseForme>();
	    for(int i=0 ; i< row1.getLastCellNum() ; i++) {
	    	String headers = row1.getCell(i).getStringCellValue();
	    	mForm = new MiseForme(headers, i);
	    	msForm.add(mForm);
	    }
	   model.addAttribute("headerLists", msForm);
        return "wp1/recherche/mise_formRecherche";
	}
	
	@PostMapping("/saveRecherche")
	public String saveRecherche(@RequestParam("code_village") int code_village,
			@RequestParam("date_restitution") int date_restitution, @RequestParam("theme") int theme,
			@RequestParam("nbr_homme") int nbr_homme, @RequestParam("nbr_femme") int nbr_femme,
			@RequestParam("pr") int pr,
			@RequestParam("producteurs") int producteurs , @RequestParam("ep") int ep,
			@RequestParam("std_ctd") int std_ctd , @RequestParam("autres") int autres ,Model model ) throws IOException, ParseException {
	    XSSFSheet worksheet = workbook.getSheetAt(0);	
	    for(int i=1;i<worksheet.getPhysicalNumberOfRows() ;i++) {
	        XSSFRow row = worksheet.getRow(i);
	        String code_villag = row.getCell(code_village).getStringCellValue();
	        java.util.Date date_restit = row.getCell(date_restitution).getDateCellValue();
	        String themes = row.getCell(theme).getStringCellValue();
	        double nbr_hom =  row.getCell(nbr_homme).getNumericCellValue();
	        double nbr_fem = row.getCell(nbr_femme).getNumericCellValue();
	        boolean prs = row.getCell(pr).getStringCellValue().equalsIgnoreCase("Oui");
	        boolean product = row.getCell(producteurs).getStringCellValue().equalsIgnoreCase("Oui");
	        boolean std_ctds = row.getCell(std_ctd).getStringCellValue().equalsIgnoreCase("Oui");
	        boolean eps = row.getCell(ep).getStringCellValue().equalsIgnoreCase("Oui");
	        boolean autre = row.getCell(autres).getStringCellValue().equalsIgnoreCase("Oui");
	        rechercheService.addRecherche(code_villag,date_restit,themes, nbr_hom, nbr_fem, prs, product, eps, std_ctds, autre);
	        
	    }

	    return "redirect:/listRecherche";
	}
	
	@RequestMapping("/listRecherche")
	public String listRecherche(Model model) {
		List<Recherche> recherche = rechercheService.ListRecherche();
		model.addAttribute("recherche", recherche);
		return "wp1/recherche/listRecherche";
	}
	

	/* CANEVAS FERME D'ELEVAGE OPERATIONNEL  */
	
	@RequestMapping("/uploadElevage")
	public String uploadElevage(Model model) {
		String[][] scList = ListeWp.wp();
		model.addAttribute("scList", scList);
		return "wp1/elevage/uploadElevage";
	}
	
	@PostMapping("/importElevage")
	public String importElevage(@RequestParam("file") MultipartFile reapExcelDataFile, Model model ) throws IOException, ParseException {
				
	    workbook = new XSSFWorkbook(reapExcelDataFile.getInputStream());
	    XSSFSheet worksheet = workbook.getSheetAt(0);
	    XSSFRow row1 = worksheet.getRow(0);
	    MiseForme mForm = null;
	    ArrayList<MiseForme> msForm = new ArrayList<MiseForme>();
	    for(int i=0 ; i< row1.getLastCellNum() ; i++) {
	    	String headers = row1.getCell(i).getStringCellValue();
	    	mForm = new MiseForme(headers, i);
	    	msForm.add(mForm);
	    }
	   model.addAttribute("headerLists", msForm);
        return "wp1/elevage/mise_formElevage";
	}
	
	@PostMapping("/saveElevage")
	public String saveElevage(@RequestParam("code_village") int code_village,
			@RequestParam("nomResponsable") int nomResponsable, @RequestParam("x") int x,
			@RequestParam("y") int y,
			@RequestParam("genre_elev") int genre_elev , @RequestParam("annee_naiss") int annee_naiss, @RequestParam("date_mise") int date_mise,
			@RequestParam("tf") int tf , @RequestParam("nbr_visiteur") int nbr_visiteur, @RequestParam("date_suivi") int date_suivi, Model model ) throws IOException, ParseException {
		XSSFSheet worksheet = workbook.getSheetAt(0);	
	    for(int i=1;i<worksheet.getPhysicalNumberOfRows() ;i++) {
	        XSSFRow row = worksheet.getRow(i);
	        String code_villag = row.getCell(code_village).getStringCellValue();
	        String nomResponsabl = row.getCell(nomResponsable).getStringCellValue();
	        float cord_x = (float) row.getCell(x).getNumericCellValue();
	        float cord_y = (float) row.getCell(y).getNumericCellValue();
	        String genre = row.getCell(genre_elev).getStringCellValue();
	        int annee_nais = (int) row.getCell(annee_naiss).getNumericCellValue();
	        String pratique_realis = null;
	        int date_mis = (int) row.getCell(date_mise).getNumericCellValue();
	        String tfs = row.getCell(tf).getStringCellValue();
	        double nbr_visiteurs = row.getCell(nbr_visiteur).getNumericCellValue();
	        java.util.Date date_suiv = row.getCell(date_suivi).getDateCellValue();
	        System.out.println(tfs);;
	        elevageService.addElevage(code_villag, cord_x, cord_y, nomResponsabl, genre, annee_nais, pratique_realis, date_mis, tfs, nbr_visiteurs, date_suiv, false);
	        
	        
	    }

	    return "redirect:/listElevage";
	}
	
	@RequestMapping("/listElevage")
	public String listElevage(Model model) {
		List<Elevage> elevage = elevageService.ListElevage();
		model.addAttribute("elevage", elevage);
		return "wp1/elevage/listElevage";
	}
	
/* CANEVAS FORMATION SUR LES BONNES PRATIQUES DES PRODUCTEURS */
	
	@RequestMapping("/uploadFomBpa")
	public String uploadFomBpa(Model model) {
		String[][] scList = ListeWp.wp();
		model.addAttribute("scList", scList);
		return "wp1/FormBpa/uploadBpa";
	}
	
	@PostMapping("/importFomBpa")
	public String importFomBpa(@RequestParam("file") MultipartFile reapExcelDataFile, Model model ) throws IOException, ParseException {
				
	    workbook = new XSSFWorkbook(reapExcelDataFile.getInputStream());
	    XSSFSheet worksheet = workbook.getSheetAt(0);
	    XSSFRow row1 = worksheet.getRow(0);
	    MiseForme mForm = null;
	    ArrayList<MiseForme> msForm = new ArrayList<MiseForme>();
	    for(int i=0 ; i< row1.getLastCellNum() ; i++) {
	    	String headers = row1.getCell(i).getStringCellValue();
	    	mForm = new MiseForme(headers, i);
	    	msForm.add(mForm);
	    }
	   model.addAttribute("headerLists", msForm);
        return "wp1/FormBpa/mise_formFormBpa";
	}
	
	@PostMapping("/saveFomBpa")
	public String saveFomBpa(@RequestParam("code_pro") int code_pro,
			@RequestParam("code_village") int code_village, @RequestParam("nomPrenom_bpa") int nomPrenom_bpa,
			@RequestParam("genre_ai") int genre_ai,
			@RequestParam("frm_recu") int frm_recu , @RequestParam("annee_naiss") int annee_naiss, @RequestParam("date_frm") int date_frm,
			@RequestParam("theme_frm") int theme_frm , Model model ) throws IOException, ParseException {
		XSSFSheet worksheet = workbook.getSheetAt(0);	
	    for(int i=1;i<worksheet.getPhysicalNumberOfRows() ;i++) {
	        XSSFRow row = worksheet.getRow(i);
	        String code_pr = row.getCell(code_pro).getStringCellValue();
	        String code_villag = row.getCell(code_village).getStringCellValue();
	        String nomPrenom_bp =  row.getCell(nomPrenom_bpa).getStringCellValue();
	        String genre =  row.getCell(genre_ai).getStringCellValue();
	        String frm_rec = row.getCell(frm_recu).getStringCellValue();
	        int annee_nais = (int) row.getCell(annee_naiss).getNumericCellValue();
	        java.util.Date date_frms = row.getCell(date_frm).getDateCellValue();
	        String theme_frms = row.getCell(theme_frm).getStringCellValue();
	        formationBpaService.addFormation_bpa(code_pr, code_villag, nomPrenom_bp, genre, annee_nais, frm_rec, date_frms, theme_frms);
	        
	        
	    }

	    return "redirect:/listFomBpa";
	}
	
	@RequestMapping("/listFomBpa")
	public String listFomBpa(Model model) {
		List<Formation_bpa> formation = formationBpaService.ListFormation_bpa();
		model.addAttribute("formation", formation);
		return "wp1/FormBpa/listFormBpa";
	}
	
/* CANEVAS PARCELLES TESTS VANILLES */
	
	@RequestMapping("/uploadPt")
	public String uploadFomPt(Model model) {
		String[][] scList = ListeWp.wp();
		model.addAttribute("scList", scList);
		return "wp1/ParcelleTest/uploadPt";
	}
	
	@PostMapping("/importPt")
	public String importFomPt(@RequestParam("file") MultipartFile reapExcelDataFile, Model model ) throws IOException, ParseException {
				
	    workbook = new XSSFWorkbook(reapExcelDataFile.getInputStream());
	    XSSFSheet worksheet = workbook.getSheetAt(0);
	    XSSFRow row1 = worksheet.getRow(0);
	    MiseForme mForm = null;
	    ArrayList<MiseForme> msForm = new ArrayList<MiseForme>();
	    for(int i=0 ; i< row1.getLastCellNum() ; i++) {
	    	String headers = row1.getCell(i).getStringCellValue();
	    	mForm = new MiseForme(headers, i);
	    	msForm.add(mForm);
	    }
	   model.addAttribute("headerLists", msForm);
        return "wp1/ParcelleTest/mise_formPt";
	}
	
	@PostMapping("/savePt")
	public String savePt(@RequestParam("x") int x,
			@RequestParam("code_village") int code_village, 
			@RequestParam("y") int y,
			@RequestParam("nomResponsable") int nomResponsable , @RequestParam("annee_naiss") int annee_naiss, @RequestParam("genre_pt") int genre_pt,
			@RequestParam("date_mise") int date_mise , @RequestParam("superficies") int superficies,
			@RequestParam("pratique_realise") int pratique_realise , Model model ) throws IOException, ParseException {
		XSSFSheet worksheet = workbook.getSheetAt(0);	
	    for(int i=1;i<worksheet.getPhysicalNumberOfRows() ;i++) {
	        XSSFRow row = worksheet.getRow(i);
	        float coord_x = (float) row.getCell(x).getNumericCellValue();
	        String code_villag = row.getCell(code_village).getStringCellValue();
	        float coord_y =  (float) row.getCell(y).getNumericCellValue();
	        String nomResponsables = row.getCell(nomResponsable).getStringCellValue();
	        int annee_nais = (int) row.getCell(annee_naiss).getNumericCellValue();
	        String genre_pts = row.getCell(genre_pt).getStringCellValue();
	        String pratique_realises = row.getCell(pratique_realise).getStringCellValue();
	        java.util.Date date_mises = row.getCell(date_mise).getDateCellValue();
	        float superficie = (float) row.getCell(superficies).getNumericCellValue();
	        boolean operationnels = false;
	        java.util.Date date_suivis = null;
	        String technique_exergues = null;
	        Long nbr_participants = (long) 0;
	        String type = "TESTS VANILLES";
	        parcelleTestService.addParcelle_test(code_villag, coord_x, coord_y, nomResponsables, genre_pts, annee_nais, pratique_realises, date_mises, superficie, operationnels, date_suivis, technique_exergues, nbr_participants, type);
	        
	    }

	    return "redirect:/listPt";
	}
	
	@RequestMapping("/listPt")
	public String listPt(Model model) {
		List<Parcelle_test> pt = parcelleTestService.ListParcelle_test();
		model.addAttribute("pt", pt);
		return "wp1/ParcelleTest/listPt";
	}
	
	
/* CANEVAS PEPINIERE MISE EN PLACE */
	
	@RequestMapping("/uploadPepiniere")
	public String uploadFomPepiniere(Model model) {
		String[][] scList = ListeWp.wp();
		model.addAttribute("scList", scList);
		return "wp1/Pepiniere/uploadPepiniere";
	}
	
	@PostMapping("/importPepiniere")
	public String importFomPepiniere(@RequestParam("file") MultipartFile reapExcelDataFile, Model model ) throws IOException, ParseException {
				
	    workbook = new XSSFWorkbook(reapExcelDataFile.getInputStream());
	    XSSFSheet worksheet = workbook.getSheetAt(0);
	    XSSFRow row1 = worksheet.getRow(0);
	    MiseForme mForm = null;
	    ArrayList<MiseForme> msForm = new ArrayList<MiseForme>();
	    for(int i=0 ; i< row1.getLastCellNum() ; i++) {
	    	String headers = row1.getCell(i).getStringCellValue();
	    	mForm = new MiseForme(headers, i);
	    	msForm.add(mForm);
	    }
	   model.addAttribute("headerLists", msForm);
        return "wp1/Pepiniere/mise_formPepiniere";
	}
	
	@PostMapping("/savePepiniere")
	public String savePepiniere(@RequestParam("x") int x,
			@RequestParam("code_village") int code_village, 
			@RequestParam("y") int y,
			@RequestParam("nomResp") int nomResp , @RequestParam("annee_naiss") int annee_naiss, @RequestParam("genre_pep") int genre_pep,
			@RequestParam("annee_mise_place") int annee_mise_place ,@RequestParam("operationnel") int operationnel ,
			@RequestParam("date_suivi") int date_suivi , Model model ) throws IOException, ParseException {
		XSSFSheet worksheet = workbook.getSheetAt(0);	
	    for(int i=1;i<worksheet.getPhysicalNumberOfRows() ;i++) {
	        XSSFRow row = worksheet.getRow(i);
	        float coord_x = (float) row.getCell(x).getNumericCellValue();
	        String code_villag = row.getCell(code_village).getStringCellValue();
	        float coord_y =  (float) row.getCell(y).getNumericCellValue();
	        String nomResps = row.getCell(nomResp).getStringCellValue();
	        int annee_nais = (int) row.getCell(annee_naiss).getNumericCellValue();
	        String genre_peps = row.getCell(genre_pep).getStringCellValue();
	        boolean operationnels = row.getCell(operationnel).getStringCellValue().equalsIgnoreCase("Oui");
	        java.util.Date date_suivis = row.getCell(date_suivi).getDateCellValue();
	        int annee_mise_places = (int) row.getCell(annee_mise_place).getNumericCellValue();
	       pepiniereService.addPepiniere(code_villag, coord_x, coord_y, nomResps, genre_peps, annee_nais, annee_mise_places, operationnels, date_suivis);
	        
	    }

	    return "redirect:/listPepiniere";
	}
	
	@RequestMapping("/listPepiniere")
	public String listPepiniere(Model model) {
		List<Pepiniere> pepiniere = pepiniereService.ListPepiniere();
		model.addAttribute("pepiniere", pepiniere);
		return "wp1/Pepiniere/listPepiniere";
	}
	
/* CANEVAS AGENT DE SANTE ANIMAL OPERATIONNEL */
	
	@RequestMapping("/uploadSA")
	public String uploadSA(Model model) {
		String[][] scList = ListeWp.wp();
		model.addAttribute("scList", scList);
		return "wp1/SA/uploadSA";
	}
	
	@PostMapping("/importSA")
	public String importSA(@RequestParam("file") MultipartFile reapExcelDataFile, Model model ) throws IOException, ParseException {
				
	    workbook = new XSSFWorkbook(reapExcelDataFile.getInputStream());
	    XSSFSheet worksheet = workbook.getSheetAt(0);
	    XSSFRow row1 = worksheet.getRow(0);
	    MiseForme mForm = null;
	    ArrayList<MiseForme> msForm = new ArrayList<MiseForme>();
	    for(int i=0 ; i< row1.getLastCellNum() ; i++) {
	    	String headers = row1.getCell(i).getStringCellValue();
	    	mForm = new MiseForme(headers, i);
	    	msForm.add(mForm);
	    }
	   model.addAttribute("headerLists", msForm);
        return "wp1/SA/mise_formSA";
	}
	
	@PostMapping("/saveSA")
	public String saveSA(@RequestParam("genre_sa") int genre_sa,
			@RequestParam("code_village") int code_village, 
			@RequestParam("date_mise_place") int date_mise_place,
			@RequestParam("nomPrenom") int nomPrenom , @RequestParam("annee_naiss") int annee_naiss ,@RequestParam("operationnel") int operationnel ,
			@RequestParam("date_suivi") int date_suivi , Model model ) throws IOException, ParseException {
		XSSFSheet worksheet = workbook.getSheetAt(0);	
	    for(int i=1;i<worksheet.getPhysicalNumberOfRows() ;i++) {
	        XSSFRow row = worksheet.getRow(i);
	        String genre_sas = row.getCell(genre_sa).getStringCellValue();
	        String code_villag = row.getCell(code_village).getStringCellValue();
	        String nomPrenoms = row.getCell(nomPrenom).getStringCellValue();
	        int annee_nais = (int) row.getCell(annee_naiss).getNumericCellValue();
	        boolean operationnels = row.getCell(operationnel).getStringCellValue().equalsIgnoreCase("Oui");
	        java.util.Date date_suivis = row.getCell(date_suivi).getDateCellValue();
	        java.util.Date date_mise_places =  row.getCell(date_mise_place).getDateCellValue();
	       sante_animalService.addSante_animal(code_villag, nomPrenoms, genre_sas, annee_nais, operationnels, date_mise_places, date_suivis);
	        
	    }

	    return "redirect:/listSA";
	}
	
	@RequestMapping("/listSA")
	public String listSA(Model model) {
		List<Sante_animal> sa = sante_animalService.ListSante_animal();
		model.addAttribute("sa", sa);
		return "wp1/SA/listSA";
	}
	
/* CANEVAS PERSONNES RESSOURCES */
	
	@RequestMapping("/uploadPr")
	public String uploadPr(Model model) {
		String[][] scList = ListeWp.wp();
		model.addAttribute("scList", scList);
		return "wp1/person_res/uploadPr";
	}
	
	@PostMapping("/importPr")
	public String importPr(@RequestParam("file") MultipartFile reapExcelDataFile, Model model ) throws IOException, ParseException {
				
	    workbook = new XSSFWorkbook(reapExcelDataFile.getInputStream());
	    XSSFSheet worksheet = workbook.getSheetAt(0);
	    XSSFRow row1 = worksheet.getRow(0);
	    MiseForme mForm = null;
	    ArrayList<MiseForme> msForm = new ArrayList<MiseForme>();
	    for(int i=0 ; i< row1.getLastCellNum() ; i++) {
	    	String headers = row1.getCell(i).getStringCellValue();
	    	mForm = new MiseForme(headers, i);
	    	msForm.add(mForm);
	    }
	   model.addAttribute("headerLists", msForm);
        return "wp1/person_res/mise_formPr";
	}
	
	@PostMapping("/savePr")
	public String savePr(@RequestParam("genre_pr") int genre_pr,
			@RequestParam("code_village") int code_village, 
			@RequestParam("types_services_dev") int types_services_dev,
			@RequestParam("nomPrenom") int nomPrenom , @RequestParam("annee_naiss") int annee_naiss ,@RequestParam("operationnalite") int operationnalite ,
			@RequestParam("date_suivi") int date_suivi , Model model ) throws IOException, ParseException {
		XSSFSheet worksheet = workbook.getSheetAt(0);	
	    for(int i=1;i<worksheet.getPhysicalNumberOfRows() ;i++) {
	        XSSFRow row = worksheet.getRow(i);
	        String genre_prs = row.getCell(genre_pr).getStringCellValue();
	        String code_villag = row.getCell(code_village).getStringCellValue();
	        String nomPrenoms = row.getCell(nomPrenom).getStringCellValue();
	        int annee_nais = (int) row.getCell(annee_naiss).getNumericCellValue();
	        boolean operationnels = row.getCell(operationnalite).getStringCellValue().equalsIgnoreCase("Oui");
	        java.util.Date date_suivis = row.getCell(date_suivi).getDateCellValue();
	        String types_services_devs =  row.getCell(types_services_dev).getStringCellValue();
	       person_resService.addPerson_res(code_villag, nomPrenoms, genre_prs, annee_nais, operationnels, date_suivis, types_services_devs);
	        
	    }

	    return "redirect:/listPr";
	}
	
	@RequestMapping("/listPr")
	public String listPr(Model model) {
		List<Person_res> pr = person_resService.ListPerson_res();
		model.addAttribute("pr", pr);
		return "wp1/person_res/listPr";
	}
	
/* CANEVAS FORMATEURS FBS/POST FBS */
	
	@RequestMapping("/uploadFormateur")
	public String uploadFormateur(Model model) {
		String[][] scList = ListeWp.wp();
		model.addAttribute("scList", scList);
		return "wp1/formateur/uploadFormateur";
	}
	
	@PostMapping("/importFormateur")
	public String importFormateur(@RequestParam("file") MultipartFile reapExcelDataFile, Model model ) throws IOException, ParseException {
				
	    workbook = new XSSFWorkbook(reapExcelDataFile.getInputStream());
	    XSSFSheet worksheet = workbook.getSheetAt(0);
	    XSSFRow row1 = worksheet.getRow(0);
	    MiseForme mForm = null;
	    ArrayList<MiseForme> msForm = new ArrayList<MiseForme>();
	    for(int i=0 ; i< row1.getLastCellNum() ; i++) {
	    	String headers = row1.getCell(i).getStringCellValue();
	    	mForm = new MiseForme(headers, i);
	    	msForm.add(mForm);
	    }
	   model.addAttribute("headerLists", msForm);
        return "wp1/formateur/mise_formFormateur";
	}
	
	@PostMapping("/saveFormateur")
	public String saveFormateur(@RequestParam("code_village") int code_village, 
			@RequestParam("zoneInterv") int zoneInterv,
			@RequestParam("nomPrenom") int nomPrenom , @RequestParam("annee_naiss") int annee_naiss ,@RequestParam("operationnalite") int operationnalite ,
			@RequestParam("date_debut") int date_debut , @RequestParam("date_fin") int date_fin ,
			@RequestParam("date_suivi") int date_suivi , Model model ) throws IOException, ParseException {
		XSSFSheet worksheet = workbook.getSheetAt(0);	
	    for(int i=1;i<worksheet.getPhysicalNumberOfRows() ;i++) {
	        XSSFRow row = worksheet.getRow(i);
	        String zoneIntervs = row.getCell(zoneInterv).getStringCellValue();
	        String code_villag = row.getCell(code_village).getStringCellValue();
	        String nomPrenoms = row.getCell(nomPrenom).getStringCellValue();
	        int annee_nais = (int) row.getCell(annee_naiss).getNumericCellValue();
	        boolean operationnels = row.getCell(operationnalite).getStringCellValue().equalsIgnoreCase("Oui");
	        java.util.Date date_debuts = row.getCell(date_debut).getDateCellValue();
	        java.util.Date date_fins = row.getCell(date_fin).getDateCellValue();
	        java.util.Date date_suivis = row.getCell(date_suivi).getDateCellValue();
	        String type_forms =  "FBS/POST";
	        formateursService.addFormateur(code_villag, nomPrenoms, zoneIntervs, null, annee_nais, operationnels, null, date_suivis, date_debuts, date_fins, type_forms);
	        
	    }

	    return "redirect:/listFormateur";
	}
	
	@RequestMapping("/listFormateur")
	public String listFormateur(Model model) {
		List<Formateur> formateur =  formateursService.ListElevage("FBS/POST");;
		model.addAttribute("formateur", formateur);
		return "wp1/formateur/listFormateur";
	}
}
