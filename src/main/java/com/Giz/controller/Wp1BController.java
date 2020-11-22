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
import com.Giz.data.domain.Cooperative;
import com.Giz.data.domain.Formateur;
import com.Giz.data.domain.Leaders;
import com.Giz.data.domain.MiseForme;
import com.Giz.data.domain.SupportVideo;
import com.Giz.service.metier.CooperativeService;
import com.Giz.service.metier.LeadersService;
import com.Giz.service.metier.SVService;






@Controller
public class Wp1BController {
	
	XSSFWorkbook workbook;
	
	@Autowired
	SVService svService;
	
	@Autowired
	LeadersService leadersService;
	
	@Autowired
	CooperativeService cooperativeService;
	
	/* CANEVAS DISSEMINATION DE SUPPORT VIDEO AU NIVEAU VILLAGE */
	
	@RequestMapping("/uploadSv")
	public String uploadSv(Model model) {
		String[][] scList = ListeWp.wp();
		model.addAttribute("scList", scList);
		return "wp1/support/uploadSv";
	}
	
	@PostMapping("/importSv")
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
        return "wp1/support/mise_formSv";
	}
	
	@PostMapping("/saveSv")
	public String saveFormateur(@RequestParam("code_village") int code_village, 
			@RequestParam("nom_support") int nom_support,
			@RequestParam("date_dissemination") int date_dissemination , @RequestParam("receptionnaire") int receptionnaire ,@RequestParam("genre_sv") int genre_sv ,
			@RequestParam("responsable") int responsable ,
			@RequestParam("date_suivi") int date_suivi , Model model ) throws IOException, ParseException {
		XSSFSheet worksheet = workbook.getSheetAt(0);	
	    for(int i=1;i<worksheet.getPhysicalNumberOfRows() ;i++) {
	        XSSFRow row = worksheet.getRow(i);
	        String nom_supports = row.getCell(nom_support).getStringCellValue();
	        String code_villag = row.getCell(code_village).getStringCellValue();
	        String receptionnaires =  row.getCell(receptionnaire).getStringCellValue();
	        String genre_svs =  row.getCell(genre_sv).getStringCellValue();
	        java.util.Date date_disseminations = row.getCell(date_dissemination).getDateCellValue();
	        String responsables = row.getCell(responsable).getStringCellValue();
	        java.util.Date date_suivis = row.getCell(date_suivi).getDateCellValue();
	        svService.addSupportVideo(code_villag, nom_supports, date_disseminations, receptionnaires, genre_svs, responsables, date_suivis);
	        
	        
	    }

	    return "redirect:/listSv";
	}
	
	@RequestMapping("/listSv")
	public String listFormateur(Model model) {
		List<SupportVideo> sv =  svService.ListSV();
		model.addAttribute("sv", sv);
		return "wp1/support/listSv";
	}
	
	/*  CANEVAS FEMMES LEADERS APPUYEES  */
	
	@RequestMapping("/uploadLeaders")
	public String uploadLeaders(Model model) {
		String[][] scList = ListeWp.wp();
		model.addAttribute("scList", scList);
		return "wp1/leaders/uploadLeaders";
	}
	
	@PostMapping("/importLeaders")
	public String importLeaders(@RequestParam("file") MultipartFile reapExcelDataFile, Model model ) throws IOException, ParseException {
				
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
        return "wp1/leaders/mise_formLeaders";
	}
	
	@PostMapping("/saveLeaders")
	public String saveLeaders(@RequestParam("code_village") int code_village, 
			@RequestParam("nomPrenom") int nomPrenom,@RequestParam("operationnalite") int operationnalite,
			@RequestParam("genre_pt") int genre_pt ,
			@RequestParam("annee_naiss") int annee_naiss ,@RequestParam("date_mise") int date_mise,
			@RequestParam("date_suivi") int date_suivi , Model model ) throws IOException, ParseException {
		XSSFSheet worksheet = workbook.getSheetAt(0);	
	    for(int i=1;i<worksheet.getPhysicalNumberOfRows() ;i++) {
	        XSSFRow row = worksheet.getRow(i);
	        String nomPrenoms = row.getCell(nomPrenom).getStringCellValue();
	        String code_villag = row.getCell(code_village).getStringCellValue();
	        String genre_pts =  row.getCell(genre_pt).getStringCellValue();
	        boolean operationnel = row.getCell(operationnalite).getStringCellValue().equalsIgnoreCase("Oui");
	        java.util.Date date_mises = row.getCell(date_mise).getDateCellValue();
	        int annee_nais = (int) row.getCell(annee_naiss).getNumericCellValue();
	        java.util.Date date_suivis = row.getCell(date_suivi).getDateCellValue();
	        leadersService.addLeaders(code_villag, nomPrenoms, genre_pts, annee_nais, operationnel, date_mises, date_suivis);
	        
	        
	    }

	    return "redirect:/listLeaders";
	}
	
	@RequestMapping("/listLeaders")
	public String listLeaders(Model model) {
		List<Leaders> leaders =  leadersService.ListLeaders();
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
	public String importCooperatives(@RequestParam("file") MultipartFile reapExcelDataFile, Model model ) throws IOException, ParseException {
				
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
        return "wp1/cooperative/mise_formCooperative";
	}
	
	@PostMapping("/saveCooperative")
	public String saveCooperative(@RequestParam("code_village") int code_village, 
			@RequestParam("exist") int exist,@RequestParam("nom_coop") int nom_coop,
			@RequestParam("environnement") int environnement ,
			@RequestParam("socio") int socio ,@RequestParam("date_creation") int date_creation,
			@RequestParam("date_suivi") int date_suivi , Model model ) throws IOException, ParseException {
		XSSFSheet worksheet = workbook.getSheetAt(0);	
	    for(int i=1;i<worksheet.getPhysicalNumberOfRows() ;i++) {
	        XSSFRow row = worksheet.getRow(i);
	        String nom_coops = row.getCell(nom_coop).getStringCellValue();
	        String code_villag = row.getCell(code_village).getStringCellValue();
	        boolean exists = row.getCell(exist).getStringCellValue().equalsIgnoreCase("Oui");
	        boolean socios = row.getCell(socio).getStringCellValue().equalsIgnoreCase("Oui");
	        boolean environnements = row.getCell(environnement).getStringCellValue().equalsIgnoreCase("Oui");
	        java.util.Date date_creations = row.getCell(date_creation).getDateCellValue();
	        java.util.Date date_suivis = row.getCell(date_suivi).getDateCellValue();
	        cooperativeService.addCooperative(code_villag, exists, nom_coops, date_creations, socios, environnements, date_suivis);
	        
	        
	    }

	    return "redirect:/listCooperative";
	}
	
	@RequestMapping("/listCooperative")
	public String listCooperative(Model model) {
		List<Cooperative> cooperative =  cooperativeService.ListCooperative();
		model.addAttribute("cooperative", cooperative);
		return "wp1/cooperative/listCooperative";
	}
	
}
