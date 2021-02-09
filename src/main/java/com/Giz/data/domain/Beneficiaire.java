package com.Giz.data.domain;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

public class Beneficiaire {
	String nom_prenom;
	String sexe;
	int annee_naissance;
	int age;
	String code_village;
	
	public String getNom_prenom() {
		return nom_prenom;
	}
	public void setNom_prenom(String nom_prenom) {
		this.nom_prenom = nom_prenom;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public int getAnnee_naissance() {
		return annee_naissance;
	}
	public void setAnnee_naissance(int annee_naissance) {
		this.annee_naissance = annee_naissance;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getCode_village() {
		return code_village;
	}
	public void setCode_village(String code_village) {
		this.code_village = code_village;
	}
	public Beneficiaire(String nom_prenom, String sexe, int annee_naissance, int age, String code_village) {
		super();
		this.nom_prenom = nom_prenom;
		this.sexe = sexe;
		this.annee_naissance = annee_naissance;
		this.age = age;
		this.code_village = code_village;
	}
	
	
	public Beneficiaire(String nom_prenom, String sexe, int annee_naissance,String code_village) {
		super();
		this.nom_prenom = nom_prenom;
		this.sexe = sexe;
		this.annee_naissance = annee_naissance;
		this.code_village = code_village;
	}
	public Beneficiaire() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	


}
