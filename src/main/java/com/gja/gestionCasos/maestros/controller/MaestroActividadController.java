package com.gja.gestionCasos.maestros.controller;

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

import com.gja.gestionCasos.actividades.entities.Actividad;
import com.gja.gestionCasos.actividades.entities.ActividadTipoCaso;
import com.gja.gestionCasos.actividades.entities.TareaActividad;
import com.gja.gestionCasos.filters.ActividadFiltro;
import com.gja.gestionCasos.filters.CasoFiltro;
import com.gja.gestionCasos.filters.GeneralFilter;
import com.gja.gestionCasos.maestros.service.MaestroActividadesService;
import com.sf.util.BusinessException;
import com.sf.util.DAOException;


@Controller
@RequestMapping(value = {"/maestroActividad" }) 
public class MaestroActividadController {

	private final String estadoExito = "SUCCESS";
	private final String estadoError = "ERROR";
	@Autowired
	MaestroActividadesService maestroActividadService;
	
	private static final Logger LOG = Logger.getLogger(MaestroActividadController.class);

	@RequestMapping()
	public String getCreateForm(Model model, Locale loc){
		return "maestros/maestroActividad"; //carpeta y el jsp
	}

	/*@SuppressWarnings("unchecked")
	@RequestMapping( value = "/eliminarTarea", method = RequestMethod.POST,produces = "application/json; charset=utf-8",consumes = "application/x-www-form-urlencoded; charset=UTF-8")
	public @ResponseBody String eliminarTarea(@ModelAttribute("tarea") TareaActividad tarea) {
			JSONObject res = new JSONObject();
			try {
				int exito = maestroTareaService.eliminarTarea(tarea);
				if(exito == 1){
					res.put("STATUS", estadoExito);
				}else {
					res.put("STATUS", estadoError);
				}
					
					
				
			} catch (DAOException e) {
				res = new JSONObject();
				LOG.error("DAOException: Ocurrio un error consultando la Actividad . El error es: " + e.getMessage());
				res.put("STATUS", estadoError);
			} catch (BusinessException e) {
				res = new JSONObject();
				LOG.error("BusinessException: Ocurrio un error consultando la  Actividad . El error es: " + e.getMessage());
				res.put("STATUS", estadoError);
			}
			return res.toJSONString();
	}*/
	
	@SuppressWarnings("unchecked")
	@RequestMapping( value = "/consultarActividad", method = RequestMethod.POST,produces = "application/json; charset=utf-8",consumes = "application/x-www-form-urlencoded; charset=UTF-8")
	public @ResponseBody Actividad consultarActividad(@ModelAttribute("actividad") Actividad actividad) {
		JSONObject res = new JSONObject();
			try {
				List<Actividad> actividades=null;
				actividad = maestroActividadService.findByPK(actividad);
				/*JSONObject jsO = new JSONObject();
				JSONObject jsOActividad = new JSONObject();
				jsO.put("cdactividad", actividad.getCdactividad());
				jsO.put("dsactividad", actividad.getDsactividad());
				JSONArray arrayActividades = new JSONArray();
				   List<TareaActividad> listActividad = actividad.getTareaActividadList();
					for (TareaActividad objActividad :listActividad) {
						if(objActividad.getIsactivo().equals("S")){
							JSONObject jsO1 = new JSONObject();
							jsO.put("cdtareaactividad", objActividad.getCdtareaactividad());
							jsO.put("dsdetalle", objActividad.getDsdetalle());
							jsO.put("dstarea", objActividad.getDstarea());
							arrayActividades.add(jsO);
						}
						
					}
					
	 			   	res.put("actividad",arrayActividades);
					res.put("STATUS", estadoExito);*/
			} catch (DAOException e) {
				res = new JSONObject();
				LOG.error("DAOException: Ocurrio un error consultando la Actividad . El error es: " + e.getMessage());
				res.put("STATUS", estadoError);
			} catch (BusinessException e) {
				res = new JSONObject();
				LOG.error("BusinessException: Ocurrio un error consultando la  Actividad . El error es: " + e.getMessage());
				res.put("STATUS", estadoError);
			}
			//return res.toJSONString();
			return actividad;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping( value = "/eliminarActividad", method = RequestMethod.POST,produces = "application/json; charset=utf-8",consumes = "application/x-www-form-urlencoded; charset=UTF-8")
	public @ResponseBody String eliminarActividad(@ModelAttribute("actividad") Actividad actividad) {
			JSONObject res = new JSONObject();
			int retunValor = 0;
			try {
				actividad = maestroActividadService.findByPK(actividad);
				retunValor =maestroActividadService.eliminarActividades(actividad);
				if(retunValor == 1){
					res.put("STATUS", estadoExito);
				}else {
					res.put("STATUS", estadoError);
				}
			} catch (DAOException e) {
				res = new JSONObject();
				LOG.error("DAOException: Ocurrio un error eliminando la Actividad . El error es: " + e.getMessage());
				res.put("STATUS", estadoError);
			} catch (BusinessException e) {
				res = new JSONObject();
				LOG.error("BusinessException: Ocurrio un error eliminando la  Actividad . El error es: " + e.getMessage());
				res.put("STATUS", estadoError);
			}
			return res.toJSONString();
	}
	
	@RequestMapping(value = "/mostrarActividades", method = RequestMethod.POST,produces = "application/json; charset=utf-8",consumes = "application/x-www-form-urlencoded; charset=UTF-8")
	public @ResponseBody String getAllTable(ActividadFiltro filtro, @RequestParam("activo") String activo, @RequestParam("iDisplayStart") int displayStart, @RequestParam("iDisplayLength") int displayLength,
			@RequestParam("sSearch") String sSearch,
			@RequestParam("iSortCol_0") int sortColumn0,
			@RequestParam("sSortDir_0") String sortDirection0,
			@RequestParam("sEcho") int sEcho) {
			int cantidad = 0;
			List<Actividad> actividades=null;
			JSONObject res = new JSONObject();
			try {  
				JSONObject jsO = new JSONObject();
				cantidad=maestroActividadService.getCountFilter(filtro).intValue();
				actividades = maestroActividadService.getActividadByFilter(filtro);
				JSONArray arrayActividades = new JSONArray();
			   List<Actividad> listActividad = actividades;
				for (Actividad actividad :actividades) {
					jsO = new JSONObject();
						jsO.put("codigoActividad", actividad.getCdactividad());
						jsO.put("nombreActividad", actividad.getDsactividad());
						jsO.put("papelera", "<a  data-toggle='modal' onclick='eliminarActividad("+actividad.getCdactividad()+")' title='Eliminar'><i class='fa fa-bitbucket' style='color: red;'></i></a>");
						arrayActividades.add(jsO);
				}
				res.put("sEcho", sEcho);
				res.put("iTotalRecords", cantidad);
				res.put("iTotalDisplayRecords", cantidad);
 			   	res.put("aaData", arrayActividades);
				res.put("STATUS", estadoExito);
		   } catch (DAOException e) {
				res = new JSONObject();
				LOG.error("DAOException: Ocurrio un error consultando las Actividades . El error es: " + e.getMessage());
				res.put("STATUS", estadoError);
			} catch (BusinessException e) {
				res = new JSONObject();
				LOG.error("BusinessException: Ocurrio un error consultando las Actividades . El error es: " + e.getMessage());
				res.put("STATUS", estadoError);
			}
			return res.toJSONString();
			}

	
	@RequestMapping("/guardarActividad")
	public @ResponseBody String guardar(@ModelAttribute("actividad") Actividad actividad) throws Exception {
		JSONObject res = new JSONObject();
		try {
			actividad = maestroActividadService.guardarActividades(actividad);
			
			res.put("STATUS", estadoExito);
		} catch (DAOException e) {
			LOG.error("DAOException: Ocurrio un error guardando las Actividades . El error es: " + e.getMessage());
			res.put("STATUS", estadoError);
		} catch (BusinessException e) {
			LOG.error("BusinessException: Ocurrio un error guardando las Actividades . El error es: " + e.getMessage());
			res.put("STATUS", estadoError);
		}
     return res.toString();
	}
	
	@RequestMapping("/existNameActividad")
	public @ResponseBody String existNameActividad(@ModelAttribute("actividad")Actividad actividad) throws Exception {
		JSONObject res = new JSONObject();
		try {
			boolean existe = maestroActividadService.existNameActividad(actividad);
			if (existe){
				res.put("STATUS", estadoExito);
			}else{
				res.put("STATUS", estadoError);
			}
			
			
		} catch (DAOException e) {
			LOG.error("DAOException: Ocurrio un error consultando las actividades por nombre . El error es: " + e.getMessage());
			res.put("STATUS", estadoError);
		} catch (BusinessException e) {
			LOG.error("BusinessException: Ocurrio un error consultando las actividades por nombre . El error es: " + e.getMessage());
			res.put("STATUS", estadoError);
		}
     return res.toString();
	}

}
