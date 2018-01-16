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
	
	@Column(name="Modelo")
	private String modelo;
	
	@Column(name="Precio")
	private double precio;
	
	@Column(name="Descripcion")
	private String descripcion;
	
	@Column(name="Tiempo_Garantia")
	private String tiempoGarantia;
	
	@Column(name="Pdf")
	private String pdf;
	
	@Column(name="Imagen1")
	private String imagen1;
	
	@Column(name="Imagen2")
	private String imagen2;
	

	@ManyToOne
	@JoinColumn(name="Fk_Categoria")
	private Categoria categoria;
	
	@ManyToOne
	@JoinColumn(name="Fk_Marca")
	private Marca marca;
	
	public Productos() {
		// TODO Auto-generated constructor stub
	}

	
	
	public Productos(String nombreProducto, String modelo, float precio, String descripcion, String tiempoGarantia,
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




	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
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
	

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}



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



	public String getPdf() {
		return pdf;
	}



	public void setPdf(String pdf) {
		this.pdf = pdf;
	}

	

	
	
	
	
	
}
