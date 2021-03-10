package com.Giz.data.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ciforme")
public class CiForme {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_ci;
	
	@Column(length = 30)
	private String code_village;
	
	@Column(length = 250)
	private String nomPrenom_ci;
	
	@Column(length = 150)
	private String genre_ci;
	
	private int annee_naiss ;
	
	private Date date_form;
	
	private boolean equipe;

	@Column(length = 150)
	private String type_materiel;
	
	private Date date_dotation;

	public CiForme() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CiForme(Long id_ci, String code_village, String nomPrenom_ci, String genre_ci, int annee_naiss,
			Date date_form, boolean equipe, String type_materiel, Date date_dotation) {
		super();
		this.id_ci = id_ci;
		this.code_village = code_village;
		this.nomPrenom_ci = nomPrenom_ci;
		this.genre_ci = genre_ci;
		this.annee_naiss = annee_naiss;
		this.date_form = date_form;
		this.equipe = equipe;
		this.type_materiel = type_materiel;
		this.date_dotation = date_dotation;
	}

	public Long getId_ci() {
		return id_ci;
	}

	public void setId_ci(Long id_ci) {
		this.id_ci = id_ci;
	}

	public String getCode_village() {
		return code_village;
	}

	public void setCode_village(String code_village) {
		this.code_village = code_village;
	}

	public String getNomPrenom_ci() {
		return nomPrenom_ci;
	}

	public void setNomPrenom_ci(String nomPrenom_ci) {
		this.nomPrenom_ci = nomPrenom_ci;
	}

	public String getGenre_ci() {
		return genre_ci;
	}

	public void setGenre_ci(String genre_ci) {
		this.genre_ci = genre_ci;
	}

	public int getAnnee_naiss() {
		return annee_naiss;
	}

	public void setAnnee_naiss(int annee_naiss) {
		this.annee_naiss = annee_naiss;
	}

	public Date getDate_form() {
		return date_form;
	}

	public void setDate_form(Date date_form) {
		this.date_form = date_form;
	}

	public boolean isEquipe() {
		return equipe;
	}

	public void setEquipe(boolean equipe) {
		this.equipe = equipe;
	}

	public String getType_materiel() {
		return type_materiel;
	}

	public void setType_materiel(String type_materiel) {
		this.type_materiel = type_materiel;
	}

	public Date getDate_dotation() {
		return date_dotation;
	}

	public void setDate_dotation(Date date_dotation) {
		this.date_dotation = date_dotation;
	}
	
	
	
	
}
