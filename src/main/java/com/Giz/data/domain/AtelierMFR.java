package com.Giz.data.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AtelierMFR")
public class AtelierMFR {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_am;
	
	@Column(length = 30)
	private String code_village;
	
	@Column(length = 200)
	private String atelier_resp;
	
	private Date date_realise;
	
	private String lieu_realise;
	
	@Column(length = 120)
	private String theme_choise;

	private long nbr_particip;
	
	private int nbr_homme;
	
	private int nbr_femme;
	
	@Column(length = 150)
	private String cible_atelier;
	
	@Column(length = 150)
	private String type_atelier;
		
	/**
	 * 
	 */
	public AtelierMFR() {
		// TODO Auto-generated constructor stub
	}

	public AtelierMFR(Long id_am, String code_village, String atelier_resp, Date date_realise, String lieu_realise,
			String theme_choise, long nbr_particip, int nbr_homme, int nbr_femme, String cible_atelier,
			String type_atelier) {
		super();
		this.id_am = id_am;
		this.code_village = code_village;
		this.atelier_resp = atelier_resp;
		this.date_realise = date_realise;
		this.lieu_realise = lieu_realise;
		this.theme_choise = theme_choise;
		this.nbr_particip = nbr_particip;
		this.nbr_homme = nbr_homme;
		this.nbr_femme = nbr_femme;
		this.cible_atelier = cible_atelier;
		this.type_atelier = type_atelier;
	}

	public Long getId_am() {
		return id_am;
	}

	public void setId_am(Long id_am) {
		this.id_am = id_am;
	}

	public String getCode_village() {
		return code_village;
	}

	public void setCode_village(String code_village) {
		this.code_village = code_village;
	}

	public String getAtelier_resp() {
		return atelier_resp;
	}

	public void setAtelier_resp(String atelier_resp) {
		this.atelier_resp = atelier_resp;
	}

	public Date getDate_realise() {
		return date_realise;
	}

	public void setDate_realise(Date date_realise) {
		this.date_realise = date_realise;
	}

	public String getLieu_realise() {
		return lieu_realise;
	}

	public void setLieu_realise(String lieu_realise) {
		this.lieu_realise = lieu_realise;
	}

	public String getTheme_choise() {
		return theme_choise;
	}

	public void setTheme_choise(String theme_choise) {
		this.theme_choise = theme_choise;
	}

	public long getNbr_particip() {
		return nbr_particip;
	}

	public void setNbr_particip(long nbr_particip) {
		this.nbr_particip = nbr_particip;
	}

	public int getNbr_homme() {
		return nbr_homme;
	}

	public void setNbr_homme(int nbr_homme) {
		this.nbr_homme = nbr_homme;
	}

	public int getNbr_femme() {
		return nbr_femme;
	}

	public void setNbr_femme(int nbr_femme) {
		this.nbr_femme = nbr_femme;
	}

	public String getCible_atelier() {
		return cible_atelier;
	}

	public void setCible_atelier(String cible_atelier) {
		this.cible_atelier = cible_atelier;
	}

	public String getType_atelier() {
		return type_atelier;
	}

	public void setType_atelier(String type_atelier) {
		this.type_atelier = type_atelier;
	}

	
}
