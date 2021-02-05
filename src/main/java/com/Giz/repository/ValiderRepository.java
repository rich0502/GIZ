package com.Giz.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Giz.data.domain.Valider;

@Repository
public interface ValiderRepository extends JpaRepository<Valider, Long>{
	
	//lakile telo
	
	@Query("SELECT v FROM Valider v WHERE v.id = ?1 and canevas = 'L3'")
	Optional<Valider> findByL3(Long id);
	
	@Query("SELECT v FROM Valider v where  canevas = 'L3'")
	List<Valider> findAllL3();
	
	@Query(value = "SELECT CASE WHEN sum(nbr_h + nbr_f) IS NULL THEN 0 ELSE sum(nbr_h + nbr_f) END AS total FROM Valider where  canevas = 'L3' AND date_suivi BETWEEN cast(TO_DATE('01/01/2020', 'DD/MM/YYYY') as date) and cast(TO_DATE(:dateChronologique, 'DD/MM/YYYY') as date) and operationnel ", nativeQuery = true)
	int countL3Operationnel(String dateChronologique);
	
	@Query(value = "SELECT CASE WHEN sum(nbr_h) IS NULL THEN 0 ELSE sum(nbr_h) END AS h FROM Valider where  canevas = 'L3' and sexe in ('h', 'H')  AND date_suivi BETWEEN cast(TO_DATE('01/01/2020', 'DD/MM/YYYY') as date) and cast(TO_DATE(:dateChronologique, 'DD/MM/YYYY') as date) and operationnel", nativeQuery = true)
	int countL3HOperationnel(String dateChronologique);
	
	@Query(value = "SELECT CASE WHEN sum(nbr_f) IS NULL THEN 0 ELSE sum(nbr_f) END AS f FROM Valider where  canevas = 'L3' and sexe in ('f', 'H')  AND date_suivi BETWEEN cast(TO_DATE('01/01/2020', 'DD/MM/YYYY') as date) and cast(TO_DATE(:dateChronologique, 'DD/MM/YYYY') as date) and operationnel", nativeQuery = true)
	int countL3FOperationnel(String dateChronologique);
	
	@Query(value = "SELECT count(*) FROM Valider where  canevas = 'L3' AND date_suivi BETWEEN cast(TO_DATE('01/01/2020', 'DD/MM/YYYY') as date) and cast(TO_DATE(:dateChronologique, 'DD/MM/YYYY') as date) and operationnel and categorie = 'VSLA'", nativeQuery = true)
	int countL3OperationnelVSLA(String dateChronologique);
	
	@Query(value = "SELECT count(*) FROM Valider where  canevas = 'L3' AND date_suivi BETWEEN cast(TO_DATE('01/01/2020', 'DD/MM/YYYY') as date) and cast(TO_DATE(:dateChronologique, 'DD/MM/YYYY') as date) and operationnel and categorie = 'VSLA' and sexe in ('h', 'H')", nativeQuery = true)
	int countL3HOperationnelVSLA(String dateChronologique);
	
	@Query(value = "SELECT count(*) FROM Valider where  canevas = 'L3' AND date_suivi BETWEEN cast(TO_DATE('01/01/2020', 'DD/MM/YYYY') as date) and cast(TO_DATE(:dateChronologique, 'DD/MM/YYYY') as date) and operationnel and categorie = 'VSLA' and sexe in ('f', 'F')", nativeQuery = true)
	int countL3FOperationnelVSLA(String dateChronologique);
	
	@Query(value = "SELECT CASE WHEN sum(nbr_h + nbr_f) IS NULL THEN 0 ELSE sum(nbr_h + nbr_f) END AS total FROM Valider where  canevas = 'L3' AND date_suivi BETWEEN cast(TO_DATE('01/01/2020', 'DD/MM/YYYY') as date) and cast(TO_DATE(:dateChronologique, 'DD/MM/YYYY') as date) and operationnel and categorie = 'GEC'", nativeQuery = true)
	int countL3OperationnelGEC(String dateChronologique);
	
	@Query(value = "SELECT CASE WHEN sum(nbr_h) IS NULL THEN 0 ELSE sum(nbr_h) END AS h FROM Valider where  canevas = 'L3' AND date_suivi BETWEEN cast(TO_DATE('01/01/2020', 'DD/MM/YYYY') as date) and cast(TO_DATE(:dateChronologique, 'DD/MM/YYYY') as date) and operationnel and categorie = 'GEC' and sexe in ('h', 'H')", nativeQuery = true)
	int countL3HOperationnelGEC(String dateChronologique);
	
	@Query(value = "SELECT CASE WHEN sum(nbr_f) IS NULL THEN 0 ELSE sum(nbr_f) END AS f FROM Valider where  canevas = 'L3' AND date_suivi BETWEEN cast(TO_DATE('01/01/2020', 'DD/MM/YYYY') as date) and cast(TO_DATE(:dateChronologique, 'DD/MM/YYYY') as date) and operationnel and categorie = 'GEC' and sexe in ('f', 'H')", nativeQuery = true)
	int countL3FOperationnelGEC(String dateChronologique);
	
	//VSLA
	@Query("SELECT v FROM Valider v WHERE v.id = ?1 and canevas = 'VSLA'")
	Optional<Valider> findByIdVSLA(Long id);
	
	@Query("SELECT v FROM Valider v where  canevas = 'VSLA'")
	List<Valider> findAllVSLA();
	
	@Query(value = "SELECT count(*) FROM Valider where  canevas = 'VSLA' and operationnel and vsla_lier_regionale and appuis_recus", nativeQuery = true)
	int countVSLAOperationnel();
	
	@Query(value = "SELECT count(*) FROM Valider where  canevas = 'VSLA' and sexe in ('homme', 'h') and operationnel and vsla_lier_regionale and appuis_recus", nativeQuery = true)
	int countVSLAHOperationnel();
	
	@Query(value = "SELECT count(*) FROM Valider where  canevas = 'VSLA' and sexe in ('femme', 'f') and operationnel and vsla_lier_regionale and appuis_recus", nativeQuery = true)
	int countVSLAFOperationnel();
	
	//FBS
	@Query("SELECT v FROM Valider v WHERE v.id = ?1 and canevas = 'FBS'")
	Optional<Valider> findByIdFBS(Long id);
	
	@Query("SELECT v FROM Valider v where  canevas = 'FBS'")
	List<Valider> findAllFBS();
	/*
	@Query("SELECT count(*) FROM Valider where  canevas = 'FBS'")
	int countFBS();
	
	@Query("SELECT count(*) FROM Valider where  canevas = 'FBS' and sexe in ('homme', 'h')")
	int countFBSH();
	
	@Query("SELECT count(*) FROM Valider where  canevas = 'FBS' and sexe in ('femme', 'f')")
	int countFBSF();
	*/
	
	//Mobile money
	@Query("SELECT v FROM Valider v WHERE v.id = ?1 and canevas = 'Mobile'")
	Optional<Valider> findByIdMoney(Long id);
	
	@Query("SELECT v FROM Valider v where  canevas = 'Mobile'")
	List<Valider> findAllMobileMoney();
	
	@Query(value = "SELECT count(*) FROM Valider where  canevas = 'Mobile' AND date_suivi BETWEEN cast(TO_DATE('01/01/2020', 'DD/MM/YYYY') as date) and cast(TO_DATE(:dateChronologique, 'DD/MM/YYYY') as date) and service_mobile_money", nativeQuery = true)
	int countMobileMoney(String dateChronologique);
	
	@Query(value = "SELECT count(*) FROM Valider where  canevas = 'Mobile' and sexe in ('homme', 'h') AND date_suivi BETWEEN cast(TO_DATE('01/01/2020', 'DD/MM/YYYY') as date) and cast(TO_DATE(:dateChronologique, 'DD/MM/YYYY') as date) and service_mobile_money", nativeQuery = true)
	int countMobileMoneyH(String dateChronologique);
	
	@Query(value = "SELECT count(*) FROM Valider where  canevas = 'Mobile' and sexe in ('femme', 'f') AND date_suivi BETWEEN cast(TO_DATE('01/01/2020', 'DD/MM/YYYY') as date) and cast(TO_DATE(:dateChronologique, 'DD/MM/YYYY') as date) and service_mobile_money", nativeQuery = true)
	int countMobileMoneyF(String dateChronologique);
	
	//Finance
	@Query("SELECT v FROM Valider v WHERE v.id = ?1 and canevas = 'Finance'")
	Optional<Valider> findByIdFinance(Long id);
	
	@Query("SELECT v FROM Valider v where  canevas = 'Finance'")
	List<Valider> findAllFinance();
	
	@Query(value = "SELECT count(*) FROM Valider where  canevas = 'Finance' AND date_suivi BETWEEN cast(TO_DATE('01/01/2020', 'DD/MM/YYYY') as date) and cast(TO_DATE(:dateChronologique, 'DD/MM/YYYY') as date)", nativeQuery = true)
	int countFinance(String dateChronologique);
	
	@Query(value = "SELECT count(*) FROM Valider where  canevas = 'Finance' AND date_suivi BETWEEN cast(TO_DATE('01/01/2020', 'DD/MM/YYYY') as date) and cast(TO_DATE(:dateChronologique, 'DD/MM/YYYY') as date) and sexe in ('homme', 'h') and service_IMF", nativeQuery = true)
	int countFinanceH(String dateChronologique);
	
	@Query(value = "SELECT count(*) FROM Valider where  canevas = 'Finance' AND date_suivi BETWEEN cast(TO_DATE('01/01/2020', 'DD/MM/YYYY') as date) and cast(TO_DATE(:dateChronologique, 'DD/MM/YYYY') as date) and sexe in ('femme', 'f') and service_IMF", nativeQuery = true)
	int countFinanceF(String dateChronologique);
	
	//Producteur
	@Query("SELECT v FROM Valider v WHERE v.id = ?1 and canevas = 'Producteur'")
	Optional<Valider> findByIdProducteur(Long id);
	
	@Query("SELECT v FROM Valider v where  canevas = 'Producteur'")
	List<Valider> findAllProducteur();
	
	@Query(value = "SELECT count(*) FROM Valider where  canevas = 'Producteur' AND date_suivi BETWEEN cast(TO_DATE('01/01/2020', 'DD/MM/YYYY') as date) and cast(TO_DATE(:dateChronologique, 'DD/MM/YYYY') as date) and annee_adhesion = EXTRACT(YEAR FROM CURRENT_DATE)", nativeQuery = true)
	int countProducteur(String dateChronologique);
	
	@Query(value = "SELECT count(*) FROM Valider where  canevas = 'Producteur' AND date_suivi BETWEEN cast(TO_DATE('01/01/2020', 'DD/MM/YYYY') as date) and cast(TO_DATE(:dateChronologique, 'DD/MM/YYYY') as date) and sexe in ('homme', 'h') and annee_adhesion = EXTRACT(YEAR FROM CURRENT_DATE)", nativeQuery = true)
	int countProducteurH(String dateChronologique);
	
	@Query(value = "SELECT count(*) FROM Valider where  canevas = 'Producteur' AND date_suivi BETWEEN cast(TO_DATE('01/01/2020', 'DD/MM/YYYY') as date) and cast(TO_DATE(:dateChronologique, 'DD/MM/YYYY') as date) and sexe in ('femme', 'f') and annee_adhesion = EXTRACT(YEAR FROM CURRENT_DATE)", nativeQuery = true)
	int countProducteurF(String dateChronologique);
	
	//Adhesion
	@Query("SELECT v FROM Valider v WHERE v.id = ?1 and canevas = 'Adhesion'")
	Optional<Valider> findByIdAdhesion(Long id);
	
	@Query("SELECT v FROM Valider v where  canevas = 'Adhesion'")
	List<Valider> findAllAdhesion();
	
	@Query(value = "SELECT count(*) FROM Valider where  canevas = 'Adhesion' AND date_suivi BETWEEN cast(TO_DATE('01/01/2020', 'DD/MM/YYYY') as date) and cast(TO_DATE(:dateChronologique, 'DD/MM/YYYY') as date) and annee_adhesion = EXTRACT(YEAR FROM CURRENT_DATE)", nativeQuery = true)
	int countAdhesion(String dateChronologique);
	
	@Query(value = "SELECT count(*) FROM Valider where  canevas = 'Adhesion' AND date_suivi BETWEEN cast(TO_DATE('01/01/2020', 'DD/MM/YYYY') as date) and cast(TO_DATE(:dateChronologique, 'DD/MM/YYYY') as date) and sexe in ('homme', 'h') and annee_adhesion = EXTRACT(YEAR FROM CURRENT_DATE)", nativeQuery = true)
	int countAdhesionH(String dateChronologique);
	
	@Query(value = "SELECT count(*) FROM Valider where  canevas = 'Adhesion' AND date_suivi BETWEEN cast(TO_DATE('01/01/2020', 'DD/MM/YYYY') as date) and cast(TO_DATE(:dateChronologique, 'DD/MM/YYYY') as date) and sexe in ('femme', 'f') and annee_adhesion = EXTRACT(YEAR FROM CURRENT_DATE)", nativeQuery = true)
	int countAdhesionF(String dateChronologique);
	
	//Menage
	@Query("SELECT v FROM Valider v WHERE v.id = ?1 and canevas = 'Menage'")
	Optional<Valider> findByIdMenage(Long id);
	
	@Query(value = "SELECT v FROM Valider v where  canevas = 'Menage'")
	List<Valider> findAllMenage();
	
	@Query(value = "SELECT count(*)  FROM Valider where  canevas = 'Menage' AND date_suivi BETWEEN cast(TO_DATE('01/01/2020', 'DD/MM/YYYY') as date) and cast(TO_DATE(:dateChronologique, 'DD/MM/YYYY') as date) and annee_adhesion = EXTRACT(YEAR FROM CURRENT_DATE)", nativeQuery = true)
	int countMenage(String dateChronologique);
	
	@Query(value = "SELECT count(*)  FROM Valider where  canevas = 'Menage' AND date_suivi BETWEEN cast(TO_DATE('01/01/2020', 'DD/MM/YYYY') as date) and cast(TO_DATE(:dateChronologique, 'DD/MM/YYYY') as date) and sexe in ('homme', 'h') and annee_adhesion = EXTRACT(YEAR FROM CURRENT_DATE)", nativeQuery = true)
	int countMenageH(String dateChronologique);
	
	@Query(value = "SELECT count(*)  FROM Valider where  canevas = 'Menage' AND date_suivi BETWEEN cast(TO_DATE('01/01/2020', 'DD/MM/YYYY') as date) and cast(TO_DATE(:dateChronologique, 'DD/MM/YYYY') as date) and sexe in ('femme', 'f') and annee_adhesion = EXTRACT(YEAR FROM CURRENT_DATE)", nativeQuery = true)
	int countMenageF(String dateChronologique);

}
