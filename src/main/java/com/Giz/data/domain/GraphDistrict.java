package com.Giz.data.domain;

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
	 * @param district_form 
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
