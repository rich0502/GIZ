package com.Giz.service.metier;

import java.util.Date;
import java.util.List;

import com.Giz.data.domain.ZoneForest;


public interface ZoneForestService {


	public List<ZoneForest> ListZoneForest();

	public void deleteZoneForest(Long id_zf);
	
	public void addZoneForest(String code_village, boolean exist_zn, float superficies, Date date_suivi);
	
	
	public void modifyZoneForest(ZoneForest zoneForest,String code_village, boolean exist_zn, float superficies, Date date_suivi, Long id_zf);
	
}
