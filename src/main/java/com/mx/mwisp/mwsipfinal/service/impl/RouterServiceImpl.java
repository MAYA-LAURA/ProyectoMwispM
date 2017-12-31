package com.mx.mwisp.mwsipfinal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mx.mwisp.mwsipfinal.dao.RouterJpaRepository;
import com.mx.mwisp.mwsipfinal.entity.Router;
import com.mx.mwisp.mwsipfinal.service.RouterService;

@Service("routerServiceImpl")
public class RouterServiceImpl implements RouterService {
	
	@Autowired
	@Qualifier("routerJpaRepository")
	private RouterJpaRepository routerJpaRepository;
	
	@Override
	public List<Router> routerList() {
		return routerJpaRepository.findAll();
	}

	@Override
	public Router agregarRouter(Router router) {
		
		return routerJpaRepository.save(router);
	}

	@Override
	public int eliminarRouter(int id) {
		routerJpaRepository.delete(id);
		return 0;
	}

	@Override
	public Router actualizarRouter(int id, Router router) {
		// TODO Auto-generated method stub
		return routerJpaRepository.save(router);
	}

	@Override
	public Router buscarRouterPorId(int id) {
		// TODO Auto-generated method stub
		return routerJpaRepository.findOne(id);
	}

}
