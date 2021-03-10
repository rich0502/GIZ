package com.Giz.data.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DocCap")
public class DocCap {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_dc;
	
	@Column(length = 200)
	private String titre_doc;
	
	@Column(length = 200)
	private String thematique;
	
	@Column(length = 100)
	private String type_doc;
	
	@Column(length = 150)
	private String auteur_doc;
	
	private Date date_partage;
	
	@Column(length = 150)
	private String reception;

	/**
	 * 
	 */
	public DocCap() {
		// TODO Auto-generated constructor stub
	}

	public DocCap(Long id_dc, String titre_doc, String thematique, String type_doc, String auteur_doc,
			Date date_partage, String reception) {
		super();
		this.id_dc = id_dc;
		this.titre_doc = titre_doc;
		this.thematique = thematique;
		this.type_doc = type_doc;
		this.auteur_doc = auteur_doc;
		this.date_partage = date_partage;
		this.reception = reception;
	}

	public Long getId_dc() {
		return id_dc;
	}

	public void setId_dc(Long id_dc) {
		this.id_dc = id_dc;
	}

	public String getTitre_doc() {
		return titre_doc;
	}

	public void setTitre_doc(String titre_doc) {
		this.titre_doc = titre_doc;
	}

	public String getThematique() {
		return thematique;
	}

	public void setThematique(String thematique) {
		this.thematique = thematique;
	}

	public String getType_doc() {
		return type_doc;
	}

	public void setType_doc(String type_doc) {
		this.type_doc = type_doc;
	}

	public String getAuteur_doc() {
		return auteur_doc;
	}

	public void setAuteur_doc(String auteur_doc) {
		this.auteur_doc = auteur_doc;
	}

	public Date getDate_partage() {
		return date_partage;
	}

	public void setDate_partage(Date date_partage) {
		this.date_partage = date_partage;
	}

	public String getReception() {
		return reception;
	}

	public void setReception(String reception) {
		this.reception = reception;
	}

	
	
}
