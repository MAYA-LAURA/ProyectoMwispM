package com.mx.mwisp.mwsipfinal.controller;

import javax.servlet.http.HttpServletRequest;

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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mx.mwisp.mwsipfinal.converter.impl.ProductoConverter;
import com.mx.mwisp.mwsipfinal.entity.Productos;
import com.mx.mwisp.mwsipfinal.model.CarritoInfo;
import com.mx.mwisp.mwsipfinal.model.PagoModeloForm;
import com.mx.mwisp.mwsipfinal.model.ProductoModel;
import com.mx.mwisp.mwsipfinal.openpay.CargoBanco;
import com.mx.mwisp.mwsipfinal.openpay.CargoTarjeta;
import com.mx.mwisp.mwsipfinal.openpay.CargoTienda;
import com.mx.mwisp.mwsipfinal.openpay.ClienteOpenpay;
import com.mx.mwisp.mwsipfinal.openpay.ObjPeticion;
import com.mx.mwisp.mwsipfinal.openpay.ObjetoPeticionCard;
import com.mx.mwisp.mwsipfinal.openpay.RespuestaPeticion;
import com.mx.mwisp.mwsipfinal.service.PersonaService;
import com.mx.mwisp.mwsipfinal.service.ProductoService;
import com.mx.mwisp.mwsipfinal.service.VentasService;
import com.mx.mwisp.mwsipfinal.service.impl.PagoServiceImpl;
import com.mx.mwisp.mwsipfinal.utils.Utils;

@Controller
@RequestMapping("/ecommerce")
public class ControllerEcommerce {
	private static final Log LOG = LogFactory.getLog(ControllerEcommerce.class);
	@Autowired
	@Qualifier("productoServiceImpl")
	ProductoService productoServiceImpl;
	@Autowired
	@Qualifier("productoConverter")
	ProductoConverter productoConverter;
	@Autowired
	@Qualifier("personaServiceImpl")
	PersonaService personaServiceImpl;
	@Autowired
	@Qualifier("pagoServiceImpl")
	PagoServiceImpl pagoServiceImpl;
	@Autowired
	@Qualifier("ventasServiceImpl")
	VentasService ventaServiceImpl;
	
	
	@GetMapping("/principal")
	public ModelAndView vistaPrincipal() {
		ModelAndView mav = new ModelAndView("/ecommerce/indexecommerce");
		mav.addObject("listProduc", productoServiceImpl.listarProductos());
		return mav;
	}

	@RequestMapping({ "/comprarProducto" })
	public String listaCarrito(HttpServletRequest request, Model model,
			@RequestParam(value = "id", defaultValue = "") int id) {
		Productos producto = null;
		if (id != 0) {
			producto = productoServiceImpl.encontrarPorId(id);
		}
		if (producto != null) {
			CarritoInfo carroInfo = Utils.getCarroSession(request);
			ProductoModel productoModel = productoConverter.entityModel(producto);
			carroInfo.agregarProducto(productoModel, 1);
		}
		LOG.info("metodo===============ComprarProducto");
		return "redirect:/ecommerce/carrito";
	}

	@RequestMapping(value = { "/carrito" }, method = RequestMethod.GET)
	public String shoppingCartHandler(HttpServletRequest request, Model model) {
		LOG.info("Metodo==============ShoppingCart");
		CarritoInfo miCarrito = Utils.getCarroSession(request);
		model.addAttribute("carritoForm", miCarrito);
		LOG.info(miCarrito);
		return "/ecommerce/basket";
	}

	// POST: actualiza cantidad de productos en el carrito
	@RequestMapping(value = { "/carritoCompras" }, method = RequestMethod.POST)
	public String actualizarCarrito(HttpServletRequest request, Model model,
			@ModelAttribute("carritoForm") CarritoInfo carritoForm) {
		LOG.info("Entrado al metodo POST");
		LOG.info(carritoForm);
		CarritoInfo carritoInfo = Utils.getCarroSession(request);
		carritoInfo.actualizarCantidad(carritoForm);
		return "redirect:/ecommerce/carrito";
	}

	@RequestMapping({ "/eliminarProductoCarrito" })
	public String eliminarProductoCart(HttpServletRequest request, Model model,
			@RequestParam(value = "id", defaultValue = "") int id) {
		Productos producto = null;
		if (id != 0) {
			producto = productoServiceImpl.encontrarPorId(id);
		}
		if (producto != null) {
			CarritoInfo carroInfo = Utils.getCarroSession(request);
			ProductoModel productoModel = productoConverter.entityModel(producto);
			carroInfo.eliminarProducto(productoModel);
		}
		return "redirect:/ecommerce/carrito";
	}

	@GetMapping("/wizard")
	public ModelAndView wizard(HttpServletRequest request) {
		LOG.info("metodo wizard");
		CarritoInfo carritoInfo = Utils.getCarroSession(request);
		if (carritoInfo.isEmpty()) {
			ModelAndView mav = new ModelAndView("redirect:/ecommerce/carrito");
			return mav;
		}
		PagoModeloForm pagoModel = new PagoModeloForm();
		pagoModel.setTotalCompra(carritoInfo.getMontoTotal());
		ModelAndView mav = new ModelAndView("/ecommerce/Wizard");
		mav.addObject("miCarrito", carritoInfo);
		mav.addObject("formularioEcommerce", pagoModel);
		return mav;
	}

	@PostMapping("/pagar")
	public String pagar(HttpServletRequest request,
			@ModelAttribute("formularioEcommerce") PagoModeloForm pagoModelForm,Model model,
			RedirectAttributes flash) {

		ClienteOpenpay clienteOpenpay = new ClienteOpenpay(pagoModelForm.getName(), pagoModelForm.getApellidoPaterno(),
				pagoModelForm.getNumeroTelefono(), pagoModelForm.getEmail());
		String urlPdf = null;
		String formaPago = null;
		String radiobtnb24 = request.getParameter("pago");
		LOG.info("Entrando al metodo:===========================================PAGAR");
		LOG.info(pagoModelForm.getName());
		LOG.info(radiobtnb24);
		LOG.info(pagoModelForm.getFormaPago());
		if (radiobtnb24.equals("0")) {
			formaPago = "Pago en Banco";
			ObjPeticion peticionBanco = new ObjPeticion("bank_account", pagoModelForm.getTotalCompra(), "MXN",
					"Pago en Banco", clienteOpenpay);
			CargoBanco cargoBanco = new CargoBanco();
			RespuestaPeticion respuestaPeticionBanco = cargoBanco.cargoB(peticionBanco);
			urlPdf = "https://sandbox-dashboard.openpay.mx/spei-pdf/mexcviwsqt2snzeylcy5" + "/"
					+ respuestaPeticionBanco.getId();
			LOG.info(urlPdf);
		}
		if (radiobtnb24.equals("1")) {
			formaPago = "Pago en Tienda";
			ObjPeticion objPeticion = new ObjPeticion("store", pagoModelForm.getTotalCompra(), "MXN", "pago en tienda",
					clienteOpenpay);
			CargoTienda cargoTienda = new CargoTienda();
			RespuestaPeticion respuestPeticionTienda = cargoTienda.cargoStore(objPeticion);
			urlPdf = "https://sandbox-dashboard.openpay.mx/paynet-pdf/mexcviwsqt2snzeylcy5" + "/"
					+ respuestPeticionTienda.getPayment_method().getReference();
			LOG.info(respuestPeticionTienda.getPayment_method().getReference());
			LOG.info(urlPdf);

		}

		if (radiobtnb24.equals("2")) {
			formaPago = "Pago con tarjeta";
			LOG.info("entrando al metodo de la tarjeta");
			LOG.info("token:==============" + pagoModelForm.getToken());
			ObjetoPeticionCard objetoPeticionCard = new ObjetoPeticionCard(pagoModelForm.getToken(), "card",
					pagoModelForm.getTotalCompra(), "MXN", "pago tarjeta", "1rvGhOGaFgPwNbrtefA4IwPZbMRjsQpe",
					clienteOpenpay);
			CargoTarjeta cargoTarjeta = new CargoTarjeta();
			cargoTarjeta.cargoT(objetoPeticionCard);
			//urlPdf = "/index";
		}
		CarritoInfo carritoInfo = Utils.getCarroSession(request);
		String folio=null;
		int ordernum = pagoServiceImpl.guardarFormularioPago(pagoModelForm, carritoInfo, formaPago);
		folio=ventaServiceImpl.encontrarPordId(ordernum).getFolio();
		LOG.info("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+folio);
		flash.addFlashAttribute("orden", ordernum);
		flash.addFlashAttribute("folio",folio);
		flash.addFlashAttribute("pdf",urlPdf);
		// elimina el carrito de la sesion
		Utils.removerCarroSesion(request);
		// return "redirect:" + urlPdf;
		return "redirect:/ecommerce/successful";
	}
	
	@GetMapping("/successful")
	public String compraExitosa() {
		return "/ecommerce/successful";
	}
	
	
	
	
	@GetMapping("/404")
	public ModelAndView vistaError() {
		ModelAndView mav = new ModelAndView("/ecommerce/404");
		return mav;
	}

	@GetMapping("/encabezado")
	public ModelAndView vistaEncabezado() {
		ModelAndView mav = new ModelAndView("/ecommerce/encabezado");
		return mav;
	}

	@GetMapping("/blog")
	public ModelAndView vistaBlog() {
		ModelAndView mav = new ModelAndView("/ecommerce/blog");
		return mav;
	}

	@GetMapping("/categoria")
	public ModelAndView vistaCategoria() {

		ModelAndView mav = new ModelAndView("/ecommerce/category");
		mav.addObject("listProduc", productoServiceImpl.listarProductos());
		return mav;
	}

	@GetMapping("/checkout1")
	public ModelAndView vistaCheck1() {
		ModelAndView mav = new ModelAndView("/ecommerce/checkout1");
		return mav;
	}

	@GetMapping("/checkout2")
	public ModelAndView vistaCheck2() {
		ModelAndView mav = new ModelAndView("/ecommerce/checkout2");
		return mav;
	}

	@GetMapping("/checkout3")
	public ModelAndView vistaCheck3() {
		ModelAndView mav = new ModelAndView("/ecommerce/checkout3");
		return mav;
	}

	@GetMapping("/checkout4")
	public ModelAndView vistaCheck4() {
		ModelAndView mav = new ModelAndView("/ecommerce/checkout4");
		return mav;
	}

	@GetMapping("/contacto")
	public ModelAndView vistaContact() {
		ModelAndView mav = new ModelAndView("/ecommerce/contact");
		return mav;
	}

	@GetMapping("/cuenta")
	public ModelAndView vistaCompras() {
		ModelAndView mav = new ModelAndView("/ecommerce/customer-account");
		return mav;
	}

	@GetMapping("/orden")
	public ModelAndView vistaOrden() {
		ModelAndView mav = new ModelAndView("/ecommerce/customer-order");
		return mav;
	}

	@GetMapping("/ordenes")
	public ModelAndView vistaOrdenes() {
		ModelAndView mav = new ModelAndView("/ecommerce/customer-orders");
		return mav;
	}

	// este metodo muestra los detalles de cada producto
	@GetMapping("/{modelo}/detalles")
	public ModelAndView vistaDetail(@PathVariable(value = "modelo") String modelo) {
		ModelAndView mav = new ModelAndView("/ecommerce/detail");
		Productos producto = productoServiceImpl.encontraPorModelo(modelo);
		ProductoModel productoModel=productoConverter.entityModel(producto);
		mav.addObject("productoFind", productoModel);
		return mav;
	}

	@GetMapping("/pregfrec")
	public ModelAndView vistaFaq() {
		ModelAndView mav = new ModelAndView("/ecommerce/faq");
		return mav;
	}

	@GetMapping("/post")
	public ModelAndView vistaPost() {
		ModelAndView mav = new ModelAndView("/ecommerce/post");
		return mav;
	}

	@GetMapping("/registrar")
	public ModelAndView vistaRegister() {
		ModelAndView mav = new ModelAndView("/ecommerce/register");
		return mav;
	}
}
