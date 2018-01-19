package com.mx.mwisp.mwsipfinal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mx.mwisp.mwsipfinal.dao.VentasJpaRepository;
import com.mx.mwisp.mwsipfinal.entity.Ventas;
import com.mx.mwisp.mwsipfinal.service.VentasService;

@Service("ventasServiceImpl")
public class VentasServiceImpl implements VentasService {

	@Autowired
	@Qualifier("ventasJpaRepository")
	private VentasJpaRepository ventasJpaRepository;
	
	@Override
	public Ventas addVentas(Ventas ventas) {
		// TODO Auto-generated method stub
		return ventasJpaRepository.save(ventas);
	}

	@Override
	public List<Ventas> listarVentas() {
		// TODO Auto-generated method stub
		return ventasJpaRepository.findAll();
	}
	

}
