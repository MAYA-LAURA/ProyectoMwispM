package com.mx.mwisp.mwsipfinal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mx.mwisp.mwsipfinal.dao.DireccionJpaRepository;
import com.mx.mwisp.mwsipfinal.entity.Direccion;
import com.mx.mwisp.mwsipfinal.service.DireccionService;

@Service("direccionServiceImpl")
public class DireccionServiceImpl implements DireccionService{
	@Autowired
	@Qualifier("direccionJpaRepository")
	private DireccionJpaRepository direccionJpaRepository;

	@Override
	public Direccion addDireccion(Direccion direccion) {
		// TODO Auto-generated method stub
		return direccionJpaRepository.save(direccion);
	}
	
	
	
	
}
