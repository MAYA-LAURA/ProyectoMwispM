package com.mx.mwisp.mwsipfinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mx.mwisp.mwsipfinal.model.ClienteModelo;
import com.mx.mwisp.mwsipfinal.model.helper.FormRouter;
import com.mx.mwisp.mwsipfinal.service.ClientesService;
import com.mx.mwisp.mwsipfinal.service.RouterService;

@Controller
@RequestMapping("/AdminControl")
public class ControllerAdmin {
	@Autowired
	@Qualifier("routerServiceImpl")
	RouterService routerServiceImpl;
	@Autowired
	@Qualifier("clienteServiceImpl")
	ClientesService clienteServiceImpl;
	
	FormRouter formRouter=new FormRouter();
	
	@GetMapping("/routers")
	public ModelAndView vistaRouters() {
		ModelAndView mav=new ModelAndView("/admin/ListaRouter");
		formRouter.setListRouter(routerServiceImpl.routerList());
		mav.addObject("listaRouter", formRouter.getListRouter());
		return mav;
	}
	
	@GetMapping("/dashboard")
	public ModelAndView dashboard() {
		ModelAndView mav=new ModelAndView("/admin/index");
		return mav;
	}
	
	@GetMapping("/nuevoRouter")
	public ModelAndView agregarRouter() {
		ModelAndView mav=new ModelAndView("/admin/addRouter");
		return mav;
	}
	
	@GetMapping("/clientes")
	public ModelAndView vistaClientes() {
		ModelAndView mav=new ModelAndView("/admin/ListaClientes");
		mav.addObject("cliente", new ClienteModelo());
		mav.addObject("listaNombre", routerServiceImpl.routerList());
		mav.addObject("listaCliente", clienteServiceImpl.listaClientes());
		return mav;
	}
	@PostMapping("/prueba")
	public String prueba(@ModelAttribute("cliente") ClienteModelo clienteModelo) {
		clienteServiceImpl.prueba(clienteModelo);
		return "redirect:/AdminControl/clientes";
	}
	@GetMapping("/encabezado")
	public ModelAndView encabezado() {
		ModelAndView mav=new ModelAndView("/admin/encabezado");
		return mav;
	}
	
}
