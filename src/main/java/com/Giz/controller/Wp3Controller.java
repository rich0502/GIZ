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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.Giz.data.constants.theme.ListeWp;
import com.Giz.data.domain.MiseForme;
import com.Giz.data.domain.Wp3ActivEcoJeune;
import com.Giz.data.domain.Wp3AgrDevMfr;
import com.Giz.data.domain.Wp3CommitteeActif;
import com.Giz.data.domain.Wp3ElevMfr;
import com.Giz.data.domain.Wp3EppFram;
import com.Giz.data.domain.Wp3EquipeTechMfr;
import com.Giz.data.domain.Wp3FedeMfr;
import com.Giz.data.domain.Wp3JeuneFormeMfr;
import com.Giz.data.domain.Wp3JeunePathway;
import com.Giz.data.domain.Wp3JeuneTech;
import com.Giz.data.domain.Wp3PeerEducator;
import com.Giz.data.domain.Wp3SanteeComm;
import com.Giz.data.domain.Wp3UniteElevJeune;
import com.Giz.service.metier.Wp3ActivEcoJeuneService;
import com.Giz.service.metier.Wp3AgrDevMfrService;
import com.Giz.service.metier.Wp3CommitteeActifService;
import com.Giz.service.metier.Wp3ElevMfrService;
import com.Giz.service.metier.Wp3EppFramService;
import com.Giz.service.metier.Wp3EquipeTechMfrService;
import com.Giz.service.metier.Wp3FedeMfrService;
import com.Giz.service.metier.Wp3JeuneFormeMfrService;
import com.Giz.service.metier.Wp3JeunePathwayService;
import com.Giz.service.metier.Wp3JeuneTechService;
import com.Giz.service.metier.Wp3PeerEducatorService;
import com.Giz.service.metier.Wp3SanteeCommService;
import com.Giz.service.metier.Wp3UniteElevJeuneService;

@Controller
public class Wp3Controller {

	XSSFWorkbook workbook;

	@Autowired
	Wp3ActivEcoJeuneService wp3ActivEcoJeuneService;

	@Autowired
	Wp3AgrDevMfrService wp3AgrDevMfrService;

	@Autowired
	Wp3CommitteeActifService wp3CommitteeActifService;

	@Autowired
	Wp3ElevMfrService wp3ElevMfrService;

	@Autowired
	Wp3EppFramService wp3EppFramService;

	@Autowired
	Wp3EquipeTechMfrService wp3EquipeTechMfrService;

	@Autowired
	Wp3FedeMfrService wp3FedeMfrService;

	@Autowired
	Wp3JeuneFormeMfrService wp3JeuneFormeMfrService;

	@Autowired
	Wp3JeunePathwayService wp3JeunePathwayService;

	@Autowired
	Wp3JeuneTechService wp3JeuneTechService;

	@Autowired
	Wp3PeerEducatorService wp3PeerEducatorService;

	@Autowired
	Wp3SanteeCommService wp3SanteeCommService;

	@Autowired
	Wp3UniteElevJeuneService wp3UniteElevJeuneService;

	/* #37-CANEVAS ACTIVITE ECONOMIQUE JEUNE */

	@RequestMapping("/uploadWp3ActivEcoJeune")
	public String uploadWp3ActivEcoJeune(Model model) {
		String[][] scList = ListeWp.wp();
		model.addAttribute("scList", scList);
		return "wp3/Wp3ActivEcoJeune/uploadWp3ActivEcoJeune";
	}

	@RequestMapping("/listWp3ActivEcoJeune")
	public String listWp3ActivEcoJeune(Model model) {
		List<Wp3ActivEcoJeune> wp3ActivEcoJeune = wp3ActivEcoJeuneService.ListWp3ActivEcoJeune();
		model.addAttribute("wp3ActivEcoJeune", wp3ActivEcoJeune);
		return "wp3/Wp3ActivEcoJeune/listWp3ActivEcoJeune";
	}

	@PostMapping("/importWp3ActivEcoJeune")
	public String importWp3ActivEcoJeune(@RequestParam("file") MultipartFile reapExcelDataFile, Model model)
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
		return "wp3/Wp3ActivEcoJeune/mise_formWp3ActivEcoJeune";
	}

	@PostMapping("/saveWp3ActivEcoJeune")
	public String saveWp3ActivEcoJeune(@RequestParam("code_village") int code_village,
			@RequestParam("nom_prenom") int nom_prenom, @RequestParam("sexe") int sexe,
			@RequestParam("annee_naissance") int annee_naissance,
			@RequestParam("organisme_formateur") int organisme_formateur,
			@RequestParam("frm_tech_suivi") int frm_tech_suivi, @RequestParam("date_fin_frm") int date_fin_frm,
			@RequestParam("activite_eco") int activite_eco, @RequestParam("date_demarrage") int date_demarrage,
			Model model) throws IOException, ParseException {

		XSSFSheet worksheet = workbook.getSheetAt(0);
		for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
			XSSFRow row = worksheet.getRow(i);

			String code_village37 = row.getCell(code_village).getStringCellValue();
			String nom_prenom37 = row.getCell(nom_prenom).getStringCellValue();
			String sexe37 = row.getCell(sexe).getStringCellValue();
			int annee_naissance37 = (int) row.getCell(annee_naissance).getNumericCellValue();
			String organisme_formateur37 = row.getCell(organisme_formateur).getStringCellValue();
			String frm_tech_suivi37 = row.getCell(frm_tech_suivi).getStringCellValue();
			java.util.Date date_fin_frm37 = row.getCell(date_fin_frm).getDateCellValue();
			String activite_eco37 = row.getCell(activite_eco).getStringCellValue();
			java.util.Date date_demarrage37 = row.getCell(date_demarrage).getDateCellValue();

			wp3ActivEcoJeuneService.addWp3ActivEcoJeune(code_village37, nom_prenom37, sexe37, annee_naissance37,
					organisme_formateur37, frm_tech_suivi37, date_fin_frm37, activite_eco37, date_demarrage37);
		}

		return "redirect:/listWp3ActivEcoJeune";
	}

	/* END #37-CANEVAS ACTIVITE ECONOMIQUE JEUNE */

	/* START #38-CANEVAS AGR DÉVELOPPÉ MFR SAVA */

	@RequestMapping("/uploadWp3AgrDevMfr")
	public String uploadWp3AgrDevMfr(Model model) {
		String[][] scList = ListeWp.wp();
		model.addAttribute("scList", scList);
		return "wp3/Wp3AgrDevMfr/uploadWp3AgrDevMfr";
	}

	@RequestMapping("/listWp3AgrDevMfr")
	public String listWp3AgrDevMfr(Model model) {
		List<Wp3AgrDevMfr> wp3AgrDevMfr = wp3AgrDevMfrService.ListWp3AgrDevMfr();
		model.addAttribute("wp3AgrDevMfr", wp3AgrDevMfr);
		return "wp3/Wp3AgrDevMfr/listWp3AgrDevMfr";
	}

	@PostMapping("/importWp3AgrDevMfr")
	public String importWp3AgrDevMfr(@RequestParam("file") MultipartFile reapExcelDataFile, Model model)
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
		return "wp3/Wp3AgrDevMfr/mise_formWp3AgrDevMfr";
	}

	@PostMapping("/saveWp3AgrDevMfr")
	public String saveWp3AgrDevMfr(@RequestParam("code_village") int code_village, @RequestParam("nom_mfr") int nom_mfr,
			@RequestParam("annee_miseplace") int annee_miseplace, @RequestParam("agr_developpe") int agr_developpe,
			@RequestParam("date_eval") int date_eval, @RequestParam("type_agr_dev1") int type_agr_dev1,
			@RequestParam("date_suivi1") int date_suivi1,
			/*
			 * @RequestParam("type_agr_dev2") int type_agr_dev2,
			 * 
			 * @RequestParam("date_suivi2") int date_suivi2, @RequestParam("type_agr_dev3")
			 * int type_agr_dev3,
			 * 
			 * @RequestParam("date_suivi3") int date_suivi3, @RequestParam("type_agr_dev4")
			 * int type_agr_dev4,
			 * 
			 * @RequestParam("date_suivi4") int date_suivi4, @RequestParam("type_agr_dev5")
			 * int type_agr_dev5,
			 * 
			 * @RequestParam("date_suivi5") int date_suivi5,
			 */
			Model model) throws IOException, ParseException {

		XSSFSheet worksheet = workbook.getSheetAt(0);
		for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
			XSSFRow row = worksheet.getRow(i);

			String code_village38 = row.getCell(code_village).getStringCellValue();
			String nom_mfr38 = row.getCell(nom_mfr).getStringCellValue();
			int annee_miseplace38 = (int) row.getCell(annee_miseplace).getNumericCellValue();
			String agr_developpe38 = row.getCell(agr_developpe).getStringCellValue();
			java.util.Date date_eval38 = row.getCell(date_eval).getDateCellValue();
			String type_agr_dev138 = row.getCell(type_agr_dev1).getStringCellValue();
			java.util.Date date_suivi138 = row.getCell(date_suivi1).getDateCellValue();
			/*
			 * String type_agr_dev238 = row.getCell(type_agr_dev2).getStringCellValue();
			 * java.util.Date date_suivi238 = row.getCell(date_suivi2).getDateCellValue();
			 * String type_agr_dev338 = row.getCell(type_agr_dev3).getStringCellValue();
			 * java.util.Date date_suivi338 = row.getCell(date_suivi3).getDateCellValue();
			 * String type_agr_dev438 = row.getCell(type_agr_dev4).getStringCellValue();
			 * java.util.Date date_suivi438 = row.getCell(date_suivi4).getDateCellValue();
			 * String type_agr_dev538 = row.getCell(type_agr_dev5).getStringCellValue();
			 * java.util.Date date_suivi538 = row.getCell(date_suivi5).getDateCellValue();
			 */

			wp3AgrDevMfrService.addWp3AgrDevMfr(code_village38, nom_mfr38, annee_miseplace38, agr_developpe38,
					date_eval38, type_agr_dev138, date_suivi138);
			;
		}

		return "redirect:/listWp3AgrDevMfr";
	}
	/* END #38-CANEVAS AGR DÉVELOPPÉ MFR SAVA */

	/* START #39-CANEVAS YOUTH COMMITTEE ACTIF   */

	@RequestMapping("/uploadWp3CommitteeActif")
	public String uploadWp3CommitteeActif(Model model) {
		String[][] scList = ListeWp.wp();
		model.addAttribute("scList", scList);
		return "wp3/Wp3CommitteeActif/uploadWp3CommitteeActif";
	}

	@RequestMapping("/listWp3CommitteeActif")
	public String listWp3CommitteeActif(Model model) {
		List<Wp3CommitteeActif> wp3CommitteeActif = wp3CommitteeActifService.ListWp3CommitteeActif();
		model.addAttribute("wp3CommitteeActif", wp3CommitteeActif);
		return "wp3/Wp3CommitteeActif/listWp3CommitteeActif";
	}

	@PostMapping("/importWp3CommitteeActif")
	public String importWp3CommitteeActif(@RequestParam("file") MultipartFile reapExcelDataFile, Model model)
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
		return "wp3/Wp3CommitteeActif/mise_formWp3CommitteeActif";
	}

	@PostMapping("/saveWp3CommitteeActif")
	public String saveWp3CommitteeActif(@RequestParam("code_village") int code_village,
			@RequestParam("nom_comite") int nom_comite, @RequestParam("mois_annee_creation") int mois_annee_creation,
			@RequestParam("committee_actif") int committee_actif, @RequestParam("date_suivi") int date_suivi,
			@RequestParam("effectif_membre") int effectif_membre, @RequestParam("sexe_h") int sexe_h,
			@RequestParam("sexe_f") int sexe_f, Model model) throws IOException, ParseException {

		XSSFSheet worksheet = workbook.getSheetAt(0);
		for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
			XSSFRow row = worksheet.getRow(i);

			String code_village39 = row.getCell(code_village).getStringCellValue();
			String nom_comite39 = row.getCell(nom_comite).getStringCellValue();
			String mois_annee_creation39 = row.getCell(mois_annee_creation).getStringCellValue();
			boolean committee_actif39 = row.getCell(committee_actif).getStringCellValue().equalsIgnoreCase("Oui");
			java.util.Date date_suivi39 = row.getCell(date_suivi).getDateCellValue();
			int effectif_membre39 = (int) row.getCell(effectif_membre).getNumericCellValue();
			int sexe_h39 = (int) row.getCell(sexe_h).getNumericCellValue();
			int sexe_f39 = (int) row.getCell(sexe_f).getNumericCellValue();

			wp3CommitteeActifService.addWp3CommitteeActif(code_village39, nom_comite39, mois_annee_creation39,
					committee_actif39, date_suivi39, effectif_membre39, sexe_h39, sexe_f39);

		}

		return "redirect:/listWp3CommitteeActif";
	}

	/* END #39-CANEVAS YOUTH COMMITTEE ACTIF   */

	/* START #40-CANEVAS ELÈVE INSCRIT MFR DRAFT */

	@RequestMapping("/uploadWp3ElevMfr")
	public String uploadWp3ElevMfr(Model model) {
		String[][] scList = ListeWp.wp();
		model.addAttribute("scList", scList);
		return "wp3/Wp3ElevMfr/uploadWp3ElevMfr";
	}

	@RequestMapping("/listWp3ElevMfr")
	public String listWp3ElevMfr(Model model) {
		List<Wp3ElevMfr> wp3ElevMfr = wp3ElevMfrService.ListWp3ElevMfr();
		model.addAttribute("wp3ElevMfr", wp3ElevMfr);
		return "wp3/Wp3ElevMfr/listWp3ElevMfr";
	}

	@PostMapping("/importWp3ElevMfr")
	public String importWp3ElevMfr(@RequestParam("file") MultipartFile reapExcelDataFile, Model model)
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
		return "wp3/Wp3ElevMfr/mise_formWp3ElevMfr";
	}

	@PostMapping("/saveWp3ElevMfr")
	public String saveWp3ElevMfr(@RequestParam("code_village") int code_village,
			@RequestParam("nom_prenom") int nom_prenom, @RequestParam("village_origine") int village_origine,
			@RequestParam("sexe") int sexe, @RequestParam("annee_naissance") int annee_naissance,
			@RequestParam("inscrit") int inscrit, @RequestParam("annee_inscription") int annee_inscription,
			@RequestParam("date_suivi") int date_suivi, @RequestParam("type_frm") int type_frm,
			@RequestParam("annee_etude") int annee_etude, @RequestParam("date_sortie") int date_sortie,
			@RequestParam("type_projet") int type_projet, @RequestParam("niveau_demarrage") int niveau_demarrage,
			@RequestParam("date_validation") int date_validation, @RequestParam("accompagne") int accompagne,
			@RequestParam("date_suivi1") int date_suivi1, @RequestParam("date_suivi2") int date_suivi2,
			@RequestParam("date_suivi3") int date_suivi3, @RequestParam("date_suivi4") int date_suivi4, Model model)
			throws IOException, ParseException {

		XSSFSheet worksheet = workbook.getSheetAt(0);
		for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
			XSSFRow row = worksheet.getRow(i);

			String code_village40 = row.getCell(code_village).getStringCellValue();
			String nom_prenom40 = row.getCell(nom_prenom).getStringCellValue();
			String village_origine40 = row.getCell(village_origine).getStringCellValue();
			String sexe40 = row.getCell(sexe).getStringCellValue();
			int annee_naissance40 = (int) row.getCell(annee_naissance).getNumericCellValue();
			boolean inscrit40 = row.getCell(inscrit).getStringCellValue().equalsIgnoreCase("Oui");
			int annee_inscription40 = (int) row.getCell(annee_inscription).getNumericCellValue();
			java.util.Date date_suivi40 = row.getCell(date_suivi).getDateCellValue();
			String type_frm40 = row.getCell(type_frm).getStringCellValue();
			int annee_etude40 = (int) row.getCell(annee_etude).getNumericCellValue();
			java.util.Date date_sortie40 = row.getCell(date_sortie).getDateCellValue();
			String type_projet40 = row.getCell(type_projet).getStringCellValue();
			String niveau_demarrage40 = row.getCell(niveau_demarrage).getStringCellValue();
			java.util.Date date_validation40 = row.getCell(date_validation).getDateCellValue();
			boolean accompagne40 = row.getCell(accompagne).getStringCellValue().equalsIgnoreCase("Oui");
			java.util.Date date_suivi140 = row.getCell(date_suivi1).getDateCellValue();
			java.util.Date date_suivi240 = row.getCell(date_suivi2).getDateCellValue();
			java.util.Date date_suivi340 = row.getCell(date_suivi3).getDateCellValue();
			java.util.Date date_suivi440 = row.getCell(date_suivi4).getDateCellValue();

			wp3ElevMfrService.addWp3ElevMfr(code_village40, nom_prenom40, village_origine40, sexe40, annee_naissance40,
					inscrit40, annee_inscription40, date_suivi40, type_frm40, annee_etude40, date_sortie40,
					type_projet40, niveau_demarrage40, date_validation40, accompagne40, date_suivi140, date_suivi240,
					date_suivi340, date_suivi440);
		}

		return "redirect:/listWp3ElevMfr";
	}

	/* END #40-CANEVAS ELÈVE INSCRIT MFR DRAFT */

	/* START #41-CANEVAS EPP FRAM DRAFT */

	@RequestMapping("/uploadWp3EppFram")
	public String uploadWp3EppFram(Model model) {
		String[][] scList = ListeWp.wp();
		model.addAttribute("scList", scList);
		return "wp3/Wp3EppFram/uploadWp3EppFram";
	}

	@RequestMapping("/listWp3EppFram")
	public String listWp3EppFram(Model model) {
		List<Wp3EppFram> wp3EppFram = wp3EppFramService.ListWp3EppFram();
		model.addAttribute("wp3EppFram", wp3EppFram);
		return "wp3/Wp3EppFram/listWp3EppFram";
	}

	@PostMapping("/importWp3EppFram")
	public String importWp3EppFram(@RequestParam("file") MultipartFile reapExcelDataFile, Model model)
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
		return "wp3/Wp3EppFram/mise_formWp3EppFram";
	}

	@PostMapping("/saveWp3EppFram")
	public String saveWp3EppFram(@RequestParam("code_village") int code_village,
			@RequestParam("nom_ecole") int nom_ecole, @RequestParam("projet_fram") int projet_fram,
			@RequestParam("projet_valide") int projet_valide, @RequestParam("type_projet") int type_projet,
			@RequestParam("date_validation") int date_validation, Model model) throws IOException, ParseException {

		XSSFSheet worksheet = workbook.getSheetAt(0);
		for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
			XSSFRow row = worksheet.getRow(i);

			String code_village41 = row.getCell(code_village).getStringCellValue();
			String nom_ecole41 = row.getCell(nom_ecole).getStringCellValue();
			boolean projet_fram41 = row.getCell(projet_fram).getStringCellValue().equalsIgnoreCase("Oui");
			boolean projet_valide41 = row.getCell(projet_valide).getStringCellValue().equalsIgnoreCase("Oui");
			String type_projet41 = row.getCell(type_projet).getStringCellValue();
			java.util.Date date_validation41 = row.getCell(date_validation).getDateCellValue();

			wp3EppFramService.addWp3EppFram(code_village41, nom_ecole41, projet_fram41, projet_valide41, type_projet41,
					date_validation41);

		}

		return "redirect:/listWp3EppFram";
	}

	/* END #41-CANEVAS EPP FRAM DRAFT */

	/* START #42-CANEVAS BDD ÉQUIPE TECHNIQUE MFR */

	@RequestMapping("/uploadWp3EquipeTechMfr")
	public String uploadWp3EquipeTechMfr(Model model) {
		String[][] scList = ListeWp.wp();
		model.addAttribute("scList", scList);
		return "wp3/Wp3EquipeTechMfr/uploadWp3EquipeTechMfr";
	}

	@RequestMapping("/listWp3EquipeTechMfr")
	public String listWp3EquipeTechMfr(Model model) {
		List<Wp3EquipeTechMfr> wp3EquipeTechMfr = wp3EquipeTechMfrService.ListWp3EquipeTechMfr();
		model.addAttribute("wp3EquipeTechMfr", wp3EquipeTechMfr);
		return "wp3/Wp3EquipeTechMfr/listWp3EquipeTechMfr";
	}

	@PostMapping("/importWp3EquipeTechMfr")
	public String importWp3EquipeTechMfr(@RequestParam("file") MultipartFile reapExcelDataFile, Model model)
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
		return "wp3/Wp3EquipeTechMfr/mise_formWp3EquipeTechMfr";
	}

	@PostMapping("/saveWp3EquipeTechMfr")
	public String saveWp3EquipeTechMfr(@RequestParam("code_village") int code_village,
			@RequestParam("nom_prenom") int nom_prenom, @RequestParam("sexe") int sexe,
			@RequestParam("annee_naissance") int annee_naissance, @RequestParam("Frm_recue1") int Frm_recue1,

			// @RequestParam("Frm_recue2") int Frm_recue2,
			// @RequestParam("Frm_recue3") int Frm_recue3,
			// @RequestParam("Frm_recue4") int Frm_recue4,

			@RequestParam("competence_frm") int competence_frm, @RequestParam("date_eval") int date_eval, Model model)
			throws IOException, ParseException {

		XSSFSheet worksheet = workbook.getSheetAt(0);
		for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
			XSSFRow row = worksheet.getRow(i);

			String code_village42 = row.getCell(code_village).getStringCellValue();
			String nom_prenom42 = row.getCell(nom_prenom).getStringCellValue();
			String sexe42 = row.getCell(sexe).getStringCellValue();
			int annee_naissance42 = (int) row.getCell(annee_naissance).getNumericCellValue();
			String Frm_recue142 = row.getCell(Frm_recue1).getStringCellValue();

			/*
			 * String Frm_recue242 = row.getCell(Frm_recue2).getStringCellValue(); String
			 * Frm_recue342 = row.getCell(Frm_recue3).getStringCellValue(); String
			 * Frm_recue442 = row.getCell(Frm_recue4).getStringCellValue();
			 */

			boolean competence_frm42 = row.getCell(competence_frm).getStringCellValue().equalsIgnoreCase("Oui");
			java.util.Date date_eval42 = row.getCell(date_eval).getDateCellValue();

			wp3EquipeTechMfrService.addWp3EquipeTechMfr(code_village42, nom_prenom42, sexe42, annee_naissance42,
					Frm_recue142, competence_frm42, date_eval42);
			;

		}

		return "redirect:/listWp3EquipeTechMfr";
	}

	/* END #42-CANEVAS BDD ÉQUIPE TECHNIQUE MFR */

	/* START #43-CANEVAS FEDERATION REGIONALE MFR */

	@RequestMapping("/uploadWp3FedeMfr")
	public String uploadWp3FedeMfr(Model model) {
		String[][] scList = ListeWp.wp();
		model.addAttribute("scList", scList);
		return "wp3/Wp3FedeMfr/uploadWp3FedeMfr";
	}

	@RequestMapping("/listWp3FedeMfr")
	public String listWp3FedeMfr(Model model) {
		List<Wp3FedeMfr> wp3FedeMfr = wp3FedeMfrService.ListWp3FedeMfr();
		model.addAttribute("wp3FedeMfr", wp3FedeMfr);
		return "wp3/Wp3FedeMfr/listWp3FedeMfr";
	}

	@PostMapping("/importWp3FedeMfr")
	public String importWp3FedeMfr(@RequestParam("file") MultipartFile reapExcelDataFile, Model model)
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
		return "wp3/Wp3FedeMfr/mise_formWp3FedeMfr";
	}

	@PostMapping("/saveWp3FedeMfr")
	public String saveWp3FedeMfr(@RequestParam("code_region") int code_region, @RequestParam("nom_mfr") int nom_mfr,
			@RequestParam("annee_miseplace") int annee_miseplace, @RequestParam("statut") int statut,
			@RequestParam("reglement_interieur") int reglement_interieur,
			@RequestParam("recepisse_mfr") int recepisse_mfr, @RequestParam("date_recepisse") int date_recepisse,
			@RequestParam("plan_strategique") int plan_strategique,
			@RequestParam("date_validation") int date_validation, Model model) throws IOException, ParseException {

		XSSFSheet worksheet = workbook.getSheetAt(0);
		for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
			XSSFRow row = worksheet.getRow(i);

			String code_region43 = row.getCell(code_region).getStringCellValue();
			String nom_mfr43 = row.getCell(nom_mfr).getStringCellValue();
			int annee_miseplace43 = (int) row.getCell(annee_miseplace).getNumericCellValue();
			boolean statut43 = row.getCell(statut).getStringCellValue().equalsIgnoreCase("Oui");
			boolean reglement_interieur43 = row.getCell(reglement_interieur).getStringCellValue()
					.equalsIgnoreCase("Oui");
			boolean recepisse_mfr43 = row.getCell(recepisse_mfr).getStringCellValue().equalsIgnoreCase("Oui");
			java.util.Date date_recepisse43 = row.getCell(date_recepisse).getDateCellValue();
			boolean plan_strategique43 = row.getCell(plan_strategique).getStringCellValue().equalsIgnoreCase("Oui");
			java.util.Date date_validation43 = row.getCell(date_validation).getDateCellValue();

			wp3FedeMfrService.addWp3FedeMfr(code_region43, nom_mfr43, annee_miseplace43, statut43,
					reglement_interieur43, recepisse_mfr43, date_recepisse43, plan_strategique43, date_validation43);
		}

		return "redirect:/listWp3FedeMfr";
	}

	/* END #43-CANEVAS FEDERATION REGIONALE MFR */

	/* START #44-CANEVAS JEUNE FORME MFR ACCOMPAGNE */

	@RequestMapping("/uploadWp3JeuneFormeMfr")
	public String uploadWp3JeuneFormeMfr(Model model) {
		String[][] scList = ListeWp.wp();
		model.addAttribute("scList", scList);
		return "wp3/Wp3JeuneFormeMfr/uploadWp3JeuneFormeMfr";
	}

	@RequestMapping("/listWp3JeuneFormeMfr")
	public String listWp3JeuneFormeMfr(Model model) {
		List<Wp3JeuneFormeMfr> wp3JeuneFormeMfr = wp3JeuneFormeMfrService.ListWp3JeuneFormeMfr();
		model.addAttribute("wp3JeuneFormeMfr", wp3JeuneFormeMfr);
		return "wp3/Wp3JeuneFormeMfr/listWp3JeuneFormeMfr";
	}

	@PostMapping("/importWp3JeuneFormeMfr")
	public String importWp3JeuneFormeMfr(@RequestParam("file") MultipartFile reapExcelDataFile, Model model)
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
		return "wp3/Wp3JeuneFormeMfr/mise_formWp3JeuneFormeMfr";
	}

	@PostMapping("/saveWp3JeuneFormeMfr")
	public String saveWp3JeuneFormeMfr(@RequestParam("code_village") int code_village,
			@RequestParam("nom_prenom") int nom_prenom, @RequestParam("sexe") int sexe,
			@RequestParam("annee_naissance") int annee_naissance, @RequestParam("forme") int forme,
			@RequestParam("accompagne_sortie") int accompagne_sortie,
			@RequestParam("type_accompagnement") int type_accompagnement, @RequestParam("date_suivi") int date_suivi,
			Model model) throws IOException, ParseException {

		XSSFSheet worksheet = workbook.getSheetAt(0);
		for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
			XSSFRow row = worksheet.getRow(i);

			String code_village44 = row.getCell(code_village).getStringCellValue();
			String nom_prenom44 = row.getCell(nom_prenom).getStringCellValue();
			String sexe44 = row.getCell(sexe).getStringCellValue();
			int annee_naissance44 = (int) row.getCell(annee_naissance).getNumericCellValue();
			boolean forme44 = row.getCell(forme).getStringCellValue().equalsIgnoreCase("Oui");
			boolean accompagne_sortie44 = row.getCell(accompagne_sortie).getStringCellValue().equalsIgnoreCase("Oui");
			String type_accompagnement44 = row.getCell(type_accompagnement).getStringCellValue();
			java.util.Date date_suivi44 = row.getCell(date_suivi).getDateCellValue();

			wp3JeuneFormeMfrService.addWp3JeuneFormeMfr(code_village44, nom_prenom44, sexe44, annee_naissance44,
					forme44, accompagne_sortie44, type_accompagnement44, date_suivi44);

		}

		return "redirect:/listWp3JeuneFormeMfr";
	}

	/* END #44-CANEVAS JEUNE FORME MFR ACCOMPAGNE */

	/* START #45-CANEVAS JEUNE AYANT TERMINÉ FORMATION PATHWAY */

	@RequestMapping("/uploadWp3JeunePathway")
	public String uploadWp3JeunePathway(Model model) {
		String[][] scList = ListeWp.wp();
		model.addAttribute("scList", scList);
		return "wp3/Wp3JeunePathway/uploadWp3JeunePathway";
	}

	@RequestMapping("/listWp3JeunePathway")
	public String listWp3JeunePathway(Model model) {
		List<Wp3JeunePathway> wp3JeunePathway = wp3JeunePathwayService.ListWp3JeunePathway();
		model.addAttribute("wp3JeunePathway", wp3JeunePathway);
		return "wp3/Wp3JeunePathway/listWp3JeunePathway";
	}

	@PostMapping("/importWp3JeunePathway")
	public String importWp3JeunePathway(@RequestParam("file") MultipartFile reapExcelDataFile, Model model)
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
		return "wp3/Wp3JeunePathway/mise_formWp3JeunePathway";
	}

	@PostMapping("/saveWp3JeunePathway")
	public String saveWp3JeunePathway(@RequestParam("code_village") int code_village,
			@RequestParam("nom_prenom") int nom_prenom, @RequestParam("sexe") int sexe,
			@RequestParam("annee_naissance") int annee_naissance, @RequestParam("date_fin_frm") int date_fin_frm,
			Model model) throws IOException, ParseException {

		XSSFSheet worksheet = workbook.getSheetAt(0);
		for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
			XSSFRow row = worksheet.getRow(i);

			String code_village45 = row.getCell(code_village).getStringCellValue();
			String nom_prenom45 = row.getCell(nom_prenom).getStringCellValue();
			String sexe45 = row.getCell(sexe).getStringCellValue();
			int annee_naissance45 = (int) row.getCell(annee_naissance).getNumericCellValue();
			java.util.Date date_fin_frm45 = row.getCell(date_fin_frm).getDateCellValue();

			wp3JeunePathwayService.addWp3JeunePathway(code_village45, nom_prenom45, sexe45, annee_naissance45,
					date_fin_frm45);

		}

		return "redirect:/listWp3JeunePathway";
	}

	/* END #45-CANEVAS JEUNE AYANT TERMINÉ FORMATION PATHWAY */

	/* START #46-CANEVAS JEUNE TECHNIQUE DE METIER DRAFT   */

	@RequestMapping("/uploadWp3JeuneTech")
	public String uploadWp3JeuneTech(Model model) {
		String[][] scList = ListeWp.wp();
		model.addAttribute("scList", scList);
		return "wp3/Wp3JeuneTech/uploadWp3JeuneTech";
	}

	@RequestMapping("/listWp3JeuneTech")
	public String listWp3JeuneTech(Model model) {
		List<Wp3JeuneTech> wp3JeuneTech = wp3JeuneTechService.ListWp3JeuneTech();
		model.addAttribute("wp3JeuneTech", wp3JeuneTech);
		return "wp3/Wp3JeuneTech/listWp3JeuneTech";
	}

	@PostMapping("/importWp3JeuneTech")
	public String importWp3JeuneTech(@RequestParam("file") MultipartFile reapExcelDataFile, Model model)
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
		return "wp3/Wp3JeuneTech/mise_formWp3JeuneTech";
	}

	@PostMapping("/saveWp3JeuneTech")
	public String saveWp3JeuneTech(@RequestParam("code_village") int code_village,
			@RequestParam("organisme_formateur") int organisme_formateur, @RequestParam("frm_recue") int frm_recue,
			@RequestParam("theme_frm1") int theme_frm1, @RequestParam("date_fin_frm1") int date_fin_frm1,
			@RequestParam("etape_frm1") int etape_frm1,

			/*
			 * @RequestParam("theme_frm2") int theme_frm2,
			 * 
			 * @RequestParam("date_real2") int date_real2,
			 * 
			 * @RequestParam("etape_frm2") int etape_frm2,
			 * 
			 * @RequestParam("theme_frm3") int theme_frm3,
			 * 
			 * @RequestParam("date_real3") int date_real3,
			 * 
			 * @RequestParam("etape_frm3") int etape_frm3,
			 */

			Model model) throws IOException, ParseException {

		XSSFSheet worksheet = workbook.getSheetAt(0);
		for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
			XSSFRow row = worksheet.getRow(i);

			String code_village46 = row.getCell(code_village).getStringCellValue();
			String organisme_formateur46 = row.getCell(organisme_formateur).getStringCellValue();
			boolean frm_recue46 = row.getCell(frm_recue).getStringCellValue().equalsIgnoreCase("Oui");

			String theme_frm146 = row.getCell(theme_frm1).getStringCellValue();
			java.util.Date date_fin_frm146 = row.getCell(date_fin_frm1).getDateCellValue();
			String etape_frm146 = row.getCell(etape_frm1).getStringCellValue();

			/*
			 * String theme_frm246 = row.getCell(theme_frm2).getStringCellValue();
			 * java.util.Date date_real246 = row.getCell(date_real2).getDateCellValue();
			 * String etape_frm246 = row.getCell(etape_frm2).getStringCellValue();
			 * 
			 * String theme_frm346 = row.getCell(theme_frm3).getStringCellValue();
			 * java.util.Date date_real346 = row.getCell(date_real3).getDateCellValue();
			 * String etape_frm346 = row.getCell(etape_frm3).getStringCellValue();
			 */

			wp3JeuneTechService.addWp3JeuneTech(code_village46, organisme_formateur46, frm_recue46, theme_frm146,
					date_fin_frm146, etape_frm146);

		}

		return "redirect:/listWp3JeuneTech";
	}

	/* END #46-CANEVAS JEUNE TECHNIQUE DE METIER DRAFT   */

	/* START #47-CANEVAS PEER EDUCATOR */

	@RequestMapping("/uploadWp3PeerEducator")
	public String uploadWp3PeerEducator(Model model) {
		String[][] scList = ListeWp.wp();
		model.addAttribute("scList", scList);
		return "wp3/Wp3PeerEducator/uploadWp3PeerEducator";
	}

	@RequestMapping("/listWp3PeerEducator")
	public String listWp3PeerEducator(Model model) {
		List<Wp3PeerEducator> wp3PeerEducator = wp3PeerEducatorService.ListWp3PeerEducator();
		model.addAttribute("wp3PeerEducator", wp3PeerEducator);
		return "wp3/Wp3PeerEducator/listWp3PeerEducator";
	}

	@PostMapping("/importWp3PeerEducator")
	public String importWp3PeerEducator(@RequestParam("file") MultipartFile reapExcelDataFile, Model model)
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
		return "wp3/Wp3PeerEducator/mise_formWp3PeerEducator";
	}

	@PostMapping("/saveWp3PeerEducator")
	public String saveWp3PeerEducator(@RequestParam("code_village") int code_village,
			@RequestParam("nom_prenom") int nom_prenom, @RequestParam("sexe") int sexe,
			@RequestParam("annee_naissance") int annee_naissance, @RequestParam("operationnelle") int operationnelle,
			@RequestParam("date_suivi") int date_suivi, Model model) throws IOException, ParseException {

		XSSFSheet worksheet = workbook.getSheetAt(0);
		for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
			XSSFRow row = worksheet.getRow(i);

			String code_village47 = row.getCell(code_village).getStringCellValue();
			String nom_prenom47 = row.getCell(nom_prenom).getStringCellValue();
			String sexe47 = row.getCell(sexe).getStringCellValue();
			int annee_naissance47 = (int) row.getCell(annee_naissance).getNumericCellValue();
			boolean operationnelle47 = row.getCell(operationnelle).getStringCellValue().equalsIgnoreCase("Oui");
			java.util.Date date_suivi47 = row.getCell(date_suivi).getDateCellValue();

			wp3PeerEducatorService.addWp3PeerEducator(code_village47, nom_prenom47, sexe47, annee_naissance47,
					operationnelle47, date_suivi47);
		}

		return "redirect:/listWp3PeerEducator";
	}

	/* END #47-CANEVAS PEER EDUCATOR */

	/* START #48-CANEVAS SERVICE SANTÉ PAR COMMUNAUTÉ */

	@RequestMapping("/uploadWp3SanteeComm")
	public String uploadWp3SanteeComm(Model model) {
		String[][] scList = ListeWp.wp();
		model.addAttribute("scList", scList);
		return "wp3/Wp3SanteeComm/uploadWp3SanteeComm";
	}

	@RequestMapping("/listWp3SanteeComm")
	public String listWp3SanteeComm(Model model) {
		List<Wp3SanteeComm> wp3SanteeComm = wp3SanteeCommService.ListWp3SanteeComm();
		model.addAttribute("wp3SanteeComm", wp3SanteeComm);
		return "wp3/Wp3SanteeComm/listWp3SanteeComm";
	}

	@PostMapping("/importWp3SanteeComm")
	public String importWp3SanteeComm(@RequestParam("file") MultipartFile reapExcelDataFile, Model model)
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
		return "wp3/Wp3SanteeComm/mise_formWp3SanteeComm";
	}

	@PostMapping("/saveWp3SanteeComm")
	public String saveWp3SanteeComm(@RequestParam("code_village") int code_village, @RequestParam("csb") int csb,
			@RequestParam("gps_x") int gps_x, @RequestParam("gps_y") int gps_y,
			@RequestParam("repro_sexuelle") int repro_sexuelle, @RequestParam("date_suivi") int date_suivi, Model model)
			throws IOException, ParseException {

		XSSFSheet worksheet = workbook.getSheetAt(0);
		for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
			XSSFRow row = worksheet.getRow(i);

			String code_village48 = row.getCell(code_village).getStringCellValue();
			String csb48 = row.getCell(csb).getStringCellValue();
			float gps_x48 = (float) row.getCell(gps_x).getNumericCellValue();
			float gps_y48 = (float) row.getCell(gps_y).getNumericCellValue();
			String repro_sexuelle48 = row.getCell(repro_sexuelle).getStringCellValue();
			java.util.Date date_suivi48 = row.getCell(date_suivi).getDateCellValue();

			wp3SanteeCommService.addWp3SanteeComm(code_village48, csb48, gps_x48, gps_y48, repro_sexuelle48,
					date_suivi48);
		}

		return "redirect:/listWp3SanteeComm";
	}

	/* END #48-CANEVAS SERVICE SANTÉ PAR COMMUNAUTÉ */

	/* START #49-CANEVAS DEMARRAGE UNITÉ ELÉVAGE JEUNEE 18 À 24 ANS   */

	@RequestMapping("/uploadWp3UniteElevJeune")
	public String uploadWp3UniteElevJeune(Model model) {
		String[][] scList = ListeWp.wp();
		model.addAttribute("scList", scList);
		return "wp3/Wp3UniteElevJeune/uploadWp3UniteElevJeune";
	}

	@RequestMapping("/listWp3UniteElevJeune")
	public String listWp3UniteElevJeune(Model model) {
		List<Wp3UniteElevJeune> wp3UniteElevJeune = wp3UniteElevJeuneService.ListWp3UniteElevJeune();
		model.addAttribute("wp3UniteElevJeune", wp3UniteElevJeune);
		return "wp3/Wp3UniteElevJeune/listWp3UniteElevJeune";
	}

	@PostMapping("/importWp3UniteElevJeune")
	public String importWp3UniteElevJeune(@RequestParam("file") MultipartFile reapExcelDataFile, Model model)
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
		return "wp3/Wp3UniteElevJeune/mise_formWp3UniteElevJeune";
	}

	@PostMapping("/saveWp3UniteElevJeune")
	public String saveWp3UniteElevJeune(@RequestParam("code_village") int code_village,
			@RequestParam("nom_prenom") int nom_prenom, @RequestParam("sexe") int sexe,
			@RequestParam("annee_naissance") int annee_naissance, @RequestParam("demarrage_unite") int demarrage_unite,
			@RequestParam("date_dem") int date_dem, @RequestParam("type_activite") int type_activite,
			@RequestParam("theme1_traite") int theme1_traite, @RequestParam("date_suivi1") int date_suivi1,

			/*
			 * @RequestParam("theme2_traite") int theme2_traite,
			 * 
			 * @RequestParam("date_suivi2") int date_suivi2,
			 * 
			 * @RequestParam("theme3_traite") int theme3_traite,
			 * 
			 * @RequestParam("date_suivi3") int date_suivi3,
			 */

			Model model)

			throws IOException, ParseException {

		XSSFSheet worksheet = workbook.getSheetAt(0);
		for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
			XSSFRow row = worksheet.getRow(i);

			String code_village49 = row.getCell(code_village).getStringCellValue();
			String nom_prenom49 = row.getCell(nom_prenom).getStringCellValue();
			String sexe49 = row.getCell(sexe).getStringCellValue();
			int annee_naissance49 = (int) row.getCell(annee_naissance).getNumericCellValue();
			String demarrage_unite49 = row.getCell(demarrage_unite).getStringCellValue();
			java.util.Date date_dem49 = row.getCell(date_dem).getDateCellValue();
			String type_activite49 = row.getCell(type_activite).getStringCellValue();

			String theme1_traite49 = row.getCell(theme1_traite).getStringCellValue();
			java.util.Date date_suivi149 = row.getCell(date_suivi1).getDateCellValue();

			/*
			 * String theme2_traite49 = row.getCell(theme2_traite).getStringCellValue();
			 * java.util.Date date_suivi249 = row.getCell(date_suivi2).getDateCellValue();
			 * 
			 * String theme3_traite49 = row.getCell(theme3_traite).getStringCellValue();
			 * java.util.Date date_suivi349 = row.getCell(date_suivi3).getDateCellValue();
			 */

			wp3UniteElevJeuneService.addWp3UniteElevJeune(code_village49, nom_prenom49, sexe49, annee_naissance49,
					demarrage_unite49, date_dem49, type_activite49, theme1_traite49, date_suivi149);
		}

		return "redirect:/listWp3UniteElevJeune";
	}

	/* END #49-CANEVAS DEMARRAGE UNITÉ ELÉVAGE JEUNEE 18 À 24 ANS */
}
