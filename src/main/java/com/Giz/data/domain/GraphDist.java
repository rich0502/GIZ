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


public class GraphDist {

	 private String district;
	 private Long y;
	 
	 
	public GraphDist() {
		super();
		// TODO Auto-generated constructor stub
	}


	public GraphDist(String district, Long y) {
		super();
		this.district = district;
		this.y = y;
	}


	public String getDistrict() {
		return district;
	}


	public void setDistrict(String district) {
		this.district = district;
	}


	public Long getY() {
		return y;
	}


	public void setY(Long y) {
		this.y = y;
	}
	
	

}
