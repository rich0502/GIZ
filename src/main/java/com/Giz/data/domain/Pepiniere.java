package com.Giz.data.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pepiniere")
public class Pepiniere {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_pep;
	
	@Column(length = 30)
	private String code_village;

	private float x;
	
	private float y;
	
	@Column(length = 150)
	private String nomResp ;
	
	@Column(length = 50)
	private String genre_pep ;
	
	private int annee_naiss ;
	
	private int annee_mise_place ;
	
	private boolean operationnel ;
	
	private Date date_suivi;

	public Pepiniere() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pepiniere(Long id_pep, String code_village, float x, float y, String nomResp, String genre_pep,
			int annee_naiss, int annee_mise_place, boolean operationnel, Date date_suivi) {
		super();
		this.id_pep = id_pep;
		this.code_village = code_village;
		this.x = x;
		this.y = y;
		this.nomResp = nomResp;
		this.genre_pep = genre_pep;
		this.annee_naiss = annee_naiss;
		this.annee_mise_place = annee_mise_place;
		this.operationnel = operationnel;
		this.date_suivi = date_suivi;
	}

	public Long getId_pep() {
		return id_pep;
	}

	public void setId_pep(Long id_pep) {
		this.id_pep = id_pep;
	}

	public String getCode_village() {
		return code_village;
	}

	public void setCode_village(String code_village) {
		this.code_village = code_village;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public String getNomResp() {
		return nomResp;
	}

	public void setNomResp(String nomResp) {
		this.nomResp = nomResp;
	}

	public String getGenre_pep() {
		return genre_pep;
	}

	public void setGenre_pep(String genre_pep) {
		this.genre_pep = genre_pep;
	}

	public int getAnnee_naiss() {
		return annee_naiss;
	}

	public void setAnnee_naiss(int annee_naiss) {
		this.annee_naiss = annee_naiss;
	}

	public int getAnnee_mise_place() {
		return annee_mise_place;
	}

	public void setAnnee_mise_place(int annee_mise_place) {
		this.annee_mise_place = annee_mise_place;
	}

	public boolean isOperationnel() {
		return operationnel;
	}

	public void setOperationnel(boolean operationnel) {
		this.operationnel = operationnel;
	}

	public Date getDate_suivi() {
		return date_suivi;
	}

	public void setDate_suivi(Date date_suivi) {
		this.date_suivi = date_suivi;
	}
	
	

}
