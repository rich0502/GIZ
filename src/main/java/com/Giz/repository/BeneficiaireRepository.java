package com.Giz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Giz.data.domain.Beneficiaire;
import com.Giz.data.domain.Valider;

public interface BeneficiaireRepository extends JpaRepository<Valider, Long> {
	
	// WP2 Beneficiaire
	@Query("select new com.Giz.data.domain.Beneficiaire(v.nom_prenom, v.sexe, v.annee_naissance, v.age, v.code_village) from Valider v where v.canevas in('Mobile','Finance','Adhesion','Menage') group by v.nom_prenom, v.sexe, v.annee_naissance, v.age, v.code_village")
	List<Beneficiaire> listBeneficiaireWP2();
	
	@Query(value="select count(*) as nbr from(select nom_prenom as nom, sexe, age, annee_naissance as annee from Valider where canevas in('Mobile','Finance','Adhesion','Menage') and sexe = 'H' and ((age > 0 and age < 18) OR (annee_naissance > 0 and ((annee_naissance - EXTRACT(YEAR from cast(now() as date))) < 18))) group by nom_prenom, sexe, age, annee_naissance) as valider", nativeQuery = true)
	int getGarcon();
	
	@Query(value="select count(*) as nbr from(select nom_prenom as nom, sexe, age, annee_naissance as annee from Valider where canevas in('Mobile','Finance','Adhesion','Menage') and sexe = 'H' and (age >= 18 OR ((annee_naissance - EXTRACT(YEAR from cast(now() as date))) >= 18)) group by nom_prenom, sexe, age, annee_naissance) as valider", nativeQuery = true)
	int getHomme();
	
	@Query(value="select count(*) as nbr from(select nom_prenom as nom, sexe, age, annee_naissance as annee from Valider where canevas in('Mobile','Finance','Adhesion','Menage') and sexe = 'F' and ((age > 0 and age < 18) OR (annee_naissance > 0 and ((annee_naissance - EXTRACT(YEAR from cast(now() as date))) < 18))) group by nom_prenom, sexe, age, annee_naissance) as valider", nativeQuery = true)
	int getFille();
	
	@Query(value="select count(*) as nbr from(select nom_prenom as nom, sexe, age, annee_naissance as annee from Valider where canevas in('Mobile','Finance','Adhesion','Menage') and sexe = 'F' and (age >= 18 OR ((annee_naissance - EXTRACT(YEAR from cast(now() as date))) >= 18)) group by nom_prenom, sexe, age, annee_naissance) as valider", nativeQuery = true)
	int getFemme();
	
	// WP3 Beneficiaire
	@Query(value = "select DISTINCT nom_prenom, sexe, annee_naissance, code_village from (select nom_prenom,sexe,annee_naissance, code_village from wp3_activ_eco_jeune union all select nom_prenom,sexe,annee_naissance, code_village from wp3_unite_elev_jeune union all select nom_prenom,sexe,annee_naissance, code_village from wp3_elev_mfr union all select nom_prenom,sexe,annee_naissance, code_village from wp3_jeune_forme_mfr union all select nom_prenom,sexe,annee_naissance, code_village from wp3_eequipe_tech_mfr union all select nom_prenom,sexe,annee_naissance, code_village from wp3_jeune_pathway union all select nom_prenom,sexe,annee_naissance, code_village from wp3_peer_educator ) sub", nativeQuery = true)
	List<String> listBeneficiaireWP3();
	
	@Query(value="select count(*) as nbr from(select nom_prenom, sexe, annee_naissance from (select nom_prenom,sexe,annee_naissance from wp3_activ_eco_jeune union all select nom_prenom,sexe,annee_naissance from wp3_unite_elev_jeune union all select nom_prenom,sexe,annee_naissance from wp3_elev_mfr union all select nom_prenom,sexe,annee_naissance from wp3_jeune_forme_mfr union all select nom_prenom,sexe,annee_naissance from wp3_eequipe_tech_mfr union all select nom_prenom,sexe,annee_naissance from wp3_jeune_pathway union all select nom_prenom,sexe,annee_naissance from wp3_peer_educator ) sub where sexe = 'H' and (annee_naissance > 0 and ((annee_naissance - EXTRACT(YEAR from cast(now() as date))) < 18)) group by nom_prenom,sexe,annee_naissance) as valider", nativeQuery = true)
	int getGarconWP3();
	
	@Query(value="select count(*) as nbr from(select nom_prenom, sexe, annee_naissance from (select nom_prenom,sexe,annee_naissance from wp3_activ_eco_jeune union all select nom_prenom,sexe,annee_naissance from wp3_unite_elev_jeune union all select nom_prenom,sexe,annee_naissance from wp3_elev_mfr union all select nom_prenom,sexe,annee_naissance from wp3_jeune_forme_mfr union all select nom_prenom,sexe,annee_naissance from wp3_eequipe_tech_mfr union all select nom_prenom,sexe,annee_naissance from wp3_jeune_pathway union all select nom_prenom,sexe,annee_naissance from wp3_peer_educator ) sub where sexe = 'F' and (annee_naissance > 0 and ((annee_naissance - EXTRACT(YEAR from cast(now() as date))) < 18)) group by nom_prenom,sexe,annee_naissance) as valider", nativeQuery = true)
	int getFilleWP3();
	
	@Query(value="select count(*) as nbr from(select nom_prenom, sexe, annee_naissance from (select nom_prenom,sexe,annee_naissance from wp3_activ_eco_jeune union all select nom_prenom,sexe,annee_naissance from wp3_unite_elev_jeune union all select nom_prenom,sexe,annee_naissance from wp3_elev_mfr union all select nom_prenom,sexe,annee_naissance from wp3_jeune_forme_mfr union all select nom_prenom,sexe,annee_naissance from wp3_eequipe_tech_mfr union all select nom_prenom,sexe,annee_naissance from wp3_jeune_pathway union all select nom_prenom,sexe,annee_naissance from wp3_peer_educator ) sub where sexe = 'H' and ((annee_naissance - EXTRACT(YEAR from cast(now() as date))) >= 18) group by nom_prenom,sexe,annee_naissance) as valider", nativeQuery = true)
	int getHommeWP3();
	
	@Query(value="select count(*) as nbr from(select nom_prenom, sexe, annee_naissance from (select nom_prenom,sexe,annee_naissance from wp3_activ_eco_jeune union all select nom_prenom,sexe,annee_naissance from wp3_unite_elev_jeune union all select nom_prenom,sexe,annee_naissance from wp3_elev_mfr union all select nom_prenom,sexe,annee_naissance from wp3_jeune_forme_mfr union all select nom_prenom,sexe,annee_naissance from wp3_eequipe_tech_mfr union all select nom_prenom,sexe,annee_naissance from wp3_jeune_pathway union all select nom_prenom,sexe,annee_naissance from wp3_peer_educator ) sub where sexe = 'F' and ((annee_naissance - EXTRACT(YEAR from cast(now() as date))) >= 18) group by nom_prenom,sexe,annee_naissance) as valider", nativeQuery = true)
	int getFemmeWP3();
	
	
	
	
	
}

