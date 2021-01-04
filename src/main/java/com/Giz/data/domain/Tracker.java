package com.Giz.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tracker")
public class Tracker {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //this is where problem exists
	@Column(name = "id")
	private Long id;
	
	@Column(name = "desc_file")
	private String desc_file;
	
	@Column(name = "date_tracker")
	private String date_tracker;
	
	@Column(name = "file_name")
	private String file_name;
	
	@Column(name = "type_tracker")
	private String type_tracker;

	/**
	 * 
	 */
	public Tracker() {
		// TODO Auto-generated constructor stub
	}

	public Tracker(Long id, String desc_file, String date_tracker, String file_name, String type_tracker) {
		super();
		this.id = id;
		this.desc_file = desc_file;
		this.date_tracker = date_tracker;
		this.file_name = file_name;
		this.type_tracker = type_tracker;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDesc_file() {
		return desc_file;
	}

	public void setDesc_file(String desc_file) {
		this.desc_file = desc_file;
	}

	public String getDate_tracker() {
		return date_tracker;
	}

	public void setDate_tracker(String date_tracker) {
		this.date_tracker = date_tracker;
	}

	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	public String getType_tracker() {
		return type_tracker;
	}

	public void setType_tracker(String type_tracker) {
		this.type_tracker = type_tracker;
	}

	
	
}
