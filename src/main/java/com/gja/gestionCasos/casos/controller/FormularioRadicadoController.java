package com.gja.gestionCasos.casos.controller;

import java.util.Locale;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping(value = {"/formularioRadicado" }) 
public class FormularioRadicadoController {
	
	private static final Logger LOG = Logger.getLogger(FormularioRadicadoController.class);

	@RequestMapping()
	public String getCreateForm(Model model, Locale loc){
		return "casos/formularioRadicado"; //carpeta y el jsp
	}


}
