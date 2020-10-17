package com.Giz.controller;


import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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

import com.Giz.data.domain.Beneficiaire;
import com.Giz.service.metier.BeneficiaireService;






@Controller
public class UploadController {
	
	@Autowired
	BeneficiaireService beneficiaireService;

	@RequestMapping("/uploadFile")
	public String uploadFile(Model model) {

		return "uploadFile";
	}

	@PostMapping("/import")
	public String mapReapExcelDatatoDB(@RequestParam("file") MultipartFile reapExcelDataFile) throws IOException, ParseException {
	    
	    List<Beneficiaire> beneficiaireList = new ArrayList<Beneficiaire>();
	    XSSFWorkbook workbook = new XSSFWorkbook(reapExcelDataFile.getInputStream());
	    XSSFSheet worksheet = workbook.getSheetAt(0);
	    
	    for(int i=1;i<worksheet.getPhysicalNumberOfRows() ;i++) {
	        XSSFRow row = worksheet.getRow(i);
	        String nom_bf = row.getCell(0).getStringCellValue();
	        String prenom_bf = row.getCell(1).getStringCellValue();
	        String adresse_bf = row.getCell(2).getStringCellValue();
	        SimpleDateFormat  formater = new SimpleDateFormat("yyyy-MM-dd");
	        String date_naiss_bf =formater.format(row.getCell(3).getDateCellValue());
	        String contact_bf = row.getCell(4).getStringCellValue();
	        beneficiaireService.addBeneficiaire(nom_bf, prenom_bf, adresse_bf, contact_bf, date_naiss_bf);
	    }
        return "redirect:/beneficiaire";
	}
	
}
