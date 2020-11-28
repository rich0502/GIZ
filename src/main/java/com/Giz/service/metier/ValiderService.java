package com.Giz.service.metier;

import java.util.Date;
import java.util.List;

import com.Giz.data.domain.Valider;

public interface ValiderService {
	
	public void deleteValider(Long id);
	
	
	
	public List<Valider> ListValiderL3();
	
	public void addValiderL3(String code_village, String district, String nom_group_l_telo, String categorie, Date date_creation, String effectif_membre, String sexe, boolean operationnel, Date date_suivi);
	
	
	public void modifyL3(Valider valider,String code_village, String district, String nom_group_l_telo, String categorie, Date date_creation,
			String effectif_membre, String sexe, boolean operationnel, Date date_suivi, Long id);

	
	
	public List<Valider> ListValiderVSLA();
	
	public void addValiderVSLA(String code_village, String nom_vsla, int annee_creation, boolean vsla_lier_regionale, boolean appuis_recus,
			String type_appui, boolean operationnel, Date date_suivi);

	public void modifyVSLA(Valider valider,String code_village, String nom_vsla, int annee_creation, boolean vsla_lier_regionale, boolean appuis_recus,
			String type_appui, boolean operationnel, Date date_suivi, Long id);
	
	
	
	public List<Valider> ListValiderFBS();
	
	public void addValiderFBS(String code_village, boolean fbs_post_fbs_recus, boolean education_fbs_post_fbs, Date date_suivi);

	public void modifyFBS(Valider valider,String code_village, boolean fbs_post_fbs_recus, boolean education_fbs_post_fbs, Date date_suivi, Long id);

	
	
	public List<Valider> ListValiderMobileMoney();
	
	public void addValiderMobileMoney(String code_village, String code_prod, String nom_prenom, String sexe, int annee_naissance, boolean service_mobile_money, Date date_suivi, boolean orange_money, boolean mvola, boolean airtel_money);

	public void modifyMobileMoney(Valider valider,String code_village, String code_prod, String nom_prenom, String sexe, int annee_naissance, boolean service_mobile_money, Date date_suivi, boolean orange_money, boolean mvola, boolean airtel_money, Long id);
	
	
	
	public List<Valider> ListValiderFinance();
	
	public void addValiderFinance(String code_village, String code_prod, String nom_prenom, String sexe, int annee_naissance, boolean service_IMF, Date date_suivi, String institution, String lieu_agence);

	public void modifyFinance(Valider valider,String code_village, String code_prod, String nom_prenom, String sexe, int annee_naissance, boolean service_IMF, Date date_suivi, String institution, String lieu_agence, Long id);

	
	
	public List<Valider> ListValiderProducteur();
	
	public void addValiderProducteur(String num_adhesion, String nom_beneficiaire, String nom_usuel_adherent, String contact, int age, Date date_naiss, String cin, String sexe, String code_village, String code_pro_symrise, String commune, String adresse_fkt, String affiliation, String ma_1ere_adhesion,  int nbr_pers_charge );

	public void modifyProducteur(Valider valider,String num_adhesion, String nom_beneficiaire, String nom_usuel_adherent, String contact, int age, Date date_naiss, String cin, String sexe, String code_village, String code_pro_symrise, String commune, String adresse_fkt, String affiliation, String ma_1ere_adhesion,  int nbr_pers_charge, Long id);

	
	
	public List<Valider> ListValiderAdhesion();
	
	public void addValiderAdhesion(String num_adhesion, String nom_beneficiaire, String nom_usuel_adherent, String contact, int age, Date date_naiss, String cin, String sexe, String code_village, String code_pro_symrise, String commune, String adresse_fkt, String affiliation, String ma_1ere_adhesion,  int nbr_pers_charge );

	public void modifyAdhesion(Valider valider,String num_adhesion, String nom_beneficiaire, String nom_usuel_adherent, String contact, int age, Date date_naiss, String cin, String sexe, String code_village, String code_pro_symrise, String commune, String adresse_fkt, String affiliation, String ma_1ere_adhesion,  int nbr_pers_charge, Long id);

	
	
	public List<Valider> ListValiderMenage();
	
	public void addValiderMenage(String num_adhesion, String nom_beneficiaire, String nom_usuel_adherent, String contact, int age, Date date_naiss, String cin, String sexe, String code_village, String code_pro_symrise, String commune, String adresse_fkt, String affiliation, String ma_1ere_adhesion,  int nbr_pers_charge );

	public void modifyMenage(Valider valider,String num_adhesion, String nom_beneficiaire, String nom_usuel_adherent, String contact, int age, Date date_naiss, String cin, String sexe, String code_village, String code_pro_symrise, String commune, String adresse_fkt, String affiliation, String ma_1ere_adhesion,  int nbr_pers_charge, Long id);

	
}
