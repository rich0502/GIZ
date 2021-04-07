package com.Giz.service.metier;

import java.util.List;

public interface ProducteurService {

	List<Object[]> ListZone();

	List<Object[]> ListFkt(String zone);
	
	List<Object[]> ListProd(String code_fkt);

}
