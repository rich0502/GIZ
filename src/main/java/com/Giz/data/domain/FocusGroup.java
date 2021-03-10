package com.Giz.data.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FocusGroup")
public class FocusGroup {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_fg;
	
	@Column(length = 30)
	private String code_village;
	
	private boolean realisation;
	
	@Column(length = 200)
	private String nomResp;
	
	@Column(length = 30)
	private String genre_fg;
	
	@Column(length = 100)
	private String risque_env;

	@Column(length = 250)
	private String mesure_prise;
	
	private Date date_fg;

	public FocusGroup() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FocusGroup(Long id_fg, String code_village, boolean realisation, String nomResp, String genre_fg,
			String risque_env, String mesure_prise, Date date_fg) {
		super();
		this.id_fg = id_fg;
		this.code_village = code_village;
		this.realisation = realisation;
		this.nomResp = nomResp;
		this.genre_fg = genre_fg;
		this.risque_env = risque_env;
		this.mesure_prise = mesure_prise;
		this.date_fg = date_fg;
	}

	public Long getId_fg() {
		return id_fg;
	}

	public void setId_fg(Long id_fg) {
		this.id_fg = id_fg;
	}

	public String getCode_village() {
		return code_village;
	}

	public void setCode_village(String code_village) {
		this.code_village = code_village;
	}

	public boolean isRealisation() {
		return realisation;
	}

	public void setRealisation(boolean realisation) {
		this.realisation = realisation;
	}

	public String getNomResp() {
		return nomResp;
	}

	public void setNomResp(String nomResp) {
		this.nomResp = nomResp;
	}

	public String getGenre_fg() {
		return genre_fg;
	}

	public void setGenre_fg(String genre_fg) {
		this.genre_fg = genre_fg;
	}

	public String getRisque_env() {
		return risque_env;
	}

	public void setRisque_env(String risque_env) {
		this.risque_env = risque_env;
	}

	public String getMesure_prise() {
		return mesure_prise;
	}

	public void setMesure_prise(String mesure_prise) {
		this.mesure_prise = mesure_prise;
	}

	public Date getDate_fg() {
		return date_fg;
	}

	public void setDate_fg(Date date_fg) {
		this.date_fg = date_fg;
	}
	
	
}
