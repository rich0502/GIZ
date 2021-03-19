package com.Giz.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Giz.data.constants.theme.ListeWp;
import com.Giz.data.domain.Elevage;
import com.Giz.data.domain.Formateur;
import com.Giz.data.domain.Formations;
import com.Giz.data.domain.MiseForme;
import com.Giz.data.domain.Parcelle_test;
import com.Giz.service.metier.ElevageService;
import com.Giz.service.metier.FormateurService;
import com.Giz.service.metier.FormationsService;
import com.Giz.service.metier.ParcelleTestService;

@Controller
public class Wp1AController {

	XSSFWorkbook workbook;

	@Autowired
	ElevageService elevageService;

	@Autowired
	ParcelleTestService parcelleTestService;

	@Autowired
	FormationsService formationsService;

	@Autowired
	FormateurService formateurService;

	@Autowired
	FormateurService formateursService;

	/* CANEVAS FERME DE REFERENCE */

	@RequestMapping("/uploadFerme")
	public String uploadFormateur(Model model) {
		String[][] scList = ListeWp.wp();
		model.addAttribute("scList", scList);
		return "wp1/Elevage/uploadFerme";
	}

	@PostMapping("/importFerme")
	public String importFormateur(@RequestParam("file") MultipartFile reapExcelDataFile, Model model)
			throws IOException, ParseException {

		workbook = new XSSFWorkbook(reapExcelDataFile.getInputStream());
		XSSFSheet worksheet = workbook.getSheetAt(0);
		XSSFRow row1 = worksheet.getRow(0);
		MiseForme mForm = null;
		ArrayList<MiseForme> msForm = new ArrayList<MiseForme>();
		for (int i = 0; i < row1.getLastCellNum(); i++) {
			String headers = row1.getCell(i).getStringCellValue();
			mForm = new MiseForme(headers, i);
			msForm.add(mForm);
		}
		model.addAttribute("headerLists", msForm);
		return "wp1/Elevage/mise_formFerme";
	}

	@PostMapping("/saveFerme")
	public String saveElevage(@RequestParam("code_village") int code_village,
			@RequestParam("nomResponsable") int nomResponsable, @RequestParam("x") int x, @RequestParam("y") int y,
			@RequestParam("genre_elev") int genre_elev, @RequestParam("annee_naiss") int annee_naiss,
			@RequestParam("operationnalite") int operationnalite, @RequestParam("date_suivi") int date_suivi,
			Model model, RedirectAttributes redirAttrs) throws IOException, ParseException {
		XSSFSheet worksheet = workbook.getSheetAt(0);
		for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
			XSSFRow row = worksheet.getRow(i);
			String code_villag = row.getCell(code_village).getStringCellValue();
			String nomResponsabl = row.getCell(nomResponsable).getStringCellValue();
			float cord_x = (float) row.getCell(x).getNumericCellValue();
			float cord_y = (float) row.getCell(y).getNumericCellValue();
			String genre = row.getCell(genre_elev).getStringCellValue();
			int annee_nais = (int) row.getCell(annee_naiss).getNumericCellValue();
			boolean operationnels = row.getCell(operationnalite).getStringCellValue().equalsIgnoreCase("Oui");
			java.util.Date date_suiv = row.getCell(date_suivi).getDateCellValue();
			elevageService.addFerme(code_villag, cord_x, cord_y, nomResponsabl, genre, annee_nais, date_suiv,
					operationnels);

		}
		redirAttrs.addFlashAttribute("success", "Données importer avec succès");
		return "redirect:/listFerme";
	}

	@GetMapping("/FermeForm")
	public String FermeForm(Model model) throws Exception {
		return "wp1/elevage/addFerme";
	}

	@PostMapping("/createFerme")
	public String createFerme(@RequestParam("code_village") String code_village,
			@RequestParam("nomResponsable") String nomResponsable, @RequestParam("x") float x,
			@RequestParam("y") float y, @RequestParam("genre_elev") String genre_elev,
			@RequestParam("annee_naiss") int annee_naiss, @RequestParam("operationnel") boolean operationnel,
			@RequestParam("date_suivi") java.sql.Date date_suivi, RedirectAttributes redirectAttributes)
			throws ParseException {
		elevageService.addFerme(code_village, x, y, nomResponsable, genre_elev, annee_naiss, date_suivi, operationnel);
		return "redirect:/listFerme";

	}

	@RequestMapping("/listFerme")
	public String listFormateur(Model model) {
		List<Elevage> ferme = elevageService.ListElevage();
		model.addAttribute("ferme", ferme);
		return "wp1/Elevage/listFerme";
	}

	/* CANEVAS PARCELLES AGC OPERATION */

	@RequestMapping("/uploadPtAGC")
	public String uploadFomPtAGC(Model model) {
		String[][] scList = ListeWp.wp();
		model.addAttribute("scList", scList);
		return "wp1/ParcelleTest/uploadPtAGC";
	}

	@PostMapping("/importPtAGC")
	public String importFomPtAGC(@RequestParam("file") MultipartFile reapExcelDataFile, Model model)
			throws IOException, ParseException {

		workbook = new XSSFWorkbook(reapExcelDataFile.getInputStream());
		XSSFSheet worksheet = workbook.getSheetAt(0);
		XSSFRow row1 = worksheet.getRow(0);
		MiseForme mForm = null;
		ArrayList<MiseForme> msForm = new ArrayList<MiseForme>();
		for (int i = 0; i < row1.getLastCellNum(); i++) {
			String headers = row1.getCell(i).getStringCellValue();
			mForm = new MiseForme(headers, i);
			msForm.add(mForm);
		}
		model.addAttribute("headerLists", msForm);
		return "wp1/ParcelleTest/mise_formPtAGC";
	}

	@PostMapping("/savePtAGC")
	public String savePt(@RequestParam("x") int x, @RequestParam("code_village") int code_village,
			@RequestParam("y") int y, @RequestParam("nomResponsable") int nomResponsable,
			@RequestParam("annee_naiss") int annee_naiss, @RequestParam("genre_pt") int genre_pt,
			@RequestParam("superficies") int superficies, @RequestParam("date_suivi") int date_suivi,
			@RequestParam("technique_exergue") int technique_exergue,
			@RequestParam("operationnalite") int operationnalite, Model model, RedirectAttributes redirAttrs) throws IOException, ParseException {
		XSSFSheet worksheet = workbook.getSheetAt(0);
		for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
			XSSFRow row = worksheet.getRow(i);
			float coord_x = (float) row.getCell(x).getNumericCellValue();
			String code_villag = row.getCell(code_village).getStringCellValue();
			float coord_y = (float) row.getCell(y).getNumericCellValue();
			String nomResponsables = row.getCell(nomResponsable).getStringCellValue();
			int annee_nais = (int) row.getCell(annee_naiss).getNumericCellValue();
			String genre_pts = row.getCell(genre_pt).getStringCellValue();
			float superficie = (float) row.getCell(superficies).getNumericCellValue();
			java.util.Date date_suiv = row.getCell(date_suivi).getDateCellValue();
			String technique_exergues = row.getCell(technique_exergue).getStringCellValue();
			boolean operationnels = row.getCell(operationnalite).getStringCellValue().equalsIgnoreCase("Oui");
			parcelleTestService.addParcelle_AGC(code_villag, coord_x, coord_y, nomResponsables, genre_pts, annee_nais,
					superficie, operationnels, date_suiv, technique_exergues);

		}
		redirAttrs.addFlashAttribute("success", "Données importer avec succès");
		return "redirect:/listPtAGC";
	}

	@GetMapping("/PtAGCForm")
	public String PtAGCForm(Model model) throws Exception {
		return "wp1/ParcelleTest/addPtAGC";
	}

	@PostMapping("/createPtAGC")
	public String createPtAGC(@RequestParam("x") float x, @RequestParam("code_village") String code_village,
			@RequestParam("y") float y, @RequestParam("nomResponsable") String nomResponsable,
			@RequestParam("annee_naiss") int annee_naiss, @RequestParam("genre_pt") String genre_pt,
			@RequestParam("superficies") float superficies, @RequestParam("date_suivi") java.sql.Date date_suivi,
			@RequestParam("technique_exergue") String technique_exergue,
			@RequestParam("operationnel") boolean operationnel, RedirectAttributes redirectAttributes)
			throws ParseException {
		parcelleTestService.addParcelle_AGC(code_village, x, y, nomResponsable, genre_pt, annee_naiss, superficies,
				operationnel, date_suivi, technique_exergue);
		return "redirect:/listPtAGC";

	}

	@RequestMapping("/listPtAGC")
	public String listPtAGC(Model model) {
		List<Parcelle_test> pt = parcelleTestService.ListParcelle_test();
		model.addAttribute("pt", pt);
		return "wp1/ParcelleTest/listPtAGC";
	}

	/* CANEVAS PARTICIPANTS AUX PARCELLES DE DEMONSTRATION AGC */

	@RequestMapping("/uploadPtParticipant")
	public String uploadPtParticipant(Model model) {
		String[][] scList = ListeWp.wp();
		model.addAttribute("scList", scList);
		return "wp1/ParcelleTest/uploadPtParticipant";
	}

	@PostMapping("/importPtParticipant")
	public String importFomPtParticipant(@RequestParam("file") MultipartFile reapExcelDataFile, Model model)
			throws IOException, ParseException {

		workbook = new XSSFWorkbook(reapExcelDataFile.getInputStream());
		XSSFSheet worksheet = workbook.getSheetAt(0);
		XSSFRow row1 = worksheet.getRow(0);
		MiseForme mForm = null;
		ArrayList<MiseForme> msForm = new ArrayList<MiseForme>();
		for (int i = 0; i < row1.getLastCellNum(); i++) {
			String headers = row1.getCell(i).getStringCellValue();
			mForm = new MiseForme(headers, i);
			msForm.add(mForm);
		}
		model.addAttribute("headerLists", msForm);
		return "wp1/ParcelleTest/mise_formPtParticipant";
	}

	@PostMapping("/savePtParticipant")
	public String saveParticipant(@RequestParam("x") int x, @RequestParam("code_village") int code_village,
			@RequestParam("y") int y, @RequestParam("nomResponsable") int nomResponsable,
			@RequestParam("annee_naiss") int annee_naiss, @RequestParam("genre_pt") int genre_pt,
			@RequestParam("date_suivi") int date_suivi, @RequestParam("nbr_homme") int nbr_homme,
			@RequestParam("nbr_femme") int nbr_femme, @RequestParam("nbr_participant") int nbr_participant,
			Model model, RedirectAttributes redirAttrs)
			throws IOException, ParseException {
		XSSFSheet worksheet = workbook.getSheetAt(0);
		for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
			XSSFRow row = worksheet.getRow(i);
			float coord_x = (float) row.getCell(x).getNumericCellValue();
			String code_villag = row.getCell(code_village).getStringCellValue();
			float coord_y = (float) row.getCell(y).getNumericCellValue();
			String nomResponsables = row.getCell(nomResponsable).getStringCellValue();
			int annee_nais = (int) row.getCell(annee_naiss).getNumericCellValue();
			String genre_pts = row.getCell(genre_pt).getStringCellValue();
			java.util.Date date_suiv = row.getCell(date_suivi).getDateCellValue();
			Long nbr_participants = (long) row.getCell(nbr_participant).getNumericCellValue();
			Long nbr_hommes = (long) row.getCell(nbr_homme).getNumericCellValue();
			Long nbr_femmes = (long) row.getCell(nbr_femme).getNumericCellValue();
			parcelleTestService.addParcelleParticipant(code_villag, coord_x, coord_y, nomResponsables, genre_pts,
					annee_nais, nbr_participants, nbr_hommes, nbr_femmes, date_suiv);

		}
		redirAttrs.addFlashAttribute("success", "Données importer avec succès");
		return "redirect:/listPtParticipant";
	}

	@GetMapping("/PtParticipantForm")
	public String PtParticipantForm(Model model) throws Exception {
		return "wp1/ParcelleTest/addPtParticipant";
	}

	@PostMapping("/createPtParticipant")
	public String createPtParticipant(@RequestParam("x") float x, @RequestParam("code_village") String code_village,
			@RequestParam("y") float y, @RequestParam("nomResponsable") String nomResponsable,
			@RequestParam("annee_naiss") int annee_naiss, @RequestParam("genre_pt") String genre_pt,
			@RequestParam("date_suivi") java.sql.Date date_suivi, @RequestParam("nbr_homme") long nbr_homme,
			@RequestParam("nbr_femme") long nbr_femme, @RequestParam("nbr_participant") Long nbr_participant,
			RedirectAttributes redirectAttributes) throws ParseException {
		parcelleTestService.addParcelleParticipant(code_village, x, y, nomResponsable, genre_pt, annee_naiss,
				nbr_participant, nbr_homme, nbr_femme, date_suivi);
		return "redirect:/listPtParticipant";

	}

	@RequestMapping("/listPtParticipant")
	public String listPtParticipant(Model model) {
		List<Parcelle_test> pt = parcelleTestService.ListParcelle_test();
		model.addAttribute("pt", pt);
		return "wp1/ParcelleTest/listPtParticipant";
	}

	/*
	 * CANEVAS ELEVEURS FORMES ET ADOPTION DES BONNES PRATIQUES CONSEILLEES EN
	 * ELEVAGE
	 */

	@RequestMapping("/uploadFomations")
	public String uploadFomations(Model model) {
		String[][] scList = ListeWp.wp();
		model.addAttribute("scList", scList);
		return "wp1/formations/uploadFormations";
	}

	@PostMapping("/importFomations")
	public String importFomations(@RequestParam("file") MultipartFile reapExcelDataFile, Model model)
			throws IOException, ParseException {

		workbook = new XSSFWorkbook(reapExcelDataFile.getInputStream());
		XSSFSheet worksheet = workbook.getSheetAt(0);
		XSSFRow row1 = worksheet.getRow(0);
		MiseForme mForm = null;
		ArrayList<MiseForme> msForm = new ArrayList<MiseForme>();
		for (int i = 0; i < row1.getLastCellNum(); i++) {
			String headers = row1.getCell(i).getStringCellValue();
			mForm = new MiseForme(headers, i);
			msForm.add(mForm);
		}
		model.addAttribute("headerLists", msForm);
		return "wp1/formations/mise_formFormations";
	}

	@PostMapping("/saveFomations")
	public String saveFomations(@RequestParam("code_village") int code_village,
			@RequestParam("nom_eleveur") int nom_eleveur, @RequestParam("annee_naiss") int annee_naiss,
			@RequestParam("genre_form") int genre_form, @RequestParam("genre_form") int adoption,
			@RequestParam("pratique_adopte") int pratique_adopte, @RequestParam("formation_recu") int formation_recu,
			@RequestParam("date_forma") int date_forma, @RequestParam("theme_formation") int theme_formation,
			Model model, RedirectAttributes redirAttrs) throws IOException, ParseException {
		XSSFSheet worksheet = workbook.getSheetAt(0);
		for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
			XSSFRow row = worksheet.getRow(i);
			String code_villag = row.getCell(code_village).getStringCellValue();
			String nom_eleveurs = row.getCell(nom_eleveur).getStringCellValue();
			String genre = row.getCell(genre_form).getStringCellValue();
			String frm_rec = row.getCell(formation_recu).getStringCellValue();
			String theme_formations = row.getCell(theme_formation).getStringCellValue();
			int annee_nais = (int) row.getCell(annee_naiss).getNumericCellValue();
			java.util.Date date_frms = row.getCell(date_forma).getDateCellValue();
			boolean adoptions = row.getCell(adoption).getStringCellValue().equalsIgnoreCase("Oui");
			String pratique_adoptes = row.getCell(pratique_adopte).getStringCellValue();
			String type_formations = "ADOPTION DES BONNES PRATIQUES EN ELEVAGE";
			formationsService.addFormEFA(code_villag, nom_eleveurs, genre, annee_nais, frm_rec, theme_formations,
					date_frms, adoptions, pratique_adoptes, type_formations);

		}
		redirAttrs.addFlashAttribute("success", "Données importer avec succès");
		return "redirect:/listFomations";
	}

	@GetMapping("/FomationsForm")
	public String FomationsForm(Model model) throws Exception {
		return "wp1/formations/addFomations";
	}

	@PostMapping("/createFomations")
	public String createFomations(@RequestParam("code_village") String code_village,
			@RequestParam("nom_eleveur") String nom_eleveur, @RequestParam("annee_naiss") int annee_naiss,
			@RequestParam("genre_form") String genre_form, @RequestParam("adoption") boolean adoption,
			@RequestParam("pratique_adopte") String pratique_adopte,
			@RequestParam("formation_recu") String formation_recu, @RequestParam("date_forma") java.sql.Date date_forma,
			@RequestParam("theme_formation") String theme_formation, RedirectAttributes redirectAttributes)
					throws Exception {
		String type_formation = "ADOPTION DES BONNES PRATIQUES EN ELEVAGE";
		Formations formations = new Formations();
		formations.setCode_village(code_village);
		formations.setNom_eleveur(nom_eleveur);
		formations.setGenre_form(genre_form.toLowerCase());
		formations.setAnnee_naiss(annee_naiss);
		formations.setFormation_recu(formation_recu);
		formations.setTheme_formation(theme_formation);
		formations.setDate_forma(date_forma);
		formations.setType_formation(type_formation);
		formationsService.createFormEFA(formations);
		return "redirect:/listFomations";

	}

	@RequestMapping("/listFomations")
	public String listFomations(Model model) {
		List<Formations> formations = formationsService.ListFormations("ADOPTION DES BONNES PRATIQUES EN ELEVAGE");
		model.addAttribute("formations", formations);
		return "wp1/formations/listFormations";
	}

	/* CANEVAS FORMATEURS EN ELEVAGE OPERATIONNELS */

	@RequestMapping("/uploadFormElev")
	public String uploadFormateurElev(Model model) {
		String[][] scList = ListeWp.wp();
		model.addAttribute("scList", scList);
		return "wp1/formateur/uploadFormateurElev";
	}

	@PostMapping("/importFormElev")
	public String importFormateurElev(@RequestParam("file") MultipartFile reapExcelDataFile, Model model)
			throws IOException, ParseException {

		workbook = new XSSFWorkbook(reapExcelDataFile.getInputStream());
		XSSFSheet worksheet = workbook.getSheetAt(0);
		XSSFRow row1 = worksheet.getRow(0);
		MiseForme mForm = null;
		ArrayList<MiseForme> msForm = new ArrayList<MiseForme>();
		for (int i = 0; i < row1.getLastCellNum(); i++) {
			String headers = row1.getCell(i).getStringCellValue();
			mForm = new MiseForme(headers, i);
			msForm.add(mForm);
		}
		model.addAttribute("headerLists", msForm);
		return "wp1/formateur/mise_formFormateurElev";
	}

	@PostMapping("/saveFormElev")
	public String saveFormateurElev(@RequestParam("code_village") int code_village,
			@RequestParam("genre_ft") int genre_ft, @RequestParam("nomPrenom") int nomPrenom,
			@RequestParam("annee_naiss") int annee_naiss, @RequestParam("operationnalite") int operationnalite,
			@RequestParam("date_mise_place") int date_mise_place, @RequestParam("date_suivi") int date_suivi,
			Model model, RedirectAttributes redirAttrs) throws IOException, ParseException {
		XSSFSheet worksheet = workbook.getSheetAt(0);
		for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
			XSSFRow row = worksheet.getRow(i);
			String genre_fts = row.getCell(genre_ft).getStringCellValue();
			String code_villag = row.getCell(code_village).getStringCellValue();
			String nomPrenoms = row.getCell(nomPrenom).getStringCellValue();
			int date_naiss = (int) row.getCell(annee_naiss).getNumericCellValue();
			java.util.Date date_mise_places = row.getCell(date_mise_place).getDateCellValue();
			java.util.Date date_suivis = row.getCell(date_suivi).getDateCellValue();
			boolean operationnel = row.getCell(operationnalite).getStringCellValue().equalsIgnoreCase("Oui");
			String type_forms = "ELEVAGE";
			formateursService.addFormateurElevage(code_villag, nomPrenoms, genre_fts, date_naiss, operationnel,
					date_mise_places, date_suivis, type_forms);
			;

		}
		redirAttrs.addFlashAttribute("success", "Données importer avec succès");
		return "redirect:/listFormElev";
	}
	
	@GetMapping("/FormElevForm")
	public String FormElevForm(Model model) throws Exception {
		return "wp1/formateur/addFormElev";
	}

	@PostMapping("/createFormElev")
	public String createFormElev(@RequestParam("code_village") String code_village,
			@RequestParam("genre_ft") String genre_ft, @RequestParam("nomPrenom") String nomPrenom,
			@RequestParam("date_naiss") int date_naiss, @RequestParam("operationnel") boolean operationnel,
			@RequestParam("date_mise_place") java.sql.Date date_mise_place, @RequestParam("date_suivi") java.sql.Date date_suivi, 
			RedirectAttributes redirectAttributes) throws Exception {
		String type_form = "ELEVAGE";
		Formateur formateur = new Formateur();
		formateur.setCode_village(code_village);
		formateur.setNomPrenom(nomPrenom);
		formateur.setGenre_ft(genre_ft.toLowerCase());
		formateur.setDate_naiss(date_naiss);
		formateur.setOperationnel(operationnel);
		formateur.setDate_mise_place(date_mise_place);
		formateur.setDate_suivi(date_suivi);
		formateur.setType_form(type_form);
		formateursService.createFormElev(formateur);
		return "redirect:/listFormElev";
	}

	@RequestMapping("/listFormElev")
	public String listFormateurElev(Model model) {
		List<Formateur> formateur = formateursService.ListElevage("ELEVAGE");
		model.addAttribute("formateur", formateur);
		return "wp1/formateur/listFormateurElev";
	}

	/* CANEVAS AGENTS DE TERRAIN FORMES EN FBS ET POST FBS */

	@RequestMapping("/uploadFomFBS")
	public String uploadFomFBS(Model model) {
		String[][] scList = ListeWp.wp();
		model.addAttribute("scList", scList);
		return "wp1/formations/uploadFormFBS";
	}

	@PostMapping("/importFormFBS")
	public String importFomFBS(@RequestParam("file") MultipartFile reapExcelDataFile, Model model)
			throws IOException, ParseException {

		workbook = new XSSFWorkbook(reapExcelDataFile.getInputStream());
		XSSFSheet worksheet = workbook.getSheetAt(0);
		XSSFRow row1 = worksheet.getRow(0);
		MiseForme mForm = null;
		ArrayList<MiseForme> msForm = new ArrayList<MiseForme>();
		for (int i = 0; i < row1.getLastCellNum(); i++) {
			String headers = row1.getCell(i).getStringCellValue();
			mForm = new MiseForme(headers, i);
			msForm.add(mForm);
		}
		model.addAttribute("headerLists", msForm);
		return "wp1/formations/mise_formFormFBS";
	}

	@PostMapping("/saveFormFBS")
	public String saveFomFBS(@RequestParam("code_village") int code_village,
			@RequestParam("nom_eleveur") int nom_eleveur, @RequestParam("annee_naiss") int annee_naiss,
			@RequestParam("genre_form") int genre_form, @RequestParam("formation_recu") int formation_recu,
			@RequestParam("date_forma") int date_forma, @RequestParam("theme_formation") int theme_formation,
			Model model, RedirectAttributes redirAttrs) throws IOException, ParseException {
		XSSFSheet worksheet = workbook.getSheetAt(0);
		for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
			XSSFRow row = worksheet.getRow(i);
			String code_villag = row.getCell(code_village).getStringCellValue();
			String nom_eleveurs = row.getCell(nom_eleveur).getStringCellValue();
			String genre = row.getCell(genre_form).getStringCellValue();
			String frm_rec = row.getCell(formation_recu).getStringCellValue();
			String theme_formations = row.getCell(theme_formation).getStringCellValue();
			int annee_nais = (int) row.getCell(annee_naiss).getNumericCellValue();
			java.util.Date date_frms = row.getCell(date_forma).getDateCellValue();
			String type_formation = "FBS ET POST FBS";
			formationsService.addFormations(code_villag, nom_eleveurs, genre, annee_nais, frm_rec, theme_formations,
					date_frms, type_formation);
			;

		}
		redirAttrs.addFlashAttribute("success", "Données importer avec succès");
		return "redirect:/listFormFBS";
	}
	
	@GetMapping("/FormFBSForm")
	public String FormFBSForm(Model model) throws Exception {
		return "wp1/formations/addFormFBS";
	}

	@PostMapping("/createFormFBS")
	public String createFormFBS(@RequestParam("code_village") String code_village,
			@RequestParam("nom_eleveur") String nom_eleveur, @RequestParam("annee_naiss") int annee_naiss,
			@RequestParam("genre_form") String genre_form, @RequestParam("formation_recu") String formation_recu,
			@RequestParam("date_forma") java.sql.Date date_forma, @RequestParam("theme_formation") String theme_formation,
			RedirectAttributes redirectAttributes) throws Exception {
		String type_formation = "FBS ET POST FBS";
		Formations formations = new Formations();
		formations.setCode_village(code_village);
		formations.setNom_eleveur(nom_eleveur);
		formations.setGenre_form(genre_form.toLowerCase());
		formations.setAnnee_naiss(annee_naiss);
		formations.setFormation_recu(formation_recu);
		formations.setTheme_formation(theme_formation);
		formations.setDate_forma(date_forma);
		formations.setType_formation(type_formation);
		formationsService.createFormFBS(formations);
		return "redirect:/listFormFBS";
	}

	@RequestMapping("/listFormFBS")
	public String listFormFBS(Model model) {
		List<Formations> formations = formationsService.ListFormations("FBS ET POST FBS");
		model.addAttribute("formations", formations);
		return "wp1/formations/listFormFBS";
	}

}
