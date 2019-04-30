package com.meidey.springtorneobackend.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.meidey.springtorneobackend.modelo.Usuario;

@Repository
public class UsuarioDaoImpl implements IUsuarioDao {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<Usuario> listarUsuarios() {
		return em.createQuery("from Usuario").getResultList();
	}

	@Override
	@Transactional
	public Usuario registrarUsuario(Usuario usuario) {
		em.persist(usuario);
		return usuario;
	}

}
