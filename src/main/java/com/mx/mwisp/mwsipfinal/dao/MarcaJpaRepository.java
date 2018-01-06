package com.mx.mwisp.mwsipfinal.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.mwisp.mwsipfinal.entity.Marca;

@Repository("marcaJpaRepository")
public interface MarcaJpaRepository extends JpaRepository<Marca, Serializable>{

	public abstract Marca findByMarca(String marca);
	
}
