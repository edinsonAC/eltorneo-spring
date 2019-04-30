package com.meidey.springtorneobackend.dao;

import java.util.List;

import com.meidey.springtorneobackend.modelo.Usuario;

public interface IUsuarioDao {

	public List<Usuario> listarUsuarios();

	public Usuario registrarUsuario(Usuario usuario);
}
