package com.Giz.data.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "formation_bpa")
public class Formation_bpa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_bpa;
	
	@Column(length = 30)
	private String code_pro;
	
	@Column(length = 30)
	private String code_village;
	
	@Column(length = 250)
	private String nomPrenom_bpa;
	
	@Column(length = 150)
	private String genre_ai;
	
	private int annee_naiss ;
	
	@Column(length = 150)
	private String frm_recu;
	
	private Date date_frm;
	
	@Column(length = 100)
	private String theme_frm;

	public Formation_bpa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Formation_bpa(Long id_bpa, String code_pro, String code_village, String nomPrenom_bpa, String genre_ai,
			int annee_naiss, String frm_recu, Date date_frm, String theme_frm) {
		super();
		this.id_bpa = id_bpa;
		this.code_pro = code_pro;
		this.code_village = code_village;
		this.nomPrenom_bpa = nomPrenom_bpa;
		this.genre_ai = genre_ai;
		this.annee_naiss = annee_naiss;
		this.frm_recu = frm_recu;
		this.date_frm = date_frm;
		this.theme_frm = theme_frm;
	}

	public Long getId_bpa() {
		return id_bpa;
	}

	public void setId_bpa(Long id_bpa) {
		this.id_bpa = id_bpa;
	}

	public String getCode_pro() {
		return code_pro;
	}

	public void setCode_pro(String code_pro) {
		this.code_pro = code_pro;
	}

	public String getCode_village() {
		return code_village;
	}

	public void setCode_village(String code_village) {
		this.code_village = code_village;
	}

	public String getNomPrenom_bpa() {
		return nomPrenom_bpa;
	}

	public void setNomPrenom_bpa(String nomPrenom_bpa) {
		this.nomPrenom_bpa = nomPrenom_bpa;
	}

	public String getGenre_ai() {
		return genre_ai;
	}

	public void setGenre_ai(String genre_ai) {
		this.genre_ai = genre_ai;
	}

	public int getAnnee_naiss() {
		return annee_naiss;
	}

	public void setAnnee_naiss(int annee_naiss) {
		this.annee_naiss = annee_naiss;
	}

	public String getFrm_recu() {
		return frm_recu;
	}

	public void setFrm_recu(String frm_recu) {
		this.frm_recu = frm_recu;
	}

	public Date getDate_frm() {
		return date_frm;
	}

	public void setDate_frm(Date date_frm) {
		this.date_frm = date_frm;
	}

	public String getTheme_frm() {
		return theme_frm;
	}

	public void setTheme_frm(String theme_frm) {
		this.theme_frm = theme_frm;
	}

	
	
}
