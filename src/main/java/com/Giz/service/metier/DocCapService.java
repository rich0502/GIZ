package com.Giz.service.metier;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.Giz.data.domain.DocCap;


public interface DocCapService {


	public List<DocCap> ListDocCap();

	public void deleteDocCap(Long id_dc);
	
	public void addDocCap(String titre_doc, String thematique, String type_doc, String auteur_doc, Date date_partage,
			String reception);
	
	public Optional<DocCap> findByIdDocCap(long id_dc);
	
	
	public void modifyDocCap(String titre_doc, String thematique, String type_doc, String auteur_doc, Date date_partage,
			String reception, Long id_dc);
	
	public int TotDocCap();
	
	//graphe
	
	public long TotTotal(Date debut_date, Date fin_date);
	
	public List<Object[]> ListGraphe(Date debut_date, Date fin_date);
	
	//indicateur
	
	public long countDocCap(String dateChronologique);
	
}
