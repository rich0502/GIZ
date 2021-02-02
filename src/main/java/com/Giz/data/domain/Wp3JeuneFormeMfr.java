package com.Giz.data.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "wp3_jeune_forme_mfr")
public class Wp3JeuneFormeMfr {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 10)
	private String code_village;
	private String nom_prenom;
	@Column(length = 5)
	private String sexe;
	private int annee_naissance;
	private boolean forme;
	private boolean accompagne_sortie;
	private String type_accompagnement;
	private Date date_suivi;
	private String activite;
	public Wp3JeuneFormeMfr() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Wp3JeuneFormeMfr(Long id, String code_village, String nom_prenom, String sexe, int annee_naissance,
			boolean forme, boolean accompagne_sortie, String type_accompagnement, Date date_suivi, String activite) {
		super();
		this.id = id;
		this.code_village = code_village;
		this.nom_prenom = nom_prenom;
		this.sexe = sexe;
		this.annee_naissance = annee_naissance;
		this.forme = forme;
		this.accompagne_sortie = accompagne_sortie;
		this.type_accompagnement = type_accompagnement;
		this.date_suivi = date_suivi;
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
	public boolean isForme() {
		return forme;
	}
	public void setForme(boolean forme) {
		this.forme = forme;
	}
	public boolean isAccompagne_sortie() {
		return accompagne_sortie;
	}
	public void setAccompagne_sortie(boolean accompagne_sortie) {
		this.accompagne_sortie = accompagne_sortie;
	}
	public String getType_accompagnement() {
		return type_accompagnement;
	}
	public void setType_accompagnement(String type_accompagnement) {
		this.type_accompagnement = type_accompagnement;
	}
	public Date getDate_suivi() {
		return date_suivi;
	}
	public void setDate_suivi(Date date_suivi) {
		this.date_suivi = date_suivi;
	}
	public String getActivite() {
		return activite;
	}
	public void setActivite(String activite) {
		this.activite = activite;
	}

	
}
