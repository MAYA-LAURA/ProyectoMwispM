package com.mx.mwisp.mwsipfinal.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mx.mwisp.mwsipfinal.entity.Productos;
import com.mx.mwisp.mwsipfinal.model.ProductoModel;
import com.mx.mwisp.mwsipfinal.service.CategoriaService;
import com.mx.mwisp.mwsipfinal.service.MarcaService;
import com.mx.mwisp.mwsipfinal.service.ProductoService;

@Controller
@RequestMapping("/Admin")
public class ProductosController {
	private static final Log LOG=LogFactory.getLog(ProductosController.class);
	
	private static final String vistaProductoAdmin = "/ecommerce/productosAdmin";
	@Autowired
	@Qualifier("productoServiceImpl")
	ProductoService productoServiceImpl;
	
	@Autowired
	@Qualifier("categoriaServiceImpl")
	CategoriaService categoriaServiceImpl;
	
	@Autowired
	@Qualifier("marcaServiceImpl")
	MarcaService marcaServiceImpl;

	// este metodo muestra los detalles de un producto
	@GetMapping(value="/verProducto/{id}")
	public String ver(@PathVariable(value="id")int id,Model model ) {
		Productos producto=productoServiceImpl.encontrarPorId(id);
		model.addAttribute("producto",producto );
		model.addAttribute("titulo","Detalle Producto:"+producto.getNombreProducto());
		return "/ecommerce/detallesProducto";
	}
	


	@GetMapping("/listaProductosAdmin")
	public ModelAndView vistaProductosAdmin() {
		ModelAndView mav = new ModelAndView(vistaProductoAdmin);
		mav.addObject("objProductoAdmin", productoServiceImpl.listarProductos());
		return mav;
	}

	@GetMapping("/formProducto")
	public ModelAndView formularioProducto(@RequestParam(name="idz",required=false) int id) {
		ModelAndView mav = new ModelAndView("/ecommerce/formularioProducto");
		if (id!=0) {
			mav.addObject("marcaObj", marcaServiceImpl.listaMarcas());
			mav.addObject("produ", productoServiceImpl.encontrarPorId(id));
			mav.addObject("categoriaObj", categoriaServiceImpl.listarCategorias());
		}
		else {
			mav.addObject("produ", new ProductoModel());
			mav.addObject("marcaObj", marcaServiceImpl.listaMarcas());
			mav.addObject("categoriaObj", categoriaServiceImpl.listarCategorias());
			
			
		}
		return mav;
	
	}

	@PostMapping("/addProducto")
	public String agregarProductos(@ModelAttribute("prod") ProductoModel productoModel,	RedirectAttributes flass,
			@RequestParam("file") MultipartFile imagen,@RequestParam("file2") MultipartFile imagen2) {
		///si la imagen1 existe entonces guarda la imagen en el directorio c:/imagenes/uploads
		if(!imagen.isEmpty()) {
			//si ya existe una imagen la elimina
			if(productoModel.getImagen1()!=null) {
				Path rootPath1=Paths.get("c:/imagenes/uploads").resolve(productoModel.getImagen1()).toAbsolutePath();
				File archivo1=rootPath1.toFile();
				if (archivo1.exists() && archivo1.canRead()) {
					archivo1.delete();
				 }
			}
//			String rootPatch="c://imagenes//uploads";  * esta es la ruta que se usa para agregar la configuracion en el paquete configuration
			//en esta parte se genera un nombre unico para la imagen que se guarda en el sistema
			String unicoNombre=UUID.randomUUID().toString()+"_"+imagen.getOriginalFilename();
			Path rootPatch=Paths.get("c://imagenes/uploads").resolve(unicoNombre);
			Path rootAbsolutPath=rootPatch.toAbsolutePath();
			LOG.info("rootPatch"+rootPatch);
			LOG.info("rootAbsolutPath"+rootAbsolutPath);
			try {
				Files.copy(imagen.getInputStream(), rootAbsolutPath);
				productoModel.setImagen1(unicoNombre);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		///si la imagen2 existe entonces guarda la imagen en el directorio c:/imagenes/uploads
		if(!imagen2.isEmpty()) {
			//si ya existe una imagen2 la elimina
			if(productoModel.getImagen2()!=null) {
				Path rootPath2=Paths.get("c:/imagenes/uploads").resolve(productoModel.getImagen2()).toAbsolutePath();
				File archivo2=rootPath2.toFile();
				if (archivo2.exists() && archivo2.canRead()) {
					archivo2.delete();
				 }
			}
			String unicoNombre2=UUID.randomUUID().toString()+"_"+imagen2.getOriginalFilename();
			Path rootPatch=Paths.get("c://imagenes/uploads").resolve(unicoNombre2);
			Path rootAbsolutPath=rootPatch.toAbsolutePath();
			LOG.info("rootPatch"+rootPatch);
			LOG.info("rootAbsolutPath"+rootAbsolutPath);
			try {
				Files.copy(imagen2.getInputStream(), rootAbsolutPath);
				productoModel.setImagen2(unicoNombre2);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (productoServiceImpl.addProducto(productoModel)!=null) {
			if(productoModel.getIdProdcutos()!=0) {
			flass.addFlashAttribute("success", "Producto Editado Correctamente!");
			}else {
				flass.addFlashAttribute("success", "Producto Agregado Correctamente!");
			}
		}else {
			
		}
		
		return "redirect:/Admin/listaProductosAdmin";
	}
	
	
	// con este metodo se elimina un producto por su id y tambien se elimina las imagenes del producto
	 @RequestMapping(path = "/eliminar/{id}", method = RequestMethod.GET)
	 public String eliminar(@PathVariable(name="id") int id) {
		 Productos producto=productoServiceImpl.encontrarPorId(id);
		 productoServiceImpl.eliminarPorId(id);
		 
		 //aqui encuntra al cliente por su id para despues recuperar la foto y eliminarla
		 //falta cambiar la entity por un modelo 
		 Path rootPath1=Paths.get("c:/imagenes/uploads").resolve(producto.getImagen1()).toAbsolutePath();
		 Path rootPath2=Paths.get("c:/imagenes/uploads").resolve(producto.getImagen2()).toAbsolutePath();
		 File archivo1=rootPath1.toFile();
		 File archivo2=rootPath2.toFile();
		 if (archivo1.exists() && archivo1.canRead()) {
			 if(archivo1.delete()) {
				 LOG.info("Imagen"+producto.getImagen1()+"eliminada");
			 }
		 }
		 if (archivo2.exists() && archivo2.canRead()) {
			 if(archivo2.delete()) {
				 LOG.info("Imagen"+producto.getImagen2()+"eliminada");
			 }
		 }
		 
		
		 return "redirect:/Admin/listaProductosAdmin";
	 }
	 
	 

//	@GetMapping("/eliminar")
//	public ModelAndView eliminar(@RequestParam(name = "id", required = true) int id) {
//		productoServiceImpl.eliminarPorId(id);
//		return vistaProductosAdmin();
//	}

}
