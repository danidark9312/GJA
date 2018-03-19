package com.gja.gestionCasos.maestros.service;

import java.util.List;

import com.gja.gestionCasos.maestros.entities.EstadoCaso;
import com.sf.util.BusinessException;
import com.sf.util.DAOException;

public interface EstadoCasoService {

	public List<EstadoCaso> obtenerEstadoCaso() throws DAOException,BusinessException;
}
