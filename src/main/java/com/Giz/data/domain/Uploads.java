package com.Giz.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "uploads")
public class Uploads {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //this is where problem exists
	@Column(name = "id")
	private Long id;
	
	@Column(name = "chr_rappel")
	private String chr_rappel;
	
	@Column(name = "arret")
	private String arret;
	
	@Column(name = "auteur")
	private String auteur;
	
	@Column(name = "date_crea")
	private String date_crea;
	
	@Column(name = "date_modif")
	private String date_modif;
	
	@Column(name = "links_file")
	private String links_file;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the chr_rappel
	 */
	public String getChr_rappel() {
		return chr_rappel;
	}

	/**
	 * @param chr_rappel the chr_rappel to set
	 */
	public void setChr_rappel(String chr_rappel) {
		this.chr_rappel = chr_rappel;
	}

	/**
	 * @return the arret
	 */
	public String getArret() {
		return arret;
	}

	/**
	 * @param arret the arret to set
	 */
	public void setArret(String arret) {
		this.arret = arret;
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
