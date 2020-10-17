package com.Giz.data.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "fokontany")
public class Fokontany {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long gid;

	@Column(length = 150)
	private String adm4_en;

	/**
	 * @param gid
	 * @param adm4_en
	 */
	public Fokontany(Long gid, String adm4_en) {
		super();
		this.gid = gid;
		this.adm4_en = adm4_en;
	}

	/**
	 * 
	 */
	public Fokontany() {
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
	 * @return the adm4_en
	 */
	public String getadm4_en() {
		return adm4_en;
	}

	/**
	 * @param adm4_en the adm4_en to set
	 */
	public void setadm4_en(String adm4_en) {
		this.adm4_en = adm4_en;
	}
	
	

}
