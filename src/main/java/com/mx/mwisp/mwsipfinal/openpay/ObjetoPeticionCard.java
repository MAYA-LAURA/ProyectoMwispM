package com.mx.mwisp.mwsipfinal.openpay;

public class ObjetoPeticionCard {
	private String source_id;
	private String method;
	private float amount;
	private String currency;
	private String description;
	private String device_session_id;
	private ClienteOpenpay customer;
	
	
	public ObjetoPeticionCard(String source_id, String method, float amount, String currency, String description,
			String device_session_id, ClienteOpenpay customer) {
		super();
		this.source_id = source_id;
		this.method = method;
		this.amount = amount;
		this.currency = currency;
		this.description = description;
		this.device_session_id = device_session_id;
		this.customer = customer;
	}
	public ClienteOpenpay getCustomer() {
		return customer;
	}
	public void setCustomer(ClienteOpenpay customer) {
		this.customer = customer;
	}
	public String getSource_id() {
		return source_id;
	}
	public void setSource_id(String source_id) {
		this.source_id = source_id;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
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
	public String getDevice_session_id() {
		return device_session_id;
	}
	public void setDevice_session_id(String device_session_id) {
		this.device_session_id = device_session_id;
	}

}
