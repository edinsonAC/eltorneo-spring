package com.meidey.springtorneobackend.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the equipo database table.
 * 
 */
@Entity
@NamedQuery(name="Equipo.findAll", query="SELECT e FROM Equipo e")
public class Equipo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="equi_id")
	private int equiId;

	@Column(name="equi_estado")
	private byte equiEstado;

	@Column(name="equi_fecharegistro")
	private Timestamp equiFecharegistro;

	@Column(name="equi_golescontra")
	private int equiGolescontra;

	@Column(name="equi_golesfavor")
	private int equiGolesfavor;

	@Column(name="equi_imagen")
	private String equiImagen;

	@Column(name="equi_inscripcion")
	private String equiInscripcion;

	@Column(name="equi_nombre")
	private String equiNombre;

	@Column(name="equi_puntos")
	private String equiPuntos;

	//bi-directional many-to-one association to Tecnico
	@ManyToOne
	@JoinColumn(name="tecn_id")
	private Tecnico tecnico;

	//bi-directional many-to-one association to Jugador
	@OneToMany(mappedBy="equipo")
	private List<Jugador> jugadors;

	//bi-directional many-to-one association to Partido
	@OneToMany(mappedBy="equipo1")
	private List<Partido> partidos1;

	//bi-directional many-to-one association to Partido
	@OneToMany(mappedBy="equipo2")
	private List<Partido> partidos2;

	//bi-directional many-to-one association to PodioTemporada
	@OneToMany(mappedBy="equipo")
	private List<PodioTemporada> podioTemporadas;

	public Equipo() {
	}

	public int getEquiId() {
		return this.equiId;
	}

	public void setEquiId(int equiId) {
		this.equiId = equiId;
	}

	public byte getEquiEstado() {
		return this.equiEstado;
	}

	public void setEquiEstado(byte equiEstado) {
		this.equiEstado = equiEstado;
	}

	public Timestamp getEquiFecharegistro() {
		return this.equiFecharegistro;
	}

	public void setEquiFecharegistro(Timestamp equiFecharegistro) {
		this.equiFecharegistro = equiFecharegistro;
	}

	public int getEquiGolescontra() {
		return this.equiGolescontra;
	}

	public void setEquiGolescontra(int equiGolescontra) {
		this.equiGolescontra = equiGolescontra;
	}

	public int getEquiGolesfavor() {
		return this.equiGolesfavor;
	}

	public void setEquiGolesfavor(int equiGolesfavor) {
		this.equiGolesfavor = equiGolesfavor;
	}

	public String getEquiImagen() {
		return this.equiImagen;
	}

	public void setEquiImagen(String equiImagen) {
		this.equiImagen = equiImagen;
	}

	public String getEquiInscripcion() {
		return this.equiInscripcion;
	}

	public void setEquiInscripcion(String equiInscripcion) {
		this.equiInscripcion = equiInscripcion;
	}

	public String getEquiNombre() {
		return this.equiNombre;
	}

	public void setEquiNombre(String equiNombre) {
		this.equiNombre = equiNombre;
	}

	public String getEquiPuntos() {
		return this.equiPuntos;
	}

	public void setEquiPuntos(String equiPuntos) {
		this.equiPuntos = equiPuntos;
	}

	public Tecnico getTecnico() {
		return this.tecnico;
	}

	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}

	public List<Jugador> getJugadors() {
		return this.jugadors;
	}

	public void setJugadors(List<Jugador> jugadors) {
		this.jugadors = jugadors;
	}

	public Jugador addJugador(Jugador jugador) {
		getJugadors().add(jugador);
		jugador.setEquipo(this);

		return jugador;
	}

	public Jugador removeJugador(Jugador jugador) {
		getJugadors().remove(jugador);
		jugador.setEquipo(null);

		return jugador;
	}

	public List<Partido> getPartidos1() {
		return this.partidos1;
	}

	public void setPartidos1(List<Partido> partidos1) {
		this.partidos1 = partidos1;
	}

	public Partido addPartidos1(Partido partidos1) {
		getPartidos1().add(partidos1);
		partidos1.setEquipo1(this);

		return partidos1;
	}

	public Partido removePartidos1(Partido partidos1) {
		getPartidos1().remove(partidos1);
		partidos1.setEquipo1(null);

		return partidos1;
	}

	public List<Partido> getPartidos2() {
		return this.partidos2;
	}

	public void setPartidos2(List<Partido> partidos2) {
		this.partidos2 = partidos2;
	}

	public Partido addPartidos2(Partido partidos2) {
		getPartidos2().add(partidos2);
		partidos2.setEquipo2(this);

		return partidos2;
	}

	public Partido removePartidos2(Partido partidos2) {
		getPartidos2().remove(partidos2);
		partidos2.setEquipo2(null);

		return partidos2;
	}

	public List<PodioTemporada> getPodioTemporadas() {
		return this.podioTemporadas;
	}

	public void setPodioTemporadas(List<PodioTemporada> podioTemporadas) {
		this.podioTemporadas = podioTemporadas;
	}

	public PodioTemporada addPodioTemporada(PodioTemporada podioTemporada) {
		getPodioTemporadas().add(podioTemporada);
		podioTemporada.setEquipo(this);

		return podioTemporada;
	}

	public PodioTemporada removePodioTemporada(PodioTemporada podioTemporada) {
		getPodioTemporadas().remove(podioTemporada);
		podioTemporada.setEquipo(null);

		return podioTemporada;
	}

}