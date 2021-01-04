package com.Giz.service.metier;

import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Giz.data.domain.Beneficiaire;
import com.Giz.data.domain.Formation;
import com.Giz.data.domain.Former;
import com.Giz.data.domain.GraphDistrict;
import com.Giz.data.domain.TpsFormes;
import com.Giz.repository.FormerRepository;




@Service
public class FormerServiceImpl implements FormerService {
	@Autowired
	private FormerRepository formerRepository;

	@Override
	public List<Former> ListFormer() {
		// TODO Auto-generated method stub
		return formerRepository.fetchFormesData();
	}

	@Override
	public void deleteFormer(Long id) {
		formerRepository.deleteFormer(id);
		
	}

	@Override
	public void addFormer(Date date_frm, Long id_bf, Long id_form) {
		Former former = new Former();
		former.setDate_frm(date_frm);

		if (id_bf > 0) {
			Beneficiaire vl = new Beneficiaire(id_bf);
			former.setBeneficiaire(vl);
		}
		if (id_form > 0) {
			Formation th = new Formation(id_form);
			former.setFormation(th);
		}
		formerRepository.save(former);
		
	}

	@Override
	public void modifyFormer(Former former, Date date_frm, Long id_bf, Long id_form, Long id) {
		former.setDate_frm(date_frm);

		if (id_bf > 0) {
			Beneficiaire vl = new Beneficiaire(id_bf);
			former.setBeneficiaire(vl);
		}
		if (id_form > 0) {
			Formation th = new Formation(id_form);
			former.setFormation(th);
		}
		formerRepository.save(former);
		
	}

	@Override
	public List<GraphDistrict> ListFormees() {
		// TODO Auto-generated method stub
		return formerRepository.fetchFormsData();
	}

	@Override
	public int TotForms() {
		// TODO Auto-generated method stub
		return formerRepository.SomFormerData();
	}

	@Override
	public List<TpsFormes> TpsFormer(Date debut_date,Date fin_date) {
		return formerRepository.TpsFormerData(debut_date, fin_date);
	}


}
