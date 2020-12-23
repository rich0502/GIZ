package com.Giz.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "storie")
public class Storie {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //this is where problem exists
	@Column(name = "id_str")
	private Long id_str;
	
	@Column(name = "nom_str")
	private String nom_str;
	
	@Column(name = "auteur")
	private String auteur;
	
	@Column(name = "date_crea")
	private String date_crea;
	
	@Column(name = "date_modif")
	private String date_modif;
	
	@Column(name = "links_file")
	private String links_file;

	public Long getId_str() {
		return id_str;
	}

	public void setId_str(Long id_str) {
		this.id_str = id_str;
	}

	public String getNom_str() {
		return nom_str;
	}

	public void setNom_str(String nom_str) {
		this.nom_str = nom_str;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public String getDate_crea() {
		return date_crea;
	}

	public void setDate_crea(String date_crea) {
		this.date_crea = date_crea;
	}

	public String getDate_modif() {
		return date_modif;
	}

	public void setDate_modif(String date_modif) {
		this.date_modif = date_modif;
	}

	public String getLinks_file() {
		return links_file;
	}

	public void setLinks_file(String links_file) {
		this.links_file = links_file;
	}
	
	
}
