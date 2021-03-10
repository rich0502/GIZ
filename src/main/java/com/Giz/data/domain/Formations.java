package com.Giz.data.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "formations")
public class Formations {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_forms;
	
	@Column(length = 30)
	private String code_village;
	
	@Column(length = 250)
	private String nom_eleveur;
	
	@Column(length = 20)
	private String genre_form;
	
	private int annee_naiss;
	
	@Column(length = 200)
	private String formation_recu;
	
	@Column(length = 200)
	private String theme_formation;
	
	private Date date_forma;
	
	private boolean adoption;
	
	@Column(length = 200)
	private String pratique_adopte;

	@Column(length = 200)
	private String type_formation;

	public Formations() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Formations(Long id_forms, String code_village, String nom_eleveur, String genre_form, int annee_naiss,
			String formation_recu, String theme_formation, Date date_forma, boolean adoption, String pratique_adopte,
			String type_formation) {
		super();
		this.id_forms = id_forms;
		this.code_village = code_village;
		this.nom_eleveur = nom_eleveur;
		this.genre_form = genre_form;
		this.annee_naiss = annee_naiss;
		this.formation_recu = formation_recu;
		this.theme_formation = theme_formation;
		this.date_forma = date_forma;
		this.adoption = adoption;
		this.pratique_adopte = pratique_adopte;
		this.type_formation = type_formation;
	}

	public Long getId_forms() {
		return id_forms;
	}

	public void setId_forms(Long id_forms) {
		this.id_forms = id_forms;
	}

	public String getCode_village() {
		return code_village;
	}

	public void setCode_village(String code_village) {
		this.code_village = code_village;
	}

	public String getNom_eleveur() {
		return nom_eleveur;
	}

	public void setNom_eleveur(String nom_eleveur) {
		this.nom_eleveur = nom_eleveur;
	}

	public String getGenre_form() {
		return genre_form;
	}

	public void setGenre_form(String genre_form) {
		this.genre_form = genre_form;
	}

	public int getAnnee_naiss() {
		return annee_naiss;
	}

	public void setAnnee_naiss(int annee_naiss) {
		this.annee_naiss = annee_naiss;
	}

	public String getFormation_recu() {
		return formation_recu;
	}

	public void setFormation_recu(String formation_recu) {
		this.formation_recu = formation_recu;
	}

	public String getTheme_formation() {
		return theme_formation;
	}

	public void setTheme_formation(String theme_formation) {
		this.theme_formation = theme_formation;
	}

	public Date getDate_forma() {
		return date_forma;
	}

	public void setDate_forma(Date date_forma) {
		this.date_forma = date_forma;
	}

	public boolean isAdoption() {
		return adoption;
	}

	public void setAdoption(boolean adoption) {
		this.adoption = adoption;
	}

	public String getPratique_adopte() {
		return pratique_adopte;
	}

	public void setPratique_adopte(String pratique_adopte) {
		this.pratique_adopte = pratique_adopte;
	}

	public String getType_formation() {
		return type_formation;
	}

	public void setType_formation(String type_formation) {
		this.type_formation = type_formation;
	}
	
	
}
