package com.Giz.service.metier;

import java.util.List;

import com.Giz.data.domain.Info_generale;

public interface Info_generaleService {

	List<Info_generale> ListInfo_generale(String code_prod);

}
