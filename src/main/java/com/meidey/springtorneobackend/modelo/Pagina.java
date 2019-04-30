package com.meidey.springtorneobackend.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the pagina database table.
 * 
 */
@Entity
@NamedQuery(name="Pagina.findAll", query="SELECT p FROM Pagina p")
public class Pagina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="pagi_id")
	private int pagiId;

	@Column(name="pagi_icono")
	private String pagiIcono;

	@Column(name="pagi_pagina")
	private String pagiPagina;

	@Column(name="pagi_titulo")
	private String pagiTitulo;

	//bi-directional many-to-one association to Menu
	@ManyToOne
	@JoinColumn(name="menu_id")
	private Menu menu;

	//bi-directional many-to-one association to TipoUsuarioPagina
	@OneToMany(mappedBy="pagina")
	private List<TipoUsuarioPagina> tipoUsuarioPaginas;

	//bi-directional many-to-one association to UsuarioPagina
	@OneToMany(mappedBy="pagina")
	private List<UsuarioPagina> usuarioPaginas;

	public Pagina() {
	}

	public int getPagiId() {
		return this.pagiId;
	}

	public void setPagiId(int pagiId) {
		this.pagiId = pagiId;
	}

	public String getPagiIcono() {
		return this.pagiIcono;
	}

	public void setPagiIcono(String pagiIcono) {
		this.pagiIcono = pagiIcono;
	}

	public String getPagiPagina() {
		return this.pagiPagina;
	}

	public void setPagiPagina(String pagiPagina) {
		this.pagiPagina = pagiPagina;
	}

	public String getPagiTitulo() {
		return this.pagiTitulo;
	}

	public void setPagiTitulo(String pagiTitulo) {
		this.pagiTitulo = pagiTitulo;
	}

	public Menu getMenu() {
		return this.menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public List<TipoUsuarioPagina> getTipoUsuarioPaginas() {
		return this.tipoUsuarioPaginas;
	}

	public void setTipoUsuarioPaginas(List<TipoUsuarioPagina> tipoUsuarioPaginas) {
		this.tipoUsuarioPaginas = tipoUsuarioPaginas;
	}

	public TipoUsuarioPagina addTipoUsuarioPagina(TipoUsuarioPagina tipoUsuarioPagina) {
		getTipoUsuarioPaginas().add(tipoUsuarioPagina);
		tipoUsuarioPagina.setPagina(this);

		return tipoUsuarioPagina;
	}

	public TipoUsuarioPagina removeTipoUsuarioPagina(TipoUsuarioPagina tipoUsuarioPagina) {
		getTipoUsuarioPaginas().remove(tipoUsuarioPagina);
		tipoUsuarioPagina.setPagina(null);

		return tipoUsuarioPagina;
	}

	public List<UsuarioPagina> getUsuarioPaginas() {
		return this.usuarioPaginas;
	}

	public void setUsuarioPaginas(List<UsuarioPagina> usuarioPaginas) {
		this.usuarioPaginas = usuarioPaginas;
	}

	public UsuarioPagina addUsuarioPagina(UsuarioPagina usuarioPagina) {
		getUsuarioPaginas().add(usuarioPagina);
		usuarioPagina.setPagina(this);

		return usuarioPagina;
	}

	public UsuarioPagina removeUsuarioPagina(UsuarioPagina usuarioPagina) {
		getUsuarioPaginas().remove(usuarioPagina);
		usuarioPagina.setPagina(null);

		return usuarioPagina;
	}

}