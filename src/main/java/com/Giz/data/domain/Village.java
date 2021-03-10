package com.Giz.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "village")
public class Village {
	
	@Id
	@Column(length = 100)
	private String code_village;
	
	@Column(length = 100)
	private String district;
	
	@Column(length = 100)
	private String commune;
	
	@Column(length = 100)
	private String village ;

	@Column(length = 5)
	private String zone;
	
	private float lon;
	
	private float lat;
	

	/**
	 * 
	 */
	public Village() {
		// TODO Auto-generated constructor stub
	}


	public Village(String code_village, String district, String commune, String village, String zone, float lon,
			float lat) {
		super();
		this.code_village = code_village;
		this.district = district;
		this.commune = commune;
		this.village = village;
		this.zone = zone;
		this.lon = lon;
		this.lat = lat;
	}


	public String getCode_village() {
		return code_village;
	}


	public void setCode_village(String code_village) {
		this.code_village = code_village;
	}


	public String getDistrict() {
		return district;
	}


	public void setDistrict(String district) {
		this.district = district;
	}


	public String getCommune() {
		return commune;
	}


	public void setCommune(String commune) {
		this.commune = commune;
	}


	public String getVillage() {
		return village;
	}


	public void setVillage(String village) {
		this.village = village;
	}


	public String getZone() {
		return zone;
	}


	public void setZone(String zone) {
		this.zone = zone;
	}


	public float getLon() {
		return lon;
	}


	public void setLon(float lon) {
		this.lon = lon;
	}


	public float getLat() {
		return lat;
	}


	public void setLat(float lat) {
		this.lat = lat;
	}

}
