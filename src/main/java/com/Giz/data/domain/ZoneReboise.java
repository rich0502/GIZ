package com.Giz.data.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ZoneReboise")
public class ZoneReboise {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_zr;
	
	@Column(length = 30)
	private String code_village;
	
	private boolean exist_zr;
	
	private float superficies;
	
	private int jeunePlant;
	
	private int NbrTotalJeune;
	
	private Date date_suivi;

	/**
	 * 
	 */
	public ZoneReboise() {
		// TODO Auto-generated constructor stub
	}

	public ZoneReboise(Long id_zr, String code_village, boolean exist_zr, float superficies, int jeunePlant,
			int nbrTotalJeune, Date date_suivi) {
		super();
		this.id_zr = id_zr;
		this.code_village = code_village;
		this.exist_zr = exist_zr;
		this.superficies = superficies;
		this.jeunePlant = jeunePlant;
		NbrTotalJeune = nbrTotalJeune;
		this.date_suivi = date_suivi;
	}

	public Long getId_zr() {
		return id_zr;
	}

	public void setId_zr(Long id_zr) {
		this.id_zr = id_zr;
	}

	public String getCode_village() {
		return code_village;
	}

	public void setCode_village(String code_village) {
		this.code_village = code_village;
	}

	public boolean isExist_zr() {
		return exist_zr;
	}

	public void setExist_zr(boolean exist_zr) {
		this.exist_zr = exist_zr;
	}

	public float getSuperficies() {
		return superficies;
	}

	public void setSuperficies(float superficies) {
		this.superficies = superficies;
	}

	public int getJeunePlant() {
		return jeunePlant;
	}

	public void setJeunePlant(int jeunePlant) {
		this.jeunePlant = jeunePlant;
	}

	public int getNbrTotalJeune() {
		return NbrTotalJeune;
	}

	public void setNbrTotalJeune(int nbrTotalJeune) {
		NbrTotalJeune = nbrTotalJeune;
	}

	public Date getDate_suivi() {
		return date_suivi;
	}

	public void setDate_suivi(Date date_suivi) {
		this.date_suivi = date_suivi;
	}

	
	
}
