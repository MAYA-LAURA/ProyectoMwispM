package com.mx.mwisp.mwsipfinal.openpay;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class ObjPeticion {
	private String method;
	private int amount;
	private String currency;
	private String description;
	private ClienteOpenpay customer;
	
	
	public ObjPeticion(String method, int amount, String currency, String description, ClienteOpenpay customer) {
		super();
		this.method = method;
		this.amount = amount;
		this.currency = currency;
		this.description = description;
		this.customer = customer;
	}
	
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ClienteOpenpay getCustomer() {
		return customer;
	}
	public void setCustomer(ClienteOpenpay customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "ObjPeticion [method=" + method + ", amount=" + amount + ", currency=" + currency + ", description="
				+ description + ", customer=" + customer + "]";
	}
	
	
	

}
