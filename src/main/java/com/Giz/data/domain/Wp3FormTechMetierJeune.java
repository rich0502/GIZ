package com.Giz.data.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "wp3FormTechMetierJeune")
public class Wp3FormTechMetierJeune {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 10)
	private String code_village;
	
	@Column(length = 10)
	private String sexe;
	
	private int annee_naissance;
	
	@Column(length = 100)
	private String organisme_formateur;
	
	private Boolean formation_recue; 
	
	@Column(length = 50)
	private String theme;
	
	private Date date_fin;
	
	@Column(length = 90)
	private String etape_suivre;
	
	private Date date_realise;

	public Wp3FormTechMetierJeune() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Wp3FormTechMetierJeune(Long id, String code_village, String sexe, int annee_naissance,
			String organisme_formateur, Boolean formation_recue, String theme, Date date_fin, String etape_suivre,
			Date date_realise) {
		super();
		this.id = id;
		this.code_village = code_village;
		this.sexe = sexe;
		this.annee_naissance = annee_naissance;
		this.organisme_formateur = organisme_formateur;
		this.formation_recue = formation_recue;
		this.theme = theme;
		this.date_fin = date_fin;
		this.etape_suivre = etape_suivre;
		this.date_realise = date_realise;
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

	public Boolean getFormation_recue() {
		return formation_recue;
	}

	public void setFormation_recue(Boolean formation_recue) {
		this.formation_recue = formation_recue;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public Date getDate_fin() {
		return date_fin;
	}

	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}

	public String getEtape_suivre() {
		return etape_suivre;
	}

	public void setEtape_suivre(String etape_suivre) {
		this.etape_suivre = etape_suivre;
	}

	public Date getDate_realise() {
		return date_realise;
	}

	public void setDate_realise(Date date_realise) {
		this.date_realise = date_realise;
	}
	
	
	

}
