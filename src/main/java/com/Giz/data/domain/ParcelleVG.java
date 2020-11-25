package com.Giz.data.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ParcelleVG")
public class ParcelleVG {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_pvg;
	
	@Column(length = 30)
	private String code_village;
	
	private float x;
	
	private float y;
	
	private boolean exist;
	
	@Column(length = 200)
	private String nomResp;
	
	@Column(length = 30)
	private String genre_pvg;

	private int annee_naiss;
	
	private boolean suivi_numeric;
	
	private boolean diffusion_resultat;
	
	private Date date_suivi;

	/**
	 * 
	 */
	public ParcelleVG() {
		// TODO Auto-generated constructor stub
	}

	public ParcelleVG(Long id_pvg, String code_village, float x, float y, boolean exist, String nomResp,
			String genre_pvg, int annee_naiss, boolean suivi_numeric, boolean diffusion_resultat, Date date_suivi) {
		super();
		this.id_pvg = id_pvg;
		this.code_village = code_village;
		this.x = x;
		this.y = y;
		this.exist = exist;
		this.nomResp = nomResp;
		this.genre_pvg = genre_pvg;
		this.annee_naiss = annee_naiss;
		this.suivi_numeric = suivi_numeric;
		this.diffusion_resultat = diffusion_resultat;
		this.date_suivi = date_suivi;
	}

	public Long getId_pvg() {
		return id_pvg;
	}

	public void setId_pvg(Long id_pvg) {
		this.id_pvg = id_pvg;
	}

	public String getCode_village() {
		return code_village;
	}

	public void setCode_village(String code_village) {
		this.code_village = code_village;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public boolean isExist() {
		return exist;
	}

	public void setExist(boolean exist) {
		this.exist = exist;
	}

	public String getNomResp() {
		return nomResp;
	}

	public void setNomResp(String nomResp) {
		this.nomResp = nomResp;
	}

	public String getGenre_pvg() {
		return genre_pvg;
	}

	public void setGenre_pvg(String genre_pvg) {
		this.genre_pvg = genre_pvg;
	}

	public int getAnnee_naiss() {
		return annee_naiss;
	}

	public void setAnnee_naiss(int annee_naiss) {
		this.annee_naiss = annee_naiss;
	}

	public boolean isSuivi_numeric() {
		return suivi_numeric;
	}

	public void setSuivi_numeric(boolean suivi_numeric) {
		this.suivi_numeric = suivi_numeric;
	}

	public boolean isDiffusion_resultat() {
		return diffusion_resultat;
	}

	public void setDiffusion_resultat(boolean diffusion_resultat) {
		this.diffusion_resultat = diffusion_resultat;
	}

	public Date getDate_suivi() {
		return date_suivi;
	}

	public void setDate_suivi(Date date_suivi) {
		this.date_suivi = date_suivi;
	}

	
	
	
}
