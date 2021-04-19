package com.Giz.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "info_parcelle")
public class Info_parcelle {
	@Id
	private Long id;
	@Column(length = 40)
	private String code_prod;
	@Column(length = 250)
	private String nom_parcel;
	@Column(length = 4)
	private String annee_plan_liane;
	private int nbr_liane;
	@Column(length = 255)
	private String recolt_estime;
	private float surf_parcel;
	private int nbr_liane_total;
	private float rende_parcel;
	private int vol_anne_prec;
	@Column(length = 200)
	private String culture_asocie;
	@Column(length = 200)
	private String asocie_autre;
	@Column(length = 250)
	private String inclinaison;
	@Column(length = 3)
	private String mise_anti_errosif;
	@Column(length = 250)
	private String technic_use;
	@Column(length = 255)
	private String photo_technique;
	@Column(length = 25)
	private String qualite_ombrage;
	@Column(length = 25)
	private String couverture_vegetal;
	@Column(length = 250)
	private String avant;
	@Column(length = 255)
	private String provien_liane;
	@Column(length = 250)
	private String spec_autre;
	@Column(length = 255)
	private String photo_parcelle;
	
	public Info_parcelle() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Info_parcelle(Long id, String code_prod, String nom_parcel, String annee_plan_liane, int nbr_liane,
			String recolt_estime, float surf_parcel, int nbr_liane_total, float rende_parcel, int vol_anne_prec,
			String culture_asocie, String asocie_autre, String inclinaison, String mise_anti_errosif,
			String technic_use, String photo_technique, String qualite_ombrage, String couverture_vegetal, String avant,
			String provien_liane, String spec_autre, String photo_parcelle) {
		super();
		this.id = id;
		this.code_prod = code_prod;
		this.nom_parcel = nom_parcel;
		this.annee_plan_liane = annee_plan_liane;
		this.nbr_liane = nbr_liane;
		this.recolt_estime = recolt_estime;
		this.surf_parcel = surf_parcel;
		this.nbr_liane_total = nbr_liane_total;
		this.rende_parcel = rende_parcel;
		this.vol_anne_prec = vol_anne_prec;
		this.culture_asocie = culture_asocie;
		this.asocie_autre = asocie_autre;
		this.inclinaison = inclinaison;
		this.mise_anti_errosif = mise_anti_errosif;
		this.technic_use = technic_use;
		this.photo_technique = photo_technique;
		this.qualite_ombrage = qualite_ombrage;
		this.couverture_vegetal = couverture_vegetal;
		this.avant = avant;
		this.provien_liane = provien_liane;
		this.spec_autre = spec_autre;
		this.photo_parcelle = photo_parcelle;
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
	public String getNom_parcel() {
		return nom_parcel;
	}
	public void setNom_parcel(String nom_parcel) {
		this.nom_parcel = nom_parcel;
	}
	public String getAnnee_plan_liane() {
		return annee_plan_liane;
	}
	public void setAnnee_plan_liane(String annee_plan_liane) {
		this.annee_plan_liane = annee_plan_liane;
	}
	public int getNbr_liane() {
		return nbr_liane;
	}
	public void setNbr_liane(int nbr_liane) {
		this.nbr_liane = nbr_liane;
	}
	public String getRecolt_estime() {
		return recolt_estime;
	}
	public void setRecolt_estime(String recolt_estime) {
		this.recolt_estime = recolt_estime;
	}
	public float getSurf_parcel() {
		return surf_parcel;
	}
	public void setSurf_parcel(float surf_parcel) {
		this.surf_parcel = surf_parcel;
	}
	public int getNbr_liane_total() {
		return nbr_liane_total;
	}
	public void setNbr_liane_total(int nbr_liane_total) {
		this.nbr_liane_total = nbr_liane_total;
	}
	public float getRende_parcel() {
		return rende_parcel;
	}
	public void setRende_parcel(float rende_parcel) {
		this.rende_parcel = rende_parcel;
	}
	public int getVol_anne_prec() {
		return vol_anne_prec;
	}
	public void setVol_anne_prec(int vol_anne_prec) {
		this.vol_anne_prec = vol_anne_prec;
	}
	public String getCulture_asocie() {
		return culture_asocie;
	}
	public void setCulture_asocie(String culture_asocie) {
		this.culture_asocie = culture_asocie;
	}
	public String getAsocie_autre() {
		return asocie_autre;
	}
	public void setAsocie_autre(String asocie_autre) {
		this.asocie_autre = asocie_autre;
	}
	public String getInclinaison() {
		return inclinaison;
	}
	public void setInclinaison(String inclinaison) {
		this.inclinaison = inclinaison;
	}
	public String getMise_anti_errosif() {
		return mise_anti_errosif;
	}
	public void setMise_anti_errosif(String mise_anti_errosif) {
		this.mise_anti_errosif = mise_anti_errosif;
	}
	public String getTechnic_use() {
		return technic_use;
	}
	public void setTechnic_use(String technic_use) {
		this.technic_use = technic_use;
	}
	public String getPhoto_technique() {
		return photo_technique;
	}
	public void setPhoto_technique(String photo_technique) {
		this.photo_technique = photo_technique;
	}
	public String getQualite_ombrage() {
		return qualite_ombrage;
	}
	public void setQualite_ombrage(String qualite_ombrage) {
		this.qualite_ombrage = qualite_ombrage;
	}
	public String getCouverture_vegetal() {
		return couverture_vegetal;
	}
	public void setCouverture_vegetal(String couverture_vegetal) {
		this.couverture_vegetal = couverture_vegetal;
	}
	public String getAvant() {
		return avant;
	}
	public void setAvant(String avant) {
		this.avant = avant;
	}
	public String getProvien_liane() {
		return provien_liane;
	}
	public void setProvien_liane(String provien_liane) {
		this.provien_liane = provien_liane;
	}
	public String getSpec_autre() {
		return spec_autre;
	}
	public void setSpec_autre(String spec_autre) {
		this.spec_autre = spec_autre;
	}
	public String getPhoto_parcelle() {
		return photo_parcelle;
	}
	public void setPhoto_parcelle(String photo_parcelle) {
		this.photo_parcelle = photo_parcelle;
	}
	
}
