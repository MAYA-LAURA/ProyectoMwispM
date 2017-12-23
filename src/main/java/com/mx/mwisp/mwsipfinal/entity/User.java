package com.mx.mwisp.mwsipfinal.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



/**
 * @author jorge
 *
 */
@Entity
@Table(name="t_users")
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="Username")
	private String usuario;
	
	
	@Column(name="Password")
	private String pass;
	
	@Column(name="E_Mail",unique=true)
	private String mail;

	@OneToMany(fetch=FetchType.EAGER, mappedBy="user")
	private Set<UserRole> rol=new HashSet<UserRole>();

	public User(String usuario, String pass, String mail) {
		super();
		this.usuario = usuario;
		this.pass = pass;
		this.mail = mail;
	}

	public User(String usuario, String pass, String mail, Set<UserRole> rol) {
		super();
		this.usuario = usuario;
		this.pass = pass;
		this.mail = mail;
		this.rol = rol;
	}
	
	public User() {
		
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Set<UserRole> getRol() {
		return rol;
	}

	public void setRol(Set<UserRole> rol) {
		this.rol = rol;
	}
	
	
}
