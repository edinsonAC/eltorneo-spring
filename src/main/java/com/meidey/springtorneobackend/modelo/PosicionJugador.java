package com.meidey.springtorneobackend.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the posicion_jugador database table.
 * 
 */
@Entity
@Table(name="posicion_jugador")
@NamedQuery(name="PosicionJugador.findAll", query="SELECT p FROM PosicionJugador p")
public class PosicionJugador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="poju_id")
	private int pojuId;

	@Column(name="poju_nombre")
	private String pojuNombre;

	//bi-directional many-to-one association to Jugador
	@OneToMany(mappedBy="posicionJugador")
	private List<Jugador> jugadors;

	public PosicionJugador() {
	}

	public int getPojuId() {
		return this.pojuId;
	}

	public void setPojuId(int pojuId) {
		this.pojuId = pojuId;
	}

	public String getPojuNombre() {
		return this.pojuNombre;
	}

	public void setPojuNombre(String pojuNombre) {
		this.pojuNombre = pojuNombre;
	}

	public List<Jugador> getJugadors() {
		return this.jugadors;
	}

	public void setJugadors(List<Jugador> jugadors) {
		this.jugadors = jugadors;
	}

	public Jugador addJugador(Jugador jugador) {
		getJugadors().add(jugador);
		jugador.setPosicionJugador(this);

		return jugador;
	}

	public Jugador removeJugador(Jugador jugador) {
		getJugadors().remove(jugador);
		jugador.setPosicionJugador(null);

		return jugador;
	}

}