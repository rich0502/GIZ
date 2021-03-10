package com.Giz.data.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "person_res")
public class Person_res {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_pr;
	
	@Column(length = 10)
	private String code_village;

	@Column(length = 200)
	private String nomPrenom;
	
	@Column(length = 20)
	private String genre_pr;
	
	private int annee_naiss;

	private boolean operationnalite;
	
	private Date date_suivi;
	
	@Column(length = 120)
	private String types_services_dev;
	

	public Person_res() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Person_res(Long id_pr, String code_village, String nomPrenom, String genre_pr, int annee_naiss,
			boolean operationnalite, Date date_suivi, String types_services_dev) {
		super();
		this.id_pr = id_pr;
		this.code_village = code_village;
		this.nomPrenom = nomPrenom;
		this.genre_pr = genre_pr;
		this.annee_naiss = annee_naiss;
		this.operationnalite = operationnalite;
		this.date_suivi = date_suivi;
		this.types_services_dev = types_services_dev;
	}


	public Long getId_pr() {
		return id_pr;
	}


	public void setId_pr(Long id_pr) {
		this.id_pr = id_pr;
	}


	public String getCode_village() {
		return code_village;
	}


	public void setCode_village(String code_village) {
		this.code_village = code_village;
	}


	public String getNomPrenom() {
		return nomPrenom;
	}


	public void setNomPrenom(String nomPrenom) {
		this.nomPrenom = nomPrenom;
	}


	public String getGenre_pr() {
		return genre_pr;
	}


	public void setGenre_pr(String genre_pr) {
		this.genre_pr = genre_pr;
	}


	public int getAnnee_naiss() {
		return annee_naiss;
	}


	public void setAnnee_naiss(int annee_naiss) {
		this.annee_naiss = annee_naiss;
	}


	public boolean isOperationnalite() {
		return operationnalite;
	}


	public void setOperationnalite(boolean operationnalite) {
		this.operationnalite = operationnalite;
	}


	public Date getDate_suivi() {
		return date_suivi;
	}


	public void setDate_suivi(Date date_suivi) {
		this.date_suivi = date_suivi;
	}


	public String getTypes_services_dev() {
		return types_services_dev;
	}


	public void setTypes_services_dev(String types_services_dev) {
		this.types_services_dev = types_services_dev;
	}


}
