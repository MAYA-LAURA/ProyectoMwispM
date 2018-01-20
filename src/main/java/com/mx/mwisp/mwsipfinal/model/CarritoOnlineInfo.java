package com.mx.mwisp.mwsipfinal.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author Jorge este objeto tiene una variable cantida y produto, que se
 *         utiliza para calcular el monto total por producto
 * 
 */
public class CarritoOnlineInfo {
	private int cantidad;
	private ProductoModel productoModel;

	public CarritoOnlineInfo() {
		this.cantidad = 0;
	}

	public ProductoModel getProductoModel() {
		return productoModel;
	}

	public void setProductoModel(ProductoModel productoModel) {
		this.productoModel = productoModel;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	

	//obtiene el monto por producto
	public double getMonto() {
		BigDecimal bd=new BigDecimal(this.productoModel.getPrecioMxm() * this.cantidad);
		bd=bd.setScale(2, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}

	@Override
	public String toString() {
		return "CarritoInfo [cantidad=" + cantidad + ", productoModel=" + productoModel + "]";
	}

}
