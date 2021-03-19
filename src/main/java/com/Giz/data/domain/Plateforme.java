package com.Giz.data.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Plateforme")
public class Plateforme extends Auditable<String> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_am;
	
	private String code_village;
	
	private boolean exist_platform;
	
	private boolean operationnel;
	
	private Date date_suivi;
	
	private String commentaire;
	
	private String type_plateform;
		
	/**
	 * 
	 */
	public Plateforme() {
		// TODO Auto-generated constructor stub
	}

	public Plateforme(Long id_am, String code_village, boolean exist_platform, boolean operationnel, Date date_suivi,
			String commentaire, String type_plateform) {
		super();
		this.id_am = id_am;
		this.code_village = code_village;
		this.exist_platform = exist_platform;
		this.operationnel = operationnel;
		this.date_suivi = date_suivi;
		this.commentaire = commentaire;
		this.type_plateform = type_plateform;
	}

	public Long getId_am() {
		return id_am;
	}

	public void setId_am(Long id_am) {
		this.id_am = id_am;
	}

	public String getCode_village() {
		return code_village;
	}

	public void setCode_village(String code_village) {
		this.code_village = code_village;
	}

	public boolean isExist_platform() {
		return exist_platform;
	}

	public void setExist_platform(boolean exist_platform) {
		this.exist_platform = exist_platform;
	}

	public boolean isOperationnel() {
		return operationnel;
	}

	public void setOperationnel(boolean operationnel) {
		this.operationnel = operationnel;
	}

	public Date getDate_suivi() {
		return date_suivi;
	}

	public void setDate_suivi(Date date_suivi) {
		this.date_suivi = date_suivi;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public String getType_plateform() {
		return type_plateform;
	}

	public void setType_plateform(String type_plateform) {
		this.type_plateform = type_plateform;
	}

	
}
