package com.Giz.data.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "wp3_agr_deev_mfr")
public class Wp3AgrDevMfr {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 10)
	private String code_village;
	private String nom_mfr;
	private int annee_miseplace;
	private Boolean agr_developpe;
	private Date date_eval;
	private String type_agr_dev1;
	private Date date_suivi1;
	private String sexe;
	/*
	 * private String type_agr_dev2; private Date date_suivi2; private String
	 * type_agr_dev3; private Date date_suivi3; private String type_agr_dev4;
	 * private Date date_suivi4; private String type_agr_dev5; private Date
	 * date_suivi5;
	 */

	public Wp3AgrDevMfr() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Wp3AgrDevMfr(Long id, String code_village, String nom_mfr, int annee_miseplace, Boolean agr_developpe,
			Date date_eval, String type_agr_dev1, Date date_suivi1, String sexe) {
		super();
		this.id = id;
		this.code_village = code_village;
		this.nom_mfr = nom_mfr;
		this.annee_miseplace = annee_miseplace;
		this.agr_developpe = agr_developpe;
		this.date_eval = date_eval;
		this.type_agr_dev1 = type_agr_dev1;
		this.date_suivi1 = date_suivi1;
		this.sexe = sexe;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode_village() {
		return code_village;
	}
	public void setCode_village(String code_village) {
		this.code_village = code_village;
	}
	public String getNom_mfr() {
		return nom_mfr;
	}
	public void setNom_mfr(String nom_mfr) {
		this.nom_mfr = nom_mfr;
	}
	public int getAnnee_miseplace() {
		return annee_miseplace;
	}
	public void setAnnee_miseplace(int annee_miseplace) {
		this.annee_miseplace = annee_miseplace;
	}
	public Boolean getAgr_developpe() {
		return agr_developpe;
	}
	public void setAgr_developpe(Boolean agr_developpe) {
		this.agr_developpe = agr_developpe;
	}
	public Date getDate_eval() {
		return date_eval;
	}
	public void setDate_eval(Date date_eval) {
		this.date_eval = date_eval;
	}
	public String getType_agr_dev1() {
		return type_agr_dev1;
	}
	public void setType_agr_dev1(String type_agr_dev1) {
		this.type_agr_dev1 = type_agr_dev1;
	}
	public Date getDate_suivi1() {
		return date_suivi1;
	}
	public void setDate_suivi1(Date date_suivi1) {
		this.date_suivi1 = date_suivi1;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

}
