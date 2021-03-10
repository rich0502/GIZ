package com.Giz.service.metier;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Giz.data.domain.Adoption_innovation;
import com.Giz.data.domain.Concours;
import com.Giz.repository.Adopte_InnovationRepository;
import com.Giz.repository.ConcoursRepository;

@Service
public class ConcoursServiceImpl implements ConcoursService {
	
	@Autowired
	private ConcoursRepository concoursRepository;

	@Override
	public List<Concours> ListConcours() {
		// TODO Auto-generated method stub
		return concoursRepository.findAll();
	}

	@Override
	public void deleteConcours(Long id_con) {
		concoursRepository.deleteById(id_con);
		
	}

	@Override
	public void addConcours(String code_village, boolean exist, Date date_eval, Date date_suivi) {
		Concours concours = new Concours();
		concours.setCode_village(code_village);
		concours.setExist(exist);
		concours.setDate_eval(date_eval);
		concours.setDate_suivi(date_suivi);
		concoursRepository.save(concours);
		
	}

	@Override
	public void modifyConcours(Concours concours, String code_village, boolean exist, Date date_eval, Date date_suivi,
			Long id_con) {
		concours.setCode_village(code_village);
		concours.setExist(exist);
		concours.setDate_eval(date_eval);
		concours.setDate_suivi(date_suivi);
		concoursRepository.save(concours);
		
	}
	
	


}
