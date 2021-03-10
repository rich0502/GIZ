package com.Giz.data.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SupportVideo")
public class SupportVideo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_sv;

	@Column(length = 30)
	private String code_village;
	
	@Column(length = 150)
	private String nom_support;
	
	private Date date_dissemination;
	
	@Column(length = 200)
	private String receptionnaire;

	@Column(length = 30)
	private String genre_sv;
	
	@Column(length = 200)
	private String responsable;
	
	private Date date_suivi;

	public SupportVideo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SupportVideo(Long id_sv, String code_village, String nom_support, Date date_dissemination,
			String receptionnaire, String genre_sv, String responsable, Date date_suivi) {
		super();
		this.id_sv = id_sv;
		this.code_village = code_village;
		this.nom_support = nom_support;
		this.date_dissemination = date_dissemination;
		this.receptionnaire = receptionnaire;
		this.genre_sv = genre_sv;
		this.responsable = responsable;
		this.date_suivi = date_suivi;
	}

	public Long getId_sv() {
		return id_sv;
	}

	public void setId_sv(Long id_sv) {
		this.id_sv = id_sv;
	}

	public String getCode_village() {
		return code_village;
	}

	public void setCode_village(String code_village) {
		this.code_village = code_village;
	}

	public String getNom_support() {
		return nom_support;
	}

	public void setNom_support(String nom_support) {
		this.nom_support = nom_support;
	}

	public Date getDate_dissemination() {
		return date_dissemination;
	}

	public void setDate_dissemination(Date date_dissemination) {
		this.date_dissemination = date_dissemination;
	}

	public String getReceptionnaire() {
		return receptionnaire;
	}

	public void setReceptionnaire(String receptionnaire) {
		this.receptionnaire = receptionnaire;
	}

	public String getGenre_sv() {
		return genre_sv;
	}

	public void setGenre_sv(String genre_sv) {
		this.genre_sv = genre_sv;
	}

	public String getResponsable() {
		return responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	public Date getDate_suivi() {
		return date_suivi;
	}

	public void setDate_suivi(Date date_suivi) {
		this.date_suivi = date_suivi;
	}
	
	


}
