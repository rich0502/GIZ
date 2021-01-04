package com.Giz.controller;

import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.Giz.Exception.CustomeFieldValidationException;
import com.Giz.dto.ChangePasswordForm;
import com.Giz.entity.User;
import com.Giz.repository.RoleRepository;
import com.Giz.service.UserService;

@Controller
public class ProfilController {

	private final String TAB_FORM = "formTab";
	private final String TAB_LIST = "listTab";

	@Autowired
	UserService userService;

	@Autowired
	RoleRepository roleRepository;
	
	private void baseAttributerForProfilForm(Model model, User user, String activeTab) {
		model.addAttribute("profilForm", user);
		model.addAttribute("profilList", userService.getAllUsers());
		model.addAttribute("roles", roleRepository.findAll());
		model.addAttribute(activeTab, "active");
	}

	@GetMapping("/profilForm")
	public String profilForm(Model model) {
		baseAttributerForProfilForm(model, new User(), TAB_LIST);
		return "profil-form/profil-view";
	}

	@PostMapping("/profilForm")
	public String createProfil(@Valid @ModelAttribute("profilForm") User user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			baseAttributerForProfilForm(model, user, TAB_FORM);
		} else {
			try {
				userService.createUser(user);
				baseAttributerForProfilForm(model, new User(), TAB_LIST);

			} catch (CustomeFieldValidationException cfve) {
				result.rejectValue(cfve.getFieldName(), null, cfve.getMessage());
				baseAttributerForProfilForm(model, user, TAB_FORM);
			} catch (Exception e) {
				model.addAttribute("formErrorMessage", e.getMessage());
				baseAttributerForProfilForm(model, user, TAB_FORM);
			}
		}
		return "profil-form/profil-view";
	}

	@GetMapping("/editProfil/{id}")
	public String getEditProfilForm(Model model, @PathVariable(name = "id") Long id) throws Exception {
		User profilToEdit = userService.getUserById(id);

		baseAttributerForProfilForm(model, profilToEdit, TAB_FORM);
		model.addAttribute("editMode", "true");
		model.addAttribute("passwordForm", new ChangePasswordForm(id));
		return "profil-form/profil-view";
	}

	@PostMapping("/editProfil")
	public String postEditProfilForm(@Valid @ModelAttribute("profilForm") User user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			baseAttributerForProfilForm(model, user, TAB_FORM);
			model.addAttribute("editMode", "true");
			model.addAttribute("passwordForm", new ChangePasswordForm(user.getId()));
		} else {
			try {
				userService.updateUser(user);
				baseAttributerForProfilForm(model, new User(), TAB_LIST);
			} catch (Exception e) {
				model.addAttribute("formErrorMessage", e.getMessage());

				baseAttributerForProfilForm(model, user, TAB_FORM);
				model.addAttribute("editMode", "true");
				model.addAttribute("passwordForm", new ChangePasswordForm(user.getId()));
			}
		}
		return "profil-form/profil-view";

	}

	@GetMapping("/profilForm/cancel")
	public String cancelEditProfil(ModelMap model) {
		return "redirect:/profilForm";
	}

	
	@PostMapping("/editProfil/changePassword")
	public ResponseEntity postEditProfilChangePassword(@Valid @RequestBody ChangePasswordForm form, Errors errors) {
		System.out.println("getCurrentPassword" + form.getCurrentPassword());
		System.out.println("NewPassword" + form.getNewPassword());
		System.out.println("ConfirmPassword" + form.getConfirmPassword());
		try {
			if (errors.hasErrors()) {
				String result = errors.getAllErrors().stream().map(x -> x.getDefaultMessage())
						.collect(Collectors.joining(""));

				throw new Exception(result);
			}
			userService.ChangePasswordDto(form);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		return ResponseEntity.ok("Success");
	}

}
