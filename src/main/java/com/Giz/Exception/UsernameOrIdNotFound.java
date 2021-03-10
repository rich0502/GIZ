package com.Giz.Exception;

public class UsernameOrIdNotFound extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1668398822129870029L;

	public UsernameOrIdNotFound() {
		super("Utilisateur non trouvé");
	}
	
	public UsernameOrIdNotFound(String message) {
		super(message);
	}
}
