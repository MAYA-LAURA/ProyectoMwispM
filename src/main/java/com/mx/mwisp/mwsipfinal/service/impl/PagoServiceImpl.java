package com.mx.mwisp.mwsipfinal.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mx.mwisp.mwsipfinal.entity.DetalleVenta;
import com.mx.mwisp.mwsipfinal.entity.Direccion;
import com.mx.mwisp.mwsipfinal.entity.Persona;
import com.mx.mwisp.mwsipfinal.entity.Productos;
import com.mx.mwisp.mwsipfinal.entity.Ventas;
import com.mx.mwisp.mwsipfinal.model.CarritoInfo;
import com.mx.mwisp.mwsipfinal.model.CarritoOnlineInfo;
import com.mx.mwisp.mwsipfinal.model.PagoModeloForm;
import com.mx.mwisp.mwsipfinal.service.DetallesVetasService;
import com.mx.mwisp.mwsipfinal.service.DireccionService;
import com.mx.mwisp.mwsipfinal.service.PersonaService;
import com.mx.mwisp.mwsipfinal.service.ProductoService;
import com.mx.mwisp.mwsipfinal.service.VentasService;

@Service("pagoServiceImpl")
public class PagoServiceImpl {

	private static final Log LOG = LogFactory.getLog(PagoServiceImpl.class);
	@Autowired
	@Qualifier("productoServiceImpl")
	ProductoService productoServiceImpl;
	@Autowired
	@Qualifier("personaServiceImpl")
	PersonaService personaServiceImpl;
	@Autowired
	@Qualifier("direccionServiceImpl")
	DireccionService direccionServiceImpl;
	@Autowired
	@Qualifier("ventasServiceImpl")
	VentasService ventaServiceImpl;
	@Autowired
	@Qualifier("detallesVentasServiceImpl")
	DetallesVetasService detallesVentasServiceImpl;

	public int guardarFormularioPago(PagoModeloForm pagoModeloForm, CarritoInfo carritoInfo, String formaPago) {

		Ventas venta = new Ventas();

		// aqui se obtiene los datos del formulario y se asignan al objeto persona
		Persona persona = new Persona(pagoModeloForm.getName(), pagoModeloForm.getApellidoPaterno(),
				pagoModeloForm.getApellidoMaterno(), pagoModeloForm.getEmail(), pagoModeloForm.getNumeroTelefono());
		// aqui se obtiene los datos del formulario y se asignan al objeto Direccion
		Direccion direccion = new Direccion(pagoModeloForm.getCodigoPostal(), pagoModeloForm.getCalle(),
				pagoModeloForm.getNumeroExterior(), pagoModeloForm.getNumeroInterior(), pagoModeloForm.getEstado(),
				pagoModeloForm.getColonia(), pagoModeloForm.getMunicipio());

		persona = personaServiceImpl.addPersona(persona);
		direccion.setPersona(persona);
		direccionServiceImpl.addDireccion(direccion);

		// se asigan los datos del carrito a la venta
		venta.setFolio(this.generadorFolio());
		venta.setFechaVenta(new Date());
		venta.setMontoVenta(carritoInfo.getMontoTotal());
		venta.setFormaPago(formaPago);
		venta.setPersona(persona);
		ventaServiceImpl.addVentas(venta);
		int numeroDeOrden = venta.getIdVenta();

		List<CarritoOnlineInfo> lines = carritoInfo.getCartOnline();
		for (CarritoOnlineInfo line : lines) {
			DetalleVenta detalle = new DetalleVenta();
			detalle.setIdVenta(venta);
			detalle.setCantidad(line.getCantidad());
			detalle.setMonto(line.getMonto());
			detalle.setPrecioUnitario(line.getProductoModel().getPrecioMxm());

			int id = line.getProductoModel().getIdProdcutos();
			Productos producto = productoServiceImpl.encontrarPorId(id);
			detalle.setIdProducto(producto);
			detallesVentasServiceImpl.addDetalleVentas(detalle);

		}

		LOG.info("persona Insertada en la Base de datos=====================================" + persona);
		LOG.info("direccion guardada en la base de datos====================================" + direccion);
		LOG.info("venta creada====================================" + venta);
		return numeroDeOrden;
	}

	public String generadorFolio() {
		String folio = RandomStringUtils.randomAlphanumeric(10);
		return folio;
	}

}
