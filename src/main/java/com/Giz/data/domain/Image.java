package com.Giz.data.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "image")
public class Image {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long id_album;
	@Lob
	private byte[] photo;
	private String photo_name;
	private String photo_type;
	
	public Image(long id_album, byte[] photo, String photo_name, String photo_type) {
		super();
		this.id_album = id_album;
		this.photo = photo;
		this.photo_name = photo_name;
		this.photo_type = photo_type;
	}
	public String getPhoto_name() {
		return photo_name;
	}
	public void setPhoto_name(String photo_name) {
		this.photo_name = photo_name;
	}
	public String getPhoto_type() {
		return photo_type;
	}
	public void setPhoto_type(String photo_type) {
		this.photo_type = photo_type;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getId_album() {
		return id_album;
	}
	public void setId_album(long id_album) {
		this.id_album = id_album;
	}
	
	
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	public Image() {
		
	}
	
	

}
