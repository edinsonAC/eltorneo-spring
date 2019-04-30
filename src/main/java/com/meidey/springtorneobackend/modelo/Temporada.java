package com.meidey.springtorneobackend.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the temporada database table.
 * 
 */
@Entity
@NamedQuery(name="Temporada.findAll", query="SELECT t FROM Temporada t")
public class Temporada implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="temp_id")
	private int tempId;

	@Column(name="temp_fechafinal")
	private String tempFechafinal;

	@Column(name="temp_fechainicial")
	private String tempFechainicial;

	@Column(name="temp_nombre")
	private String tempNombre;

	@Column(name="temp_numequipos")
	private String tempNumequipos;

	@Column(name="temp_premioprimero")
	private String tempPremioprimero;

	@Column(name="temp_premiosegundo")
	private String tempPremiosegundo;

	@Column(name="temp_premiotercero")
	private String tempPremiotercero;

	@Column(name="temp_sorteo")
	private String tempSorteo;

	//bi-directional many-to-one association to Partido
	@OneToMany(mappedBy="temporada")
	private List<Partido> partidos;

	//bi-directional many-to-one association to PodioTemporada
	@OneToMany(mappedBy="temporada")
	private List<PodioTemporada> podioTemporadas;

	public Temporada() {
	}

	public int getTempId() {
		return this.tempId;
	}

	public void setTempId(int tempId) {
		this.tempId = tempId;
	}

	public String getTempFechafinal() {
		return this.tempFechafinal;
	}

	public void setTempFechafinal(String tempFechafinal) {
		this.tempFechafinal = tempFechafinal;
	}

	public String getTempFechainicial() {
		return this.tempFechainicial;
	}

	public void setTempFechainicial(String tempFechainicial) {
		this.tempFechainicial = tempFechainicial;
	}

	public String getTempNombre() {
		return this.tempNombre;
	}

	public void setTempNombre(String tempNombre) {
		this.tempNombre = tempNombre;
	}

	public String getTempNumequipos() {
		return this.tempNumequipos;
	}

	public void setTempNumequipos(String tempNumequipos) {
		this.tempNumequipos = tempNumequipos;
	}

	public String getTempPremioprimero() {
		return this.tempPremioprimero;
	}

	public void setTempPremioprimero(String tempPremioprimero) {
		this.tempPremioprimero = tempPremioprimero;
	}

	public String getTempPremiosegundo() {
		return this.tempPremiosegundo;
	}

	public void setTempPremiosegundo(String tempPremiosegundo) {
		this.tempPremiosegundo = tempPremiosegundo;
	}

	public String getTempPremiotercero() {
		return this.tempPremiotercero;
	}

	public void setTempPremiotercero(String tempPremiotercero) {
		this.tempPremiotercero = tempPremiotercero;
	}

	public String getTempSorteo() {
		return this.tempSorteo;
	}

	public void setTempSorteo(String tempSorteo) {
		this.tempSorteo = tempSorteo;
	}

	public List<Partido> getPartidos() {
		return this.partidos;
	}

	public void setPartidos(List<Partido> partidos) {
		this.partidos = partidos;
	}

	public Partido addPartido(Partido partido) {
		getPartidos().add(partido);
		partido.setTemporada(this);

		return partido;
	}

	public Partido removePartido(Partido partido) {
		getPartidos().remove(partido);
		partido.setTemporada(null);

		return partido;
	}

	public List<PodioTemporada> getPodioTemporadas() {
		return this.podioTemporadas;
	}

	public void setPodioTemporadas(List<PodioTemporada> podioTemporadas) {
		this.podioTemporadas = podioTemporadas;
	}

	public PodioTemporada addPodioTemporada(PodioTemporada podioTemporada) {
		getPodioTemporadas().add(podioTemporada);
		podioTemporada.setTemporada(this);

		return podioTemporada;
	}

	public PodioTemporada removePodioTemporada(PodioTemporada podioTemporada) {
		getPodioTemporadas().remove(podioTemporada);
		podioTemporada.setTemporada(null);

		return podioTemporada;
	}

}