package com.Giz.service.metier;

import java.util.List;

import com.Giz.data.domain.Info_parcelle_divers;

public interface Info_parcelle_diversService {

	List<Info_parcelle_divers> ListInfo_parcelle_divers(String code_prod);

	List<Info_parcelle_divers> ListInfo_parcelle_diversAll();

}
