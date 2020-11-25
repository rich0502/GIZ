package com.Giz.service.metier;

import java.util.Date;
import java.util.List;

import com.Giz.data.domain.DocCap;


public interface DocCapService {


	public List<DocCap> ListDocCap();

	public void deleteDocCap(Long id_dc);
	
	public void addDocCap(String thematique, String type_doc, String auteur_doc, Date date_partage,
			String reception);
	
	
	public void modifyDocCap(DocCap docCap,String thematique, String type_doc, String auteur_doc, Date date_partage,
			String reception, Long id_dc);
	
}
