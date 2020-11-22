package com.Giz.data.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "leaders")
public class Leaders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_lds;
	
	@Column(length = 10)
	private String code_village;
	
	@Column(length = 150)
	private String nomPrenom;
	
	@Column(length = 150)
	private String genre_pt;
	
	
	private int annee_naiss;
	
	private boolean operationnel;
	
	private Date date_mise;
	
	private Date date_suivi;

	public Leaders() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Leaders(Long id_lds, String code_village, String nomPrenom, String genre_pt, int annee_naiss,
			boolean operationnel, Date date_mise, Date date_suivi) {
		super();
		this.id_lds = id_lds;
		this.code_village = code_village;
		this.nomPrenom = nomPrenom;
		this.genre_pt = genre_pt;
		this.annee_naiss = annee_naiss;
		this.operationnel = operationnel;
		this.date_mise = date_mise;
		this.date_suivi = date_suivi;
	}

	public Long getId_lds() {
		return id_lds;
	}

	public void setId_lds(Long id_lds) {
		this.id_lds = id_lds;
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

	public String getGenre_pt() {
		return genre_pt;
	}

	public void setGenre_pt(String genre_pt) {
		this.genre_pt = genre_pt;
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

	public Date getDate_mise() {
		return date_mise;
	}

	public void setDate_mise(Date date_mise) {
		this.date_mise = date_mise;
	}

	public Date getDate_suivi() {
		return date_suivi;
	}

	public void setDate_suivi(Date date_suivi) {
		this.date_suivi = date_suivi;
	}
	
	
	
	
	
	

}
