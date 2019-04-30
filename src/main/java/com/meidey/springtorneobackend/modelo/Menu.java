package com.meidey.springtorneobackend.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the menu database table.
 * 
 */
@Entity
@NamedQuery(name="Menu.findAll", query="SELECT m FROM Menu m")
public class Menu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="menu_id")
	private int menuId;

	@Column(name="menu_icono")
	private String menuIcono;

	@Column(name="menu_titulo")
	private String menuTitulo;

	//bi-directional many-to-one association to Pagina
	@OneToMany(mappedBy="menu")
	private List<Pagina> paginas;

	public Menu() {
	}

	public int getMenuId() {
		return this.menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public String getMenuIcono() {
		return this.menuIcono;
	}

	public void setMenuIcono(String menuIcono) {
		this.menuIcono = menuIcono;
	}

	public String getMenuTitulo() {
		return this.menuTitulo;
	}

	public void setMenuTitulo(String menuTitulo) {
		this.menuTitulo = menuTitulo;
	}

	public List<Pagina> getPaginas() {
		return this.paginas;
	}

	public void setPaginas(List<Pagina> paginas) {
		this.paginas = paginas;
	}

	public Pagina addPagina(Pagina pagina) {
		getPaginas().add(pagina);
		pagina.setMenu(this);

		return pagina;
	}

	public Pagina removePagina(Pagina pagina) {
		getPaginas().remove(pagina);
		pagina.setMenu(null);

		return pagina;
	}

}