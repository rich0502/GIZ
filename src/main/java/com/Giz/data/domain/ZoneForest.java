package com.Giz.data.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ZoneForest")
public class ZoneForest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_zf;
	
	@Column(length = 30)
	private String code_village;
	
	private boolean exist_zn;
	
	private float superficies;
	
	private Date date_suivi;
	
	

	/**
	 * 
	 */
	public ZoneForest() {
		// TODO Auto-generated constructor stub
	}



	public ZoneForest(Long id_zf, String code_village, boolean exist_zn, float superficies, Date date_suivi) {
		super();
		this.id_zf = id_zf;
		this.code_village = code_village;
		this.exist_zn = exist_zn;
		this.superficies = superficies;
		this.date_suivi = date_suivi;
	}



	public Long getId_zf() {
		return id_zf;
	}



	public void setId_zf(Long id_zf) {
		this.id_zf = id_zf;
	}



	public String getCode_village() {
		return code_village;
	}



	public void setCode_village(String code_village) {
		this.code_village = code_village;
	}



	public boolean isExist_zn() {
		return exist_zn;
	}



	public void setExist_zn(boolean exist_zn) {
		this.exist_zn = exist_zn;
	}



	public float getSuperficies() {
		return superficies;
	}



	public void setSuperficies(float superficies) {
		this.superficies = superficies;
	}



	public Date getDate_suivi() {
		return date_suivi;
	}



	public void setDate_suivi(Date date_suivi) {
		this.date_suivi = date_suivi;
	}

	
	
}
