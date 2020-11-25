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
import com.Giz.data.domain.DocCap;
import com.Giz.data.domain.MiseForme;
import com.Giz.service.metier.DocCapService;

@Controller
public class Wp4Controller {
	
	@Autowired
	DocCapService docCapService;

	XSSFWorkbook workbook;
	
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
        return "wp4/DocCap/mise_formAI";
	}
	
	@PostMapping("/saveDocCap")
	public String saveDocCap(@RequestParam("thematique") int thematique,
			@RequestParam("type_doc") int type_doc, @RequestParam("auteur_doc") int auteur_doc,
			@RequestParam("date_partage") int date_partage,
			@RequestParam("reception") int reception , Model model ) throws IOException, ParseException {
	    XSSFSheet worksheet = workbook.getSheetAt(0);	
	    for(int i=1;i<worksheet.getPhysicalNumberOfRows() ;i++) {
	        XSSFRow row = worksheet.getRow(i);
	        String thematiques = row.getCell(thematique).getStringCellValue();
	        String type_docs = row.getCell(type_doc).getStringCellValue();
	        String auteur_docs = row.getCell(auteur_doc).getStringCellValue();
	        java.util.Date date_partages = row.getCell(date_partage).getDateCellValue();
	        String receptions = row.getCell(reception).getStringCellValue();
	        docCapService.addDocCap(thematiques, type_docs, auteur_docs, date_partages, receptions);
	        
	    }

	    return "redirect:/listAI";
	}
	
	@RequestMapping("/listDocCap")
	public String listDocCap(Model model) {
		List<DocCap> docCap = docCapService.ListDocCap();
		model.addAttribute("docCap", docCap);
		return "wp4/DocCap/listDocCap";
	}
	
	
}
