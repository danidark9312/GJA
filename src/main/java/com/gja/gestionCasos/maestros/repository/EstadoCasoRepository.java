package com.gja.gestionCasos.maestros.repository;

import java.util.List;

import com.gja.gestionCasos.maestros.entities.EstadoCaso;
import com.sf.util.BusinessException;
import com.sf.util.DAOException;

public interface EstadoCasoRepository {
 
	public List<EstadoCaso> obtenerEstadoCaso() throws DAOException, BusinessException;
}
