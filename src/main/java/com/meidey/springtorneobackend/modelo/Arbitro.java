package com.meidey.springtorneobackend.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the arbitro database table.
 * 
 */
@Entity
@NamedQuery(name="Arbitro.findAll", query="SELECT a FROM Arbitro a")
public class Arbitro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="arbi_id")
	private int arbiId;

	@Column(name="arbi_apellido")
	private String arbiApellido;

	@Column(name="arbi_celular")
	private String arbiCelular;

	@Column(name="arbi_direccion")
	private String arbiDireccion;

	@Column(name="arbi_documento")
	private String arbiDocumento;

	@Column(name="arbi_estado")
	private byte arbiEstado;

	@Column(name="arbi_fecharegistro")
	private Timestamp arbiFecharegistro;

	@Column(name="arbi_nombre")
	private String arbiNombre;

	@Column(name="arbi_telefono")
	private String arbiTelefono;

	private String arbitrocol;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="usua_id")
	private Usuario usuario;

	//bi-directional many-to-one association to PartidoArbitro
	@OneToMany(mappedBy="arbitro")
	private List<PartidoArbitro> partidoArbitros;

	public Arbitro() {
	}

	public int getArbiId() {
		return this.arbiId;
	}

	public void setArbiId(int arbiId) {
		this.arbiId = arbiId;
	}

	public String getArbiApellido() {
		return this.arbiApellido;
	}

	public void setArbiApellido(String arbiApellido) {
		this.arbiApellido = arbiApellido;
	}

	public String getArbiCelular() {
		return this.arbiCelular;
	}

	public void setArbiCelular(String arbiCelular) {
		this.arbiCelular = arbiCelular;
	}

	public String getArbiDireccion() {
		return this.arbiDireccion;
	}

	public void setArbiDireccion(String arbiDireccion) {
		this.arbiDireccion = arbiDireccion;
	}

	public String getArbiDocumento() {
		return this.arbiDocumento;
	}

	public void setArbiDocumento(String arbiDocumento) {
		this.arbiDocumento = arbiDocumento;
	}

	public byte getArbiEstado() {
		return this.arbiEstado;
	}

	public void setArbiEstado(byte arbiEstado) {
		this.arbiEstado = arbiEstado;
	}

	public Timestamp getArbiFecharegistro() {
		return this.arbiFecharegistro;
	}

	public void setArbiFecharegistro(Timestamp arbiFecharegistro) {
		this.arbiFecharegistro = arbiFecharegistro;
	}

	public String getArbiNombre() {
		return this.arbiNombre;
	}

	public void setArbiNombre(String arbiNombre) {
		this.arbiNombre = arbiNombre;
	}

	public String getArbiTelefono() {
		return this.arbiTelefono;
	}

	public void setArbiTelefono(String arbiTelefono) {
		this.arbiTelefono = arbiTelefono;
	}

	public String getArbitrocol() {
		return this.arbitrocol;
	}

	public void setArbitrocol(String arbitrocol) {
		this.arbitrocol = arbitrocol;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<PartidoArbitro> getPartidoArbitros() {
		return this.partidoArbitros;
	}

	public void setPartidoArbitros(List<PartidoArbitro> partidoArbitros) {
		this.partidoArbitros = partidoArbitros;
	}

	public PartidoArbitro addPartidoArbitro(PartidoArbitro partidoArbitro) {
		getPartidoArbitros().add(partidoArbitro);
		partidoArbitro.setArbitro(this);

		return partidoArbitro;
	}

	public PartidoArbitro removePartidoArbitro(PartidoArbitro partidoArbitro) {
		getPartidoArbitros().remove(partidoArbitro);
		partidoArbitro.setArbitro(null);

		return partidoArbitro;
	}

}