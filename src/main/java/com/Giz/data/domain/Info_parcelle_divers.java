package com.Giz.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "info_parcelle_divers")
public class Info_parcelle_divers {
	
	@Id
	private Long id;
	@Column(length = 40)
	private String code_prod;
	@Column(length = 150)
	private String type_culture;
	@Column(length = 150)
	private String nom_parcel;
	@Column(length = 8)
	private String periode_mise_culture;
	@Column(length = 150)
	private String periode_culture;
	@Column(length = 150)
	private String occupation_sol;
	@Column(length = 150)
	private String autre_occupation_sol;
	private float volume_annee_precedent;
	private float volume_annee_venir;
	private float surface_parcelle;
	private float rendement;
	private int nbr_pieds;
	@Column(length = 150)
	private String etape_visite;
	@Column(length = 150)
	private String systeme_protection_sol;
	@Column(length = 150)
	private String systeme_utilise;
	@Column(length = 150)
	private String associe_parcel;
	@Column(length = 150)
	private String autre_associe_parcel;
	@Column(length = 150)
	private String inclinaison;
	@Column(length = 150)
	private String mise_anti_errosif;
	@Column(length = 150)
	private String technic_use;
	@Column(length = 150)
	private String photo_technique;
	@Column(length = 150)
	private String photo_culture;
	
	public Info_parcelle_divers() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Info_parcelle_divers(Long id, String code_prod, String type_culture, String nom_parcel,
			String periode_mise_culture, String periode_culture, String occupation_sol, String autre_occupation_sol,
			float volume_annee_precedent, float volume_annee_venir, float surface_parcelle, float rendement,
			int nbr_pieds, String etape_visite, String systeme_protection_sol, String systeme_utilise,
			String associe_parcel, String autre_associe_parcel, String inclinaison, String mise_anti_errosif,
			String technic_use, String photo_technique, String photo_culture) {
		super();
		this.id = id;
		this.code_prod = code_prod;
		this.type_culture = type_culture;
		this.nom_parcel = nom_parcel;
		this.periode_mise_culture = periode_mise_culture;
		this.periode_culture = periode_culture;
		this.occupation_sol = occupation_sol;
		this.autre_occupation_sol = autre_occupation_sol;
		this.volume_annee_precedent = volume_annee_precedent;
		this.volume_annee_venir = volume_annee_venir;
		this.surface_parcelle = surface_parcelle;
		this.rendement = rendement;
		this.nbr_pieds = nbr_pieds;
		this.etape_visite = etape_visite;
		this.systeme_protection_sol = systeme_protection_sol;
		this.systeme_utilise = systeme_utilise;
		this.associe_parcel = associe_parcel;
		this.autre_associe_parcel = autre_associe_parcel;
		this.inclinaison = inclinaison;
		this.mise_anti_errosif = mise_anti_errosif;
		this.technic_use = technic_use;
		this.photo_technique = photo_technique;
		this.photo_culture = photo_culture;
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
	public String getType_culture() {
		return type_culture;
	}
	public void setType_culture(String type_culture) {
		this.type_culture = type_culture;
	}
	public String getNom_parcel() {
		return nom_parcel;
	}
	public void setNom_parcel(String nom_parcel) {
		this.nom_parcel = nom_parcel;
	}
	public String getPeriode_mise_culture() {
		return periode_mise_culture;
	}
	public void setPeriode_mise_culture(String periode_mise_culture) {
		this.periode_mise_culture = periode_mise_culture;
	}
	public String getPeriode_culture() {
		return periode_culture;
	}
	public void setPeriode_culture(String periode_culture) {
		this.periode_culture = periode_culture;
	}
	public String getOccupation_sol() {
		return occupation_sol;
	}
	public void setOccupation_sol(String occupation_sol) {
		this.occupation_sol = occupation_sol;
	}
	public String getAutre_occupation_sol() {
		return autre_occupation_sol;
	}
	public void setAutre_occupation_sol(String autre_occupation_sol) {
		this.autre_occupation_sol = autre_occupation_sol;
	}
	public float getVolume_annee_precedent() {
		return volume_annee_precedent;
	}
	public void setVolume_annee_precedent(float volume_annee_precedent) {
		this.volume_annee_precedent = volume_annee_precedent;
	}
	public float getVolume_annee_venir() {
		return volume_annee_venir;
	}
	public void setVolume_annee_venir(float volume_annee_venir) {
		this.volume_annee_venir = volume_annee_venir;
	}
	public float getSurface_parcelle() {
		return surface_parcelle;
	}
	public void setSurface_parcelle(float surface_parcelle) {
		this.surface_parcelle = surface_parcelle;
	}
	public float getRendement() {
		return rendement;
	}
	public void setRendement(float rendement) {
		this.rendement = rendement;
	}
	public int getNbr_pieds() {
		return nbr_pieds;
	}
	public void setNbr_pieds(int nbr_pieds) {
		this.nbr_pieds = nbr_pieds;
	}
	public String getEtape_visite() {
		return etape_visite;
	}
	public void setEtape_visite(String etape_visite) {
		this.etape_visite = etape_visite;
	}
	public String getSysteme_protection_sol() {
		return systeme_protection_sol;
	}
	public void setSysteme_protection_sol(String systeme_protection_sol) {
		this.systeme_protection_sol = systeme_protection_sol;
	}
	public String getSysteme_utilise() {
		return systeme_utilise;
	}
	public void setSysteme_utilise(String systeme_utilise) {
		this.systeme_utilise = systeme_utilise;
	}
	public String getAssocie_parcel() {
		return associe_parcel;
	}
	public void setAssocie_parcel(String associe_parcel) {
		this.associe_parcel = associe_parcel;
	}
	public String getAutre_associe_parcel() {
		return autre_associe_parcel;
	}
	public void setAutre_associe_parcel(String autre_associe_parcel) {
		this.autre_associe_parcel = autre_associe_parcel;
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
	public String getPhoto_culture() {
		return photo_culture;
	}
	public void setPhoto_culture(String photo_culture) {
		this.photo_culture = photo_culture;
	}
	
}
