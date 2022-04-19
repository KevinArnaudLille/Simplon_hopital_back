package com.example.demo.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the lit database table.
 * 
 */
@Entity
@NamedQuery(name="Lit.findAll", query="SELECT l FROM Lit l")
public class Lit implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private LitPK id;

	@Column(name="chambre_id")
	private Integer chambreId;

	@Column(name="numero_lit")
	private Integer numeroLit;

	private String type;

	//bi-directional many-to-one association to Chambre
	@JsonIgnore
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="id_chambre", referencedColumnName="id_chambre", insertable = false, updatable = false),
		@JoinColumn(name="id_service", referencedColumnName="id_service", insertable = false, updatable = false)
		})
	private Chambre chambre;

	//bi-directional many-to-one association to Sejour
	@OneToMany(mappedBy="lit")
	private List<Sejour> sejours;

	public Lit() {
	}

	public LitPK getId() {
		return this.id;
	}

	public void setId(LitPK id) {
		this.id = id;
	}

	public Integer getChambreId() {
		return this.chambreId;
	}

	public void setChambreId(Integer chambreId) {
		this.chambreId = chambreId;
	}

	public Integer getNumeroLit() {
		return this.numeroLit;
	}

	public void setNumeroLit(Integer numeroLit) {
		this.numeroLit = numeroLit;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Chambre getChambre() {
		return this.chambre;
	}

	public void setChambre(Chambre chambre) {
		this.chambre = chambre;
	}

	public List<Sejour> getSejours() {
		return this.sejours;
	}

	public void setSejours(List<Sejour> sejours) {
		this.sejours = sejours;
	}

	public Sejour addSejour(Sejour sejour) {
		getSejours().add(sejour);
		sejour.setLit(this);

		return sejour;
	}

	public Sejour removeSejour(Sejour sejour) {
		getSejours().remove(sejour);
		sejour.setLit(null);

		return sejour;
	}

}