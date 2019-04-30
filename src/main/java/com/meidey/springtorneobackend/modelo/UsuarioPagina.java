package com.meidey.springtorneobackend.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the usuario_paginas database table.
 * 
 */
@Entity
@Table(name="usuario_paginas")
@NamedQuery(name="UsuarioPagina.findAll", query="SELECT u FROM UsuarioPagina u")
public class UsuarioPagina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="uspa_id")
	private int uspaId;

	//bi-directional many-to-one association to Pagina
	@ManyToOne
	@JoinColumn(name="pagi_id")
	private Pagina pagina;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="usua_id")
	private Usuario usuario;

	public UsuarioPagina() {
	}

	public int getUspaId() {
		return this.uspaId;
	}

	public void setUspaId(int uspaId) {
		this.uspaId = uspaId;
	}

	public Pagina getPagina() {
		return this.pagina;
	}

	public void setPagina(Pagina pagina) {
		this.pagina = pagina;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}