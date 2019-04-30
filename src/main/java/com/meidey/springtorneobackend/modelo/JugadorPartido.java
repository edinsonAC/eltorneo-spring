package com.meidey.springtorneobackend.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the jugador_partido database table.
 * 
 */
@Entity
@Table(name="jugador_partido")
@NamedQuery(name="JugadorPartido.findAll", query="SELECT j FROM JugadorPartido j")
public class JugadorPartido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="jupa_id")
	private int jupaId;

	//bi-directional many-to-one association to Jugador
	@ManyToOne
	@JoinColumn(name="juga_id")
	private Jugador jugador;

	//bi-directional many-to-one association to Partido
	@ManyToOne
	@JoinColumn(name="part_id")
	private Partido partido;

	public JugadorPartido() {
	}

	public int getJupaId() {
		return this.jupaId;
	}

	public void setJupaId(int jupaId) {
		this.jupaId = jupaId;
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

}