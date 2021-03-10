package com.Giz.service.metier;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.Giz.data.domain.Valider;

public interface ValiderService {
	
	public void deleteValider(Long id);
	
	
	
	public List<Valider> ListValiderL3();
	
	public void addValiderL3(String code_village, String district, String nom_group_l_telo, String categorie, Date date_creation, double effectif_membre,int nbr_h,int nbr_f, boolean operationnel, Date date_suivi);
	
	public Optional<Valider> findByIdL3(long id);
	
	public void modifyL3(String code_village, String district, String nom_group_l_telo, String categorie, Date date_creation,
			double effectif_membre, int nbr_h,int nbr_f, boolean operationnel, Date date_suivi, Long id);
	
	public int countLakileteloOperatoinnel(String dateChronologique);
	
	public int countHLakileteloOperationnel(String dateChronologique);
	
	public int countFLakileteloOperationnel(String dateChronologique);
	
	public int countL3VSLAOperationnel(String dateChronologique);
	
	public int countL3VSLAOperationnelH(String dateChronologique);
	
	public int countL3VSLAOperationnelF(String dateChronologique);
	
	public int countL3GEC(String dateChronologique);
	
	public int countL3GECH(String dateChronologique);
	
	public int countL3GECF(String dateChronologique);

	
	public Optional<Valider> findByIdVSLA(long id);
	
	public List<Valider> ListValiderVSLA();
	
	public void addValiderVSLA(String code_village, String nom_vsla, int annee_creation, boolean vsla_lier_regionale, boolean appuis_recus,
			String type_appui, boolean operationnel, Date date_suivi);

	public void modifyVSLA(String code_village, String nom_vsla, int annee_creation, boolean vsla_lier_regionale, boolean appuis_recus,
			String type_appui, boolean operationnel, Date date_suivi, Long id);
	
	
	public int countVSLAOperationnel();
	
	public int countHVSLAOperationnel();
	
	public int countFVSLAOperationnel();
	
	
	public Optional<Valider> findByIdFBS(long id);
	
	public List<Valider> ListValiderFBS();
	
	public void addValiderFBS(String code_village, boolean fbs_post_fbs_recus, boolean education_fbs_post_fbs, Date date_suivi);

	public void modifyFBS(String code_village, boolean fbs_post_fbs_recus, boolean education_fbs_post_fbs, Date date_suivi, Long id);
	
	public int countFBS(String dateChronologique);
	
	/*
	public int countHFBS();
	
	public int countFFBS();*/

	
	public Optional<Valider> findByIdMoney(long id);
	
	public List<Valider> ListValiderMobileMoney();
	
	public void addValiderMobileMoney(String code_village, String code_prod, String nom_prenom, String sexe, int annee_naissance, boolean service_mobile_money, Date date_suivi, boolean orange_money, boolean mvola, boolean airtel_money);

	public void modifyMoney(String code_village, String code_prod, String nom_prenom, String sexe, int annee_naissance, boolean service_mobile_money, Date date_suivi, boolean orange_money, boolean mvola, boolean airtel_money, Long id);
	
	public int countMobileMoney(String dateChronologique);
	
	public int countHMobileMoney(String dateChronologique);
	
	public int countFMobileMoney(String dateChronologique);
	
	
	public Optional<Valider> findByIdFinance(long id);
	
	public List<Valider> ListValiderFinance();
	
	public void addValiderFinance(String code_village, String code_prod, String nom_prenom, String sexe, int annee_naissance, boolean service_IMF, Date date_suivi, String institution, String lieu_agence);

	public void modifyFinance(String code_village, String code_prod, String nom_prenom, String sexe, int annee_naissance, boolean service_IMF, Date date_suivi, String institution, String lieu_agence, Long id);

	public int countFinance(String dateChronologique);
	
	public int countHFinance(String dateChronologique);
	
	public int countFFinance(String dateChronologique);
	
	
	public Optional<Valider> findByIdProducteur(long id);
	
	public List<Valider> ListValiderProducteur();
	
	public void addValiderProducteur(String num_adhesion, String nom_beneficiaire, String nom_usuel_adherent, String contact, int age, Date date_naiss, String cin, String sexe, String code_village, String code_pro_symrise, String commune, String adresse_fkt, String affiliation, String ma_1ere_adhesion,  int nbr_pers_charge);

	public void modifyProducteur(String num_adhesion, String nom_beneficiaire, String nom_usuel_adherent, String contact, int age, Date date_naiss, String cin, String sexe, String code_village, String code_pro_symrise, String commune, String adresse_fkt, String affiliation, String ma_1ere_adhesion,  int nbr_pers_charge, Long id);

	public int countProducteur(String dateChronologique);
	
	public int countHProducteur(String dateChronologique);
	
	public int countFProducteur(String dateChronologique);
	
	
	public Optional<Valider> findByIdAdhesion(long id);
	
	public List<Valider> ListValiderAdhesion();
	
	public void addValiderAdhesion(String num_adhesion, String nom_beneficiaire, String nom_usuel_adherent, String contact, int age, Date date_naiss, String cin, String sexe, String code_village, String code_pro_symrise, String commune, String adresse_fkt, String affiliation, String ma_1ere_adhesion,  int nbr_pers_charge );

	public void modifyAdhesion(String num_adhesion, String nom_beneficiaire, String nom_usuel_adherent, String contact, int age, Date date_naiss, String cin, String sexe, String code_village, String code_pro_symrise, String commune, String adresse_fkt, String affiliation, String ma_1ere_adhesion,  int nbr_pers_charge,int annee_adhesion, Long id);

	public int countAdhesion(String dateChronologique);
	
	public int countHAdhesion(String dateChronologique);
	
	public int countFAdhesion(String dateChronologique);
	
	
	public Optional<Valider> findByIdMenage(long id);
	
	public List<Valider> ListValiderMenage();
	
	public void addValiderMenage(String num_adhesion, String nom_beneficiaire, String nom_usuel_adherent, String contact, int age, Date date_naiss, String cin, String sexe, String code_village, String code_pro_symrise, String commune, String adresse_fkt, String affiliation, String ma_1ere_adhesion,  int nbr_pers_charge);

	public void modifyMenage(String num_adhesion, String nom_beneficiaire, String nom_usuel_adherent, String contact, int age, Date date_naiss, String cin, String sexe, String code_village, String code_pro_symrise, String commune, String adresse_fkt, String affiliation, String ma_1ere_adhesion,  int nbr_pers_charge,int annee_adhesion, Long id);

	public int countMenage(String dateChronologique);
	
	public int countHMenage(String dateChronologique);
	
	public int countFMenage(String dateChronologique);


	
}
