package com.Giz.data.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "parcelle_test")
public class Parcelle_test {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_pt;
	
	@Column(length = 30)
	private String code_village;
	
	private float x;

	private float y;
	
	@Column(length = 150)
	private String nomResponsable ;
	
	@Column(length = 150)
	private String genre_pt;
	
	private int annee_naiss;
	
	@Column(length = 100)
	private String pratique_realise;
	
	private Date date_mise;

	private float superficies;
	
	private boolean operationnel;
	
	private Date date_suivi;
	
	@Column(length = 150)
	private String technique_exergue;
	
	private long nbr_participant;
	
	private long nbr_homme;
	
	private long nbr_femme;
	
	@Column(length = 100)
	private String type;

	public Parcelle_test() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Parcelle_test(Long id_pt, String code_village, float x, float y, String nomResponsable, String genre_pt,
			int annee_naiss, String pratique_realise, Date date_mise, float superficies, boolean operationnel,
			Date date_suivi, String technique_exergue, long nbr_participant, long nbr_homme, long nbr_femme,
			String type) {
		super();
		this.id_pt = id_pt;
		this.code_village = code_village;
		this.x = x;
		this.y = y;
		this.nomResponsable = nomResponsable;
		this.genre_pt = genre_pt;
		this.annee_naiss = annee_naiss;
		this.pratique_realise = pratique_realise;
		this.date_mise = date_mise;
		this.superficies = superficies;
		this.operationnel = operationnel;
		this.date_suivi = date_suivi;
		this.technique_exergue = technique_exergue;
		this.nbr_participant = nbr_participant;
		this.nbr_homme = nbr_homme;
		this.nbr_femme = nbr_femme;
		this.type = type;
	}

	public Long getId_pt() {
		return id_pt;
	}

	public void setId_pt(Long id_pt) {
		this.id_pt = id_pt;
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

	public String getGenre_pt() {
		return genre_pt;
	}

	public void setGenre_pt(String genre_pt) {
		this.genre_pt = genre_pt;
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

	public Date getDate_mise() {
		return date_mise;
	}

	public void setDate_mise(Date date_mise) {
		this.date_mise = date_mise;
	}

	public float getSuperficies() {
		return superficies;
	}

	public void setSuperficies(float superficies) {
		this.superficies = superficies;
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

	public String getTechnique_exergue() {
		return technique_exergue;
	}

	public void setTechnique_exergue(String technique_exergue) {
		this.technique_exergue = technique_exergue;
	}

	public long getNbr_participant() {
		return nbr_participant;
	}

	public void setNbr_participant(long nbr_participant) {
		this.nbr_participant = nbr_participant;
	}

	public long getNbr_homme() {
		return nbr_homme;
	}

	public void setNbr_homme(long nbr_homme) {
		this.nbr_homme = nbr_homme;
	}

	public long getNbr_femme() {
		return nbr_femme;
	}

	public void setNbr_femme(long nbr_femme) {
		this.nbr_femme = nbr_femme;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	
}
