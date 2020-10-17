package com.Giz.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.Giz.dto.ChangePasswordForm;
import com.Giz.entity.User;
import com.Giz.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository repository;

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public Iterable<User> getAllUsers() {
		return repository.findAll();
	}
	
	@Override
	public User getUserByName(String username) throws Exception {
		return repository.findByUsername(username).orElseThrow(() -> new Exception("Cet utilisateur n'existe pas"));
	}

	private boolean checkUsernameAvailable(User user) throws Exception {
		Optional<User> userFound = repository.findByUsername(user.getUsername());
		if (userFound.isPresent()) {
			throw new Exception("Nom d'utilisateur non disponible");
		}
		return true;
	}

	private boolean checkPasswordValid(User user) throws Exception {
		if (user.getConfirmPassword() == null || user.getConfirmPassword().isEmpty()) {
			throw new Exception("Confirmer le mot de passe est obligatoire");
		}

		if (!user.getPassword().equals(user.getConfirmPassword())) {
			throw new Exception("Mot de passe et Confirmer le mot de passe non identique");
		}
		return true;
	}

	@Override
	public User createUser(User user) throws Exception {
		if (checkUsernameAvailable(user) && checkPasswordValid(user)) {
			String encodePassword = bCryptPasswordEncoder.encode(user.getPassword());
			user.setPassword(encodePassword);
			user = repository.save(user);
		}
		return user;
	}

	@Override
	public User getUserById(Long id) throws Exception {
		return repository.findById(id).orElseThrow(() -> new Exception("Cet utilisateur n'existe pas"));
	}

	@Override
	public User updateUser(User fromUser) throws Exception {
		User toUser = getUserById(fromUser.getId());
		mapUser(fromUser, toUser);
		return repository.save(toUser);
	}

	/**
	 * Map everythin but the password.
	 * 
	 * @param from
	 * @param to
	 */
	protected void mapUser(User from, User to) {
		to.setUsername(from.getUsername());
		to.setFirstName(from.getFirstName());
		to.setLastName(from.getLastName());
		to.setEmail(from.getEmail());
		to.setTel(from.getTel());
		to.setFonction(from.getFonction());
		to.setSociete(from.getSociete());
		to.setRoles(from.getRoles());
	}

	@Override
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public void deleteUser(Long id) throws Exception {
		User user = getUserById(id);
		repository.delete(user);
	}

	@Override
	public User ChangePasswordDto(ChangePasswordForm form) throws Exception {
		User user = getUserById(form.getId());

		/*
		 * if (!isLoggedUserADMIN() &&
		 * !user.getPassword().equals(form.getCurrentPassword())) { throw new
		 * Exception("Mot de passe actuel invalide"); }
		 */

		if (user.getPassword().equals(form.getNewPassword())) {
			throw new Exception("Le nouveau mot de passe doit être différent du mot de passe actuel");
		}

		if (!form.getNewPassword().equals(form.getConfirmPassword())) {
			throw new Exception("Nouveau mot de passe et mot de passe actuel doit être différent");
		}

		String encodePassword = bCryptPasswordEncoder.encode(form.getNewPassword());
		user.setPassword(encodePassword);
		return repository.save(user);
	}

	private boolean isLoggedUserADMIN() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails loggedUser = null;
		if (principal instanceof UserDetails) {
			loggedUser = (UserDetails) principal;

			loggedUser.getAuthorities().stream().filter(x -> "ADMIN".equals(x.getAuthority())).findFirst().orElse(null); // loggedUser
																															// =
																															// null;
		}
		return loggedUser != null ? true : false;
	}

}
