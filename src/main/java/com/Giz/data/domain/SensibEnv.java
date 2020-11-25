package com.Giz.data.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SensibEnv")
public class SensibEnv {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_se;
	
	@Column(length = 30)
	private String code_village;
	
	private boolean exist_sens;
	
	private Date date_fin;
	
	@Column(length = 250)
	private String theme_sens;
	
	private int nbr_participant;
	
	private int nbr_homme;
	
	private int nbr_femme;

	/**
	 * 
	 */
	public SensibEnv() {
		// TODO Auto-generated constructor stub
	}

	public SensibEnv(Long id_se, String code_village, boolean exist_sens, Date date_fin, String theme_sens,
			int nbr_participant, int nbr_homme, int nbr_femme) {
		super();
		this.id_se = id_se;
		this.code_village = code_village;
		this.exist_sens = exist_sens;
		this.date_fin = date_fin;
		this.theme_sens = theme_sens;
		this.nbr_participant = nbr_participant;
		this.nbr_homme = nbr_homme;
		this.nbr_femme = nbr_femme;
	}

	public Long getId_se() {
		return id_se;
	}

	public void setId_se(Long id_se) {
		this.id_se = id_se;
	}

	public String getCode_village() {
		return code_village;
	}

	public void setCode_village(String code_village) {
		this.code_village = code_village;
	}

	public boolean isExist_sens() {
		return exist_sens;
	}

	public void setExist_sens(boolean exist_sens) {
		this.exist_sens = exist_sens;
	}

	public Date getDate_fin() {
		return date_fin;
	}

	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}

	public String getTheme_sens() {
		return theme_sens;
	}

	public void setTheme_sens(String theme_sens) {
		this.theme_sens = theme_sens;
	}

	public int getNbr_participant() {
		return nbr_participant;
	}

	public void setNbr_participant(int nbr_participant) {
		this.nbr_participant = nbr_participant;
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

	/**
	 * @param id_ai
	 * @param code_pro
	 * @param nomPrenom_ai
	 * @param genre_ai
	 * @param annee_naiss
	 * @param date_suivi
	 * @param type
	 */
	
}
