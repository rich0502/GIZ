package com.Giz.data.domain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "accueil")
public class Accueil {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_acc;
	
	@Column(columnDefinition="TEXT")
	private String contenu_acc;

	public Accueil() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Accueil(Long id_acc, String contenu_acc) {
		super();
		this.id_acc = id_acc;
		this.contenu_acc = contenu_acc;
	}

	public Long getId_acc() {
		return id_acc;
	}

	public void setId_acc(Long id_acc) {
		this.id_acc = id_acc;
	}

	public String getContenu_acc() {
		return contenu_acc;
	}

	public void setContenu_acc(String contenu_acc) {
		this.contenu_acc = contenu_acc;
	}

	
}
