package com.gja.gestionCasos.casos.controller;



import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import net.minidev.json.JSONArray;

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

import com.gja.gestionCasos.actividades.entities.Actividad;
import com.gja.gestionCasos.actividades.entities.ActividadCaso;
import com.gja.gestionCasos.actividades.entities.ActividadTipoCaso;
import com.gja.gestionCasos.actividades.entities.TareaParticularCaso;
import com.gja.gestionCasos.actividades.repository.ActividadCasoRepository;
import com.gja.gestionCasos.actividades.repository.ListaActividades;
import com.gja.gestionCasos.actividades.service.ActividadCasoService;
import com.gja.gestionCasos.casos.entities.Caso;
import com.gja.gestionCasos.casos.entities.CasoEquipoCaso;
import com.gja.gestionCasos.casos.entities.Celular;
import com.gja.gestionCasos.casos.entities.Correo;
import com.gja.gestionCasos.casos.entities.Prestamo;
import com.gja.gestionCasos.casos.entities.ListaPrestamos;
import com.gja.gestionCasos.casos.entities.Radicado;
import com.gja.gestionCasos.casos.entities.Telefono;
import com.gja.gestionCasos.casos.service.CasoService;
import com.gja.gestionCasos.filters.CasoFiltro;
import com.gja.gestionCasos.maestros.entities.TipoCaso;
import com.sf.util.BusinessException;
import com.sf.util.DAOException;
import com.sf.util.Parametros;


@Controller
@RequestMapping(value = {"/caso" }) 
public class CasoController {
	
	private static final Logger LOG = Logger.getLogger(CasoController.class);
	private final String errorMessage= "ERROR";
	
	private final String estadoExito = "SUCCESS";
	private final String estadoError = "ERROR";
	
	@Autowired
	CasoService casoService;
	@Autowired
	ActividadCasoService actividadCasoService;
	

	@RequestMapping()
	public String getCreateForm(Model model, Locale loc) {
		model.addAttribute("aniosCaducidad", Parametros.getAnosCaducidad());
		return "casos/caso"; //carpeta y el jsp
	}
	
	@RequestMapping("/guardar")
	//public @ResponseBody String guardar(@ModelAttribute("caso") Caso caso,ActividadCaso actividadCaso) throws Exception 
	//public @ResponseBody String guardar(@ModelAttribute("caso") Caso caso, ListaPrestamos prestamos,ListaActividades listaActividadDelCaso) throws Exception{	
	public @ResponseBody String guardar(@ModelAttribute("caso") Caso caso, ListaPrestamos prestamos) throws Exception{
		JSONObject res = new JSONObject();
		try {
			caso = casoService.guardarCaso(caso,prestamos);
			JSONArray codigosResponsables= casoService.obtenerCodigoEquipo(caso);
			JSONObject jsO = new JSONObject();
			jsO.put("codigoCaso",caso.getCodigo());
			codigosResponsables.add(jsO);
			res.put("equipoCaso", codigosResponsables);
			
			
		//	for(ActividadCaso actividad:listaActividadDelCaso.getListaActividadesCaso()){
				
				//casoService.obtenerCodigoEquipo(caso);
		//	}
			 //caso = casoService.guardarCaso(caso);
//			JSONObject jsO = new JSONObject();
//			JSONArray casos = new JSONArray();
//			jsO.put("codigo",caso.getCodigo());
//			casos.add(jsO);
			//res.put("STATUS", "SUCCESS");
		} catch (DAOException e) {
			LOG.error("DAOException: Ocurrio un error guardando el caso . El error es: " + e.getMessage());
			res.put("STATUS", errorMessage);
		} catch (BusinessException e) {
			LOG.error("BusinessException: Ocurrio un error guardando el caso . El error es: " + e.getMessage());
			res.put("STATUS", errorMessage);
		}
     return res.toString();
	}
	@RequestMapping("/guardarActividades")
	//public @ResponseBody String guardarActividades(@ModelAttribute("ActividadCaso")ActividadCaso actividadDelCaso) throws Exception
	public @ResponseBody String guardarActividades(@ModelAttribute("ListaActividades")ListaActividades listaActividadDelCaso) throws Exception
	{
		JSONObject res = new JSONObject();
		try{
			for(ActividadCaso actividadDelCaso:listaActividadDelCaso.getListaActividadesCaso()){
				actividadDelCaso=actividadCasoService.guardarActividadCaso(actividadDelCaso);
			}
			res.put("STATUS", "SUCCESS");
		} catch (DAOException e) {
			LOG.error("DAOException: Ocurrio un error guardando el caso . El error es: " + e.getMessage());
			res.put("STATUS", errorMessage);
		} catch (BusinessException e) {
			LOG.error("BusinessException: Ocurrio un error guardando el caso . El error es: " + e.getMessage());
			res.put("STATUS", errorMessage);
		}
			return res.toString();
		}
	
	@RequestMapping(value = "/mostrarCasos", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public @ResponseBody String filtrarCasos(CasoFiltro casoFiltro, @RequestParam("iDisplayStart") int displayStart,
			@RequestParam("iDisplayLength") int displayLength, @RequestParam("iSortCol_0") int sortColumn0,
			@RequestParam("sSortDir_0") String sortDirection0, @RequestParam("sEcho") int sEcho)
	{

		SimpleDateFormat formatoFecha=new	SimpleDateFormat("dd/MM/yyyy");
		List<Caso> casosFiltrados=null;
		String accion=null;
		JSONObject res = new JSONObject();
		casosFiltrados=casoService.encontrarCasoPorFiltro(casoFiltro);
		Long cantidad=casoService.getCountFilter(casoFiltro);
		JSONObject jsO = new JSONObject();
		JSONArray arrayCasosFiltrados = new JSONArray();
		for (Caso caso:casosFiltrados) {
			accion ="";
			jsO = new JSONObject();
			jsO.put("codigo", caso.getCodigo());
			jsO.put("nombre",caso.getNombre());
			jsO.put("estadoCaso",caso.getEstadoCaso().getNombre());
			jsO.put("tipoCaso",caso.getTipoCaso().getNombre());
			 
			//inicio tabla radicados
			List<Radicado> radicados=caso.getRadicadoSet();
			String tabla = "<table>";
			if (radicados != null && !radicados.isEmpty()) {
					tabla = tabla + "<tr>";
		        	tabla = tabla + "<th>Numero de Radicado &nbsp;&nbsp;&nbsp;&nbsp;</th>";
		        	tabla = tabla + "<th>Instancia &nbsp;&nbsp;&nbsp;&nbsp;</th>";
		        	tabla = tabla + "<th>Es acumulado &nbsp;&nbsp;&nbsp;&nbsp;</th>";
		        	tabla = tabla + "</tr>";
		        
		        for (Radicado radicado : radicados) {
		        	tabla = tabla + "<tr>";
			        tabla = tabla + "<td>" + radicado.getCodigo() + "&nbsp;&nbsp;&nbsp;&nbsp;" + "</td>";
			        tabla = tabla + "<td>" + radicado.getInstancia().getNombre() + "&nbsp;&nbsp;&nbsp;&nbsp;" + "</td>";
			        tabla = tabla + "<td>" + radicado.getAcumulado() + "&nbsp;&nbsp;&nbsp;&nbsp;" + "</td>";
			        tabla = tabla + "</tr>";
		        		        	
		        }
		      }else{
	        	tabla = tabla + "<tr>";
	   	        tabla = tabla + "<th>El caso no tiene radicados &nbsp;&nbsp;&nbsp;&nbsp;</th>";
	   	        tabla = tabla + "</tr>";
	        }
	        tabla = tabla + "</table>";
	        jsO.put("detalle", tabla);
	        accion = accion + "<SPAN title='Ver detalles'><a name='verDetalle'><i  id='verDetalle' class='glyphicon glyphicon-chevron-down'></i></a></SPAN>";
	        jsO.put("accion", accion);
	        //fin tabla radicados e inicio tabla equipo del caso
	        List<CasoEquipoCaso> casosEquipoCaso = caso.getCasoEquipoCasoSet();
	        tabla = "<table>";
	        Calendar calendario=Calendar.getInstance();
	        Long fechaLimite=calendario.getTimeInMillis()-(24*60*60*1000);
	        Long  fechaVencimiento = null;
	        String responsable=null;
	        String detalle=null;
	        String estado=null;
	        if(casosEquipoCaso!=null && !casosEquipoCaso.isEmpty()){
		        tabla = tabla + "<tr>";
		        tabla = tabla + "<th style='width:20%'>Nombre &nbsp;&nbsp;&nbsp;&nbsp;</th>";
		        //tabla = tabla + "<th>Apellidos &nbsp;&nbsp;&nbsp;&nbsp;</th>";
		        tabla = tabla + "<th style='width:20%'>Tipo de Miembro &nbsp;&nbsp;&nbsp;&nbsp;</th>";
		        tabla = tabla + "<th style='width:20%'>Telefonos &nbsp;&nbsp;&nbsp;&nbsp;</th>";
		        tabla = tabla + "<th style='width:20%'>Celulares &nbsp;&nbsp;&nbsp;&nbsp;</th>";
		        tabla = tabla + "<th style='width:20%'>Correo &nbsp;&nbsp;&nbsp;&nbsp;</th>";
		        tabla = tabla + "</tr>";
		       // List<CasoEquipoCaso> casosEquipoCaso=caso.getCasoEquipoCasoSet();
			        for (CasoEquipoCaso casoEquipoCaso : casosEquipoCaso) {
			        	
			        	tabla = tabla + "<tr>";
				        	if (casoEquipoCaso.getEquipoCaso().getApellido() != null) {
				        		
				        		tabla = tabla + "<td>" + casoEquipoCaso.getEquipoCaso().getNombre() + "&nbsp;&nbsp;" +casoEquipoCaso.getEquipoCaso().getApellido()+"&nbsp;&nbsp;&nbsp;&nbsp;" + "</td>";
				        	} else {
				        		tabla = tabla + "<td>" + casoEquipoCaso.getEquipoCaso().getNombre() +"&nbsp;&nbsp;&nbsp;&nbsp;" + "</td>";
				        	}
				        	
				        //tabla = tabla + "<td>" + casoEquipoCaso.getEquipoCaso().getApellido() + "&nbsp;&nbsp;&nbsp;&nbsp;" + "</td>";
				        tabla = tabla + "<td>" + casoEquipoCaso.getTipoMiembro().getNombre() + "&nbsp;&nbsp;&nbsp;&nbsp;" + "</td>";
				        //List<Telefono> telefonos = casoEquipoCaso.getEquipoCaso().getTelefonoList();
				        
				        //se muestran los telefonos del miembro del equipo
				        List<Telefono> telefonos = casoEquipoCaso.getEquipoCaso().getTelefonoList();
					        if(telefonos!=null && telefonos.size()>0){
						        
					        	String numerosTelefonos="";
					        	for(Telefono telefono:telefonos) {
					        		numerosTelefonos+=telefono.getNumero()+", ";
					        		}	
						         tabla = tabla + "<td>" + numerosTelefonos+ "&nbsp;&nbsp;&nbsp;&nbsp;" + "</td>";
						        
					        }else{
					        	tabla = tabla + "<td>" +"&nbsp;&nbsp;&nbsp;&nbsp;" + "</td>";
					        	
					        }
				        
				        //se muestran los Celulares del miembro del equipo
				        List<Celular> celulares=casoEquipoCaso.getEquipoCaso().getCelularList();
					        if(celulares!=null && celulares.size()>0){
						        
					        	String numerosCelular="";
					        	for(Celular celular:celulares) {
					        		numerosCelular+=celular.getNumero()+", ";
					        		}	
						       tabla = tabla + "<td>" + numerosCelular+ "&nbsp;&nbsp;&nbsp;&nbsp;" + "</td>";
						        
					        }else{
					        	
					        	tabla = tabla + "<td>" +"&nbsp;&nbsp;&nbsp;&nbsp;" + "</td>";
					        }
				        
				      //se muestran los Correos  del miembro del equipo
				        
				        List<Correo> correos=casoEquipoCaso.getEquipoCaso().getCorreoList();
					        if (correos != null && correos.size() > 0) {
						        
					           String correosElectronicos="";
					        	for(Correo correo:correos) {
					        		correosElectronicos+=correo.getCorreo()+", ";
					        		}	
						        tabla = tabla + "<td>" + correosElectronicos+ "&nbsp;&nbsp;&nbsp;&nbsp;" + "</td>";
						        
					        }else{
					        	
					        	 tabla = tabla + "<td>" + "&nbsp;&nbsp;&nbsp;&nbsp;" + "</td>";
					        }
				        
				        tabla = tabla + "</tr>";
				        
					        for (TareaParticularCaso tarea:casoEquipoCaso.getTareaParticularCasoSet()) {
				        		if(fechaVencimiento==null  && tarea.getFechaLimite().getTime()>fechaLimite){
				        			fechaVencimiento=tarea.getFechaLimite().getTime();
				        		}
					        	
					        	if(tarea.getFechaLimite().getTime()>fechaLimite && tarea.getFechaLimite().getTime()<=fechaVencimiento){
					        		
					        		fechaVencimiento=tarea.getFechaLimite().getTime();
					        		detalle=tarea.getDetalle();
					        		responsable=casoEquipoCaso.getEquipoCaso().getNombre();
					        		estado=tarea.getFinalizada();
					        		
					        		
					        	}
			        	    }
			        }
		    } 
	        else {
	        	tabla = tabla + "<tr>";
	   	        tabla = tabla + "<th>El caso no tiene miembros &nbsp;&nbsp;&nbsp;&nbsp;</th>";
	   	        tabla = tabla + "</tr>";
	        	
	        }
	        tabla = tabla + "</table>";
	        jsO.put("detalleEquipoCaso", tabla);
	        accion ="";
	        accion = accion + "<SPAN title='Ver detalles'><a name='verDetalleEquipoCaso'><i  id='verDetalle' class='glyphicon glyphicon-chevron-down'></i></a></SPAN>";
	        jsO.put("accionEquipo", accion);
						
	        /////
	        
	        tabla = "<table>";
	        tabla = tabla + "<tr>";
	        tabla = tabla + "<th>Tarea &nbsp;&nbsp;&nbsp;&nbsp;</th>";
	        //tabla = tabla + "<th>Apellidos &nbsp;&nbsp;&nbsp;&nbsp;</th>";
	        tabla = tabla + "<th>Responsable &nbsp;&nbsp;&nbsp;&nbsp;</th>";
	        tabla = tabla + "<th>Fecha de Vencimiento &nbsp;&nbsp;&nbsp;&nbsp;</th>";
	        tabla = tabla + "<th>Finalizada &nbsp;&nbsp;&nbsp;&nbsp;</th>";
	        if(responsable!=null){
		        //tabla = tabla + "</tr>";
	        	//if(fechaLimite.after(new Date())){
	        	Date fecha = new Date(fechaVencimiento);
		        tabla = tabla + "<tr>";
		        tabla = tabla + "<td>" + detalle + "&nbsp;&nbsp;&nbsp;&nbsp;" + "</td>";
		        tabla = tabla + "<td>" + responsable+ "&nbsp;&nbsp;&nbsp;&nbsp;" + "</td>";
		        tabla = tabla + "<td>" + formatoFecha.format(fecha)+ "&nbsp;&nbsp;&nbsp;&nbsp;" + "</td>";
		        tabla = tabla + "<td>" + estado+ "&nbsp;&nbsp;&nbsp;&nbsp;" + "</td>";
		        tabla = tabla + "</tr>";
		       // }else{
//		        	tabla = tabla + "<tr>";
//			        tabla = tabla + "<td> El caso no tiene tareas proximas a vencer &nbsp;&nbsp;&nbsp;&nbsp;" + "</td>";
//			        tabla = tabla + "</tr>";
		    //    }
	        }
	        else{
	        	tabla = tabla + "<tr>";
		        tabla = tabla + "<td> El caso no tiene tareas  proximas a vencerse &nbsp;&nbsp;&nbsp;&nbsp;" + "</td>";
		        tabla = tabla + "</tr>";
	        	
	        }
	        jsO.put("detalleTarea", tabla); 
	        tabla = tabla + "</table>"; 
	        
	        accion ="";
	        accion = accion + "<SPAN title='Ver detalles'><a name='verDetalleTarea'><i  id='verDetalle' class='glyphicon glyphicon-chevron-down'></i></a></SPAN>";
	        jsO.put("accionDetalleTarea", accion);
	        
	        
			// fin tabla
			
			arrayCasosFiltrados.add(jsO);
		}
				
		  res.put("sEcho", Integer.valueOf(sEcho));
	      res.put("iTotalRecords", cantidad);
	      res.put("iTotalDisplayRecords", cantidad);
	      res.put("aaData", arrayCasosFiltrados);
		
	      return res.toString();
		
	}
	
	@RequestMapping("/canIsDeleteTipoCaso")
	public @ResponseBody String guardar(@ModelAttribute("tipoCaso")TipoCaso tipoCaso) throws Exception {
		JSONObject res = new JSONObject();
		try {
			Long cantidad = casoService.getCountByTipoCasoCaso(tipoCaso);
			if (cantidad.intValue()==0){
				res.put("STATUS", estadoExito);
			}else{
				res.put("STATUS", estadoError);
			}
			
			
		} catch (DAOException e) {
			LOG.error("DAOException: Ocurrio un error validando si se puede eliminar el tipo de caso . El error es: " + e.getMessage());
			res.put("STATUS", estadoError);
		} catch (BusinessException e) {
			LOG.error("BusinessException: Ocurrio un error validando si se puede eliminar el tipo de caso . El error es: " + e.getMessage());
			res.put("STATUS", estadoError);
		}
     return res.toString();
	}
	
}
