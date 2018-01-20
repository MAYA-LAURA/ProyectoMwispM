package com.mx.mwisp.mwsipfinal.service;

import java.util.List;

import com.mx.mwisp.mwsipfinal.model.RouterModel;

public interface RouterService {
	
	public List<RouterModel> routerList();
	public RouterModel agregarRouter(RouterModel routerModel);
	public int eliminarRouter(int id);
	public RouterModel actualizarRouter(int id,RouterModel router);
	public RouterModel buscarRouterPorId(int id);
}
