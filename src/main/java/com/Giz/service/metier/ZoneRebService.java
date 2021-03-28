package com.Giz.service.metier;

import java.util.Date;
import java.util.List;

import com.Giz.data.domain.ZoneReboise;


public interface ZoneRebService {


	public List<ZoneReboise> ListZoneReboise();

	public void deleteZoneReboise(Long id_zr);
	
	public void addZoneReboise(String code_village, boolean exist_zr, float superficies, int jeunePlant,
			int nbrTotalJeune, Date date_suivi);
	
	
	public void modifyZoneReboise(ZoneReboise zoneReboise,String code_village, boolean exist_zr, float superficies, int jeunePlant,
			int nbrTotalJeune, Date date_suivi, Long id_zr);

	public void deleteAllZR();
	
}
