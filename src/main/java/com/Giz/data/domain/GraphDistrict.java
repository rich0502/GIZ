package com.Giz.data.domain;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


public class GraphDistrict {

	 private String district_form;
	 private Long y;
	/**
	 * @param district
	 * @param y
	 */
	public GraphDistrict(String district_form, Long y) {
		super();
		this.district_form = district_form;
		this.y = y;
	}
	/**
	 * @return the district
	 */
	public String getDistrict() {
		return district_form;
	}
	/**
	 * @param district the district to set
	 */
	public void setDistrict(String district) {
		this.district_form = district_form;
	}
	/**
	 * @return the y
	 */
	public Long gety() {
		return y;
	}
	/**
	 * @param y the y to set
	 */
	public void sety(Long y) {
		this.y = y;
	}

	   


}
