package com.mx.mwisp.mwsipfinal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mx.mwisp.mwsipfinal.dao.DetallesVentasJpa;
import com.mx.mwisp.mwsipfinal.entity.DetalleVenta;

@Service("detallesVentasServiceImpl")
public class DetallesVentasServiceImpl implements DetallesVetasService  {
	@Autowired
	@Qualifier("detallesVentasJpa")
	DetallesVentasJpa detallesVentasJpa;

	@Override
	public DetalleVenta addDetalleVentas(DetalleVenta detalleVentas) {
		// TODO Auto-generated method stub
		return detallesVentasJpa.save(detalleVentas);
	}

}
