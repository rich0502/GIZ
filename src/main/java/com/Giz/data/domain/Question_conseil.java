package com.Giz.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "question_conseil")
public class Question_conseil {
	@Id
	private Long id;
	@Column(length = 40)
	private  String code_pro;
	@Column(length = 255)
	private String question_symrise;
	@Column(length = 255)
	private String conseil_rural;
	@Column(length = 250)
	private String etat_vanille;
	@Column(length = 250)
	private String assistance;
	
	public Question_conseil() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Question_conseil(Long id, String code_pro, String question_symrise, String conseil_rural,
			String etat_vanille, String assistance) {
		super();
		this.id = id;
		this.code_pro = code_pro;
		this.question_symrise = question_symrise;
		this.conseil_rural = conseil_rural;
		this.etat_vanille = etat_vanille;
		this.assistance = assistance;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode_pro() {
		return code_pro;
	}

	public void setCode_pro(String code_pro) {
		this.code_pro = code_pro;
	}

	public String getQuestion_symrise() {
		return question_symrise;
	}

	public void setQuestion_symrise(String question_symrise) {
		this.question_symrise = question_symrise;
	}

	public String getConseil_rural() {
		return conseil_rural;
	}

	public void setConseil_rural(String conseil_rural) {
		this.conseil_rural = conseil_rural;
	}

	public String getEtat_vanille() {
		return etat_vanille;
	}

	public void setEtat_vanille(String etat_vanille) {
		this.etat_vanille = etat_vanille;
	}

	public String getAssistance() {
		return assistance;
	}

	public void setAssistance(String assistance) {
		this.assistance = assistance;
	}
	
}
