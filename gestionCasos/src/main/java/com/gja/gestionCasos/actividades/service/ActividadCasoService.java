package com.gja.gestionCasos.actividades.service;

import java.util.List;

import com.gja.gestionCasos.actividades.entities.ActividadCaso;
import com.gja.gestionCasos.actividades.entities.ActividadTipoCaso;
import com.sf.util.BusinessException;
import com.sf.util.DAOException;

public interface ActividadCasoService {

	public ActividadCaso guardarActividadCaso(ActividadCaso actividadCaso) throws DAOException,BusinessException;
	public List<ActividadCaso>  getActividadByCaso(Integer codigoCaso) throws DAOException, BusinessException;
	public List<ActividadTipoCaso> obtenerActividadesTipoCaso(Integer codigoTipoCaso)throws DAOException, BusinessException;
}
