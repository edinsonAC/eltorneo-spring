package com.meidey.springtorneobackend.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the horario_partido database table.
 * 
 */
@Entity
@Table(name="horario_partido")
@NamedQuery(name="HorarioPartido.findAll", query="SELECT h FROM HorarioPartido h")
public class HorarioPartido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="hopa_id")
	private int hopaId;

	@Column(name="hopa_horafinal")
	private int hopaHorafinal;

	@Column(name="hopa_horainicial")
	private int hopaHorainicial;

	//bi-directional many-to-one association to Partido
	@OneToMany(mappedBy="horarioPartido")
	private List<Partido> partidos;

	public HorarioPartido() {
	}

	public int getHopaId() {
		return this.hopaId;
	}

	public void setHopaId(int hopaId) {
		this.hopaId = hopaId;
	}

	public int getHopaHorafinal() {
		return this.hopaHorafinal;
	}

	public void setHopaHorafinal(int hopaHorafinal) {
		this.hopaHorafinal = hopaHorafinal;
	}

	public int getHopaHorainicial() {
		return this.hopaHorainicial;
	}

	public void setHopaHorainicial(int hopaHorainicial) {
		this.hopaHorainicial = hopaHorainicial;
	}

	public List<Partido> getPartidos() {
		return this.partidos;
	}

	public void setPartidos(List<Partido> partidos) {
		this.partidos = partidos;
	}

	public Partido addPartido(Partido partido) {
		getPartidos().add(partido);
		partido.setHorarioPartido(this);

		return partido;
	}

	public Partido removePartido(Partido partido) {
		getPartidos().remove(partido);
		partido.setHorarioPartido(null);

		return partido;
	}

}