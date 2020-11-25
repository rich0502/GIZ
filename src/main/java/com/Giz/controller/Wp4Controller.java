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
import com.Giz.data.domain.AtelierMFR;
import com.Giz.data.domain.DocCap;
import com.Giz.data.domain.MiseForme;
import com.Giz.data.domain.Plateforme;
import com.Giz.service.metier.AtelierMFRService;
import com.Giz.service.metier.DocCapService;
import com.Giz.service.metier.PlateformeService;

@Controller
public class Wp4Controller {
	
	@Autowired
	DocCapService docCapService;
	
	@Autowired
	AtelierMFRService atelierMFRService;
	
	@Autowired
	PlateformeService plateformeService;

	XSSFWorkbook workbook;
	
	String type_at=null;
	
	public String canevas(int nbr_canevas) {
	    String result;
	    switch (nbr_canevas) {
	        case 52:
	            result = "CANEVAS ATELIERS/EVENEMENTS PROMOTIONNELS DU RESEAU DE MFR DANS LA REGION"; 
	            break;
	        case 53:
	            result = "CANEVAS DIALOGUE REGIONAL SUR L'ACCES AU FINANCEMENT";
	            break;
	        case 54:
	            result = "CANEVAS ATELIERS DE CAPITALISATION ET PARTAGE DES ACQUIS";
	            break;
	        case 55:
	            result = "CANEVAS ATELIERS/EVENEMENTS PROMOTIONNELS DE MAHAVELONA DANS LA SAVA";
	            break;
	        case 57:
	            result = "CANEVAS EXISTENCE DE DISPOSITIF CONCERTE DE SUIVI ET PROTECTION DES ENFANTS";
	            break;
	        case 58:
	            result = "CANEVAS PLATE FORME DE REFLEXION ET DE PLANIFICATION DE L'AMELIORATION DE LA FORMATION PROFESSIONNELLE";
	            break;
	        case 59:
	            result = "CANEVAS PLATE FORME DE CONCERTATION ET DE PLANIFICATION SUR L'ENVIRONNEMENT, BIODIVERSITE ET CHANGEMENT CLIMATIQUE DANS LA REGION SAVA";
	            break;
	        default:
	            result = "CANEVAS ATELIERS DE PARTAGES DES BONNES PRATIQUES ET OUTILS AUX PRODUCTEURS DE VANILLE";
	            break;
	    }
	    return result;
	}
	
	/* CANEVAS PARTAGE DE DOCUMENT DE CAPITALISATION AUX ACTEURS  */
	
	@RequestMapping("/uploadDocCap")
	public String uploadDocCap(Model model) {
		String[][] scList = ListeWp.wp();
		model.addAttribute("scList", scList);
		return "wp4/DocCap/uploadDocCap";
	}
	
	
	@PostMapping("/importDocCap")
	public String importDocCap(@RequestParam("file") MultipartFile reapExcelDataFile, Model model ) throws IOException, ParseException {
				
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
        return "wp4/DocCap/mise_formDocCap";
	}
	
	@PostMapping("/saveDocCap")
	public String saveDocCap(@RequestParam("thematique") int thematique,@RequestParam("titre_doc") int titre_doc,
			@RequestParam("type_doc") int type_doc, @RequestParam("auteur_doc") int auteur_doc,
			@RequestParam("date_partage") int date_partage,
			@RequestParam("reception") int reception , Model model ) throws IOException, ParseException {
	    XSSFSheet worksheet = workbook.getSheetAt(0);	
	    for(int i=1;i<worksheet.getPhysicalNumberOfRows() ;i++) {
	        XSSFRow row = worksheet.getRow(i);
	        String thematiques = row.getCell(thematique).getStringCellValue();
	        String titre_docs = row.getCell(titre_doc).getStringCellValue();
	        String type_docs = row.getCell(type_doc).getStringCellValue();
	        String auteur_docs = row.getCell(auteur_doc).getStringCellValue();
	        java.util.Date date_partages = row.getCell(date_partage).getDateCellValue();
	        String receptions = row.getCell(reception).getStringCellValue();
	        docCapService.addDocCap(titre_docs,thematiques, type_docs, auteur_docs, date_partages, receptions);
	        
	    }

	    return "redirect:/listDocCap";
	}
	
	@RequestMapping("/listDocCap")
	public String listDocCap(Model model) {
		List<DocCap> docCap = docCapService.ListDocCap();
		model.addAttribute("docCap", docCap);
		return "wp4/DocCap/listDocCap";
	}
	
	/* CANEVAS ATELIERS/EVENEMENTS PROMOTIONNELS DU RESEAU DE MFR DANS LA REGION */
	@RequestMapping("/uploadAtelier")
	public String uploadAtelier(Model model) {
		int canevas = 52;
		String nameCanevas = canevas(canevas);
		model.addAttribute("canevas", canevas);
		model.addAttribute("nameCanevas", nameCanevas);
		String[][] scList = ListeWp.wp();
		model.addAttribute("scList", scList);
		return "wp4/AtelierMFR/uploadAtelier";
	}
	
	
	@PostMapping("/importAtelier")
	public String importAtelier(@RequestParam("file") MultipartFile reapExcelDataFile, @RequestParam("canevas") int canevas, Model model ) throws IOException, ParseException {

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
		model.addAttribute("canevas", canevas);
	   model.addAttribute("headerLists", msForm);
        return "wp4/AtelierMFR/mise_formAtelier";
	}
	
	@PostMapping("/saveAtelier")
	public String saveAtelier(@RequestParam("code_village") int code_village,@RequestParam("atelier_resp") int atelier_resp,
			@RequestParam("date_realise") int date_realise, @RequestParam("lieu_realise") int lieu_realise,@RequestParam("cible_atelier") int cible_atelier,
			@RequestParam("nbr_particip") int nbr_particip, @RequestParam("nbr_homme") int nbr_homme, @RequestParam("nbr_femme") int nbr_femme,@RequestParam("canevas") int canevas,
			@RequestParam("theme_choise") int theme_choise , Model model ) throws IOException, ParseException {
		System.out.println("io iz e! " + canevas + " ererer : " + canevas(canevas));
	    XSSFSheet worksheet = workbook.getSheetAt(0);	
	    for(int i=1;i<worksheet.getPhysicalNumberOfRows() ;i++) {
	        XSSFRow row = worksheet.getRow(i);
	        String code_villages = row.getCell(code_village).getStringCellValue();
	        String atelier_resps = row.getCell(atelier_resp).getStringCellValue();
	        String theme_choises = row.getCell(theme_choise).getStringCellValue();
	        String lieu_realises = row.getCell(lieu_realise).getStringCellValue();
	        java.util.Date date_realises = row.getCell(date_realise).getDateCellValue();
	        long nbr_particips = (long) row.getCell(nbr_particip).getNumericCellValue();
	        int nbr_hommes = (int) row.getCell(nbr_homme).getNumericCellValue();
	        int nbr_femmes = (int) row.getCell(nbr_femme).getNumericCellValue();
	        String cible_ateliers = row.getCell(cible_atelier).getStringCellValue();
	        type_at = canevas(canevas);
	        atelierMFRService.addAtelierMFR(code_villages, atelier_resps, date_realises, lieu_realises, theme_choises, nbr_particips, nbr_hommes, nbr_femmes, cible_ateliers, canevas(canevas));
	    }

	    return "redirect:/listAtelier";
	}
	
	@RequestMapping("/listAtelier")
	public String listAtelier(Model model) {
		System.out.println("afin" + type_at);
		List<AtelierMFR> atelier = atelierMFRService.fetchAtelier(type_at);
		model.addAttribute("atelier", atelier);
		model.addAttribute("type_at", type_at);
		return "wp4/AtelierMFR/listAtelier";
	}
	
	/* CANEVAS DIALOGUE REGIONAL SUR L'ACCES AU FINANCEMENT */
	@RequestMapping("/uploadAccesFinance")
	public String uploadAccesFinance(Model model) {
		String[][] scList = ListeWp.wp();
		int canevas = 53;
		String nameCanevas = canevas(canevas);
		model.addAttribute("canevas", canevas);
		model.addAttribute("nameCanevas", nameCanevas);
		model.addAttribute("scList", scList);
		return "wp4/AtelierMFR/uploadAtelier";
	}
	
	/* CANEVAS ATELIERS DE CAPITALISATION ET PARTAGE DES ACQUIS  */ 
	@RequestMapping("/uploadPartageAcquis")
	public String uploadPartageAcquis(Model model) {
		String[][] scList = ListeWp.wp();
		int canevas = 54;
		String nameCanevas = canevas(canevas);
		model.addAttribute("canevas", canevas);
		model.addAttribute("nameCanevas", nameCanevas);
		model.addAttribute("scList", scList);
		return "wp4/AtelierMFR/uploadAtelier";
	}
	
	/* CANEVAS ATELIERS/EVENEMENTS PROMOTIONNELS DE MAHAVELONA DANS LA SAVA*/
	
	@RequestMapping("/uploadMahavelona")
	public String uploadMahavelona(Model model) {
		String[][] scList = ListeWp.wp();
		int canevas = 55;
		String nameCanevas = canevas(canevas);
		model.addAttribute("canevas", canevas);
		model.addAttribute("nameCanevas", nameCanevas);
		model.addAttribute("scList", scList);
		return "wp4/AtelierMFR/uploadAtelier";
	}
	
	/* CANEVAS ATELIERS DE PARTAGES DES BONNES PRATIQUES ET OUTILS AUX PRODUCTEURS DE VANILLE*/
	
	@RequestMapping("/uploadPratiqueProdVanille")
	public String uploadPratiqueProdVanille(Model model) {
		String[][] scList = ListeWp.wp();
		int canevas = 56;
		String nameCanevas = canevas(canevas);
		model.addAttribute("canevas", canevas);
		model.addAttribute("nameCanevas", nameCanevas);
		model.addAttribute("scList", scList);
		return "wp4/AtelierMFR/uploadAtelier";
	}
	
	/*  CANEVAS EXISTENCE DE DISPOSITIF CONCERTE DE SUIVI ET PROTECTION DES ENFANTS */
	
	@RequestMapping("/uploadPlateforme")
	public String uploadPlateforme(Model model) {
		int canevas = 57;
		String nameCanevas = canevas(canevas);
		model.addAttribute("canevas", canevas);
		model.addAttribute("nameCanevas", nameCanevas);
		String[][] scList = ListeWp.wp();
		model.addAttribute("scList", scList);
		return "wp4/plateforme/uploadPlateforme";
	}
	
	
	@PostMapping("/importPlateforme")
	public String importPlateforme(@RequestParam("file") MultipartFile reapExcelDataFile, @RequestParam("canevas") int canevas, Model model ) throws IOException, ParseException {
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
		model.addAttribute("canevas", canevas);
	   model.addAttribute("headerLists", msForm);
        return "wp4/plateforme/mise_formPlateforme";
	}
	
	@PostMapping("/savePlateforme")
	public String savePlateforme(@RequestParam("code_village") int code_village,@RequestParam("exist_platform") int exist_platform,
			@RequestParam("operationnel") int operationnel, @RequestParam("date_suivi") int date_suivi,@RequestParam("commentaire") int commentaire,
			@RequestParam("canevas") int canevas, Model model ) throws IOException, ParseException {
	    XSSFSheet worksheet = workbook.getSheetAt(0);	
	    for(int i=1;i<worksheet.getPhysicalNumberOfRows() ;i++) {
	        XSSFRow row = worksheet.getRow(i);
	        String code_villages = row.getCell(code_village).getStringCellValue();
	        boolean exist_platforms = row.getCell(exist_platform).getStringCellValue().equalsIgnoreCase("Oui");
	        boolean operationnels = row.getCell(operationnel).getStringCellValue().equalsIgnoreCase("Oui");
	        java.util.Date date_suivis = row.getCell(date_suivi).getDateCellValue();
	        String commentaires = row.getCell(commentaire).getStringCellValue();
	        type_at = canevas(canevas);
	        plateformeService.addPlateforme(code_villages, exist_platforms, operationnels, date_suivis, commentaires, canevas(canevas));
	    }

	    return "redirect:/listPlateforme";
	}
	
	@RequestMapping("/listPlateforme")
	public String listPlateformer(Model model) {
		List<Plateforme> plate = plateformeService.fetchPlateforme(type_at);
		model.addAttribute("plate", plate);
		model.addAttribute("type_at", type_at);
		return "wp4/plateforme/listPlateforme";
	}
	
	/* CANEVAS PLATE FORME DE REFLEXION ET DE PLANIFICATION DE L'AMELIORATION DE LA FORMATION PROFESSIONNELLE */
	@RequestMapping("/uploadPlateFormation")
	public String uploadPlateFormation(Model model) {
		int canevas = 58;
		String nameCanevas = canevas(canevas);
		model.addAttribute("canevas", canevas);
		model.addAttribute("nameCanevas", nameCanevas);
		String[][] scList = ListeWp.wp();
		model.addAttribute("scList", scList);
		return "wp4/plateforme/uploadPlateforme";
	}
	
	/* CANEVAS PLATE FORME DE CONCERTATION ET DE PLANIFICATION SUR L'ENVIRONNEMENT, BIODIVERSITE ET CHANGEMENT CLIMATIQUE DANS LA REGION SAVA */
	@RequestMapping("/uploadPlateBio")
	public String uploadPlateBio(Model model) {
		int canevas = 59;
		String nameCanevas = canevas(canevas);
		model.addAttribute("canevas", canevas);
		model.addAttribute("nameCanevas", nameCanevas);
		String[][] scList = ListeWp.wp();
		model.addAttribute("scList", scList);
		return "wp4/plateforme/uploadPlateforme";
	}

	
}
