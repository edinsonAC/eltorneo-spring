package com.meidey.springtorneobackend.modelo;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.sql.Timestamp;
import java.util.List;

/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "usua_id")
	private int usuaId;

	@Column(name = "usua_clave")
	private String usuaClave;

	@Column(name = "usua_correo")
	private String usuaCorreo;

	@Column(name = "usua_estado")
	private byte usuaEstado;

	@Column(name = "usua_fecharegistro")
	private Timestamp usuaFecharegistro;

	@Column(name = "usua_grupo")
	private String usuaGrupo;

	@Column(name = "usua_imgperfil")
	private String usuaImgperfil;

	@Column(name = "usua_usuario")
	private String usuaUsuario;

	// bi-directional many-to-one association to Arbitro
	@JsonIgnore
	@OneToMany(mappedBy = "usuario")
	private List<Arbitro> arbitros;

	// bi-directional many-to-one association to Jugador
	@JsonIgnore
	@OneToMany(mappedBy = "usuario")
	private List<Jugador> jugadors;

	// bi-directional many-to-one association to Tecnico
	@JsonIgnore
	@OneToMany(mappedBy = "usuario")
	private List<Tecnico> tecnicos;

	// bi-directional many-to-one association to TipoUsuario
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "tius_id")
	private TipoUsuario tipoUsuario;

	// bi-directional many-to-one association to UsuarioPagina
	@JsonIgnore
	@OneToMany(mappedBy = "usuario")
	private List<UsuarioPagina> usuarioPaginas;

	public Usuario() {
	}

	public int getUsuaId() {
		return this.usuaId;
	}

	public void setUsuaId(int usuaId) {
		this.usuaId = usuaId;
	}

	public String getUsuaClave() {
		return this.usuaClave;
	}

	public void setUsuaClave(String usuaClave) {
		this.usuaClave = usuaClave;
	}

	public String getUsuaCorreo() {
		return this.usuaCorreo;
	}

	public void setUsuaCorreo(String usuaCorreo) {
		this.usuaCorreo = usuaCorreo;
	}

	public byte getUsuaEstado() {
		return this.usuaEstado;
	}

	public void setUsuaEstado(byte usuaEstado) {
		this.usuaEstado = usuaEstado;
	}

	public Timestamp getUsuaFecharegistro() {
		return this.usuaFecharegistro;
	}

	public void setUsuaFecharegistro(Timestamp usuaFecharegistro) {
		this.usuaFecharegistro = usuaFecharegistro;
	}

	public String getUsuaGrupo() {
		return this.usuaGrupo;
	}

	public void setUsuaGrupo(String usuaGrupo) {
		this.usuaGrupo = usuaGrupo;
	}

	public String getUsuaImgperfil() {
		return this.usuaImgperfil;
	}

	public void setUsuaImgperfil(String usuaImgperfil) {
		this.usuaImgperfil = usuaImgperfil;
	}

	public String getUsuaUsuario() {
		return this.usuaUsuario;
	}

	public void setUsuaUsuario(String usuaUsuario) {
		this.usuaUsuario = usuaUsuario;
	}

	public List<Arbitro> getArbitros() {
		return this.arbitros;
	}

	public void setArbitros(List<Arbitro> arbitros) {
		this.arbitros = arbitros;
	}

	public Arbitro addArbitro(Arbitro arbitro) {
		getArbitros().add(arbitro);
		arbitro.setUsuario(this);

		return arbitro;
	}

	public Arbitro removeArbitro(Arbitro arbitro) {
		getArbitros().remove(arbitro);
		arbitro.setUsuario(null);

		return arbitro;
	}

	public List<Jugador> getJugadors() {
		return this.jugadors;
	}

	public void setJugadors(List<Jugador> jugadors) {
		this.jugadors = jugadors;
	}

	public Jugador addJugador(Jugador jugador) {
		getJugadors().add(jugador);
		jugador.setUsuario(this);

		return jugador;
	}

	public Jugador removeJugador(Jugador jugador) {
		getJugadors().remove(jugador);
		jugador.setUsuario(null);

		return jugador;
	}

	public List<Tecnico> getTecnicos() {
		return this.tecnicos;
	}

	public void setTecnicos(List<Tecnico> tecnicos) {
		this.tecnicos = tecnicos;
	}

	public Tecnico addTecnico(Tecnico tecnico) {
		getTecnicos().add(tecnico);
		tecnico.setUsuario(this);

		return tecnico;
	}

	public Tecnico removeTecnico(Tecnico tecnico) {
		getTecnicos().remove(tecnico);
		tecnico.setUsuario(null);

		return tecnico;
	}

	public TipoUsuario getTipoUsuario() {
		return this.tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public List<UsuarioPagina> getUsuarioPaginas() {
		return this.usuarioPaginas;
	}

	public void setUsuarioPaginas(List<UsuarioPagina> usuarioPaginas) {
		this.usuarioPaginas = usuarioPaginas;
	}

	public UsuarioPagina addUsuarioPagina(UsuarioPagina usuarioPagina) {
		getUsuarioPaginas().add(usuarioPagina);
		usuarioPagina.setUsuario(this);

		return usuarioPagina;
	}

	public UsuarioPagina removeUsuarioPagina(UsuarioPagina usuarioPagina) {
		getUsuarioPaginas().remove(usuarioPagina);
		usuarioPagina.setUsuario(null);

		return usuarioPagina;
	}

	public String toStringJson() {
		String dtoJsonString = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			dtoJsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
		} catch (Exception e) {
		}
		return dtoJsonString;
	}

}