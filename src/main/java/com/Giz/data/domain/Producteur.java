package com.Giz.data.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "producteur")
public class Producteur {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 50)
	private String zone;
	
	@Column(length = 20)
	private String code_fkt;
	
	@Column(length = 20)
	private String code_prod;
	
	@Column(length = 100)
	private String nom_prod;
	
	@Column(length = 1)
	private String genre;
	
	private Date date_inspection;

	private Date date_naissance;
	
	private String compte;
	
	@Column(length = 20)
	private String cin;
	
	@Column(length = 20)
	private String tel;
	
	private String error_remonte;
	
	private String photo_prod;

	public Producteur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Producteur(Long id, String zone, String code_fkt, String code_prod, String nom_prod, String genre,
			Date date_inspection, Date date_naissance, String compte, String cin, String tel, String error_remonte,
			String photo_prod) {
		super();
		this.id = id;
		this.zone = zone;
		this.code_fkt = code_fkt;
		this.code_prod = code_prod;
		this.nom_prod = nom_prod;
		this.genre = genre;
		this.date_inspection = date_inspection;
		this.date_naissance = date_naissance;
		this.compte = compte;
		this.cin = cin;
		this.tel = tel;
		this.error_remonte = error_remonte;
		this.photo_prod = photo_prod;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public String getCode_fkt() {
		return code_fkt;
	}

	public void setCode_fkt(String code_fkt) {
		this.code_fkt = code_fkt;
	}

	public String getCode_prod() {
		return code_prod;
	}

	public void setCode_prod(String code_prod) {
		this.code_prod = code_prod;
	}

	public String getNom_prod() {
		return nom_prod;
	}

	public void setNom_prod(String nom_prod) {
		this.nom_prod = nom_prod;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Date getDate_inspection() {
		return date_inspection;
	}

	public void setDate_inspection(Date date_inspection) {
		this.date_inspection = date_inspection;
	}

	public Date getDate_naissance() {
		return date_naissance;
	}

	public void setDate_naissance(Date date_naissance) {
		this.date_naissance = date_naissance;
	}

	public String getCompte() {
		return compte;
	}

	public void setCompte(String compte) {
		this.compte = compte;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getError_remonte() {
		return error_remonte;
	}

	public void setError_remonte(String error_remonte) {
		this.error_remonte = error_remonte;
	}

	public String getPhoto_prod() {
		return photo_prod;
	}

	public void setPhoto_prod(String photo_prod) {
		this.photo_prod = photo_prod;
	}
	
}
