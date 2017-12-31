package com.mx.mwisp.mwsipfinal.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mx.mwisp.mwsipfinal.entity.Router;
import com.mx.mwisp.mwsipfinal.model.ClienteModelo;
import com.mx.mwisp.mwsipfinal.service.ClientesService;
import com.mx.mwisp.mwsipfinal.service.RouterService;

import me.legrange.mikrotik.ApiConnection;
import me.legrange.mikrotik.MikrotikApiException;


@Service("clienteServiceImpl")
public class ClientesServiceImpl implements ClientesService {
	@Autowired
	@Qualifier("routerServiceImpl")
	RouterService routerServiceImpl;
	

	@Override
	public List<ClienteModelo> listaClientes() {
		ApiConnection con;
		List<Map<String, String>> rs;
		try {
			 //con=ApiConnection.connect("mercadowispmexico.dyndns.org"); //ROUTER MIGUEL
//			for (int i = 0; i <= routerDaoImpl.routerList().size(); i++) {
				con = ApiConnection.connect("10.1.3.1");
				con.login("admin","");
				//con.login("sistema","isc2017");// ROUTER MIGUEL
				// rs = con.execute("/ip/firewall/address-list/print where list=1-MOROSO");
				rs = con.execute("/ip/firewall/address-list/print where comment!=null");
				List<ClienteModelo> listClientes = new ArrayList<ClienteModelo>();
				for (Map<String, String> map : rs) {
					ClienteModelo clientes = new ClienteModelo();
					clientes.setId(map.get(".id") != null ? map.get(".id") : null);
					clientes.setNombre(map.get("comment") != null ? map.get("comment") : null);
					clientes.setIp(map.get("address") != null ? map.get("address") : null);
					clientes.setFecha(map.get("creation-time") != null ? map.get("creation-time") : null);
					clientes.setPlan(map.get("list") != null ? map.get("list") : null);
					listClientes.add(clientes);
				}
				con.close();
			//}
			return listClientes;
			
		} catch (MikrotikApiException e) {
			e.printStackTrace();

			return null;
		}
	}

	@Override
	public void insertarUsuario(ClienteModelo cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarCliente(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void prueba(ClienteModelo prueba) {
		Router router=new Router();
		int id=Integer.parseInt(prueba.getOpcionActual());
		router=routerServiceImpl.buscarRouterPorId(id);
		String ip=router.getIpDns();
		String Usuario=router.getNombreUser();
		String password=router.getLlave();
		System.out.println("Ip: "+ip+" user: "+ Usuario+" contraseña: "+password);
		
		
		
	}

}
