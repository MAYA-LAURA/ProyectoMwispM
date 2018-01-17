package com.mx.mwisp.mwsipfinal.utils;

import javax.servlet.http.HttpServletRequest;

import com.mx.mwisp.mwsipfinal.model.CarritoInfo;

public class Utils {
	public static CarritoInfo getCarroSession(HttpServletRequest request) {
		CarritoInfo carroInfo=(CarritoInfo)request.getSession().getAttribute("miCarro");
		if(carroInfo==null) {
			carroInfo=new CarritoInfo();
			request.getSession().setAttribute("miCarro", carroInfo);
		}
		
		return carroInfo;
	}
	
	//eliminar carrito de la sesion
	public static void removerCarroSesion(HttpServletRequest request)
	{
		request.getSession().removeAttribute("miCarro");
	}

}
