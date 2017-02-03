package com.algaworks.pedidovenda.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.algaworks.pedidovenda.model.Categoria;

public class CategoriaRepository implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	EntityManager entityManager;

	public List<Categoria> buscarCategorias() {
		return entityManager.createQuery("from Categoria", Categoria.class).getResultList();
	}
}
