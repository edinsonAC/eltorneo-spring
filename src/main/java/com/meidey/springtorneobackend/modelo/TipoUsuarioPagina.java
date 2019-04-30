package com.meidey.springtorneobackend.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tipo_usuario_pagina database table.
 * 
 */
@Entity
@Table(name="tipo_usuario_pagina")
@NamedQuery(name="TipoUsuarioPagina.findAll", query="SELECT t FROM TipoUsuarioPagina t")
public class TipoUsuarioPagina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="tiup_id")
	private int tiupId;

	//bi-directional many-to-one association to Pagina
	@ManyToOne
	@JoinColumn(name="pagi_id")
	private Pagina pagina;

	//bi-directional many-to-one association to TipoUsuario
	@ManyToOne
	@JoinColumn(name="tius_id")
	private TipoUsuario tipoUsuario;

	public TipoUsuarioPagina() {
	}

	public int getTiupId() {
		return this.tiupId;
	}

	public void setTiupId(int tiupId) {
		this.tiupId = tiupId;
	}

	public Pagina getPagina() {
		return this.pagina;
	}

	public void setPagina(Pagina pagina) {
		this.pagina = pagina;
	}

	public TipoUsuario getTipoUsuario() {
		return this.tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

}