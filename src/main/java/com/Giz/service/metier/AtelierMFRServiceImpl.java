package com.Giz.service.metier;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Giz.data.domain.AtelierMFR;
import com.Giz.repository.AtelierMFRRepository;

@Service
public class AtelierMFRServiceImpl implements AtelierMFRService {
	
	@Autowired
	private AtelierMFRRepository atelierMFRRepository;

	@Override
	public List<AtelierMFR> ListAtelierMFR() {
		// TODO Auto-generated method stub
		return atelierMFRRepository.findAll();
	}

	@Override
	public void deleteAtelierMFR(Long id_am) {
		atelierMFRRepository.deleteById(id_am);
		
	}

	@Override
	public void addAtelierMFR(String code_village, String atelier_resp, Date date_realise, String lieu_realise, String theme_choise,
			long nbr_particip, int nbr_homme, int nbr_femme, String cible_atelier, String type_atelier) {
		AtelierMFR atelierMFR = new AtelierMFR();
		atelierMFR.setCible_atelier(cible_atelier);
		atelierMFR.setCode_village(code_village);
		atelierMFR.setDate_realise(date_realise);
		atelierMFR.setLieu_realise(lieu_realise);
		atelierMFR.setNbr_femme(nbr_femme);
		atelierMFR.setNbr_homme(nbr_homme);
		atelierMFR.setNbr_particip(nbr_particip);
		atelierMFR.setTheme_choise(theme_choise);
		atelierMFR.setAtelier_resp(atelier_resp);
		atelierMFR.setType_atelier(type_atelier);
		atelierMFRRepository.save(atelierMFR);
		
		
	}

	@Override
	public Optional<AtelierMFR> findByIdAtelierMFR(long id_am) {
		return atelierMFRRepository.findById(id_am);
	}

	@Override
	public void modifyAtelierMFR(String code_village,String atelier_resp, Date date_realise, String lieu_realise,
			String theme_choise, long nbr_particip, int nbr_homme, int nbr_femme, String cible_atelier,String type_atelier, Long id_am) {
		AtelierMFR atelierMFR = new AtelierMFR();
		atelierMFR.setCible_atelier(cible_atelier);
		atelierMFR.setCode_village(code_village);
		atelierMFR.setDate_realise(date_realise);
		atelierMFR.setLieu_realise(lieu_realise);
		atelierMFR.setNbr_femme(nbr_femme);
		atelierMFR.setNbr_homme(nbr_homme);
		atelierMFR.setNbr_particip(nbr_particip);
		atelierMFR.setTheme_choise(theme_choise);
		atelierMFR.setAtelier_resp(atelier_resp);
		atelierMFR.setType_atelier(type_atelier);
		atelierMFR.setId_am(id_am);
		atelierMFRRepository.save(atelierMFR);
		
	}

	@Override
	public List<AtelierMFR> fetchAtelier(String type_atelier) {
		return atelierMFRRepository.fetchAtelier(type_atelier);
	}

	@Override
	public List<Object[]> ListAtelierFetch(String type_atelier) {
		return atelierMFRRepository.fetchAtelierMFRData(type_atelier);
	}

	@Override
	public long TotAtelierMFR(String type_atelier) {
		// TODO Auto-generated method stub
		return atelierMFRRepository.SomAtelierMFRData(type_atelier);
	}

	@Override
	public List<Object[]> TpsAtelierMFR(String type_atelier, Date debut_date, Date fin_date) {
		// TODO Auto-generated method stub
		return atelierMFRRepository.TpsAtelierMFRData(type_atelier, debut_date, fin_date);
	}

	@Override
	public long TotAtelierParticipant(String type_atelier,Date debut_date, Date fin_date) {
		// TODO Auto-generated method stub
			return atelierMFRRepository.SomAtelierMFR(type_atelier,debut_date, fin_date);
	}

	@Override
	public long getCountHomme(String dateChronologique, String type_atelier) {
		if(atelierMFRRepository.getCountHommeIsExist(dateChronologique, type_atelier)) {
			return atelierMFRRepository.getCountHomme(dateChronologique, type_atelier);
		} else {
			return 0;
		}
	}

	@Override
	public long getCountFemme(String dateChronologique,String type_atelier) {
		boolean nbr = atelierMFRRepository.getCountFemmeIsExist(dateChronologique, type_atelier);
				if(nbr) {
					return atelierMFRRepository.getCountFemme(dateChronologique, type_atelier);
				}
			return 0;
	}

	@Override
	public long countAtelier(String dateChronologique, String type_atelier) {
		boolean nbr = atelierMFRRepository.getCountChronologiqueIsExist(dateChronologique, type_atelier);
		if(nbr) {
			return atelierMFRRepository.getCountChronologique(dateChronologique, type_atelier);
		}
		return 0;
	}

	@Override
	public List<Object[]> ListTableau(String type_atelier, List<String> params, Date debut_date, Date fin_date) {
		// TODO Auto-generated method stub
		return atelierMFRRepository.TableData(type_atelier, params, debut_date, fin_date);
	}

	@Override
	public List<Object[]> ListTableauCommune(String type_atelier, Date debut_date, Date fin_date) {
		// TODO Auto-generated method stub
		return atelierMFRRepository.TableDataCommune(type_atelier, debut_date, fin_date);
	}

	@Override
	public List<Object[]> ListTableauDist(String type_atelier, Date debut_date, Date fin_date) {
		// TODO Auto-generated method stub
		return atelierMFRRepository.TableDataDist(type_atelier, debut_date, fin_date);
	}
}
