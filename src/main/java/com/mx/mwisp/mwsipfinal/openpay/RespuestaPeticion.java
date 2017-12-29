package com.mx.mwisp.mwsipfinal.openpay;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RespuestaPeticion {
	private String id;
	private String authorization;
	private String operation_type;
	private String method;
	private String transaction_type;
	
	private MetodoPago payment_method;
	
	public MetodoPago getPayment_method() {
		return payment_method;
	}
	public void setPayment_method(MetodoPago payment_method) {
		this.payment_method = payment_method;
	}
	public String getTransaction_type() {
		return transaction_type;
	}
	public void setTransaction_type(String transaction_type) {
		this.transaction_type = transaction_type;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAuthorization() {
		return authorization;
	}
	public void setAuthorization(String authorization) {
		this.authorization = authorization;
	}
	public String getOperation_type() {
		return operation_type;
	}
	public void setOperation_type(String operation_type) {
		this.operation_type = operation_type;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}

}
