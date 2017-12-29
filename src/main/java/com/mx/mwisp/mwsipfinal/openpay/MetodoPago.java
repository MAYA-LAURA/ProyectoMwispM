package com.mx.mwisp.mwsipfinal.openpay;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MetodoPago {
	private String type;
	private String reference;
	private String barcode_url;
	
public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getBarcode_url() {
		return barcode_url;
	}
	public void setBarcode_url(String barcode_url) {
		this.barcode_url = barcode_url;
	}

}
