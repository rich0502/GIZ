package com.Giz.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Giz.data.domain.Tracker;
import com.Giz.entity.User;
import com.Giz.service.TrackerService;






@Controller
public class TrackerController {
	
    //private static String UPLOADED_FOLDER = "/usr/local/tomcat/webapps/documents/";	
	private static String UPLOADED_FOLDER = "C://uploads//";
	
    //private static String DOWNLOAD_FOLDER = "http://plan-etech.dev.arkeup.com/documents/";
	private static String DOWNLOAD_FOLDER = "http://localhost:8080/documents/";
	
	@Autowired
	TrackerService trackerService;
	
	@RequestMapping("/trackerAdd")
	public String uploadFile(Model model) {

		return "tracker/trackerAdd";
	}
	
	
	@RequestMapping(value="/saveTracker",method = RequestMethod.POST)
    public String saveTracker(@RequestParam("desc_file") String desc_file, @RequestParam("imageValue") String imageValue,HttpServletRequest request) throws Exception
    {
		
	    DateFormat formater = null;
		Date date_tracker = new Date();
		formater = new SimpleDateFormat("dd-MM-yyyy");
		Tracker tracker = new Tracker();
		tracker.setDesc_file(desc_file);
		tracker.setDate_tracker(formater.format(date_tracker));
		
		String msg=imageValue.substring(8);
        byte[] decode = Base64.getDecoder().decode(msg.getBytes());
        File file = new File(UPLOADED_FOLDER + "tracker-"+formater.format(date_tracker)+".jpeg");
        try {
           OutputStream os = new FileOutputStream(file);
           os.write(decode);
           os.close();
        } catch (Exception e) {
           e.printStackTrace();
        }
	       
		tracker.setFile_name("tracker-" + formater.format(date_tracker));
		trackerService.addTracker(tracker);
		return "redirect:trackerList";
    }

	      
	@GetMapping("/trackerList")
	public String trackerList(Model model) throws Exception {
		model.addAttribute("ListFiles",trackerService.getTracker());
		return "tracker/tracker-list";
	}
}
