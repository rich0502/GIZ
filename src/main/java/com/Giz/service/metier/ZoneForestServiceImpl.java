package com.Giz.service.metier;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Giz.data.domain.ZoneForest;
import com.Giz.repository.ZoneForestRepository;

@Service
public class ZoneForestServiceImpl implements ZoneForestService {
	
	@Autowired
	private ZoneForestRepository zoneForestRepository;

	@Override
	public List<ZoneForest> ListZoneForest() {
		// TODO Auto-generated method stub
		return zoneForestRepository.findAll();
	}

	@Override
	public void deleteZoneForest(Long id_zf) {
		zoneForestRepository.deleteById(id_zf);
		
	}

	@Override
	public void addZoneForest(String code_village, boolean exist_zn, float superficies, Date date_suivi) {
		ZoneForest zoneForest = new ZoneForest();
		zoneForest.setCode_village(code_village);
		zoneForest.setExist_zn(exist_zn);
		zoneForest.setSuperficies(superficies);
		zoneForest.setDate_suivi(date_suivi);
		zoneForestRepository.save(zoneForest);
		
	}

	@Override
	public void modifyZoneForest(ZoneForest zoneForest, String code_village, boolean exist_zn, float superficies,
			Date date_suivi, Long id_zf) {
		zoneForest.setCode_village(code_village);
		zoneForest.setExist_zn(exist_zn);
		zoneForest.setSuperficies(superficies);
		zoneForest.setDate_suivi(date_suivi);
		zoneForestRepository.save(zoneForest);
		
	}

	@Override
	public void deleteAllZF() {
		// TODO Auto-generated method stub
		zoneForestRepository.deleteAll();
	}
	
	

	

}
