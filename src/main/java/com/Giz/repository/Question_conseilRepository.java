package com.Giz.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Giz.data.domain.Question_conseil;

public interface Question_conseilRepository extends JpaRepository<Question_conseil, Long>{
	@Query(value = "SELECT * FROM Question_conseil,producteur WHERE Question_conseil.code_pro=producteur.code_prod AND"
		    + " producteur.code_prod = ?1", nativeQuery = true)
	List<Question_conseil> findByCodeProd(String code_prod);
	
	@Query(value = "SELECT * FROM Question_conseil where code_pro = ?1", nativeQuery = true)
	Optional<Question_conseil> existCodeProd(String code_prod);

	@Query(value = "SELECT * FROM Question_conseil,producteur WHERE Question_conseil.code_pro=producteur.code_prod AND"
		    + " producteur.zone = ?1", nativeQuery = true)
	List<Question_conseil> ListQuestion_conseilAllFkt(String zone);

	@Query(value = "SELECT * FROM Question_conseil,producteur WHERE Question_conseil.code_pro=producteur.code_prod AND"
		    + " producteur.code_fkt = ?1", nativeQuery = true)
	List<Question_conseil> ListQuestion_conseilAllProd(String code_fkt);
}
