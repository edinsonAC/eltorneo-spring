package com.meidey.springtorneobackend.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the actividad_jugador database table.
 * 
 */
@Entity
@Table(name="actividad_jugador")
@NamedQuery(name="ActividadJugador.findAll", query="SELECT a FROM ActividadJugador a")
public class ActividadJugador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="acju_id")
	private int acjuId;

	//bi-directional many-to-one association to Jugador
	@ManyToOne
	@JoinColumn(name="juga_id")
	private Jugador jugador;

	//bi-directional many-to-one association to Partido
	@ManyToOne
	@JoinColumn(name="part_id")
	private Partido partido;

	//bi-directional many-to-one association to TipoActividad
	@ManyToOne
	@JoinColumn(name="tiac_id")
	private TipoActividad tipoActividad;

	public ActividadJugador() {
	}

	public int getAcjuId() {
		return this.acjuId;
	}

	public void setAcjuId(int acjuId) {
		this.acjuId = acjuId;
	}

	public Jugador getJugador() {
		return this.jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	public Partido getPartido() {
		return this.partido;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;
	}

	public TipoActividad getTipoActividad() {
		return this.tipoActividad;
	}

	public void setTipoActividad(TipoActividad tipoActividad) {
		this.tipoActividad = tipoActividad;
	}

}