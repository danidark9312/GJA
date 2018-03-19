package com.gja.gestionCasos.casos.controller;

import java.util.List;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gja.gestionCasos.actividades.entities.ActividadCaso;
import com.gja.gestionCasos.actividades.service.ActividadCasoService;
import com.gja.gestionCasos.casos.entities.BienAfectado;
import com.gja.gestionCasos.casos.entities.Caso;
import com.gja.gestionCasos.casos.entities.Radicado;
import com.gja.gestionCasos.casos.service.CasoService;
import com.gja.gestionCasos.filters.CasoFiltro;
import com.sf.util.BusinessException;
import com.sf.util.DAOException;
import com.sf.util.Parametros;


@Controller
@RequestMapping(value = {"/detalleCaso" }) 
public class DetalleCasoController {
	
	private static final Logger LOG = Logger.getLogger(DetalleCasoController.class);
	private final String estadoExito = "SUCCESS";
	private final String estadoError = "ERROR";

	@Autowired
	CasoService casoService;

	@Autowired
	ActividadCasoService actividadCasoService;

	@RequestMapping()
	public String createForm(Model model, Locale loc,Caso caso){
		
		try {
				//caso.setCodigo(152);// comentar 
				caso = casoService.findByPK(caso);
				List<ActividadCaso> actividades= actividadCasoService.getActividadByCaso(caso.getCodigo());
				model.addAttribute("caso",caso!=null ? caso:"");
				model.addAttribute("actividades",actividades);
				model.addAttribute("aniosCaducidad", Parametros.getAnosCaducidad());
							
		} catch (DAOException e) {
			LOG.error("DAOException: Ocurrio un error consultando el caso . El error es: " + e.getMessage());
		} catch (BusinessException e) {
			LOG.error("BusinessException: Ocurrio un error consultando el caso . El error es: " + e.getMessage());
		}
		return "casos/detalleCaso"; //carpeta y el jsp
  
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping( value = "/consultarCaso", method = RequestMethod.POST,produces = "application/json; charset=utf-8",consumes = "application/x-www-form-urlencoded; charset=UTF-8")
	public @ResponseBody Caso consulta(@ModelAttribute("caso") Caso caso) {
			JSONObject res;
			try {
				caso = casoService.findByPK(caso);
				
//				res.put("STATUS", estadoExito);
			} catch (DAOException e) {
				res = new JSONObject();
				LOG.error("DAOException: Ocurrio un error consultando el caso . El error es: " + e.getMessage());
				res.put("STATUS", estadoError);
			} catch (BusinessException e) {
				res = new JSONObject();
				LOG.error("BusinessException: Ocurrio un error consultando el caso . El error es: " + e.getMessage());
				res.put("STATUS", estadoError);
			}
			return caso;
	}
	
	
	
	
	@RequestMapping(value = "/getAllTable", method = RequestMethod.POST,produces = "application/json; charset=utf-8",consumes = "application/x-www-form-urlencoded; charset=UTF-8")
	public @ResponseBody String getAllTable(CasoFiltro casoFiltro,Caso caso, @RequestParam("iDisplayStart") int displayStart, @RequestParam("iDisplayLength") int displayLength,
			@RequestParam("iSortCol_0") int sortColumn0,
			@RequestParam("sSortDir_0") String sortDirection0,
			@RequestParam("sEcho") int sEcho) {
			int cantidad = 0;
			JSONObject res = new JSONObject();
			JSONObject jsO = new JSONObject();
			JSONArray casos = new JSONArray();
			try {   
			   caso = casoService.findByPK(caso);
			   List<BienAfectado> listBienAfectado = caso.getBienAfectadoSet();
			   cantidad = listBienAfectado.size();
				for(BienAfectado objBienAfectado: listBienAfectado ){
					jsO = new JSONObject();
					jsO.put("tipoBienAfectdo", objBienAfectado.getClase().getNombre());
					jsO.put("detalleBienAfectado", objBienAfectado.getDetalle());
					jsO.put("tituloBienAfectado", objBienAfectado.getTitulo());
					casos.add(jsO);
				}	
				res.put("sEcho", sEcho);
				res.put("iTotalRecords", cantidad);
				res.put("iTotalDisplayRecords", cantidad);
 			   	res.put("aaData", casos);
				res.put("STATUS", estadoExito);
		   } catch (DAOException e) {
				res = new JSONObject();
				LOG.error("DAOException: Ocurrio un error consultando el caso . El error es: " + e.getMessage());
				res.put("STATUS", estadoError);
			} catch (BusinessException e) {
				res = new JSONObject();
				LOG.error("BusinessException: Ocurrio un error consultando el caso . El error es: " + e.getMessage());
				res.put("STATUS", estadoError);
			}
			return res.toJSONString();
			}
	
	
	
	@RequestMapping(value = "/getAllTableRadicado", method = RequestMethod.POST,produces = "application/json; charset=utf-8",consumes = "application/x-www-form-urlencoded; charset=UTF-8")
	public @ResponseBody String getAllTableRadicado(CasoFiltro casoFiltro,Caso caso, @RequestParam("iDisplayStart") int displayStart, @RequestParam("iDisplayLength") int displayLength,
			@RequestParam("iSortCol_0") int sortColumn0,
			@RequestParam("sSortDir_0") String sortDirection0,
			@RequestParam("sEcho") int sEcho) {
			int cantidad = 0;
			JSONObject res = new JSONObject();
			JSONObject jsO = new JSONObject();
			JSONArray casos = new JSONArray();
			try {   
			   caso = casoService.findByPK(caso);
				List<Radicado> listRadicado = caso.getRadicadoSet();
				 cantidad = listRadicado.size();
				for(Radicado objRadicado: listRadicado ){
					jsO = new JSONObject();
					jsO.put("estadoRadicado", objRadicado.getActivo() );
					jsO.put("codigoRadicado", objRadicado.getCodigo());
					jsO.put("instanciaRadicado", objRadicado.getInstancia().getNombre());	
					casos.add(jsO);
				}
				res.put("sEcho", sEcho);
				res.put("iTotalRecords", cantidad);
				res.put("iTotalDisplayRecords", cantidad);
 			   	res.put("aaData", casos);
				res.put("STATUS", estadoExito);
		   } catch (DAOException e) {
				res = new JSONObject();
				LOG.error("DAOException: Ocurrio un error consultando el caso . El error es: " + e.getMessage());
				res.put("STATUS", estadoError);
			} catch (BusinessException e) {
				res = new JSONObject();
				LOG.error("BusinessException: Ocurrio un error consultando el caso . El error es: " + e.getMessage());
				res.put("STATUS", estadoError);
			}
			return res.toJSONString();
			}
	
	
}
