package com.mx.mwisp.mwsipfinal.converter;

import java.io.IOException;

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
		productoModel.setMarca(producto.getMarca());
		productoModel.setDescripcion(producto.getDescripcion());
		productoModel.setPrecio(producto.getPrecio());
		productoModel.setTiempoGarantia(producto.getTiempoGarantia());
		productoModel.setCategoria(producto.getCategoria());
		productoModel.setMarca(producto.getMarca());
		
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
		if(productoModel.getFileData()!=null) {
			byte[] imagen=null;
			try {
				imagen=productoModel.getFileData().getBytes();
			}
			catch(IOException e) {
			}
			if(imagen!=null&&imagen.length>0) {
				producto.setFileData(imagen);
			}
		}
		producto.setCategoria(productoModel.getCategoria());
		producto.setMarca(productoModel.getMarca());
		
		return producto;
		
	}
	
	
	

}
