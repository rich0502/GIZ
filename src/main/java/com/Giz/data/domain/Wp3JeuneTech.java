package com.Giz.data.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "wp3_jeune_tech")
public class Wp3JeuneTech {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 10)
	private String code_village;
	private String organisme_formateur;
	private boolean frm_recue;

	private String theme_frm1;
	private Date date_fin_frm1;
	private String etape_frm1;
	private String sexe;
	/*
	 * private String theme_frm2; private Date date_real2; private String
	 * etape_frm2;
	 * 
	 * private String theme_frm3; private Date date_real3; private String
	 * etape_frm3;
	 */

	public Wp3JeuneTech() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Wp3JeuneTech(Long id, String code_village, String organisme_formateur, boolean frm_recue, String theme_frm1,
			Date date_fin_frm1, String etape_frm1) {
		super();
		this.id = id;
		this.code_village = code_village;
		this.organisme_formateur = organisme_formateur;
		this.frm_recue = frm_recue;
		this.theme_frm1 = theme_frm1;
		this.date_fin_frm1 = date_fin_frm1;
		this.etape_frm1 = etape_frm1;
	}
	
	

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
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

	public String getOrganisme_formateur() {
		return organisme_formateur;
	}

	public void setOrganisme_formateur(String organisme_formateur) {
		this.organisme_formateur = organisme_formateur;
	}

	public boolean isFrm_recue() {
		return frm_recue;
	}

	public void setFrm_recue(boolean frm_recue) {
		this.frm_recue = frm_recue;
	}

	public String getTheme_frm1() {
		return theme_frm1;
	}

	public void setTheme_frm1(String theme_frm1) {
		this.theme_frm1 = theme_frm1;
	}

	public Date getDate_fin_frm1() {
		return date_fin_frm1;
	}

	public void setDate_fin_frm1(Date date_fin_frm1) {
		this.date_fin_frm1 = date_fin_frm1;
	}

	public String getEtape_frm1() {
		return etape_frm1;
	}

	public void setEtape_frm1(String etape_frm1) {
		this.etape_frm1 = etape_frm1;
	}

}
