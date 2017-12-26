package com.mx.mwisp.mwsipfinal.model;

import com.mx.mwisp.mwsipfinal.entity.Categoria;

public class ProductoModel {
	private int  idProdcutos;
	private String nombreProducto;
	private float precio;
	private String descripcion;
	private String tiempoGarantia;
	private Categoria categoria;

	
	
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


	

	public ProductoModel(int idProdcutos, String nombreProducto, float precio, String descripcion,
			String tiempoGarantia, Categoria categoria) {
		super();
		this.idProdcutos = idProdcutos;
		this.nombreProducto = nombreProducto;
		this.precio = precio;
		this.descripcion = descripcion;
		this.tiempoGarantia = tiempoGarantia;
		this.categoria = categoria;
	}



	public ProductoModel() {
		// TODO Auto-generated constructor stub
	}

}
