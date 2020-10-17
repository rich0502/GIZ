package com.Giz.data.domain;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "formation")
public class Formation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_form;

	@Column(length = 200)
	private String nom_form;
	@Column(length = 75)
	private String type_form;
	@Column(length = 75)
	private String district_form;
	@Column(length = 15)
	private String commune_form;
	@Column(length = 25)
	private String fkt_form;
	
	
	
	
	
	/**
	 * 
	 */
	public Formation() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param id_form
	 * @param nom_form
	 * @param type_form
	 * @param district_form
	 * @param commune_form
	 * @param fkt_form
	 */
	
	
	public Formation(Long id_form, String nom_form, String type_form, String district_form, String commune_form,
			String fkt_form) {
		super();
		this.id_form = id_form;
		this.nom_form = nom_form;
		this.type_form = type_form;
		this.district_form = district_form;
		this.commune_form = commune_form;
		this.fkt_form = fkt_form;
	}
	
	
	public Formation(Long id_form) {
		this.id_form = id_form;
	}
	
	/**
	 * @return the id_form
	 */
	public Long getId_form() {
		return id_form;
	}
	/**
	 * @param id_form the id_form to set
	 */
	public void setId_form(Long id_form) {
		this.id_form = id_form;
	}
	/**
	 * @return the nom_form
	 */
	public String getNom_form() {
		return nom_form;
	}
	/**
	 * @param nom_form the nom_form to set
	 */
	public void setNom_form(String nom_form) {
		this.nom_form = nom_form;
	}
	/**
	 * @return the type_form
	 */
	public String getType_form() {
		return type_form;
	}
	/**
	 * @param type_form the type_form to set
	 */
	public void setType_form(String type_form) {
		this.type_form = type_form;
	}
	/**
	 * @return the district_form
	 */
	public String getDistrict_form() {
		return district_form;
	}
	/**
	 * @param district_form the district_form to set
	 */
	public void setDistrict_form(String district_form) {
		this.district_form = district_form;
	}
	/**
	 * @return the commune_form
	 */
	public String getCommune_form() {
		return commune_form;
	}
	/**
	 * @param commune_form the commune_form to set
	 */
	public void setCommune_form(String commune_form) {
		this.commune_form = commune_form;
	}
	/**
	 * @return the fkt_form
	 */
	public String getFkt_form() {
		return fkt_form;
	}
	/**
	 * @param fkt_form the fkt_form to set
	 */
	public void setFkt_form(String fkt_form) {
		this.fkt_form = fkt_form;
	}
	
	
	
	

}
