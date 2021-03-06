package com.algaworks.pedidovenda.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.algaworks.pedidovenda.model.Categoria;

public class CategoriaRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	EntityManager entityManager;

	public Categoria buscarPorId(Long id) {
		return entityManager.find(Categoria.class, id);
	}

	public List<Categoria> buscarTudo() {
		EntityTransaction transaction = entityManager.getTransaction();

		transaction.begin();

		List<Categoria> categorias = entityManager.createQuery("from Categoria", Categoria.class).getResultList();

		transaction.commit();

		return categorias;
	}
}
