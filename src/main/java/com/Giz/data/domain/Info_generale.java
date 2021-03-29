package com.Giz.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "info_generale")
public class Info_generale {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 40)
	private  String code_pro;
	private int nbr_parcel_prod;
	@Column(length = 255)
	private String appris_culture;
	@Column(length = 255)
	private String autre;
	@Column(length = 255)
	private String moyen;
	@Column(length = 255)
	private String technic_conseil;
	@Column(length = 255)
	private String change_tech;
	@Column(length = 90)
	private String prepare;
	private int dernier_compagne;
	@Column(length = 90)
	private String place_dedie;
	
	public Info_generale() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Info_generale(Long id, String code_pro, int nbr_parcel_prod, String appris_culture, String autre,
			String moyen, String technic_conseil, String change_tech, String prepare, int dernier_compagne,
			String place_dedie) {
		super();
		this.id = id;
		this.code_pro = code_pro;
		this.nbr_parcel_prod = nbr_parcel_prod;
		this.appris_culture = appris_culture;
		this.autre = autre;
		this.moyen = moyen;
		this.technic_conseil = technic_conseil;
		this.change_tech = change_tech;
		this.prepare = prepare;
		this.dernier_compagne = dernier_compagne;
		this.place_dedie = place_dedie;
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

	public int getNbr_parcel_prod() {
		return nbr_parcel_prod;
	}

	public void setNbr_parcel_prod(int nbr_parcel_prod) {
		this.nbr_parcel_prod = nbr_parcel_prod;
	}

	public String getAppris_culture() {
		return appris_culture;
	}

	public void setAppris_culture(String appris_culture) {
		this.appris_culture = appris_culture;
	}

	public String getAutre() {
		return autre;
	}

	public void setAutre(String autre) {
		this.autre = autre;
	}

	public String getMoyen() {
		return moyen;
	}

	public void setMoyen(String moyen) {
		this.moyen = moyen;
	}

	public String getTechnic_conseil() {
		return technic_conseil;
	}

	public void setTechnic_conseil(String technic_conseil) {
		this.technic_conseil = technic_conseil;
	}

	public String getChange_tech() {
		return change_tech;
	}

	public void setChange_tech(String change_tech) {
		this.change_tech = change_tech;
	}

	public String getPrepare() {
		return prepare;
	}

	public void setPrepare(String prepare) {
		this.prepare = prepare;
	}

	public int getDernier_compagne() {
		return dernier_compagne;
	}

	public void setDernier_compagne(int dernier_compagne) {
		this.dernier_compagne = dernier_compagne;
	}

	public String getPlace_dedie() {
		return place_dedie;
	}

	public void setPlace_dedie(String place_dedie) {
		this.place_dedie = place_dedie;
	}
	
}
