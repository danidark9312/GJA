package com.gja.gestionCasos.maestros.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gja.gestionCasos.maestros.entities.EstadoCaso;
import com.sf.util.BusinessException;
import com.sf.util.DAOException;
import com.sf.util.repository.AbstractRepository;



@Repository("estadoCasoRepository")
public class EstadoCasoRepositoryImpl extends AbstractRepository<EstadoCaso> implements EstadoCasoRepository  {

	public List<EstadoCaso> obtenerEstadoCaso() throws DAOException, BusinessException
	{
		List<EstadoCaso> estadoCaso=null;
		estadoCaso=entityManager.createQuery("SELECT e FROM EstadoCaso e  ORDER BY e.nombre").getResultList();
		return estadoCaso;
	}
	
	
	
}
