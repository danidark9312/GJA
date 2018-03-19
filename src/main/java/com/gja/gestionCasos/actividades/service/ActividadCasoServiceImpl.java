package com.gja.gestionCasos.actividades.service;

import java.util.Date;
import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gja.gestionCasos.actividades.entities.ActividadCaso;
import com.gja.gestionCasos.actividades.entities.ActividadTipoCaso;
import com.gja.gestionCasos.actividades.entities.TareaParticularCaso;
import com.gja.gestionCasos.actividades.repository.ActividadCasoRepository;
import com.gja.gestionCasos.casos.entities.EquipoCaso;
import com.gja.gestionCasos.casos.repository.EquipoCasoRepositoryImpl;
import com.gja.gestionCasos.maestros.repository.ActividadTipoCasoRepository;
import com.sf.util.BusinessException;
import com.sf.util.DAOException;

@Service("actividadCasoService")
@Transactional(readOnly = true)
public class ActividadCasoServiceImpl implements ActividadCasoService {

	@Autowired
	ActividadCasoRepository actividadCasoRepository;
	
	@Autowired
	EquipoCasoRepositoryImpl equipoCasoRepository;
	@Autowired 
	ActividadTipoCasoRepository actividadTipoCasoRepository;
	
	@Transactional
	public ActividadCaso guardarActividadCaso(ActividadCaso actividadCaso)
			throws DAOException, BusinessException {
		List<TareaParticularCaso> tareasParticulares=actividadCaso.getTareaParticularCasoSet();
		actividadCaso.setFechaCreacion(new Date());
		actividadCaso.setFechaUltimaModificacion(new Date());
		actividadCaso.setTareaParticularCasoSet(null);
		actividadCaso=actividadCasoRepository.guardarActividadCaso(actividadCaso);
		if(tareasParticulares!=null){
		for(TareaParticularCaso tareaParticular:tareasParticulares){
			tareaParticular.setFechaCreacion(new Date());
			tareaParticular.setFechaUltimaModificacion(new Date());
			tareaParticular.setActividadParticular(actividadCaso);
		}}
		actividadCaso.setTareaParticularCasoSet(tareasParticulares);
		actividadCaso=actividadCasoRepository.guardarActividadCaso(actividadCaso);
		return actividadCaso;
	}
	
	public List<ActividadCaso>  getActividadByCaso(Integer codigoCaso) throws DAOException, BusinessException{
		List<ActividadCaso> actividades=null;
		EquipoCaso equipoCaso=null;
		actividades=actividadCasoRepository.getActividadByCaso(codigoCaso);
		
		return actividades;
	}

	public List<ActividadTipoCaso> obtenerActividadesTipoCaso(
			Integer codigoTipoCaso) throws DAOException, BusinessException {
		List<ActividadTipoCaso> actividadesTipoCaso=null;
		
		actividadesTipoCaso=actividadTipoCasoRepository.obtenerActividadesTipoCaso(codigoTipoCaso);
		return actividadesTipoCaso;
	}



}
