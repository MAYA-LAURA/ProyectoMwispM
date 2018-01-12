package com.mx.mwisp.mwsipfinal.service;

import java.util.List;

import com.mx.mwisp.mwsipfinal.entity.Productos;
import com.mx.mwisp.mwsipfinal.model.ProductoModel;

public interface ProductoService {
	public abstract List<ProductoModel> listarProductos();
	public abstract ProductoModel addProducto(ProductoModel productoModel);
	public abstract int eliminarPorId(int id);
	public abstract Productos actualizarProducto(Productos producto);
	public abstract Productos encontrarPorId(int id);
	public abstract Productos encontraPorModelo(String modelo);
	
}
