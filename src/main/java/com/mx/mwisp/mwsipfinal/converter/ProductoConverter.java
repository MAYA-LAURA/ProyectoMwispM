package com.mx.mwisp.mwsipfinal.converter;

import org.springframework.stereotype.Component;

import com.mx.mwisp.mwsipfinal.entity.Productos;
import com.mx.mwisp.mwsipfinal.model.ProductoModel;

@Component("productoConverter")
public class ProductoConverter {
	
	//transformar de entity a model
	public ProductoModel entityModel(Productos producto) {
		ProductoModel productoModel= new ProductoModel();
		productoModel.setNombreProducto(producto.getNombreProducto());
		productoModel.setDescripcion(producto.getDescripcion());
		productoModel.setPrecio(producto.getPrecio());
		productoModel.setTiempoGarantia(producto.getTiempoGarantia());
		productoModel.setCategoria(producto.getCategoria());
		return productoModel;
		
	}
	
	
	
	//transformar de un model a entity
	public Productos modelEntity(ProductoModel productoModel) {
		Productos producto=new Productos();
		producto.setNombreProducto(productoModel.getNombreProducto());
		producto.setDescripcion(productoModel.getDescripcion());
		producto.setPrecio(productoModel.getPrecio());
		producto.setTiempoGarantia(producto.getTiempoGarantia());
		producto.setCategoria(productoModel.getCategoria());
		
		return producto;
		
	}
	
	
	

}
