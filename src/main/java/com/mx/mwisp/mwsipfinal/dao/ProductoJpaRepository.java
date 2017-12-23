package com.mx.mwisp.mwsipfinal.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.mwisp.mwsipfinal.entity.Productos;


@Repository("productoJpaRepository")
public interface ProductoJpaRepository extends JpaRepository<Productos, Serializable>{

	public abstract Productos findByPrecio(float precio);

}
