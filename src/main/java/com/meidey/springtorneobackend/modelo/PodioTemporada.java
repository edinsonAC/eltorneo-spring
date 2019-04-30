package com.meidey.springtorneobackend.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the podio_temporada database table.
 * 
 */
@Entity
@Table(name="podio_temporada")
@NamedQuery(name="PodioTemporada.findAll", query="SELECT p FROM PodioTemporada p")
public class PodioTemporada implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="podi_id")
	private int podiId;

	@Column(name="podi_primero")
	private String podiPrimero;

	@Column(name="podi_segundo")
	private String podiSegundo;

	@Column(name="podio_tercero")
	private String podioTercero;

	//bi-directional many-to-one association to Equipo
	@ManyToOne
	@JoinColumn(name="equi_id")
	private Equipo equipo;

	//bi-directional many-to-one association to Temporada
	@ManyToOne
	@JoinColumn(name="temp_id")
	private Temporada temporada;

	public PodioTemporada() {
	}

	public int getPodiId() {
		return this.podiId;
	}

	public void setPodiId(int podiId) {
		this.podiId = podiId;
	}

	public String getPodiPrimero() {
		return this.podiPrimero;
	}

	public void setPodiPrimero(String podiPrimero) {
		this.podiPrimero = podiPrimero;
	}

	public String getPodiSegundo() {
		return this.podiSegundo;
	}

	public void setPodiSegundo(String podiSegundo) {
		this.podiSegundo = podiSegundo;
	}

	public String getPodioTercero() {
		return this.podioTercero;
	}

	public void setPodioTercero(String podioTercero) {
		this.podioTercero = podioTercero;
	}

	public Equipo getEquipo() {
		return this.equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public Temporada getTemporada() {
		return this.temporada;
	}

	public void setTemporada(Temporada temporada) {
		this.temporada = temporada;
	}

}