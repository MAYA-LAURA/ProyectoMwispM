package com.mx.mwisp.mwsipfinal.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Jorge
 *
 */
@Entity
@Table(name = "user_roles")
public class UserRole implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id_Rol")
	private int id_rol;

	@Column(name = "Rol")
	private String rol;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Username")
	private User user;

	public UserRole(String rol, User user) {
		super();
		this.rol = rol;
		this.user = user;
	}

	public UserRole() {
		// TODO Auto-generated constructor stub
	}

	public int getId_rol() {
		return id_rol;
	}

	public void setId_rol(int id_rol) {
		this.id_rol = id_rol;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	

}
