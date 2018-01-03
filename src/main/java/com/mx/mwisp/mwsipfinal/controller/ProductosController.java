package com.mx.mwisp.mwsipfinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.mx.mwisp.mwsipfinal.model.ProductoModel;
import com.mx.mwisp.mwsipfinal.service.CategoriaService;
import com.mx.mwisp.mwsipfinal.service.ProductoService;

@Controller
@RequestMapping("/Admin")
public class ProductosController {

	
	private static final String vistaProductoAdmin = "productosAdmin";
	@Autowired
	@Qualifier("productoServiceImpl")
	ProductoService productoServiceImpl;
	@Qualifier("categoriaServiceImpl")
	CategoriaService categoriaServiceImpl;



	@GetMapping("/listaProductosAdmin")
	public ModelAndView vistaProductosAdmin() {
		ModelAndView mav = new ModelAndView(vistaProductoAdmin);
		mav.addObject("objProductoAdmin", productoServiceImpl.listarProductos());
		return mav;
	}

	@GetMapping("/formProducto")
	public ModelAndView formularioProducto(@RequestParam(name="idz",required=false) int id) {
		ModelAndView mav = new ModelAndView("formularioProducto");
		if (id!=0) {
			
			mav.addObject("produ", productoServiceImpl.encontrarPorId(id));
		}
		else {
			mav.addObject("produ", new ProductoModel());
			
		}
		return mav;
	
	}

	@PostMapping("/addProducto")
	public String agregarProductos(@ModelAttribute("prod") ProductoModel productoModel) {
		productoServiceImpl.addProducto(productoModel);
		return "redirect:/Admin/listaProductosAdmin";

	}
	
	 @RequestMapping(path = "/eliminar/{id}", method = RequestMethod.GET)
	 public String eliminar(@PathVariable(name="id") int id) {
		 productoServiceImpl.eliminarPorId(id);
		 return "redirect:/Admin/listaProductosAdmin";
	 }
	 
	 
//	 @ModelAttribute("resultSelect")
//	 public List<String> getResultSelect(){
//		 
//		 List<String> nombreCategorias= new ArrayList<>(); 
//		 List<Categoria> categorias=categoriaServiceImpl.listarCategorias();
//		 Iterator<Categoria> it=categorias.iterator();
//		 if (categorias.size()>0) {
//			 while(it.hasNext()) {
//				 nombreCategorias.add(it.next().getNombreCategoria());
//				 
//			 }
//			 
//		 }
//		 return nombreCategorias;
//	 }

//	@GetMapping("/eliminar")
//	public ModelAndView eliminar(@RequestParam(name = "id", required = true) int id) {
//		productoServiceImpl.eliminarPorId(id);
//		return vistaProductosAdmin();
//	}

}
