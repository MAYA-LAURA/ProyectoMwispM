package com.mx.mwisp.mwsipfinal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mx.mwisp.mwsipfinal.dao.MarcaJpaRepository;
import com.mx.mwisp.mwsipfinal.entity.Marca;
import com.mx.mwisp.mwsipfinal.service.MarcaService;

@Service("marcaServiceImpl")
public class MarcaServiceImpl implements MarcaService {
	@Autowired
	@Qualifier("marcaJpaRepository")
	private MarcaJpaRepository marcaJpaRepository;

	@Override
	public List<Marca> listaMarcas() {
		// TODO Auto-generated method stub
		return marcaJpaRepository.findAll();
	}

	@Override
	public Marca encontrarMarca(String marca) {
		// TODO Auto-generated method stub
		return marcaJpaRepository.findByMarca(marca);
	}

}
