package com.meidey.springtorneobackend.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_actividad database table.
 * 
 */
@Entity
@Table(name="tipo_actividad")
@NamedQuery(name="TipoActividad.findAll", query="SELECT t FROM TipoActividad t")
public class TipoActividad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="tiac_id")
	private int tiacId;

	@Column(name="tiac_descripcion")
	private String tiacDescripcion;

	//bi-directional many-to-one association to ActividadJugador
	@OneToMany(mappedBy="tipoActividad")
	private List<ActividadJugador> actividadJugadors;

	public TipoActividad() {
	}

	public int getTiacId() {
		return this.tiacId;
	}

	public void setTiacId(int tiacId) {
		this.tiacId = tiacId;
	}

	public String getTiacDescripcion() {
		return this.tiacDescripcion;
	}

	public void setTiacDescripcion(String tiacDescripcion) {
		this.tiacDescripcion = tiacDescripcion;
	}

	public List<ActividadJugador> getActividadJugadors() {
		return this.actividadJugadors;
	}

	public void setActividadJugadors(List<ActividadJugador> actividadJugadors) {
		this.actividadJugadors = actividadJugadors;
	}

	public ActividadJugador addActividadJugador(ActividadJugador actividadJugador) {
		getActividadJugadors().add(actividadJugador);
		actividadJugador.setTipoActividad(this);

		return actividadJugador;
	}

	public ActividadJugador removeActividadJugador(ActividadJugador actividadJugador) {
		getActividadJugadors().remove(actividadJugador);
		actividadJugador.setTipoActividad(null);

		return actividadJugador;
	}

}