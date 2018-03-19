package com.gja.gestionCasos.clientes.controller;

import java.util.Locale;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = {"/cliente" }) 
public class ClienteController {

	private static final Logger LOG = Logger.getLogger(ClienteController.class);

	@RequestMapping()
	public String getCreateForm(Model model, Locale loc){
		return "clientes/cliente"; //carpeta y el jsp
	}
	
}
