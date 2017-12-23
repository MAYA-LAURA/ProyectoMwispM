package com.mx.mwisp.mwsipfinal.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	private static final Log LOG = LogFactory.getLog(LoginController.class);



	@GetMapping("/login")
	public String verLoginForm(Model model, @RequestParam(name = "error", required = false) String error,
			@RequestParam(name = "logout", required = false) String logout) {
		model.addAttribute("logout", logout);
		model.addAttribute("error", error);
		return "login";
	}

	@GetMapping({ "/loginsuccess", "/" })
	public String loginCheck() {
		LOG.info("Metodo: loginCheck");
		return "redirect:/Admin/listaProductosAdmin";

	}

}
