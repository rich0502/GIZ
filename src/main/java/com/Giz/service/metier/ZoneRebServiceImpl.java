package com.Giz.service.metier;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Giz.data.domain.Adoption_innovation;
import com.Giz.data.domain.ZoneReboise;
import com.Giz.repository.Adopte_InnovationRepository;
import com.Giz.repository.ZoneReboiseRepository;

@Service
public class ZoneRebServiceImpl implements ZoneRebService {
	
	@Autowired
	private ZoneReboiseRepository zoneReboiseRepository;

	@Override
	public List<ZoneReboise> ListZoneReboise() {
		// TODO Auto-generated method stub
		return zoneReboiseRepository.findAll();
	}

	@Override
	public void deleteZoneReboise(Long id_zr) {
		zoneReboiseRepository.deleteById(id_zr);
		
	}

	@Override
	public void addZoneReboise(String code_village, boolean exist_zr, float superficies, int jeunePlant,
			int nbrTotalJeune, Date date_suivi) {
		ZoneReboise zoneReboise = new ZoneReboise();
		zoneReboise.setCode_village(code_village);
		zoneReboise.setExist_zr(exist_zr);
		zoneReboise.setSuperficies(superficies);
		zoneReboise.setJeunePlant(jeunePlant);
		zoneReboise.setNbrTotalJeune(nbrTotalJeune);
		zoneReboise.setDate_suivi(date_suivi);
		zoneReboiseRepository.save(zoneReboise);
		
	}

	@Override
	public void modifyZoneReboise(ZoneReboise zoneReboise, String code_village, boolean exist_zr, float superficies,
			int jeunePlant, int nbrTotalJeune, Date date_suivi, Long id_zr) {
		zoneReboise.setCode_village(code_village);
		zoneReboise.setExist_zr(exist_zr);
		zoneReboise.setSuperficies(superficies);
		zoneReboise.setJeunePlant(jeunePlant);
		zoneReboise.setNbrTotalJeune(nbrTotalJeune);
		zoneReboise.setDate_suivi(date_suivi);
		zoneReboiseRepository.save(zoneReboise);
		
	}
	
	


}
