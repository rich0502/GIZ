package com.Giz.data.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Cooperative")
public class Cooperative {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_coop;
	
	@Column(length = 30)
	private String code_village;
	
	private boolean exist;
	
	@Column(length = 150)
	private String nom_coop;
	
	private Date date_creation ;
	
	private boolean socio;
	
	private boolean environnement;
	
	private Date date_suivi;

	public Cooperative() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cooperative(Long id_coop, String code_village, boolean exist, String nom_coop, Date date_creation,
			boolean socio, boolean environnement, Date date_suivi) {
		super();
		this.id_coop = id_coop;
		this.code_village = code_village;
		this.exist = exist;
		this.nom_coop = nom_coop;
		this.date_creation = date_creation;
		this.socio = socio;
		this.environnement = environnement;
		this.date_suivi = date_suivi;
	}

	public Long getId_coop() {
		return id_coop;
	}

	public void setId_coop(Long id_coop) {
		this.id_coop = id_coop;
	}

	public String getCode_village() {
		return code_village;
	}

	public void setCode_village(String code_village) {
		this.code_village = code_village;
	}

	public boolean isExist() {
		return exist;
	}

	public void setExist(boolean exist) {
		this.exist = exist;
	}

	public String getNom_coop() {
		return nom_coop;
	}

	public void setNom_coop(String nom_coop) {
		this.nom_coop = nom_coop;
	}

	public Date getDate_creation() {
		return date_creation;
	}

	public void setDate_creation(Date date_creation) {
		this.date_creation = date_creation;
	}

	public boolean isSocio() {
		return socio;
	}

	public void setSocio(boolean socio) {
		this.socio = socio;
	}

	public boolean isEnvironnement() {
		return environnement;
	}

	public void setEnvironnement(boolean environnement) {
		this.environnement = environnement;
	}

	public Date getDate_suivi() {
		return date_suivi;
	}

	public void setDate_suivi(Date date_suivi) {
		this.date_suivi = date_suivi;
	}
	
	
	
}
