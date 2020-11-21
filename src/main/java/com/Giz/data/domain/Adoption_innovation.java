package com.Giz.data.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "adoption_innovation")
public class Adoption_innovation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_ai;
	
	@Column(length = 30)
	private String code_pro;
	
	@Column(length = 250)
	private String nomPrenom_ai;
	
	@Column(length = 150)
	private String genre_ai;
	
	@Column(length = 25)
	private String annee_naiss ;
	
	private Date date_suivi;
	
	@Column(length = 150)
	private String type;

	/**
	 * 
	 */
	public Adoption_innovation() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id_ai
	 * @param code_pro
	 * @param nomPrenom_ai
	 * @param genre_ai
	 * @param annee_naiss
	 * @param date_suivi
	 * @param type
	 */
	public Adoption_innovation(Long id_ai, String code_pro, String nomPrenom_ai, String genre_ai, String annee_naiss,
			Date date_suivi, String type) {
		super();
		this.id_ai = id_ai;
		this.code_pro = code_pro;
		this.nomPrenom_ai = nomPrenom_ai;
		this.genre_ai = genre_ai;
		this.annee_naiss = annee_naiss;
		this.date_suivi = date_suivi;
		this.type = type;
	}

	/**
	 * @return the id_ai
	 */
	public Long getId_ai() {
		return id_ai;
	}

	/**
	 * @param id_ai the id_ai to set
	 */
	public void setId_ai(Long id_ai) {
		this.id_ai = id_ai;
	}

	/**
	 * @return the code_pro
	 */
	public String getCode_pro() {
		return code_pro;
	}

	/**
	 * @param code_pro the code_pro to set
	 */
	public void setCode_pro(String code_pro) {
		this.code_pro = code_pro;
	}

	/**
	 * @return the nomPrenom_ai
	 */
	public String getNomPrenom_ai() {
		return nomPrenom_ai;
	}

	/**
	 * @param nomPrenom_ai the nomPrenom_ai to set
	 */
	public void setNomPrenom_ai(String nomPrenom_ai) {
		this.nomPrenom_ai = nomPrenom_ai;
	}

	/**
	 * @return the genre_ai
	 */
	public String getGenre_ai() {
		return genre_ai;
	}

	/**
	 * @param genre_ai the genre_ai to set
	 */
	public void setGenre_ai(String genre_ai) {
		this.genre_ai = genre_ai;
	}

	/**
	 * @return the annee_naiss
	 */
	public String getAnnee_naiss() {
		return annee_naiss;
	}

	/**
	 * @param annee_naiss the annee_naiss to set
	 */
	public void setAnnee_naiss(String annee_naiss) {
		this.annee_naiss = annee_naiss;
	}

	/**
	 * @return the date_suivi
	 */
	public Date getDate_suivi() {
		return date_suivi;
	}

	/**
	 * @param date_suivi the date_suivi to set
	 */
	public void setDate_suivi(Date date_suivi) {
		this.date_suivi = date_suivi;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	
	
}
