package com.mx.mwisp.mwsipfinal.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_Venta")
public class Ventas {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id_Venta")
	private int idVenta;

	@Column(name = "Folio")
	private String folio;

	@Column(name = "Monto_venta")
	private double montoVenta;

	@Column(name = "Fecha_Venta")
	private Date fechaVenta;

	@Column(name = "Forma_Pago")
	private String formaPago;

	@ManyToOne
	@JoinColumn(name = "Fk_Persona")
	private Persona persona;

	public Ventas() {
		// TODO Auto-generated constructor stub
	}

	public Ventas(double montoVenta, Date fechaVenta, String formaPago) {
		super();
		this.montoVenta = montoVenta;
		this.fechaVenta = fechaVenta;
		this.formaPago = formaPago;
	}

	public int getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}

	public String getFolio() {
		return folio;
	}

	public void setFolio(String folio) {
		this.folio = folio;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public double getMontoVenta() {
		return montoVenta;
	}

	public void setMontoVenta(double montoVenta) {
		this.montoVenta = montoVenta;
	}

	public Date getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public String getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}

	@Override
	public String toString() {
		return "Ventas [idVenta=" + idVenta + ", persona=" + persona + ", montoVenta=" + montoVenta + ", fechaVenta="
				+ fechaVenta + ", formaPago=" + formaPago + "]";
	}

}
