package com.Giz.data.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "wp3_jeune_pathway")
public class Wp3JeunePathway {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 10)
	private String code_village;
	private String nom_prenom;
	@Column(length = 5)
	private String sexe;
	private int annee_naissance;
	private Date date_fin_frm;
	private boolean existance_agr;
	private String activite;
	public Wp3JeunePathway() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Wp3JeunePathway(Long id, String code_village, String nom_prenom, String sexe, int annee_naissance,
			Date date_fin_frm, boolean existance_agr, String activite) {
		super();
		this.id = id;
		this.code_village = code_village;
		this.nom_prenom = nom_prenom;
		this.sexe = sexe;
		this.annee_naissance = annee_naissance;
		this.date_fin_frm = date_fin_frm;
		this.existance_agr = existance_agr;
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
	public Date getDate_fin_frm() {
		return date_fin_frm;
	}
	public void setDate_fin_frm(Date date_fin_frm) {
		this.date_fin_frm = date_fin_frm;
	}
	public boolean isExistance_agr() {
		return existance_agr;
	}
	public void setExistance_agr(boolean existance_agr) {
		this.existance_agr = existance_agr;
	}
	public String getActivite() {
		return activite;
	}
	public void setActivite(String activite) {
		this.activite = activite;
	}

	

}
