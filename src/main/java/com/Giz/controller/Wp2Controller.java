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
import com.Giz.data.domain.Valider;
import com.Giz.service.metier.ValiderService;

@Controller
public class Wp2Controller {
	XSSFWorkbook workbook;

	@Autowired
	ValiderService validerservice;

	// Canevas lakile telo
	@RequestMapping("/uploadL3")
	public String uploadL3(Model model) {
		String[][] scList = ListeWp.wp();
		model.addAttribute("scList", scList);
		return "wp2/lakileTelo/uploadLakileTelo";
	}

	@PostMapping("/importL3")
	public String importL3(@RequestParam("file") MultipartFile reapExcelDataFile, Model model)
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
		return "wp2/lakileTelo/mise_formLakileTelo";
	}

	@PostMapping("/saveL3")
	public String saveLakileTelo(@RequestParam("code_village") int code_village, @RequestParam("district") int district,
			@RequestParam("Nom_du_groupe_lakile_telo") int nom_group_l_telo, @RequestParam("categorie") int categorie,
			@RequestParam("date_creation") int date_creation, @RequestParam("effectif_membre") int effectif_membre,
			@RequestParam("H") int sexeH, @RequestParam("F") int sexeF, @RequestParam("operationnel") int operationnel,
			@RequestParam("date_suivi") int date_suivi, Model model) throws IOException, ParseException {
		XSSFSheet worksheet = workbook.getSheetAt(0);
		for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
			XSSFRow row = worksheet.getRow(i);
			String code_villag = row.getCell(code_village).getStringCellValue();
			String districte = row.getCell(district).getStringCellValue();
			String nom_groupe_l_telo = row.getCell(nom_group_l_telo).getStringCellValue();
			String categories = row.getCell(categorie).getStringCellValue();
			java.util.Date date_creations = row.getCell(date_creation).getDateCellValue();
			String effectif_membres = row.getCell(effectif_membre).getStringCellValue();
			String sexe = "";
			if (row.getCell(sexeH).getStringCellValue().equalsIgnoreCase("1")) {
				sexe = "Homme";
			} else if (row.getCell(sexeF).getStringCellValue().equalsIgnoreCase("1")) {
				sexe = "Femme";
			} else {
				sexe = "";
			}
			boolean operationnels = row.getCell(operationnel).getStringCellValue().equalsIgnoreCase("Oui");
			java.util.Date date_suivis = row.getCell(date_suivi).getDateCellValue();
			validerservice.addValiderL3(code_villag, districte, nom_groupe_l_telo, categories, date_creations,
					effectif_membres, sexe, operationnels, date_suivis);

		}

		return "redirect:/listLakileTelo";
	}

	@RequestMapping("/listLakileTelo")
	public String listLakileTelo(Model model) {
		List<Valider> validerL3 = validerservice.ListValiderL3();
		model.addAttribute("validerL3", validerL3);
		return "wp2/LakileTelo/listLakileTelo";
	}

	// Canevas VSLA Municipal
	@RequestMapping("/uploadVSLA")
	public String uploadVSLA(Model model) {
		String[][] scList = ListeWp.wp();
		model.addAttribute("scList", scList);
		return "wp2/VSLA/uploadVSLA";
	}

	@PostMapping("/importVSLA")
	public String importVSLA(@RequestParam("file") MultipartFile reapExcelDataFile, Model model)
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
		return "wp2/VSLA/mise_formVSLA";
	}

	@PostMapping("/saveVSLA")
	public String saveVSLA(@RequestParam("code_village") int code_de_village, 
			@RequestParam("nom_vsla") int noms_vsla,
			@RequestParam("annee_creation") int annee_de_creation, 
			@RequestParam("vsla_lie") int vsla_lie,
			@RequestParam("appui_recus") int appui_recus, 
			@RequestParam("type_appui") int type_appuis,
			@RequestParam("operationnel") int operationnel, 
			@RequestParam("date_suivi") int date_suivi, Model model)
			throws IOException, ParseException {
		XSSFSheet worksheet = workbook.getSheetAt(0);
		for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
			XSSFRow row = worksheet.getRow(i);
			String code_villag = row.getCell(code_de_village).getStringCellValue();
			String nom_vsla = row.getCell(noms_vsla).getStringCellValue();
			int annee_creation = (int) row.getCell(annee_de_creation).getNumericCellValue();
			boolean vsla_lier_regionale = row.getCell(vsla_lie).getStringCellValue().equalsIgnoreCase("Oui");
			boolean appuis_recus = row.getCell(appui_recus).getStringCellValue().equalsIgnoreCase("Oui");
			String type_appui = row.getCell(type_appuis).getStringCellValue();
			boolean operationnels = row.getCell(operationnel).getStringCellValue().equalsIgnoreCase("Oui");
			java.util.Date date_suivis = row.getCell(date_suivi).getDateCellValue();
			validerservice.addValiderVSLA(code_villag, nom_vsla, annee_creation, vsla_lier_regionale, appuis_recus,
					type_appui, operationnels, date_suivis);

		}

		return "redirect:/listVSLA";
	}

	@RequestMapping("/listVSLA")
	public String listVSLA(Model model) {
		List<Valider> validerVSLA = validerservice.ListValiderVSLA();
		model.addAttribute("validerVSLA", validerVSLA);
		return "wp2/VSLA/listVSLA";
	}

	// Canevas integration de l'education
	@RequestMapping("/uploadFBS")
	public String uploadFBS(Model model) {
		String[][] scList = ListeWp.wp();
		model.addAttribute("scList", scList);
		return "wp2/FBS/uploadFBS";
	}

	@PostMapping("/importFBS")
	public String importFBS(@RequestParam("file") MultipartFile reapExcelDataFile, Model model)
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
		return "wp2/FBS/mise_formFBS";
	}

	@PostMapping("/saveFBS")
	public String saveVSLA(@RequestParam("code_village") int code_de_village,
			@RequestParam("formation_fbs") int formation_fbs,
			@RequestParam("integration_fbs") int integration_fbs,
			@RequestParam("date_suivi") int date_suivi, Model model) throws IOException, ParseException {
		XSSFSheet worksheet = workbook.getSheetAt(0);
		for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
			XSSFRow row = worksheet.getRow(i);
			String code_villag = row.getCell(code_de_village).getStringCellValue();
			boolean fbs_post_fbs_recus = row.getCell(formation_fbs).getStringCellValue().equalsIgnoreCase("Oui");
			boolean education_fbs_post_fbs = row.getCell(integration_fbs).getStringCellValue().equalsIgnoreCase("Oui");
			java.util.Date date_suivis = row.getCell(date_suivi).getDateCellValue();
			validerservice.addValiderFBS(code_villag, fbs_post_fbs_recus, education_fbs_post_fbs, date_suivis);

		}

		return "redirect:/listFBS";
	}

	@RequestMapping("/listFBS")
	public String listFBS(Model model) {
		List<Valider> validerFBS = validerservice.ListValiderFBS();
		model.addAttribute("validerFBS", validerFBS);
		return "wp2/FBS/listFBS";
	}

	// Canevas mobile money
	@RequestMapping("/uploadMoney")
	public String uploadMoney(Model model) {
		String[][] scList = ListeWp.wp();
		model.addAttribute("scList", scList);
		return "wp2/money/uploadMoney";
	}

	@PostMapping("/importMoney")
	public String importMoney(@RequestParam("file") MultipartFile reapExcelDataFile, Model model)
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
		return "wp2/money/mise_formMoney";
	}

	@PostMapping("/saveMoney")
	public String saveMoney(@RequestParam("code_village") int code_de_village,
			@RequestParam("code_prod") int code_produi,
			@RequestParam("nom") int nom, 
			@RequestParam("sex") int sex,
			@RequestParam("annee_nais") int annee_nais, 
			@RequestParam("service_money") int service_money,
			@RequestParam("date_suivis") int date_suivis, 
			@RequestParam("orange") int orange,
			@RequestParam("mvol") int mvol, 
			@RequestParam("airtel") int airtel, Model model)
			throws IOException, ParseException {
		XSSFSheet worksheet = workbook.getSheetAt(0);
		for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
			XSSFRow row = worksheet.getRow(i);
			String code_villag = row.getCell(code_de_village).getStringCellValue();
			String code_prod = row.getCell(code_produi).getStringCellValue();
			String nom_prenom = row.getCell(nom).getStringCellValue();
			String sexe = row.getCell(sex).getStringCellValue();
			int annee_naissance = (int) row.getCell(annee_nais).getNumericCellValue();
			boolean service_mobile_money = row.getCell(service_money).getStringCellValue().equalsIgnoreCase("Oui");
			boolean orange_money = row.getCell(orange).getStringCellValue().equalsIgnoreCase("Oui");
			boolean mvola = row.getCell(mvol).getStringCellValue().equalsIgnoreCase("Oui");
			boolean airtel_money = row.getCell(airtel).getStringCellValue().equalsIgnoreCase("Oui");
			java.util.Date date_suivi = row.getCell(date_suivis).getDateCellValue();
			validerservice.addValiderMobileMoney(code_villag, code_prod, nom_prenom, sexe, annee_naissance,
					service_mobile_money, date_suivi, orange_money, mvola, airtel_money);

		}

		return "redirect:/listMoney";
	}

	@RequestMapping("/listMoney")
	public String listMoney(Model model) {
		List<Valider> validerMoney = validerservice.ListValiderMobileMoney();
		model.addAttribute("validerMoney", validerMoney);
		return "wp2/money/listMoney";
	}

	// Canevas Finance
	@RequestMapping("/uploadFinance")
	public String uploadFinance(Model model) {
		String[][] scList = ListeWp.wp();
		model.addAttribute("scList", scList);
		return "wp2/finance/uploadFinance";
	}

	@PostMapping("/importFinance")
	public String importFinance(@RequestParam("file") MultipartFile reapExcelDataFile, Model model)
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
		return "wp2/finance/mise_formFinance";
	}

	@PostMapping("/saveFinance")
	public String saveFinance(@RequestParam("code_village") int code_de_village,
			@RequestParam("code_prod") int code_produi, 
			@RequestParam("nom") int nom,
			@RequestParam("sex") int sex,
			@RequestParam("annee_nais") int annee_nais, 
			@RequestParam("imf") int imf,
			@RequestParam("date_suivis") int date_suivis, 
			@RequestParam("list_instut") int list_instut,
			@RequestParam("lieu_ag") int lieu_ag, Model model) throws IOException, ParseException {
		XSSFSheet worksheet = workbook.getSheetAt(0);
		for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
			XSSFRow row = worksheet.getRow(i);
			String code_villag = row.getCell(code_de_village).getStringCellValue();
			String code_prod = row.getCell(code_produi).getStringCellValue();
			String nom_prenom = row.getCell(nom).getStringCellValue();
			String sexe = row.getCell(sex).getStringCellValue();
			int annee_naissance = (int) row.getCell(annee_nais).getNumericCellValue();
			boolean service_IMF = row.getCell(imf).getStringCellValue().equalsIgnoreCase("Oui");
			String institution = row.getCell(list_instut).getStringCellValue();
			String lieu_agence = row.getCell(lieu_ag).getStringCellValue();
			java.util.Date date_suivi = row.getCell(date_suivis).getDateCellValue();
			validerservice.addValiderFinance(code_villag, code_prod, nom_prenom, sexe, annee_naissance, service_IMF,
					date_suivi, institution, lieu_agence);

		}

		return "redirect:/listFinance";
	}

	@RequestMapping("/listFinance")
	public String listFinance(Model model) {
		List<Valider> validerFinance = validerservice.ListValiderFinance();
		model.addAttribute("validerFinance", validerFinance);
		return "wp2/finance/listFinance";
	}

	// Canevas Production
	@RequestMapping("/uploadProducteur")
	public String uploadProduction(Model model) {
		String[][] scList = ListeWp.wp();
		model.addAttribute("scList", scList);
		return "wp2/producteur/uploadProducteur";
	}

	@PostMapping("/importProducteur")
	public String importProducteur(@RequestParam("file") MultipartFile reapExcelDataFile, Model model)
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
		return "wp2/producteur/mise_formProducteur";
	}

	@PostMapping("/saveProducteur")
	public String saveProducteur(@RequestParam("num_adhesion") int numero_adhesion,
			@RequestParam("nom_beneficiaire") int nom_benef, @RequestParam("nom") int nom, @RequestParam("sex") int sex,
			@RequestParam("contact") int contacte, @RequestParam("age") int ages,
			@RequestParam("date_naiss") int date_naissance, @RequestParam("cin") int cine, @RequestParam("code_villag") int code_villag,
			@RequestParam("commune") int communes,
			@RequestParam("adresse_fkt") int adresse_fktny,
			@RequestParam("code_pro_symrise") int code_pro_symris,
			@RequestParam("affiliation") int affiliations,
			@RequestParam("ma_1ere_adhesion") int ma_adhesion, @RequestParam("nbr_pers_charge") int nbr_pers_charges,
			Model model) throws IOException, ParseException {
		XSSFSheet worksheet = workbook.getSheetAt(0);
		for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
			XSSFRow row = worksheet.getRow(i);
			String num_adhesion = row.getCell(numero_adhesion).getStringCellValue();
			String nom_beneficiaire = row.getCell(nom_benef).getStringCellValue();
			String nom_usuel_adherent = row.getCell(nom).getStringCellValue();
			String contact = row.getCell(contacte).getStringCellValue();
			int age = (int) row.getCell(ages).getNumericCellValue();
			String cin = row.getCell(cine).getStringCellValue();
			String sexe = row.getCell(sex).getStringCellValue();
			String code_village = row.getCell(code_villag).getStringCellValue();
			String code_pro_symrise= row.getCell(code_pro_symris).getStringCellValue();
			String commune= row.getCell(communes).getStringCellValue();
			String adresse_fkt= row.getCell(adresse_fktny).getStringCellValue();
			String affiliation= row.getCell(affiliations).getStringCellValue();
			String ma_1ere_adhesion= row.getCell(ma_adhesion).getStringCellValue();
			int nbr_pers_charge= (int) row.getCell(nbr_pers_charges).getNumericCellValue();
			java.util.Date date_naiss = row.getCell(date_naissance).getDateCellValue();
			validerservice.addValiderProducteur(num_adhesion, nom_beneficiaire, nom_usuel_adherent, contact, age, date_naiss, cin, sexe, code_village, code_pro_symrise, commune, adresse_fkt, affiliation, ma_1ere_adhesion, nbr_pers_charge);

		}

		return "redirect:/listProducteur";
	}

	@RequestMapping("/listProducteur")
	public String listProducteur(Model model) {
		List<Valider> validerProducteur = validerservice.ListValiderProducteur();
		model.addAttribute("validerProducteur", validerProducteur);
		return "wp2/producteur/listProducteur";
	}
	
	
	// Canevas Adhesion
		@RequestMapping("/uploadAdhesion")
		public String uploadAdhesion(Model model) {
			String[][] scList = ListeWp.wp();
			model.addAttribute("scList", scList);
			return "wp2/adhesion/uploadAdhesion";
		}

		@PostMapping("/importAdhesion")
		public String importAdhesion(@RequestParam("file") MultipartFile reapExcelDataFile, Model model)
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
			return "wp2/adhesion/mise_formAdhesion";
		}

		@PostMapping("/saveAdhesion")
		public String saveAdhesion(@RequestParam("num_adhesion") int numero_adhesion,
				@RequestParam("nom_beneficiaire") int nom_benef, 
				@RequestParam("nom") int nom, 
				@RequestParam("sex") int sex,
				@RequestParam("contact") int contacte, @RequestParam("age") int ages,
				@RequestParam("date_naiss") int date_naissance, 
				@RequestParam("cin") int cine, 
				@RequestParam("code_villag") int code_villag,
				@RequestParam("commune") int communes,
				@RequestParam("adresse_fkt") int adresse_fktny,
				@RequestParam("code_pro_symrise") int code_pro_symris,
				@RequestParam("affiliation") int affiliations,
				@RequestParam("ma_1ere_adhesion") int ma_adhesion, 
				@RequestParam("nbr_pers_charge") int nbr_pers_charges,
				Model model) throws IOException, ParseException {
			XSSFSheet worksheet = workbook.getSheetAt(0);
			for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
				XSSFRow row = worksheet.getRow(i);
				String num_adhesion = row.getCell(numero_adhesion).getStringCellValue();
				String nom_beneficiaire = row.getCell(nom_benef).getStringCellValue();
				String nom_usuel_adherent = row.getCell(nom).getStringCellValue();
				String contact = row.getCell(contacte).getStringCellValue();
				int age = (int) row.getCell(ages).getNumericCellValue();
				String cin = row.getCell(cine).getStringCellValue();
				String sexe = row.getCell(sex).getStringCellValue();
				String code_village = row.getCell(code_villag).getStringCellValue();
				String code_pro_symrise= row.getCell(code_pro_symris).getStringCellValue();
				String commune= row.getCell(communes).getStringCellValue();
				String adresse_fkt= row.getCell(adresse_fktny).getStringCellValue();
				String affiliation= row.getCell(affiliations).getStringCellValue();
				String ma_1ere_adhesion= row.getCell(ma_adhesion).getStringCellValue();
				int nbr_pers_charge= (int) row.getCell(nbr_pers_charges).getNumericCellValue();
				java.util.Date date_naiss = row.getCell(date_naissance).getDateCellValue();
				validerservice.addValiderAdhesion(num_adhesion, nom_beneficiaire, nom_usuel_adherent, contact, age, date_naiss, cin, sexe, code_village, code_pro_symrise, commune, adresse_fkt, affiliation, ma_1ere_adhesion, nbr_pers_charge);

			}

			return "redirect:/listAdhesion";
		}

		@RequestMapping("/listAdhesion")
		public String listAdhesion(Model model) {
			List<Valider> validerAdhesion = validerservice.ListValiderAdhesion();
			model.addAttribute("validerAdhesion", validerAdhesion);
			return "wp2/adhesion/listAdhesion";
		}
		
		
		// Canevas Menage
				@RequestMapping("/uploadMenage")
				public String uploadMenage(Model model) {
					String[][] scList = ListeWp.wp();
					model.addAttribute("scList", scList);
					return "wp2/menage/uploadMenage";
				}

				@PostMapping("/importMenage")
				public String importMenage(@RequestParam("file") MultipartFile reapExcelDataFile, Model model)
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
					return "wp2/menage/mise_formMenage";
				}

				@PostMapping("/saveMenage")
				public String saveMenage(@RequestParam("num_adhesion") int numero_adhesion,
						@RequestParam("nom_beneficiaire") int nom_benef, @RequestParam("nom") int nom, @RequestParam("sex") int sex,
						@RequestParam("contact") int contacte, @RequestParam("age") int ages,
						@RequestParam("date_naiss") int date_naissance, @RequestParam("cin") int cine, @RequestParam("code_villag") int code_villag,
						@RequestParam("commune") int communes,
						@RequestParam("adresse_fkt") int adresse_fktny,
						@RequestParam("code_pro_symrise") int code_pro_symris,
						@RequestParam("affiliation") int affiliations,
						@RequestParam("ma_1ere_adhesion") int ma_adhesion, @RequestParam("nbr_pers_charge") int nbr_pers_charges,
						Model model) throws IOException, ParseException {
					XSSFSheet worksheet = workbook.getSheetAt(0);
					for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
						XSSFRow row = worksheet.getRow(i);
						String num_adhesion = row.getCell(numero_adhesion).getStringCellValue();
						String nom_beneficiaire = row.getCell(nom_benef).getStringCellValue();
						String nom_usuel_adherent = row.getCell(nom).getStringCellValue();
						String contact = row.getCell(contacte).getStringCellValue();
						int age = (int) row.getCell(ages).getNumericCellValue();
						String cin = row.getCell(cine).getStringCellValue();
						String sexe = row.getCell(sex).getStringCellValue();
						String code_village = row.getCell(code_villag).getStringCellValue();
						String code_pro_symrise= row.getCell(code_pro_symris).getStringCellValue();
						String commune= row.getCell(communes).getStringCellValue();
						String adresse_fkt= row.getCell(adresse_fktny).getStringCellValue();
						String affiliation= row.getCell(affiliations).getStringCellValue();
						String ma_1ere_adhesion= row.getCell(ma_adhesion).getStringCellValue();
						int nbr_pers_charge= (int) row.getCell(nbr_pers_charges).getNumericCellValue();
						java.util.Date date_naiss = row.getCell(date_naissance).getDateCellValue();
						validerservice.addValiderMenage(num_adhesion, nom_beneficiaire, nom_usuel_adherent, contact, age, date_naiss, cin, sexe, code_village, code_pro_symrise, commune, adresse_fkt, affiliation, ma_1ere_adhesion, nbr_pers_charge);

					}

					return "redirect:/listMenage";
				}

				@RequestMapping("/listMenage")
				public String listMenage(Model model) {
					List<Valider> validerMenage = validerservice.ListValiderMenage();
					model.addAttribute("validerMenage", validerMenage);
					return "wp2/menage/listMenage";
				}

}
