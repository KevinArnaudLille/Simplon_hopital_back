package com.example.demo.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the chambre database table.
 * 
 */
@Embeddable
public class ChambrePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_service", insertable=false, updatable=false)
	private Integer idService;

	@Column(name="id_chambre")
	private Integer idChambre;

	public ChambrePK() {
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

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ChambrePK)) {
			return false;
		}
		ChambrePK castOther = (ChambrePK)other;
		return 
			this.idService.equals(castOther.idService)
			&& this.idChambre.equals(castOther.idChambre);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idService.hashCode();
		hash = hash * prime + this.idChambre.hashCode();
		
		return hash;
	}
}