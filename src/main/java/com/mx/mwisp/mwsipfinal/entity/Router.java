package com.mx.mwisp.mwsipfinal.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_Routers")
public class Router implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id_Router")
	private int id;
	
	@Column(name="Nombre")
	private String nombre;
	
	@Column(name="Ip_Dns")
	private String ipDns;
	
	@Column(name="Nombre_Usuario")
	private String nombreUser;
	
	@Column(name="Llave")
	private String llave;
	
	@Column(name="Ubicacion")
	private String ubicacion;
	
	private static final long serialVersionUID = 1L;
	
	
	
	public Router() {}
	
/*	public Router(int id) {
		this.id=id;
	}*/
	
	public Router(String nombre, String ipDns, String nombreUser, String llave, String ubicacion) {
		this.nombre = nombre;
		this.ipDns = ipDns;
		this.nombreUser = nombreUser;
		this.llave = llave;
		this.ubicacion = ubicacion;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getIpDns() {
		return ipDns;
	}
	public void setIpDns(String ipDns) {
		this.ipDns = ipDns;
	}
	public String getNombreUser() {
		return nombreUser;
	}
	public void setNombreUser(String nombreUser) {
		this.nombreUser = nombreUser;
	}
	public String getLlave() {
		return llave;
	}
	public void setLlave(String llave) {
		this.llave = llave;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	@Override
	public String toString() {
		return "Router [id=" + id + ", nombre=" + nombre + ", ipDns=" + ipDns + ", nombreUser=" + nombreUser
				+ ", llave=" + llave + ", ubicacion=" + ubicacion + "]";
	}

	
	/*public List<Router> getRouterList() {
		return routerList;
	}

	public void setRouterList(List<Router> routerList) {
		this.routerList = routerList;
	}*/

}
