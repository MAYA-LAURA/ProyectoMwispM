package com.mx.mwisp.mwsipfinal.model;



import com.mx.mwisp.mwsipfinal.entity.Categoria;
import com.mx.mwisp.mwsipfinal.entity.Marca;

public class ProductoModel {
	private int  idProdcutos;
	private String nombreProducto;
	private String modelo;
	private double precio;
	private String descripcion;
	private String tiempoGarantia;
	private Categoria categoria;
	private Marca marca;
	
	private String imagen1;
	private String imagen2;
	
	//variable para pasar el valor en pesos mexicanos
	private double precioMxm;
	
	
	
	public String getImagen1() {
		return imagen1;
	}



	public void setImagen1(String imagen1) {
		this.imagen1 = imagen1;
	}



	public String getImagen2() {
		return imagen2;
	}



	public void setImagen2(String imagen2) {
		this.imagen2 = imagen2;
	}



	public String getModelo() {
		return modelo;
	}



	public void setModelo(String modelo) {
		this.modelo = modelo;
	}



	public Marca getMarca() {
		return marca;
	}



	public void setMarca(Marca marca) {
		this.marca = marca;
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



	public double getPrecio() {
		return precio;
	}



	public void setPrecio(double precio) {
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
	



	public double getPrecioMxm() {
		return precioMxm;
	}



	public void setPrecioMxm(double precioMxm) {
		this.precioMxm = precioMxm;
	}



	public ProductoModel(String nombreProducto, String modelo, float precio, String descripcion, String tiempoGarantia,
			Categoria categoria, Marca marca) {
		super();
		this.nombreProducto = nombreProducto;
		this.modelo = modelo;
		this.precio = precio;
		this.descripcion = descripcion;
		this.tiempoGarantia = tiempoGarantia;
		this.categoria = categoria;
		this.marca = marca;
	}



	public ProductoModel() {
		// TODO Auto-generated constructor stub
	}

}
