package com.Giz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Giz.data.domain.Valider;

@Repository
public interface ValiderRepository extends JpaRepository<Valider, Long>{
	
	@Query("SELECT v.code_village, v.district, v.nom_group_l_telo, v.categorie, v.date_creation, v.effectif_membre, v.sexe, v.operationnel, v.date_suivi FROM Valider v where v.canevas = 'L3'")
	List<Valider> findAllL3();
	
	@Query("SELECT v.code_village, v.nom_vsla, v.annee_creation, v.vsla_lier_regionale, v.appuis_reçus, v.type_appui, v.operationnel, v.date_suivi FROM Valider v where v.canevas = 'VSLA'")
	List<Valider> findAllVSLA();
	
	@Query("SELECT v.code_village, v.fbs_post_fbs_reçus, v.education_fbs_post_fbs, v.date_suivi FROM Valider v where v.canevas = 'FBS'")
	List<Valider> findAllFBS();
	
	@Query("SELECT v.code_village, v.code_prod, v.nom_prenom, v.sexe, v.annee_naissance, v.service_mobile_money, v.date_suivi, v.orange_money, v.mvola, v.airtel_money FROM Valider v where v.canevas = 'Mobile'")
	List<Valider> findAllMobileMoney();
	
	@Query("SELECT v.code_village, v.code_prod, v.nom_prenom, v.sexe, v.annee_naissance, v.service_IMF, v.date_suivi, v.institution, v.lieu_agence FROM Valider v where v.canevas = 'Finance'")
	List<Valider> findAllFinance();
	
	@Query("SELECT v.num_adhesion, v.nom_beneficiaire, v.nom_usuel_adherent, v.contact, v.age, v.date_naiss, v.cin, v.sexe, v.code_village. v.code_pro_symrise, v.commune, v.adresse_fkt, v.affiliation, v.ma_1ere_adhesion, v.nbr_pers_charge  FROM Valider v where v.canevas = 'Producteur'")
	List<Valider> findAllProducteur();
	
	@Query("SELECT v.num_adhesion, v.nom_beneficiaire, v.nom_usuel_adherent, v.contact, v.age, v.date_naiss, v.cin, v.sexe, v.code_village. v.code_pro_symrise, v.commune, v.adresse_fkt, v.affiliation, v.ma_1ere_adhesion, v.nbr_pers_charge  FROM Valider v where v.canevas = 'Adhesion'")
	List<Valider> findAllAdhesion();
	
	@Query("SELECT v.num_adhesion, v.nom_beneficiaire, v.nom_usuel_adherent, v.contact, v.age, v.date_naiss, v.cin, v.sexe, v.code_village. v.code_pro_symrise, v.commune, v.adresse_fkt, v.affiliation, v.ma_1ere_adhesion, v.nbr_pers_charge  FROM Valider v where v.canevas = 'Menage'")
	List<Valider> findAllMenage();

}
