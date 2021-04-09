package com.Giz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Giz.data.domain.Question_conseil_divers;

public interface Question_conseil_diversRepository extends JpaRepository<Question_conseil_divers, Long>{
	@Query(value = "SELECT * FROM Question_conseil_divers,producteur WHERE Question_conseil_divers.code_prod=producteur.code_prod AND"
		    + " producteur.code_prod = ?1", nativeQuery = true)
	List<Question_conseil_divers> findByCodeProd(String code_prod);
}
