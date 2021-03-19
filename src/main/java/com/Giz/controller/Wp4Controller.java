package com.Giz.controller;


import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	@GetMapping("/DocCapForm")
	public String DocCapForm(Model model) throws Exception {
		return "wp4/DocCap/Form_addDocCap";
	}

	@PostMapping("/createDocCap")
	public String createDocCap(
			@RequestParam("titre_doc") String titre_doc,
			@RequestParam("thematique") String thematique,
			@RequestParam("type_doc") String type_doc,
			@RequestParam("auteur_doc") String auteur_doc,
			@RequestParam("date_partage") java.sql.Date date_partage,
			@RequestParam("reception") String reception,
			RedirectAttributes redirectAttributes) throws Exception {
		docCapService.addDocCap( titre_doc, thematique, type_doc, auteur_doc, date_partage, reception);
		return "redirect:/listDocCap";

	}
	
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
			@RequestParam("reception") int reception , Model model , RedirectAttributes redirAttrs) throws IOException, ParseException {
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
	    redirAttrs.addFlashAttribute("success", "Données importer avec succès");
	    return "redirect:/listDocCap";
	}
	
	@RequestMapping("/listDocCap")
	public String listDocCap(Model model) {
		List<DocCap> docCap = docCapService.ListDocCap();
		model.addAttribute("docCap", docCap);
		return "wp4/DocCap/listDocCap";
	}
	
	@RequestMapping("/deleteDocCap/{id_dc}")
	public String deleteDocCap(@PathVariable(name = "id_dc") Long id_dc) {
		docCapService.deleteDocCap(id_dc);
		return "redirect:/listDocCap";
	}
	
	@RequestMapping("/editDocCap/{id_dc}")
	public ModelAndView editDocCap(@PathVariable(name = "id_dc") Long id_dc, Model model) throws ParseException {
		ModelAndView mav = new ModelAndView("wp4/DocCap/Form_modifDocCap");
		Optional<DocCap> bf = docCapService.findByIdDocCap(id_dc);
		mav.addObject("docCap", bf);
		return mav;
	}
	
	@RequestMapping(value = "/saveEditDocCap", method = RequestMethod.POST)
	public String saveEditDocCap(
			@RequestParam("id_dc") long id_dc,
			@RequestParam("titre_doc") String titre_doc,
			@RequestParam("thematique") String thematique,
			@RequestParam("type_doc") String type_doc,
			@RequestParam("auteur_doc") String auteur_doc,
			@RequestParam("date_partage") java.sql.Date date_partage,
			@RequestParam("reception") String reception,
			RedirectAttributes redirectAttributes) throws ParseException {
		docCapService.modifyDocCap( titre_doc, thematique, type_doc, auteur_doc, date_partage, reception, id_dc);
		return "redirect:/listDocCap";
	}
	
	/* CANEVAS ATELIERS/EVENEMENTS PROMOTIONNELS DU RESEAU DE MFR DANS LA REGION */
	
	@GetMapping("/AtelierMFRForm")
	public String AtelierMFRForm(Model model) throws Exception {
		return "wp4/AtelierMFR/Form_addAtelierMFR";
	}

	@PostMapping("/createAtelierMFR")
	public String createAtelierMFR(
			@RequestParam("code_village") String code_village,
			@RequestParam("atelier_resp") String atelier_resp,
			@RequestParam("date_realise") java.sql.Date date_realise,
			@RequestParam("lieu_realise") String lieu_realise,
			@RequestParam("theme_choise") String theme_choise,
			@RequestParam("nbr_particip") long nbr_particip,
			@RequestParam("nbr_homme") int nbr_homme,
			@RequestParam("nbr_femme") int nbr_femme, 
			@RequestParam("cible_atelier") String cible_atelier,
			@RequestParam("type_atelier") String type_atelier,
			RedirectAttributes redirectAttributes) throws ParseException {
		type_at = type_atelier;
		atelierMFRService.addAtelierMFR( code_village, atelier_resp, date_realise, lieu_realise, theme_choise, nbr_particip, nbr_homme, nbr_femme, cible_atelier, type_atelier);
		return "redirect:/listAtelier";

	}
	
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
			@RequestParam("theme_choise") int theme_choise , Model model , RedirectAttributes redirAttrs) throws IOException, ParseException {
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
	    redirAttrs.addFlashAttribute("success", "Données importer avec succès");
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
	
	@RequestMapping("/deleteAtelierMFR/{id_am}")
	public String deleteAtelierMFR(@PathVariable(name = "id_am") Long id_am) {
		atelierMFRService.deleteAtelierMFR(id_am);
		return "redirect:/listAtelier";
	}
	
	@RequestMapping("/editAtelierMFR/{id_am}")
	public ModelAndView editAtelierMFR(@PathVariable(name = "id_am") Long id_am, Model model) throws ParseException {
		ModelAndView mav = new ModelAndView("wp4/AtelierMFR/Form_modifAtelierMFR");
		Optional<AtelierMFR> bf = atelierMFRService.findByIdAtelierMFR(id_am);
		mav.addObject("atelierMFR", bf);
		return mav;
	}
	
	@RequestMapping(value = "/saveEditAtelierMFR", method = RequestMethod.POST)
	public String saveEditAtelierMFR(
			@RequestParam("id_am") long id_am,
			@RequestParam("code_village") String code_village,
			@RequestParam("atelier_resp") String atelier_resp,
			@RequestParam("date_realise") java.sql.Date date_realise,
			@RequestParam("lieu_realise") String lieu_realise,
			@RequestParam("theme_choise") String theme_choise,
			@RequestParam("nbr_particip") long nbr_particip,
			@RequestParam("nbr_homme") int nbr_homme,
			@RequestParam("nbr_femme") int nbr_femme, 
			@RequestParam("cible_atelier") String cible_atelier,
			@RequestParam("type_atelier") String type_atelier,
			RedirectAttributes redirectAttributes) throws ParseException {
		type_at = type_atelier;
		atelierMFRService.modifyAtelierMFR( code_village, atelier_resp, date_realise, lieu_realise, theme_choise, nbr_particip, nbr_homme, nbr_femme, cible_atelier, type_atelier, id_am);
		return "redirect:/listAtelier";
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
	
	@GetMapping("/PlateformeForm")
	public String PlateformeForm(Model model) throws Exception {
		return "wp4/plateforme/Form_addPlateforme";
	}

	@PostMapping("/createPlateforme")
	public String createPlateforme(
			@RequestParam("code_village") String code_village,
			@RequestParam("exist_platform") Boolean exist_platform,
			@RequestParam("operationnel") Boolean operationnel,
			@RequestParam("date_suivi") java.sql.Date date_suivi,
			@RequestParam("commentaire") String commentaire,
			@RequestParam("type_plateform") String type_plateform,
			RedirectAttributes redirectAttributes) throws ParseException {
		type_at = type_plateform;
		plateformeService.addPlateforme(  code_village,  exist_platform,  operationnel,  date_suivi, commentaire,  type_plateform);
		return "redirect:/listPlateforme";

	}
	
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
			@RequestParam("canevas") int canevas, Model model , RedirectAttributes redirAttrs) throws IOException, ParseException {
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
	    redirAttrs.addFlashAttribute("success", "Données importer avec succès");
	    return "redirect:/listPlateforme";
	}
	
	@RequestMapping("/listPlateforme")
	public String listPlateformer(Model model) {
		List<Plateforme> plate = plateformeService.fetchPlateforme(type_at);
		model.addAttribute("plate", plate);
		model.addAttribute("type_at", type_at);
		return "wp4/plateforme/listPlateforme";
	}
	
	@RequestMapping("/deletePlateforme/{id_am}")
	public String deletePlateforme(@PathVariable(name = "id_am") Long id_am) {
		plateformeService.deletePlateforme(id_am);
		return "redirect:/listPlateforme";
	}
	
	@RequestMapping("/editPlateforme/{id_am}")
	public ModelAndView editPlateforme(@PathVariable(name = "id_am") Long id_am, Model model) throws ParseException {
		ModelAndView mav = new ModelAndView("wp4/plateforme/Form_modifPlateforme");
		Optional<Plateforme> bf = plateformeService.findByIdPlateforme(id_am);
		mav.addObject("plateforme", bf);
		return mav;
	}
	
	@RequestMapping(value = "/saveEditPlateforme", method = RequestMethod.POST)
	public String saveEditPlateforme(
			@RequestParam("id_am") long id_am,
			@RequestParam("code_village") String code_village,
			@RequestParam("exist_platform") Boolean exist_platform,
			@RequestParam("operationnel") Boolean operationnel,
			@RequestParam("date_suivi") java.sql.Date date_suivi,
			@RequestParam("commentaire") String commentaire,
			@RequestParam("type_plateform") String type_plateform,
			RedirectAttributes redirectAttributes) throws ParseException {
		type_at = type_plateform;
		plateformeService.modifyPlateforme(  code_village,  exist_platform,  operationnel,  date_suivi, commentaire,  type_plateform, id_am);
		return "redirect:/listPlateforme";
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
