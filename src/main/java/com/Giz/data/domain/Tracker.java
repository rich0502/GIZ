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

	/**
	 * 
	 */
	public Tracker() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param desc_file
	 * @param date_tracker
	 * @param file_name
	 */
	public Tracker(Long id, String desc_file, String date_tracker, String file_name) {
		super();
		this.id = id;
		this.desc_file = desc_file;
		this.date_tracker = date_tracker;
		this.file_name = file_name;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the desc_file
	 */
	public String getDesc_file() {
		return desc_file;
	}

	/**
	 * @param desc_file the desc_file to set
	 */
	public void setDesc_file(String desc_file) {
		this.desc_file = desc_file;
	}

	/**
	 * @return the date_tracker
	 */
	public String getDate_tracker() {
		return date_tracker;
	}

	/**
	 * @param date_tracker the date_tracker to set
	 */
	public void setDate_tracker(String date_tracker) {
		this.date_tracker = date_tracker;
	}

	/**
	 * @return the file_name
	 */
	public String getFile_name() {
		return file_name;
	}

	/**
	 * @param file_name the file_name to set
	 */
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}



	
}
