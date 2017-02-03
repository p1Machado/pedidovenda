package com.algaworks.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.algaworks.model.Categoria;
import org.algaworks.model.Produto;

@Named
@ViewScoped
public class ProdutoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	EntityManager entityManager;

	private Produto produto;
	private List<Produto> produtos = new ArrayList<>();

	private List<Categoria> categorias = new ArrayList<>();

	public ProdutoBean() {
		produto = new Produto();

	}

	public void inicializar() {
		categorias = listarCategorias();
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void salvar() {
		EntityTransaction transaction = entityManager.getTransaction();

		transaction.begin();

		transaction.commit();

		produtos.add(this.produto);

		produto = new Produto();
	}
	/*
	 * public double getPrecoProduto() { return
	 * calculadora.calcular(this.valorUnitario, this.quantidadeEstoque); }
	 */

	public List<Categoria> listarCategorias() {
		EntityTransaction transaction = entityManager.getTransaction();

		transaction.begin();

		categorias = entityManager.createQuery("from Categoria", Categoria.class).getResultList();

		transaction.commit();

		return categorias;
	}
}
