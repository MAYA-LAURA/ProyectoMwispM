package com.mx.mwisp.mwsipfinal.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mx.mwisp.mwsipfinal.dao.ProductoJpaRepository;
import com.mx.mwisp.mwsipfinal.entity.Categoria;
import com.mx.mwisp.mwsipfinal.entity.Productos;
import com.mx.mwisp.mwsipfinal.service.ProductoService;


@Service("productoServiceImpl")
public class ProductoServiceImpl implements ProductoService{
   
	private static final Log log=LogFactory.getLog(ProductoServiceImpl.class);
	
	@Autowired
	@Qualifier("productoJpaRepository")
	private ProductoJpaRepository productoJpaRepository;
	
	@Override
	public List<Productos> listarProductos() {
		log.info("lamando:"+"ListarProductos");
		return productoJpaRepository.findAll();
	}

	@Override
	public Productos addProducto(Productos producto) {
		// TODO Auto-generated method stub
		Categoria categoria=new Categoria("Redes", "productos redes");
		categoria.setIdCategoria(1);		
		producto.setCategoria(categoria);
		
		return productoJpaRepository.save(producto);
	}

	@Override
	public int eliminarPorId(int id) {
		productoJpaRepository.delete(id);
		return 0;
	}

	@Override
	public Productos actualizarProducto(Productos producto) {
		
		return productoJpaRepository.save(producto);
	}

	@Override
	public Productos encontrarPorId(int id) {
		
		return productoJpaRepository.findOne(id);
	}

}
