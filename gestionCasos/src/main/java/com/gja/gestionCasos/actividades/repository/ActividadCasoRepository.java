package com.gja.gestionCasos.actividades.repository;

import java.util.List;

import com.gja.gestionCasos.actividades.entities.ActividadCaso;
import com.sf.util.BusinessException;
import com.sf.util.DAOException;

public interface ActividadCasoRepository {
	
	public ActividadCaso guardarActividadCaso(ActividadCaso actividadCaso) throws DAOException,BusinessException;
	public List<ActividadCaso> getActividadByCaso(Integer codigoCaso) throws DAOException;
	
}
