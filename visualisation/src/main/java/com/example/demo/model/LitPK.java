package com.example.demo.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the lit database table.
 * 
 */
@Embeddable
public class LitPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_service", insertable=false, updatable=false)
	private Integer idService;

	@Column(name="id_chambre", insertable=false, updatable=false)
	private Integer idChambre;

	@Column(name="id_lit")
	private Integer idLit;

	public LitPK() {
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

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof LitPK)) {
			return false;
		}
		LitPK castOther = (LitPK)other;
		return 
			this.idService.equals(castOther.idService)
			&& this.idChambre.equals(castOther.idChambre)
			&& this.idLit.equals(castOther.idLit);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idService.hashCode();
		hash = hash * prime + this.idChambre.hashCode();
		hash = hash * prime + this.idLit.hashCode();
		
		return hash;
	}
}