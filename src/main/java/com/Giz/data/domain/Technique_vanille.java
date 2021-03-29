package com.Giz.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "technique_vanille")
public class Technique_vanille {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 40)
	private  String code_pro;
	@Column(length = 80)
	private  String  ptv;
	@Column(length = 80)
	private  String  taille;
	@Column(length = 80)
	private  String  selectLiane;
	@Column(length = 80)
	private  String  plantVao;
	@Column(length = 80)
	private  String  entretienCan;
	@Column(length = 80)
	private  String  desherbFaush;
	@Column(length = 80)
	private  String  descentBoucl;
	@Column(length = 80)
	private  String  prepaBouton; 
	@Column(length = 80)
	private  String  pollinisation; 
	@Column(length = 80)
	private  String  limitGousse;
	@Column(length = 80)
	private  String  nettoyMort;
	@Column(length = 80)
	private  String  arretCoeur;
	@Column(length = 80)
	private  String  nettoyaParasit;
	@Column(length = 80)
	private  String  adyGasy;
	@Column(length = 80)
	private  String  appliCompo;
	
	public Technique_vanille() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Technique_vanille(Long id, String code_pro, String ptv, String taille, String selectLiane, String plantVao,
			String entretienCan, String desherbFaush, String descentBoucl, String prepaBouton, String pollinisation,
			String limitGousse, String nettoyMort, String arretCoeur, String nettoyaParasit, String adyGasy,
			String appliCompo) {
		super();
		this.id = id;
		this.code_pro = code_pro;
		this.ptv = ptv;
		this.taille = taille;
		this.selectLiane = selectLiane;
		this.plantVao = plantVao;
		this.entretienCan = entretienCan;
		this.desherbFaush = desherbFaush;
		this.descentBoucl = descentBoucl;
		this.prepaBouton = prepaBouton;
		this.pollinisation = pollinisation;
		this.limitGousse = limitGousse;
		this.nettoyMort = nettoyMort;
		this.arretCoeur = arretCoeur;
		this.nettoyaParasit = nettoyaParasit;
		this.adyGasy = adyGasy;
		this.appliCompo = appliCompo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode_pro() {
		return code_pro;
	}

	public void setCode_pro(String code_pro) {
		this.code_pro = code_pro;
	}

	public String getPtv() {
		return ptv;
	}

	public void setPtv(String ptv) {
		this.ptv = ptv;
	}

	public String getTaille() {
		return taille;
	}

	public void setTaille(String taille) {
		this.taille = taille;
	}

	public String getSelectLiane() {
		return selectLiane;
	}

	public void setSelectLiane(String selectLiane) {
		this.selectLiane = selectLiane;
	}

	public String getPlantVao() {
		return plantVao;
	}

	public void setPlantVao(String plantVao) {
		this.plantVao = plantVao;
	}

	public String getEntretienCan() {
		return entretienCan;
	}

	public void setEntretienCan(String entretienCan) {
		this.entretienCan = entretienCan;
	}

	public String getDesherbFaush() {
		return desherbFaush;
	}

	public void setDesherbFaush(String desherbFaush) {
		this.desherbFaush = desherbFaush;
	}

	public String getDescentBoucl() {
		return descentBoucl;
	}

	public void setDescentBoucl(String descentBoucl) {
		this.descentBoucl = descentBoucl;
	}

	public String getPrepaBouton() {
		return prepaBouton;
	}

	public void setPrepaBouton(String prepaBouton) {
		this.prepaBouton = prepaBouton;
	}

	public String getPollinisation() {
		return pollinisation;
	}

	public void setPollinisation(String pollinisation) {
		this.pollinisation = pollinisation;
	}

	public String getLimitGousse() {
		return limitGousse;
	}

	public void setLimitGousse(String limitGousse) {
		this.limitGousse = limitGousse;
	}

	public String getNettoyMort() {
		return nettoyMort;
	}

	public void setNettoyMort(String nettoyMort) {
		this.nettoyMort = nettoyMort;
	}

	public String getArretCoeur() {
		return arretCoeur;
	}

	public void setArretCoeur(String arretCoeur) {
		this.arretCoeur = arretCoeur;
	}

	public String getNettoyaParasit() {
		return nettoyaParasit;
	}

	public void setNettoyaParasit(String nettoyaParasit) {
		this.nettoyaParasit = nettoyaParasit;
	}

	public String getAdyGasy() {
		return adyGasy;
	}

	public void setAdyGasy(String adyGasy) {
		this.adyGasy = adyGasy;
	}

	public String getAppliCompo() {
		return appliCompo;
	}

	public void setAppliCompo(String appliCompo) {
		this.appliCompo = appliCompo;
	}
	
	
	
	
}
