package com.mx.mwisp.mwsipfinal.converter.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mx.mwisp.mwsipfinal.converterInterface.ConverterRouterInterface;
import com.mx.mwisp.mwsipfinal.entity.Router;
import com.mx.mwisp.mwsipfinal.model.RouterModel;

@Component("boRouter")
@Scope("prototype")
public class RouterConverter implements ConverterRouterInterface {

	@Override
	public RouterModel entityRouterToDtoRouter(Router entityRouter) {
		RouterModel routerModel=new RouterModel();
		routerModel.setIdRouter(entityRouter.getId());
		routerModel.setNombreRouter(entityRouter.getNombre());
		routerModel.setIpODnsRouter(entityRouter.getIpDns());
		routerModel.setUserRouter(entityRouter.getNombreUser());
		routerModel.setPassRouter(entityRouter.getLlave());
		routerModel.setUbicacionRouter(entityRouter.getUbicacion());
		return routerModel;
	}

	@Override
	public List<RouterModel> listEntityRouterToListDtoRouter(List<Router> listEntityRouter) {
		List<RouterModel> listRouterModel=null;
		if(listEntityRouter!=null) {
			listRouterModel=new ArrayList<RouterModel>();
			for(Router entityRouter: listEntityRouter) {
				listRouterModel.add(this.entityRouterToDtoRouter(entityRouter));
			}
		}
		return listRouterModel;
	}

	@Override
	public Router DtoRouterToEntityRouter(RouterModel dtoRouter) {
		Router entityRouter= new Router();
		entityRouter.setId(dtoRouter.getIdRouter());
		entityRouter.setNombre(dtoRouter.getNombreRouter());
		entityRouter.setIpDns(dtoRouter.getIpODnsRouter());
		entityRouter.setNombreUser(dtoRouter.getUserRouter());
		entityRouter.setLlave(dtoRouter.getPassRouter());
		entityRouter.setUbicacion(dtoRouter.getUbicacionRouter());
		return entityRouter;
	}

	@Override
	public List<Router> listDtoRouterTolistEntityRouter(List<RouterModel> listDtoRouter) {
		List<Router> listEntityRouter =null;
		if(listDtoRouter!=null) {
			listEntityRouter=new ArrayList<Router>();
			for(RouterModel dtoRouter:listDtoRouter) {
				listEntityRouter.add(this.DtoRouterToEntityRouter(dtoRouter));
			}
		}
		return listEntityRouter;
	}

}
