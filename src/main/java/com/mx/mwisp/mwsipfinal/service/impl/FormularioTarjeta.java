package com.mx.mwisp.mwsipfinal.service.impl;

public class FormularioTarjeta {
	private String tokenId;
	private String metodo;
	private int monto;
	private String currency;
	private String descripcion;
	private String deviceId;
	private String clienteName;
	private String lastName;
	private String numberPhone;
	private String email;
	
	public FormularioTarjeta() {
		// TODO Auto-generated constructor stub
	}
	

	public FormularioTarjeta(String tokenId, String metodo, int monto, String currency, String descripcion,
			String deviceId, String clienteName, String lastName, String numberPhone, String email) {
		super();
		this.tokenId = tokenId;
		this.metodo = metodo;
		this.monto = monto;
		this.currency = currency;
		this.descripcion = descripcion;
		this.deviceId = deviceId;
		this.clienteName = clienteName;
		this.lastName = lastName;
		this.numberPhone = numberPhone;
		this.email = email;
	}


	public String getTokenId() {
		return tokenId;
	}

	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}

	public String getMetodo() {
		return metodo;
	}

	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}

	public int getMonto() {
		return monto;
	}

	public void setMonto(int monto) {
		this.monto = monto;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getClienteName() {
		return clienteName;
	}

	public void setClienteName(String clienteName) {
		this.clienteName = clienteName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNumberPhone() {
		return numberPhone;
	}

	public void setNumberPhone(String numberPhone) {
		this.numberPhone = numberPhone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
