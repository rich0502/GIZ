package com.Giz.data.domain;

import javax.persistence.Column;

public class MiseForme {

	@Column(length = 150)
	private String name_header;
	@Column(length = 5)
	private int num_header;
	/**
	 * 
	 */
	public MiseForme() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param name_header
	 * @param num_header
	 */
	public MiseForme(String name_header, int num_header) {
		super();
		this.name_header = name_header;
		this.num_header = num_header;
	}
	/**
	 * @return the name_header
	 */
	public String getName_header() {
		return name_header;
	}
	/**
	 * @param name_header the name_header to set
	 */
	public void setName_header(String name_header) {
		this.name_header = name_header;
	}
	/**
	 * @return the num_header
	 */
	public int getNum_header() {
		return num_header;
	}
	/**
	 * @param num_header the num_header to set
	 */
	public void setNum_header(int num_header) {
		this.num_header = num_header;
	}	

	
	
}
