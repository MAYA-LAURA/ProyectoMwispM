package com.mx.mwisp.mwsipfinal.model;

import org.springframework.web.multipart.MultipartFile;

import com.mx.mwisp.mwsipfinal.entity.Categoria;
import com.mx.mwisp.mwsipfinal.entity.Marca;

public class ProductoModel {
	private int  idProdcutos;
	private String nombreProducto;
	private String modelo;
	private float precio;
	private String descripcion;
	private String tiempoGarantia;
	private Categoria categoria;
	private Marca marca;
	//subir imagen
	private MultipartFile fileData;
	
	
	
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



	public MultipartFile getFileData() {
		return fileData;
	}



	public void setFileData(MultipartFile fileData) {
		this.fileData = fileData;
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
