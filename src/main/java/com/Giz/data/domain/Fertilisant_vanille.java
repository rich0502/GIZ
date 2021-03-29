package com.Giz.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fertilisant_vanille")
public class Fertilisant_vanille {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 40)
	private  String code_pro;
	@Column(length = 3)
	private String use_fertilisant;
	@Column(length = 50)
	private String type_use;
	@Column(length = 200)
	private String autre;
	@Column(length = 70)
	private String qte;
	private int nbr_ans;
	
	public Fertilisant_vanille() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Fertilisant_vanille(Long id, String code_pro, String use_fertilisant, String type_use, String autre,
			String qte, int nbr_ans) {
		super();
		this.id = id;
		this.code_pro = code_pro;
		this.use_fertilisant = use_fertilisant;
		this.type_use = type_use;
		this.autre = autre;
		this.qte = qte;
		this.nbr_ans = nbr_ans;
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

	public String getUse_fertilisant() {
		return use_fertilisant;
	}

	public void setUse_fertilisant(String use_fertilisant) {
		this.use_fertilisant = use_fertilisant;
	}

	public String getType_use() {
		return type_use;
	}

	public void setType_use(String type_use) {
		this.type_use = type_use;
	}

	public String getAutre() {
		return autre;
	}

	public void setAutre(String autre) {
		this.autre = autre;
	}

	public String getQte() {
		return qte;
	}

	public void setQte(String qte) {
		this.qte = qte;
	}

	public int getNbr_ans() {
		return nbr_ans;
	}

	public void setNbr_ans(int nbr_ans) {
		this.nbr_ans = nbr_ans;
	}
	
	
}
