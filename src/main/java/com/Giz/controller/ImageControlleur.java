package com.Giz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.Giz.data.domain.Image;
import com.Giz.service.metier.GalerieService;
import com.Giz.service.metier.ImageService;

@Controller
public class ImageControlleur {
	
	@Autowired
	ImageService imageService;
	@Autowired
	GalerieService galerieService;
	
	@RequestMapping(value = "/album/{id_album}")
	public String albumPage(Model model, @PathVariable(name = "id_album") Long id_album) {
		try {
			model.addAttribute("album_image", galerieService.getGalerieById(id_album));
			model.addAttribute("imageList", imageService.getAllImage());
		} catch (Exception e) {
			System.out.print(e.toString());
		}
		return "album-page/image-view";
	}
	
	
	
	
	@RequestMapping("/saveImage")
	public String createImage(@RequestParam("file") MultipartFile file, @RequestParam("nom_album") String nom_album, @RequestParam("id_album") Long id_album) {
		try {
			String fileName = StringUtils.cleanPath(file.getOriginalFilename());
			Image image = new Image(id_album, file.getBytes(), fileName, file.getContentType());
			imageService.createImage(image);
		} catch (Exception e) {
			System.out.print(e.toString());
		}
		return "redirect:/album/"+id_album;
	}
	
	@RequestMapping(value = "album/deleteImage/{id}/{id_album}")
	public String deleteImage(Model model, @PathVariable(name = "id") Long id, @PathVariable(name = "id_album") Long id_album) {
		try {
			imageService.deleteImage(id);
		} catch (Exception e) {
			System.out.print(e.toString());
		}
		return "redirect:/album/"+id_album;
	}
	
	@RequestMapping(value = "album/deleteGalerieAlbum/{id_album}")
	public String deleteGalerieAlbum(Model model, @PathVariable(name = "id_album") Long id_album) {
		try {
			imageService.deleteGalerieImage(id_album);
		} catch (Exception e) {
			System.out.print(e.toString());
		}
		return "redirect:/galerie";
	}
	
	@GetMapping("/downloadImage/{id}")
	public ResponseEntity<Resource> downloadFile(@PathVariable Long id) throws Exception {
		Image img = imageService.findImage(id);
		return ResponseEntity.ok().contentType(MediaType.parseMediaType(img.getPhoto_type()))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + img.getPhoto_name() + "\"")
				.body(new ByteArrayResource(img.getPhoto()));
	}
	
	

}
