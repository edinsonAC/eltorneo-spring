package com.meidey.springtorneobackend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.meidey.springtorneobackend.dao.IUsuarioDao;
import com.meidey.springtorneobackend.modelo.Usuario;
@Service
public class UsuarioServiceImpl implements IUsuarioService{

	@Autowired
	private IUsuarioDao usuarioDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Usuario> listarUsuarios() {
		return usuarioDao.listarUsuarios();
	}

	@Override
	public Usuario registrarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return usuarioDao.registrarUsuario(usuario);
	}
	

}
