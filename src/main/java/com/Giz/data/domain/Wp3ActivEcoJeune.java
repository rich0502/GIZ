package com.Giz.data.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "wp3_activ_eco_jeune")
public class Wp3ActivEcoJeune {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 10)
	private String code_village;
	private String nom_prenom;
	@Column(length = 5)
	private String sexe;
	private int annee_naissance;
	private String organisme_formateur;
	private String frm_tech_suivi;
	private Date date_fin_frm;
	private String activite_eco;
	private Date date_demarrage;
	private String activite;

	

	public Wp3ActivEcoJeune() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public Wp3ActivEcoJeune(Long id, String code_village, String nom_prenom, String sexe, int annee_naissance,
			String organisme_formateur, String frm_tech_suivi, Date date_fin_frm, String activite_eco,
			Date date_demarrage, String activite) {
		super();
		this.id = id;
		this.code_village = code_village;
		this.nom_prenom = nom_prenom;
		this.sexe = sexe;
		this.annee_naissance = annee_naissance;
		this.organisme_formateur = organisme_formateur;
		this.frm_tech_suivi = frm_tech_suivi;
		this.date_fin_frm = date_fin_frm;
		this.activite_eco = activite_eco;
		this.date_demarrage = date_demarrage;
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

	public String getOrganisme_formateur() {
		return organisme_formateur;
	}

	public void setOrganisme_formateur(String organisme_formateur) {
		this.organisme_formateur = organisme_formateur;
	}

	public String getFrm_tech_suivi() {
		return frm_tech_suivi;
	}

	public void setFrm_tech_suivi(String frm_tech_suivi) {
		this.frm_tech_suivi = frm_tech_suivi;
	}

	public Date getDate_fin_frm() {
		return date_fin_frm;
	}

	public void setDate_fin_frm(Date date_fin_frm) {
		this.date_fin_frm = date_fin_frm;
	}

	public String getActivite_eco() {
		return activite_eco;
	}

	public void setActivite_eco(String activite_eco) {
		this.activite_eco = activite_eco;
	}

	public Date getDate_demarrage() {
		return date_demarrage;
	}

	public void setDate_demarrage(Date date_demarrage) {
		this.date_demarrage = date_demarrage;
	}



	public String getActivite() {
		return activite;
	}



	public void setActivite(String activite) {
		this.activite = activite;
	}
	
	

}
