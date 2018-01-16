package com.mx.mwisp.mwsipfinal.model;

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

	public double getMonto() {
		return this.productoModel.getPrecioMxm() * this.cantidad;
	}

	@Override
	public String toString() {
		return "CarritoInfo [cantidad=" + cantidad + ", productoModel=" + productoModel + "]";
	}

}
