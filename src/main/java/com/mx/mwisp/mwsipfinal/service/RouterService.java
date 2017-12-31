package com.mx.mwisp.mwsipfinal.service;

import java.util.List;

import com.mx.mwisp.mwsipfinal.entity.Router;

public interface RouterService {
	
	public List<Router> routerList();
	public Router agregarRouter(Router router);
	public int eliminarRouter(int id);
	public Router actualizarRouter(int id,Router router);
	public Router buscarRouterPorId(int id);
}
