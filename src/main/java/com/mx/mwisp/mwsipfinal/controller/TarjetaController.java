package com.mx.mwisp.mwsipfinal.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mx.mwisp.mwsipfinal.openpay.CargoTarjeta;
import com.mx.mwisp.mwsipfinal.service.impl.FormularioTarjeta;

@Controller
@RequestMapping("/form")
public class TarjetaController {
	CargoTarjeta cargorTarjeta=new CargoTarjeta();
	private static final Log LOG=LogFactory.getLog(TarjetaController.class);
	
	
	@GetMapping("/pagot")
	public String pagoConTarjeta(Model model) {		
		model.addAttribute("formCard", new FormularioTarjeta());
		return "card";
	}
	
	@PostMapping("/addCargoTarjeta")
	public ModelAndView agregarCargoTarjeta(@ModelAttribute("formCard") FormularioTarjeta formularioTarjeta) {
		LOG.info("valores del token============================================================="+formularioTarjeta.getTokenId());
		cargorTarjeta.cargoT(formularioTarjeta.getTokenId(), "card", 100, "MXM", "compra syscom", "1rvGhOGaFgPwNbrtefA4IwPZbMRjsQpe", formularioTarjeta.getClienteName(), "damian", "9581318869", "coco@gmail.com");
		ModelAndView mav=new ModelAndView("confirmarCompra");
		mav.addObject("formC",formularioTarjeta);
		return mav;
	}
	
	

}
