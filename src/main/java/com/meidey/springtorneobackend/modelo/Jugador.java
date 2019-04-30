package com.meidey.springtorneobackend.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the jugador database table.
 * 
 */
@Entity
@NamedQuery(name="Jugador.findAll", query="SELECT j FROM Jugador j")
public class Jugador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="juga_id")
	private int jugaId;

	@Column(name="juga_apellido")
	private String jugaApellido;

	@Column(name="juga_celular")
	private String jugaCelular;

	@Column(name="juga_direccion")
	private String jugaDireccion;

	@Column(name="juga_documento")
	private String jugaDocumento;

	@Column(name="juga_dorsal")
	private byte jugaDorsal;

	@Column(name="juga_estado")
	private byte jugaEstado;

	@Column(name="juga_nombre")
	private String jugaNombre;

	@Column(name="juga_telefono")
	private String jugaTelefono;

	//bi-directional many-to-one association to ActividadJugador
	@OneToMany(mappedBy="jugador")
	private List<ActividadJugador> actividadJugadors;

	//bi-directional many-to-one association to Equipo
	@ManyToOne
	@JoinColumn(name="equi_id")
	private Equipo equipo;

	//bi-directional many-to-one association to PosicionJugador
	@ManyToOne
	@JoinColumn(name="poju_id")
	private PosicionJugador posicionJugador;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="usua_id")
	private Usuario usuario;

	//bi-directional many-to-one association to JugadorPartido
	@OneToMany(mappedBy="jugador")
	private List<JugadorPartido> jugadorPartidos;

	public Jugador() {
	}

	public int getJugaId() {
		return this.jugaId;
	}

	public void setJugaId(int jugaId) {
		this.jugaId = jugaId;
	}

	public String getJugaApellido() {
		return this.jugaApellido;
	}

	public void setJugaApellido(String jugaApellido) {
		this.jugaApellido = jugaApellido;
	}

	public String getJugaCelular() {
		return this.jugaCelular;
	}

	public void setJugaCelular(String jugaCelular) {
		this.jugaCelular = jugaCelular;
	}

	public String getJugaDireccion() {
		return this.jugaDireccion;
	}

	public void setJugaDireccion(String jugaDireccion) {
		this.jugaDireccion = jugaDireccion;
	}

	public String getJugaDocumento() {
		return this.jugaDocumento;
	}

	public void setJugaDocumento(String jugaDocumento) {
		this.jugaDocumento = jugaDocumento;
	}

	public byte getJugaDorsal() {
		return this.jugaDorsal;
	}

	public void setJugaDorsal(byte jugaDorsal) {
		this.jugaDorsal = jugaDorsal;
	}

	public byte getJugaEstado() {
		return this.jugaEstado;
	}

	public void setJugaEstado(byte jugaEstado) {
		this.jugaEstado = jugaEstado;
	}

	public String getJugaNombre() {
		return this.jugaNombre;
	}

	public void setJugaNombre(String jugaNombre) {
		this.jugaNombre = jugaNombre;
	}

	public String getJugaTelefono() {
		return this.jugaTelefono;
	}

	public void setJugaTelefono(String jugaTelefono) {
		this.jugaTelefono = jugaTelefono;
	}

	public List<ActividadJugador> getActividadJugadors() {
		return this.actividadJugadors;
	}

	public void setActividadJugadors(List<ActividadJugador> actividadJugadors) {
		this.actividadJugadors = actividadJugadors;
	}

	public ActividadJugador addActividadJugador(ActividadJugador actividadJugador) {
		getActividadJugadors().add(actividadJugador);
		actividadJugador.setJugador(this);

		return actividadJugador;
	}

	public ActividadJugador removeActividadJugador(ActividadJugador actividadJugador) {
		getActividadJugadors().remove(actividadJugador);
		actividadJugador.setJugador(null);

		return actividadJugador;
	}

	public Equipo getEquipo() {
		return this.equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public PosicionJugador getPosicionJugador() {
		return this.posicionJugador;
	}

	public void setPosicionJugador(PosicionJugador posicionJugador) {
		this.posicionJugador = posicionJugador;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<JugadorPartido> getJugadorPartidos() {
		return this.jugadorPartidos;
	}

	public void setJugadorPartidos(List<JugadorPartido> jugadorPartidos) {
		this.jugadorPartidos = jugadorPartidos;
	}

	public JugadorPartido addJugadorPartido(JugadorPartido jugadorPartido) {
		getJugadorPartidos().add(jugadorPartido);
		jugadorPartido.setJugador(this);

		return jugadorPartido;
	}

	public JugadorPartido removeJugadorPartido(JugadorPartido jugadorPartido) {
		getJugadorPartidos().remove(jugadorPartido);
		jugadorPartido.setJugador(null);

		return jugadorPartido;
	}

}