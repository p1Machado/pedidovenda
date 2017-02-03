package com.algaworks.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.persistence.Id;

import org.algaworks.model.Categoria;

@Named
public class CategoriaBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;
	private Categoria categoria;
	private List<Categoria> categorias = new ArrayList<>();

	@PostConstruct
	public void init() {

	}

	public CategoriaBean() {
		categoria = new Categoria();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}
}
