package com.Giz.data.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "galeries")
public class Galerie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom_album;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom_album() {
		return nom_album;
	}
	public void setNom_album(String nom_album) {
		this.nom_album = nom_album;
	}
	public Galerie(String nom_album) {
		super();
		this.nom_album = nom_album;
	}
	
	public Galerie(Long id, String nom_album) {
		super();
		this.id = id;
		this.nom_album = nom_album;
	}
	
	public Galerie() {
		
	}

}
