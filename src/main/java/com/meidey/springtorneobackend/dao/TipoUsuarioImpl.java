package com.meidey.springtorneobackend.dao;

import java.util.List;

import javax.persistence.PersistenceContext;

import com.meidey.springtorneobackend.modelo.TipoUsuario;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
public class TipoUsuarioImpl implements ITipoUsuarioDao {
	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)

	@Override
	public List<TipoUsuario> listarTipoUsuario() {
		return em.createQuery("from TipoUsuario").getResultList();
	}

}