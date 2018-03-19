package com.gja.gestionCasos.casos.repository;

import java.util.List;

import com.gja.gestionCasos.casos.entities.Prestamo;
import com.sf.util.BusinessException;
import com.sf.util.DAOException;

public interface PrestamoRepository {

	public Prestamo guardarPrestamo(Prestamo prestamo) throws DAOException,BusinessException;
}
