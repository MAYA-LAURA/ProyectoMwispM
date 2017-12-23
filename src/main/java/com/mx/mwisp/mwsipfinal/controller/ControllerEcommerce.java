package com.mx.mwisp.mwsipfinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mx.mwisp.mwsipfinal.service.ProductoService;

@Controller
@RequestMapping("/ecommerce")
public class ControllerEcommerce {
@Autowired
@Qualifier("productoServiceImpl")
ProductoService productoServiceImpl;
	
@GetMapping("/principal")
public ModelAndView vistaPrincipal() {
	ModelAndView mav=new ModelAndView("/ecommerce/indexecommerce");
	return mav;
}
	

@GetMapping ("/404")
public ModelAndView vistaError() {
	ModelAndView mav=new ModelAndView ("/ecommerce/404");
	return mav;
			}
@GetMapping ("/carrito")
public ModelAndView vistaCar() {
	ModelAndView mav=new ModelAndView ("/ecommerce/basket");
	return mav;
			}
@GetMapping ("/encabezado")
public ModelAndView vistaEncabezado() {
	ModelAndView mav=new ModelAndView ("/ecommerce/encabezado");
	return mav;
			}
@GetMapping ("/blog")
public ModelAndView vistaBlog() {
	ModelAndView mav=new ModelAndView ("/ecommerce/blog");
	return mav;
			}
@GetMapping ("/categoria")
public ModelAndView vistaCategoria() {
	
	ModelAndView mav=new ModelAndView ("/ecommerce/category");
	mav.addObject("listProduc", productoServiceImpl.listarProductos());
	return mav;
			}

@GetMapping ("/checkout1")
public ModelAndView vistaCheck1() {
	ModelAndView mav=new ModelAndView ("/ecommerce/checkout1");
	return mav;
			}
@GetMapping ("/checkout2")
public ModelAndView vistaCheck2() {
	ModelAndView mav=new ModelAndView ("/ecommerce/checkout2");
	return mav;
			}
@GetMapping ("/checkout3")
public ModelAndView vistaCheck3() {
	ModelAndView mav=new ModelAndView ("/ecommerce/checkout3");
	return mav;
			}
@GetMapping ("/checkout4")
public ModelAndView vistaCheck4() {
	ModelAndView mav=new ModelAndView ("/ecommerce/checkout4");
	return mav;
			}
@GetMapping ("/contacto")
public ModelAndView vistaContact() {
	ModelAndView mav=new ModelAndView ("/ecommerce/contact");
	return mav;
			}
@GetMapping ("/cuenta")
public ModelAndView vistaCompras() {
	ModelAndView mav=new ModelAndView ("/ecommerce/customer-account");
	return mav;
			}
@GetMapping ("/orden")
public ModelAndView vistaOrden() {
	ModelAndView mav=new ModelAndView ("/ecommerce/customer-order");
	return mav;
			}
@GetMapping ("/ordenes")
public ModelAndView vistaOrdenes() {
	ModelAndView mav=new ModelAndView ("/ecommerce/customer-orders");
	return mav;
			}
@GetMapping ("/detalles")
public ModelAndView vistaDetail() {
	ModelAndView mav=new ModelAndView ("/ecommerce/detail");
	return mav;
			}
@GetMapping ("/pregfrec")
public ModelAndView vistaFaq() {
	ModelAndView mav=new ModelAndView ("/ecommerce/faq");
	return mav;
			}
@GetMapping ("/post")
public ModelAndView vistaPost() {
	ModelAndView mav=new ModelAndView ("/ecommerce/post");
	return mav;
			}
@GetMapping ("/registrar")
public ModelAndView vistaRegister() {
	ModelAndView mav=new ModelAndView ("/ecommerce/register");
	return mav;
			}
}

