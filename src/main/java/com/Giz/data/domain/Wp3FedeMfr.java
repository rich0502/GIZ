package com.Giz.data.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "wp3_fede_mfr")
public class Wp3FedeMfr extends Auditable<String> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 10)
	private String code_region;
	private String nom_mfr;
	private int annee_miseplace;
	private boolean statut;
	private boolean reglement_interieur;
	private boolean recepisse_mfr;
	private Date date_recepisse;
	private boolean plan_strategique;
	private Date date_validation;
	private String sexe;

	public Wp3FedeMfr() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Wp3FedeMfr(Long id, String code_region, String nom_mfr, int annee_miseplace, boolean statut,
			boolean reglement_interieur, boolean recepisse_mfr, Date date_recepisse, boolean plan_strategique,
			Date date_validation) {
		super();
		this.id = id;
		this.code_region = code_region;
		this.nom_mfr = nom_mfr;
		this.annee_miseplace = annee_miseplace;
		this.statut = statut;
		this.reglement_interieur = reglement_interieur;
		this.recepisse_mfr = recepisse_mfr;
		this.date_recepisse = date_recepisse;
		this.plan_strategique = plan_strategique;
		this.date_validation = date_validation;
	}
	
	

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode_region() {
		return code_region;
	}

	public void setCode_region(String code_region) {
		this.code_region = code_region;
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

	public boolean isStatut() {
		return statut;
	}

	public void setStatut(boolean statut) {
		this.statut = statut;
	}

	public boolean isReglement_interieur() {
		return reglement_interieur;
	}

	public void setReglement_interieur(boolean reglement_interieur) {
		this.reglement_interieur = reglement_interieur;
	}

	public boolean isRecepisse_mfr() {
		return recepisse_mfr;
	}

	public void setRecepisse_mfr(boolean recepisse_mfr) {
		this.recepisse_mfr = recepisse_mfr;
	}

	public Date getDate_recepisse() {
		return date_recepisse;
	}

	public void setDate_recepisse(Date date_recepisse) {
		this.date_recepisse = date_recepisse;
	}

	public boolean isPlan_strategique() {
		return plan_strategique;
	}

	public void setPlan_strategique(boolean plan_strategique) {
		this.plan_strategique = plan_strategique;
	}

	public Date getDate_validation() {
		return date_validation;
	}

	public void setDate_validation(Date date_validation) {
		this.date_validation = date_validation;
	}

}
