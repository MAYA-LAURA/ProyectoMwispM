package com.mx.mwisp.mwsipfinal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_detalles")
public class DetalleVenta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id_Detalles")
	private int idDetalles;

	@ManyToOne
	@JoinColumn(name = "Fk_Producto")
	private Productos idProducto;

	@ManyToOne
	@JoinColumn(name = "Fk_Venta")
	private Ventas idVenta;

	@Column(name = "Cantidad_Producto")
	private int cantidad;

	@Column(name = "Monto")
	private double monto;

	@Column(name = "Precio_Unitario")
	private double precioUnitario;

	public DetalleVenta() {
		// TODO Auto-generated constructor stub
	}

	public int getIdDetalles() {
		return idDetalles;
	}

	public void setIdDetalles(int idDetalles) {
		this.idDetalles = idDetalles;
	}

	public Ventas getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(Ventas idVenta) {
		this.idVenta = idVenta;
	}

	public Productos getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Productos idProducto) {
		this.idProducto = idProducto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	@Override
	public String toString() {
		return "DetalleVenta [idDetalles=" + idDetalles + ", idProducto=" + idProducto + ", idVenta=" + idVenta
				+ ", cantidad=" + cantidad + ", monto=" + monto + ", precioUnitario=" + precioUnitario + "]";
	}

	

}
