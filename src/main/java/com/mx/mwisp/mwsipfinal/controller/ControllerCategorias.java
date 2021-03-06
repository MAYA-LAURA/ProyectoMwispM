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
	@GetMapping("/Engenius")
	public ModelAndView categoriaEngenius() {
		ModelAndView mav=new ModelAndView("/ecommerce/categoryEngenius");
		Marca marca=marcaServiceImpl.encontrarMarca("ENGENIUS");
		mav.addObject("listaUbiquiti", productoServiceImpl.encontrarPorMarca(marca));
		return mav;
	}
	@GetMapping("/Mimosa")
	public ModelAndView categoriaMimosa() {
		ModelAndView mav=new ModelAndView("/ecommerce/categoryMimosa");
		Marca marca=marcaServiceImpl.encontrarMarca("MIMOSA NETWORKS");
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
	
	@GetMapping("/Epcom")
	public ModelAndView categoriaEpcom() {
		ModelAndView mav=new ModelAndView("/ecommerce/categoryEpcom");
		Marca marca=marcaServiceImpl.encontrarMarca("EPCOM");
		mav.addObject("listaUbiquiti", productoServiceImpl.encontrarPorMarca(marca));
		return mav;
	}
	
	@GetMapping("/Samsung")
	public ModelAndView categoriaSamsung() {
		ModelAndView mav=new ModelAndView("/ecommerce/categorySamsungWisenet");
		Marca marca=marcaServiceImpl.encontrarMarca("SAMSUNG WISENET");
		mav.addObject("listaUbiquiti", productoServiceImpl.encontrarPorMarca(marca));
		return mav;
	}
	
	@GetMapping("/Epcom_Power_Line")
	public ModelAndView categoriaKenwood() {
		ModelAndView mav=new ModelAndView("/ecommerce/categoryPowerLine");
		Marca marca=marcaServiceImpl.encontrarMarca("EPCOM POWER LINE");
		mav.addObject("listaUbiquiti", productoServiceImpl.encontrarPorMarca(marca));
		return mav;
	}
	@GetMapping("/Epsolar")
	public ModelAndView categoriaEpsolar() {
		ModelAndView mav=new ModelAndView("/ecommerce/categoryEpsolar");
		Marca marca=marcaServiceImpl.encontrarMarca("EPSOLAR");
		mav.addObject("listaUbiquiti", productoServiceImpl.encontrarPorMarca(marca));
		return mav;
	}

}
