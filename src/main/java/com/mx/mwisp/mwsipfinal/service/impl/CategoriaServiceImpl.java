package com.mx.mwisp.mwsipfinal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mx.mwisp.mwsipfinal.dao.CategoriaJpaRepository;
import com.mx.mwisp.mwsipfinal.entity.Categoria;
import com.mx.mwisp.mwsipfinal.service.CategoriaService;

@Service("categoriaServiceImpl")
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	@Qualifier("categoriaJpaRepository")
	CategoriaJpaRepository categiriaJpaRepository;
	
	@Override
	public List<Categoria> listarCategorias() {
		// TODO Auto-generated method stub
		return categiriaJpaRepository.findAll();
	}

}
