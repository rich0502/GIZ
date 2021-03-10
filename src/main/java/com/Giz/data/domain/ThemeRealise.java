package com.Giz.data.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ThemeRealise")
public class ThemeRealise {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_tr;
	
	
	@Column(length = 30)
	private String code_village;
	
	@Column(length = 100)
	private String epp_youth;
	
	private boolean env;
	
	@Column(length = 150)
	private String activites;
	
	private Date date_suivi;

	public ThemeRealise() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ThemeRealise(Long id_tr, String code_village, String epp_youth, boolean env, String activites,
			Date date_suivi) {
		super();
		this.id_tr = id_tr;
		this.code_village = code_village;
		this.epp_youth = epp_youth;
		this.env = env;
		this.activites = activites;
		this.date_suivi = date_suivi;
	}

	public Long getId_tr() {
		return id_tr;
	}

	public void setId_tr(Long id_tr) {
		this.id_tr = id_tr;
	}

	public String getCode_village() {
		return code_village;
	}

	public void setCode_village(String code_village) {
		this.code_village = code_village;
	}

	public String getEpp_youth() {
		return epp_youth;
	}

	public void setEpp_youth(String epp_youth) {
		this.epp_youth = epp_youth;
	}

	public boolean getEnv() {
		return env;
	}

	public void setEnv(boolean env) {
		this.env = env;
	}

	public String getActivites() {
		return activites;
	}

	public void setActivites(String activites) {
		this.activites = activites;
	}

	public Date getDate_suivi() {
		return date_suivi;
	}

	public void setDate_suivi(Date date_suivi) {
		this.date_suivi = date_suivi;
	}

	
}
