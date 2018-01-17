package com.mx.mwisp.mwsipfinal.model;

import java.util.ArrayList;
import java.util.List;


/**
 * @author wisme
 * Objeto que contiene la lista de productos
 * que se van agregando al carrito
 */
public class CarritoInfo {
	private int ordenNum;
	private final List<CarritoOnlineInfo> cartOnline=new ArrayList<CarritoOnlineInfo>();
	
	public CarritoInfo() {
		
	}

	public int getOrdenNum() {
		return ordenNum;
	}

	public void setOrdenNum(int ordenNum) {
		this.ordenNum = ordenNum;
	}

	public List<CarritoOnlineInfo> getCartOnline() {
		return this.cartOnline;
	}
	
	//este metodo encuentra los productos en el carrito
	private CarritoOnlineInfo encontrarPorId(int id) {
		for(CarritoOnlineInfo line: this.cartOnline) {
			if(line.getProductoModel().getIdProdcutos()==id) {
				return line;
			}
		}
		return null;
	}
	public void agregarProducto(ProductoModel productoModel,int cantidad) {
		CarritoOnlineInfo line=this.encontrarPorId(productoModel.getIdProdcutos());
		
		if (line==null) {
			line=new CarritoOnlineInfo();
			line.setCantidad(0);
			line.setProductoModel(productoModel);
			this.cartOnline.add(line);
		}
		int nuevaCantidad=line.getCantidad()+cantidad;
		if(nuevaCantidad<=0) {
			this.cartOnline.remove(line);
		}
		else {
			line.setCantidad(nuevaCantidad);
		}
	}
	
	public void eliminarProducto(ProductoModel productoModel) {
		CarritoOnlineInfo line=this.encontrarPorId(productoModel.getIdProdcutos());
		if (line!=null) {
			this.cartOnline.remove(line);
		}
		
	}
	public void updateProduct(int id,int cantidad) {
		CarritoOnlineInfo line=this.encontrarPorId(id);
		if (line!=null) {
			if(cantidad<=0) {
				
			}else {
				line.setCantidad(cantidad);
			}
			
		}
	}
	
	public void actualizarCantidad(CarritoInfo carritoForm) {
		if(carritoForm!=null) {
			List<CarritoOnlineInfo> lines=carritoForm.getCartOnline();
			for(CarritoOnlineInfo line: lines) {
				this.updateProduct(line.getProductoModel().getIdProdcutos(),line.getCantidad());
			}
		}
	}
	
	public boolean isEmpty() {
		return this.cartOnline.isEmpty();
	}
	
	public double getMontoTotal() {
		double total=0;
		for(CarritoOnlineInfo line:this.cartOnline) {
			total+=line.getMonto();
		}
		return total;
	}

	@Override
	public String toString() {
		return "CarritoInfo [ordenNum=" + ordenNum + ", cartOnline=" + cartOnline + "]";
	}
	
}
