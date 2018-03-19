package com.gja.gestionCasos.casos.controller;

import java.util.Locale;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import com.sf.util.Parametros;

@Controller
@RequestMapping(value = {"/visorCaso" }) 

public class VisorCasoController {
	
	private static final Logger LOG = Logger.getLogger(VisorCasoController.class);

	@RequestMapping()
	public String getCreateForm(Model model, Locale loc){
		model.addAttribute("aniosCaducidad", Parametros.getAnosCaducidad());
		return "casos/visorCaso"; //carpeta y el jsp
	}
	
	
	
	
	
}

