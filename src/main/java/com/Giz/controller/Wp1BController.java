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
import com.Giz.data.domain.CiForme;
import com.Giz.data.domain.Concours;
import com.Giz.data.domain.Cooperative;
import com.Giz.data.domain.FocusGroup;
import com.Giz.data.domain.Leaders;
import com.Giz.data.domain.MiseForme;
import com.Giz.data.domain.ParcelleVG;
import com.Giz.data.domain.SensibEnv;
import com.Giz.data.domain.SupportVideo;
import com.Giz.data.domain.ThemeRealise;
import com.Giz.data.domain.ZoneForest;
import com.Giz.data.domain.ZoneReboise;
import com.Giz.service.metier.CiFormeService;
import com.Giz.service.metier.ConcoursService;
import com.Giz.service.metier.CooperativeService;
import com.Giz.service.metier.FocusGroupService;
import com.Giz.service.metier.LeadersService;
import com.Giz.service.metier.PvgService;
import com.Giz.service.metier.SVService;
import com.Giz.service.metier.SensiEnvService;
import com.Giz.service.metier.ThemeService;
import com.Giz.service.metier.ZoneForestService;
import com.Giz.service.metier.ZoneRebService;

@Controller
public class Wp1BController {

	XSSFWorkbook workbook;

	@Autowired
	SVService svService;

	@Autowired
	LeadersService leadersService;

	@Autowired
	CooperativeService cooperativeService;

	@Autowired
	FocusGroupService focusGroupService;

	@Autowired
	ThemeService themeService;

	@Autowired
	ConcoursService concoursService;

	@Autowired
	ZoneForestService zoneForest;

	@Autowired
	ZoneRebService zoneRebService;

	@Autowired
	SensiEnvService sensiEnvService;

	@Autowired
	CiFormeService ciFormeService;

	@Autowired
	PvgService pvgService;

	/* CANEVAS DISSEMINATION DE SUPPORT VIDEO AU NIVEAU VILLAGE */

	@RequestMapping("/uploadSv")
	public String uploadSv(Model model) {
		String[][] scList = ListeWp.wp();
		model.addAttribute("scList", scList);
		return "wp1/support/uploadSv";
	}

	@PostMapping("/importSv")
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
		return "wp1/support/mise_formSv";
	}

	@PostMapping("/saveSv")
	public String saveFormateur(@RequestParam("code_village") int code_village,
			@RequestParam("nom_support") int nom_support, @RequestParam("date_dissemination") int date_dissemination,
			@RequestParam("receptionnaire") int receptionnaire, @RequestParam("genre_sv") int genre_sv,
			@RequestParam("responsable") int responsable, @RequestParam("date_suivi") int date_suivi, 
			Model model, RedirectAttributes redirAttrs) throws IOException, ParseException {
		XSSFSheet worksheet = workbook.getSheetAt(0);
		for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
			XSSFRow row = worksheet.getRow(i);
			String nom_supports = row.getCell(nom_support).getStringCellValue();
			String code_villag = row.getCell(code_village).getStringCellValue();
			String receptionnaires = row.getCell(receptionnaire).getStringCellValue();
			String genre_svs = row.getCell(genre_sv).getStringCellValue();
			java.util.Date date_disseminations = row.getCell(date_dissemination).getDateCellValue();
			String responsables = row.getCell(responsable).getStringCellValue();
			java.util.Date date_suivis = row.getCell(date_suivi).getDateCellValue();
			svService.addSupportVideo(code_villag, nom_supports, date_disseminations, receptionnaires, genre_svs,
					responsables, date_suivis);

		}
		redirAttrs.addFlashAttribute("success", "Données importer avec succès");
		return "redirect:/listSv";
	}

	@GetMapping("/SvForm")
	public String SvForm(Model model) throws Exception {
		return "wp1/support/addSv";
	}

	@PostMapping("/createSv")
	public String createSv(@RequestParam("code_village") String code_village,
			@RequestParam("nom_support") String nom_support,
			@RequestParam("date_dissemination") java.sql.Date date_dissemination,
			@RequestParam("receptionnaire") String receptionnaire, @RequestParam("genre_sv") String genre_sv,
			@RequestParam("responsable") String responsable, @RequestParam("date_suivi") java.sql.Date date_suivi,
			RedirectAttributes redirectAttributes) throws ParseException {
		svService.addSupportVideo(code_village, nom_support, date_dissemination, receptionnaire, genre_sv, responsable,
				date_suivi);
		return "redirect:/listSv";

	}

	@RequestMapping("/listSv")
	public String listFormateur(Model model) {
		List<SupportVideo> sv = svService.ListSV();
		model.addAttribute("sv", sv);
		return "wp1/support/listSv";
	}

	/* CANEVAS FEMMES LEADERS APPUYEES */

	@RequestMapping("/uploadLeaders")
	public String uploadLeaders(Model model) {
		String[][] scList = ListeWp.wp();
		model.addAttribute("scList", scList);
		return "wp1/leaders/uploadLeaders";
	}

	@PostMapping("/importLeaders")
	public String importLeaders(@RequestParam("file") MultipartFile reapExcelDataFile, Model model)
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
		return "wp1/leaders/mise_formLeaders";
	}

	@PostMapping("/saveLeaders")
	public String saveLeaders(@RequestParam("code_village") int code_village, @RequestParam("nomPrenom") int nomPrenom,
			@RequestParam("operationnalite") int operationnalite, @RequestParam("genre_pt") int genre_pt,
			@RequestParam("annee_naiss") int annee_naiss, @RequestParam("date_mise") int date_mise,
			@RequestParam("date_suivi") int date_suivi, Model model, RedirectAttributes redirAttrs) throws IOException, ParseException {
		XSSFSheet worksheet = workbook.getSheetAt(0);
		for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
			XSSFRow row = worksheet.getRow(i);
			String nomPrenoms = row.getCell(nomPrenom).getStringCellValue();
			String code_villag = row.getCell(code_village).getStringCellValue();
			String genre_pts = row.getCell(genre_pt).getStringCellValue();
			boolean operationnel = row.getCell(operationnalite).getStringCellValue().equalsIgnoreCase("Oui");
			java.util.Date date_mises = row.getCell(date_mise).getDateCellValue();
			int annee_nais = (int) row.getCell(annee_naiss).getNumericCellValue();
			java.util.Date date_suivis = row.getCell(date_suivi).getDateCellValue();
			leadersService.addLeaders(code_villag, nomPrenoms, genre_pts, annee_nais, operationnel, date_mises,
					date_suivis);

		}
		redirAttrs.addFlashAttribute("success", "Données importer avec succès");
		return "redirect:/listLeaders";
	}

	@GetMapping("/LeadersForm")
	public String LeadersForm(Model model) throws Exception {
		return "wp1/leaders/addLeaders";
	}

	@PostMapping("/createLeaders")
	public String createLeaders(@RequestParam("code_village") String code_village,
			@RequestParam("nomPrenom") String nomPrenom, @RequestParam("operationnel") boolean operationnel,
			@RequestParam("genre_pt") String genre_pt, @RequestParam("annee_naiss") int annee_naiss,
			@RequestParam("date_mise") java.sql.Date date_mise, @RequestParam("date_suivi") java.sql.Date date_suivi,
			RedirectAttributes redirectAttributes) throws ParseException {
		leadersService.addLeaders(code_village, nomPrenom, genre_pt, annee_naiss, operationnel, date_mise, date_suivi);
		return "redirect:/listLeaders";

	}

	@RequestMapping("/listLeaders")
	public String listLeaders(Model model) {
		List<Leaders> leaders = leadersService.ListLeaders();
		model.addAttribute("leaders", leaders);
		return "wp1/leaders/listLeaders";
	}

	/* CANEVAS COOPERATIVE FAIRTRADE RENFORCEE */

	@RequestMapping("/uploadCooperative")
	public String uploadCooperative(Model model) {
		String[][] scList = ListeWp.wp();
		model.addAttribute("scList", scList);
		return "wp1/cooperative/uploadCooperative";
	}

	@PostMapping("/importCooperative")
	public String importCooperatives(@RequestParam("file") MultipartFile reapExcelDataFile, Model model)
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
		return "wp1/cooperative/mise_formCooperative";
	}

	@PostMapping("/saveCooperative")
	public String saveCooperative(@RequestParam("code_village") int code_village, @RequestParam("exist") int exist,
			@RequestParam("nom_coop") int nom_coop, @RequestParam("environnement") int environnement,
			@RequestParam("socio") int socio, @RequestParam("date_creation") int date_creation,
			@RequestParam("date_suivi") int date_suivi, Model model, RedirectAttributes redirAttrs) throws IOException, ParseException {
		XSSFSheet worksheet = workbook.getSheetAt(0);
		for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
			XSSFRow row = worksheet.getRow(i);
			String nom_coops = row.getCell(nom_coop).getStringCellValue();
			String code_villag = row.getCell(code_village).getStringCellValue();
			boolean exists = row.getCell(exist).getStringCellValue().equalsIgnoreCase("Oui");
			boolean socios = row.getCell(socio).getStringCellValue().equalsIgnoreCase("Oui");
			boolean environnements = row.getCell(environnement).getStringCellValue().equalsIgnoreCase("Oui");
			java.util.Date date_creations = row.getCell(date_creation).getDateCellValue();
			java.util.Date date_suivis = row.getCell(date_suivi).getDateCellValue();
			cooperativeService.addCooperative(code_villag, exists, nom_coops, date_creations, socios, environnements,
					date_suivis);

		}
		redirAttrs.addFlashAttribute("success", "Données importer avec succès");
		return "redirect:/listCooperative";
	}

	@GetMapping("/CooperativeForm")
	public String CooperativeForm(Model model) throws Exception {
		return "wp1/cooperative/addCooperative";
	}

	@PostMapping("/createCooperative")
	public String createCooperative(@RequestParam("code_village") String code_village,
			@RequestParam("exist") boolean exist, @RequestParam("nom_coop") String nom_coop,
			@RequestParam("environnement") boolean environnement, @RequestParam("socio") boolean socio,
			@RequestParam("date_creation") java.sql.Date date_creation,
			@RequestParam("date_suivi") java.sql.Date date_suivi, RedirectAttributes redirectAttributes)
			throws ParseException {
		cooperativeService.addCooperative(code_village, exist, nom_coop, date_creation, socio, environnement,
				date_suivi);
		return "redirect:/listCooperative";

	}

	@RequestMapping("/listCooperative")
	public String listCooperative(Model model) {
		List<Cooperative> cooperative = cooperativeService.ListCooperative();
		model.addAttribute("cooperative", cooperative);
		return "wp1/cooperative/listCooperative";
	}

	/* CANEVAS FOCUS GROUP ENVIRONNEMENTAL */

	@RequestMapping("/uploadFG")
	public String uploadFG(Model model) {
		String[][] scList = ListeWp.wp();
		model.addAttribute("scList", scList);
		return "wp1/focusGroup/uploadFG";
	}

	@PostMapping("/importFG")
	public String importFG(@RequestParam("file") MultipartFile reapExcelDataFile, Model model)
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
		return "wp1/focusGroup/mise_formFG";
	}

	@PostMapping("/saveFG")
	public String saveFG(@RequestParam("code_village") int code_village, @RequestParam("realisation") int realisation,
			@RequestParam("nomResp") int nomResp, @RequestParam("genre_fg") int genre_fg,
			@RequestParam("risque_env") int risque_env, @RequestParam("mesure_prise") int mesure_prise,
			@RequestParam("date_fg") int date_fg, Model model, RedirectAttributes redirAttrs) throws IOException, ParseException {
		XSSFSheet worksheet = workbook.getSheetAt(0);
		for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
			XSSFRow row = worksheet.getRow(i);
			String nomResps = row.getCell(nomResp).getStringCellValue();
			String code_villag = row.getCell(code_village).getStringCellValue();
			boolean realisations = row.getCell(realisation).getStringCellValue().equalsIgnoreCase("Oui");
			String risque_envs = row.getCell(risque_env).getStringCellValue();
			String mesure_prises = row.getCell(mesure_prise).getStringCellValue();
			String genre_fgs = row.getCell(genre_fg).getStringCellValue();
			java.util.Date date_fgs = row.getCell(date_fg).getDateCellValue();
			focusGroupService.addFocusGroup(code_villag, realisations, nomResps, genre_fgs, risque_envs, mesure_prises,
					date_fgs);

		}
		redirAttrs.addFlashAttribute("success", "Données importer avec succès");
		return "redirect:/listFG";
	}

	@GetMapping("/FGForm")
	public String FGForm(Model model) throws Exception {
		return "wp1/focusGroup/addFG";
	}

	@PostMapping("/createFG")
	public String createFG(@RequestParam("code_village") String code_village,
			@RequestParam("realisation") boolean realisation, @RequestParam("nomResp") String nomResp,
			@RequestParam("genre_fg") String genre_fg, @RequestParam("risque_env") String risque_env,
			@RequestParam("mesure_prise") String mesure_prise, @RequestParam("date_fg") java.sql.Date date_fg,
			RedirectAttributes redirectAttributes) throws ParseException {
		focusGroupService.addFocusGroup(code_village, realisation, nomResp, genre_fg, risque_env, mesure_prise,
				date_fg);
		return "redirect:/listFG";

	}

	@RequestMapping("/listFG")
	public String listFG(Model model) {
		List<FocusGroup> fg = focusGroupService.ListFocusGroup();
		model.addAttribute("fg", fg);
		return "wp1/focusGroup/listFocusGroup";
	}

	/*
	 * CANEVAS THEME REALISEE SUR L' ENVIRONNEMENT AU NIVEAU D' EPP ET LES YOUTH
	 * COMMITTEE
	 */

	@RequestMapping("/uploadTheme")
	public String uploadTheme(Model model) {
		String[][] scList = ListeWp.wp();
		model.addAttribute("scList", scList);
		return "wp1/theme/uploadTheme";
	}

	@PostMapping("/importTheme")
	public String importTheme(@RequestParam("file") MultipartFile reapExcelDataFile, Model model)
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
		return "wp1/theme/mise_formTheme";
	}

	@PostMapping("/saveTheme")
	public String saveTheme(@RequestParam("code_village") int code_village, @RequestParam("env") int env,
			@RequestParam("epp_youth") int epp_youth, @RequestParam("activites") int activites,
			@RequestParam("date_suivi") int date_suivi, Model model, RedirectAttributes redirAttrs) throws IOException, ParseException {
		XSSFSheet worksheet = workbook.getSheetAt(0);
		for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
			XSSFRow row = worksheet.getRow(i);
			String epp_youths = row.getCell(epp_youth).getStringCellValue();
			String code_villag = row.getCell(code_village).getStringCellValue();
			boolean envs = row.getCell(env).getStringCellValue().equalsIgnoreCase("Oui");
			String activite = row.getCell(activites).getStringCellValue();
			java.util.Date date_suivis = row.getCell(date_suivi).getDateCellValue();
			themeService.addThemeRealise(code_villag, epp_youths, envs, activite, date_suivis);

		}
		redirAttrs.addFlashAttribute("success", "Données importer avec succès");
		return "redirect:/listTheme";
	}

	@GetMapping("/ThemeForm")
	public String ThemeForm(Model model) throws Exception {
		return "wp1/theme/addTheme";
	}

	@PostMapping("/createTheme")
	public String createTheme(@RequestParam("code_village") String code_village, @RequestParam("env") boolean env,
			@RequestParam("epp_youth") String epp_youth, @RequestParam("activites") String activites,
			@RequestParam("date_suivi") java.sql.Date date_suivi, RedirectAttributes redirectAttributes)
			throws ParseException {
		themeService.addThemeRealise(code_village, epp_youth, env, activites, date_suivi);
		return "redirect:/listTheme";

	}

	@RequestMapping("/listTheme")
	public String listTheme(Model model) {
		List<ThemeRealise> theme = themeService.ListThemeRealise();
		model.addAttribute("theme", theme);
		return "wp1/theme/listTheme";
	}

	/* CANEVAS EXISTENCE DE CONCOURS ENVIRONNEMENTAL */

	@RequestMapping("/uploadConcours")
	public String uploadConcours(Model model) {
		String[][] scList = ListeWp.wp();
		model.addAttribute("scList", scList);
		return "wp1/concours/uploadConcours";
	}

	@PostMapping("/importConcours")
	public String importConcours(@RequestParam("file") MultipartFile reapExcelDataFile, Model model)
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
		return "wp1/concours/mise_formConcours";
	}

	@PostMapping("/saveConcours")
	public String saveConcours(@RequestParam("code_village") int code_village, @RequestParam("exist") int exist,
			@RequestParam("date_eval") int date_eval, @RequestParam("date_suivi") int date_suivi, Model model, RedirectAttributes redirAttrs)
			throws IOException, ParseException {
		XSSFSheet worksheet = workbook.getSheetAt(0);
		for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
			XSSFRow row = worksheet.getRow(i);
			String code_villag = row.getCell(code_village).getStringCellValue();
			boolean exists = row.getCell(exist).getStringCellValue().equalsIgnoreCase("Oui");
			java.util.Date date_evals = row.getCell(date_eval).getDateCellValue();
			java.util.Date date_suivis = row.getCell(date_suivi).getDateCellValue();
			concoursService.addConcours(code_villag, exists, date_evals, date_suivis);

		}
		redirAttrs.addFlashAttribute("success", "Données importer avec succès");
		return "redirect:/listConcours";
	}

	@GetMapping("/ConcoursForm")
	public String ConcoursForm(Model model) throws Exception {
		return "wp1/concours/addConcours";
	}

	@PostMapping("/createConcours")
	public String createConcours(@RequestParam("code_village") String code_village,
			@RequestParam("exist") boolean exist, @RequestParam("date_eval") java.sql.Date date_eval,
			@RequestParam("date_suivi") java.sql.Date date_suivi, RedirectAttributes redirectAttributes)
			throws ParseException {
		concoursService.addConcours(code_village, exist, date_eval, date_suivi);
		return "redirect:/listConcours";

	}

	@RequestMapping("/listConcours")
	public String listConcours(Model model) {
		List<Concours> concours = concoursService.ListConcours();
		model.addAttribute("concours", concours);
		return "wp1/concours/listConcours";
	}

	/* CANEVAS SUPERFICIES ZONES FORESTIERES */

	@RequestMapping("/uploadZF")
	public String uploadZF(Model model) {
		String[][] scList = ListeWp.wp();
		model.addAttribute("scList", scList);
		return "wp1/zoneForest/uploadZF";
	}

	@PostMapping("/importZF")
	public String importZF(@RequestParam("file") MultipartFile reapExcelDataFile, Model model)
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
		return "wp1/zoneForest/mise_formZF";
	}

	@PostMapping("/saveZF")
	public String saveZF(@RequestParam("code_village") int code_village, @RequestParam("exist_zn") int exist_zn,
			@RequestParam("superficies") int superficies, @RequestParam("date_suivi") int date_suivi, Model model, RedirectAttributes redirAttrs)
			throws IOException, ParseException {
		XSSFSheet worksheet = workbook.getSheetAt(0);
		for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
			XSSFRow row = worksheet.getRow(i);
			String code_villag = row.getCell(code_village).getStringCellValue();
			boolean exist_zns = row.getCell(exist_zn).getStringCellValue().equalsIgnoreCase("Oui");
			float superficie = (float) row.getCell(superficies).getNumericCellValue();
			java.util.Date date_suivis = row.getCell(date_suivi).getDateCellValue();
			zoneForest.addZoneForest(code_villag, exist_zns, superficie, date_suivis);

		}
		redirAttrs.addFlashAttribute("success", "Données importer avec succès");
		return "redirect:/listZF";
	}

	@GetMapping("/ZFForm")
	public String ZFForm(Model model) throws Exception {
		return "wp1/zoneForest/addZF";
	}

	@PostMapping("/createZF")
	public String createZF(@RequestParam("code_village") String code_village,
			@RequestParam("exist_zn") boolean exist_zn, @RequestParam("superficies") float superficies,
			@RequestParam("date_suivi") java.sql.Date date_suivi, RedirectAttributes redirectAttributes)
			throws ParseException {
		zoneForest.addZoneForest(code_village, exist_zn, superficies, date_suivi);
		return "redirect:/listZF";

	}

	@RequestMapping("/listZF")
	public String listZF(Model model) {
		List<ZoneForest> zf = zoneForest.ListZoneForest();
		model.addAttribute("zf", zf);
		return "wp1/zoneForest/listZF";
	}

	/* CANEVAS SUPERFICIE ZONE REBOISEE */

	@RequestMapping("/uploadZR")
	public String uploadZR(Model model) {
		String[][] scList = ListeWp.wp();
		model.addAttribute("scList", scList);
		return "wp1/ZoneReboise/uploadZR";
	}

	@PostMapping("/importZR")
	public String importZR(@RequestParam("file") MultipartFile reapExcelDataFile, Model model)
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
		return "wp1/ZoneReboise/mise_formZR";
	}

	@PostMapping("/saveZR")
	public String saveZR(@RequestParam("code_village") int code_village, @RequestParam("exist_zr") int exist_zr,
			@RequestParam("superficies") int superficies, @RequestParam("jeunePlant") int jeunePlant,
			@RequestParam("nbrTotalJeune") int nbrTotalJeune, @RequestParam("date_suivi") int date_suivi, Model model, RedirectAttributes redirAttrs)
			throws IOException, ParseException {
		XSSFSheet worksheet = workbook.getSheetAt(0);
		for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
			XSSFRow row = worksheet.getRow(i);
			String code_villag = row.getCell(code_village).getStringCellValue();
			int jeunePlants = (int) row.getCell(jeunePlant).getNumericCellValue();
			int nbrTotalJeunes = (int) row.getCell(nbrTotalJeune).getNumericCellValue();
			boolean exist_zrs = row.getCell(exist_zr).getStringCellValue().equalsIgnoreCase("Oui");
			float superficie = (float) row.getCell(superficies).getNumericCellValue();
			java.util.Date date_suivis = row.getCell(date_suivi).getDateCellValue();
			zoneRebService.addZoneReboise(code_villag, exist_zrs, superficie, jeunePlants, nbrTotalJeunes, date_suivis);

		}
		redirAttrs.addFlashAttribute("success", "Données importer avec succès");
		return "redirect:/listZR";
	}

	@GetMapping("/ZRForm")
	public String ZRForm(Model model) throws Exception {
		return "wp1/ZoneReboise/addZR";
	}

	@PostMapping("/createZR")
	public String createZR(@RequestParam("code_village") String code_village,
			@RequestParam("exist_zr") boolean exist_zr, @RequestParam("superficies") float superficies,
			@RequestParam("jeunePlant") int jeunePlant, @RequestParam("nbrTotalJeune") int nbrTotalJeune,
			@RequestParam("date_suivi") java.sql.Date date_suivi, RedirectAttributes redirectAttributes)
			throws ParseException {
		zoneRebService.addZoneReboise(code_village, exist_zr, superficies, jeunePlant, nbrTotalJeune, date_suivi);
		return "redirect:/listZR";

	}

	@RequestMapping("/listZR")
	public String listZR(Model model) {
		List<ZoneReboise> zr = zoneRebService.ListZoneReboise();
		model.addAttribute("zr", zr);
		return "wp1/ZoneReboise/listZR";
	}

	/* CANEVAS SENSIBILISATION ENVIRONNEMENTALE */

	@RequestMapping("/uploadSE")
	public String uploadSE(Model model) {
		String[][] scList = ListeWp.wp();
		model.addAttribute("scList", scList);
		return "wp1/SensiEnv/uploadSE";
	}

	@PostMapping("/importSE")
	public String importSE(@RequestParam("file") MultipartFile reapExcelDataFile, Model model)
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
		return "wp1/SensiEnv/mise_formSE";
	}

	@PostMapping("/saveSE")
	public String saveSE(@RequestParam("code_village") int code_village, @RequestParam("exist_sens") int exist_sens,
			@RequestParam("theme_sens") int theme_sens, @RequestParam("nbr_participant") int nbr_participant,
			@RequestParam("nbr_homme") int nbr_homme, @RequestParam("nbr_femme") int nbr_femme,
			@RequestParam("date_fin") int date_fin, Model model, RedirectAttributes redirAttrs) throws IOException, ParseException {
		XSSFSheet worksheet = workbook.getSheetAt(0);
		for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
			XSSFRow row = worksheet.getRow(i);
			String code_villag = row.getCell(code_village).getStringCellValue();
			int nbr_participants = (int) row.getCell(nbr_participant).getNumericCellValue();
			int nbr_hommes = (int) row.getCell(nbr_homme).getNumericCellValue();
			int nbr_femmes = (int) row.getCell(nbr_femme).getNumericCellValue();
			boolean exist_sen = row.getCell(exist_sens).getStringCellValue().equalsIgnoreCase("Oui");
			String theme_sen = row.getCell(theme_sens).getStringCellValue();
			java.util.Date date_fins = row.getCell(date_fin).getDateCellValue();
			sensiEnvService.addSensibEnv(code_villag, exist_sen, date_fins, theme_sen, nbr_participants, nbr_hommes,
					nbr_femmes);

		}
		redirAttrs.addFlashAttribute("success", "Données importer avec succès");
		return "redirect:/listSE";
	}

	@GetMapping("/SEForm")
	public String SEForm(Model model) throws Exception {
		return "wp1/SensiEnv/addSE";
	}

	@PostMapping("/createSE")
	public String createSE(@RequestParam("code_village") String code_village,
			@RequestParam("exist_sens") boolean exist_sens, @RequestParam("theme_sens") String theme_sens,
			@RequestParam("nbr_participant") int nbr_participant, @RequestParam("nbr_homme") int nbr_homme,
			@RequestParam("nbr_femme") int nbr_femme, @RequestParam("date_fin") java.sql.Date date_fin,
			RedirectAttributes redirectAttributes) throws ParseException {
		sensiEnvService.addSensibEnv(code_village, exist_sens, date_fin, theme_sens, nbr_participant, nbr_homme,
				nbr_femme);
		return "redirect:/listSE";

	}

	@RequestMapping("/listSE")
	public String listSE(Model model) {
		List<SensibEnv> se = sensiEnvService.ListSensibEnv();
		model.addAttribute("se", se);
		return "wp1/SensiEnv/listSE";
	}

	/* CANEVAS CONTROLEUR INTERNE FORME ET EQUIPE */

	@RequestMapping("/uploadCI")
	public String uploadCI(Model model) {
		String[][] scList = ListeWp.wp();
		model.addAttribute("scList", scList);
		return "wp1/CIForme/uploadCI";
	}

	@PostMapping("/importCI")
	public String importCI(@RequestParam("file") MultipartFile reapExcelDataFile, Model model)
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
		return "wp1/CIForme/mise_formCI";
	}

	@PostMapping("/saveCI")
	public String saveCI(@RequestParam("code_village") int code_village, @RequestParam("nomPrenom_ci") int nomPrenom_ci,
			@RequestParam("genre_ci") int genre_ci, @RequestParam("type_materiel") int type_materiel,
			@RequestParam("annee_naiss") int annee_naiss, @RequestParam("date_form") int date_form,
			@RequestParam("equipe") int equipe, @RequestParam("date_dotation") int date_dotation, Model model, RedirectAttributes redirAttrs)
			throws IOException, ParseException {
		XSSFSheet worksheet = workbook.getSheetAt(0);
		for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
			XSSFRow row = worksheet.getRow(i);
			String code_villag = row.getCell(code_village).getStringCellValue();
			int annee_nais = (int) row.getCell(annee_naiss).getNumericCellValue();
			java.util.Date date_forms = row.getCell(date_form).getDateCellValue();
			boolean equipes = row.getCell(equipe).getStringCellValue().equalsIgnoreCase("Oui");
			String nomPrenom_cis = row.getCell(nomPrenom_ci).getStringCellValue();
			String genre_cis = row.getCell(genre_ci).getStringCellValue();
			String type_materiels = row.getCell(type_materiel).getStringCellValue();
			java.util.Date date_dotations = row.getCell(date_dotation).getDateCellValue();
			ciFormeService.addCiForme(code_villag, nomPrenom_cis, genre_cis, annee_nais, date_forms, equipes,
					type_materiels, date_dotations);

		}
		redirAttrs.addFlashAttribute("success", "Données importer avec succès");
		return "redirect:/listCI";
	}

	@GetMapping("/CIForm")
	public String CIForm(Model model) throws Exception {
		return "wp1/CIForme/addCI";
	}

	@PostMapping("/createCI")
	public String createCI(@RequestParam("code_village") String code_village,
			@RequestParam("nomPrenom_ci") String nomPrenom_ci, @RequestParam("genre_ci") String genre_ci,
			@RequestParam("type_materiel") String type_materiel, @RequestParam("annee_naiss") int annee_naiss,
			@RequestParam("date_form") java.sql.Date date_form, @RequestParam("equipe") boolean equipe,
			@RequestParam("date_dotation") java.sql.Date date_dotation, RedirectAttributes redirectAttributes)
			throws ParseException {
		ciFormeService.addCiForme(code_village, nomPrenom_ci, genre_ci, annee_naiss, date_form, equipe, type_materiel,
				date_dotation);
		return "redirect:/listCI";

	}

	@RequestMapping("/listCI")
	public String listCI(Model model) {
		List<CiForme> ci = ciFormeService.ListCiForme();
		model.addAttribute("ci", ci);
		return "wp1/CIForme/listCI";
	}

	/*
	 * CANEVAS PARCELLES DE VANILLES ET DE GINGEMBRES QUI ONT FAIT L'OBJET DE SUIVI
	 * NUMERIQUE
	 */

	@RequestMapping("/uploadPvg")
	public String uploadPvg(Model model) {
		String[][] scList = ListeWp.wp();
		model.addAttribute("scList", scList);
		return "wp1/pvg/uploadPvg";
	}

	@PostMapping("/importPvg")
	public String importPvg(@RequestParam("file") MultipartFile reapExcelDataFile, Model model)
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
		return "wp1/pvg/mise_formPvg";
	}

	@PostMapping("/savePvg")
	public String savePvg(@RequestParam("code_village") int code_village, @RequestParam("x") int x,
			@RequestParam("y") int y, @RequestParam("exist") int exist, @RequestParam("nomResp") int nomResp,
			@RequestParam("date_suivi") int date_suivi, @RequestParam("annee_naiss") int annee_naiss,
			@RequestParam("suivi_numeric") int suivi_numeric,
			@RequestParam("diffusion_resultat") int diffusion_resultat, @RequestParam("genre_pvg") int genre_pvg,
			Model model, RedirectAttributes redirAttrs) throws IOException, ParseException {
		XSSFSheet worksheet = workbook.getSheetAt(0);
		for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
			XSSFRow row = worksheet.getRow(i);
			String code_villag = row.getCell(code_village).getStringCellValue();
			int annee_nais = (int) row.getCell(annee_naiss).getNumericCellValue();
			boolean suivi_numerics = row.getCell(suivi_numeric).getStringCellValue().equalsIgnoreCase("Oui");
			boolean exists = row.getCell(exist).getStringCellValue().equalsIgnoreCase("Oui");
			boolean diffusion_resultats = row.getCell(diffusion_resultat).getStringCellValue().equalsIgnoreCase("Oui");
			float coord_x = (float) row.getCell(x).getNumericCellValue();
			float coord_y = (float) row.getCell(y).getNumericCellValue();
			String nomResps = row.getCell(nomResp).getStringCellValue();
			String genre_pvgs = row.getCell(genre_pvg).getStringCellValue();
			java.util.Date date_suivis = row.getCell(date_suivi).getDateCellValue();
			pvgService.addParcelleVG(code_villag, coord_x, coord_y, exists, nomResps, genre_pvgs, annee_nais,
					suivi_numerics, diffusion_resultats, date_suivis);

		}
		redirAttrs.addFlashAttribute("success", "Données importer avec succès");
		return "redirect:/listPvg";
	}

	@GetMapping("/PvgForm")
	public String PvgForm(Model model) throws Exception {
		return "wp1/pvg/addPvg";
	}

	@PostMapping("/createPvg")
	public String createPvg(@RequestParam("code_village") String code_village, @RequestParam("x") float x,
			@RequestParam("y") float y, @RequestParam("exist") boolean exist, @RequestParam("nomResp") String nomResp,
			@RequestParam("date_suivi") java.sql.Date date_suivi, @RequestParam("annee_naiss") int annee_naiss,
			@RequestParam("suivi_numeric") boolean suivi_numeric,
			@RequestParam("diffusion_resultat") boolean diffusion_resultat, @RequestParam("genre_pvg") String genre_pvg,
			RedirectAttributes redirectAttributes) throws ParseException {
		pvgService.createParcelleVG(code_village, x, y, exist, nomResp, genre_pvg, annee_naiss, suivi_numeric,
				diffusion_resultat, date_suivi);
		return "redirect:/listPvg";

	}

	@RequestMapping("/listPvg")
	public String listPvg(Model model) {
		List<ParcelleVG> pvg = pvgService.ListParcelleVG();
		model.addAttribute("pvg", pvg);
		return "wp1/pvg/listPvg";
	}

}
