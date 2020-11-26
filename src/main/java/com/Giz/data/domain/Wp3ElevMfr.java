package com.Giz.data.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "wp3_elev_mfr")
public class Wp3ElevMfr {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 10)
	private String code_village;
	private String nom_prenom;
	private String village_origine;
	@Column(length = 5)
	private String sexe;
	private int annee_naissance;
	private boolean inscrit;
	private int annee_inscription;
	private Date date_suivi;
	private String type_frm;
	private int annee_etude;
	private Date date_sortie;
	private String type_projet;
	private String niveau_demarrage;
	private Date date_validation;
	private boolean accompagne;
	private Date date_suivi1;
	/*
	 * private Date date_suivi2; private Date date_suivi3; private Date date_suivi4;
	 */

	public Wp3ElevMfr() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Wp3ElevMfr(Long id, String code_village, String nom_prenom, String village_origine, String sexe,
			int annee_naissance, boolean inscrit, int annee_inscription, Date date_suivi, String type_frm,
			int annee_etude, Date date_sortie, String type_projet, String niveau_demarrage, Date date_validation,
			boolean accompagne, Date date_suivi1) {
		super();
		this.id = id;
		this.code_village = code_village;
		this.nom_prenom = nom_prenom;
		this.village_origine = village_origine;
		this.sexe = sexe;
		this.annee_naissance = annee_naissance;
		this.inscrit = inscrit;
		this.annee_inscription = annee_inscription;
		this.date_suivi = date_suivi;
		this.type_frm = type_frm;
		this.annee_etude = annee_etude;
		this.date_sortie = date_sortie;
		this.type_projet = type_projet;
		this.niveau_demarrage = niveau_demarrage;
		this.date_validation = date_validation;
		this.accompagne = accompagne;
		this.date_suivi1 = date_suivi1;
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

	public String getVillage_origine() {
		return village_origine;
	}

	public void setVillage_origine(String village_origine) {
		this.village_origine = village_origine;
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

	public boolean isInscrit() {
		return inscrit;
	}

	public void setInscrit(boolean inscrit) {
		this.inscrit = inscrit;
	}

	public int getAnnee_inscription() {
		return annee_inscription;
	}

	public void setAnnee_inscription(int annee_inscription) {
		this.annee_inscription = annee_inscription;
	}

	public Date getDate_suivi() {
		return date_suivi;
	}

	public void setDate_suivi(Date date_suivi) {
		this.date_suivi = date_suivi;
	}

	public String getType_frm() {
		return type_frm;
	}

	public void setType_frm(String type_frm) {
		this.type_frm = type_frm;
	}

	public int getAnnee_etude() {
		return annee_etude;
	}

	public void setAnnee_etude(int annee_etude) {
		this.annee_etude = annee_etude;
	}

	public Date getDate_sortie() {
		return date_sortie;
	}

	public void setDate_sortie(Date date_sortie) {
		this.date_sortie = date_sortie;
	}

	public String getType_projet() {
		return type_projet;
	}

	public void setType_projet(String type_projet) {
		this.type_projet = type_projet;
	}

	public String getNiveau_demarrage() {
		return niveau_demarrage;
	}

	public void setNiveau_demarrage(String niveau_demarrage) {
		this.niveau_demarrage = niveau_demarrage;
	}

	public Date getDate_validation() {
		return date_validation;
	}

	public void setDate_validation(Date date_validation) {
		this.date_validation = date_validation;
	}

	public boolean isAccompagne() {
		return accompagne;
	}

	public void setAccompagne(boolean accompagne) {
		this.accompagne = accompagne;
	}

	public Date getDate_suivi1() {
		return date_suivi1;
	}

	public void setDate_suivi1(Date date_suivi1) {
		this.date_suivi1 = date_suivi1;
	}

}
