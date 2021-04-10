package com.Giz.service.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Giz.data.domain.Main_oeuvre;
import com.Giz.repository.Main_oeuvreRepository;

@Service
public class Main_oeuvreServiceImpl implements Main_oeuvreService {
	
	@Autowired
	private Main_oeuvreRepository main_oeuvreRepository ;
	
	@Override
	public List<Main_oeuvre> ListMain_oeuvre(String code_prod) {
		// TODO Auto-generated method stub
		return main_oeuvreRepository.findByCodeProd(code_prod);
	}

	@Override
	public void addMainOeuvre(long id, String code_prod, int nbr_empl_perm, String empl_jour_saison, int nbr_empl_jour,
			int pay_empl_jour, String mois_tw_empl, String tw, String autre, String activite_vanille) {
		Main_oeuvre main = new Main_oeuvre();
		main.setId(id);
		main.setCode_prod(code_prod);
		main.setNbr_empl_perm(nbr_empl_perm);
		main.setEmpl_jour_saison(empl_jour_saison);
		main.setNbr_empl_jour(nbr_empl_jour);
		main.setPay_empl_jour(pay_empl_jour);
		main.setMois_tw_empl(mois_tw_empl);
		main.setTw(tw);
		main.setAutre(autre);
		main.setActivite_vanille(activite_vanille);
		main_oeuvreRepository.save(main);
	}
	public List<Main_oeuvre> ListMain_oeuvreAll() {
		// TODO Auto-generated method stub
		return main_oeuvreRepository.findAll();
	}

}
