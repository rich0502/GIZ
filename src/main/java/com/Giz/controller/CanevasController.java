package com.Giz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Giz.data.constants.theme.GetTheme;





@Controller
public class CanevasController {
	
	@RequestMapping(value = "/dropdownlist/{sc}", method = RequestMethod.GET)
	public @ResponseBody String[][] getAllSubcategories(@PathVariable("sc") String sc) {
		String[][] theme = GetTheme.getTheme(sc);
		return theme;
	}

}
