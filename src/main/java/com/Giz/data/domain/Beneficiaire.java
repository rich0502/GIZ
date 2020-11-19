package com.Giz.data.domain;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Beneficiaire")
public class Beneficiaire {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_bf;

	@Column(length = 150)
	private String nom_bf;
	@Column(length = 75)
	private String prenom_bf;
	
	private Boolean success;
	
	@Column(length = 75)
	private String adresse_bf;
	@Column(length = 15)
	private String contact_bf;
	@Column(length = 25)
	private String date_naiss_bf;
	
	
	
	/**
	 * 
	 */
	public Beneficiaire() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param id_bf
	 * @param nom_bf
	 * @param prenom_bf
	 * @param adresse_bf
	 * @param contact_bf
	 * @param date_naiss_bf
	 */
	
	public Beneficiaire(Long id_bf) {
		this.id_bf = id_bf;
	}
	
	/**
	 * @param id_bf
	 * @param nom_bf
	 * @param success
	 * @param prenom_bf
	 * @param adresse_bf
	 * @param contact_bf
	 * @param date_naiss_bf
	 */
	public Beneficiaire(Long id_bf, String nom_bf, Boolean success, String prenom_bf, String adresse_bf,
			String contact_bf, String date_naiss_bf) {
		super();
		this.id_bf = id_bf;
		this.nom_bf = nom_bf;
		this.success = success;
		this.prenom_bf = prenom_bf;
		this.adresse_bf = adresse_bf;
		this.contact_bf = contact_bf;
		this.date_naiss_bf = date_naiss_bf;
	}



	/**
	 * @return the id_bf
	 */
	public Long getId_bf() {
		return id_bf;
	}



	/**
	 * @param id_bf the id_bf to set
	 */
	public void setId_bf(Long id_bf) {
		this.id_bf = id_bf;
	}



	/**
	 * @return the nom_bf
	 */
	public String getNom_bf() {
		return nom_bf;
	}



	/**
	 * @param nom_bf the nom_bf to set
	 */
	public void setNom_bf(String nom_bf) {
		this.nom_bf = nom_bf;
	}



	/**
	 * @return the success
	 */
	public Boolean getSuccess() {
		return success;
	}



	/**
	 * @param success the success to set
	 */
	public void setSuccess(Boolean success) {
		this.success = success;
	}



	/**
	 * @return the prenom_bf
	 */
	public String getPrenom_bf() {
		return prenom_bf;
	}



	/**
	 * @param prenom_bf the prenom_bf to set
	 */
	public void setPrenom_bf(String prenom_bf) {
		this.prenom_bf = prenom_bf;
	}



	/**
	 * @return the adresse_bf
	 */
	public String getAdresse_bf() {
		return adresse_bf;
	}



	/**
	 * @param adresse_bf the adresse_bf to set
	 */
	public void setAdresse_bf(String adresse_bf) {
		this.adresse_bf = adresse_bf;
	}



	/**
	 * @return the contact_bf
	 */
	public String getContact_bf() {
		return contact_bf;
	}



	/**
	 * @param contact_bf the contact_bf to set
	 */
	public void setContact_bf(String contact_bf) {
		this.contact_bf = contact_bf;
	}



	/**
	 * @return the date_naiss_bf
	 */
	public String getDate_naiss_bf() {
		return date_naiss_bf;
	}



	/**
	 * @param date_naiss_bf the date_naiss_bf to set
	 */
	public void setDate_naiss_bf(String date_naiss_bf) {
		this.date_naiss_bf = date_naiss_bf;
	}
		

}
