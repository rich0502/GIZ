package com.Giz.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "commune")
public class Commune {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long gid;

	@Column(length = 150)
	private String adm3_en;

	/**
	 * @param gid
	 * @param adm3_en
	 */
	public Commune(Long gid, String adm3_en) {
		super();
		this.gid = gid;
		this.adm3_en = adm3_en;
	}

	/**
	 * 
	 */
	public Commune() {
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
	 * @return the adm3_en
	 */
	public String getadm3_en() {
		return adm3_en;
	}

	/**
	 * @param adm3_en the adm3_en to set
	 */
	public void setadm3_en(String adm3_en) {
		this.adm3_en = adm3_en;
	}
	
	

}
