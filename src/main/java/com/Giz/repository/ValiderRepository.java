package com.Giz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Giz.data.domain.Valider;

@Repository
public interface ValiderRepository extends JpaRepository<Valider, Long>{
	
	//lakile telo
	@Query("SELECT v FROM Valider v where  canevas = 'L3'")
	List<Valider> findAllL3();
	
	@Query(value = "SELECT count(*) FROM Valider where  canevas = 'L3' and operationnel ", nativeQuery = true)
	int countL3Operationnel();
	
	@Query(value = "SELECT count(*) FROM Valider where  canevas = 'L3' and sexe in ('homme', 'h') and operationnel", nativeQuery = true)
	int countL3HOperationnel();
	
	@Query(value = "SELECT count(*) FROM Valider where  canevas = 'L3' and sexe in ('femme', 'f') and operationnel", nativeQuery = true)
	int countL3FOperationnel();
	
	@Query(value = "SELECT count(*) FROM Valider where  canevas = 'L3' and operationnel and categorie = 'VSLA'", nativeQuery = true)
	int countL3OperationnelVSLA();
	
	@Query(value = "SELECT count(*) FROM Valider where  canevas = 'L3' and operationnel and categorie = 'VSLA' and sexe in ('homme', 'h')", nativeQuery = true)
	int countL3HOperationnelVSLA();
	
	@Query(value = "SELECT count(*) FROM Valider where  canevas = 'L3' and operationnel and categorie = 'VSLA' and sexe in ('femme', 'f')", nativeQuery = true)
	int countL3FOperationnelVSLA();
	
	@Query(value = "SELECT count(*) FROM Valider where  canevas = 'L3' and operationnel and categorie = 'GEC'", nativeQuery = true)
	int countL3OperationnelGEC();
	
	@Query(value = "SELECT count(*) FROM Valider where  canevas = 'L3' and operationnel and categorie = 'GEC' and sexe in ('homme', 'h')", nativeQuery = true)
	int countL3HOperationnelGEC();
	
	@Query(value = "SELECT count(*) FROM Valider where  canevas = 'L3' and operationnel and categorie = 'GEC' and sexe in ('femme', 'f')", nativeQuery = true)
	int countL3FOperationnelGEC();
	
	//VSLA
	@Query("SELECT v FROM Valider v where  canevas = 'VSLA'")
	List<Valider> findAllVSLA();
	
	@Query(value = "SELECT count(*) FROM Valider where  canevas = 'VSLA' and operationnel and vsla_lier_regionale and appuis_recus", nativeQuery = true)
	int countVSLAOperationnel();
	
	@Query(value = "SELECT count(*) FROM Valider where  canevas = 'VSLA' and sexe in ('homme', 'h') and operationnel and vsla_lier_regionale and appuis_recus", nativeQuery = true)
	int countVSLAHOperationnel();
	
	@Query(value = "SELECT count(*) FROM Valider where  canevas = 'VSLA' and sexe in ('femme', 'f') and operationnel and vsla_lier_regionale and appuis_recus", nativeQuery = true)
	int countVSLAFOperationnel();
	
	//FBS
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
	@Query("SELECT v FROM Valider v where  canevas = 'Mobile'")
	List<Valider> findAllMobileMoney();
	
	@Query(value = "SELECT count(*) FROM Valider where  canevas = 'Mobile' and service_mobile_money", nativeQuery = true)
	int countMobileMoney();
	
	@Query(value = "SELECT count(*) FROM Valider where  canevas = 'Mobile' and sexe in ('homme', 'h') and service_mobile_money", nativeQuery = true)
	int countMobileMoneyH();
	
	@Query(value = "SELECT count(*) FROM Valider where  canevas = 'Mobile' and sexe in ('femme', 'f') and service_mobile_money", nativeQuery = true)
	int countMobileMoneyF();
	
	//Finance
	@Query("SELECT v FROM Valider v where  canevas = 'Finance'")
	List<Valider> findAllFinance();
	
	@Query(value = "SELECT count(*) FROM Valider where  canevas = 'Finance'", nativeQuery = true)
	int countFinance();
	
	@Query(value = "SELECT count(*) FROM Valider where  canevas = 'Finance' and sexe in ('homme', 'h') and service_IMF", nativeQuery = true)
	int countFinanceH();
	
	@Query(value = "SELECT count(*) FROM Valider where  canevas = 'Finance' and sexe in ('femme', 'f') and service_IMF", nativeQuery = true)
	int countFinanceF();
	
	//Producteur
	@Query("SELECT v FROM Valider v where  canevas = 'Producteur'")
	List<Valider> findAllProducteur();
	
	@Query(value = "SELECT count(*) FROM Valider where  canevas = 'Producteur' and annee_adhesion = EXTRACT(YEAR FROM CURRENT_DATE)", nativeQuery = true)
	int countProducteur();
	
	@Query(value = "SELECT count(*) FROM Valider where  canevas = 'Producteur' and sexe in ('homme', 'h') and annee_adhesion = EXTRACT(YEAR FROM CURRENT_DATE)", nativeQuery = true)
	int countProducteurH();
	
	@Query(value = "SELECT count(*) FROM Valider where  canevas = 'Producteur' and sexe in ('femme', 'f') and annee_adhesion = EXTRACT(YEAR FROM CURRENT_DATE)", nativeQuery = true)
	int countProducteurF();
	
	//Adhesion
	@Query("SELECT v FROM Valider v where  canevas = 'Adhesion'")
	List<Valider> findAllAdhesion();
	
	@Query(value = "SELECT count(*) FROM Valider where  canevas = 'Adhesion' and annee_adhesion = EXTRACT(YEAR FROM CURRENT_DATE)", nativeQuery = true)
	int countAdhesion();
	
	@Query(value = "SELECT count(*) FROM Valider where  canevas = 'Adhesion' and sexe in ('homme', 'h') and annee_adhesion = EXTRACT(YEAR FROM CURRENT_DATE)", nativeQuery = true)
	int countAdhesionH();
	
	@Query(value = "SELECT count(*) FROM Valider where  canevas = 'Adhesion' and sexe in ('femme', 'f') and annee_adhesion = EXTRACT(YEAR FROM CURRENT_DATE)", nativeQuery = true)
	int countAdhesionF();
	
	//Menage
	@Query(value = "SELECT v FROM Valider v where  canevas = 'Menage'")
	List<Valider> findAllMenage();
	
	@Query(value = "SELECT count(*)  FROM Valider where  canevas = 'Menage' and annee_adhesion = EXTRACT(YEAR FROM CURRENT_DATE)", nativeQuery = true)
	int countMenage();
	
	@Query(value = "SELECT count(*)  FROM Valider where  canevas = 'Menage' and sexe in ('homme', 'h') and annee_adhesion = EXTRACT(YEAR FROM CURRENT_DATE)", nativeQuery = true)
	int countMenageH();
	
	@Query(value = "SELECT count(*)  FROM Valider where  canevas = 'Menage' and sexe in ('femme', 'f') and annee_adhesion = EXTRACT(YEAR FROM CURRENT_DATE)", nativeQuery = true)
	int countMenageF();

}
