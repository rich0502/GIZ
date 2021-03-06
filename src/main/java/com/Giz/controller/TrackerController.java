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
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Giz.data.domain.Tracker;
import com.Giz.service.TrackerService;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

@Controller
public class TrackerController {
	
    //private static String UPLOADED_FOLDER = "/usr/local/tomcat/webapps/documents/";	
	//private static String UPLOADED_FOLDER = "/home/liantsoa/Documents/FileUpload/";
	private static String UPLOADED_FOLDER = "/usr/share/apache-tomcat-8.5.6/webapps/tracker/";
	
    //private static String DOWNLOAD_FOLDER = "http://plan-etech.dev.arkeup.com/documents/";
	private static String DOWNLOAD_FOLDER = "http://168.119.185.165:8080/tracker/";
	
	@Autowired
	TrackerService trackerService;
	
	// HISTORIQUE TRACKER WP1 à WP4
	@RequestMapping("/trackerHistorique/{type_tracker}")
	public String trackerHistorique(@PathVariable("type_tracker") String type_tracker,Model model) throws Exception {
		String titre="tracker " + type_tracker;
		List<Object[]> historiqueList = trackerService.historiqueList(type_tracker);
		model.addAttribute("historiqueList", historiqueList);
		model.addAttribute("titre", titre);
		return "historique/historiqueList";
	}
	
	// DELETE TRACKER WP1 à WP4
	@RequestMapping("/deleteTrackerWP1/{id}")
	public String deleteTrackerWP1(@PathVariable(name = "id") Long id) {
		trackerService.deleteTracker(id);
		return "redirect:/trackerListWP1";
	}
	@RequestMapping("/deleteTrackerWP2/{id}")
	public String deleteTrackerWP2(@PathVariable(name = "id") Long id) {
		trackerService.deleteTracker(id);
		return "redirect:/trackerListWP2";
	}
	@RequestMapping("/deleteTrackerWP3/{id}")
	public String deleteTrackerWP3(@PathVariable(name = "id") Long id) {
		trackerService.deleteTracker(id);
		return "redirect:/trackerListWP3";
	}
	@RequestMapping("/deleteTrackerWP4/{id}")
	public String deleteTrackerWP4(@PathVariable(name = "id") Long id) {
		trackerService.deleteTracker(id);
		return "redirect:/trackerListWP4";
	}

	//WP1
	@RequestMapping("/trackerAddWP1")
	public String trackerAddWP1(Model model) {

		return "tracker/trackerAddWP1";
	}
	
	
	@RequestMapping(value="/TrackerTableWP1",method = RequestMethod.POST)
    public String TrackerTableWP1( @RequestParam("imageValue") String imageValue, Model model) throws Exception
    {     
		System.out.println("imageValue" + imageValue);
		model.addAttribute("imageValue",imageValue);
		return "tracker/trackerTableWP1";
    }

	@RequestMapping(value="/saveTrackerWP1",method = RequestMethod.POST)
    public String saveTrackerWP1(@RequestParam("desc_file") String desc_file, @RequestParam("imageValue") String imageValue,@RequestParam("tableWp") String tableWp, HttpServletRequest request) throws Exception
    {
	    DateFormat formater = null;
		Date date_tracker = new Date();
		formater = new SimpleDateFormat("dd-MM-yyyy");
		Tracker tracker = new Tracker();
		tracker.setDesc_file(desc_file);
		tracker.setDate_tracker(formater.format(date_tracker));
		tracker.setType_tracker("WP1");
		String msg=imageValue.substring(8);
        byte[] decode = Base64.getDecoder().decode(msg.getBytes());
        //tableau
		String msgNext=tableWp.substring(8);
        byte[] decodeNext = Base64.getDecoder().decode(msgNext.getBytes());
        File file = new File(UPLOADED_FOLDER + "tracker-"+formater.format(date_tracker)+".jpeg");
        File fileNext = new File(UPLOADED_FOLDER + "trackerNext-"+formater.format(date_tracker)+".jpeg");
        try {
           OutputStream os = new FileOutputStream(file);
           os.write(decode);
           os.close();
        } catch (Exception e) {
           e.printStackTrace();
        }
        try {
            OutputStream osNext = new FileOutputStream(fileNext);
            osNext.write(decodeNext);
            osNext.close();
         } catch (Exception e) {
            e.printStackTrace();
         }
        Path path = Paths.get(UPLOADED_FOLDER + "tracker-"+formater.format(date_tracker)+".jpeg");
        Path pathNext = Paths.get(UPLOADED_FOLDER + "trackerNext-"+formater.format(date_tracker)+".jpeg");
        Font font = FontFactory.getFont(FontFactory.TIMES_BOLD, 16, BaseColor.RED);
        final Chunk NEWLINE = new Chunk("\n");
        Document document = new Document(PageSize.A4.rotate());
        PdfWriter.getInstance(document, new FileOutputStream(UPLOADED_FOLDER +formater.format(date_tracker)+"TrackerWP1.pdf"));
        document.open();
        Image img = Image.getInstance(path.toAbsolutePath().toString());
        img.scaleAbsolute(800, 400);
        Image imgNext = Image.getInstance(pathNext.toAbsolutePath().toString());
        imgNext.scaleAbsolute(600, 300);
        document.add( new Paragraph( "WP1: Climate Smart", font ));
        document.add( new Paragraph(  "    Agriculture (CSA)", font ));
        document.add(img);
        document.add(NEWLINE);
        document.add(NEWLINE);
        document.add(NEWLINE);
        document.add( new Paragraph( "WP1 Climate smart agriculture", font ) );
        document.add( new Paragraph(  "  Activities highlights based on status", font ) );
        document.add(imgNext);
        document.close();
		tracker.setFile_name(formater.format(date_tracker)+"TrackerWP1.pdf");
		trackerService.addTracker(tracker);
		return "redirect:trackerListWP1";
    }
	      
	@GetMapping("/trackerListWP1")
	public String trackerListWP1(Model model) throws Exception {
		model.addAttribute("ListFiles",trackerService.getTracker("WP1"));
		return "tracker/tracker-listWP1";
	}
	
	@GetMapping("/trackerFormWP1")
	public String trackerFormWP1(Model model) throws Exception {
		return "tracker/tracker-uploadWP1";
	}
	
	@RequestMapping(value = "/uploadtrackerWP1", method = RequestMethod.POST)
    public String uploadtrackerWP1(@RequestParam("file") MultipartFile file, @RequestParam("desc_file") String desc_file,
            RedirectAttributes redirectAttributes) throws Exception{
		DateFormat formater = null;
		Date date_tracker = new Date();
		formater = new SimpleDateFormat("dd-MM-yyyy");
		Tracker tracker = new Tracker();
		tracker.setDesc_file(desc_file);
		tracker.setDate_tracker(formater.format(date_tracker));
		tracker.setType_tracker("WP1");
		
		 if (file.isEmpty()) {
	            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
	            return "redirect:trackerListWP1";
	        }
	        try {
	            // Get the file and save it somewhere
	            byte[] bytes = file.getBytes();
	            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
	            Files.write(path, bytes);
	    		String file_name = file.getOriginalFilename();
	    		tracker.setFile_name(file_name);
	    		trackerService.addTracker(tracker);

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return "redirect:/trackerListWP1";
	}
	
	//WP2
	@RequestMapping("/trackerAddWP2")
	public String trackerAddWP2(Model model) {

		return "tracker/trackerAddWP2";
	}
	
	
	@RequestMapping(value="/TrackerTableWP2",method = RequestMethod.POST)
    public String TrackerTableWP2( @RequestParam("imageValue") String imageValue, Model model) throws Exception
    {     
		System.out.println("imageValue" + imageValue);
		model.addAttribute("imageValue",imageValue);
		return "tracker/trackerTableWP2";
    }

	@RequestMapping(value="/saveTrackerWP2",method = RequestMethod.POST)
    public String saveTrackerWP2(@RequestParam("desc_file") String desc_file, @RequestParam("imageValue") String imageValue,@RequestParam("tableWp") String tableWp, HttpServletRequest request) throws Exception
    {
	    DateFormat formater = null;
		Date date_tracker = new Date();
		formater = new SimpleDateFormat("dd-MM-yyyy");
		Tracker tracker = new Tracker();
		tracker.setDesc_file(desc_file);
		tracker.setDate_tracker(formater.format(date_tracker));
		tracker.setType_tracker("WP2");
		String msg=imageValue.substring(8);
        byte[] decode = Base64.getDecoder().decode(msg.getBytes());
        //tableau
		String msgNext=tableWp.substring(8);
        byte[] decodeNext = Base64.getDecoder().decode(msgNext.getBytes());
        File file = new File(UPLOADED_FOLDER + "tracker-"+formater.format(date_tracker)+".jpeg");
        File fileNext = new File(UPLOADED_FOLDER + "trackerNext-"+formater.format(date_tracker)+".jpeg");
        try {
           OutputStream os = new FileOutputStream(file);
           os.write(decode);
           os.close();
        } catch (Exception e) {
           e.printStackTrace();
        }
        try {
            OutputStream osNext = new FileOutputStream(fileNext);
            osNext.write(decodeNext);
            osNext.close();
         } catch (Exception e) {
            e.printStackTrace();
         }
        Path path = Paths.get(UPLOADED_FOLDER + "tracker-"+formater.format(date_tracker)+".jpeg");
        Path pathNext = Paths.get(UPLOADED_FOLDER + "trackerNext-"+formater.format(date_tracker)+".jpeg");
        Font font = FontFactory.getFont(FontFactory.TIMES_BOLD, 16, BaseColor.RED);
        final Chunk NEWLINE = new Chunk("\n");
        Document document = new Document(PageSize.A4.rotate());
        PdfWriter.getInstance(document, new FileOutputStream(UPLOADED_FOLDER +formater.format(date_tracker)+"TrackerWP2.pdf"));
        document.open();
        Image img = Image.getInstance(path.toAbsolutePath().toString());
        img.scaleAbsolute(800, 400);
        Image imgNext = Image.getInstance(pathNext.toAbsolutePath().toString());
        imgNext.scaleAbsolute(800, 400);
        document.add( new Paragraph( "WP 2: Access to ", font ));
        document.add( new Paragraph(  "    Finance", font ));
        document.add(img);
        document.add(NEWLINE);
        document.add(NEWLINE);
        document.add(NEWLINE);
        document.add( new Paragraph( "WP 2: Access to Finance", font ) );
        document.add( new Paragraph(  "  Activities highlights based on status", font ) );
        document.add(imgNext);
        document.close();
		tracker.setFile_name(formater.format(date_tracker)+"TrackerWP2.pdf");
		trackerService.addTracker(tracker);
		return "redirect:trackerListWP2";
    }
	      
	@GetMapping("/trackerListWP2")
	public String trackerListWP2(Model model) throws Exception {
		model.addAttribute("ListFiles",trackerService.getTracker("WP2"));
		return "tracker/tracker-listWP2";
	}
	
	@GetMapping("/trackerFormWP2")
	public String trackerFormWP2(Model model) throws Exception {
		return "tracker/tracker-uploadWP2";
	}
	
	@RequestMapping(value = "/uploadtrackerWP2", method = RequestMethod.POST)
    public String uploadtrackerWP2(@RequestParam("file") MultipartFile file, @RequestParam("desc_file") String desc_file,
            RedirectAttributes redirectAttributes) throws Exception{
		DateFormat formater = null;
		Date date_tracker = new Date();
		formater = new SimpleDateFormat("dd-MM-yyyy");
		Tracker tracker = new Tracker();
		tracker.setDesc_file(desc_file);
		tracker.setDate_tracker(formater.format(date_tracker));
		tracker.setType_tracker("WP2");
		
		 if (file.isEmpty()) {
	            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
	            return "redirect:trackerListWP2";
	        }
	        try {
	            // Get the file and save it somewhere
	            byte[] bytes = file.getBytes();
	            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
	            Files.write(path, bytes);
	    		String file_name = file.getOriginalFilename();
	    		tracker.setFile_name(file_name);
	    		trackerService.addTracker(tracker);

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return "redirect:/trackerListWP2";
	}
	
		//WP3
		@RequestMapping("/trackerAddWP3")
		public String trackerAddWP3(Model model) {

			return "tracker/trackerAddWP3";
		}
		
		
		@RequestMapping(value="/TrackerTableWP3",method = RequestMethod.POST)
	    public String TrackerTableWP3( @RequestParam("imageValue") String imageValue, Model model) throws Exception
	    {     
			System.out.println("imageValue" + imageValue);
			model.addAttribute("imageValue",imageValue);
			return "tracker/trackerTableWP3";
	    }

		@RequestMapping(value="/saveTrackerWP3",method = RequestMethod.POST)
	    public String saveTrackerWP3(@RequestParam("desc_file") String desc_file, @RequestParam("imageValue") String imageValue,@RequestParam("tableWp") String tableWp, HttpServletRequest request) throws Exception
	    {
		    DateFormat formater = null;
			Date date_tracker = new Date();
			formater = new SimpleDateFormat("dd-MM-yyyy");
			Tracker tracker = new Tracker();
			tracker.setDesc_file(desc_file);
			tracker.setDate_tracker(formater.format(date_tracker));
			tracker.setType_tracker("WP3");
			String msg=imageValue.substring(8);
	        byte[] decode = Base64.getDecoder().decode(msg.getBytes());
	        //tableau
			String msgNext=tableWp.substring(8);
	        byte[] decodeNext = Base64.getDecoder().decode(msgNext.getBytes());
	        File file = new File(UPLOADED_FOLDER + "tracker-"+formater.format(date_tracker)+".jpeg");
	        File fileNext = new File(UPLOADED_FOLDER + "trackerNext-"+formater.format(date_tracker)+".jpeg");
	        try {
	           OutputStream os = new FileOutputStream(file);
	           os.write(decode);
	           os.close();
	        } catch (Exception e) {
	           e.printStackTrace();
	        }
	        try {
	            OutputStream osNext = new FileOutputStream(fileNext);
	            osNext.write(decodeNext);
	            osNext.close();
	         } catch (Exception e) {
	            e.printStackTrace();
	         }
	        Path path = Paths.get(UPLOADED_FOLDER + "tracker-"+formater.format(date_tracker)+".jpeg");
	        Path pathNext = Paths.get(UPLOADED_FOLDER + "trackerNext-"+formater.format(date_tracker)+".jpeg");
	        Font font = FontFactory.getFont(FontFactory.TIMES_BOLD, 16, BaseColor.RED);
	        final Chunk NEWLINE = new Chunk("\n");
	        Document document = new Document(PageSize.A4.rotate());
	        PdfWriter.getInstance(document, new FileOutputStream(UPLOADED_FOLDER +formater.format(date_tracker)+"TrackerWP3.pdf"));
	        document.open();
	        Image img = Image.getInstance(path.toAbsolutePath().toString());
	        img.scaleAbsolute(800, 400);
	        Image imgNext = Image.getInstance(pathNext.toAbsolutePath().toString());
	        imgNext.scaleAbsolute(800, 400);
	        document.add( new Paragraph( "WP 3: Youth and Child", font ));
	        document.add( new Paragraph(  "   Protection)", font ));
	        document.add(img);
	        document.add(NEWLINE);
	        document.add(NEWLINE);
	        document.add(NEWLINE);
	        document.add( new Paragraph( "WP1 Climate smart agriculture", font ) );
	        document.add( new Paragraph(  "  Activities highlights based on status", font ) );
	        document.add(imgNext);
	        document.close();
			tracker.setFile_name(formater.format(date_tracker)+"TrackerWP3.pdf");
			trackerService.addTracker(tracker);
			return "redirect:trackerListWP3";
	    }
		      
		@GetMapping("/trackerListWP3")
		public String trackerListWP3(Model model) throws Exception {
			model.addAttribute("ListFiles",trackerService.getTracker("WP3"));
			return "tracker/tracker-listWP3";
		}
		
		@GetMapping("/trackerFormWP3")
		public String trackerFormWP3(Model model) throws Exception {
			return "tracker/tracker-uploadWP3";
		}
		
		@RequestMapping(value = "/uploadtrackerWP3", method = RequestMethod.POST)
	    public String uploadtrackerWP3(@RequestParam("file") MultipartFile file, @RequestParam("desc_file") String desc_file,
	            RedirectAttributes redirectAttributes) throws Exception{
			DateFormat formater = null;
			Date date_tracker = new Date();
			formater = new SimpleDateFormat("dd-MM-yyyy");
			Tracker tracker = new Tracker();
			tracker.setDesc_file(desc_file);
			tracker.setDate_tracker(formater.format(date_tracker));
			tracker.setType_tracker("WP3");
			
			 if (file.isEmpty()) {
		            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
		            return "redirect:trackerListWP3";
		        }
		        try {
		            // Get the file and save it somewhere
		            byte[] bytes = file.getBytes();
		            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
		            Files.write(path, bytes);
		    		String file_name = file.getOriginalFilename();
		    		tracker.setFile_name(file_name);
		    		trackerService.addTracker(tracker);

		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		        return "redirect:/trackerListWP3";
		}
		
		//WP4
		@RequestMapping("/trackerAddWP4")
		public String trackerAddWP4(Model model) {
	
			return "tracker/trackerAddWP4";
		}
		
		
		@RequestMapping(value="/TrackerTableWP4",method = RequestMethod.POST)
	    public String TrackerTableWP4( @RequestParam("imageValue") String imageValue, Model model) throws Exception
	    {     
			System.out.println("imageValue" + imageValue);
			model.addAttribute("imageValue",imageValue);
			return "tracker/trackerTableWP4";
	    }
	
		@RequestMapping(value="/saveTrackerWP4",method = RequestMethod.POST)
	    public String saveTrackerWP4(@RequestParam("desc_file") String desc_file, @RequestParam("imageValue") String imageValue,@RequestParam("tableWp") String tableWp, HttpServletRequest request) throws Exception
	    {
		    DateFormat formater = null;
			Date date_tracker = new Date();
			formater = new SimpleDateFormat("dd-MM-yyyy");
			Tracker tracker = new Tracker();
			tracker.setDesc_file(desc_file);
			tracker.setDate_tracker(formater.format(date_tracker));
			tracker.setType_tracker("WP4");
			String msg=imageValue.substring(8);
	        byte[] decode = Base64.getDecoder().decode(msg.getBytes());
	        //tableau
			String msgNext=tableWp.substring(8);
	        byte[] decodeNext = Base64.getDecoder().decode(msgNext.getBytes());
	        File file = new File(UPLOADED_FOLDER + "tracker-"+formater.format(date_tracker)+".jpeg");
	        File fileNext = new File(UPLOADED_FOLDER + "trackerNext-"+formater.format(date_tracker)+".jpeg");
	        try {
	           OutputStream os = new FileOutputStream(file);
	           os.write(decode);
	           os.close();
	        } catch (Exception e) {
	           e.printStackTrace();
	        }
	        try {
	            OutputStream osNext = new FileOutputStream(fileNext);
	            osNext.write(decodeNext);
	            osNext.close();
	         } catch (Exception e) {
	            e.printStackTrace();
	         }
	        Path path = Paths.get(UPLOADED_FOLDER + "tracker-"+formater.format(date_tracker)+".jpeg");
	        Path pathNext = Paths.get(UPLOADED_FOLDER + "trackerNext-"+formater.format(date_tracker)+".jpeg");
	        Font font = FontFactory.getFont(FontFactory.TIMES_BOLD, 16, BaseColor.RED);
	        final Chunk NEWLINE = new Chunk("\n");
	        Document document = new Document(PageSize.A4.rotate());
	        PdfWriter.getInstance(document, new FileOutputStream(UPLOADED_FOLDER +formater.format(date_tracker)+"TrackerWP4.pdf"));
	        document.open();
	        Image img = Image.getInstance(path.toAbsolutePath().toString());
	        img.scaleAbsolute(800, 400);
	        Image imgNext = Image.getInstance(pathNext.toAbsolutePath().toString());
	        imgNext.scaleAbsolute(800, 400);
	        document.add( new Paragraph( "WP 5: M&E", font ));
	        document.add( new Paragraph(  "    Agriculture (CSA)", font ));
	        document.add(img);
	        document.add(NEWLINE);
	        document.add(NEWLINE);
	        document.add(NEWLINE);
	        document.add( new Paragraph( "WP 5 M&E", font ) );
	        document.add( new Paragraph(  " Activities highlights based on status", font ) );
	        document.add(imgNext);
	        document.close();
			tracker.setFile_name(formater.format(date_tracker)+"TrackerWP4.pdf");
			trackerService.addTracker(tracker);
			return "redirect:trackerListWP4";
	    }
		      
		@GetMapping("/trackerListWP4")
		public String trackerListWP4(Model model) throws Exception {
			model.addAttribute("ListFiles",trackerService.getTracker("WP4"));
			return "tracker/tracker-listWP4";
		}
		
		@GetMapping("/trackerFormWP4")
		public String trackerFormWP4(Model model) throws Exception {
			return "tracker/tracker-uploadWP4";
		}
		
		@RequestMapping(value = "/uploadtrackerWP4", method = RequestMethod.POST)
	    public String uploadtrackerWP4(@RequestParam("file") MultipartFile file, @RequestParam("desc_file") String desc_file,
	            RedirectAttributes redirectAttributes) throws Exception{
			DateFormat formater = null;
			Date date_tracker = new Date();
			formater = new SimpleDateFormat("dd-MM-yyyy");
			Tracker tracker = new Tracker();
			tracker.setDesc_file(desc_file);
			tracker.setDate_tracker(formater.format(date_tracker));
			tracker.setType_tracker("WP4");
			
			 if (file.isEmpty()) {
		            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
		            return "redirect:trackerListWP4";
		        }
		        try {
		            // Get the file and save it somewhere
		            byte[] bytes = file.getBytes();
		            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
		            Files.write(path, bytes);
		    		String file_name = file.getOriginalFilename();
		    		tracker.setFile_name(file_name);
		    		trackerService.addTracker(tracker);

		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		        return "redirect:/trackerListWP4";
		}
}
