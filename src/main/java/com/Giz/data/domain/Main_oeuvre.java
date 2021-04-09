package com.Giz.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "main_oeuvre")
public class Main_oeuvre {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 40)
	private String code_prod;
	private int nbr_empl_perm;
	@Column(length = 3)
	private String empl_jour_saison;
	private int nbr_empl_jour;
	private int pay_empl_jour;
	@Column(length = 250)
	private String mois_tw_empl;
	@Column(length = 250)
	private String tw;
	@Column(length = 250)
	private String autre;
	@Column(length = 250)
	private String activite_vanille;
	
	public Main_oeuvre() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Main_oeuvre(Long id, String code_prod, int nbr_empl_perm, String empl_jour_saison, int nbr_empl_jour,
			int pay_empl_jour, String mois_tw_empl, String tw, String autre, String activite_vanille) {
		super();
		this.id = id;
		this.code_prod = code_prod;
		this.nbr_empl_perm = nbr_empl_perm;
		this.empl_jour_saison = empl_jour_saison;
		this.nbr_empl_jour = nbr_empl_jour;
		this.pay_empl_jour = pay_empl_jour;
		this.mois_tw_empl = mois_tw_empl;
		this.tw = tw;
		this.autre = autre;
		this.activite_vanille = activite_vanille;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode_prod() {
		return code_prod;
	}

	public void setCode_prod(String code_prod) {
		this.code_prod = code_prod;
	}

	public int getNbr_empl_perm() {
		return nbr_empl_perm;
	}

	public void setNbr_empl_perm(int nbr_empl_perm) {
		this.nbr_empl_perm = nbr_empl_perm;
	}

	public String getEmpl_jour_saison() {
		return empl_jour_saison;
	}

	public void setEmpl_jour_saison(String empl_jour_saison) {
		this.empl_jour_saison = empl_jour_saison;
	}

	public int getNbr_empl_jour() {
		return nbr_empl_jour;
	}

	public void setNbr_empl_jour(int nbr_empl_jour) {
		this.nbr_empl_jour = nbr_empl_jour;
	}

	public int getPay_empl_jour() {
		return pay_empl_jour;
	}

	public void setPay_empl_jour(int pay_empl_jour) {
		this.pay_empl_jour = pay_empl_jour;
	}

	public String getMois_tw_empl() {
		return mois_tw_empl;
	}

	public void setMois_tw_empl(String mois_tw_empl) {
		this.mois_tw_empl = mois_tw_empl;
	}

	public String getTw() {
		return tw;
	}

	public void setTw(String tw) {
		this.tw = tw;
	}

	public String getAutre() {
		return autre;
	}

	public void setAutre(String autre) {
		this.autre = autre;
	}

	public String getActivite_vanille() {
		return activite_vanille;
	}

	public void setActivite_vanille(String activite_vanille) {
		this.activite_vanille = activite_vanille;
	}
	
}
