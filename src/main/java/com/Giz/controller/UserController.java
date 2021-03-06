package com.Giz.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Giz.Exception.CustomeFieldValidationException;
import com.Giz.Exception.UsernameOrIdNotFound;
import com.Giz.data.domain.Accueil;
import com.Giz.dto.ChangePasswordForm;
import com.Giz.entity.Role;
import com.Giz.entity.User;
import com.Giz.repository.AccueilRepository;
import com.Giz.repository.RoleRepository;
import com.Giz.service.EmailService;
import com.Giz.service.UserService;
import com.Giz.service.metier.AccueilService;

@Controller
public class UserController {

	private final String TAB_FORM = "formTab";
	private final String TAB_LIST = "listTab";

	@Autowired
	UserService userService;
	
	@Autowired
	EmailService emailService;
	
	@Autowired
	RoleRepository roleRepository;
	
	
	int notif = 0;
	
	@Autowired
	AccueilService accueilService;
	
	@Autowired
	AccueilRepository accueilRepository;
	
	@RequestMapping(value = { "/accueil" })
	public String accueil(Model model, HttpServletRequest request) throws Exception {
		List<Accueil> accueil = accueilService.ListAccueil();
		model.addAttribute("Accueil", accueil);
		
		/**
		 * persone.getFirstName(Authentication.getPrincipal().getUsername());
		 * model.(nom, personn);0
		 * System.out.println(Authentication.getPrincipal().getUsername());
		 */
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User nomUser = null;
		// Personne pers = new Personne();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String currentUserName = authentication.getName();
			// System.out.println(currentUserName);
			try {
				nomUser = userService.getUserByName(currentUserName);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			model.addAttribute("nomUser", nomUser.getLastName());
			model.addAttribute("roleUser", authentication.getAuthorities());
			// model.addAttribute("fromPersonne", pers);
			return "accueil";
		} else {
			// model.addAttribute("fromPersonne", pers);
			return "accueil";
		}

	}

	@RequestMapping(value = { "/profil" })
	public String profil(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User profilUser = null;
		User profilUser1 = null;
		User profilUser2 = null;
		User profilUser3 = null;
		User profilUser4 = null;
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String currentUserName = authentication.getName();
			String currentUserName1 = authentication.getName();
			String currentUserName2 = authentication.getName();
			String currentUserName3 = authentication.getName();
			String currentUserName4 = authentication.getName();
			try {
				profilUser = userService.getUserByName(currentUserName);
				profilUser1 = userService.getUserByName(currentUserName1);
				profilUser2 = userService.getUserByName(currentUserName2);
				profilUser3 = userService.getUserByName(currentUserName3);
				profilUser4 = userService.getUserByName(currentUserName4);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			model.addAttribute("roles", roleRepository.findAll());
			model.addAttribute("profilUser", profilUser);
			model.addAttribute("profilUser1", profilUser1);
			model.addAttribute("profilUser2", profilUser2);
			model.addAttribute("profilUser3", profilUser3);
			model.addAttribute("profilUser4", profilUser4);
			model.addAttribute("roleUser", authentication.getAuthorities());
			return "user-form/profil-info";
		} else {
			return "user-form/profil-info";
		}

	}

	@GetMapping({ "/", "/login" })
	public String index() {
		return "index";
	}

	@GetMapping("/signup")
	public String signup(Model model) {
		Role userRole = roleRepository.findByName("USER");
		List<Role> roles = Arrays.asList(userRole);

		model.addAttribute("signup", true);
		model.addAttribute("userForm", new User());
		model.addAttribute("roles", roles);
		return "user-form/user-signup";
	}

	@PostMapping("/signup")
	public String signupAction(@Valid @ModelAttribute("userForm") User user, BindingResult result, ModelMap model) {
		Role userRole = roleRepository.findByName("USER");
		List<Role> roles = Arrays.asList(userRole);
		model.addAttribute("userForm", user);
		model.addAttribute("roles", roles);
		model.addAttribute("signup", true);

		if (result.hasErrors()) {
			return "user-form/user-signup";
		} else {
			try {
				userService.createUser(user);
			} catch (CustomeFieldValidationException cfve) {
				result.rejectValue(cfve.getFieldName(), null, cfve.getMessage());
			} catch (Exception e) {
				model.addAttribute("formErrorMessage", e.getMessage());
			}
		}
		return index();
	}

	private void baseAttributerForUserForm(Model model, User user, String activeTab) {
		model.addAttribute("userForm", user);
		model.addAttribute("userList", userService.getAllUsers());
		model.addAttribute("roles", roleRepository.findAll());
		model.addAttribute(activeTab, "active");
	}

	@GetMapping("/userForm")
	public String userForm(Model model) throws Exception {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentUserName = authentication.getName();
		User nomUser = userService.getUserByName(currentUserName);
		model.addAttribute("type", nomUser.getLastName());
		model.addAttribute("notif",notif);
		baseAttributerForUserForm(model, new User(), TAB_LIST);
		return "user-form/user-view";
	}

	@PostMapping("/userForm")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public String createUser(@Valid @ModelAttribute("userForm") User user, BindingResult result, Model model) throws Exception {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentUserName = authentication.getName();
		User nomUser = userService.getUserByName(currentUserName);
		model.addAttribute("type", nomUser.getLastName());
		model.addAttribute("notif",notif);
		if (result.hasErrors()) {
			baseAttributerForUserForm(model, user, TAB_FORM);
		} else {
			try {
				userService.createUser(user);
				baseAttributerForUserForm(model, new User(), TAB_LIST);

			} catch (CustomeFieldValidationException cfve) {
				result.rejectValue(cfve.getFieldName(), null, cfve.getMessage());
				baseAttributerForUserForm(model, user, TAB_FORM);
			} catch (Exception e) {
				model.addAttribute("formErrorMessage", e.getMessage());
				baseAttributerForUserForm(model, user, TAB_FORM);
			}
		}
		return "user-form/user-view";
	}

	@GetMapping("/editUser/{id}")
	public String getEditUserForm(Model model, @PathVariable(name = "id") Long id) throws Exception {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentUserName = authentication.getName();
		User nomUser = userService.getUserByName(currentUserName);
		model.addAttribute("type", nomUser.getLastName());;
		model.addAttribute("notif",notif);
		User userToEdit = userService.getUserById(id);

		baseAttributerForUserForm(model, userToEdit, TAB_FORM);
		model.addAttribute("editMode", "true");
		model.addAttribute("passwordForm", new ChangePasswordForm(id));

		return "user-form/user-view";
	}

	@PostMapping("/editUser")
	public String postEditUserForm(@Valid @ModelAttribute("userForm") User user, BindingResult result, Model model) throws Exception {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentUserName = authentication.getName();
		User nomUser = userService.getUserByName(currentUserName);
		model.addAttribute("type", nomUser.getLastName());
		model.addAttribute("notif",notif);
		if (result.hasErrors()) {
			baseAttributerForUserForm(model, user, TAB_FORM);
			model.addAttribute("editMode", "true");
			model.addAttribute("passwordForm", new ChangePasswordForm(user.getId()));
		} else {
			try {
				userService.updateUser(user);
				baseAttributerForUserForm(model, new User(), TAB_LIST);
			} catch (Exception e) {
				model.addAttribute("formErrorMessage", e.getMessage());

				baseAttributerForUserForm(model, user, TAB_FORM);
				model.addAttribute("editMode", "true");
				model.addAttribute("passwordForm", new ChangePasswordForm(user.getId()));
			}
		}
		return "user-form/user-view";

	}

	@GetMapping("/userForm/cancel")
	public String cancelEditUser(ModelMap model) {
		return "redirect:/userForm";
	}

	@GetMapping("/deleteUser/{id}")
	public String deleteUser(Model model, @PathVariable(name = "id") Long id) throws Exception {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentUserName = authentication.getName();
		User nomUser = userService.getUserByName(currentUserName);
		model.addAttribute("type", nomUser.getLastName());
		model.addAttribute("notif",notif);
		try {
			userService.deleteUser(id);
		} catch (UsernameOrIdNotFound uoin) {
			model.addAttribute("listErrorMessage", uoin.getMessage());
		}
		return userForm(model);
	}

	@PostMapping("/editUser/changePassword")
	public String postEditUseChangePassword(ChangePasswordForm form, Errors errors,Model model,RedirectAttributes redirectAttributes) {
		String succes = "Modification avec succès";
		try {
			if (errors.hasErrors()) {
				String result = errors.getAllErrors().stream().map(x -> x.getDefaultMessage())
						.collect(Collectors.joining(""));

				throw new Exception(result);
			}
			userService.ChangePasswordDto(form);
		} catch (Exception e) {
			String errs = "Erreur de changement de mot de passe";
			redirectAttributes.addFlashAttribute("errs", errs );
			return "redirect:/editUser/"+form.getId();
		}
		redirectAttributes.addFlashAttribute("succes", succes);
		return "redirect:/editUser/"+form.getId();
	}
	
	@RequestMapping(value = "/reset", method = RequestMethod.POST)
	public String reset(@RequestParam("username") String username,Model model) throws Exception {
		String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZazertyuiopqsdfghjklmwxcvb~#[`^@],;:!$?./��%+�^";
	    Random rnd = new Random();

	    StringBuilder sb = new StringBuilder(10);
	    for (int i = 0; i < 10; i++) {
	        sb.append(AB.charAt(rnd.nextInt(AB.length())));
	    }
	    User nomUser = userService.getUserByName(username);
	    ChangePasswordForm form = new ChangePasswordForm();
		if(username != null) {
			form.setCurrentPassword("bank");
			form.setId(nomUser.getId());
			form.setNewPassword(sb.toString());
			form.setConfirmPassword(sb.toString());
			userService.ChangePasswordDto(form);
			emailService.sendSimpleMessage(nomUser.getEmail(), "Reinitialisation mot de passe Giz","mot de passe :" + sb.toString());
			
		}
		return "index";
	}

}
