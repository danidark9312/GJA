package com.gja.gestionCasos.casos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gja.gestionCasos.actividades.entities.ActividadCaso;
import com.gja.gestionCasos.actividades.entities.TareaParticularCaso;
import com.gja.gestionCasos.actividades.repository.ActividadCasoRepository;
import com.sf.util.BusinessException;
import com.sf.util.DAOException;

@Service("tareaParticularCasoService")
public class TareaParticularCasoServiceImpl implements TareaParticularCasoService{

	@Autowired
	ActividadCasoRepository actividadCasoRepository;
	public TareaParticularCaso guardarTareaparticularCaso(
			TareaParticularCaso tareaParticularCaso) throws DAOException,BusinessException{
		ActividadCaso actividad=null;
		actividad=tareaParticularCaso.getActividadParticular();
		tareaParticularCaso.setActividadParticular(null);
		actividad=actividadCasoRepository.guardarActividadCaso(actividad);
		tareaParticularCaso.setActividadParticular(actividad);
		return tareaParticularCaso;
	}

}
