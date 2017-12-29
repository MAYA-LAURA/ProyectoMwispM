package com.mx.mwisp.mwsipfinal.openpay;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;

public class CargoTarjeta {
	
	public void cargoT (ObjetoPeticionCard objetoPeticionCard) {
		String url = "https://sandbox-api.openpay.mx/v1/mexcviwsqt2snzeylcy5/charges";
		
		HttpAuthenticationFeature autentificacion = HttpAuthenticationFeature
				.basic("sk_baecf471d8cd4f3cad0528436d028236", "");
		Client client = ClientBuilder.newClient();
		client.register(autentificacion);
		Response response = client.target(url).request().post(Entity.entity(objetoPeticionCard, MediaType.APPLICATION_JSON_TYPE));
		int status = response.getStatus();
		String salida=response.readEntity(String.class);
		System.out.println(status);
		System.out.println(salida);
	}
	
	
}