package com.mx.mwisp.mwsipfinal.converter.impl;



import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Component;

import com.mx.mwisp.mwsipfinal.entity.Productos;
import com.mx.mwisp.mwsipfinal.model.ProductoModel;



@Component("productoConverter")
public class ProductoConverter {
	
	//transformar de entity a model
	public ProductoModel entityModel(Productos producto) {
		ProductoModel productoModel= new ProductoModel();
		productoModel.setIdProdcutos(producto.getIdProdcutos());
		productoModel.setNombreProducto(producto.getNombreProducto());
		productoModel.setModelo(producto.getModelo());
		productoModel.setDescripcion(producto.getDescripcion());
		productoModel.setPrecio(producto.getPrecio());
		productoModel.setTiempoGarantia(producto.getTiempoGarantia());
		productoModel.setPdf(producto.getPdf());
		productoModel.setImagen1(producto.getImagen1());
		productoModel.setImagen2(producto.getImagen2());
		productoModel.setCategoria(producto.getCategoria());
		productoModel.setMarca(producto.getMarca());
		//pasa el valor de precio a moneda nacional mexicana
		BigDecimal bd=new BigDecimal(producto.getPrecio()*19.1791);
		bd=bd.setScale(2, RoundingMode.HALF_UP);
		productoModel.setPrecioMxm(bd.doubleValue());
		return productoModel;
		
	}
	
	
	
	//transformar de un model a entity
	public Productos modelEntity(ProductoModel productoModel) {
		Productos producto=new Productos();
		producto.setIdProdcutos(productoModel.getIdProdcutos());
		producto.setNombreProducto(productoModel.getNombreProducto());
		producto.setModelo(productoModel.getModelo());
		producto.setDescripcion(productoModel.getDescripcion());
		producto.setPrecio(productoModel.getPrecio());
		producto.setTiempoGarantia(productoModel.getTiempoGarantia());
		producto.setPdf(productoModel.getPdf());
		producto.setImagen1(productoModel.getImagen1());
		producto.setImagen2(productoModel.getImagen2());
		producto.setCategoria(productoModel.getCategoria());
		producto.setMarca(productoModel.getMarca());
		
		return producto;
		
	}
	
	
	

}
