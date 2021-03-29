package com.Giz.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "parasite_maladie_divers")
public class Parasite_maladie_divers {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 40)
	private String code_prod;
	@Column(length = 3)
	private String constate;
	@Column(length = 40)
	private String nom_mp;
	@Column(length = 10)
	private String periode;
	@Column(length = 10)
	private String pourcentage;
	@Column(length = 3)
	private String traitement;
	@Column(length = 200)
	private String mecanique;
	@Column(length = 200)
	private String chimique;
	@Column(length = 70)
	private String chimique_qte;
	@Column(length = 70)
	private String biologique;
	@Column(length = 200)
	private String autre;
	@Column(length = 200)
	private String frequence;
	@Column(length = 200)
	private String effets;
	
	public Parasite_maladie_divers() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Parasite_maladie_divers(Long id, String code_prod, String constate, String nom_mp, String periode,
			String pourcentage, String traitement, String mecanique, String chimique, String chimique_qte,
			String biologique, String autre, String frequence, String effets) {
		super();
		this.id = id;
		this.code_prod = code_prod;
		this.constate = constate;
		this.nom_mp = nom_mp;
		this.periode = periode;
		this.pourcentage = pourcentage;
		this.traitement = traitement;
		this.mecanique = mecanique;
		this.chimique = chimique;
		this.chimique_qte = chimique_qte;
		this.biologique = biologique;
		this.autre = autre;
		this.frequence = frequence;
		this.effets = effets;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode_prod() {
		return code_prod;
	}
	public void setCode_prod(String code_prod) {
		this.code_prod = code_prod;
	}
	public String getConstate() {
		return constate;
	}
	public void setConstate(String constate) {
		this.constate = constate;
	}
	public String getNom_mp() {
		return nom_mp;
	}
	public void setNom_mp(String nom_mp) {
		this.nom_mp = nom_mp;
	}
	public String getPeriode() {
		return periode;
	}
	public void setPeriode(String periode) {
		this.periode = periode;
	}
	public String getPourcentage() {
		return pourcentage;
	}
	public void setPourcentage(String pourcentage) {
		this.pourcentage = pourcentage;
	}
	public String getTraitement() {
		return traitement;
	}
	public void setTraitement(String traitement) {
		this.traitement = traitement;
	}
	public String getMecanique() {
		return mecanique;
	}
	public void setMecanique(String mecanique) {
		this.mecanique = mecanique;
	}
	public String getChimique() {
		return chimique;
	}
	public void setChimique(String chimique) {
		this.chimique = chimique;
	}
	public String getChimique_qte() {
		return chimique_qte;
	}
	public void setChimique_qte(String chimique_qte) {
		this.chimique_qte = chimique_qte;
	}
	public String getBiologique() {
		return biologique;
	}
	public void setBiologique(String biologique) {
		this.biologique = biologique;
	}
	public String getAutre() {
		return autre;
	}
	public void setAutre(String autre) {
		this.autre = autre;
	}
	public String getFrequence() {
		return frequence;
	}
	public void setFrequence(String frequence) {
		this.frequence = frequence;
	}
	public String getEffets() {
		return effets;
	}
	public void setEffets(String effets) {
		this.effets = effets;
	}
	
	
}
