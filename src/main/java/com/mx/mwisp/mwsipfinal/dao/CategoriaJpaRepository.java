package com.mx.mwisp.mwsipfinal.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.mwisp.mwsipfinal.entity.Categoria;

@Repository("categoriaJpaRepository")
public interface CategoriaJpaRepository extends JpaRepository<Categoria, Serializable> {
	public abstract Categoria findByNombreCategoria(String nombreCategoria);

}
