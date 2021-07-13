package com.Giz.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "activite")
public class Activite {
	@Id
	private Long id_activite;
	@Column(length = 70)
	private String type_intervention;
	@Column(length = 70)
	private String theme_principal;
	@Column(length = 255)
	private String sous_theme;
	@Column(length = 70)
	private String date_enreg;
	@Column(length = 150)
	private String nom_utilisateur;
	@Column(length = 50)
	private String gps_lat;
	@Column(length = 50)
	private String gps_long;
	@Column(length = 70)
	private String formateur;
	@Column(length = 70)
	private String code_formateur;
	@Column(length = 15)
	private String lieu_formation;
	@Column(length = 255)
	private String prod_present;
	@Column(length = 255)
	private String prod_externe;
	@Column(length = 255)
	private String participant_externe;
	@Column(length = 150)
	private String image1;
	@Column(length = 150)
	private String image2;
	@Column(length = 150)
	private String image3;
	@Column(length = 255)
	private String remarques;
	public Activite() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Activite(Long id_activite, String type_intervention, String theme_principal, String sous_theme,
			String date_enreg, String nom_utilisateur, String gps_lat, String gps_long, String formateur,
			String code_formateur, String lieu_formation, String prod_present, String prod_externe,
			String participant_externe, String image1, String image2, String image3, String remarques) {
		super();
		this.id_activite = id_activite;
		this.type_intervention = type_intervention;
		this.theme_principal = theme_principal;
		this.sous_theme = sous_theme;
		this.date_enreg = date_enreg;
		this.nom_utilisateur = nom_utilisateur;
		this.gps_lat = gps_lat;
		this.gps_long = gps_long;
		this.formateur = formateur;
		this.code_formateur = code_formateur;
		this.lieu_formation = lieu_formation;
		this.prod_present = prod_present;
		this.prod_externe = prod_externe;
		this.participant_externe = participant_externe;
		this.image1 = image1;
		this.image2 = image2;
		this.image3 = image3;
		this.remarques = remarques;
	}
	public Long getId_activite() {
		return id_activite;
	}
	public void setId_activite(Long id_activite) {
		this.id_activite = id_activite;
	}
	public String getType_intervention() {
		return type_intervention;
	}
	public void setType_intervention(String type_intervention) {
		this.type_intervention = type_intervention;
	}
	public String getTheme_principal() {
		return theme_principal;
	}
	public void setTheme_principal(String theme_principal) {
		this.theme_principal = theme_principal;
	}
	public String getSous_theme() {
		return sous_theme;
	}
	public void setSous_theme(String sous_theme) {
		this.sous_theme = sous_theme;
	}
	public String getDate_enreg() {
		return date_enreg;
	}
	public void setDate_enreg(String date_enreg) {
		this.date_enreg = date_enreg;
	}
	public String getNom_utilisateur() {
		return nom_utilisateur;
	}
	public void setNom_utilisateur(String nom_utilisateur) {
		this.nom_utilisateur = nom_utilisateur;
	}
	public String getGps_lat() {
		return gps_lat;
	}
	public void setGps_lat(String gps_lat) {
		this.gps_lat = gps_lat;
	}
	public String getGps_long() {
		return gps_long;
	}
	public void setGps_long(String gps_long) {
		this.gps_long = gps_long;
	}
	public String getFormateur() {
		return formateur;
	}
	public void setFormateur(String formateur) {
		this.formateur = formateur;
	}
	public String getCode_formateur() {
		return code_formateur;
	}
	public void setCode_formateur(String code_formateur) {
		this.code_formateur = code_formateur;
	}
	public String getLieu_formation() {
		return lieu_formation;
	}
	public void setLieu_formation(String lieu_formation) {
		this.lieu_formation = lieu_formation;
	}
	public String getProd_present() {
		return prod_present;
	}
	public void setProd_present(String prod_present) {
		this.prod_present = prod_present;
	}
	public String getProd_externe() {
		return prod_externe;
	}
	public void setProd_externe(String prod_externe) {
		this.prod_externe = prod_externe;
	}
	public String getParticipant_externe() {
		return participant_externe;
	}
	public void setParticipant_externe(String participant_externe) {
		this.participant_externe = participant_externe;
	}
	public String getImage1() {
		return image1;
	}
	public void setImage1(String image1) {
		this.image1 = image1;
	}
	public String getImage2() {
		return image2;
	}
	public void setImage2(String image2) {
		this.image2 = image2;
	}
	public String getImage3() {
		return image3;
	}
	public void setImage3(String image3) {
		this.image3 = image3;
	}
	public String getRemarques() {
		return remarques;
	}
	public void setRemarques(String remarques) {
		this.remarques = remarques;
	}
	
	
}
