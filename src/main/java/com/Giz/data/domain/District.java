package com.Giz.data.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "district")
public class District {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long gid;

	@Column(length = 150)
	private String adm2_en;

	/**
	 * @param gid
	 * @param adm2_en
	 */
	public District(Long gid, String adm2_en) {
		super();
		this.gid = gid;
		this.adm2_en = adm2_en;
	}

	/**
	 * 
	 */
	public District() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the gid
	 */
	public Long getGid() {
		return gid;
	}

	/**
	 * @param gid the gid to set
	 */
	public void setGid(Long gid) {
		this.gid = gid;
	}

	/**
	 * @return the adm2_en
	 */
	public String getAdm2_en() {
		return adm2_en;
	}

	/**
	 * @param adm2_en the adm2_en to set
	 */
	public void setAdm2_en(String adm2_en) {
		this.adm2_en = adm2_en;
	}
	
	

}
