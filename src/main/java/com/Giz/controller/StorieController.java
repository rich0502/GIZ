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

import com.Giz.data.domain.Storie;
import com.Giz.entity.User;
import com.Giz.repository.StorieRepository;
import com.Giz.service.StorieService;
import com.Giz.service.UserService;

@Controller
public class StorieController {
	@Autowired
	StorieRepository storieRepository;
    //Save the uploaded file to this folder
    //private static String UPLOADED_FOLDER = "/usr/local/tomcat/webapps/documents/";	
	private static String UPLOADED_FOLDER = "C://uploads//";
	
    //private static String DOWNLOAD_FOLDER = "http://plan-etech.dev.arkeup.com/documents/";
	private static String DOWNLOAD_FOLDER = "http://localhost:8080/documents/";
    
	@Autowired
	UserService userService;
    
	@Autowired
	StorieService storieService;
	
	@GetMapping("/storieForm")
	public String storieForm(Model model) throws Exception {
		return "storie/storie-add";
	}
	
	@GetMapping("/storieList")
	public String storieList(Model model) throws Exception {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentUserName = authentication.getName();
		User nomUser = userService.getUserByName(currentUserName);
		model.addAttribute("type", nomUser.getLastName());
		//model.addAttribute("notif",notif);
		model.addAttribute("ListFiles",storieService.getStorie());
		return "storie/storie-list";
	}
	
	@PostMapping("/saveStorie")
    public String saveStorie(@RequestParam("file") MultipartFile file, @RequestParam("nom_str") String nom_str,
            RedirectAttributes redirectAttributes) throws Exception{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentUserName = authentication.getName();
		User nomUser = userService.getUserByName(currentUserName);
		DateFormat formater = null;
		Date date_uploads = new Date();
		formater = new SimpleDateFormat("dd-MM-yyyy");
		Storie storie = new Storie();
		storie.setAuteur(nomUser.getLastName());
		storie.setDate_crea(formater.format(date_uploads));
		storie.setNom_str(nom_str);
		
		 if (file.isEmpty()) {
	            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
	            return "redirect:storieList";
	        }

	        try {

	            // Get the file and save it somewhere
	            byte[] bytes = file.getBytes();
	            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
	            Files.write(path, bytes);
	    		String links_file = DOWNLOAD_FOLDER + file.getOriginalFilename();
	    		storie.setLinks_file(links_file);
	    		storieService.addStorie(storie);

	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        return "redirect:/storieList";
		
	}
	

}
