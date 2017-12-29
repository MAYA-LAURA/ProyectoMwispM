package com.mx.mwisp.mwsipfinal.openpay;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;

public class CargoBanco {

	
public RespuestaPeticion cargoB (ObjPeticion objetoPeticion) {
	String url="https://sandbox-api.openpay.mx/v1/mexcviwsqt2snzeylcy5/charges";
	//try {		

	
		HttpAuthenticationFeature autentificacion = HttpAuthenticationFeature.basic("sk_baecf471d8cd4f3cad0528436d028236","");
		Client client = ClientBuilder.newClient();
		client.register(autentificacion);
		Response response = client.target(url).request()
		        .post(Entity.entity(objetoPeticion, MediaType.APPLICATION_JSON_TYPE));
		
		
		int status = response.getStatus();
	    //String salida=response.readEntity(String.class);
	    RespuestaPeticion respuestaPeticion=response.readEntity(RespuestaPeticion.class);
		System.out.println("Status code: " + status);
		System.out.println(respuestaPeticion.getId());
		return respuestaPeticion;
		
//cliente.addFilter(new HTTPBasicAuthFilter("sk_baecf471d8cd4f3cad0528436d028236",""));

//WebResource webResource= cliente.resource(url);

//String input ="{\"method\" : \""+metodo+"\",\r\n" + 
//		"   \"amount\" : "+monto+",\r\n" + 
//		"   \"currency\" : \"MXN\",\r\n" + 
//		"   \"description\" : \""+descripcion+"\",\r\n" +  
//		"   \"customer\" : {\r\n" + 
//		"        \"name\" : \""+clienteName+"\",\r\n" + 
//		"        \"last_name\" : \""+lastName+"\",\r\n" + 
//		"        \"phone_number\" : \""+numberPhone+"\",\r\n" + 
//		"        \"email\" : \""+email+"\"\r\n" + 
//		"   }\r\n" + 
//		"}";

//ClientResponse response = webResource.type("application/json")
  // .post(ClientResponse.class, obj);

//if (response.getStatus() != 200) {
//throw new RuntimeException("Failed : HTTP error code : "
//+ response.getStatus());
//}

//
//String output = response.getEntity(String.class);
//System.out.println("Output from Server .... \n");
//System.out.println(output);
//
//} catch (Exception e) {
//
//e.printStackTrace();
//
//}

	
}



}
