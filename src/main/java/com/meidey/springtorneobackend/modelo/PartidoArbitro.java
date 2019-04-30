package com.meidey.springtorneobackend.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the partido_arbitro database table.
 * 
 */
@Entity
@Table(name="partido_arbitro")
@NamedQuery(name="PartidoArbitro.findAll", query="SELECT p FROM PartidoArbitro p")
public class PartidoArbitro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="paar_id")
	private int paarId;

	@Column(name="paar_arbitrocentral")
	private byte paarArbitrocentral;

	//bi-directional many-to-one association to Arbitro
	@ManyToOne
	@JoinColumn(name="arbi_id")
	private Arbitro arbitro;

	//bi-directional many-to-one association to Partido
	@ManyToOne
	@JoinColumn(name="part_id")
	private Partido partido;

	public PartidoArbitro() {
	}

	public int getPaarId() {
		return this.paarId;
	}

	public void setPaarId(int paarId) {
		this.paarId = paarId;
	}

	public byte getPaarArbitrocentral() {
		return this.paarArbitrocentral;
	}

	public void setPaarArbitrocentral(byte paarArbitrocentral) {
		this.paarArbitrocentral = paarArbitrocentral;
	}

	public Arbitro getArbitro() {
		return this.arbitro;
	}

	public void setArbitro(Arbitro arbitro) {
		this.arbitro = arbitro;
	}

	public Partido getPartido() {
		return this.partido;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;
	}

}