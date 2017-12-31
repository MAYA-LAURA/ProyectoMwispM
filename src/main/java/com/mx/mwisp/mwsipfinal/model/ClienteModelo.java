package com.mx.mwisp.mwsipfinal.model;

import java.util.Date;

public class ClienteModelo {
	private String id;
	private String nombre;
	private String ip;
	private String fecha;
	private String plan;
	private Date diaCorte;
	private String sector;
	private String opcionActual;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getPlan() {
		return plan;
	}
	public void setPlan(String plan) {
		this.plan = plan;
	}
	public Date getDiaCorte() {
		return diaCorte;
	}
	public void setDiaCorte(Date diaCorte) {
		this.diaCorte = diaCorte;
	}
	public String getSector() {
		return sector;
	}
	public void setSector(String sector) {
		this.sector = sector;
	}
	public String getOpcionActual() {
		return opcionActual;
	}
	public void setOpcionActual(String opcionActual) {
		this.opcionActual = opcionActual;
	}
	

}
