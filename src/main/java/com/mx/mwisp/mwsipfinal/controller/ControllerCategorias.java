package com.mx.mwisp.mwsipfinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mx.mwisp.mwsipfinal.entity.Marca;
import com.mx.mwisp.mwsipfinal.service.MarcaService;
import com.mx.mwisp.mwsipfinal.service.ProductoService;

@Controller
@RequestMapping("/ecommerce/categoria")
public class ControllerCategorias {
	@Autowired
	@Qualifier("marcaServiceImpl")
	private MarcaService marcaServiceImpl;
	@Autowired
	@Qualifier("productoServiceImpl")
	private ProductoService productoServiceImpl;
//	@Autowired
//	@Qualifier("productoConverter")
//	private ProductoConverter productoConverter;
	
	//este parte del codigo lista todos los productos de la categoria ubiquiti
	@GetMapping("/ubiquiti")
	public ModelAndView categoriaUbiquiti() {
		ModelAndView mav=new ModelAndView("/ecommerce/categoryUbiquiti");
		Marca marca=marcaServiceImpl.encontrarMarca("UBIQUITI NETWORKS");
		mav.addObject("listaUbiquiti", productoServiceImpl.encontrarPorMarca(marca));
		return mav;
	}
	@GetMapping("/mikrotik")
	public ModelAndView categoriaMikrotik() {
		ModelAndView mav=new ModelAndView("/ecommerce/categoryMikrotik");
		Marca marca=marcaServiceImpl.encontrarMarca("MIKROTIK");
		mav.addObject("listaUbiquiti", productoServiceImpl.encontrarPorMarca(marca));
		return mav;
	}
	@GetMapping("/Hikvision")
	public ModelAndView categoriaHikvision() {
		ModelAndView mav=new ModelAndView("/ecommerce/categoryHikvision");
		Marca marca=marcaServiceImpl.encontrarMarca("Hikvision");
		mav.addObject("listaUbiquiti", productoServiceImpl.encontrarPorMarca(marca));
		return mav;
	}

}
