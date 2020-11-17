package com.Giz.controller;


import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

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
import com.Giz.service.metier.BeneficiaireService;







@Controller
public class UploadController {
	
	@Autowired
	BeneficiaireService beneficiaireService;

	XSSFWorkbook workbook;
	
	@RequestMapping("/uploadFile")
	public String uploadFile(Model model) {
		String[][] scList = ListeWp.wp();
		System.out.println(scList);
		model.addAttribute("scList", scList);
		return "uploadFile";
	}

	@PostMapping("/import")
	public String mapReapExcelDatatoDB(@RequestParam("file") MultipartFile reapExcelDataFile, Model model ) throws IOException, ParseException {
				
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
	    /*for(int i=1;i<worksheet.getPhysicalNumberOfRows() ;i++) {
	        XSSFRow row = worksheet.getRow(i);
	        String nom_bf = row.getCell(0).getStringCellValue();
	        String prenom_bf = row.getCell(1).getStringCellValue();
	        String adresse_bf = row.getCell(2).getStringCellValue();
	        SimpleDateFormat  formater = new SimpleDateFormat("yyyy-MM-dd");
	        String date_naiss_bf =formater.format(row.getCell(3).getDateCellValue());
	        String contact_bf = row.getCell(4).getStringCellValue();
	       // beneficiaireService.addBeneficiaire(nom_bf, prenom_bf, adresse_bf, null, contact_bf, date_naiss_bf);
	    }*/
	   model.addAttribute("headerLists", msForm);
        return "mise_form";
	}
	
	@PostMapping("/importM")
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
	
}
