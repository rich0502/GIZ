package com.Giz.service.metier;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Giz.data.domain.Valider;
import com.Giz.repository.ValiderRepository;

@Service
public class ValiderServiceImpl implements ValiderService{

	@Autowired
	ValiderRepository validerrepository;
	
	@Override
	public List<Valider> ListValiderL3() {
		// TODO Auto-generated method stub
		return validerrepository.findAllL3();
	}

	@Override
	public void deleteValider(Long id) {
		// TODO Auto-generated method stub
		validerrepository.deleteById(id);
	}

	
	@Override
	public void addValiderL3(String code_village, String district, String nom_group_l_telo, String categorie,
			Date date_creation, double effectif_membre, int nbr_h, int nbr_f, boolean operationnel, Date date_suivi) {
		Valider validerL3 = new Valider();
		validerL3.setCode_village(code_village);
		validerL3.setDistrict(district);
		validerL3.setNom_group_l_telo(nom_group_l_telo);
		validerL3.setCategorie(categorie);
		validerL3.setDate_creation(date_creation);
		validerL3.setEffectif_membre(effectif_membre);
		validerL3.setNbr_f(nbr_f);
		validerL3.setNbr_h(nbr_h);
		validerL3.setOperationnel(operationnel);
		validerL3.setDate_suivi(date_suivi);
		validerL3.setCanevas("L3");
		validerrepository.save(validerL3);
		
	}
	
	@Override
	public void modifyL3(Valider validerL3, String code_village, String district, String nom_group_l_telo,
			String categorie, Date date_creation, double effectif_membre, String sexe, boolean operationnel,
			Date date_suivi, Long id) {
		validerL3.setId(id);
		validerL3.setCode_village(code_village);
		validerL3.setDistrict(district);
		validerL3.setNom_group_l_telo(nom_group_l_telo);
		validerL3.setCategorie(categorie);
		validerL3.setDate_creation(date_creation);
		validerL3.setEffectif_membre(effectif_membre);
		validerL3.setSexe(sexe.toLowerCase());
		validerL3.setOperationnel(operationnel);
		validerL3.setDate_suivi(date_suivi);
		validerrepository.save(validerL3);
		
	}
	
	@Override
	public void deleteL3(Long id) {
		validerrepository.deleteById(id);		
	}

	@Override
	public List<Valider> ListValiderVSLA() {
		// TODO Auto-generated method stub
		return validerrepository.findAllVSLA();
	}

	@Override
	public void addValiderVSLA(String code_village, String nom_vsla, int annee_creation, boolean vsla_lier_regionale,
			boolean appuis_recus, String type_appui, boolean operationnel, Date date_suivi) {
		Valider validerVSLA = new Valider();
		validerVSLA.setCode_village(code_village);
		validerVSLA.setNom_vsla(nom_vsla);
		validerVSLA.setAnnee_creation(annee_creation);
		validerVSLA.setVsla_lier_regionale(vsla_lier_regionale);
		validerVSLA.setAppuis_recus(appuis_recus);;
		validerVSLA.setType_appui(type_appui);
		validerVSLA.setOperationnel(operationnel);
		validerVSLA.setDate_suivi(date_suivi);
		validerVSLA.setCanevas("VSLA");
		validerrepository.save(validerVSLA);
		
	}

	@Override
	public void modifyVSLA(Valider validerVSLA, String code_village, String nom_vsla, int annee_creation,
			boolean vsla_lier_regionale, boolean appuis_recus, String type_appui, boolean operationnel, Date date_suivi,
			Long id) {
		validerVSLA.setId(id);
		validerVSLA.setCode_village(code_village);
		validerVSLA.setNom_vsla(nom_vsla);
		validerVSLA.setAnnee_creation(annee_creation);
		validerVSLA.setVsla_lier_regionale(vsla_lier_regionale);
		validerVSLA.setAppuis_recus(appuis_recus);
		validerVSLA.setType_appui(type_appui);
		validerVSLA.setOperationnel(operationnel);
		validerVSLA.setDate_suivi(date_suivi);
		validerrepository.save(validerVSLA);
		
	}

	@Override
	public List<Valider> ListValiderFBS() {
		// TODO Auto-generated method stub
		return validerrepository.findAllFBS();
	}

	@Override
	public void addValiderFBS(String code_village, boolean fbs_post_fbs_recus, boolean education_fbs_post_fbs,
			Date date_suivi) {
		Valider validerFBS = new Valider();
		validerFBS.setCode_village(code_village);
		validerFBS.setFbs_post_fbs_recus(fbs_post_fbs_recus);
		validerFBS.setEducation_fbs_post_fbs(education_fbs_post_fbs);
		validerFBS.setDate_suivi(date_suivi);
		validerFBS.setCanevas("FBS");
		validerrepository.save(validerFBS);
		
	}

	@Override
	public void modifyFBS(Valider valider, String code_village, boolean fbs_post_fbs_recus,
			boolean education_fbs_post_fbs, Date date_suivi, Long id) {
		valider.setId(id);
		valider.setCode_village(code_village);
		valider.setFbs_post_fbs_recus(fbs_post_fbs_recus);
		valider.setEducation_fbs_post_fbs(education_fbs_post_fbs);
		valider.setDate_suivi(date_suivi);
		validerrepository.save(valider);
		
	}

	@Override
	public List<Valider> ListValiderMobileMoney() {
		// TODO Auto-generated method stub
		return validerrepository.findAllMobileMoney();
	}

	@Override
	public void addValiderMobileMoney(String code_village, String code_prod, String nom_prenom, String sexe,
			int annee_naissance, boolean service_mobile_money, Date date_suivi, boolean orange_money, boolean mvola,
			boolean airtel_money) {
		Valider validerMoney = new Valider();
		validerMoney.setCode_village(code_village);
		validerMoney.setCode_prod(code_prod);
		validerMoney.setNom_prenom(nom_prenom);
		validerMoney.setSexe(sexe.toLowerCase());
		validerMoney.setAnnee_naissance(annee_naissance);
		validerMoney.setService_mobile_money(service_mobile_money);
		validerMoney.setOrange_money(orange_money);
		validerMoney.setDate_suivi(date_suivi);
		validerMoney.setMvola(mvola);
		validerMoney.setAirtel_money(airtel_money);
		validerMoney.setCanevas("Mobile");
		validerrepository.save(validerMoney);
		
	}

	@Override
	public void modifyMobileMoney(Valider valider, String code_village, String code_prod, String nom_prenom,
			String sexe, int annee_naissance, boolean service_mobile_money, Date date_suivi, boolean orange_money,
			boolean mvola, boolean airtel_money, Long id) {
		valider.setId(id);
		valider.setCode_village(code_village);
		valider.setCode_prod(code_prod);
		valider.setNom_prenom(nom_prenom);
		valider.setSexe(sexe.toLowerCase());
		valider.setAnnee_naissance(annee_naissance);
		valider.setService_mobile_money(service_mobile_money);
		valider.setOrange_money(orange_money);
		valider.setDate_suivi(date_suivi);
		valider.setMvola(mvola);
		valider.setAirtel_money(airtel_money);
		validerrepository.save(valider);
		
	}

	@Override
	public List<Valider> ListValiderFinance() {
		// TODO Auto-generated method stub
		return validerrepository.findAllFinance();
	}

	@Override
	public void addValiderFinance(String code_village, String code_prod, String nom_prenom, String sexe,
			int annee_naissance, boolean service_IMF, Date date_suivi, String institution, String lieu_agence) {
		Valider validerFinance = new Valider();
		validerFinance.setCode_village(code_village);
		validerFinance.setCode_prod(code_prod);
		validerFinance.setNom_prenom(nom_prenom);
		validerFinance.setSexe(sexe.toLowerCase());
		validerFinance.setAnnee_naissance(annee_naissance);
		validerFinance.setService_IMF(service_IMF);
		validerFinance.setInstitution(institution);
		validerFinance.setDate_suivi(date_suivi);
		validerFinance.setLieu_agence(lieu_agence);
		validerFinance.setCanevas("Finance");
		validerrepository.save(validerFinance);
		
	}

	@Override
	public void modifyFinance(Valider valider, String code_village, String code_prod, String nom_prenom, String sexe,
			int annee_naissance, boolean service_IMF, Date date_suivi, String institution, String lieu_agence,
			Long id) {
		valider.setId(id);
		valider.setCode_village(code_village);
		valider.setCode_prod(code_prod);
		valider.setNom_prenom(nom_prenom);
		valider.setSexe(sexe.toLowerCase());
		valider.setAnnee_naissance(annee_naissance);
		valider.setService_IMF(service_IMF);
		valider.setInstitution(institution);
		valider.setDate_suivi(date_suivi);
		valider.setLieu_agence(lieu_agence);
		validerrepository.save(valider);
		
	}

	@Override
	public List<Valider> ListValiderProducteur() {
		// TODO Auto-generated method stub
		return validerrepository.findAllProducteur();
	}

	@Override
	public void addValiderProducteur(String num_adhesion, String nom_beneficiaire, String nom_usuel_adherent,
			String contact, int age, Date date_naiss, String cin, String sexe, String code_village,
			String code_pro_symrise, String commune, String adresse_fkt, String affiliation, String ma_1ere_adhesion,
			int nbr_pers_charge) {
			Valider validerProducteur = new Valider();
			validerProducteur.setCode_village(code_village);
			validerProducteur.setNum_adhesion(num_adhesion);
			validerProducteur.setNom_beneficiaire(nom_beneficiaire);
			validerProducteur.setNom_usuel_adherent(nom_usuel_adherent);
			validerProducteur.setContact(contact);
			validerProducteur.setAge(age);
			validerProducteur.setDate_naiss(date_naiss);
			validerProducteur.setCin(cin);
			validerProducteur.setSexe(sexe.toLowerCase());
			validerProducteur.setCode_pro_symrise(code_pro_symrise);
			validerProducteur.setCommune(commune);
			validerProducteur.setAdresse_fkt(adresse_fkt);
			validerProducteur.setAffiliation(affiliation);
			validerProducteur.setMa_1ere_adhesion(ma_1ere_adhesion);
			validerProducteur.setNbr_pers_charge(nbr_pers_charge);
			validerProducteur.setCanevas("Producteur");
			validerrepository.save(validerProducteur);
		
	}

	@Override
	public void modifyProducteur(Valider valider, String num_adhesion, String nom_beneficiaire,
			String nom_usuel_adherent, String contact, int age, Date date_naiss, String cin, String sexe,
			String code_village, String code_pro_symrise, String commune, String adresse_fkt, String affiliation,
			String ma_1ere_adhesion, int nbr_pers_charge, int annee_adhesion, Long id) {
		valider.setId(id);
		valider.setCode_village(code_village);
		valider.setNum_adhesion(num_adhesion);
		valider.setNom_beneficiaire(nom_beneficiaire);
		valider.setNom_usuel_adherent(nom_usuel_adherent);
		valider.setContact(contact);
		valider.setAge(age);
		valider.setDate_naiss(date_naiss);
		valider.setCin(cin);
		valider.setSexe(sexe.toLowerCase());
		valider.setCode_pro_symrise(code_pro_symrise);
		valider.setCommune(commune);
		valider.setAdresse_fkt(adresse_fkt);
		valider.setAffiliation(affiliation);
		valider.setMa_1ere_adhesion(ma_1ere_adhesion);
		valider.setNbr_pers_charge(nbr_pers_charge);
		valider.setAnnee_adhesion(annee_adhesion);
		validerrepository.save(valider);
		
	}

	@Override
	public List<Valider> ListValiderAdhesion() {
		// TODO Auto-generated method stub
		return validerrepository.findAllAdhesion();
	}

	@Override
	public void addValiderAdhesion(String num_adhesion, String nom_beneficiaire, String nom_usuel_adherent,
			String contact, int age, Date date_naiss, String cin, String sexe, String code_village,
			String code_pro_symrise, String commune, String adresse_fkt, String affiliation, String ma_1ere_adhesion,
			int nbr_pers_charge) {
		Valider validerAdhesion = new Valider();
		validerAdhesion.setCode_village(code_village);
		validerAdhesion.setNum_adhesion(num_adhesion);
		validerAdhesion.setNom_beneficiaire(nom_beneficiaire);
		validerAdhesion.setNom_usuel_adherent(nom_usuel_adherent);
		validerAdhesion.setContact(contact);
		validerAdhesion.setAge(age);
		validerAdhesion.setDate_naiss(date_naiss);
		validerAdhesion.setCin(cin);
		validerAdhesion.setSexe(sexe.toLowerCase());
		validerAdhesion.setCode_pro_symrise(code_pro_symrise);
		validerAdhesion.setCommune(commune);
		validerAdhesion.setAdresse_fkt(adresse_fkt);
		validerAdhesion.setAffiliation(affiliation);
		validerAdhesion.setMa_1ere_adhesion(ma_1ere_adhesion);
		validerAdhesion.setNbr_pers_charge(nbr_pers_charge);
		validerAdhesion.setCanevas("Adhesion");
		validerrepository.save(validerAdhesion);
		
	}

	@Override
	public void modifyAdhesion(Valider valider, String num_adhesion, String nom_beneficiaire, String nom_usuel_adherent,
			String contact, int age, Date date_naiss, String cin, String sexe, String code_village,
			String code_pro_symrise, String commune, String adresse_fkt, String affiliation, String ma_1ere_adhesion,
			int nbr_pers_charge, int annee_adhesion, Long id) {
		valider.setId(id);
		valider.setCode_village(code_village);
		valider.setNum_adhesion(num_adhesion);
		valider.setNom_beneficiaire(nom_beneficiaire);
		valider.setNom_usuel_adherent(nom_usuel_adherent);
		valider.setContact(contact);
		valider.setAge(age);
		valider.setDate_naiss(date_naiss);
		valider.setCin(cin);
		valider.setSexe(sexe.toLowerCase());
		valider.setCode_pro_symrise(code_pro_symrise);
		valider.setCommune(commune);
		valider.setAdresse_fkt(adresse_fkt);
		valider.setAffiliation(affiliation);
		valider.setMa_1ere_adhesion(ma_1ere_adhesion);
		valider.setNbr_pers_charge(nbr_pers_charge);
		valider.setAnnee_adhesion(annee_adhesion);
		validerrepository.save(valider);
		
	}

	@Override
	public List<Valider> ListValiderMenage() {
		// TODO Auto-generated method stub
		return validerrepository.findAllMenage();
	}

	@Override
	public void addValiderMenage(String num_adhesion, String nom_beneficiaire, String nom_usuel_adherent,
			String contact, int age, Date date_naiss, String cin, String sexe, String code_village,
			String code_pro_symrise, String commune, String adresse_fkt, String affiliation, String ma_1ere_adhesion,
			int nbr_pers_charge) {
		Valider validerAdhesion = new Valider();
		validerAdhesion.setCode_village(code_village);
		validerAdhesion.setNum_adhesion(num_adhesion);
		validerAdhesion.setNom_beneficiaire(nom_beneficiaire);
		validerAdhesion.setNom_usuel_adherent(nom_usuel_adherent);
		validerAdhesion.setContact(contact);
		validerAdhesion.setAge(age);
		validerAdhesion.setDate_naiss(date_naiss);
		validerAdhesion.setCin(cin);
		validerAdhesion.setSexe(sexe.toLowerCase());
		validerAdhesion.setCode_pro_symrise(code_pro_symrise);
		validerAdhesion.setCommune(commune);
		validerAdhesion.setAdresse_fkt(adresse_fkt);
		validerAdhesion.setAffiliation(affiliation);
		validerAdhesion.setMa_1ere_adhesion(ma_1ere_adhesion);
		validerAdhesion.setNbr_pers_charge(nbr_pers_charge);
		validerAdhesion.setCanevas("Menage");
		validerrepository.save(validerAdhesion);
		
	}

	@Override
	public void modifyMenage(Valider valider, String num_adhesion, String nom_beneficiaire, String nom_usuel_adherent,
			String contact, int age, Date date_naiss, String cin, String sexe, String code_village,
			String code_pro_symrise, String commune, String adresse_fkt, String affiliation, String ma_1ere_adhesion,
			int nbr_pers_charge, int annee_adhesion, Long id) {
		valider.setId(id);
		valider.setCode_village(code_village);
		valider.setNum_adhesion(num_adhesion);
		valider.setNom_beneficiaire(nom_beneficiaire);
		valider.setNom_usuel_adherent(nom_usuel_adherent);
		valider.setContact(contact);
		valider.setAge(age);
		valider.setDate_naiss(date_naiss);
		valider.setCin(cin);
		valider.setSexe(sexe.toLowerCase());
		valider.setCode_pro_symrise(code_pro_symrise);
		valider.setCommune(commune);
		valider.setAdresse_fkt(adresse_fkt);
		valider.setAffiliation(affiliation);
		valider.setMa_1ere_adhesion(ma_1ere_adhesion);
		valider.setNbr_pers_charge(nbr_pers_charge);
		valider.setAnnee_adhesion(annee_adhesion);
		validerrepository.save(valider);
		
	}

	@Override
	public int countLakileteloOperatoinnel() {
		// TODO Auto-generated method stub
		return validerrepository.countL3Operationnel();
	}

	@Override
	public int countHLakileteloOperationnel() {
		// TODO Auto-generated method stub
		return validerrepository.countL3HOperationnel();
	}

	@Override
	public int countFLakileteloOperationnel() {
		// TODO Auto-generated method stub
		return validerrepository.countL3FOperationnel();
	}

	@Override
	public int countL3VSLAOperationnel() {
		// TODO Auto-generated method stub
		return validerrepository.countL3OperationnelVSLA();
	}

	@Override
	public int countL3VSLAOperationnelH() {
		// TODO Auto-generated method stub
		return validerrepository.countL3HOperationnelVSLA();
	}

	@Override
	public int countL3VSLAOperationnelF() {
		// TODO Auto-generated method stub
		return validerrepository.countL3FOperationnelVSLA();
	}

	@Override
	public int countL3GEC() {
		// TODO Auto-generated method stub
		return validerrepository.countL3OperationnelGEC();
	}

	@Override
	public int countL3GECH() {
		// TODO Auto-generated method stub
		return validerrepository.countL3HOperationnelGEC();
	}

	@Override
	public int countL3GECF() {
		// TODO Auto-generated method stub
		return validerrepository.countL3FOperationnelGEC();
	}

	@Override
	public int countVSLAOperationnel() {
		// TODO Auto-generated method stub
		return validerrepository.countVSLAOperationnel();
	}

	@Override
	public int countHVSLAOperationnel() {
		// TODO Auto-generated method stub
		return validerrepository.countVSLAHOperationnel();
	}

	@Override
	public int countFVSLAOperationnel() {
		// TODO Auto-generated method stub
		return validerrepository.countVSLAFOperationnel();
	}

	@Override
	public int countMobileMoney() {
		// TODO Auto-generated method stub
		return validerrepository.countMobileMoney();
	}

	@Override
	public int countHMobileMoney() {
		// TODO Auto-generated method stub
		return validerrepository.countMobileMoneyH();
	}

	@Override
	public int countFMobileMoney() {
		// TODO Auto-generated method stub
		return validerrepository.countMobileMoneyF();
	}

	@Override
	public int countFinance() {
		// TODO Auto-generated method stub
		return validerrepository.countFinance();
	}

	@Override
	public int countHFinance() {
		// TODO Auto-generated method stub
		return validerrepository.countFinanceH();
	}

	@Override
	public int countFFinance() {
		// TODO Auto-generated method stub
		return validerrepository.countFinanceF();
	}

	@Override
	public int countProducteur() {
		// TODO Auto-generated method stub
		return validerrepository.countProducteur();
	}

	@Override
	public int countHProducteur() {
		// TODO Auto-generated method stub
		return validerrepository.countProducteurH();
	}

	@Override
	public int countFProducteur() {
		// TODO Auto-generated method stub
		return validerrepository.countProducteurF();
	}

	@Override
	public int countAdhesion() {
		// TODO Auto-generated method stub
		return validerrepository.countAdhesion();
	}

	@Override
	public int countHAdhesion() {
		// TODO Auto-generated method stub
		return validerrepository.countAdhesionH();
	}

	@Override
	public int countFAdhesion() {
		// TODO Auto-generated method stub
		return validerrepository.countAdhesionF();
	}

	@Override
	public int countMenage() {
		// TODO Auto-generated method stub
		return validerrepository.countMenage();
	}

	@Override
	public int countHMenage() {
		// TODO Auto-generated method stub
		return validerrepository.countMenageH();
	}

	@Override
	public int countFMenage() {
		// TODO Auto-generated method stub
		return validerrepository.countMenageF();
	}



	



}
