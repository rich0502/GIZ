package com.Giz.data.domain;

import java.util.Date;

public class TpsFormes {

	 private Date x;
	 private Long y;
	 
	public TpsFormes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TpsFormes(Date x, Long y) {
		super();
		this.x = x;
		this.y = y;
	}

	public Date getX() {
		return x;
	}

	public void setX(Date x) {
		this.x = x;
	}

	public Long getY() {
		return y;
	}

	public void setY(Long y) {
		this.y = y;
	}


}
