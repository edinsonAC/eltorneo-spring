package com.meidey.springtorneobackend.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the tecnico database table.
 * 
 */
@Entity
@NamedQuery(name="Tecnico.findAll", query="SELECT t FROM Tecnico t")
public class Tecnico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="tecn_id")
	private int tecnId;

	@Column(name="tecn_apellido")
	private String tecnApellido;

	@Column(name="tecn_celular")
	private String tecnCelular;

	@Column(name="tecn_direccion")
	private String tecnDireccion;

	@Column(name="tecn_documento")
	private String tecnDocumento;

	@Column(name="tecn_fecharegistro")
	private Timestamp tecnFecharegistro;

	@Column(name="tecn_nombre")
	private String tecnNombre;

	@Column(name="tecn_telefono")
	private String tecnTelefono;

	//bi-directional many-to-one association to Equipo
	@OneToMany(mappedBy="tecnico")
	private List<Equipo> equipos;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="usua_id")
	private Usuario usuario;

	public Tecnico() {
	}

	public int getTecnId() {
		return this.tecnId;
	}

	public void setTecnId(int tecnId) {
		this.tecnId = tecnId;
	}

	public String getTecnApellido() {
		return this.tecnApellido;
	}

	public void setTecnApellido(String tecnApellido) {
		this.tecnApellido = tecnApellido;
	}

	public String getTecnCelular() {
		return this.tecnCelular;
	}

	public void setTecnCelular(String tecnCelular) {
		this.tecnCelular = tecnCelular;
	}

	public String getTecnDireccion() {
		return this.tecnDireccion;
	}

	public void setTecnDireccion(String tecnDireccion) {
		this.tecnDireccion = tecnDireccion;
	}

	public String getTecnDocumento() {
		return this.tecnDocumento;
	}

	public void setTecnDocumento(String tecnDocumento) {
		this.tecnDocumento = tecnDocumento;
	}

	public Timestamp getTecnFecharegistro() {
		return this.tecnFecharegistro;
	}

	public void setTecnFecharegistro(Timestamp tecnFecharegistro) {
		this.tecnFecharegistro = tecnFecharegistro;
	}

	public String getTecnNombre() {
		return this.tecnNombre;
	}

	public void setTecnNombre(String tecnNombre) {
		this.tecnNombre = tecnNombre;
	}

	public String getTecnTelefono() {
		return this.tecnTelefono;
	}

	public void setTecnTelefono(String tecnTelefono) {
		this.tecnTelefono = tecnTelefono;
	}

	public List<Equipo> getEquipos() {
		return this.equipos;
	}

	public void setEquipos(List<Equipo> equipos) {
		this.equipos = equipos;
	}

	public Equipo addEquipo(Equipo equipo) {
		getEquipos().add(equipo);
		equipo.setTecnico(this);

		return equipo;
	}

	public Equipo removeEquipo(Equipo equipo) {
		getEquipos().remove(equipo);
		equipo.setTecnico(null);

		return equipo;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}