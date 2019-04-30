package com.meidey.springtorneobackend.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the partido database table.
 * 
 */
@Entity
@NamedQuery(name="Partido.findAll", query="SELECT p FROM Partido p")
public class Partido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="part_id")
	private int partId;

	@Column(name="goles_a")
	private int golesA;

	@Column(name="goles_b")
	private int golesB;

	@Column(name="part_dia")
	private String partDia;

	@Column(name="part_estado")
	private byte partEstado;

	@Column(name="part_jornada")
	private int partJornada;

	//bi-directional many-to-one association to ActividadJugador
	@OneToMany(mappedBy="partido")
	private List<ActividadJugador> actividadJugadors;

	//bi-directional many-to-one association to JugadorPartido
	@OneToMany(mappedBy="partido")
	private List<JugadorPartido> jugadorPartidos;

	//bi-directional many-to-one association to Equipo
	@ManyToOne
	@JoinColumn(name="equi_a")
	private Equipo equipo1;

	//bi-directional many-to-one association to Equipo
	@ManyToOne
	@JoinColumn(name="equi_b")
	private Equipo equipo2;

	//bi-directional many-to-one association to HorarioPartido
	@ManyToOne
	@JoinColumn(name="hopa_id")
	private HorarioPartido horarioPartido;

	//bi-directional many-to-one association to Temporada
	@ManyToOne
	@JoinColumn(name="temp_id")
	private Temporada temporada;

	//bi-directional many-to-one association to PartidoArbitro
	@OneToMany(mappedBy="partido")
	private List<PartidoArbitro> partidoArbitros;

	public Partido() {
	}

	public int getPartId() {
		return this.partId;
	}

	public void setPartId(int partId) {
		this.partId = partId;
	}

	public int getGolesA() {
		return this.golesA;
	}

	public void setGolesA(int golesA) {
		this.golesA = golesA;
	}

	public int getGolesB() {
		return this.golesB;
	}

	public void setGolesB(int golesB) {
		this.golesB = golesB;
	}

	public String getPartDia() {
		return this.partDia;
	}

	public void setPartDia(String partDia) {
		this.partDia = partDia;
	}

	public byte getPartEstado() {
		return this.partEstado;
	}

	public void setPartEstado(byte partEstado) {
		this.partEstado = partEstado;
	}

	public int getPartJornada() {
		return this.partJornada;
	}

	public void setPartJornada(int partJornada) {
		this.partJornada = partJornada;
	}

	public List<ActividadJugador> getActividadJugadors() {
		return this.actividadJugadors;
	}

	public void setActividadJugadors(List<ActividadJugador> actividadJugadors) {
		this.actividadJugadors = actividadJugadors;
	}

	public ActividadJugador addActividadJugador(ActividadJugador actividadJugador) {
		getActividadJugadors().add(actividadJugador);
		actividadJugador.setPartido(this);

		return actividadJugador;
	}

	public ActividadJugador removeActividadJugador(ActividadJugador actividadJugador) {
		getActividadJugadors().remove(actividadJugador);
		actividadJugador.setPartido(null);

		return actividadJugador;
	}

	public List<JugadorPartido> getJugadorPartidos() {
		return this.jugadorPartidos;
	}

	public void setJugadorPartidos(List<JugadorPartido> jugadorPartidos) {
		this.jugadorPartidos = jugadorPartidos;
	}

	public JugadorPartido addJugadorPartido(JugadorPartido jugadorPartido) {
		getJugadorPartidos().add(jugadorPartido);
		jugadorPartido.setPartido(this);

		return jugadorPartido;
	}

	public JugadorPartido removeJugadorPartido(JugadorPartido jugadorPartido) {
		getJugadorPartidos().remove(jugadorPartido);
		jugadorPartido.setPartido(null);

		return jugadorPartido;
	}

	public Equipo getEquipo1() {
		return this.equipo1;
	}

	public void setEquipo1(Equipo equipo1) {
		this.equipo1 = equipo1;
	}

	public Equipo getEquipo2() {
		return this.equipo2;
	}

	public void setEquipo2(Equipo equipo2) {
		this.equipo2 = equipo2;
	}

	public HorarioPartido getHorarioPartido() {
		return this.horarioPartido;
	}

	public void setHorarioPartido(HorarioPartido horarioPartido) {
		this.horarioPartido = horarioPartido;
	}

	public Temporada getTemporada() {
		return this.temporada;
	}

	public void setTemporada(Temporada temporada) {
		this.temporada = temporada;
	}

	public List<PartidoArbitro> getPartidoArbitros() {
		return this.partidoArbitros;
	}

	public void setPartidoArbitros(List<PartidoArbitro> partidoArbitros) {
		this.partidoArbitros = partidoArbitros;
	}

	public PartidoArbitro addPartidoArbitro(PartidoArbitro partidoArbitro) {
		getPartidoArbitros().add(partidoArbitro);
		partidoArbitro.setPartido(this);

		return partidoArbitro;
	}

	public PartidoArbitro removePartidoArbitro(PartidoArbitro partidoArbitro) {
		getPartidoArbitros().remove(partidoArbitro);
		partidoArbitro.setPartido(null);

		return partidoArbitro;
	}

}