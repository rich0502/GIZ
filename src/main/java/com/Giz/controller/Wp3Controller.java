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
import com.Giz.data.domain.MiseForme;
import com.Giz.data.domain.Wp3ActivEcoJeune;
import com.Giz.data.domain.Wp3AgrDevMfr;
import com.Giz.data.domain.Wp3CommitteeActif;
import com.Giz.data.domain.Wp3ElevMfr;
import com.Giz.data.domain.Wp3EppFram;
import com.Giz.data.domain.Wp3EquipeTechMfr;
import com.Giz.data.domain.Wp3FedeMfr;
import com.Giz.data.domain.Wp3FormTechMetierJeune;
import com.Giz.data.domain.Wp3JeuneFormeMfr;
import com.Giz.data.domain.Wp3JeunePathway;
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
import com.Giz.service.metier.Wp3FormTechMetierJeuneService;
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

	@Autowired
	Wp3FormTechMetierJeuneService wp3FormTechMetierJeuneService;

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
		String[][] scList = ListeWp.wp();
		model.addAttribute("scList", scList);
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
			Model model, RedirectAttributes redirAttrs) throws IOException, ParseException {

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

			String activite = "CANEVAS ACTIVITE ECONOMIQUE JEUNE";

			wp3ActivEcoJeuneService.addWp3ActivEcoJeune(code_village37, nom_prenom37, sexe37, annee_naissance37,
					organisme_formateur37, frm_tech_suivi37, date_fin_frm37, activite_eco37, date_demarrage37,
					activite);
		}
		redirAttrs.addFlashAttribute("success", "Données importer avec succès");
		return "redirect:/listWp3ActivEcoJeune";
	}

	@GetMapping("/Wp3ActivEcoJeuneForm")
	public String Wp3ActivEcoJeuneForm(Model model) throws Exception {
		return "wp3/Wp3ActivEcoJeune/Form_addWp3ActivEcoJeune";
	}

	@PostMapping("/createWp3ActivEcoJeune")
	public String createWp3ActivEcoJeune(@RequestParam("code_village") String code_village,
			@RequestParam("nom_prenom") String nom_prenom, @RequestParam("sexe") String sexe,
			@RequestParam("annee_naissance") int annee_naissance,
			@RequestParam("organisme_formateur") String organisme_formateur,
			@RequestParam("frm_tech_suivi") String frm_tech_suivi,
			@RequestParam("date_fin_frm") java.sql.Date date_fin_frm, @RequestParam("activite_eco") String activite_eco,
			@RequestParam("date_demarrage") java.sql.Date date_demarrage, RedirectAttributes redirectAttributes)
			throws Exception {
		String activite = "CANEVAS ACTIVITE ECONOMIQUE JEUNE";
		Wp3ActivEcoJeune wp3ActivEcoJeune = new Wp3ActivEcoJeune();
		wp3ActivEcoJeune.setCode_village(code_village);
		wp3ActivEcoJeune.setSexe(sexe);
		wp3ActivEcoJeune.setNom_prenom(nom_prenom);
		wp3ActivEcoJeune.setAnnee_naissance(annee_naissance);
		wp3ActivEcoJeune.setOrganisme_formateur(organisme_formateur);
		wp3ActivEcoJeune.setFrm_tech_suivi(frm_tech_suivi);
		wp3ActivEcoJeune.setDate_fin_frm(date_fin_frm);
		wp3ActivEcoJeune.setActivite_eco(activite_eco);
		wp3ActivEcoJeune.setDate_demarrage(date_demarrage);
		wp3ActivEcoJeune.setActivite(activite);
		wp3ActivEcoJeuneService.createWp3ActivEcoJeune(wp3ActivEcoJeune);

		return "redirect:/listWp3ActivEcoJeune";

	}

	@RequestMapping("/editWp3ActivEcoJeune/{id}")
	public ModelAndView editWp3ActivEcoJeune(@PathVariable(name = "id") Long id, Model model) throws ParseException {
		ModelAndView mav = new ModelAndView("wp3/Wp3ActivEcoJeune/Form_modifWp3ActivEcoJeune");
		Optional<Wp3ActivEcoJeune> bf = wp3ActivEcoJeuneService.findByIdActivEcoJeune(id);
		mav.addObject("activEcoJeune", bf);
		return mav;
	}

	@RequestMapping(value = "/saveEditActivEcoJeune", method = RequestMethod.POST)
	public String saveEditActivEcoJeune(@RequestParam("id") long id, @RequestParam("code_village") String code_village,
			@RequestParam("nom_prenom") String nom_prenom, @RequestParam("sexe") String sexe,
			@RequestParam("annee_naissance") int annee_naissance,
			@RequestParam("organisme_formateur") String organisme_formateur,
			@RequestParam("frm_tech_suivi") String frm_tech_suivi,
			@RequestParam("date_fin_frm") java.sql.Date date_fin_frm, @RequestParam("activite_eco") String activite_eco,
			@RequestParam("date_demarrage") java.sql.Date date_demarrage, RedirectAttributes redirectAttributes)
			throws ParseException {
		wp3ActivEcoJeuneService.modifyActivEcoJeune(code_village, nom_prenom, sexe, annee_naissance,
				organisme_formateur, frm_tech_suivi, date_fin_frm, activite_eco, date_demarrage, id);
		return "redirect:/listWp3ActivEcoJeune";
	}

	@RequestMapping("/deleteWP3ActivEcoJeune/{id}")
	public String deleteWP3ActivEcoJeune(@PathVariable(name = "id") Long id) {
		wp3ActivEcoJeuneService.deleteWP3ActivEcoJeune(id);
		return "redirect:/listWp3ActivEcoJeune";
	}

	/* END #37-CANEVAS ACTIVITE ECONOMIQUE JEUNE */

	/* START #38-CANEVAS YOUTH COMMITTEE ACTIF */

	@GetMapping("/Wp3CommitteeActifForm")
	public String Wp3CommitteeActifForm(Model model) throws Exception {
		return "wp3/Wp3CommitteeActif/Form_addWp3CommitteeActif";
	}

	@PostMapping("/createWp3CommitteeActif")
	public String createWp3CommitteeActif(@RequestParam("code_village") String code_village,
			@RequestParam("nom_comite") String nom_comite,
			@RequestParam("mois_annee_creation") String mois_annee_creation,
			@RequestParam("committee_actif") boolean committee_actif,
			@RequestParam("date_suivi") java.sql.Date date_suivi, @RequestParam("effectif_membre") int effectif_membre,
			@RequestParam("sexe_h") int sexe_h, @RequestParam("sexe_f") int sexe_f,
			RedirectAttributes redirectAttributes) throws Exception {
		Wp3CommitteeActif wp3CommitteeActif = new Wp3CommitteeActif();
		wp3CommitteeActif.setCode_village(code_village);
		wp3CommitteeActif.setNom_comite(nom_comite);
		wp3CommitteeActif.setMois_annee_creation(mois_annee_creation);
		wp3CommitteeActif.setCommittee_actif(committee_actif);
		wp3CommitteeActif.setDate_suivi(date_suivi);
		wp3CommitteeActif.setEffectif_membre(effectif_membre);
		wp3CommitteeActif.setSexe_h(sexe_h);
		wp3CommitteeActif.setSexe_f(sexe_f);
		wp3CommitteeActifService.createWp3CommitteeActif(wp3CommitteeActif);

		return "redirect:/listWp3CommitteeActif";

	}

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
			@RequestParam("sexe_f") int sexe_f, Model model, RedirectAttributes redirAttrs) throws IOException, ParseException {

		XSSFSheet worksheet = workbook.getSheetAt(0);
		for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
			XSSFRow row = worksheet.getRow(i);

			String code_village38 = row.getCell(code_village).getStringCellValue();
			String nom_comite38 = row.getCell(nom_comite).getStringCellValue();
			String mois_annee_creation38 = row.getCell(mois_annee_creation).getStringCellValue();
			boolean committee_actif38 = row.getCell(committee_actif).getStringCellValue().equalsIgnoreCase("Oui");
			java.util.Date date_suivi38 = row.getCell(date_suivi).getDateCellValue();
			int effectif_membre38 = (int) row.getCell(effectif_membre).getNumericCellValue();
			int sexe_h38 = (int) row.getCell(sexe_h).getNumericCellValue();
			int sexe_f38 = (int) row.getCell(sexe_f).getNumericCellValue();

			wp3CommitteeActifService.addWp3CommitteeActif(code_village38, nom_comite38, mois_annee_creation38,
					committee_actif38, date_suivi38, effectif_membre38, sexe_h38, sexe_f38);

		}
		redirAttrs.addFlashAttribute("success", "Données importer avec succès");
		return "redirect:/listWp3CommitteeActif";
	}

	@RequestMapping("/editWp3CommitteeActif/{id}")
	public ModelAndView editWp3CommitteeActif(@PathVariable(name = "id") Long id, Model model) throws ParseException {
		ModelAndView mav = new ModelAndView("wp3/Wp3CommitteeActif/Form_modifWp3CommitteeActif");
		Optional<Wp3CommitteeActif> bf = wp3CommitteeActifService.findByIdCommitteeActif(id);
		mav.addObject("committeeActif", bf);
		return mav;
	}

	@RequestMapping(value = "/saveEditWp3CommitteeActif", method = RequestMethod.POST)
	public String saveEditWp3CommitteeActif(@RequestParam("id") long id,
			@RequestParam("code_village") String code_village, @RequestParam("nom_comite") String nom_comite,
			@RequestParam("mois_annee_creation") String mois_annee_creation,
			@RequestParam("committee_actif") boolean committee_actif,
			@RequestParam("date_suivi") java.sql.Date date_suivi, @RequestParam("effectif_membre") int effectif_membre,
			@RequestParam("sexe_h") int sexe_h, @RequestParam("sexe_f") int sexe_f,
			RedirectAttributes redirectAttributes) throws ParseException {
		wp3CommitteeActifService.modifyWp3CommitteeActif(code_village, nom_comite, mois_annee_creation, committee_actif,
				date_suivi, effectif_membre, sexe_h, sexe_f, id);
		return "redirect:/listWp3CommitteeActif";
	}

	@RequestMapping("/deleteWp3CommitteeActif/{id}")
	public String deleteWp3CommitteeActif(@PathVariable(name = "id") Long id) {
		wp3CommitteeActifService.deleteWp3CommitteeActif(id);
		return "redirect:/listWp3CommitteeActif";
	}

	/* END #38-CANEVAS YOUTH COMMITTEE ACTIF */

	/* START #39 CANEVAS FORMATION SUR LES TECHNIQUES/METIERS POUR LES JEUNES */

	@GetMapping("/Wp3FormTechMetierJeuneForm")
	public String Wp3FormTechMetierJeuneForm(Model model) throws Exception {
		return "wp3/Wp3FormTechMetierJeune/Form_addWp3FormTechMetierJeune";
	}

	@PostMapping("/createWp3FormTechMetierJeune")
	public String createWp3FormTechMetierJeune(@RequestParam("code_village") String code_village,
			@RequestParam("sexe") String sexe, @RequestParam("annee_naissance") int annee_naissance,
			@RequestParam("organisme_formateur") String organisme_formateur,
			@RequestParam("formation_recue") Boolean formation_recue, @RequestParam("theme") String theme,
			@RequestParam("date_fin") java.sql.Date date_fin, @RequestParam("etape_suivre") String etape_suivre,
			@RequestParam("date_realise") java.sql.Date date_realise, RedirectAttributes redirectAttributes)
			throws Exception {
		Wp3FormTechMetierJeune wp3FormTechMetierJeune = new Wp3FormTechMetierJeune();
		wp3FormTechMetierJeune.setCode_village(code_village);
		wp3FormTechMetierJeune.setSexe(sexe);
		wp3FormTechMetierJeune.setAnnee_naissance(annee_naissance);
		wp3FormTechMetierJeune.setOrganisme_formateur(organisme_formateur);
		wp3FormTechMetierJeune.setFormation_recue(formation_recue);
		wp3FormTechMetierJeune.setTheme(theme);
		wp3FormTechMetierJeune.setDate_fin(date_fin);
		wp3FormTechMetierJeune.setEtape_suivre(etape_suivre);
		wp3FormTechMetierJeune.setDate_realise(date_realise);
		wp3FormTechMetierJeuneService.createWp3FormTechMetierJeune(wp3FormTechMetierJeune);

		return "redirect:/listWp3FormTechMetierJeune";

	}

	@RequestMapping("/uploadWp3FormTechMetierJeune")
	public String uploadWp3FormTechMetierJeune(Model model) {
		String[][] scList = ListeWp.wp();
		model.addAttribute("scList", scList);
		return "wp3/Wp3FormTechMetierJeune/uploadWp3FormTechMetierJeune";
	}

	@RequestMapping("/listWp3FormTechMetierJeune")
	public String listWp3FormTechMetierJeune(Model model) {
		List<Wp3FormTechMetierJeune> wp3FormTechMetierJeune = wp3FormTechMetierJeuneService
				.ListWp3FormTechMetierJeune();
		model.addAttribute("wp3FormTechMetierJeune", wp3FormTechMetierJeune);
		return "wp3/Wp3FormTechMetierJeune/listWp3FormTechMetierJeune";
	}

	@PostMapping("/importWp3FormTechMetierJeune")
	public String importWp3FormTechMetierJeune(@RequestParam("file") MultipartFile reapExcelDataFile, Model model)
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
		return "wp3/Wp3FormTechMetierJeune/mise_formWp3FormTechMetierJeune";
	}

	@PostMapping("/saveWp3FormTechMetierJeune")
	public String saveWp3FormTechMetierJeune(@RequestParam("code_village") int code_village,
			@RequestParam("sexe") int sexe, @RequestParam("annee_naissance") int annee_naissance,
			@RequestParam("organisme_formateur") int organisme_formateur,
			@RequestParam("formation_recue") int formation_recue, @RequestParam("theme") int theme,
			@RequestParam("date_fin") int date_fin, @RequestParam("etape_suivre") int etape_suivre,
			@RequestParam("date_realise") int date_realise, Model model, RedirectAttributes redirAttrs) throws IOException, ParseException {

		XSSFSheet worksheet = workbook.getSheetAt(0);
		for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
			XSSFRow row = worksheet.getRow(i);

			String code_village39 = row.getCell(code_village).getStringCellValue();
			String sexe39 = row.getCell(sexe).getStringCellValue();
			int annee_naissance39 = (int) row.getCell(annee_naissance).getNumericCellValue();
			String organisme_formateur39 = row.getCell(organisme_formateur).getStringCellValue();
			boolean formation_recue39 = row.getCell(formation_recue).getStringCellValue().equalsIgnoreCase("Oui");
			String theme39 = row.getCell(theme).getStringCellValue();
			java.util.Date date_fin39 = row.getCell(date_fin).getDateCellValue();
			String etape_suivre39 = row.getCell(etape_suivre).getStringCellValue();
			java.util.Date date_realise39 = row.getCell(date_realise).getDateCellValue();

			wp3FormTechMetierJeuneService.addWp3FormTechMetierJeune(code_village39, sexe39, annee_naissance39,
					organisme_formateur39, formation_recue39, theme39, date_fin39, etape_suivre39, date_realise39);

		}
		redirAttrs.addFlashAttribute("success", "Données importer avec succès");
		return "redirect:/listWp3FormTechMetierJeune";
	}

	@RequestMapping("/editWp3FormTechMetierJeune/{id}")
	public ModelAndView editWp3FormTechMetierJeune(@PathVariable(name = "id") Long id, Model model)
			throws ParseException {
		ModelAndView mav = new ModelAndView("wp3/Wp3FormTechMetierJeune/Form_modifWp3FormTechMetierJeune");
		Optional<Wp3FormTechMetierJeune> bf = wp3FormTechMetierJeuneService.findByIdWp3FormTechMetierJeune(id);
		mav.addObject("formTechMetierJeune", bf);
		return mav;
	}

	@RequestMapping(value = "/saveEditWp3FormTechMetierJeune", method = RequestMethod.POST)
	public String saveEditWp3FormTechMetierJeune(@RequestParam("id") long id,
			@RequestParam("code_village") String code_village, @RequestParam("sexe") String sexe,
			@RequestParam("annee_naissance") int annee_naissance,
			@RequestParam("organisme_formateur") String organisme_formateur,
			@RequestParam("formation_recue") Boolean formation_recue, @RequestParam("theme") String theme,
			@RequestParam("date_fin") java.sql.Date date_fin, @RequestParam("etape_suivre") String etape_suivre,
			@RequestParam("date_realise") java.sql.Date date_realise, RedirectAttributes redirectAttributes)
			throws ParseException {
		wp3FormTechMetierJeuneService.modifyWp3FormTechMetierJeune(code_village, sexe, annee_naissance,
				organisme_formateur, formation_recue, theme, date_fin, etape_suivre, date_realise, id);
		return "redirect:/listWp3FormTechMetierJeune";
	}

	@RequestMapping("/deleteWp3FormTechMetierJeune/{id}")
	public String deleteWp3FormTechMetierJeune(@PathVariable(name = "id") Long id) {
		wp3FormTechMetierJeuneService.deleteWp3FormTechMetierJeune(id);
		return "redirect:/listWp3FormTechMetierJeune";
	}

	/* END #39 CANEVAS FORMATION SUR LES TECHNIQUES/METIERS POUR LES JEUNES */

	/*
	 * START 40 CANEVAS DEMARRAGE UNITE D'ELEVAGE EN ADOPTANT LES BONNES PRATIQUES
	 * POUR LES JEUNES DE 18 à 24 ans
	 */

	@GetMapping("/Wp3UniteElevJeuneForm")
	public String Wp3UniteElevJeuneForm(Model model) throws Exception {
		return "wp3/Wp3UniteElevJeune/Form_addWp3UniteElevJeune";
	}

	@PostMapping("/createWp3UniteElevJeune")
	public String createWp3UniteElevJeune(@RequestParam("code_village") String code_village,
			@RequestParam("nom_prenom") String nom_prenom, @RequestParam("sexe") String sexe,
			@RequestParam("annee_naissance") int annee_naissance,
			@RequestParam("demarrage_unite") boolean demarrage_unite, @RequestParam("date_dem") java.sql.Date date_dem,
			@RequestParam("type_activite") String type_activite, @RequestParam("theme1_traite") String theme1_traite,
			@RequestParam("date_suivi1") java.sql.Date date_suivi1, RedirectAttributes redirectAttributes)
			throws Exception {
		String activite = "CANEVAS DEMARRAGE UNITE D'ELEVAGE EN ADOPTANT LES BONNES PRATIQUES POUR LES JEUNES DE 18 à 24 ans";
		Wp3UniteElevJeune wp3UniteElevJeune = new Wp3UniteElevJeune();
		wp3UniteElevJeune.setCode_village(code_village);
		wp3UniteElevJeune.setNom_prenom(nom_prenom);
		wp3UniteElevJeune.setSexe(sexe);
		wp3UniteElevJeune.setAnnee_naissance(annee_naissance);
		wp3UniteElevJeune.setDemarrage_unite(demarrage_unite);
		wp3UniteElevJeune.setDate_dem(date_dem);
		wp3UniteElevJeune.setType_activite(type_activite);
		wp3UniteElevJeune.setTheme1_traite(theme1_traite);
		wp3UniteElevJeune.setDate_suivi1(date_suivi1);
		wp3UniteElevJeune.setActivite(activite);
		wp3UniteElevJeuneService.createWp3UniteElevJeune(wp3UniteElevJeune);

		return "redirect:/listWp3UniteElevJeune";

	}

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
			@RequestParam("theme1_traite") int theme1_traite, @RequestParam("date_suivi1") int date_suivi1, Model model, RedirectAttributes redirAttrs)

			throws IOException, ParseException {

		XSSFSheet worksheet = workbook.getSheetAt(0);
		for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
			XSSFRow row = worksheet.getRow(i);

			String code_village40 = row.getCell(code_village).getStringCellValue();
			String nom_prenom40 = row.getCell(nom_prenom).getStringCellValue();
			String sexe40 = row.getCell(sexe).getStringCellValue();
			int annee_naissance40 = (int) row.getCell(annee_naissance).getNumericCellValue();
			Boolean demarrage_unite40 = row.getCell(demarrage_unite).getStringCellValue().equalsIgnoreCase("Oui");
			java.util.Date date_dem40 = row.getCell(date_dem).getDateCellValue();
			String type_activite40 = row.getCell(type_activite).getStringCellValue();

			String theme1_traite40 = row.getCell(theme1_traite).getStringCellValue();
			java.util.Date date_suivi140 = row.getCell(date_suivi1).getDateCellValue();

			String activite = "CANEVAS DEMARRAGE UNITE D'ELEVAGE EN ADOPTANT LES BONNES PRATIQUES POUR LES JEUNES DE 18 à 24 ans";

			wp3UniteElevJeuneService.addWp3UniteElevJeune(code_village40, nom_prenom40, sexe40, annee_naissance40,
					demarrage_unite40, date_dem40, type_activite40, theme1_traite40, date_suivi140, activite);
		}
		redirAttrs.addFlashAttribute("success", "Données importer avec succès");
		return "redirect:/listWp3UniteElevJeune";
	}

	@RequestMapping("/editWp3UniteElevJeune/{id}")
	public ModelAndView editWp3UniteElevJeune(@PathVariable(name = "id") Long id, Model model) throws ParseException {
		ModelAndView mav = new ModelAndView("wp3/Wp3UniteElevJeune/Form_modifWp3UniteElevJeune");
		Optional<Wp3UniteElevJeune> bf = wp3UniteElevJeuneService.findByIdUniteElevJeune(id);
		mav.addObject("uniteElevJeune", bf);
		return mav;
	}

	@RequestMapping(value = "/saveEditWp3UniteElevJeune", method = RequestMethod.POST)
	public String saveEditWp3UniteElevJeune(@RequestParam("id") long id,
			@RequestParam("code_village") String code_village, @RequestParam("nom_prenom") String nom_prenom,
			@RequestParam("sexe") String sexe, @RequestParam("annee_naissance") int annee_naissance,
			@RequestParam("demarrage_unite") Boolean demarrage_unite, @RequestParam("date_dem") java.sql.Date date_dem,
			@RequestParam("type_activite") String type_activite, @RequestParam("theme1_traite") String theme1_traite,
			@RequestParam("date_suivi1") java.sql.Date date_suivi1, RedirectAttributes redirectAttributes)
			throws ParseException {
		wp3UniteElevJeuneService.modifyWp3UniteElevJeune(code_village, nom_prenom, sexe, annee_naissance,
				demarrage_unite, date_dem, type_activite, theme1_traite, date_suivi1, id);
		return "redirect:/listWp3UniteElevJeune";
	}

	@RequestMapping("/deleteWp3UniteElevJeune/{id}")
	public String deleteWp3UniteElevJeune(@PathVariable(name = "id") Long id) {
		wp3UniteElevJeuneService.deleteWp3UniteElevJeune(id);
		return "redirect:/listWp3UniteElevJeune";
	}

	/*
	 * END CANEVAS DEMARRAGE UNITE D'ELEVAGE EN ADOPTANT LES BONNES PRATIQUES POUR
	 * LES JEUNES DE 18 à 24 ans
	 */

	/* START #41-CANEVAS ELÈVE INSCRIT MFR DRAFT */

	@GetMapping("/Wp3ElevMfrForm")
	public String Wp3ElevMfrForm(Model model) throws Exception {
		return "wp3/Wp3ElevMfr/Form_addWp3ElevMfr";
	}

	@PostMapping("/createWp3ElevMfr")
	public String createWp3ElevMfr(@RequestParam("code_village") String code_village,
			@RequestParam("nom_prenom") String nom_prenom, @RequestParam("village_origine") String village_origine,
			@RequestParam("sexe") String sexe, @RequestParam("annee_naissance") int annee_naissance,
			@RequestParam("inscrit") boolean inscrit, @RequestParam("annee_inscription") int annee_inscription,
			@RequestParam("date_suivi") java.sql.Date date_suivi, @RequestParam("type_frm") String type_frm,
			@RequestParam("annee_etude") int annee_etude, @RequestParam("date_sortie") java.sql.Date date_sortie,
			@RequestParam("type_projet") String type_projet, @RequestParam("niveau_demarrage") String niveau_demarrage,
			@RequestParam("date_validation") java.sql.Date date_validation,
			@RequestParam("accompagne") boolean accompagne, @RequestParam("date_suivi1") java.sql.Date date_suivi1,
			RedirectAttributes redirectAttributes) throws Exception {
		String activite = "CANEVAS ELÈVE INSCRIT MFR DRAFT";
		Wp3ElevMfr wp3ElevMfr = new Wp3ElevMfr();
		wp3ElevMfr.setCode_village(code_village);
		wp3ElevMfr.setNom_prenom(nom_prenom);
		wp3ElevMfr.setVillage_origine(village_origine);
		wp3ElevMfr.setSexe(sexe);
		wp3ElevMfr.setAnnee_naissance(annee_naissance);
		wp3ElevMfr.setInscrit(inscrit);
		wp3ElevMfr.setAnnee_inscription(annee_inscription);
		wp3ElevMfr.setDate_suivi(date_suivi);
		wp3ElevMfr.setType_frm(type_frm);
		wp3ElevMfr.setAnnee_etude(annee_etude);
		wp3ElevMfr.setDate_sortie(date_sortie);
		wp3ElevMfr.setType_projet(type_projet);
		wp3ElevMfr.setNiveau_demarrage(niveau_demarrage);
		wp3ElevMfr.setDate_validation(date_validation);
		wp3ElevMfr.setAccompagne(accompagne);
		wp3ElevMfr.setDate_suivi1(date_suivi1);
		wp3ElevMfr.setActivite(activite);
		wp3ElevMfrService.createWp3ElevMfr(wp3ElevMfr);

		return "redirect:/listWp3ElevMfr";

	}

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
			@RequestParam("date_suivi1") int date_suivi1, Model model, RedirectAttributes redirAttrs) throws IOException, ParseException {

		XSSFSheet worksheet = workbook.getSheetAt(0);
		for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
			XSSFRow row = worksheet.getRow(i);

			String code_village41 = row.getCell(code_village).getStringCellValue();
			String nom_prenom41 = row.getCell(nom_prenom).getStringCellValue();
			String village_origine41 = row.getCell(village_origine).getStringCellValue();
			String sexe41 = row.getCell(sexe).getStringCellValue();
			int annee_naissance41 = (int) row.getCell(annee_naissance).getNumericCellValue();
			boolean inscrit41 = row.getCell(inscrit).getStringCellValue().equalsIgnoreCase("Oui");
			int annee_inscription41 = (int) row.getCell(annee_inscription).getNumericCellValue();
			java.util.Date date_suivi41 = row.getCell(date_suivi).getDateCellValue();
			String type_frm41 = row.getCell(type_frm).getStringCellValue();
			int annee_etude41 = (int) row.getCell(annee_etude).getNumericCellValue();
			java.util.Date date_sortie41 = row.getCell(date_sortie).getDateCellValue();
			String type_projet41 = row.getCell(type_projet).getStringCellValue();
			String niveau_demarrage41 = row.getCell(niveau_demarrage).getStringCellValue();
			java.util.Date date_validation41 = row.getCell(date_validation).getDateCellValue();
			boolean accompagne41 = row.getCell(accompagne).getStringCellValue().equalsIgnoreCase("Oui");
			java.util.Date date_suivi141 = row.getCell(date_suivi1).getDateCellValue();

			String activite = "CANEVAS ELÈVE INSCRIT MFR DRAFT";

			wp3ElevMfrService.addWp3ElevMfr(code_village41, nom_prenom41, village_origine41, sexe41, annee_naissance41,
					inscrit41, annee_inscription41, date_suivi41, type_frm41, annee_etude41, date_sortie41,
					type_projet41, niveau_demarrage41, date_validation41, accompagne41, date_suivi141, activite);
		}
		redirAttrs.addFlashAttribute("success", "Données importer avec succès");
		return "redirect:/listWp3ElevMfr";
	}

	@RequestMapping("/editWp3ElevMfr/{id}")
	public ModelAndView editWp3ElevMfr(@PathVariable(name = "id") Long id, Model model) throws ParseException {
		ModelAndView mav = new ModelAndView("wp3/Wp3ElevMfr/Form_modifWp3ElevMfr");
		Optional<Wp3ElevMfr> bf = wp3ElevMfrService.findByIdWp3ElevMfr(id);
		mav.addObject("elevMfr", bf);
		return mav;
	}

	@RequestMapping(value = "/saveEditWp3ElevMfr", method = RequestMethod.POST)
	public String saveEditWp3ElevMfr(@RequestParam("code_village") String code_village,
			@RequestParam("nom_prenom") String nom_prenom, @RequestParam("village_origine") String village_origine,
			@RequestParam("sexe") String sexe, @RequestParam("annee_naissance") int annee_naissance,
			@RequestParam("inscrit") Boolean inscrit, @RequestParam("annee_inscription") int annee_inscription,
			@RequestParam("date_suivi") java.sql.Date date_suivi, @RequestParam("type_frm") String type_frm,
			@RequestParam("annee_etude") int annee_etude, @RequestParam("date_sortie") java.sql.Date date_sortie,
			@RequestParam("type_projet") String type_projet, @RequestParam("niveau_demarrage") String niveau_demarrage,
			@RequestParam("date_validation") java.sql.Date date_validation,
			@RequestParam("accompagne") Boolean accompagne, @RequestParam("date_suivi1") java.sql.Date date_suivi1,
			long id, RedirectAttributes redirectAttributes) throws ParseException {
		wp3ElevMfrService.modifyWp3ElevMfr(code_village, nom_prenom, village_origine, sexe, annee_naissance, inscrit,
				annee_inscription, date_suivi, type_frm, annee_etude, date_sortie, type_projet, niveau_demarrage,
				date_validation, accompagne, date_suivi1, id);
		return "redirect:/listWp3ElevMfr";
	}

	@RequestMapping("/deleteWp3ElevMfr/{id}")
	public String deleteWp3ElevMfr(@PathVariable(name = "id") Long id) {
		wp3ElevMfrService.deleteWp3ElevMfr(id);
		return "redirect:/listWp3ElevMfr";
	}

	/* END #41-CANEVAS ELÈVE INSCRIT MFR DRAFT */

	/* START #42-CANEVAS JEUNE FORME MFR ACCOMPAGNE */
	@GetMapping("/Wp3JeuneFormeMfrForm")
	public String Wp3JeuneFormeMfrForm(Model model) throws Exception {
		return "wp3/Wp3JeuneFormeMfr/Form_addWp3JeuneFormeMfr";
	}

	@PostMapping("/createWp3JeuneFormeMfr")
	public String createWp3JeuneFormeMfr(@RequestParam("code_village") String code_village,
			@RequestParam("nom_prenom") String nom_prenom, @RequestParam("sexe") String sexe,
			@RequestParam("annee_naissance") int annee_naissance, @RequestParam("forme") boolean forme,
			@RequestParam("accompagne_sortie") boolean accompagne_sortie,
			@RequestParam("type_accompagnement") String type_accompagnement,
			@RequestParam("date_suivi") java.sql.Date date_suivi, RedirectAttributes redirectAttributes)
			throws Exception {
		String activite = "CANEVAS JEUNE FORME MFR ACCOMPAGNE";
		Wp3JeuneFormeMfr wp3JeuneFormeMfr = new Wp3JeuneFormeMfr();
		wp3JeuneFormeMfr.setCode_village(code_village);
		wp3JeuneFormeMfr.setNom_prenom(nom_prenom);
		wp3JeuneFormeMfr.setSexe(sexe);
		wp3JeuneFormeMfr.setAnnee_naissance(annee_naissance);
		wp3JeuneFormeMfr.setForme(forme);
		wp3JeuneFormeMfr.setAccompagne_sortie(accompagne_sortie);
		wp3JeuneFormeMfr.setType_accompagnement(type_accompagnement);
		wp3JeuneFormeMfr.setDate_suivi(date_suivi);
		wp3JeuneFormeMfr.setActivite(activite);
		wp3JeuneFormeMfrService.createWp3JeuneFormeMfr(wp3JeuneFormeMfr);

		return "redirect:/listWp3JeuneFormeMfr";

	}

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
			Model model, RedirectAttributes redirAttrs) throws IOException, ParseException {

		XSSFSheet worksheet = workbook.getSheetAt(0);
		for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
			XSSFRow row = worksheet.getRow(i);

			String code_village42 = row.getCell(code_village).getStringCellValue();
			String nom_prenom42 = row.getCell(nom_prenom).getStringCellValue();
			String sexe42 = row.getCell(sexe).getStringCellValue();
			int annee_naissance42 = (int) row.getCell(annee_naissance).getNumericCellValue();
			boolean forme42 = row.getCell(forme).getStringCellValue().equalsIgnoreCase("Oui");
			boolean accompagne_sortie42 = row.getCell(accompagne_sortie).getStringCellValue().equalsIgnoreCase("Oui");
			String type_accompagnement42 = row.getCell(type_accompagnement).getStringCellValue();
			java.util.Date date_suivi42 = row.getCell(date_suivi).getDateCellValue();

			String activite = "CANEVAS JEUNE FORME MFR ACCOMPAGNE";

			wp3JeuneFormeMfrService.addWp3JeuneFormeMfr(code_village42, nom_prenom42, sexe42, annee_naissance42,
					forme42, accompagne_sortie42, type_accompagnement42, date_suivi42, activite);

		}
		redirAttrs.addFlashAttribute("success", "Données importer avec succès");
		return "redirect:/listWp3JeuneFormeMfr";
	}

	@RequestMapping("/editWp3JeuneFormeMfr/{id}")
	public ModelAndView editWp3JeuneFormeMfr(@PathVariable(name = "id") Long id, Model model) throws ParseException {
		ModelAndView mav = new ModelAndView("wp3/Wp3JeuneFormeMfr/Form_modifWp3JeuneFormeMfr");
		Optional<Wp3JeuneFormeMfr> bf = wp3JeuneFormeMfrService.findByIdJeuneFormeMfr(id);
		mav.addObject("jeuneFormeMfr", bf);
		return mav;
	}

	@RequestMapping(value = "/saveEditWp3JeuneFormeMfr", method = RequestMethod.POST)
	public String saveEditWp3JeuneFormeMfr(@RequestParam("code_village") String code_village,
			@RequestParam("nom_prenom") String nom_prenom, @RequestParam("sexe") String sexe,
			@RequestParam("annee_naissance") int annee_naissance, @RequestParam("forme") Boolean forme,
			@RequestParam("accompagne_sortie") Boolean accompagne_sortie,
			@RequestParam("type_accompagnement") String type_accompagnement,
			@RequestParam("date_suivi") java.sql.Date date_suivi, long id, RedirectAttributes redirectAttributes)
			throws ParseException {
		wp3JeuneFormeMfrService.modifyWp3JeuneFormeMfr(code_village, nom_prenom, sexe, annee_naissance, forme,
				accompagne_sortie, type_accompagnement, date_suivi, id);
		return "redirect:/listWp3JeuneFormeMfr";
	}

	@RequestMapping("/deleteWp3JeuneFormeMfr/{id}")
	public String deleteWp3JeuneFormeMfr(@PathVariable(name = "id") Long id) {
		wp3JeuneFormeMfrService.deleteWp3JeuneFormeMfr(id);
		return "redirect:/listWp3JeuneFormeMfr";
	}

	/* END #42-CANEVAS JEUNE FORME MFR ACCOMPAGNE */

	/* START #43-CANEVAS FEDERATION REGIONALE MFR */
	@GetMapping("/Wp3FedeMfrForm")
	public String Wp3FedeMfrForm(Model model) throws Exception {
		return "wp3/Wp3FedeMfr/Form_addWp3FedeMfr";
	}

	@PostMapping("/createWp3FedeMfr")
	public String createWp3FedeMfr(@RequestParam("code_region") String code_region,
			@RequestParam("nom_mfr") String nom_mfr, @RequestParam("sexe") String sexe,
			@RequestParam("annee_miseplace") int annee_miseplace, @RequestParam("statut") boolean statut,
			@RequestParam("reglement_interieur") boolean reglement_interieur,
			@RequestParam("recepisse_mfr") boolean recepisse_mfr,
			@RequestParam("date_recepisse") java.sql.Date date_recepisse,
			@RequestParam("plan_strategique") boolean plan_strategique,
			@RequestParam("date_validation") java.sql.Date date_validation, RedirectAttributes redirectAttributes)
			throws Exception {
		Wp3FedeMfr wp3FedeMfr = new Wp3FedeMfr();

		wp3FedeMfr.setCode_region(code_region);
		wp3FedeMfr.setNom_mfr(nom_mfr);
		wp3FedeMfr.setSexe(sexe);
		wp3FedeMfr.setAnnee_miseplace(annee_miseplace);
		wp3FedeMfr.setStatut(statut);
		wp3FedeMfr.setReglement_interieur(reglement_interieur);
		wp3FedeMfr.setRecepisse_mfr(recepisse_mfr);
		wp3FedeMfr.setDate_recepisse(date_recepisse);
		wp3FedeMfr.setPlan_strategique(plan_strategique);
		wp3FedeMfr.setDate_validation(date_validation);
		wp3FedeMfrService.createWp3FedeMfr(wp3FedeMfr);

		return "redirect:/listWp3FedeMfr";

	}

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
			@RequestParam("date_validation") int date_validation, Model model, RedirectAttributes redirAttrs) throws IOException, ParseException {

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
		redirAttrs.addFlashAttribute("success", "Données importer avec succès");
		return "redirect:/listWp3FedeMfr";
	}

	@RequestMapping("/editWp3FedeMfr/{id}")
	public ModelAndView editWp3FedeMfr(@PathVariable(name = "id") Long id, Model model) throws ParseException {
		ModelAndView mav = new ModelAndView("wp3/Wp3FedeMfr/Form_modifWp3FedeMfr");
		Optional<Wp3FedeMfr> bf = wp3FedeMfrService.findByIdFedeMfr(id);
		mav.addObject("fedeMfr", bf);
		return mav;
	}

	@RequestMapping(value = "/saveEditWp3FedeMfr", method = RequestMethod.POST)
	public String saveEditWp3FedeMfr(@RequestParam("code_region") String code_region,
			@RequestParam("nom_mfr") String nom_mfr, @RequestParam("sexe") String sexe,
			@RequestParam("annee_miseplace") int annee_miseplace, @RequestParam("statut") Boolean statut,
			@RequestParam("reglement_interieur") Boolean reglement_interieur,
			@RequestParam("recepisse_mfr") Boolean recepisse_mfr,
			@RequestParam("date_recepisse") java.sql.Date date_recepisse,
			@RequestParam("plan_strategique") Boolean plan_strategique,
			@RequestParam("date_validation") java.sql.Date date_validation, long id,
			RedirectAttributes redirectAttributes) throws ParseException {
		wp3FedeMfrService.modifyWp3FedeMfr(code_region, nom_mfr, sexe, annee_miseplace, statut, reglement_interieur,
				recepisse_mfr, date_recepisse, plan_strategique, date_validation, id);
		return "redirect:/listWp3FedeMfr";
	}

	@RequestMapping("/deleteWp3FedeMfr/{id}")
	public String deleteWp3FedeMfr(@PathVariable(name = "id") Long id) {
		wp3FedeMfrService.deleteWp3FedeMfr(id);
		return "redirect:/listWp3FedeMfr";
	}

	/* END #43-CANEVAS FEDERATION REGIONALE MFR */

	/* START #44-CANEVAS BDD ÉQUIPE TECHNIQUE MFR */
	@GetMapping("/Wp3EquipeTechMfrForm")
	public String Wp3EquipeTechMfrForm(Model model) throws Exception {
		return "wp3/Wp3EquipeTechMfr/Form_addWp3EquipeTechMfr";
	}

	@PostMapping("/createWp3EquipeTechMfr")
	public String createWp3EquipeTechMfr(@RequestParam("code_village") String code_village,
			@RequestParam("nom_prenom") String nom_prenom, @RequestParam("sexe") String sexe,
			@RequestParam("annee_naissance") int annee_naissance, @RequestParam("frm_recue1") String frm_recue1,
			@RequestParam("competence_frm") boolean competence_frm, @RequestParam("date_eval") java.sql.Date date_eval,
			RedirectAttributes redirectAttributes) throws Exception {
		String activite = "CANEVAS BDD ÉQUIPE TECHNIQUE MFR";
		Wp3EquipeTechMfr wp3EquipeTechMfr = new Wp3EquipeTechMfr();
		wp3EquipeTechMfr.setCode_village(code_village);
		wp3EquipeTechMfr.setNom_prenom(nom_prenom);
		wp3EquipeTechMfr.setSexe(sexe);
		wp3EquipeTechMfr.setAnnee_naissance(annee_naissance);
		wp3EquipeTechMfr.setFrm_recue1(frm_recue1);
		wp3EquipeTechMfr.setCompetence_frm(competence_frm);
		wp3EquipeTechMfr.setDate_eval(date_eval);
		wp3EquipeTechMfr.setActivite(activite);
		wp3EquipeTechMfrService.createWp3EquipeTechMfr(wp3EquipeTechMfr);

		return "redirect:/listWp3EquipeTechMfr";

	}

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
			@RequestParam("competence_frm") int competence_frm, @RequestParam("date_eval") int date_eval, Model model, 
			RedirectAttributes redirAttrs) throws IOException, ParseException {

		XSSFSheet worksheet = workbook.getSheetAt(0);
		for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
			XSSFRow row = worksheet.getRow(i);

			String code_village44 = row.getCell(code_village).getStringCellValue();
			String nom_prenom44 = row.getCell(nom_prenom).getStringCellValue();
			String sexe44 = row.getCell(sexe).getStringCellValue();
			int annee_naissance44 = (int) row.getCell(annee_naissance).getNumericCellValue();
			String Frm_recue144 = row.getCell(Frm_recue1).getStringCellValue();
			boolean competence_frm44 = row.getCell(competence_frm).getStringCellValue().equalsIgnoreCase("Oui");
			java.util.Date date_eval44 = row.getCell(date_eval).getDateCellValue();

			String activite = "CANEVAS BDD ÉQUIPE TECHNIQUE MFR";

			wp3EquipeTechMfrService.addWp3EquipeTechMfr(code_village44, nom_prenom44, sexe44, annee_naissance44,
					Frm_recue144, competence_frm44, date_eval44, activite);

		}
		redirAttrs.addFlashAttribute("success", "Données importer avec succès");
		return "redirect:/listWp3EquipeTechMfr";
	}

	@RequestMapping("/editWp3EquipeTechMfr/{id}")
	public ModelAndView editWp3EquipeTechMfr(@PathVariable(name = "id") Long id, Model model) throws ParseException {
		ModelAndView mav = new ModelAndView("wp3/Wp3EquipeTechMfr/Form_modifWp3EquipeTechMfr");
		Optional<Wp3EquipeTechMfr> bf = wp3EquipeTechMfrService.findByIdEquipeTechMfr(id);
		mav.addObject("equipeTechMfr", bf);
		return mav;
	}

	@RequestMapping(value = "/saveEditWp3EquipeTechMfr", method = RequestMethod.POST)
	public String saveEditWp3EquipeTechMfr(@RequestParam("code_village") String code_village,
			@RequestParam("nom_prenom") String nom_prenom, @RequestParam("sexe") String sexe,
			@RequestParam("annee_naissance") int annee_naissance, @RequestParam("frm_recue1") String frm_recue1,
			@RequestParam("competence_frm") Boolean competence_frm, @RequestParam("date_eval") java.sql.Date date_eval,
			long id, RedirectAttributes redirectAttributes) throws ParseException {
		wp3EquipeTechMfrService.modifyWp3EquipeTechMfr(code_village, nom_prenom, sexe, annee_naissance, frm_recue1,
				competence_frm, date_eval, id);
		return "redirect:/listWp3EquipeTechMfr";
	}

	@RequestMapping("/deleteWp3EquipeTechMfr/{id}")
	public String deleteWp3EquipeTechMfr(@PathVariable(name = "id") Long id) {
		wp3EquipeTechMfrService.deleteWp3EquipeTechMfr(id);
		return "redirect:/listWp3EquipeTechMfr";
	}

	/* END #44-CANEVAS BDD ÉQUIPE TECHNIQUE MFR */

	/* START #45-CANEVAS AGR DÉVELOPPÉ MFR SAVA */
	@GetMapping("/Wp3AgrDevMfrForm")
	public String Wp3AgrDevMfrForm(Model model) throws Exception {
		return "wp3/Wp3AgrDevMfr/Form_addWp3AgrDevMfr";
	}

	@PostMapping("/createWp3AgrDevMfr")
	public String createWp3AgrDevMfr(@RequestParam("code_village") String code_village,
			@RequestParam("nom_mfr") String nom_mfr, @RequestParam("sexe") String sexe,
			@RequestParam("annee_miseplace") int annee_miseplace, @RequestParam("agr_developpe") boolean agr_developpe,
			@RequestParam("date_eval") java.sql.Date date_eval, @RequestParam("type_agr_dev1") String type_agr_dev1,
			@RequestParam("date_suivi1") java.sql.Date date_suivi1, RedirectAttributes redirectAttributes)
			throws Exception {
		Wp3AgrDevMfr wp3AgrDevMfr = new Wp3AgrDevMfr();
		wp3AgrDevMfr.setCode_village(code_village);
		wp3AgrDevMfr.setNom_mfr(nom_mfr);
		wp3AgrDevMfr.setSexe(sexe);
		wp3AgrDevMfr.setAnnee_miseplace(annee_miseplace);
		wp3AgrDevMfr.setAgr_developpe(agr_developpe);
		wp3AgrDevMfr.setDate_eval(date_eval);
		wp3AgrDevMfr.setType_agr_dev1(type_agr_dev1);
		wp3AgrDevMfr.setDate_suivi1(date_suivi1);
		wp3AgrDevMfrService.createWp3AgrDevMfr(wp3AgrDevMfr);

		return "redirect:/listWp3AgrDevMfr";

	}

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
			@RequestParam("date_suivi1") int date_suivi1, Model model, RedirectAttributes redirAttrs) throws IOException, ParseException {

		XSSFSheet worksheet = workbook.getSheetAt(0);
		for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
			XSSFRow row = worksheet.getRow(i);

			String code_village38 = row.getCell(code_village).getStringCellValue();
			String nom_mfr38 = row.getCell(nom_mfr).getStringCellValue();
			int annee_miseplace38 = (int) row.getCell(annee_miseplace).getNumericCellValue();
			Boolean agr_developpe38 = row.getCell(agr_developpe).getStringCellValue().equalsIgnoreCase("Oui");
			java.util.Date date_eval38 = row.getCell(date_eval).getDateCellValue();
			String type_agr_dev138 = row.getCell(type_agr_dev1).getStringCellValue();
			java.util.Date date_suivi138 = row.getCell(date_suivi1).getDateCellValue();
			wp3AgrDevMfrService.addWp3AgrDevMfr(code_village38, nom_mfr38, annee_miseplace38, agr_developpe38,
					date_eval38, type_agr_dev138, date_suivi138);
			;
		}
		redirAttrs.addFlashAttribute("success", "Données importer avec succès");
		return "redirect:/listWp3AgrDevMfr";
	}

	@RequestMapping("/editWp3AgrDevMfr/{id}")
	public ModelAndView editWp3AgrDevMfr(@PathVariable(name = "id") Long id, Model model) throws ParseException {
		ModelAndView mav = new ModelAndView("wp3/Wp3AgrDevMfr/Form_modifWp3AgrDevMfr");
		Optional<Wp3AgrDevMfr> bf = wp3AgrDevMfrService.finbByIdAgrDevMfr(id);
		mav.addObject("agrDevMfr", bf);
		return mav;
	}

	@RequestMapping(value = "/saveEditWp3AgrDevMfr", method = RequestMethod.POST)
	public String saveEditWp3AgrDevMfr(@RequestParam("code_village") String code_village,
			@RequestParam("nom_mfr") String nom_mfr, @RequestParam("sexe") String sexe,
			@RequestParam("annee_miseplace") int annee_miseplace, @RequestParam("agr_developpe") Boolean agr_developpe,
			@RequestParam("date_eval") java.sql.Date date_eval, @RequestParam("type_agr_dev1") String type_agr_dev1,
			@RequestParam("date_suivi1") java.sql.Date date_suivi1, long id, RedirectAttributes redirectAttributes)
			throws ParseException {
		wp3AgrDevMfrService.modifyWp3AgrDevMfr(code_village, nom_mfr, sexe, annee_miseplace, agr_developpe, date_eval,
				type_agr_dev1, date_suivi1, id);
		return "redirect:/listWp3AgrDevMfr";
	}

	@RequestMapping("/deleteWp3AgrDevMfr/{id}")
	public String deleteWp3AgrDevMfr(@PathVariable(name = "id") Long id) {
		wp3AgrDevMfrService.deleteWp3AgrDevMfr(id);
		return "redirect:/listWp3AgrDevMfr";
	}

	/* END #45-CANEVAS AGR DÉVELOPPÉ MFR SAVA */

	/* START #46-CANEVAS JEUNE AYANT TERMINÉ FORMATION PATHWAY */
	@GetMapping("/Wp3JeunePathwayForm")
	public String Wp3JeunePathwayForm(Model model) throws Exception {
		return "wp3/Wp3JeunePathway/Form_addWp3JeunePathway";
	}

	@PostMapping("/createWp3JeunePathway")
	public String createWp3JeunePathway(@RequestParam("code_village") String code_village,
			@RequestParam("nom_prenom") String nom_prenom, @RequestParam("sexe") String sexe,
			@RequestParam("annee_naissance") int annee_naissance, @RequestParam("existance_agr") boolean existance_agr,
			@RequestParam("date_fin_frm") java.sql.Date date_fin_frm, RedirectAttributes redirectAttributes)
			throws Exception {
		Wp3JeunePathway wp3JeunePathway = new Wp3JeunePathway();
		String activite = "CANEVAS JEUNE AYANT TERMINÉ FORMATION PATHWAY";
		wp3JeunePathway.setCode_village(code_village);
		wp3JeunePathway.setNom_prenom(nom_prenom);
		wp3JeunePathway.setSexe(sexe);
		wp3JeunePathway.setAnnee_naissance(annee_naissance);
		wp3JeunePathway.setExistance_agr(existance_agr);
		wp3JeunePathway.setDate_fin_frm(date_fin_frm);
		wp3JeunePathway.setActivite(activite);
		wp3JeunePathwayService.createWp3JeunePathway(wp3JeunePathway);

		return "redirect:/listWp3JeunePathway";

	}

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
			Model model, RedirectAttributes redirAttrs) throws IOException, ParseException {

		XSSFSheet worksheet = workbook.getSheetAt(0);
		for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
			XSSFRow row = worksheet.getRow(i);

			String code_village45 = row.getCell(code_village).getStringCellValue();
			String nom_prenom45 = row.getCell(nom_prenom).getStringCellValue();
			String sexe45 = row.getCell(sexe).getStringCellValue();
			int annee_naissance45 = (int) row.getCell(annee_naissance).getNumericCellValue();
			java.util.Date date_fin_frm45 = row.getCell(date_fin_frm).getDateCellValue();

			String activite = "CANEVAS JEUNE AYANT TERMINÉ FORMATION PATHWAY";

			wp3JeunePathwayService.addWp3JeunePathway(code_village45, nom_prenom45, sexe45, annee_naissance45,
					date_fin_frm45, activite);

		}
		redirAttrs.addFlashAttribute("success", "Données importer avec succès");
		return "redirect:/listWp3JeunePathway";
	}

	@RequestMapping("/editWp3JeunePathway/{id}")
	public ModelAndView editWp3JeunePathway(@PathVariable(name = "id") Long id, Model model) throws ParseException {
		ModelAndView mav = new ModelAndView("wp3/Wp3JeunePathway/Form_modifWp3JeunePathway");
		Optional<Wp3JeunePathway> bf = wp3JeunePathwayService.findByIdJeunePathway(id);
		mav.addObject("jeunePathway", bf);
		return mav;
	}

	@RequestMapping(value = "/saveEditWp3JeunePathway", method = RequestMethod.POST)
	public String saveEditWp3JeunePathway(@RequestParam("code_village") String code_village,
			@RequestParam("nom_prenom") String nom_prenom, @RequestParam("sexe") String sexe,
			@RequestParam("annee_naissance") int annee_naissance, @RequestParam("existance_agr") boolean existance_agr,
			@RequestParam("date_fin_frm") java.sql.Date date_fin_frm, long id, RedirectAttributes redirectAttributes)
			throws ParseException {
		wp3JeunePathwayService.modifyWp3JeunePathway(code_village, nom_prenom, sexe, annee_naissance, existance_agr,
				date_fin_frm, id);
		return "redirect:/listWp3JeunePathway";
	}

	@RequestMapping("/deleteWp3JeunePathway/{id}")
	public String deleteWp3JeunePathway(@PathVariable(name = "id") Long id) {
		wp3JeunePathwayService.deleteWp3JeunePathway(id);
		return "redirect:/listWp3JeunePathway";
	}

	/* END #46-CANEVAS JEUNE AYANT TERMINÉ FORMATION PATHWAY */

	/* START #47-CANEVAS EPP FRAM DRAFT */
	@GetMapping("/Wp3EppFramForm")
	public String Wp3EppFramForm(Model model) throws Exception {
		return "wp3/Wp3EppFram/Form_addWp3EppFram";
	}

	@PostMapping("/createWp3EppFram")
	public String createWp3EppFram(@RequestParam("code_village") String code_village,
			@RequestParam("nom_ecole") String nom_ecole, @RequestParam("sexe") String sexe,
			@RequestParam("projet_fram") boolean projet_fram, @RequestParam("projet_valide") boolean projet_valide,
			@RequestParam("type_projet") String type_projet,
			@RequestParam("date_validation") java.sql.Date date_validation, RedirectAttributes redirectAttributes)
			throws Exception {
		Wp3EppFram wp3EppFram = new Wp3EppFram();
		wp3EppFram.setCode_village(code_village);
		wp3EppFram.setNom_ecole(nom_ecole);
		wp3EppFram.setSexe(sexe);
		wp3EppFram.setProjet_fram(projet_fram);
		wp3EppFram.setProjet_valide(projet_valide);
		wp3EppFram.setType_projet(type_projet);
		wp3EppFram.setDate_validation(date_validation);
		wp3EppFramService.createWp3EppFram(wp3EppFram);

		return "redirect:/listWp3EppFram";

	}

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
			@RequestParam("date_validation") int date_validation, Model model, RedirectAttributes redirAttrs) throws IOException, ParseException {

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
		redirAttrs.addFlashAttribute("success", "Données importer avec succès");
		return "redirect:/listWp3EppFram";
	}

	@RequestMapping("/editWp3EppFram/{id}")
	public ModelAndView editWp3EppFram(@PathVariable(name = "id") Long id, Model model) throws ParseException {
		ModelAndView mav = new ModelAndView("wp3/Wp3EppFram/Form_modifWp3EppFram");
		Optional<Wp3EppFram> bf = wp3EppFramService.findByIdEppFram(id);
		mav.addObject("eppFram", bf);
		return mav;
	}

	@RequestMapping(value = "/saveEditWp3EppFram", method = RequestMethod.POST)
	public String saveEditWp3EppFram(@RequestParam("code_village") String code_village,
			@RequestParam("nom_ecole") String nom_ecole, @RequestParam("sexe") String sexe,
			@RequestParam("projet_fram") Boolean projet_fram, @RequestParam("projet_valide") Boolean projet_valide,
			@RequestParam("type_projet") String type_projet,
			@RequestParam("date_validation") java.sql.Date date_validation, long id,
			RedirectAttributes redirectAttributes) throws ParseException {
		wp3EppFramService.modifyWp3EppFram(code_village, nom_ecole, sexe, projet_fram, projet_valide, type_projet,
				date_validation, id);
		return "redirect:/listWp3EppFram";
	}

	@RequestMapping("/deleteWp3EppFram/{id}")
	public String deleteWp3EppFram(@PathVariable(name = "id") Long id) {
		wp3EppFramService.deleteWp3EppFram(id);
		return "redirect:/listWp3EppFram";
	}

	/* END #47-CANEVAS EPP FRAM DRAFT */

	/* START #48-CANEVAS SERVICE SANTÉ PAR COMMUNAUTÉ */

	@GetMapping("/Wp3SanteeCommForm")
	public String Wp3SanteeCommForm(Model model) throws Exception {
		return "wp3/Wp3SanteeComm/Form_addWp3SanteeComm";
	}

	@PostMapping("/createWp3SanteeComm")
	public String createWp3SanteeComm(@RequestParam("code_village") String code_village,@RequestParam("sexe") String sexe,
			@RequestParam("csb") String csb, @RequestParam("gps_x") int gps_x, @RequestParam("gps_y") int gps_y,
			@RequestParam("repro_sexuelle") String repro_sexuelle, @RequestParam("date_suivi") java.sql.Date date_suivi,
			RedirectAttributes redirectAttributes) throws Exception {
		Wp3SanteeComm wp3SanteeComm = new Wp3SanteeComm();
		wp3SanteeComm.setCode_village(code_village);
		wp3SanteeComm.setCsb(csb);
		wp3SanteeComm.setGps_x(gps_x);
		wp3SanteeComm.setGps_y(gps_y);
		wp3SanteeComm.setRepro_sexuelle(repro_sexuelle);
		wp3SanteeComm.setSexe(sexe);
		wp3SanteeComm.setDate_suivi(date_suivi);
		wp3SanteeCommService.createWp3SanteeComm(wp3SanteeComm);

		return "redirect:/listWp3SanteeComm";

	}

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
			@RequestParam("repro_sexuelle") int repro_sexuelle, @RequestParam("date_suivi") int date_suivi, Model model, 
			RedirectAttributes redirAttrs) throws IOException, ParseException {

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
		redirAttrs.addFlashAttribute("success", "Données importer avec succès");
		return "redirect:/listWp3SanteeComm";
	}

	@RequestMapping("/editWp3SanteeComm/{id}")
	public ModelAndView editWp3SanteeComm(@PathVariable(name = "id") Long id, Model model) throws ParseException {
		ModelAndView mav = new ModelAndView("wp3/Wp3SanteeComm/Form_modifWp3SanteeComm");
		Optional<Wp3SanteeComm> bf = wp3SanteeCommService.findByIdSanteeComm(id);
		mav.addObject("santeeComm", bf);
		return mav;
	}

	@RequestMapping(value = "/saveEditWp3SanteeComm", method = RequestMethod.POST)
	public String saveEditWp3SanteeComm(@RequestParam("code_village") String code_village,@RequestParam("sexe") String sexe,
			@RequestParam("csb") String csb, @RequestParam("gps_x") float gps_x, @RequestParam("gps_y") float gps_y,
			@RequestParam("repro_sexuelle") String repro_sexuelle, @RequestParam("date_suivi") java.sql.Date date_suivi,
			long id, RedirectAttributes redirectAttributes) throws ParseException {
		wp3SanteeCommService.modifyWp3SanteeComm(code_village, csb, gps_x, gps_y, repro_sexuelle,sexe, date_suivi, id);
		return "redirect:/listWp3SanteeComm";
	}

	@RequestMapping("/deleteWp3SanteeComm/{id}")
	public String deleteWp3SanteeComm(@PathVariable(name = "id") Long id) {
		wp3SanteeCommService.deleteWp3SanteeComm(id);
		return "redirect:/listWp3SanteeComm";
	}

	/* END #48-CANEVAS SERVICE SANTÉ PAR COMMUNAUTÉ */

	/* START #49-CANEVAS PEER EDUCATOR */

	@GetMapping("/Wp3PeerEducatorForm")
	public String Wp3PeerEducatorForm(Model model) throws Exception {
		return "wp3/Wp3PeerEducator/Form_addWp3PeerEducator";
	}

	@PostMapping("/createWp3PeerEducator")
	public String createWp3PeerEducator(@RequestParam("code_village") String code_village,
			@RequestParam("nom_prenom") String nom_prenom, @RequestParam("sexe") String sexe,
			@RequestParam("annee_naissance") int annee_naissance,
			@RequestParam("operationnelle") Boolean operationnelle,
			@RequestParam("date_suivi") java.sql.Date date_suivi, RedirectAttributes redirectAttributes)
			throws Exception {
		Wp3PeerEducator wp3PeerEducator = new Wp3PeerEducator();
		String activite = "CANEVAS PEER EDUCATOR";
		wp3PeerEducator.setCode_village(code_village);
		wp3PeerEducator.setNom_prenom(nom_prenom);
		wp3PeerEducator.setSexe(sexe);
		wp3PeerEducator.setAnnee_naissance(annee_naissance);
		wp3PeerEducator.setOperationnelle(operationnelle);
		wp3PeerEducator.setDate_suivi(date_suivi);
		wp3PeerEducator.setActivite(activite);
		wp3PeerEducatorService.createWp3PeerEducator(wp3PeerEducator);

		return "redirect:/listWp3PeerEducator";

	}

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
			@RequestParam("date_suivi") int date_suivi, Model model, RedirectAttributes redirAttrs) throws IOException, ParseException {

		XSSFSheet worksheet = workbook.getSheetAt(0);
		for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
			XSSFRow row = worksheet.getRow(i);

			String code_village47 = row.getCell(code_village).getStringCellValue();
			String nom_prenom47 = row.getCell(nom_prenom).getStringCellValue();
			String sexe47 = row.getCell(sexe).getStringCellValue();
			int annee_naissance47 = (int) row.getCell(annee_naissance).getNumericCellValue();
			boolean operationnelle47 = row.getCell(operationnelle).getStringCellValue().equalsIgnoreCase("Oui");
			java.util.Date date_suivi47 = row.getCell(date_suivi).getDateCellValue();

			String activite = "CANEVAS PEER EDUCATOR";

			wp3PeerEducatorService.addWp3PeerEducator(code_village47, nom_prenom47, sexe47, annee_naissance47,
					operationnelle47, date_suivi47, activite);
		}
		redirAttrs.addFlashAttribute("success", "Données importer avec succès");
		return "redirect:/listWp3PeerEducator";
	}

	@RequestMapping("/editWp3PeerEducator/{id}")
	public ModelAndView editWp3PeerEducator(@PathVariable(name = "id") Long id, Model model) throws ParseException {
		ModelAndView mav = new ModelAndView("wp3/Wp3PeerEducator/Form_modifWp3PeerEducator");
		Optional<Wp3PeerEducator> bf = wp3PeerEducatorService.findByIdPeerEducator(id);
		mav.addObject("peerEducator", bf);
		return mav;
	}

	@RequestMapping(value = "/saveEditWp3PeerEducator", method = RequestMethod.POST)
	public String saveEditWp3PeerEducator(@RequestParam("code_village") String code_village,
			@RequestParam("nom_prenom") String nom_prenom, @RequestParam("sexe") String sexe,
			@RequestParam("annee_naissance") int annee_naissance,
			@RequestParam("operationnelle") Boolean operationnelle,
			@RequestParam("date_suivi") java.sql.Date date_suivi, long id, RedirectAttributes redirectAttributes)
			throws ParseException {

		wp3PeerEducatorService.modifyWp3PeerEducator(code_village, nom_prenom, sexe, annee_naissance, operationnelle,
				date_suivi, id);
		return "redirect:/listWp3PeerEducator";
	}

	@RequestMapping("/deleteWp3PeerEducator/{id}")
	public String deleteWp3PeerEducator(@PathVariable(name = "id") Long id) {
		wp3PeerEducatorService.deleteWp3PeerEducator(id);
		return "redirect:/listWp3PeerEducator";
	}

	/* END #49-CANEVAS PEER EDUCATOR */

}
