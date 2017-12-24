package com.mx.mwisp.mwsipfinal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControllerIndex {
	private static final String principal="index";
	@GetMapping ({"/index","/"})
	public ModelAndView vistaIndex() {
		ModelAndView mav=new ModelAndView (principal);
		return mav;
				}
	//commit

}
