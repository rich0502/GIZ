package com.Giz.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Giz.data.domain.Uploads;
import com.Giz.entity.User;
import com.Giz.repository.UploadsRepository;
import com.Giz.service.UploadFilesService;
import com.Giz.service.UserService;

@Controller
public class UploadFileController {
	@Autowired
	UploadsRepository uploadsRepository;
    //Save the uploaded file to this folder
    //private static String UPLOADED_FOLDER = "/usr/local/tomcat/webapps/documents/";	
	private static String UPLOADED_FOLDER = "/usr/share/apache-tomcat-8.5.6/webapps/documents/";
	
    //private static String DOWNLOAD_FOLDER = "http://plan-etech.dev.arkeup.com/documents/";
	private static String DOWNLOAD_FOLDER = "http://168.119.185.165:8080/documents/";
    
	@Autowired
	UserService userService;
    
	@Autowired
	UploadFilesService uploadFilesService;
	
	@GetMapping("/uploadForm")
	public String uploadForm(Model model) throws Exception {
		return "uploads/document-add";
	}
	
	@GetMapping("/uploadList")
	public String uploadList(Model model) throws Exception {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentUserName = authentication.getName();
		User nomUser = userService.getUserByName(currentUserName);
		model.addAttribute("type", nomUser.getLastName());
		//model.addAttribute("notif",notif);
		model.addAttribute("ListFiles",uploadFilesService.getUploads());
		return "uploads/document-list";
	}
	
	@PostMapping("/saveUploads")
    public String saveUploads(@RequestParam("file") MultipartFile file, @RequestParam("chr_rappel") String chr_rappel, @RequestParam("arret") String arret,
            RedirectAttributes redirectAttributes) throws Exception{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentUserName = authentication.getName();
		User nomUser = userService.getUserByName(currentUserName);
		DateFormat formater = null;
		Date date_uploads = new Date();
		formater = new SimpleDateFormat("dd-MM-yyyy");
		Uploads uploads = new Uploads();
		uploads.setAuteur(nomUser.getLastName());
		uploads.setDate_crea(formater.format(date_uploads));
		uploads.setChr_rappel(chr_rappel);
		uploads.setArret(arret);
		
		 if (file.isEmpty()) {
	            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
	            return "redirect:uploadList";
	        }

	        try {

	            // Get the file and save it somewhere
	            byte[] bytes = file.getBytes();
	            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
	            Files.write(path, bytes);
	    		String links_file = DOWNLOAD_FOLDER + file.getOriginalFilename();
	    		uploads.setLinks_file(links_file);
	    		uploadFilesService.addUploads(uploads);

	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        return "redirect:/uploadList";
		
	}
	
	
	
}
