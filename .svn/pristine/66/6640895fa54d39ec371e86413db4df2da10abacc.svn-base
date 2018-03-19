package com.gja.gestionCasos.maestros.controller;

import java.util.List;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
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
import com.gja.gestionCasos.filters.TipoCasoFiltro;
import com.gja.gestionCasos.maestros.entities.Parentesco;
import com.gja.gestionCasos.maestros.entities.TipoCaso;
import com.gja.gestionCasos.maestros.service.MaestroActividadesService;
import com.gja.gestionCasos.maestros.service.MaestroTipoCasoService;
import com.gja.gestionCasos.maestros.service.TipoCasoService;
import com.sf.util.BusinessException;
import com.sf.util.DAOException;


@Controller
@RequestMapping(value = {"/maestroTipoCaso" }) 
public class MaestroTipoCasoController {

	private final String estadoExito = "SUCCESS";
	private final String estadoError = "ERROR";
	@Autowired
	MaestroActividadesService maestroActividadService;
	
	@Autowired
	TipoCasoService tipoCasoService;
	
	
	private static final Logger LOG = Logger.getLogger(MaestroTipoCasoController.class);

	@RequestMapping()
	public String getCreateForm(Model model, Locale loc){
		try {
			List<Actividad> actividades=maestroActividadService.obtenerActividades();
			model.addAttribute("actividades", actividades);
		} catch (DAOException e) {
			LOG.error("DAOException: Ocurrio un error consultando las Actividades . El error es: " + e.getMessage());
			e.printStackTrace();
		} catch (BusinessException e) {
			LOG.error("BusinessException: Ocurrio un error consultando las Actividades . El error es: " + e.getMessage());
			e.printStackTrace();
		}
		return "maestros/maestroTipoCaso"; //carpeta y el jsp
	}

	/*@SuppressWarnings("unchecked")
	@RequestMapping( value = "/eliminarTarea", method = RequestMethod.POST,produces = "application/json; charset=utf-8",consumes = "application/x-www-form-urlencoded; charset=UTF-8")
	public @ResponseBody String eliminarTarea(@ModelAttribute("tarea") Tarea tarea) {
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
	@RequestMapping( value = "/consultarTipoCaso", method = RequestMethod.POST,produces = "application/json; charset=utf-8",consumes = "application/x-www-form-urlencoded; charset=UTF-8")
	public @ResponseBody String consultarActividad(@ModelAttribute("tipoCaso") TipoCaso tipoCaso) {
		JSONObject res = new JSONObject();
			try {
				tipoCaso = tipoCasoService.findByPK(tipoCaso);
				JSONObject jsO = new JSONObject();
				
				res.put("codigo", tipoCaso.getCodigo());
				res.put("nombre", tipoCaso.getNombre());
				res.put("activo", tipoCaso.getActivo());
				
				JSONArray arrayActividades = new JSONArray();
			   for (ActividadTipoCaso actividad :tipoCaso.getActividadTipoCasoList()) {
					jsO = new JSONObject();
					jsO.put("cdactividadtipocaso", actividad.getCdactividadtipocaso());
					jsO.put("cdactividad", actividad.getCdactividad().getCdactividad());
					arrayActividades.add(jsO);
					
				}
				
 			   	res.put("actividadTipoCasoList", arrayActividades);
				
			} catch (DAOException e) {
				res = new JSONObject();
				LOG.error("DAOException: Ocurrio un error consultando la Actividad . El error es: " + e.getMessage());
				res.put("STATUS", estadoError);
			} catch (BusinessException e) {
				res = new JSONObject();
				LOG.error("BusinessException: Ocurrio un error consultando la  Actividad . El error es: " + e.getMessage());
				res.put("STATUS", estadoError);
			}
			return res.toString();
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping( value = "/eliminarTipoCaso", method = RequestMethod.POST,produces = "application/json; charset=utf-8",consumes = "application/x-www-form-urlencoded; charset=UTF-8")
	public @ResponseBody String eliminarTipoCaso(@ModelAttribute("tipoCaso") TipoCaso tipoCaso) {
			JSONObject res = new JSONObject();
			int retunValor = 0;
			try {
				retunValor = tipoCasoService.eliminarTipoCaso(tipoCaso);
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
	
	@RequestMapping(value = "/obtenerActividades", method=RequestMethod.GET,produces="aplication/json; charset=utf-8")
	public @ResponseBody String obtenerActividades(){
		List<Actividad> actividades = null;
		JSONObject res = new JSONObject();
			try {  
				JSONObject jsO = new JSONObject();
				actividades = maestroActividadService.obtenerActividades();
				JSONArray arrayActividades = new JSONArray();
			   List<Actividad> listActividad = actividades;
				for (Actividad actividad :actividades) {
					jsO = new JSONObject();
					if(actividad.getIsactivo().equals("S")){
						jsO.put("codigo", actividad.getCdactividad());
						jsO.put("nombre", actividad.getDsactividad());
						arrayActividades.add(jsO);
					}
				}
				
 			   	res.put("actividad", arrayActividades);
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

	
	@RequestMapping("/guardarTipoCaso")
	public @ResponseBody String guardar(@ModelAttribute("tipoCaso")TipoCaso tipoCaso) throws Exception {
		JSONObject res = new JSONObject();
		try {
			tipoCaso = tipoCasoService.guardarTipoCaso(tipoCaso);
			
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
	
	
	@RequestMapping("/canIsDeleteActividad")
	public @ResponseBody String guardar(@ModelAttribute("actividadTipoCaso")ActividadTipoCaso actividadTipoCaso) throws Exception {
		JSONObject res = new JSONObject();
		try {
			Long cantidad = tipoCasoService.getCountByActividad(actividadTipoCaso);
			if (cantidad.intValue()==0){
				res.put("STATUS", estadoExito);
			}else{
				res.put("STATUS", estadoError);
			}
			
			
		} catch (DAOException e) {
			LOG.error("DAOException: Ocurrio un error guardando las Actividades . El error es: " + e.getMessage());
			res.put("STATUS", estadoError);
		} catch (BusinessException e) {
			LOG.error("BusinessException: Ocurrio un error guardando las Actividades . El error es: " + e.getMessage());
			res.put("STATUS", estadoError);
		}
     return res.toString();
	}

	@RequestMapping(value = "/mostrarTiposCasos", method = RequestMethod.POST,produces = "application/json; charset=utf-8",consumes = "application/x-www-form-urlencoded; charset=UTF-8")
	public @ResponseBody String getAllTable(TipoCasoFiltro filtro, @RequestParam("activo") String activo, @RequestParam("iDisplayStart") int displayStart, @RequestParam("iDisplayLength") int displayLength,
			@RequestParam("sSearch") String sSearch,
			@RequestParam("iSortCol_0") int sortColumn0,
			@RequestParam("sSortDir_0") String sortDirection0,
			@RequestParam("sEcho") int sEcho) {
			int cantidad = 0;
			List<TipoCaso> tiposCasos=null;
			JSONObject res = new JSONObject();
			try {  
				JSONObject jsO = new JSONObject();
				cantidad=tipoCasoService.getCountFilter(filtro).intValue();
				tiposCasos = tipoCasoService.getTipoCasoByFilter(filtro);
				JSONArray arrayTiposCasos = new JSONArray();
			   List<TipoCaso> listActividad = tiposCasos;
				for (TipoCaso tipoCaso :tiposCasos) {
					jsO = new JSONObject();
						jsO.put("codigoTipoCaso", tipoCaso.getCodigo());
						jsO.put("nombreTipoCaso", tipoCaso.getNombre());
						jsO.put("papelera", "<a  data-toggle='modal' onclick='eliminarTipoCaso("+tipoCaso.getCodigo()+")' title='Eliminar'><i class='fa fa-bitbucket' style='color: red;'></i></a>");
						arrayTiposCasos.add(jsO);
				}
				res.put("sEcho", sEcho);
				res.put("iTotalRecords", cantidad);
				res.put("iTotalDisplayRecords", cantidad);
 			   	res.put("aaData", arrayTiposCasos);
				res.put("STATUS", estadoExito);
		   } catch (DAOException e) {
				res = new JSONObject();
				LOG.error("DAOException: Ocurrio un error consultando los tipos de casos . El error es: " + e.getMessage());
				res.put("STATUS", estadoError);
			} catch (BusinessException e) {
				res = new JSONObject();
				LOG.error("BusinessException: Ocurrio un error consultando los tipos de casos . El error es: " + e.getMessage());
				res.put("STATUS", estadoError);
			}
			return res.toJSONString();
			}
	
	@RequestMapping("/existNameTipoCaso")
	public @ResponseBody String existNameTipoCaso(@ModelAttribute("tipoCaso")TipoCaso tipoCaso) throws Exception {
		JSONObject res = new JSONObject();
		try {
			boolean existe = tipoCasoService.existNameTipoCaso(tipoCaso);
			if (existe){
				res.put("STATUS", estadoExito);
			}else{
				res.put("STATUS", estadoError);
			}
			
			
		} catch (DAOException e) {
			LOG.error("DAOException: Ocurrio un error consultando el tipo de caso por nombre . El error es: " + e.getMessage());
			res.put("STATUS", estadoError);
		} catch (BusinessException e) {
			LOG.error("BusinessException: Ocurrio un error consultando el tipo de caso por nombre . El error es: " + e.getMessage());
			res.put("STATUS", estadoError);
		}
     return res.toString();
	}

	
}
