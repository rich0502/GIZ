package com.Giz.data.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "wp3_epp_fram")
public class Wp3EppFram {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 10)
	private String code_village;
	private String nom_ecole;
	private boolean projet_fram;
	private boolean projet_valide;
	private String type_projet;
	private Date date_validation;
	private String sexe;

	public Wp3EppFram() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Wp3EppFram(Long id, String code_village, String nom_ecole, boolean projet_fram, boolean projet_valide,
			String type_projet, Date date_validation) {
		super();
		this.id = id;
		this.code_village = code_village;
		this.nom_ecole = nom_ecole;
		this.projet_fram = projet_fram;
		this.projet_valide = projet_valide;
		this.type_projet = type_projet;
		this.date_validation = date_validation;
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

	public String getNom_ecole() {
		return nom_ecole;
	}

	public void setNom_ecole(String nom_ecole) {
		this.nom_ecole = nom_ecole;
	}

	public boolean isProjet_fram() {
		return projet_fram;
	}

	public void setProjet_fram(boolean projet_fram) {
		this.projet_fram = projet_fram;
	}

	public boolean isProjet_valide() {
		return projet_valide;
	}

	public void setProjet_valide(boolean projet_valide) {
		this.projet_valide = projet_valide;
	}

	public String getType_projet() {
		return type_projet;
	}

	public void setType_projet(String type_projet) {
		this.type_projet = type_projet;
	}

	public Date getDate_validation() {
		return date_validation;
	}

	public void setDate_validation(Date date_validation) {
		this.date_validation = date_validation;
	}

}
