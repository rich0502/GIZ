package com.Giz.data.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "wp3_unite_elev_jeune")
public class Wp3UniteElevJeune extends Auditable<String> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 10)
	private String code_village;
	private String nom_prenom;
	@Column(length = 10)
	private String sexe;
	private int annee_naissance;
	private boolean demarrage_unite;
	private Date date_dem;
	private String type_activite;

	private String theme1_traite;
	private Date date_suivi1;
	private String activite;
	
	public Wp3UniteElevJeune() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Wp3UniteElevJeune(Long id, String code_village, String nom_prenom, String sexe, int annee_naissance,
			boolean demarrage_unite, Date date_dem, String type_activite, String theme1_traite, Date date_suivi1,
			String activite) {
		super();
		this.id = id;
		this.code_village = code_village;
		this.nom_prenom = nom_prenom;
		this.sexe = sexe;
		this.annee_naissance = annee_naissance;
		this.demarrage_unite = demarrage_unite;
		this.date_dem = date_dem;
		this.type_activite = type_activite;
		this.theme1_traite = theme1_traite;
		this.date_suivi1 = date_suivi1;
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

	public boolean isDemarrage_unite() {
		return demarrage_unite;
	}

	public void setDemarrage_unite(boolean demarrage_unite) {
		this.demarrage_unite = demarrage_unite;
	}

	public Date getDate_dem() {
		return date_dem;
	}

	public void setDate_dem(Date date_dem) {
		this.date_dem = date_dem;
	}

	public String getType_activite() {
		return type_activite;
	}

	public void setType_activite(String type_activite) {
		this.type_activite = type_activite;
	}

	public String getTheme1_traite() {
		return theme1_traite;
	}

	public void setTheme1_traite(String theme1_traite) {
		this.theme1_traite = theme1_traite;
	}

	public Date getDate_suivi1() {
		return date_suivi1;
	}

	public void setDate_suivi1(Date date_suivi1) {
		this.date_suivi1 = date_suivi1;
	}

	public String getActivite() {
		return activite;
	}

	public void setActivite(String activite) {
		this.activite = activite;
	}
	
}
