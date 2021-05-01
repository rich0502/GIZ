package com.Giz.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Giz.data.domain.Question_conseil_divers;

public interface Question_conseil_diversRepository extends JpaRepository<Question_conseil_divers, Long>{
	@Query(value = "SELECT * FROM Question_conseil_divers,producteur WHERE Question_conseil_divers.code_prod=producteur.code_prod AND"
		    + " producteur.code_prod = ?1", nativeQuery = true)
	List<Question_conseil_divers> findByCodeProd(String code_prod);
	
	@Query(value = "SELECT * FROM Question_conseil_divers where code_prod = ?1", nativeQuery = true)
	Optional<Question_conseil_divers> existCodeProd(String code_prod);

	@Query(value = "SELECT * FROM Question_conseil_divers,producteur WHERE Question_conseil_divers.code_prod=producteur.code_prod AND"
		    + " producteur.zone = ?1", nativeQuery = true)
	List<Question_conseil_divers> ListQuestion_conseil_diversAllFkt(String zone);

	@Query(value = "SELECT * FROM Question_conseil_divers,producteur WHERE Question_conseil_divers.code_prod=producteur.code_prod AND"
		    + " producteur.code_fkt = ?1", nativeQuery = true)
	List<Question_conseil_divers> ListQuestion_conseil_diversAllProd(String code_fkt);
}
