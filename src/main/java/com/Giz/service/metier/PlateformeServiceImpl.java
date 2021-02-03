package com.Giz.service.metier;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Giz.data.domain.Adoption_innovation;
import com.Giz.data.domain.AtelierMFR;
import com.Giz.data.domain.Plateforme;
import com.Giz.data.domain.TpsFormes;
import com.Giz.repository.Adopte_InnovationRepository;
import com.Giz.repository.AtelierMFRRepository;
import com.Giz.repository.PlateformRepository;

@Service
public class PlateformeServiceImpl implements PlateformeService {
	
	@Autowired
	private PlateformRepository plateformRepository;

	@Override
	public List<Plateforme> ListPlateforme() {
		// TODO Auto-generated method stub
		return plateformRepository.findAll();
	}

	@Override
	public List<Plateforme> fetchPlateforme(String type_plateform) {
		// TODO Auto-generated method stub
		return plateformRepository.fetchPlateforme(type_plateform);
	}

	@Override
	public void deletePlateforme(Long id_am) {
		plateformRepository.deleteById(id_am);
		
	}

	@Override
	public void addPlateforme(String code_village, boolean exist_platform, boolean operationnel, Date date_suivi,
			String commentaire, String type_plateform) {
		Plateforme plateforme = new Plateforme();
		plateforme.setCode_village(code_village);
		plateforme.setExist_platform(exist_platform);
		plateforme.setOperationnel(operationnel);
		plateforme.setDate_suivi(date_suivi);
		plateforme.setCommentaire(commentaire);
		plateforme.setType_plateform(type_plateform);
		plateformRepository.save(plateforme);
	}

	@Override
	public Optional<Plateforme> findByIdPlateforme(long id_am) {
		return plateformRepository.findById(id_am);
	}

	@Override
	public void modifyPlateforme(String code_village, boolean exist_platform,
			boolean operationnel, Date date_suivi, String commentaire, String type_plateform, Long id_am) {
		Plateforme plateforme = new Plateforme();
		plateforme.setCode_village(code_village);
		plateforme.setExist_platform(exist_platform);
		plateforme.setOperationnel(operationnel);
		plateforme.setDate_suivi(date_suivi);
		plateforme.setCommentaire(commentaire);
		plateforme.setType_plateform(type_plateform);
		plateforme.setId_am(id_am);
		plateformRepository.save(plateforme);
	}

	@Override
	public List<Object[]> ListPlateformeFetch(String type_plateform) {
		// TODO Auto-generated method stub
		return plateformRepository.fetchplateformeData(type_plateform);
	}

	@Override
	public long TotPlateforme(String type_plateform) {
		// TODO Auto-generated method stub
		return plateformRepository.SomplateformeData(type_plateform);
	}

	@Override
	public long TotPlateformeParticipant(String type_plateform, Date debut_date, Date fin_date) {
		// TODO Auto-generated method stub

			return plateformRepository.Somplateforme(type_plateform, debut_date, fin_date);
	}

	@Override
	public List<Object[]> TpsPlateforme(String type_plateform, Date debut_date, Date fin_date) {
		// TODO Auto-generated method stub
		return plateformRepository.TpsplateformeData(type_plateform, debut_date, fin_date);
	}

	@Override
	public long getCount(String dateChronologique, String type_plateform) {
		boolean nbr = plateformRepository.getCountIsExist(dateChronologique, type_plateform);
		if(nbr) {
			return plateformRepository.getCount(dateChronologique, type_plateform);
		}
	return 0;
	}

	@Override
	public long countPlateforme(String dateChronologique, String type_plateform) {
		boolean nbr = plateformRepository.getCountChronologiqueIsExist(dateChronologique, type_plateform);
		if(nbr) {
			return plateformRepository.getCountChronologique(dateChronologique, type_plateform);
		}
	return 0;
	}

	@Override
	public List<Object[]> ListTableau(String type_atelier, List<String> params, Date debut_date, Date fin_date) {
		// TODO Auto-generated method stub
		return plateformRepository.TableData(type_atelier, params, debut_date, fin_date);
	}

	@Override
	public List<Object[]> ListTableauCommune(String type_atelier, Date debut_date, Date fin_date) {
		// TODO Auto-generated method stub
		return plateformRepository.TableDataCommune(type_atelier, debut_date, fin_date);
	}

	@Override
	public List<Object[]> ListTableauDist(String type_atelier, Date debut_date, Date fin_date) {
		// TODO Auto-generated method stub
		return plateformRepository.TableDataDist(type_atelier, debut_date, fin_date);
	}

	

}
