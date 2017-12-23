package com.mx.mwisp.mwsipfinal.model;

public class AdminUser {
	private String usuarioAdmin;
	private String password;

	public String getUsuarioAdmin() {
		return usuarioAdmin;
	}

	public void setUsuarioAdmin(String usuarioAdmin) {
		this.usuarioAdmin = usuarioAdmin;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public AdminUser(String usuarioAdmin, String password) {
		super();
		this.usuarioAdmin = usuarioAdmin;
		this.password = password;
	}

	public AdminUser() {

	}

}
