package com.gja.gestionCasos.maestros.controller;

import java.util.List;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gja.gestionCasos.actividades.entities.ActividadTipoCaso;
import com.gja.gestionCasos.actividades.entities.TareaActividad;
import com.gja.gestionCasos.actividades.service.ActividadCasoService;
import com.gja.gestionCasos.casos.controller.VisorCasoController;
import com.gja.gestionCasos.casos.service.EquipoCasoService;
import com.gja.gestionCasos.maestros.entities.Ciudad;
import com.gja.gestionCasos.maestros.entities.ClaseBien;
import com.gja.gestionCasos.maestros.entities.Departamento;
import com.gja.gestionCasos.maestros.entities.EntidadFinanciera;
import com.gja.gestionCasos.maestros.entities.EstadoCaso;
import com.gja.gestionCasos.maestros.entities.Instancia;
import com.gja.gestionCasos.maestros.entities.Pais;
import com.gja.gestionCasos.maestros.entities.Parentesco;
import com.gja.gestionCasos.maestros.entities.TipoCaso;
import com.gja.gestionCasos.maestros.entities.TipoMiembro;
import com.gja.gestionCasos.maestros.repository.InstanciaRepository;
import com.gja.gestionCasos.maestros.service.CiudadService;
import com.gja.gestionCasos.maestros.service.ClaseBienService;
import com.gja.gestionCasos.maestros.service.ClaseBienServiceImpl;
import com.gja.gestionCasos.maestros.service.DepartamentoService;
import com.gja.gestionCasos.maestros.service.EntidadFinancieraService;
import com.gja.gestionCasos.maestros.service.EstadoCasoService;
import com.gja.gestionCasos.maestros.service.InstanciaService;
import com.gja.gestionCasos.maestros.service.PaisService;
import com.gja.gestionCasos.maestros.service.ParentescoService;
import com.gja.gestionCasos.maestros.service.TipoCasoService;
import com.gja.gestionCasos.maestros.service.TipoMiembroService;
import com.sf.social.signinmvc.user.model.User;
import com.sf.util.BusinessException;
import com.sf.util.DAOException;
import com.sf.util.Parametros;


@Controller
@RequestMapping(value = {"/maestro" }) 
public class MaestroController {


	@Autowired
	PaisService paisService;
	@Autowired
	DepartamentoService departamentoService;
	@Autowired
	CiudadService ciudadService;
	@Autowired
	TipoCasoService tipoCasoService;
	@Autowired
	EstadoCasoService estadoCasoService;
	@Autowired
	ClaseBienService claseBienService;
	@Autowired
	InstanciaService instanciaService;
	@Autowired
	TipoMiembroService tipoMiembroService;
	@Autowired
	ParentescoService parentescoService; 
	@Autowired
	EquipoCasoService equipoCasoService;
	@Autowired
	EntidadFinancieraService entidadFinancieraService;
	@Autowired
	ActividadCasoService actividadCasoService;
	
	private static final Logger LOG = Logger.getLogger(MaestroController.class);

	@RequestMapping()
	public String getCreateForm(Model model, Locale loc){
		return "/"; //carpeta y el jsp
	}
   // metodo para cargar los abogados del caso el select
	@RequestMapping(value="/obtenerAbogados",method=RequestMethod.GET,produces="aplication/json; charset=utf-8")
	public @ResponseBody String obtenerAbogados()
	{
		List<User> abogados=null;
		JSONObject res = new JSONObject();
		try {
			JSONObject jsO = new JSONObject();
			abogados = equipoCasoService.obtenerAbogados();
			JSONArray arrayAbogados = new JSONArray();
			for (User abogado:abogados) {
				jsO = new JSONObject();
				jsO.put("codigo", abogado.getId());
				jsO.put("nombre", abogado.getNombre()+" "+ abogado.getApellido());
				arrayAbogados.add(jsO);
			}
			res.put("abogados", arrayAbogados);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return res.toString(); 
	}
	
	//metodo para mostrar los abagados seleccionados
	@RequestMapping(value="/obtenerAbogadosSeleccionados",method=RequestMethod.GET,produces="aplication/json; charset=utf-8")
	public @ResponseBody String obtenerAbogadosSeleccionados(@RequestParam("codigoAbogadoSeleccionado") String codigoAbogadoSeleccionado)
	{
		List<User> abogados=null;
		JSONObject res = new JSONObject();
		try {
			JSONObject jsO = new JSONObject();
			abogados = equipoCasoService.obtenerAbogadosSeleccionados(codigoAbogadoSeleccionado);
			JSONArray arrayAbogados = new JSONArray();
			for (User abogado:abogados) {
				jsO = new JSONObject();
				jsO.put("codigo", abogado.getId());
				jsO.put("nombre", abogado.getNombre()+" "+ abogado.getApellido());
				jsO.put("correo",abogado.getEmail());
				jsO.put("telefono",abogado.getNumeroTelefono());
				jsO.put("tarjetaProfesional",abogado.getNumeroTarjetaProfesional());
				jsO.put("direccion",abogado.getDireccion());
//				jsO.put("tarjetaProfesional",abogado.);
//				jsO.put("numeroTelefono",abogado.);
				arrayAbogados.add(jsO);
			}
			res.put("abogados", arrayAbogados);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return res.toString(); 
	}
	//Metodo para Obtener las actividades por tipo de  Caso
	@RequestMapping(value="/obtenerActividadesTipoCaso",method=RequestMethod.GET,produces="aplication/json; charset=utf-8")
	public @ResponseBody String obtenerActividadesTipoCaso(@RequestParam("codigoTipoCaso") Integer codigoTipoCasoSeleccionado)
	{
		List<ActividadTipoCaso> actividadesTipoCaso=null;
		JSONObject res = new JSONObject();
		try {
			JSONObject jsO = new JSONObject();
			JSONObject jsOTareas = new JSONObject();
			actividadesTipoCaso = actividadCasoService.obtenerActividadesTipoCaso(codigoTipoCasoSeleccionado);
			JSONArray arrayActividadesTipoCaso = new JSONArray();
			for (ActividadTipoCaso actividadTipoCaso:actividadesTipoCaso) {
				jsO = new JSONObject();
				jsO.put("nombre", actividadTipoCaso.getCdactividad().getDsactividad());
				jsO.put("codigo", actividadTipoCaso.getCdactividad().getCdactividad());
				
				
				JSONArray arrayTareasActividad = new JSONArray();
				for (TareaActividad tarea:actividadTipoCaso.getCdactividad().getTareaActividadList()){
					jsOTareas= new JSONObject();
					jsOTareas.put("nombreTarea", tarea.getDstarea());
					jsOTareas.put("detalleTarea", tarea.getDsdetalle());
					
					arrayTareasActividad.add(jsOTareas);
				}
				jsO.put("tareasActividades", arrayTareasActividad);
				
//				jsO.put("nombre", abogado.getNombre()+" "+ abogado.getApellido());
//				jsO.put("correo",abogado.getEmail());
//				jsO.put("telefono",abogado.getNumeroTelefono());
//				jsO.put("tarjetaProfesional",abogado.getNumeroTarjetaProfesional());
//				jsO.put("direccion",abogado.getDireccion());m
//				jsO.put("tarjetaProfesional",abogado.);
//				jsO.put("numeroTelefono",abogado.);
				arrayActividadesTipoCaso.add(jsO);
			}
			res.put("actividadesTipoCaso", arrayActividadesTipoCaso);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return res.toString(); 
	}
	
	
	
	
	
	
	
	
	//metodo para cargar los paises
	@RequestMapping(value="/obtenerPaises",method=RequestMethod.GET,produces="aplication/json; charset=utf-8")
	public @ResponseBody String obtenerPais()
	{
		List<Pais> paises=null;
		JSONObject res = new JSONObject();
		try {
			JSONObject jsO = new JSONObject();
			paises = paisService.obtenerPaises();
			JSONArray arrayPaises = new JSONArray();
			for (Pais pais:paises) {
				jsO = new JSONObject();
				jsO.put("codigo", pais.getCodigoPais());
				jsO.put("nombre", pais.getNombre());
				arrayPaises.add(jsO);
			}
			res.put("paises", arrayPaises);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return res.toString(); 
	}
  
	//metodo para cargar los departamentos por pais
	@RequestMapping(value="/obtenerDepartamentosPorPais", method=RequestMethod.GET,produces="aplication/json; charset=utf-8")
	public @ResponseBody String obtenerDepartamentoPorPais(@RequestParam("codigoPais") String codigoPais)
	{
		List<Departamento> departamentos = null;
		JSONObject res = new JSONObject();
		try {
			JSONObject jsO = new JSONObject();
			Pais pais = new Pais(codigoPais);
			departamentos = departamentoService.departamentosPorPais(pais);
			JSONArray arrayDepartamentos = new JSONArray();
			for (Departamento departamento:departamentos) {
				jsO = new JSONObject();
				jsO.put("codigo", departamento.getCodigoDepartamento());
				jsO.put("nombre", departamento.getNombre());
				arrayDepartamentos.add(jsO);
			}
			res.put("departamentos", arrayDepartamentos);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return res.toString(); 
	}

	//metodo para cargar la ciudad por departamento
	@RequestMapping(value="/obtenerCiudadPorDepartamento", method=RequestMethod.GET,produces="aplication/json; charset=utf-8")
	public @ResponseBody String obtenerCiudadPorDepartamento(@RequestParam("codigoDepartamento") String codigoDepartamento)
	{
		List<Ciudad> ciudades = null;
		JSONObject res = new JSONObject();
		try {
			JSONObject jsO = new JSONObject();
			Departamento departamento = new Departamento(codigoDepartamento);
			ciudades = ciudadService.ciudadPorDepartamento(departamento);
			JSONArray arrayCiudades = new JSONArray();
			for (Ciudad ciudad:ciudades) {
				jsO = new JSONObject();
				jsO.put("codigo", ciudad.getCiudadPK().getCodigoCiudad());
				jsO.put("nombre", ciudad.getNombre());
				arrayCiudades.add(jsO);
			}
			res.put("ciudades", arrayCiudades);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return res.toString(); 
	}
	
	// metodo para obtener los tipos de caso
	@RequestMapping(value="/obtenerTipoDeCaso", method=RequestMethod.GET,produces="aplication/json; charset=utf-8")
	public @ResponseBody String obtenerTipoDeCaso()
	{
		List<TipoCaso> tiposDeCaso = null;
		JSONObject res = new JSONObject();
		try{
			JSONObject jsO = new JSONObject();
			tiposDeCaso = tipoCasoService.obtenerTipoCaso();
			JSONArray arrayTipoCaso = new JSONArray();
			for (TipoCaso tipoDeCaso:tiposDeCaso) {
				jsO = new JSONObject();
				if(tipoDeCaso.getActivo().equals(Parametros.getEstadoActivo())){
					jsO.put("codigo",tipoDeCaso.getCodigo());
					jsO.put("nombre",tipoDeCaso.getNombre());
					arrayTipoCaso.add(jsO);
				}	
			}
			res.put("tiposDeCaso",arrayTipoCaso);
		}
		catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return res.toString(); 
	}
	
	//Metodo para obtener los estados del caso
	@RequestMapping(value="/obtenerEstadoCaso", method=RequestMethod.GET,produces="aplication/json; charset=utf-8")
	public @ResponseBody String obtenerEstadoCaso()
	{
		List<EstadoCaso> estadosCaso = null;
		JSONObject res = new JSONObject();
		try{
			JSONObject jsO = new JSONObject();
			estadosCaso = estadoCasoService.obtenerEstadoCaso();
			JSONArray arrayEstadoCaso = new JSONArray();
			for (EstadoCaso estadoCaso:estadosCaso) {
				jsO = new JSONObject();
				jsO.put("codigo",estadoCaso.getCodigo());
				jsO.put("nombre",estadoCaso.getNombre());
				arrayEstadoCaso.add(jsO);
			}
			res.put("estadosCaso",arrayEstadoCaso);
		}
		catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return res.toString(); 
	}
	
	// Metodo para obtener las clases de bienes
	@RequestMapping(value="/obtenerClaseBien", method=RequestMethod.GET,produces="aplication/json; charset=utf-8")
	public @ResponseBody String obtenerClaseBien()
	{
		List<ClaseBien> clasesBienes = null;
		JSONObject res = new JSONObject();
		try{
			JSONObject jsO = new JSONObject();
			clasesBienes =claseBienService.obtenerClaseBien(); 
			JSONArray arrayClaseBien = new JSONArray();
			for (ClaseBien claseBien:clasesBienes) {
				jsO = new JSONObject();
				jsO.put("codigo",claseBien.getCodigo());
				jsO.put("nombre",claseBien.getNombre());
				arrayClaseBien.add(jsO);
			}
			res.put("clasesBienes",arrayClaseBien);
		}
		catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return res.toString(); 
	}
	
	//metodo para obtener las instancias del radicado
	@RequestMapping(value="/obtenerInstancia", method=RequestMethod.GET,produces="aplication/json; charset=utf-8")
	public @ResponseBody String obtenerInstancia()
	{
		List<Instancia> instancias = null;
		JSONObject res = new JSONObject();
		try{
			JSONObject jsO = new JSONObject();
			instancias=instanciaService.obtenerInstancia();  
			JSONArray arrayInstancia = new JSONArray();
			for (Instancia instancia:instancias) {
				jsO = new JSONObject();
				jsO.put("codigo",instancia.getCodigo());
				jsO.put("nombre",instancia.getNombre());
				arrayInstancia.add(jsO);
			}
			res.put("instancias",arrayInstancia);
		}
		catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return res.toString(); 
	}
	
	//metodo para obetener los tipos de miembros
	@RequestMapping(value="/obtenerTipoMiembro", method=RequestMethod.GET,produces="aplication/json; charset=utf-8")
	public @ResponseBody String obtenerTipoMiembro()
	{
		List<TipoMiembro> tiposMiembros = null;
		JSONObject res = new JSONObject();
		try{
			JSONObject jsO = new JSONObject();
			tiposMiembros=tipoMiembroService.obtenerTipoMiembro();  
			JSONArray arrayTiposMiembros = new JSONArray();
			for (TipoMiembro tipoMIembro:tiposMiembros) {
				jsO = new JSONObject();
				jsO.put("codigo",tipoMIembro.getCodigo());
				jsO.put("nombre",tipoMIembro.getNombre());
				arrayTiposMiembros.add(jsO);
			}
			res.put("tiposMiembros",arrayTiposMiembros);
		}
		catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return res.toString(); 
	}

	// metodo para obtener los parentescos
	@RequestMapping(value="/obtenerParentesco", method=RequestMethod.GET,produces="aplication/json; charset=utf-8")
	public @ResponseBody String obtenerParentesco()
	{
		List<Parentesco> parentescos = null;
		JSONObject res = new JSONObject();
		try{
			JSONObject jsO = new JSONObject();
			parentescos=parentescoService.obtenerParentesco();  
			JSONArray arrayParentescos = new JSONArray();
			for (Parentesco parentesco:parentescos) {
				jsO = new JSONObject();
				jsO.put("codigo",parentesco.getCodigo());
				jsO.put("nombre",parentesco.getNombre());
				arrayParentescos.add(jsO);
			}
			res.put("parentescos",arrayParentescos);
		}
		catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return res.toString(); 
	}

	// metodo para cargar las Entidades Financieras
	@RequestMapping(value="/cargarEntidadesFinancieras", method=RequestMethod.GET,produces="aplication/json; charset=utf-8")
	public @ResponseBody String cargarEntidadesFinancieras()
	{
		List<EntidadFinanciera> entidadesFinancieras = null;
		JSONObject res = new JSONObject();
		try{
			JSONObject jsO = new JSONObject();
			entidadesFinancieras=entidadFinancieraService.obtenerEntidadesFinancieras();  
			JSONArray arrayEntidadesFinancieras = new JSONArray();
			for (EntidadFinanciera entidadFinanciera:entidadesFinancieras) {
				jsO = new JSONObject();
				jsO.put("codigo",entidadFinanciera.getCodigoEntidadfinaciera());
				jsO.put("nombre",entidadFinanciera.getNombreEntidadfinanciera());
				arrayEntidadesFinancieras.add(jsO);
			}
			res.put("entidadesFinancieras",arrayEntidadesFinancieras);
		}
		catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return res.toString(); 
	}
	
}
