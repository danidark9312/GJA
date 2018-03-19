package com.gja.gestionCasos.casos.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gja.gestionCasos.casos.entities.Prestamo;
import com.sf.util.BusinessException;
import com.sf.util.DAOException;
import com.sf.util.repository.AbstractRepository;

@Repository("prestamoRepository")
public class PrestamoRepositoryImpl extends AbstractRepository<Prestamo> implements PrestamoRepository{

	public Prestamo guardarPrestamo(Prestamo prestamo) throws DAOException,
			BusinessException {
		
		prestamo=this.merge(prestamo);
		return prestamo;
	}

}
