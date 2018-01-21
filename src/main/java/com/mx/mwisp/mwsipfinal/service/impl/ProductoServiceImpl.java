package com.mx.mwisp.mwsipfinal.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mx.mwisp.mwsipfinal.converter.impl.ProductoConverter;
import com.mx.mwisp.mwsipfinal.dao.ProductoJpaRepository;
import com.mx.mwisp.mwsipfinal.entity.Categoria;
import com.mx.mwisp.mwsipfinal.entity.Marca;
import com.mx.mwisp.mwsipfinal.entity.Productos;
import com.mx.mwisp.mwsipfinal.model.ProductoModel;
import com.mx.mwisp.mwsipfinal.service.CategoriaService;
import com.mx.mwisp.mwsipfinal.service.MarcaService;
import com.mx.mwisp.mwsipfinal.service.ProductoService;

@Service("productoServiceImpl")
public class ProductoServiceImpl implements ProductoService {

	private static final Log log = LogFactory.getLog(ProductoServiceImpl.class);

	@Autowired
	@Qualifier("productoJpaRepository")
	private ProductoJpaRepository productoJpaRepository;
	@Autowired
	@Qualifier("productoConverter")
	private ProductoConverter productoConverter;
	@Autowired
	@Qualifier("marcaServiceImpl")
	private MarcaService marcaService;
	@Autowired
	@Qualifier("categoriaServiceImpl")
	private CategoriaService categoriaServiceImpl;

	@Override
	public List<ProductoModel> listarProductos() {
		List<Productos> productos = productoJpaRepository.findAll();
		List<ProductoModel> productoModels = new ArrayList<ProductoModel>();
		for (Productos producto : productos) {
			productoModels.add(productoConverter.entityModel(producto));
		}
		log.info("lamando:" + "ListarProductos");
		return productoModels;
	}

	@Override
	public ProductoModel addProducto(ProductoModel productoModel) {
		// TODO Auto-generated method stub

		log.info(productoModel.getCategoria().getNombreCategoria());
		log.info(productoModel.getMarca().getMarca());
		Categoria categoria = categoriaServiceImpl
				.encontrarCategoria(productoModel.getCategoria().getNombreCategoria());
		Marca marca = marcaService.encontrarMarca(productoModel.getMarca().getMarca());
		log.info(marca);
		Productos productos = productoConverter.modelEntity(productoModel);
		productos.setCategoria(categoria);
		productos.setMarca(marca);

		return productoConverter.entityModel(productoJpaRepository.save(productos));
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

	@Override
	public Productos encontraPorModelo(String modelo) {
		// TODO Auto-generated method stub
		return productoJpaRepository.findByModelo(modelo);
	}

	@Override
	public List<ProductoModel> encontrarPorMarca(Marca marca) {
		// TODO Auto-generated method stub
		List<Productos> productos=productoJpaRepository.findByMarca(marca);
		List<ProductoModel> productoModels = new ArrayList<ProductoModel>();
		for (Productos producto : productos) {
			productoModels.add(productoConverter.entityModel(producto));
		}
		
		return productoModels;
	}

}
