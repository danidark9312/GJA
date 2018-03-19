
package com.gja.gestionCasos.casos.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gja.gestionCasos.actividades.entities.Actividad;
import com.gja.gestionCasos.actividades.entities.ActividadCaso;
import com.gja.gestionCasos.actividades.entities.TareaParticularCaso;
import com.gja.gestionCasos.actividades.repository.ActividadCasoRepository;
import com.gja.gestionCasos.casos.entities.BienAfectado;
import com.gja.gestionCasos.casos.entities.Caso;
import com.gja.gestionCasos.casos.entities.CasoEquipoCaso;
import com.gja.gestionCasos.casos.entities.EquipoCaso;
import com.gja.gestionCasos.casos.entities.ListaPrestamos;
import com.gja.gestionCasos.casos.entities.Prestamo;
import com.gja.gestionCasos.casos.entities.Radicado;
import com.gja.gestionCasos.casos.repository.CasoRepositoryImpl;
import com.gja.gestionCasos.casos.repository.PrestamoRepository;
import com.gja.gestionCasos.filters.CasoFiltro;
import com.gja.gestionCasos.maestros.entities.TipoCaso;
import com.sf.util.BusinessException;
import com.sf.util.DAOException;
@Service("casoService")
@Transactional(readOnly = true)
public class CasoServiceImpl implements CasoService {

	@Autowired
	CasoRepositoryImpl casoRepository;
//	@Autowired
//	EquipoCasoRepositoryImpl equipoCasoRepository;
	@Autowired
	BienAfectadoService bienAfectadoService; 
	@Autowired
	EquipoCasoService equipoCasoService;
	@Autowired
	TareaParticularCasoService tareaParticularCasoService;
	@Autowired
	ActividadCasoRepository actividadCasoRepository;
	@Autowired
	PrestamoRepository prestamoRepository; 
	
	@Transactional
	//public Caso guardarCaso(Caso caso, ActividadCaso actividadCaso) throws DAOException, BusinessException
	public Caso guardarCaso(Caso caso, ListaPrestamos prestamos) throws DAOException, BusinessException{
		//Date fechaCreacion = new Date();
		//Date fechaActualizacion = new Date();
		List<BienAfectado> bienesAfectados = caso.getBienAfectadoSet();//Lista de bienes Afectados
		List<Radicado> radicados=caso.getRadicadoSet();
		//List<Radicado> radicados=new ArrayList<Radicado>();//Lista de Radicados
		List<CasoEquipoCaso> casosEquiposCasos=new ArrayList<CasoEquipoCaso>();//Lista de equipos caso
		//ingreso de fechas de creacion  y ulitma modificacion del  caso
		//caso.setFechaCreacion(fechaCreacion);
		caso.setFechaCreacion(new Date());
		caso.setFechaUltimaActualizacion(new Date());
		caso.setFechaUsuarioUltimaModificacion(new Date());
		//fecha caducidad dos años despuess
//		Calendar fechaCaducidad=Calendar.getInstance();
//		fechaCaducidad.setTime(caso.getFechaCaducidad());
//		fechaCaducidad.add(fechaCaducidad.YEAR,2);
//		caso.setFechaCaducidad(fechaCaducidad.getTime());		
			// bloque para ingresar el codigo del caso a los bienes afectados y radicados
			//bienesAfectados.addAll(caso.getBienAfectadoSet());//bienes afectados
			caso.setBienAfectadoSet(null);
			//radicados.addAll(caso.getRadicadoSet());//radicados
			caso.setRadicadoSet(null);
			casosEquiposCasos.addAll(caso.getCasoEquipoCasoSet());//casos equipos caso
			caso.setCasoEquipoCasoSet(null);
			caso = casoRepository.merge(caso);
			if(bienesAfectados!=null){
				bienesAfectados = bienAfectadoService.asignarClavePrimaria(bienesAfectados, caso);
			}
			if(radicados!=null){
				for(Radicado radicado:radicados){
					// se ingresan las fechas de creación y ultima modificación
					radicado.setCaso(caso);
					radicado.setFechaCreacion(new Date());
					radicado.setFechaUltimaModificacion(new Date());
				}
			}
			//List<CasoEquipoCaso> casoEquipoCasoInsert = new ArrayList<CasoEquipoCaso>();
			for(CasoEquipoCaso casoEquipoCaso:casosEquiposCasos){
				// ingresar equipo del caso
				EquipoCaso equipoCaso = casoEquipoCaso.getEquipoCaso();
				equipoCaso = equipoCasoService.guardarEquipoCaso(equipoCaso);
				casoEquipoCaso.getCasoEquipoCasoPK().setCodigo(caso.getCodigo());	
				casoEquipoCaso.getCasoEquipoCasoPK().setCodigoEquipoCaso(equipoCaso.getCodigoEquipoCaso());
				casoEquipoCaso.setEquipoCaso(equipoCaso);

			}
			caso.setRadicadoSet(radicados);
			caso.setBienAfectadoSet(bienesAfectados);
			caso.setCasoEquipoCasoSet(casosEquiposCasos);
			caso = casoRepository.merge(caso);
			
			List<Prestamo> listaPrestamos=prestamos.getListaPrestamos();
			if(listaPrestamos!=null){
			for(Prestamo prestamo:listaPrestamos)
				{
					prestamo.setFechaCreacion(new Date());
					prestamo.setFechaUltimaModificacion(new Date());
					prestamo=prestamoRepository.guardarPrestamo(prestamo);
				}
			}
		return caso;
	}
	public Caso findByPK(Caso caso) throws DAOException{
		Caso casoFindByPK = null;
		casoFindByPK = casoRepository.findByPK(caso);
		return casoFindByPK;
	}

	public Long getCountFilter(CasoFiltro caso)
	{
		Long  cantidad=null;
		cantidad=casoRepository.getCountFilter(caso);
		
		return cantidad;
		
	}
	
	
	public List<Caso> encontrarCasoPorFiltro(CasoFiltro casoFiltro) {
		
		List<Caso> casos=null;
		casos = casoRepository.encontrarCasoPorFiltro(casoFiltro);
		for (Caso caso: casos) {
			Hibernate.initialize(caso.getRadicadoSet());
			Hibernate.initialize(caso.getCasoEquipoCasoSet());
			for(CasoEquipoCaso casoEquipoCaso:caso.getCasoEquipoCasoSet() ){
				Hibernate.initialize(casoEquipoCaso.getEquipoCaso().getTelefonoList());
				Hibernate.initialize(casoEquipoCaso.getEquipoCaso().getCelularList());
				Hibernate.initialize(casoEquipoCaso.getEquipoCaso().getCorreoList());
				Hibernate.initialize(casoEquipoCaso.getTareaParticularCasoSet());
				
			}
			
		}
		return casos;
		
	}
	//public void obtenerCodigoEquipo(Caso caso,List<TareaParticularCaso> tareas){
		
	public JSONArray obtenerCodigoEquipo(Caso caso)	{
		
//		for(TareaParticularCaso tarea:tareas ){
//			
//			for(CasoEquipoCaso casoEquipoCaso:caso.getCasoEquipoCasoSet()){
//				
//				if(casoEquipoCaso.getEquipoCaso().getIdentificacion()!=null && casoEquipoCaso.getEquipoCaso().getIdentificacion()!=""){
//				if(Integer.parseInt(casoEquipoCaso.getEquipoCaso().getIdentificacion())==tarea.getCodigoEquipoCaso()){
//					tarea.setCodigoEquipoCaso(casoEquipoCaso.getEquipoCaso().getCodigoEquipoCaso());
//					tarea.setCodigoCaso(caso.getCodigo());
//				}}
//			}
//		}
		
		
		
		JSONArray codigosEquipos=new JSONArray();
		
		for(CasoEquipoCaso casoEquipoCaso:caso.getCasoEquipoCasoSet()){
			JSONObject jsO = new JSONObject();
			jsO.put("identificacion",casoEquipoCaso.getEquipoCaso().getIdentificacion());
			jsO.put("codigoEquipoCaso",casoEquipoCaso.getEquipoCaso().getCodigoEquipoCaso());
			//jsO.put("codigoCaso",casoEquipoCaso.getCaso().getCodigo());
			codigosEquipos.add(jsO);
		}
		return codigosEquipos;
		
	}
	
	public Long getCountByTipoCasoCaso(TipoCaso tipoCaso) throws DAOException, BusinessException {
		Long cantidad=casoRepository.getCountByTipoCasoCaso(tipoCaso.getCodigo());
		return cantidad;
	}
	
	
}

