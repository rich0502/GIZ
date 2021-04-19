package com.Giz.service.metier;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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
	public Optional<Valider> findByIdL3(long id) {
		return validerrepository.findByL3(id);
	}
	
	@Override
	public void modifyL3(String code_village, String district, String nom_group_l_telo,
			String categorie, Date date_creation, double effectif_membre, int nbr_h, int nbr_f, boolean operationnel,
			Date date_suivi, Long id) {
		Valider validerL3 = new Valider();
		validerL3.setId(id);
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
	public Optional<Valider> findByIdVSLA(long id) {
		return validerrepository.findByIdVSLA(id);
	}

	@Override
	public void modifyVSLA(String code_village, String nom_vsla, int annee_creation,
			boolean vsla_lier_regionale, boolean appuis_recus, String type_appui, boolean operationnel, Date date_suivi,
			Long id) {
		Valider validerVSLA = new Valider();
		validerVSLA.setId(id);
		validerVSLA.setCode_village(code_village);
		validerVSLA.setNom_vsla(nom_vsla);
		validerVSLA.setAnnee_creation(annee_creation);
		validerVSLA.setVsla_lier_regionale(vsla_lier_regionale);
		validerVSLA.setAppuis_recus(appuis_recus);
		validerVSLA.setType_appui(type_appui);
		validerVSLA.setOperationnel(operationnel);
		validerVSLA.setDate_suivi(date_suivi);
		validerVSLA.setCanevas("VSLA");
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
	public Optional<Valider> findByIdFBS(long id) {
		return validerrepository.findByIdFBS(id);
	}

	@Override
	public void modifyFBS(String code_village, boolean fbs_post_fbs_recus,
			boolean education_fbs_post_fbs, Date date_suivi, Long id) {
		Valider valider = new Valider();
		valider.setId(id);
		valider.setCode_village(code_village);
		valider.setFbs_post_fbs_recus(fbs_post_fbs_recus);
		valider.setEducation_fbs_post_fbs(education_fbs_post_fbs);
		valider.setDate_suivi(date_suivi);
		valider.setCanevas("FBS");
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
	public Optional<Valider> findByIdMoney(long id) {
		return validerrepository.findByIdMoney(id);
	}

	@Override
	public void modifyMoney(String code_village, String code_prod, String nom_prenom,
			String sexe, int annee_naissance, boolean service_mobile_money, Date date_suivi, boolean orange_money,
			boolean mvola, boolean airtel_money, Long id) {
		Valider valider = new Valider();
		valider.setId(id);
		valider.setCode_village(code_village);
		valider.setCode_prod(code_prod);
		valider.setNom_prenom(nom_prenom);
		valider.setSexe(sexe.toLowerCase());
		valider.setAnnee_naissance(annee_naissance);
		valider.setService_mobile_money(service_mobile_money);
		valider.setOrange_money(orange_money);
		valider.setDate_suivi(date_suivi);
		valider.setCanevas("Mobile");
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
	public Optional<Valider> findByIdFinance(long id) {
		return validerrepository.findByIdFinance(id);
	}

	@Override
	public void modifyFinance(String code_village, String code_prod, String nom_prenom, String sexe,
			int annee_naissance, boolean service_IMF, Date date_suivi, String institution, String lieu_agence,
			Long id) {
		Valider valider = new Valider();
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
		valider.setCanevas("Finance");
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
	public Optional<Valider> findByIdProducteur(long id) {
		return validerrepository.findByIdProducteur(id);
	}

	@Override
	public void modifyProducteur(String num_adhesion, String nom_beneficiaire,
			String nom_usuel_adherent, String contact, int age, Date date_naiss, String cin, String sexe,
			String code_village, String code_pro_symrise, String commune, String adresse_fkt, String affiliation,
			String ma_1ere_adhesion, int nbr_pers_charge,  Long id) {
		Valider valider= new Valider();
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
		valider.setCanevas("Producteur");
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
	public Optional<Valider> findByIdAdhesion(long id) {
		return validerrepository.findByIdAdhesion(id);
	}

	@Override
	public void modifyAdhesion(String num_adhesion, String nom_beneficiaire, String nom_usuel_adherent,
			String contact, int age, Date date_naiss, String cin, String sexe, String code_village,
			String code_pro_symrise, String commune, String adresse_fkt, String affiliation, String ma_1ere_adhesion,
			int nbr_pers_charge, int annee_adhesion, Long id) {
		Valider valider = new Valider();
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
		valider.setCanevas("Adhesion");
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
	public Optional<Valider> findByIdMenage(long id) {
		return validerrepository.findByIdMenage(id);
	}

	@Override
	public void modifyMenage(String num_adhesion, String nom_beneficiaire, String nom_usuel_adherent,
			String contact, int age, Date date_naiss, String cin, String sexe, String code_village,
			String code_pro_symrise, String commune, String adresse_fkt, String affiliation, String ma_1ere_adhesion,
			int nbr_pers_charge, int annee_adhesion, Long id) {
		Valider valider = new Valider();
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
		valider.setCanevas("Menage");
		validerrepository.save(valider);
		
	}

	@Override
	public int countLakileteloOperatoinnel(String dateChronologique) {
		// TODO Auto-generated method stub
		return validerrepository.countL3Operationnel(dateChronologique);
	}

	@Override
	public int countHLakileteloOperationnel(String dateChronologique) {
		// TODO Auto-generated method stub
		return validerrepository.countL3HOperationnel(dateChronologique);
	}

	@Override
	public int countFLakileteloOperationnel(String dateChronologique) {
		// TODO Auto-generated method stub
		return validerrepository.countL3FOperationnel(dateChronologique);
	}

	@Override
	public int countL3VSLAOperationnel(String dateChronologique) {
		// TODO Auto-generated method stub
		return validerrepository.countL3OperationnelVSLA(dateChronologique);
	}

	@Override
	public int countL3VSLAOperationnelH(String dateChronologique) {
		// TODO Auto-generated method stub
		return validerrepository.countL3HOperationnelVSLA(dateChronologique);
	}

	@Override
	public int countL3VSLAOperationnelF(String dateChronologique) {
		// TODO Auto-generated method stub
		return validerrepository.countL3FOperationnelVSLA(dateChronologique);
	}

	@Override
	public int countL3GEC(String dateChronologique) {
		// TODO Auto-generated method stub
		return validerrepository.countL3OperationnelGEC(dateChronologique);
	}

	@Override
	public int countL3GECH(String dateChronologique) {
		// TODO Auto-generated method stub
		return validerrepository.countL3HOperationnelGEC(dateChronologique);
	}

	@Override
	public int countL3GECF(String dateChronologique) {
		// TODO Auto-generated method stub
		return validerrepository.countL3FOperationnelGEC(dateChronologique);
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
	public int countMobileMoney(String dateChronologique) {
		// TODO Auto-generated method stub
		return validerrepository.countMobileMoney(dateChronologique);
	}

	@Override
	public int countHMobileMoney(String dateChronologique) {
		// TODO Auto-generated method stub
		return validerrepository.countMobileMoneyH(dateChronologique);
	}

	@Override
	public int countFMobileMoney(String dateChronologique) {
		// TODO Auto-generated method stub
		return validerrepository.countMobileMoneyF(dateChronologique);
	}

	@Override
	public int countFinance(String dateChronologique) {
		// TODO Auto-generated method stub
		return validerrepository.countFinance(dateChronologique);
	}

	@Override
	public int countHFinance(String dateChronologique) {
		// TODO Auto-generated method stub
		return validerrepository.countFinanceH(dateChronologique);
	}

	@Override
	public int countFFinance(String dateChronologique) {
		// TODO Auto-generated method stub
		return validerrepository.countFinanceF(dateChronologique);
	}

	@Override
	public int countProducteur(String dateChronologique) {
		// TODO Auto-generated method stub
		return validerrepository.countProducteur(dateChronologique);
	}

	@Override
	public int countHProducteur(String dateChronologique) {
		// TODO Auto-generated method stub
		return validerrepository.countProducteurH(dateChronologique);
	}

	@Override
	public int countFProducteur(String dateChronologique) {
		// TODO Auto-generated method stub
		return validerrepository.countProducteurF(dateChronologique);
	}

	@Override
	public int countAdhesion(String dateChronologique) {
		// TODO Auto-generated method stub
		return validerrepository.countAdhesion(dateChronologique);
	}

	@Override
	public int countHAdhesion(String dateChronologique) {
		// TODO Auto-generated method stub
		return validerrepository.countAdhesionH(dateChronologique);
	}

	@Override
	public int countFAdhesion(String dateChronologique) {
		// TODO Auto-generated method stub
		return validerrepository.countAdhesionF(dateChronologique);
	}

	@Override
	public int countMenage(String dateChronologique) {
		// TODO Auto-generated method stub
		return validerrepository.countMenage(dateChronologique);
	}

	@Override
	public int countHMenage(String dateChronologique) {
		// TODO Auto-generated method stub
		return validerrepository.countMenageH(dateChronologique);
	}

	@Override
	public int countFMenage(String dateChronologique) {
		// TODO Auto-generated method stub
		return validerrepository.countMenageF(dateChronologique);
	}

	@Override
	public int countFBS(String dateChronologique) {
		// TODO Auto-generated method stub
		return validerrepository.countFBS(dateChronologique);
	}
	
	// TABLEAU SUM
	
	@Override
	public List<Object[]> ListTableauSum(Date debut_date, Date fin_date, List<String> params,String canevas) {
		// TODO Auto-generated method stub
		return validerrepository.TableDataSum(debut_date, fin_date,params, canevas);
	}

	@Override
	public List<Object[]> ListTableauCommuneSum(Date debut_date, Date fin_date,String canevas) {
		return validerrepository.TableDataCommuneSum(debut_date, fin_date,canevas);
	}

	@Override
	public List<Object[]> ListTableauDistSum(Date debut_date, Date fin_date,String canevas) {
		return validerrepository.TableDataDistSum(debut_date, fin_date, canevas);
	}
	
	// TABLEAU COUNT
	
	@Override
	public List<Object[]> ListTableauCount(Date debut_date, Date fin_date, List<String> params, String sexe,String canevas) {
		// TODO Auto-generated method stub
		return validerrepository.TableDataCount(debut_date, fin_date, params, sexe, canevas);
	}

	@Override
	public List<Object[]> ListTableauCommuneCount(Date debut_date, Date fin_date, String sexe,String canevas) {
		// TODO Auto-generated method stub
		return validerrepository.TableDataCommuneCount(debut_date, fin_date, sexe, canevas);
	}

	@Override
	public List<Object[]> ListTableauDistCount(Date debut_date, Date fin_date, String sexe,String canevas) {
		// TODO Auto-generated method stub
		return validerrepository.TableDataDistCount(debut_date, fin_date, sexe, canevas);
	}

	@Override
	public List<Object[]> ListTableauAllCount(Date debut_date, Date fin_date, List<String> params,String canevas) {
		// TODO Auto-generated method stub
		return validerrepository.TableDataAllCount(debut_date, fin_date, params, canevas);
	}

	@Override
	public List<Object[]> ListTableauCommuneAllCount(Date debut_date, Date fin_date,String canevas) {
		// TODO Auto-generated method stub
		return validerrepository.TableDataCommuneAllCount(debut_date, fin_date, canevas);
	}

	@Override
	public List<Object[]> ListTableauDistAllCount(Date debut_date, Date fin_date,String canevas) {
		// TODO Auto-generated method stub
		return validerrepository.TableDataDistAllCount(debut_date, fin_date, canevas);
	}
	
	// TABLEAU COUNT NO DATE
	
		@Override
		public List<Object[]> ListTableauCountNoDate(List<String> params, String sexe,String canevas) {
			// TODO Auto-generated method stub
			return validerrepository.TableDataCountNoDate(params, sexe, canevas);
		}

		@Override
		public List<Object[]> ListTableauCommuneCountNoDate(String sexe,String canevas) {
			// TODO Auto-generated method stub
			return validerrepository.TableDataCommuneCountNoDate(sexe, canevas);
		}

		@Override
		public List<Object[]> ListTableauDistCountNoDate(String sexe,String canevas) {
			// TODO Auto-generated method stub
			return validerrepository.TableDataDistCountNoDate(sexe, canevas);
		}

		@Override
		public List<Object[]> ListTableauAllCountNoDate(List<String> params,String canevas) {
			// TODO Auto-generated method stub
			return validerrepository.TableDataAllCountNoDate(params, canevas);
		}

		@Override
		public List<Object[]> ListTableauCommuneAllCountNoDate(String canevas) {
			// TODO Auto-generated method stub
			return validerrepository.TableDataCommuneAllCountNoDate(canevas);
		}

		@Override
		public List<Object[]> ListTableauDistAllCountNoDate(String canevas) {
			// TODO Auto-generated method stub
			return validerrepository.TableDataDistAllCountNoDate(canevas);
		}

		@Override
		public List<Object[]> ListTableauCountNoSexe(Date debut_date, Date fin_date, List<String> params,
				String canevas) {
			// TODO Auto-generated method stub
			return validerrepository.TableDataCountNoSexe(debut_date, fin_date, params, canevas);
		}

		@Override
		public List<Object[]> ListTableauCommuneCountNoSexe(Date debut_date, Date fin_date, String canevas) {
			// TODO Auto-generated method stub
			return validerrepository.TableDataCommuneCountNoSexe(debut_date, fin_date, canevas);
		}

		@Override
		public List<Object[]> ListTableauDistCountNoSexe(Date debut_date, Date fin_date, String canevas) {
			// TODO Auto-generated method stub
			return validerrepository.TableDataDistCountNoSexe(debut_date, fin_date, canevas);
		}
		
		
			// VILLAGE DETAIL TABLEAU COUNT

		@Override
		public List<Object[]> TableauCountDetailGenre(String village, String canevas, String sexe) {
			// TODO Auto-generated method stub
			return validerrepository.TableCountDetailGenre(village, canevas, sexe);
		}
		@Override
		public List<Object[]> TableauCountDetailGenreAll(String village, String canevas) {
			// TODO Auto-generated method stub
			return validerrepository.TableCountDetailGenreAll(village, canevas);
		}
		
			// COMMUNE DETAIL TABLEAU COUNT
		
		@Override
		public List<Object[]> TableauCountDetailGenreComm(String commune, String canevas, String sexe) {
			// TODO Auto-generated method stub
			return validerrepository.TableCountDetailGenreComm(commune, canevas, sexe);
		}
		@Override
		public List<Object[]> TableauCountDetailGenreAllComm(String commune, String canevas) {
			// TODO Auto-generated method stub
			return validerrepository.TableCountDetailGenreAllComm(commune, canevas);
		}
		
		// DISTRICT DETAIL TABLEAU COUNT
		
		@Override
		public List<Object[]> TableauCountDetailGenreDist(String district, String canevas, String sexe) {
			// TODO Auto-generated method stub
			return validerrepository.TableCountDetailGenreDist(district, canevas, sexe);
		}
		@Override
		public List<Object[]> TableauCountDetailGenreAllDist(String district, String canevas) {
			// TODO Auto-generated method stub
			return validerrepository.TableCountDetailGenreAllDist(district, canevas);
		}

		@Override
		public void deleteValiderAll(String canevas) {
			// TODO Auto-generated method stub
			validerrepository.deleteAllCanevasWp2(canevas);
		}

		@Override
		public List<Object[]> historiqueList(String canevas) {
			return validerrepository.historiqueList(canevas);
		}
		
}
