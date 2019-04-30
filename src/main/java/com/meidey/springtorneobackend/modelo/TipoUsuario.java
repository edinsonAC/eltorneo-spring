package com.meidey.springtorneobackend.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_usuario database table.
 * 
 */
@Entity
@Table(name="tipo_usuario")
@NamedQuery(name="TipoUsuario.findAll", query="SELECT t FROM TipoUsuario t")
public class TipoUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="tius_id")
	private int tiusId;

	@Column(name="tius_nombre")
	private String tiusNombre;

	//bi-directional many-to-one association to TipoUsuarioPagina
	@OneToMany(mappedBy="tipoUsuario")
	private List<TipoUsuarioPagina> tipoUsuarioPaginas;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="tipoUsuario")
	private List<Usuario> usuarios;

	public TipoUsuario() {
	}

	public int getTiusId() {
		return this.tiusId;
	}

	public void setTiusId(int tiusId) {
		this.tiusId = tiusId;
	}

	public String getTiusNombre() {
		return this.tiusNombre;
	}

	public void setTiusNombre(String tiusNombre) {
		this.tiusNombre = tiusNombre;
	}

	public List<TipoUsuarioPagina> getTipoUsuarioPaginas() {
		return this.tipoUsuarioPaginas;
	}

	public void setTipoUsuarioPaginas(List<TipoUsuarioPagina> tipoUsuarioPaginas) {
		this.tipoUsuarioPaginas = tipoUsuarioPaginas;
	}

	public TipoUsuarioPagina addTipoUsuarioPagina(TipoUsuarioPagina tipoUsuarioPagina) {
		getTipoUsuarioPaginas().add(tipoUsuarioPagina);
		tipoUsuarioPagina.setTipoUsuario(this);

		return tipoUsuarioPagina;
	}

	public TipoUsuarioPagina removeTipoUsuarioPagina(TipoUsuarioPagina tipoUsuarioPagina) {
		getTipoUsuarioPaginas().remove(tipoUsuarioPagina);
		tipoUsuarioPagina.setTipoUsuario(null);

		return tipoUsuarioPagina;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setTipoUsuario(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setTipoUsuario(null);

		return usuario;
	}

}