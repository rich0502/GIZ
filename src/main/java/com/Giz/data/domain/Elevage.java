package com.Giz.data.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "elevage")
public class Elevage {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_elev;
	
	@Column(length = 10)
	private String code_village;
	
	private float x;

	private float y;
	
	@Column(length = 150)
	private String nomResponsable ;
	
	@Column(length = 150)
	private String genre_elev;
	
	private int annee_naiss;
	
	@Column(length = 100)
	private String pratique_realise;
	
	private int date_mise;
	
	@Column(length = 100)
	private String tf;
	
	private double nbr_visiteur;
	
	private Date date_suivi;

	private boolean operationnel;

	public Elevage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Elevage(Long id_elev, String code_village, float x, float y, String nomResponsable, String genre_elev,
			int annee_naiss, String pratique_realise, int date_mise, String tf, double nbr_visiteur, Date date_suivi,
			boolean operationnel) {
		super();
		this.id_elev = id_elev;
		this.code_village = code_village;
		this.x = x;
		this.y = y;
		this.nomResponsable = nomResponsable;
		this.genre_elev = genre_elev;
		this.annee_naiss = annee_naiss;
		this.pratique_realise = pratique_realise;
		this.date_mise = date_mise;
		this.tf = tf;
		this.nbr_visiteur = nbr_visiteur;
		this.date_suivi = date_suivi;
		this.operationnel = operationnel;
	}

	public Long getId_elev() {
		return id_elev;
	}

	public void setId_elev(Long id_elev) {
		this.id_elev = id_elev;
	}

	public String getCode_village() {
		return code_village;
	}

	public void setCode_village(String code_village) {
		this.code_village = code_village;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public String getNomResponsable() {
		return nomResponsable;
	}

	public void setNomResponsable(String nomResponsable) {
		this.nomResponsable = nomResponsable;
	}

	public String getGenre_elev() {
		return genre_elev;
	}

	public void setGenre_elev(String genre_elev) {
		this.genre_elev = genre_elev;
	}

	public int getAnnee_naiss() {
		return annee_naiss;
	}

	public void setAnnee_naiss(int annee_naiss) {
		this.annee_naiss = annee_naiss;
	}

	public String getPratique_realise() {
		return pratique_realise;
	}

	public void setPratique_realise(String pratique_realise) {
		this.pratique_realise = pratique_realise;
	}

	public int getDate_mise() {
		return date_mise;
	}

	public void setDate_mise(int date_mise) {
		this.date_mise = date_mise;
	}

	public String getTf() {
		return tf;
	}

	public void setTf(String tf) {
		this.tf = tf;
	}

	public double getNbr_visiteur() {
		return nbr_visiteur;
	}

	public void setNbr_visiteur(double nbr_visiteur) {
		this.nbr_visiteur = nbr_visiteur;
	}

	public Date getDate_suivi() {
		return date_suivi;
	}

	public void setDate_suivi(Date date_suivi) {
		this.date_suivi = date_suivi;
	}

	public boolean isOperationnel() {
		return operationnel;
	}

	public void setOperationnel(boolean operationnel) {
		this.operationnel = operationnel;
	}
	
	
	
	
}
