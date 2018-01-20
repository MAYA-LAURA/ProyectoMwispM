package com.mx.mwisp.mwsipfinal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mx.mwisp.mwsipfinal.converterInterface.ConverterRouterInterface;
import com.mx.mwisp.mwsipfinal.dao.RouterJpaRepository;
import com.mx.mwisp.mwsipfinal.entity.Router;
import com.mx.mwisp.mwsipfinal.model.RouterModel;
import com.mx.mwisp.mwsipfinal.service.RouterService;

@Service("routerServiceImpl")
public class RouterServiceImpl implements RouterService {
	
	@Autowired
	@Qualifier("routerJpaRepository")
	private RouterJpaRepository routerJpaRepository;
	
	@Autowired
	ConverterRouterInterface convRouter;
	
	@Override
	public List<RouterModel> routerList() {
		return convRouter.listEntityRouterToListDtoRouter(routerJpaRepository.findAll());
	}

	@Override
	public RouterModel agregarRouter(RouterModel modelRouter) {
		Router router=convRouter.DtoRouterToEntityRouter(modelRouter);
		return convRouter.entityRouterToDtoRouter(routerJpaRepository.save(router));
	}

	@Override
	public int eliminarRouter(int id) {
		routerJpaRepository.delete(id);
		return 0;
	}

	@Override
	public RouterModel actualizarRouter(int id, RouterModel modelRouter) {
		// TODO Auto-generated method stub
		Router router=convRouter.DtoRouterToEntityRouter(modelRouter);
		return convRouter.entityRouterToDtoRouter(routerJpaRepository.save(router));
	}

	/*@Override
	public Router buscarRouterPorId(int id) {
		// TODO Auto-generated method stub
		return routerJpaRepository.findOne(id);
	}*/

	/*@Override
	public RouterModel actualizarRouter(int id, RouterModel router) {
		// TODO Auto-generated method stub
		return null;
	}*/

	@Override
	public RouterModel buscarRouterPorId(int id) {
		return convRouter.entityRouterToDtoRouter(routerJpaRepository.findOne(id));
	}

}
