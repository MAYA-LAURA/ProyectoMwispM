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
@Table(name="t_producto")
public class Productos {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id_Producto")
	private int idProdcutos;
	
	@Column(name="Nombre")
	private String nombreProducto;
	
	@Column(name="Precio")
	private float precio;
	
	@Column(name="Descripcion")
	private String descripcion;
	
	@Column(name="Tiempo_Garantia")
	private String tiempoGarantia;
 
	@ManyToOne
	@JoinColumn(name="Fk_Categoria")
	private Categoria categoria;
	
	public Productos() {
		// TODO Auto-generated constructor stub
	}

	public Productos(String nombreProducto,float precio, String descripcion, String tiempoGarantia) {
		super();
		this.nombreProducto = nombreProducto;
		this.precio = precio;
		this.descripcion = descripcion;
		this.tiempoGarantia = tiempoGarantia;
	}

	public int getIdProdcutos() {
		return idProdcutos;
	}

	public void setIdProdcutos(int idProdcutos) {
		this.idProdcutos = idProdcutos;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTiempoGarantia() {
		return tiempoGarantia;
	}

	public void setTiempoGarantia(String tiempoGarantia) {
		this.tiempoGarantia = tiempoGarantia;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}
	
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Productos [idProdcutos=" + idProdcutos + ", nombreProducto=" + nombreProducto +", precio=" + precio + ", descripcion=" + descripcion + ", tiempoGarantia="
				+ tiempoGarantia + "]";
	}
	
	
	
}
