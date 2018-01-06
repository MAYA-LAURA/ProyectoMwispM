package com.mx.mwisp.mwsipfinal.service;

import java.util.List;

import com.mx.mwisp.mwsipfinal.entity.Categoria;

public interface CategoriaService {
	public abstract List<Categoria> listarCategorias();
	public abstract Categoria encontrarCategoria(String categoria);

}
