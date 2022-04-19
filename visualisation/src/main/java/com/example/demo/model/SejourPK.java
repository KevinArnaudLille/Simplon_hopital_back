package com.example.demo.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the sejour database table.
 * 
 */
@Embeddable
public class SejourPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_service", insertable=false, updatable=false)
	private Integer idService;

	@Column(name="id_chambre", insertable=false, updatable=false)
	private Integer idChambre;

	@Column(name="id_lit", insertable=false, updatable=false)
	private Integer idLit;

	@Column(name="id_patient", insertable=false, updatable=false)
	private Integer idPatient;

	@Column(name="id_sejour")
	private Integer idSejour;

	public SejourPK() {
	}
	public Integer getIdService() {
		return this.idService;
	}
	public void setIdService(Integer idService) {
		this.idService = idService;
	}
	public Integer getIdChambre() {
		return this.idChambre;
	}
	public void setIdChambre(Integer idChambre) {
		this.idChambre = idChambre;
	}
	public Integer getIdLit() {
		return this.idLit;
	}
	public void setIdLit(Integer idLit) {
		this.idLit = idLit;
	}
	public Integer getIdPatient() {
		return this.idPatient;
	}
	public void setIdPatient(Integer idPatient) {
		this.idPatient = idPatient;
	}
	public Integer getIdSejour() {
		return this.idSejour;
	}
	public void setIdSejour(Integer idSejour) {
		this.idSejour = idSejour;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SejourPK)) {
			return false;
		}
		SejourPK castOther = (SejourPK)other;
		return 
			this.idService.equals(castOther.idService)
			&& this.idChambre.equals(castOther.idChambre)
			&& this.idLit.equals(castOther.idLit)
			&& this.idPatient.equals(castOther.idPatient)
			&& this.idSejour.equals(castOther.idSejour);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idService.hashCode();
		hash = hash * prime + this.idChambre.hashCode();
		hash = hash * prime + this.idLit.hashCode();
		hash = hash * prime + this.idPatient.hashCode();
		hash = hash * prime + this.idSejour.hashCode();
		
		return hash;
	}
}