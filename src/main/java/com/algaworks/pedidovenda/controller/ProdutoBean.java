package com.algaworks.pedidovenda.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.algaworks.pedidovenda.model.Categoria;
import com.algaworks.pedidovenda.model.Produto;
import com.algaworks.pedidovenda.repository.CategoriaRepository;
import com.algaworks.pedidovenda.repository.ProdutoRepository;

@Named
@ViewScoped
public class ProdutoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	EntityManager entityManager;

	@Inject
	private ProdutoRepository produtoRepository;

	private Produto produto;

	private List<Produto> produtos = new ArrayList<>();

	@Inject
	private CategoriaRepository categoriaRepository;

	private Categoria categoria;

	private List<Categoria> categorias = new ArrayList<>();

	public ProdutoBean() {
		produto = new Produto();
	}

	public void inicializar() {
		produtos = produtoRepository.buscarTudo();
		categorias = categoriaRepository.buscarTudo();
	}

	public Produto getProduto() {
		return produto;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public void teste() {
		System.out.println("\n" + this.categoria.toString());
	}

	public void salvar() {
		produto.setCategoria(categoria);

		EntityTransaction transaction = entityManager.getTransaction();

		transaction.begin();

		entityManager.persist(produto);

		transaction.commit();

		produtos.add(produto);

		produto = new Produto();
	}
}
