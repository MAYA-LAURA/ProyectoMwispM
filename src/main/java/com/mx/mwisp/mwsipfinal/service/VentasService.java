package com.mx.mwisp.mwsipfinal.service;

import java.util.List;

import com.mx.mwisp.mwsipfinal.entity.Ventas;

public interface VentasService {
	public abstract Ventas addVentas(Ventas ventas);
	public abstract List<Ventas> listarVentas();

}
