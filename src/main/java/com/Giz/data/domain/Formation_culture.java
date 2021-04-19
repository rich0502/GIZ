package com.Giz.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "formation_culture")
public class Formation_culture {
	@Id
	private Long id;
	@Column(length = 40)
	private  String code_prod;
	@Column(length = 150)
	private String recu_formation;
	@Column(length = 255)
	private String quelle_formation;
	@Column(length = 100)
	private String autre_formation;
	@Column(length = 50)
	private String recu_dernier_form;
	@Column(length = 255)
	private String change_observer;
	public Formation_culture() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Formation_culture(Long id, String code_prod, String recu_formation, String quelle_formation,
			String autre_formation, String recu_dernier_form, String change_observer) {
		super();
		this.id = id;
		this.code_prod = code_prod;
		this.recu_formation = recu_formation;
		this.quelle_formation = quelle_formation;
		this.autre_formation = autre_formation;
		this.recu_dernier_form = recu_dernier_form;
		this.change_observer = change_observer;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode_prod() {
		return code_prod;
	}
	public void setCode_prod(String code_prod) {
		this.code_prod = code_prod;
	}
	public String getRecu_formation() {
		return recu_formation;
	}
	public void setRecu_formation(String recu_formation) {
		this.recu_formation = recu_formation;
	}
	public String getQuelle_formation() {
		return quelle_formation;
	}
	public void setQuelle_formation(String quelle_formation) {
		this.quelle_formation = quelle_formation;
	}
	public String getAutre_formation() {
		return autre_formation;
	}
	public void setAutre_formation(String autre_formation) {
		this.autre_formation = autre_formation;
	}
	public String getRecu_dernier_form() {
		return recu_dernier_form;
	}
	public void setRecu_dernier_form(String recu_dernier_form) {
		this.recu_dernier_form = recu_dernier_form;
	}
	public String getChange_observer() {
		return change_observer;
	}
	public void setChange_observer(String change_observer) {
		this.change_observer = change_observer;
	}
	
}
