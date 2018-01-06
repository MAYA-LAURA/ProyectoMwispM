package com.mx.mwisp.mwsipfinal.service;

import java.util.List;

import com.mx.mwisp.mwsipfinal.entity.Marca;

public interface MarcaService {
	public abstract List<Marca> listaMarcas();
	public abstract Marca encontrarMarca(String marca);

}
