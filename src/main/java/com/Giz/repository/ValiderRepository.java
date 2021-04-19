package com.Giz.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Giz.data.domain.Valider;

@Repository
public interface ValiderRepository extends JpaRepository<Valider, Long> {

	@Query(value="SELECT valider.created_by, valider.creation_date, valider.last_modified_by, valider.last_modified_date FROM valider WHERE canevas = ?1", nativeQuery = true)
	List<Object[]> historiqueList(String canevas);
	
	// lakile telo
	
	@Modifying
    @Transactional
    @Query("delete from Valider v where canevas = ?1")
    void deleteAllCanevasWp2(String canevas);

	@Query("SELECT v FROM Valider v WHERE v.id = ?1 and canevas = 'L3'")
	Optional<Valider> findByL3(Long id);

	@Query("SELECT v FROM Valider v where  canevas = 'L3'")
	List<Valider> findAllL3();

	@Query(value = "SELECT CASE WHEN sum(nbr_h + nbr_f) IS NULL THEN 0 ELSE sum(nbr_h + nbr_f) END AS total FROM Valider where  canevas = 'L3' AND date_suivi BETWEEN cast(TO_DATE('01/01/2020', 'DD/MM/YYYY') as date) and cast(TO_DATE(:dateChronologique, 'DD/MM/YYYY') as date) and operationnel ", nativeQuery = true)
	int countL3Operationnel(String dateChronologique);

	@Query(value = "SELECT CASE WHEN sum(nbr_h) IS NULL THEN 0 ELSE sum(nbr_h) END AS h FROM Valider where  canevas = 'L3' AND date_suivi BETWEEN cast(TO_DATE('01/01/2020', 'DD/MM/YYYY') as date) and cast(TO_DATE(:dateChronologique, 'DD/MM/YYYY') as date) and operationnel", nativeQuery = true)
	int countL3HOperationnel(String dateChronologique);

	@Query(value = "SELECT CASE WHEN sum(nbr_f) IS NULL THEN 0 ELSE sum(nbr_f) END AS f FROM Valider where  canevas = 'L3'   AND date_suivi BETWEEN cast(TO_DATE('01/01/2020', 'DD/MM/YYYY') as date) and cast(TO_DATE(:dateChronologique, 'DD/MM/YYYY') as date) and operationnel", nativeQuery = true)
	int countL3FOperationnel(String dateChronologique);

	@Query(value = "SELECT CASE WHEN sum(nbr_h + nbr_f) IS NULL THEN 0 ELSE sum(nbr_h + nbr_f) END AS total FROM Valider where  canevas = 'L3' AND date_suivi BETWEEN cast(TO_DATE('01/01/2020', 'DD/MM/YYYY') as date) and cast(TO_DATE(:dateChronologique, 'DD/MM/YYYY') as date) and operationnel and categorie = 'VSLA'", nativeQuery = true)
	int countL3OperationnelVSLA(String dateChronologique);

	@Query(value = "SELECT CASE WHEN sum(nbr_h) IS NULL THEN 0 ELSE sum(nbr_h) END AS h FROM Valider where  canevas = 'L3' AND date_suivi BETWEEN cast(TO_DATE('01/01/2020', 'DD/MM/YYYY') as date) and cast(TO_DATE(:dateChronologique, 'DD/MM/YYYY') as date) and operationnel and categorie = 'VSLA'", nativeQuery = true)
	int countL3HOperationnelVSLA(String dateChronologique);

	@Query(value = "SELECT CASE WHEN sum(nbr_f) IS NULL THEN 0 ELSE sum(nbr_f) END AS f FROM Valider where  canevas = 'L3' AND date_suivi BETWEEN cast(TO_DATE('01/01/2020', 'DD/MM/YYYY') as date) and cast(TO_DATE(:dateChronologique, 'DD/MM/YYYY') as date) and operationnel and categorie = 'VSLA'", nativeQuery = true)
	int countL3FOperationnelVSLA(String dateChronologique);

	@Query(value = "SELECT CASE WHEN sum(nbr_h + nbr_f) IS NULL THEN 0 ELSE sum(nbr_h + nbr_f) END AS total FROM Valider where  canevas = 'L3' AND date_suivi BETWEEN cast(TO_DATE('01/01/2020', 'DD/MM/YYYY') as date) and cast(TO_DATE(:dateChronologique, 'DD/MM/YYYY') as date) and operationnel and categorie = 'GEC'", nativeQuery = true)
	int countL3OperationnelGEC(String dateChronologique);

	@Query(value = "SELECT CASE WHEN sum(nbr_h) IS NULL THEN 0 ELSE sum(nbr_h) END AS h FROM Valider where  canevas = 'L3' AND date_suivi BETWEEN cast(TO_DATE('01/01/2020', 'DD/MM/YYYY') as date) and cast(TO_DATE(:dateChronologique, 'DD/MM/YYYY') as date) and operationnel and categorie = 'GEC'", nativeQuery = true)
	int countL3HOperationnelGEC(String dateChronologique);

	@Query(value = "SELECT CASE WHEN sum(nbr_f) IS NULL THEN 0 ELSE sum(nbr_f) END AS f FROM Valider where  canevas = 'L3' AND date_suivi BETWEEN cast(TO_DATE('01/01/2020', 'DD/MM/YYYY') as date) and cast(TO_DATE(:dateChronologique, 'DD/MM/YYYY') as date) and operationnel and categorie = 'GEC'", nativeQuery = true)
	int countL3FOperationnelGEC(String dateChronologique);

	// VSLA
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

	// FBS
	@Query("SELECT v FROM Valider v WHERE v.id = ?1 and canevas = 'FBS'")
	Optional<Valider> findByIdFBS(Long id);

	@Query("SELECT v FROM Valider v where  canevas = 'FBS'")
	List<Valider> findAllFBS();

	@Query(value = "SELECT count(*) FROM Valider where  canevas = 'FBS' AND date_suivi BETWEEN cast(TO_DATE('01/01/2020', 'DD/MM/YYYY') as date) and cast(TO_DATE(:dateChronologique, 'DD/MM/YYYY') as date) and fbs_post_fbs_recus and education_fbs_post_fbs", nativeQuery = true)
	int countFBS(String dateChronologique);

	/*
	 * @Query("SELECT count(*) FROM Valider where  canevas = 'FBS'") int countFBS();
	 * 
	 * @Query("SELECT count(*) FROM Valider where  canevas = 'FBS' and sexe in ('homme', 'h')"
	 * ) int countFBSH();
	 * 
	 * @Query("SELECT count(*) FROM Valider where  canevas = 'FBS' and sexe in ('femme', 'f')"
	 * ) int countFBSF();
	 */

	// Mobile money
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

	// Finance
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

	// Producteur
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

	// Adhesion
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

	// Menage
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
	
	// TABLEAU SUM

	@Query(value = "SELECT village.code_village,village.village,sum(Valider.nbr_h) as H,sum(Valider.nbr_f) as F FROM village,Valider WHERE village.code_village=Valider.code_village AND Valider.code_village "
			+ " IN (null, ?3) AND Valider.date_suivi BETWEEN ?1 AND ?2 AND\r\n" + " Valider.canevas = ?4 \r\n"
			+ "GROUP BY village.code_village,village.village", nativeQuery = true)
	List<Object[]> TableDataSum(Date debut_date, Date fin_date, List<String> params, String canevas);

	@Query(value = "SELECT village.commune,sum(Valider.nbr_h) as H,sum(Valider.nbr_f) as F FROM"
			+ " village,Valider WHERE Valider.canevas = ?3 AND village.code_village=Valider.code_village AND "
			+ " Valider.date_suivi BETWEEN ?1 AND ?2 \r\n" + "GROUP BY village.commune", nativeQuery = true)
	List<Object[]> TableDataCommuneSum(Date debut_date, Date fin_date, String canevas);

	@Query(value = "SELECT village.district,sum(Valider.nbr_h) as H,sum(Valider.nbr_f) as F FROM"
			+ " village,Valider WHERE Valider.canevas = ?3 AND village.code_village=Valider.code_village "
			+ " AND Valider.date_suivi BETWEEN ?1 AND ?2 \r\n" + "GROUP BY village.district", nativeQuery = true)
	List<Object[]> TableDataDistSum(Date debut_date, Date fin_date, String canevas);
	
	// TABLEAU COUNT
	
	@Query(value = "SELECT village.code_village,village.village,count(Valider.sexe) as nbr, upper(Valider.sexe), Valider.canevas FROM"
			+ " village,Valider WHERE upper(Valider.sexe)=?4 AND village.code_village=Valider.code_village AND Valider.code_village "
			+ " IN (null, ?3) AND Valider.date_suivi BETWEEN ?1 AND ?2 AND\r\n" + " Valider.canevas = ?5 \r\n" + 
			"GROUP BY village.code_village,village.village, Valider.sexe, Valider.canevas", nativeQuery = true)
	List<Object[]> TableDataCount(Date debut_date,Date fin_date,List<String> params,String sexe, String canevas);
	
	@Query(value = "SELECT village.commune,count(Valider.sexe) as nbr, upper(Valider.sexe), Valider.canevas FROM"
			+ " village,Valider WHERE upper(Valider.sexe)=?3 AND village.code_village=Valider.code_village AND "
			+ " Valider.date_suivi BETWEEN ?1 AND ?2 AND\r\n" + " Valider.canevas = ?4 \r\n" + 
			"GROUP BY village.commune, Valider.sexe, Valider.Canevas", nativeQuery = true)
	List<Object[]> TableDataCommuneCount(Date debut_date,Date fin_date, String sexe, String canevas);
	
	@Query(value = "SELECT village.district,count(Valider.sexe) as nbr, upper(Valider.sexe), Valider.canevas FROM"
			+ " village,Valider WHERE upper(Valider.sexe)=?3 AND village.code_village=Valider.code_village "
			+ " AND Valider.date_suivi BETWEEN ?1 AND ?2 AND\r\n" + " Valider.canevas = ?4 \r\n" + 
			"GROUP BY village.district, Valider.sexe, Valider.canevas", nativeQuery = true)
	List<Object[]> TableDataDistCount(Date debut_date,Date fin_date,String sexe, String canevas);
	
	@Query(value = "select hommes.code_village,hommes.village,hommes.homme,femmes.femme,hommes.canevas\r\n"
			+ "	from (SELECT village.code_village,village.village,count(Valider.sexe) as homme, Valider.canevas FROM"
			+ "	 village,Valider WHERE upper(Valider.sexe)= 'H' AND village.code_village=Valider.code_village AND Valider.code_village \r\n"
			+ " IN (null, ?3) AND Valider.date_suivi BETWEEN ?1 AND ?2 AND\r\n" + " Valider.canevas = ?4 \r\n"
			+ "GROUP BY village.code_village,village.village, Valider.canevas) as hommes,\r\n"
			+ "	(SELECT village.code_village,village.village,count(Valider.sexe) as femme, Valider.canevas FROM\r\n"
			+ "	 village,Valider WHERE upper(Valider.sexe) = 'F' AND village.code_village=Valider.code_village AND Valider.code_village \r\n"
			+ " IN (null, ?3) AND Valider.date_suivi BETWEEN ?1 AND ?2 AND\r\n" + " Valider.canevas = ?4 \r\n"
			+ "GROUP BY village.code_village,village.village, Valider.canevas) as femmes where hommes.village=femmes.village AND hommes.canevas=femmes.canevas", nativeQuery = true)
	List<Object[]> TableDataAllCount(Date debut_date, Date fin_date, List<String> params, String canevas);
	
	@Query(value = "select hommes.commune,hommes.homme,femmes.femme,hommes.canevas\r\n"
			+ "	from (SELECT village.commune,count(Valider.sexe) as homme, Valider.canevas FROM\r\n"
			+ "	 village,Valider WHERE village.code_village=Valider.code_village AND\r\n"
			+ "	Valider.date_suivi BETWEEN ?1 AND ?2 \r\n" + "	and upper(Valider.sexe) = 'H' AND \r\n" + " Valider.canevas = ?3 \r\n"
			+ "	GROUP BY village.commune, Valider.canevas) as hommes,\r\n"
			+ "	(SELECT village.commune,count(Valider.sexe) as femme, Valider.canevas FROM\r\n"
			+ "	 village,Valider WHERE village.code_village=Valider.code_village AND\r\n"
			+ "	Valider.date_suivi BETWEEN ?1 AND ?2 \r\n" + " and upper(Valider.sexe) = 'F' AND\r\n" + " Valider.canevas = ?3 \r\n"
			+ "	GROUP BY village.commune, Valider.canevas) as femmes where hommes.commune=femmes.commune AND hommes.canevas=femmes.canevas", nativeQuery = true)
	List<Object[]> TableDataCommuneAllCount(Date debut_date, Date fin_date, String canevas);
	
	@Query(value = "select hommes.district,hommes.homme,femmes.femme,hommes.canevas\r\n"
			+ "	from (SELECT village.district,count(Valider.sexe) as homme, Valider.canevas FROM\r\n"
			+ "	 village,Valider WHERE village.code_village=Valider.code_village AND\r\n"
			+ "	Valider.date_suivi BETWEEN ?1 AND ?2 \r\n" + "	and upper(Valider.sexe) = 'H' AND\r\n"
			+ " Valider.canevas = ?3 \r\n"
			+ "	GROUP BY village.district, Valider.canevas) as hommes,\r\n"
			+ "	(SELECT village.district,count(Valider.sexe) as femme, Valider.canevas FROM\r\n"
			+ "	 village,Valider WHERE village.code_village=Valider.code_village AND\r\n"
			+ "	Valider.date_suivi BETWEEN ?1 AND ?2 \r\n" + " and upper(Valider.sexe) = 'F' AND\r\n"
			+ " Valider.canevas = ?3 \r\n"
			+ "	GROUP BY village.district, Valider.canevas) as femmes where hommes.district=femmes.district AND hommes.canevas=femmes.canevas", nativeQuery = true)
	List<Object[]> TableDataDistAllCount(Date debut_date, Date fin_date, String canevas);
	
		// TABLEAU COUNT SANS DATE
	
		@Query(value = "SELECT village.code_village,village.village,count(Valider.sexe) as nbr, upper(Valider.sexe) , Valider.canevas FROM"
				+ " village,Valider WHERE upper(Valider.sexe)=?2 AND village.code_village=Valider.code_village AND Valider.code_village "
				+ " IN (null, ?1) AND\r\n" + " Valider.canevas = ?3 \r\n" + 
				"GROUP BY village.code_village,village.village, Valider.sexe, Valider.canevas", nativeQuery = true)
		List<Object[]> TableDataCountNoDate(List<String> params,String sexe, String canevas);
		
		@Query(value = "SELECT village.commune,count(Valider.sexe) as nbr, upper(Valider.sexe) , Valider.canevas FROM"
				+ " village,Valider WHERE upper(Valider.sexe)=?1 AND village.code_village=Valider.code_village AND "
				+ " Valider.canevas = ?2 \r\n" + 
				"GROUP BY village.commune, Valider.sexe, Valider.canevas", nativeQuery = true)
		List<Object[]> TableDataCommuneCountNoDate(String sexe, String canevas);
		
		@Query(value = "SELECT village.district,count(Valider.sexe) as nbr, upper(Valider.sexe) , Valider.canevas FROM"
				+ " village,Valider WHERE upper(Valider.sexe)=?1 AND village.code_village=Valider.code_village "
				+ " AND Valider.canevas = ?2 \r\n" + 
				"GROUP BY village.district, Valider.sexe, Valider.canevas", nativeQuery = true)
		List<Object[]> TableDataDistCountNoDate(String sexe, String canevas);
		
		@Query(value = "select hommes.code_village,hommes.village,hommes.homme,femmes.femme, hommes.canevas\r\n"
				+ "	from (SELECT village.code_village,village.village,count(Valider.sexe) as homme, Valider.canevas FROM"
				+ "	 village,Valider WHERE upper(Valider.sexe)= 'H' AND village.code_village=Valider.code_village AND Valider.code_village \r\n"
				+ " IN (null, ?1) AND\r\n" + " Valider.canevas = ?2 \r\n"
				+ "GROUP BY village.code_village,village.village, Valider.canevas) as hommes,\r\n"
				+ "	(SELECT village.code_village,village.village,count(Valider.sexe) as femme, Valider.canevas FROM\r\n"
				+ "	 village,Valider WHERE upper(Valider.sexe) = 'F' AND village.code_village=Valider.code_village AND Valider.code_village \r\n"
				+ " IN (null, ?1) AND\r\n" + " Valider.canevas = ?2 \r\n"
				+ "GROUP BY village.code_village,village.village, Valider.canevas) as femmes where hommes.village=femmes.village AND hommes.canevas=femmes.canevas", nativeQuery = true)
		List<Object[]> TableDataAllCountNoDate(List<String> params, String canevas);
		
		@Query(value = "select hommes.commune,hommes.homme,femmes.femme, hommes.canevas\r\n"
				+ "	from (SELECT village.commune,count(Valider.sexe) as homme, Valider.canevas FROM\r\n"
				+ "	 village,Valider WHERE village.code_village=Valider.code_village AND\r\n"
				+ "	upper(Valider.sexe) = 'H' AND \r\n" + " Valider.canevas = ?1 \r\n"
				+ "	GROUP BY village.commune, Valider.canevas) as hommes,\r\n"
				+ "	(SELECT village.commune,count(Valider.sexe) as femme, Valider.canevas FROM\r\n"
				+ "	 village,Valider WHERE village.code_village=Valider.code_village AND\r\n"
				+ " upper(Valider.sexe) = 'F' AND\r\n" + " Valider.canevas = ?1 \r\n"
				+ "	GROUP BY village.commune, Valider.canevas) as femmes where hommes.commune=femmes.commune AND hommes.canevas=femmes.canevas", nativeQuery = true)
		List<Object[]> TableDataCommuneAllCountNoDate(String canevas);
		
		@Query(value = "select hommes.district,hommes.homme,femmes.femme, hommes.canevas\r\n"
				+ "	from (SELECT village.district,count(Valider.sexe) as homme, Valider.canevas FROM\r\n"
				+ "	 village,Valider WHERE village.code_village=Valider.code_village AND\r\n"
				+ "	upper(Valider.sexe) = 'H' AND\r\n"
				+ " Valider.canevas = ?1 \r\n"
				+ "	GROUP BY village.district, Valider.canevas) as hommes,\r\n"
				+ "	(SELECT village.district,count(Valider.sexe) as femme, Valider.canevas FROM\r\n"
				+ "	 village,Valider WHERE village.code_village=Valider.code_village AND\r\n"
			    + " upper(Valider.sexe) = 'F' AND\r\n"
				+ " Valider.canevas = ?1 \r\n"
				+ "	GROUP BY village.district, Valider.canevas) as femmes where hommes.district=femmes.district AND hommes.canevas=femmes.canevas", nativeQuery = true)
		List<Object[]> TableDataDistAllCountNoDate(String canevas);
		
		// TABLEAU COUNT NO SEXE
		
		@Query(value = "SELECT village.village,count(Valider.code_village) as nbr FROM"
				+ " village,Valider WHERE village.code_village=Valider.code_village AND Valider.code_village "
				+ " IN (null, ?3) AND Valider.date_suivi BETWEEN ?1 AND ?2 AND\r\n" + " Valider.canevas = ?4 \r\n" + 
				"GROUP BY village.village", nativeQuery = true)
		List<Object[]> TableDataCountNoSexe(Date debut_date,Date fin_date,List<String> params, String canevas);
		
		@Query(value = "SELECT village.commune,count(Valider.code_village) as nbr FROM"
				+ " village,Valider WHERE village.code_village=Valider.code_village AND "
				+ " Valider.date_suivi BETWEEN ?1 AND ?2 AND\r\n" + " Valider.canevas = ?3 \r\n" + 
				"GROUP BY village.commune", nativeQuery = true)
		List<Object[]> TableDataCommuneCountNoSexe(Date debut_date,Date fin_date, String canevas);
		
		@Query(value = "SELECT village.district,count(Valider.code_village) as nbr FROM"
				+ " village,Valider WHERE village.code_village=Valider.code_village "
				+ " AND Valider.date_suivi BETWEEN ?1 AND ?2 AND\r\n" + " Valider.canevas = ?3 \r\n" + 
				"GROUP BY village.district", nativeQuery = true)
		List<Object[]> TableDataDistCountNoSexe(Date debut_date,Date fin_date, String canevas);
		
			// VILLAGE DETAIL TABLEAU COUNT

		@Query(value = "SELECT village.code_village,COALESCE(Valider.nom_prenom,Valider.nom_usuel_adherent) FROM village,Valider WHERE"
				+ " village.code_village=Valider.code_village AND village.village = ?1  AND Valider.canevas = ?2 AND upper(Valider.sexe)= ?3 \r\n", nativeQuery = true)
		List<Object[]> TableCountDetailGenre(String village, String canevas, String sexe);
		
		@Query(value = "SELECT village.code_village,COALESCE(Valider.nom_prenom,Valider.nom_usuel_adherent)FROM village,Valider WHERE"
				+ " village.code_village=Valider.code_village AND village.village = ?1  AND Valider.canevas = ?2 \r\n", nativeQuery = true)
		List<Object[]> TableCountDetailGenreAll(String village, String canevas);
		
			// COMMUNE DETAIL TABLEAU COUNT
		
		@Query(value = "SELECT village.code_village,COALESCE(Valider.nom_prenom,Valider.nom_usuel_adherent) FROM village,Valider WHERE"
				+ " village.code_village=Valider.code_village AND village.commune = ?1  AND Valider.canevas = ?2 AND upper(Valider.sexe)= ?3 \r\n", nativeQuery = true)
		List<Object[]> TableCountDetailGenreComm(String commune, String canevas, String sexe);
		
		@Query(value = "SELECT village.code_village,COALESCE(Valider.nom_prenom,Valider.nom_usuel_adherent) FROM village,Valider WHERE"
				+ " village.code_village=Valider.code_village AND village.commune = ?1  AND Valider.canevas = ?2 \r\n", nativeQuery = true)
		List<Object[]> TableCountDetailGenreAllComm(String commune, String canevas);
		
			// DISTRICT DETAIL TABLEAU COUNT
		
		@Query(value = "SELECT village.code_village,COALESCE(Valider.nom_prenom,Valider.nom_usuel_adherent) FROM village,Valider WHERE"
				+ " village.code_village=Valider.code_village AND village.district = ?1  AND Valider.canevas = ?2 AND upper(Valider.sexe)= ?3 \r\n", nativeQuery = true)
		List<Object[]> TableCountDetailGenreDist(String district, String canevas, String sexe);
		
		@Query(value = "SELECT village.code_village,COALESCE(Valider.nom_prenom,Valider.nom_usuel_adherent) FROM village,Valider WHERE"
				+ " village.code_village=Valider.code_village AND village.district = ?1  AND Valider.canevas = ?2 \r\n", nativeQuery = true)
		List<Object[]> TableCountDetailGenreAllDist(String district, String canevas);

}
