package com.Giz.data.domain;

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
