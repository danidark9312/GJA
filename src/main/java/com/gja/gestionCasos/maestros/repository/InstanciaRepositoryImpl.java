package com.gja.gestionCasos.maestros.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gja.gestionCasos.maestros.entities.Instancia;
import com.sf.util.BusinessException;
import com.sf.util.DAOException;
import com.sf.util.repository.AbstractRepository;


@Repository("instanciaRepository")
public class InstanciaRepositoryImpl extends AbstractRepository<Instancia> implements InstanciaRepository{
	
	public List<Instancia> obtenerInstancia() throws DAOException,BusinessException
	{
		List<Instancia> instancias=null;
		
		instancias=entityManager.createQuery("SELECT i FROM Instancia i  ORDER BY i.nombre").getResultList();
		return instancias;
	}
	

}
