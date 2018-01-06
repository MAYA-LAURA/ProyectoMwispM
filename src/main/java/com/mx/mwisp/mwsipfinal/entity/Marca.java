package com.mx.mwisp.mwsipfinal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_marca")
public class Marca {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id_Marca")
	private int idMarca;
	
	@Column(name="Marca")
	private String marca;
	
	@Column(name="Descripcion")
	private String descripcion;

	public int getIdMarca() {
		return idMarca;
	}

	public void setIdMarca(int idMarca) {
		this.idMarca = idMarca;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	public Marca(String marca, String descripcion) {
		super();
		this.marca = marca;
		this.descripcion = descripcion;
	}

	public Marca() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Marca [idMarca=" + idMarca + ", marca=" + marca + ", descripcion=" + descripcion + "]";
	}
	
	

}
