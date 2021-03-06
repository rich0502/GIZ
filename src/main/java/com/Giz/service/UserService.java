package com.Giz.service;

import java.util.List;

import com.Giz.dto.ChangePasswordForm;
import com.Giz.entity.User;

public interface UserService {

	public Iterable<User> getAllUsers();
	
	List<User> getUserByEmail(String email) throws Exception;

	public User createUser(User user) throws Exception;

	public User getUserById(Long id) throws Exception;
	
	public User updateUser(User user) throws Exception;
	
	public void deleteUser(Long id) throws Exception;
	
	public User ChangePasswordDto(ChangePasswordForm form) throws Exception;
	
	public User getUserByName(String username) throws Exception;
	
}
