package com.Giz.data.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "wp3_eequipe_tech_mfr")
public class Wp3EquipeTechMfr extends Auditable<String> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 10)
	private String code_village;
	private String nom_prenom;
	@Column(length = 5)
	private String sexe;
	private int annee_naissance;
	private String Frm_recue1;
	/*
	 * private String Frm_recue2; private String Frm_recue3; private String
	 * Frm_recue4;
	 */
	private boolean competence_frm;
	private Date date_eval;
	private String activite;
	public Wp3EquipeTechMfr() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Wp3EquipeTechMfr(Long id, String code_village, String nom_prenom, String sexe, int annee_naissance,
			String frm_recue1, boolean competence_frm, Date date_eval, String activite) {
		super();
		this.id = id;
		this.code_village = code_village;
		this.nom_prenom = nom_prenom;
		this.sexe = sexe;
		this.annee_naissance = annee_naissance;
		Frm_recue1 = frm_recue1;
		this.competence_frm = competence_frm;
		this.date_eval = date_eval;
		this.activite = activite;
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
	public String getNom_prenom() {
		return nom_prenom;
	}
	public void setNom_prenom(String nom_prenom) {
		this.nom_prenom = nom_prenom;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public int getAnnee_naissance() {
		return annee_naissance;
	}
	public void setAnnee_naissance(int annee_naissance) {
		this.annee_naissance = annee_naissance;
	}
	public String getFrm_recue1() {
		return Frm_recue1;
	}
	public void setFrm_recue1(String frm_recue1) {
		Frm_recue1 = frm_recue1;
	}
	public boolean isCompetence_frm() {
		return competence_frm;
	}
	public void setCompetence_frm(boolean competence_frm) {
		this.competence_frm = competence_frm;
	}
	public Date getDate_eval() {
		return date_eval;
	}
	public void setDate_eval(Date date_eval) {
		this.date_eval = date_eval;
	}
	public String getActivite() {
		return activite;
	}
	public void setActivite(String activite) {
		this.activite = activite;
	}

	

}
