package com.example.demo.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the chambre database table.
 * 
 */
@Entity
@NamedQuery(name="Chambre.findAll", query="SELECT c FROM Chambre c")
public class Chambre implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ChambrePK id;

	@Column(name="numero_chambre")
	private String numeroChambre;

	private String type;

	//bi-directional many-to-one association to Service
	@ManyToOne
	@JoinColumn(name="id_service", referencedColumnName = "id_service", insertable = false, updatable = false)
	private Service service;

	//bi-directional many-to-one association to Lit
	@OneToMany(mappedBy="chambre", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	private List<Lit> lits;

	public Chambre() {
	}

	public ChambrePK getId() {
		return this.id;
	}

	public void setId(ChambrePK id) {
		this.id = id;
	}

	public String getNumeroChambre() {
		return this.numeroChambre;
	}

	public void setNumeroChambre(String numeroChambre) {
		this.numeroChambre = numeroChambre;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Service getService() {
		return this.service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public List<Lit> getLits() {
		return this.lits;
	}

	public void setLits(List<Lit> lits) {
		this.lits = lits;
	}

	public Lit addLit(Lit lit) {
		getLits().add(lit);
		lit.setChambre(this);

		return lit;
	}

	public Lit removeLit(Lit lit) {
		getLits().remove(lit);
		lit.setChambre(null);

		return lit;
	}

}