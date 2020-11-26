package com.Giz.data.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "wp3_committee_actif")
public class Wp3CommitteeActif {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 10)
	private String code_village;
	private String nom_comite;
	private String mois_annee_creation;
	private boolean committee_actif;
	private Date date_suivi;
	private int effectif_membre;

	private int sexe_h;
	private int sexe_f;

	public Wp3CommitteeActif() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Wp3CommitteeActif(Long id, String code_village, String nom_comite, String mois_annee_creation,
			boolean committee_actif, Date date_suivi, int effectif_membre, int sexe_h, int sexe_f) {
		super();
		this.id = id;
		this.code_village = code_village;
		this.nom_comite = nom_comite;
		this.mois_annee_creation = mois_annee_creation;
		this.committee_actif = committee_actif;
		this.date_suivi = date_suivi;
		this.effectif_membre = effectif_membre;
		this.sexe_h = sexe_h;
		this.sexe_f = sexe_f;
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

	public String getNom_comite() {
		return nom_comite;
	}

	public void setNom_comite(String nom_comite) {
		this.nom_comite = nom_comite;
	}

	public String getMois_annee_creation() {
		return mois_annee_creation;
	}

	public void setMois_annee_creation(String mois_annee_creation) {
		this.mois_annee_creation = mois_annee_creation;
	}

	public boolean isCommittee_actif() {
		return committee_actif;
	}

	public void setCommittee_actif(boolean committee_actif) {
		this.committee_actif = committee_actif;
	}

	public Date getDate_suivi() {
		return date_suivi;
	}

	public void setDate_suivi(Date date_suivi) {
		this.date_suivi = date_suivi;
	}

	public int getEffectif_membre() {
		return effectif_membre;
	}

	public void setEffectif_membre(int effectif_membre) {
		this.effectif_membre = effectif_membre;
	}

	public int getSexe_h() {
		return sexe_h;
	}

	public void setSexe_h(int sexe_h) {
		this.sexe_h = sexe_h;
	}

	public int getSexe_f() {
		return sexe_f;
	}

	public void setSexe_f(int sexe_f) {
		this.sexe_f = sexe_f;
	}

}
