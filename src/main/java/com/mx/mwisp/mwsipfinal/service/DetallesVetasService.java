package com.mx.mwisp.mwsipfinal.service;

import java.util.List;

import com.mx.mwisp.mwsipfinal.entity.DetalleVenta;
import com.mx.mwisp.mwsipfinal.entity.Ventas;

public interface DetallesVetasService {
	public abstract DetalleVenta addDetalleVentas(DetalleVenta detalleVentas);
	public abstract List<DetalleVenta> encontrarPorIdVenta (Ventas venta);
}
