package com.Giz.data.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "valider")
public class Valider {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //this is where problem exists
	@Column(name = "id")
	private Long id;
	
	@Column(name = "code_village")
	private String code_village;
	
	@Column(name = "district")
	private String district;
	
	@Column(name = "nom_group_l_telo")
	private String nom_group_l_telo;
	
	@Column(name = "categorie")
	private String categorie;
	
	@Column(name = "date_creation")
	private Date date_creation;
	
	@Column(name = "effectif_membre")
	private String effectif_membre;
	
	@Column(name = "sexe")
	private String sexe;
	
	@Column(name = "operationnel")
	private boolean operationnel;
	
	@Column(name = "date_suivi")
	private Date date_suivi;
	
	@Column(name = "nom_vsla")
	private String nom_vsla;
	
	@Column(name = "annee_creation")
	private int annee_creation;
	
	@Column(name = "vsla_lier_regionale")
	private boolean vsla_lier_regionale;
	
	@Column(name = "appuis_reçus")
	private boolean appuis_reçus;
	
	@Column(name = "type_appui")
	private String type_appui;
	
	@Column(name = "fbs_post_fbs_reçus")
	private boolean fbs_post_fbs_reçus;
	
	@Column(name = "education_fbs_post_fbs")
	private boolean education_fbs_post_fbs;
	
	@Column(name = "code_prod")
	private String code_prod;
	
	@Column(name = "nom_prenom")
	private String nom_prenom;
	
	@Column(name = "annee_naissance")
	private int annee_naissance;
	
	@Column(name = "service_mobile_money")
	private boolean service_mobile_money;
	
	@Column(name = "orange_money")
	private boolean orange_money;
	
	@Column(name = "mvola")
	private boolean mvola;
	
	@Column(name = "airtel_money")
	private boolean airtel_money;
	
	@Column(name = "service_IMF")
	private boolean service_IMF;
	
	@Column(name = "institution")
	private String institution;
	
	@Column(name = "lieu_agence")
	private String lieu_agence;
	
	@Column(name = "num_adhesion")
	private String num_adhesion;
	
	@Column(name = "nom_beneficiaire")
	private String nom_beneficiaire;
	
	@Column(name = "nom_usuel_adherent")
	private String nom_usuel_adherent;
	
	@Column(name = "contact")
	private String contact;
	
	@Column(name = "age")
	private int age;
	
	@Column(name = "date_naiss")
	private Date date_naiss;
	
	@Column(name = "cin")
	private String cin;
	
	@Column(name = "code_pro_symrise")
	private String code_pro_symrise;
	
	@Column(name = "commune")
	private String commune;
	
	@Column(name = "adresse_fkt")
	private String adresse_fkt;
	
	@Column(name = "affiliation")
	private String affiliation;
	
	@Column(name = "ma_1ere_adhesion")
	private String ma_1ere_adhesion;
	
	@Column(name = "nbr_pers_charge")
	private int nbr_pers_charge;
	
	@Column(name = "canevas")
	private String canevas;

	public Valider(Long id, String code_village, String district, String nom_group_l_telo, String categorie,
			Date date_creation, String effectif_membre, String sexe, boolean operationnel, Date date_suivi,
			String nom_vsla, int annee_creation, boolean vsla_lier_regionale, boolean appuis_reçus, String type_appui,
			boolean fbs_post_fbs_reçus, boolean education_fbs_post_fbs, String code_prod, String nom_prenom,
			int annee_naissance, boolean service_mobile_money, boolean orange_money, boolean mvola,
			boolean airtel_money, boolean service_IMF, String institution, String lieu_agence, String num_adhesion,
			String nom_beneficiaire, String nom_usuel_adherent, String contact, int age, Date date_naiss, String cin,
			String code_pro_symrise, String commune, String adresse_fkt, String affiliation, String ma_1ere_adhesion,
			int nbr_pers_charge, String canevas) {
		super();
		this.id = id;
		this.code_village = code_village;
		this.district = district;
		this.nom_group_l_telo = nom_group_l_telo;
		this.categorie = categorie;
		this.date_creation = date_creation;
		this.effectif_membre = effectif_membre;
		this.sexe = sexe;
		this.operationnel = operationnel;
		this.date_suivi = date_suivi;
		this.nom_vsla = nom_vsla;
		this.annee_creation = annee_creation;
		this.vsla_lier_regionale = vsla_lier_regionale;
		this.appuis_reçus = appuis_reçus;
		this.type_appui = type_appui;
		this.fbs_post_fbs_reçus = fbs_post_fbs_reçus;
		this.education_fbs_post_fbs = education_fbs_post_fbs;
		this.code_prod = code_prod;
		this.nom_prenom = nom_prenom;
		this.annee_naissance = annee_naissance;
		this.service_mobile_money = service_mobile_money;
		this.orange_money = orange_money;
		this.mvola = mvola;
		this.airtel_money = airtel_money;
		this.service_IMF = service_IMF;
		this.institution = institution;
		this.lieu_agence = lieu_agence;
		this.num_adhesion = num_adhesion;
		this.nom_beneficiaire = nom_beneficiaire;
		this.nom_usuel_adherent = nom_usuel_adherent;
		this.contact = contact;
		this.age = age;
		this.date_naiss = date_naiss;
		this.cin = cin;
		this.code_pro_symrise = code_pro_symrise;
		this.commune = commune;
		this.adresse_fkt = adresse_fkt;
		this.affiliation = affiliation;
		this.ma_1ere_adhesion = ma_1ere_adhesion;
		this.nbr_pers_charge = nbr_pers_charge;
		this.canevas = canevas;
	}

	public String getCanevas() {
		return canevas;
	}

	public void setCanevas(String canevas) {
		this.canevas = canevas;
	}

	public Valider() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Valider(Long id, String code_village, String district, String nom_group_l_telo, String categorie,
			Date date_creation, String effectif_membre, String sexe, boolean operationnel, Date date_suivi,
			String nom_vsla, int annee_creation, boolean vsla_lier_regionale, boolean appuis_reçus, String type_appui,
			boolean fbs_post_fbs_reçus, boolean education_fbs_post_fbs, String code_prod, String nom_prenom,
			int annee_naissance, boolean service_mobile_money, boolean orange_money, boolean mvola,
			boolean airtel_money, boolean service_IMF, String institution, String lieu_agence, String num_adhesion,
			String nom_beneficiaire, String nom_usuel_adherent, String contact, int age, Date date_naiss, String cin,
			String code_pro_symrise, String commune, String adresse_fkt, String affiliation, String ma_1ere_adhesion,
			int nbr_pers_charge) {
		super();
		this.id = id;
		this.code_village = code_village;
		this.district = district;
		this.nom_group_l_telo = nom_group_l_telo;
		this.categorie = categorie;
		this.date_creation = date_creation;
		this.effectif_membre = effectif_membre;
		this.sexe = sexe;
		this.operationnel = operationnel;
		this.date_suivi = date_suivi;
		this.nom_vsla = nom_vsla;
		this.annee_creation = annee_creation;
		this.vsla_lier_regionale = vsla_lier_regionale;
		this.appuis_reçus = appuis_reçus;
		this.type_appui = type_appui;
		this.fbs_post_fbs_reçus = fbs_post_fbs_reçus;
		this.education_fbs_post_fbs = education_fbs_post_fbs;
		this.code_prod = code_prod;
		this.nom_prenom = nom_prenom;
		this.annee_naissance = annee_naissance;
		this.service_mobile_money = service_mobile_money;
		this.orange_money = orange_money;
		this.mvola = mvola;
		this.airtel_money = airtel_money;
		this.service_IMF = service_IMF;
		this.institution = institution;
		this.lieu_agence = lieu_agence;
		this.num_adhesion = num_adhesion;
		this.nom_beneficiaire = nom_beneficiaire;
		this.nom_usuel_adherent = nom_usuel_adherent;
		this.contact = contact;
		this.age = age;
		this.date_naiss = date_naiss;
		this.cin = cin;
		this.code_pro_symrise = code_pro_symrise;
		this.commune = commune;
		this.adresse_fkt = adresse_fkt;
		this.affiliation = affiliation;
		this.ma_1ere_adhesion = ma_1ere_adhesion;
		this.nbr_pers_charge = nbr_pers_charge;
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

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getNom_group_l_telo() {
		return nom_group_l_telo;
	}

	public void setNom_group_l_telo(String nom_group_l_telo) {
		this.nom_group_l_telo = nom_group_l_telo;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public Date getDate_creation() {
		return date_creation;
	}

	public void setDate_creation(Date date_creation) {
		this.date_creation = date_creation;
	}

	public String getEffectif_membre() {
		return effectif_membre;
	}

	public void setEffectif_membre(String effectif_membre) {
		this.effectif_membre = effectif_membre;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
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

	public String getNom_vsla() {
		return nom_vsla;
	}

	public void setNom_vsla(String nom_vsla) {
		this.nom_vsla = nom_vsla;
	}

	public int getAnnee_creation() {
		return annee_creation;
	}

	public void setAnnee_creation(int annee_creation) {
		this.annee_creation = annee_creation;
	}

	public boolean isVsla_lier_regionale() {
		return vsla_lier_regionale;
	}

	public void setVsla_lier_regionale(boolean vsla_lier_regionale) {
		this.vsla_lier_regionale = vsla_lier_regionale;
	}

	public boolean isAppuis_reçus() {
		return appuis_reçus;
	}

	public void setAppuis_reçus(boolean appuis_reçus) {
		this.appuis_reçus = appuis_reçus;
	}

	public String getType_appui() {
		return type_appui;
	}

	public void setType_appui(String type_appui) {
		this.type_appui = type_appui;
	}

	public boolean isFbs_post_fbs_reçus() {
		return fbs_post_fbs_reçus;
	}

	public void setFbs_post_fbs_reçus(boolean fbs_post_fbs_reçus) {
		this.fbs_post_fbs_reçus = fbs_post_fbs_reçus;
	}

	public boolean isEducation_fbs_post_fbs() {
		return education_fbs_post_fbs;
	}

	public void setEducation_fbs_post_fbs(boolean education_fbs_post_fbs) {
		this.education_fbs_post_fbs = education_fbs_post_fbs;
	}

	public String getCode_prod() {
		return code_prod;
	}

	public void setCode_prod(String code_prod) {
		this.code_prod = code_prod;
	}

	public String getNom_prenom() {
		return nom_prenom;
	}

	public void setNom_prenom(String nom_prenom) {
		this.nom_prenom = nom_prenom;
	}

	public int getAnnee_naissance() {
		return annee_naissance;
	}

	public void setAnnee_naissance(int annee_naissance) {
		this.annee_naissance = annee_naissance;
	}

	public boolean isService_mobile_money() {
		return service_mobile_money;
	}

	public void setService_mobile_money(boolean service_mobile_money) {
		this.service_mobile_money = service_mobile_money;
	}

	public boolean isOrange_money() {
		return orange_money;
	}

	public void setOrange_money(boolean orange_money) {
		this.orange_money = orange_money;
	}

	public boolean isMvola() {
		return mvola;
	}

	public void setMvola(boolean mvola) {
		this.mvola = mvola;
	}

	public boolean isAirtel_money() {
		return airtel_money;
	}

	public void setAirtel_money(boolean airtel_money) {
		this.airtel_money = airtel_money;
	}

	public boolean isService_IMF() {
		return service_IMF;
	}

	public void setService_IMF(boolean service_IMF) {
		this.service_IMF = service_IMF;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public String getLieu_agence() {
		return lieu_agence;
	}

	public void setLieu_agence(String lieu_agence) {
		this.lieu_agence = lieu_agence;
	}

	public String getNum_adhesion() {
		return num_adhesion;
	}

	public void setNum_adhesion(String num_adhesion) {
		this.num_adhesion = num_adhesion;
	}

	public String getNom_beneficiaire() {
		return nom_beneficiaire;
	}

	public void setNom_beneficiaire(String nom_beneficiaire) {
		this.nom_beneficiaire = nom_beneficiaire;
	}

	public String getNom_usuel_adherent() {
		return nom_usuel_adherent;
	}

	public void setNom_usuel_adherent(String nom_usuel_adherent) {
		this.nom_usuel_adherent = nom_usuel_adherent;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getDate_naiss() {
		return date_naiss;
	}

	public void setDate_naiss(Date date_naiss) {
		this.date_naiss = date_naiss;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getCode_pro_symrise() {
		return code_pro_symrise;
	}

	public void setCode_pro_symrise(String code_pro_symrise) {
		this.code_pro_symrise = code_pro_symrise;
	}

	public String getCommune() {
		return commune;
	}

	public void setCommune(String commune) {
		this.commune = commune;
	}

	public String getAdresse_fkt() {
		return adresse_fkt;
	}

	public void setAdresse_fkt(String adresse_fkt) {
		this.adresse_fkt = adresse_fkt;
	}

	public String getAffiliation() {
		return affiliation;
	}

	public void setAffiliation(String affiliation) {
		this.affiliation = affiliation;
	}

	public String getMa_1ere_adhesion() {
		return ma_1ere_adhesion;
	}

	public void setMa_1ere_adhesion(String ma_1ere_adhesion) {
		this.ma_1ere_adhesion = ma_1ere_adhesion;
	}

	public int getNbr_pers_charge() {
		return nbr_pers_charge;
	}

	public void setNbr_pers_charge(int nbr_pers_charge) {
		this.nbr_pers_charge = nbr_pers_charge;
	}
	
	
	
}
