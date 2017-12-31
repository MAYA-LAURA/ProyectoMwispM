package com.mx.mwisp.mwsipfinal.service;

import java.util.List;

import com.mx.mwisp.mwsipfinal.model.ClienteModelo;



public interface ClientesService {

	public List<ClienteModelo> listaClientes();
	public void insertarUsuario(ClienteModelo cliente);
	public void eliminarCliente(String id);
	public void prueba(ClienteModelo prueba);
}
