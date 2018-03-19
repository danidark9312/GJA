package com.gja.gestionCasos.casos.controller;

import java.util.List;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gja.gestionCasos.casos.entities.BienAfectado;
import com.gja.gestionCasos.casos.entities.Caso;
import com.gja.gestionCasos.casos.repository.BienAfectadoRepository;
import com.gja.gestionCasos.casos.service.BienAfectadoService;
import com.sf.util.BusinessException;
import com.sf.util.DAOException;

@Controller
@RequestMapping(value = {"/bienAfectado" }) 

public class BienAfectadoController {

	
	private static final Logger LOG = Logger.getLogger(BienAfectadoController.class);
	
	@Autowired
	BienAfectadoService bienAfectadoService;
	@RequestMapping()
	public String getCreateForm(Model model, Locale loc){
		return "/"; //carpeta y el jsp
	}
	
	@RequestMapping(value="/guardar",method = RequestMethod.POST,produces = "application/json; charset=utf-8") 
	public @ResponseBody String guardarBienAfectado(Caso caso)throws Exception{
		
		JSONObject res = new JSONObject();
		/*try
		{	
			
			bienesAfectados = bienAfectadoService.guardarBienAfectado(bienesAfectados);
			res.put("STATUS", "SUCCESS");
			
		} catch (DAOException e) {
			LOG.error("DAOException: Ocurrio un error guardando el caso . El error es: " + e.getMessage());
			res.put("STATUS", "ERROR");
		} catch (BusinessException e) {
			LOG.error("BusinessException: Ocurrio un error guardando el caso . El error es: " + e.getMessage());
			res.put("STATUS", "ERROR");
		
			
		}*/
		return res.toString();
	}
}
