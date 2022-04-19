package com.example.demo.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the service database table.
 * 
 */
@Entity
@NamedQuery(name="Service.findAll", query="SELECT s FROM Service s")
public class Service implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_service")
	private Integer idService;

	private Integer etage;

	@Column(name="nom_du_service")
	private String nomDuService;

	@Column(name="nombre_chambre")
	private Integer nombreChambre;

	@Column(name="nombre_patient")
	private Integer nombrePatient;

	//bi-directional many-to-one association to Chambre
	@OneToMany(mappedBy="service")
	private List<Chambre> chambres;

	public Service() {
	}

	public Integer getIdService() {
		return this.idService;
	}

	public void setIdService(Integer idService) {
		this.idService = idService;
	}

	public Integer getEtage() {
		return this.etage;
	}

	public void setEtage(Integer etage) {
		this.etage = etage;
	}

	public String getNomDuService() {
		return this.nomDuService;
	}

	public void setNomDuService(String nomDuService) {
		this.nomDuService = nomDuService;
	}

	public Integer getNombreChambre() {
		return this.nombreChambre;
	}

	public void setNombreChambre(Integer nombreChambre) {
		this.nombreChambre = nombreChambre;
	}

	public Integer getNombrePatient() {
		return this.nombrePatient;
	}

	public void setNombrePatient(Integer nombrePatient) {
		this.nombrePatient = nombrePatient;
	}

	public List<Chambre> getChambres() {
		return this.chambres;
	}

	public void setChambres(List<Chambre> chambres) {
		this.chambres = chambres;
	}

	public Chambre addChambre(Chambre chambre) {
		getChambres().add(chambre);
		chambre.setService(this);

		return chambre;
	}

	public Chambre removeChambre(Chambre chambre) {
		getChambres().remove(chambre);
		chambre.setService(null);

		return chambre;
	}

}