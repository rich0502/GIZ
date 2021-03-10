package com.Giz.data.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sante_animal")
public class Sante_animal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_sa;
	
	@Column(length = 30)
	private String code_village;
	
	@Column(length = 200)
	private String nomPrenom;
	
	@Column(length = 10)
	private String genre_sa;
	
	
	private int annee_naiss;
	
	private boolean operationnel;
	
	private Date date_mise_place;
	
	private Date date_suivi;

	public Sante_animal() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Sante_animal(Long id_sa, String code_village, String nomPrenom, String genre_sa, int annee_naiss,
			boolean operationnel, Date date_mise_place, Date date_suivi) {
		super();
		this.id_sa = id_sa;
		this.code_village = code_village;
		this.nomPrenom = nomPrenom;
		this.genre_sa = genre_sa;
		this.annee_naiss = annee_naiss;
		this.operationnel = operationnel;
		this.date_mise_place = date_mise_place;
		this.date_suivi = date_suivi;
	}

	public Long getId_sa() {
		return id_sa;
	}

	public void setId_sa(Long id_sa) {
		this.id_sa = id_sa;
	}

	public String getCode_village() {
		return code_village;
	}

	public void setCode_village(String code_village) {
		this.code_village = code_village;
	}

	public String getNomPrenom() {
		return nomPrenom;
	}

	public void setNomPrenom(String nomPrenom) {
		this.nomPrenom = nomPrenom;
	}

	public String getGenre_sa() {
		return genre_sa;
	}

	public void setGenre_sa(String genre_sa) {
		this.genre_sa = genre_sa;
	}

	public int getAnnee_naiss() {
		return annee_naiss;
	}

	public void setAnnee_naiss(int annee_naiss) {
		this.annee_naiss = annee_naiss;
	}

	public boolean isOperationnel() {
		return operationnel;
	}

	public void setOperationnel(boolean operationnel) {
		this.operationnel = operationnel;
	}

	public Date getDate_mise_place() {
		return date_mise_place;
	}

	public void setDate_mise_place(Date date_mise_place) {
		this.date_mise_place = date_mise_place;
	}

	public Date getDate_suivi() {
		return date_suivi;
	}

	public void setDate_suivi(Date date_suivi) {
		this.date_suivi = date_suivi;
	}
	
	
	
}
