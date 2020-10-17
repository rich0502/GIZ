package com.Giz.data.domain;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "former")
public class Former {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_bf", nullable = false)
	@Fetch(FetchMode.JOIN)
	//@NotFound(action=NotFoundAction.IGNORE)  
	private Beneficiaire beneficiaire;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_form", nullable = false)
	@Fetch(FetchMode.JOIN)
	private Formation formation;





	@Column(nullable = true)
	private Date date_frm;
	

	@Column(insertable = false, updatable = false)
	private Long id_bf;
	@Column(insertable = false, updatable = false)
	private Long id_form;
	/**
	 * 
	 */
	public Former() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param id
	 * @param beneficiaire
	 * @param formation
	 * @param date_frm
	 * @param id_bf
	 * @param id_form
	 */
	public Former(Long id, Beneficiaire beneficiaire, Formation formation, Date date_frm, Long id_bf, Long id_form) {
		super();
		this.id = id;
		this.beneficiaire = beneficiaire;
		this.formation = formation;
		this.date_frm = date_frm;
		this.id_bf = id_bf;
		this.id_form = id_form;
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
	 * @return the beneficiaire
	 */
	public Beneficiaire getBeneficiaire() {
		return beneficiaire;
	}
	/**
	 * @param beneficiaire the beneficiaire to set
	 */
	public void setBeneficiaire(Beneficiaire beneficiaire) {
		this.beneficiaire = beneficiaire;
	}
	/**
	 * @return the formation
	 */
	public Formation getFormation() {
		return formation;
	}
	/**
	 * @param formation the formation to set
	 */
	public void setFormation(Formation formation) {
		this.formation = formation;
	}
	/**
	 * @return the date_frm
	 */
	public Date getDate_frm() {
		return date_frm;
	}
	/**
	 * @param date_frm the date_frm to set
	 */
	public void setDate_frm(Date date_frm) {
		this.date_frm = date_frm;
	}
	/**
	 * @return the id_bf
	 */
	public Long getId_bf() {
		return id_bf;
	}
	/**
	 * @param id_bf the id_bf to set
	 */
	public void setId_bf(Long id_bf) {
		this.id_bf = id_bf;
	}
	/**
	 * @return the id_form
	 */
	public Long getId_form() {
		return id_form;
	}
	/**
	 * @param id_form the id_form to set
	 */
	public void setId_form(Long id_form) {
		this.id_form = id_form;
	}

	
	

}
