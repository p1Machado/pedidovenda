package com.algaworks.pedidovenda.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.algaworks.pedidovenda.model.Produto;

public class ProdutoRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	EntityManager entityManager;

	public List<Produto> buscarTudo() {
		EntityTransaction transaction = entityManager.getTransaction();

		transaction.begin();

		List<Produto> produtos = entityManager.createQuery("from Produto", Produto.class).getResultList();

		transaction.commit();

		return produtos;
	}
}
