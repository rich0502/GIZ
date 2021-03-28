package com.Giz.service.metier;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.Giz.data.domain.DocCap;
import com.Giz.repository.DocCapRepository;

@Service
public class DocCapServiceImpl implements DocCapService {
	
	@Autowired
	private DocCapRepository docCapRepository;

	@Override
	public List<DocCap> ListDocCap() {
		// TODO Auto-generated method stub
		return docCapRepository.findAll();
	}

	@Override
	public void deleteDocCap(Long id_dc) {
		docCapRepository.deleteById(id_dc);
		
	}

	@Override
	public void addDocCap(String titre_doc, String thematique, String type_doc, String auteur_doc, Date date_partage, String reception) {
		DocCap docCap = new DocCap();
		docCap.setTitre_doc(titre_doc);
		docCap.setThematique(thematique);
		docCap.setType_doc(type_doc);
		docCap.setAuteur_doc(auteur_doc);
		docCap.setDate_partage(date_partage);
		docCap.setReception(reception);
		docCapRepository.save(docCap);
		
	}
	
	@Override
	public Optional<DocCap> findByIdDocCap(long id_dc) {
		return docCapRepository.findById(id_dc);
	}

	@Override
	public void modifyDocCap(String titre_doc,  String thematique, String type_doc, String auteur_doc, Date date_partage,
			String reception, Long id_dc) {
		DocCap docCap = new DocCap();
		docCap.setTitre_doc(titre_doc);
		docCap.setThematique(thematique);
		docCap.setType_doc(type_doc);
		docCap.setAuteur_doc(auteur_doc);
		docCap.setDate_partage(date_partage);
		docCap.setReception(reception);
		docCap.setId_dc(id_dc);
		docCapRepository.save(docCap);
		
	}
	@Override
	public int TotDocCap() {
		// TODO Auto-generated method stub
		return docCapRepository.SomDocCapData();
	}

	//graphe

	@Override
	public long TotTotal(Date debut_date, Date fin_date) {
		// TODO Auto-generated method stub
		return docCapRepository.SomTotal(debut_date, fin_date);
	}

	@Override
	public List<Object[]> ListGraphe(Date debut_date, Date fin_date) {
		// TODO Auto-generated method stub
		return docCapRepository.TpsData(debut_date, fin_date);
	}

	@Override
	public long countDocCap(String dateChronologique) {
		if(StringUtils.isEmpty(dateChronologique)) {
			return docCapRepository.count();
		} else {
			return docCapRepository.getCountChronologique(dateChronologique);
		}
	}

	@Override
	public void deleteAll51() {
		// TODO Auto-generated method stub
		 docCapRepository.deleteAll();
		
	}

	
	
}
