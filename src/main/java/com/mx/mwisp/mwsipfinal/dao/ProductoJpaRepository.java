package com.mx.mwisp.mwsipfinal.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.mwisp.mwsipfinal.entity.Marca;
import com.mx.mwisp.mwsipfinal.entity.Productos;


@Repository("productoJpaRepository")
public interface ProductoJpaRepository extends JpaRepository<Productos, Serializable>{

	public abstract Productos findByPrecio(double precio);
	public abstract Productos findByModelo(String modelo);
	public abstract List<Productos> findByMarca(Marca marca); 

}
