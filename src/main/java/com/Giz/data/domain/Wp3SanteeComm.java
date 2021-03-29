package com.Giz.data.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "wp3_santee_comm")
public class Wp3SanteeComm extends Auditable<String> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 10)
	private String code_village;
	private String csb;
	private float gps_x;
	private float gps_y;
	private String repro_sexuelle;
	private Date date_suivi;
	private String sexe;

	public Wp3SanteeComm() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Wp3SanteeComm(Long id, String code_village, String csb, float gps_x, float gps_y, String repro_sexuelle,
			Date date_suivi) {
		super();
		this.id = id;
		this.code_village = code_village;
		this.csb = csb;
		this.gps_x = gps_x;
		this.gps_y = gps_y;
		this.repro_sexuelle = repro_sexuelle;
		this.date_suivi = date_suivi;
	}
	
	

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode_village() {
		return code_village;
	}

	public void setCode_village(String code_village) {
		this.code_village = code_village;
	}

	public String getCsb() {
		return csb;
	}

	public void setCsb(String csb) {
		this.csb = csb;
	}

	public float getGps_x() {
		return gps_x;
	}

	public void setGps_x(float gps_x) {
		this.gps_x = gps_x;
	}

	public float getGps_y() {
		return gps_y;
	}

	public void setGps_y(float gps_y) {
		this.gps_y = gps_y;
	}

	public String getRepro_sexuelle() {
		return repro_sexuelle;
	}

	public void setRepro_sexuelle(String repro_sexuelle) {
		this.repro_sexuelle = repro_sexuelle;
	}

	public Date getDate_suivi() {
		return date_suivi;
	}

	public void setDate_suivi(Date date_suivi) {
		this.date_suivi = date_suivi;
	}

}
