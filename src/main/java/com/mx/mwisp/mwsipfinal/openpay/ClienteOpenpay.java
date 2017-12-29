package com.mx.mwisp.mwsipfinal.openpay;

public class ClienteOpenpay {
	private String name;
	private String last_name;
	private String phone_number;
	private String email;
	
	
	
	public ClienteOpenpay(String name, String last_name, String phone_number, String email) {
		super();
		this.name = name;
		this.last_name = last_name;
		this.phone_number = phone_number;
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "ClienteOpenpay [name=" + name + ", last_name=" + last_name + ", phone_number=" + phone_number
				+ ", email=" + email + "]";
	}

	

}
