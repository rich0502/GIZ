package com.Giz.data.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Concours")
public class Concours {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_con;
	
	@Column(length = 30)
	private String code_village;
	
	private boolean exist;
	
	private Date date_eval;
	
	private Date date_suivi;

	public Concours() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Concours(Long id_con, String code_village, boolean exist, Date date_eval, Date date_suivi) {
		super();
		this.id_con = id_con;
		this.code_village = code_village;
		this.exist = exist;
		this.date_eval = date_eval;
		this.date_suivi = date_suivi;
	}

	public Long getId_con() {
		return id_con;
	}

	public void setId_con(Long id_con) {
		this.id_con = id_con;
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

	public Date getDate_eval() {
		return date_eval;
	}

	public void setDate_eval(Date date_eval) {
		this.date_eval = date_eval;
	}

	public Date getDate_suivi() {
		return date_suivi;
	}

	public void setDate_suivi(Date date_suivi) {
		this.date_suivi = date_suivi;
	}
	
	
}
