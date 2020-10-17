package com.Giz.data.domain;

import java.util.Date;

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


public class TpsFormes {

	 private Date x;
	 private Long y;

	/**
	 * @param x
	 * @param y
	 */
	public TpsFormes(Date x, Long y) {
		super();
		this.x = x;
		this.y = y;
	}
	/**
	 * @return the x
	 */
	public Date getx() {
		return x;
	}
	/**
	 * @param x the x to set
	 */
	public void setx(Date x) {
		this.x = x;
	}
	/**
	 * @return the y
	 */
	public Long getY() {
		return y;
	}
	/**
	 * @param y the y to set
	 */
	public void setY(Long y) {
		this.y = y;
	}
	
	 

}
