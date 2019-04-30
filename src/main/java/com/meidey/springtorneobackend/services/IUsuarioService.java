package com.meidey.springtorneobackend.services;

import java.util.List;
import com.meidey.springtorneobackend.modelo.Usuario;

public interface IUsuarioService {

	public List<Usuario> listarUsuarios();

	public Usuario registrarUsuario(Usuario usuario);
}
