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
import com.Giz.data.domain.Beneficiaire;
import com.Giz.data.domain.MiseForme;
import com.Giz.data.domain.Recherche;
import com.Giz.service.metier.AdopteInnovationService;
import com.Giz.service.metier.BeneficiaireService;
import com.Giz.service.metier.RechercheService;







@Controller
public class Wp1Controller {
	
	@Autowired
	BeneficiaireService beneficiaireService;
	
	@Autowired
	AdopteInnovationService adopteInnovationService;
	
	@Autowired
	RechercheService rechercheService;

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
	
	@PostMapping("/importMWp1")
	public String importM(@RequestParam("nom_bf") int nom_bf,
			@RequestParam("prenom_bf") int prenom_bf, @RequestParam("adresse_bf") int adresse_bf,
			@RequestParam("contact_bf") int contact_bf,
			@RequestParam("date_naiss_bf") int date_naiss_bf, Model model ) throws IOException, ParseException {
	    //List<Beneficiaire> beneficiaireList = new ArrayList<Beneficiaire>();
	    XSSFSheet worksheet = workbook.getSheetAt(0);	    
	    for(int i=1;i<worksheet.getPhysicalNumberOfRows() ;i++) {
	        XSSFRow row = worksheet.getRow(i);
	        String nom = row.getCell(nom_bf).getStringCellValue();
	        String prenom = row.getCell(prenom_bf).getStringCellValue();
	        String adresse = row.getCell(adresse_bf).getStringCellValue();
	        SimpleDateFormat  formater = new SimpleDateFormat("yyyy-MM-dd");
	        String date_naiss =formater.format(row.getCell(date_naiss_bf).getDateCellValue());
	        String contact = row.getCell(contact_bf).getStringCellValue();
	        beneficiaireService.addBeneficiaire(nom, prenom, adresse, null, contact, date_naiss);
	    }

	    return "redirect:/beneficiaire";
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
	
}
