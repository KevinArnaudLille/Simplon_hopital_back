package com.example.demo.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the sejour database table.
 * 
 */
@Entity
@NamedQuery(name="Sejour.findAll", query="SELECT s FROM Sejour s")
public class Sejour implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SejourPK id;

	@Temporal(TemporalType.DATE)
	@Column(name="date_entree")
	private Date dateEntree;

	@Temporal(TemporalType.DATE)
	@Column(name="date_sortie")
	private Date dateSortie;

	@Column(name="heure_entree")
	private Time heureEntree;

	@Column(name="heure_sortie")
	private String heureSortie;

	//bi-directional many-to-one association to Lit
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="id_chambre", referencedColumnName="id_chambre", insertable = false, updatable = false),
		@JoinColumn(name="id_lit", referencedColumnName="id_lit", insertable = false, updatable = false),
		@JoinColumn(name="id_service", referencedColumnName="id_service", insertable = false, updatable = false)
		})
	private Lit lit;

	//bi-directional many-to-one association to Patient
	@ManyToOne
	@JoinColumn(name="id_patient", referencedColumnName="id_patient", insertable = false, updatable = false)
	private Patient patient;

	public Sejour() {
	}

	public SejourPK getId() {
		return this.id;
	}

	public void setId(SejourPK id) {
		this.id = id;
	}

	public Date getDateEntree() {
		return this.dateEntree;
	}

	public void setDateEntree(Date dateEntree) {
		this.dateEntree = dateEntree;
	}

	public Date getDateSortie() {
		return this.dateSortie;
	}

	public void setDateSortie(Date dateSortie) {
		this.dateSortie = dateSortie;
	}

	public Time getHeureEntree() {
		return this.heureEntree;
	}

	public void setHeureEntree(Time heureEntree) {
		this.heureEntree = heureEntree;
	}

	public String getHeureSortie() {
		return this.heureSortie;
	}

	public void setHeureSortie(String heureSortie) {
		this.heureSortie = heureSortie;
	}

	public Lit getLit() {
		return this.lit;
	}

	public void setLit(Lit lit) {
		this.lit = lit;
	}

	public Patient getPatient() {
		return this.patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

}