package com.Giz.data.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "formateurs")
public class Formateur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_ft;
	
	@Column(length = 10)
	private String code_village;
	
	@Column(length = 200)
	private String nomPrenom;
	
	@Column(length = 200)
	private String zoneInterv;
	
	@Column(length = 10)
	private String genre_ft;
	
	private int date_naiss;
	
	private boolean operationnel;
	
	private Date date_mise_place;
	
	private Date date_suivi;
	
	private Date date_debut;
	
	private Date date_fin;
	
	private String type_form; 

	public Formateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Formateur(Long id_ft, String code_village, String nomPrenom, String zoneInterv, String genre_ft,
			int date_naiss, boolean operationnel, Date date_mise_place, Date date_suivi, Date date_debut,
			Date date_fin, String type_form) {
		super();
		this.id_ft = id_ft;
		this.code_village = code_village;
		this.nomPrenom = nomPrenom;
		this.zoneInterv = zoneInterv;
		this.genre_ft = genre_ft;
		this.date_naiss = date_naiss;
		this.operationnel = operationnel;
		this.date_mise_place = date_mise_place;
		this.date_suivi = date_suivi;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.type_form = type_form;
	}

	public Long getId_ft() {
		return id_ft;
	}

	public void setId_ft(Long id_ft) {
		this.id_ft = id_ft;
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

	public String getZoneInterv() {
		return zoneInterv;
	}

	public void setZoneInterv(String zoneInterv) {
		this.zoneInterv = zoneInterv;
	}

	public String getGenre_ft() {
		return genre_ft;
	}

	public void setGenre_ft(String genre_ft) {
		this.genre_ft = genre_ft;
	}

	public int getDate_naiss() {
		return date_naiss;
	}

	public void setDate_naiss(int date_naiss) {
		this.date_naiss = date_naiss;
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

	public Date getDate_debut() {
		return date_debut;
	}

	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}

	public Date getDate_fin() {
		return date_fin;
	}

	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}

	public String getType_form() {
		return type_form;
	}

	public void setType_form(String type_form) {
		this.type_form = type_form;
	}

	

}
