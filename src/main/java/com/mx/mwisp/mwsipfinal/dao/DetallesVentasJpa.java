package com.mx.mwisp.mwsipfinal.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.mwisp.mwsipfinal.entity.DetalleVenta;
import com.mx.mwisp.mwsipfinal.entity.Ventas;

@Repository("detallesVentasJpa")
public interface DetallesVentasJpa extends JpaRepository<DetalleVenta, Serializable> {
	
	public abstract List<DetalleVenta> findByIdVenta(Ventas venta);

}
