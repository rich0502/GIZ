package com.Giz.data.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "recherche")
public class Recherche {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_re;
	
	@Column(length = 30)
	private String code_village;
	
	private Date date_restitution;
	
	@Column(length = 100)
	private String theme;
	
	private double nbr_homme;
	
	private double nbr_femme;
	
	private boolean pr ;
	
	private boolean producteurs;
	
	private boolean ep;
	
	private boolean std_ctd;
	
	private boolean autres;

	/**
	 * 
	 */
	public Recherche() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id_re
	 * @param code_village
	 * @param date_restitution
	 * @param theme
	 * @param nbr_homme
	 * @param nbr_femme
	 * @param pr
	 * @param producteurs
	 * @param ep
	 * @param std_ctd
	 * @param autres
	 */
	public Recherche(Long id_re, String code_village, Date date_restitution, String theme, double nbr_homme,
			double nbr_femme, boolean pr, boolean producteurs, boolean ep, boolean std_ctd, boolean autres) {
		super();
		this.id_re = id_re;
		this.code_village = code_village;
		this.date_restitution = date_restitution;
		this.theme = theme;
		this.nbr_homme = nbr_homme;
		this.nbr_femme = nbr_femme;
		this.pr = pr;
		this.producteurs = producteurs;
		this.ep = ep;
		this.std_ctd = std_ctd;
		this.autres = autres;
	}

	/**
	 * @return the id_re
	 */
	public Long getId_re() {
		return id_re;
	}

	/**
	 * @param id_re the id_re to set
	 */
	public void setId_re(Long id_re) {
		this.id_re = id_re;
	}

	/**
	 * @return the code_village
	 */
	public String getCode_village() {
		return code_village;
	}

	/**
	 * @param code_village the code_village to set
	 */
	public void setCode_village(String code_village) {
		this.code_village = code_village;
	}

	/**
	 * @return the date_restitution
	 */
	public Date getDate_restitution() {
		return date_restitution;
	}

	/**
	 * @param date_restitution the date_restitution to set
	 */
	public void setDate_restitution(Date date_restitution) {
		this.date_restitution = date_restitution;
	}

	/**
	 * @return the theme
	 */
	public String getTheme() {
		return theme;
	}

	/**
	 * @param theme the theme to set
	 */
	public void setTheme(String theme) {
		this.theme = theme;
	}

	/**
	 * @return the nbr_homme
	 */
	public double getNbr_homme() {
		return nbr_homme;
	}

	/**
	 * @param nbr_homme the nbr_homme to set
	 */
	public void setNbr_homme(double nbr_homme) {
		this.nbr_homme = nbr_homme;
	}

	/**
	 * @return the nbr_femme
	 */
	public double getNbr_femme() {
		return nbr_femme;
	}

	/**
	 * @param nbr_femme the nbr_femme to set
	 */
	public void setNbr_femme(double nbr_femme) {
		this.nbr_femme = nbr_femme;
	}

	/**
	 * @return the pr
	 */
	public boolean isPr() {
		return pr;
	}

	/**
	 * @param pr the pr to set
	 */
	public void setPr(boolean pr) {
		this.pr = pr;
	}

	/**
	 * @return the producteurs
	 */
	public boolean isProducteurs() {
		return producteurs;
	}

	/**
	 * @param producteurs the producteurs to set
	 */
	public void setProducteurs(boolean producteurs) {
		this.producteurs = producteurs;
	}

	/**
	 * @return the ep
	 */
	public boolean isEp() {
		return ep;
	}

	/**
	 * @param ep the ep to set
	 */
	public void setEp(boolean ep) {
		this.ep = ep;
	}

	/**
	 * @return the std_ctd
	 */
	public boolean isStd_ctd() {
		return std_ctd;
	}

	/**
	 * @param std_ctd the std_ctd to set
	 */
	public void setStd_ctd(boolean std_ctd) {
		this.std_ctd = std_ctd;
	}

	/**
	 * @return the autres
	 */
	public boolean isAutres() {
		return autres;
	}

	/**
	 * @param autres the autres to set
	 */
	public void setAutres(boolean autres) {
		this.autres = autres;
	}

	
}
