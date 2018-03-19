package com.gja.gestionCasos.maestros.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gja.gestionCasos.maestros.entities.Parentesco;
import com.sf.util.BusinessException;
import com.sf.util.DAOException;
import com.sf.util.repository.AbstractRepository;

@Repository("parentescoRepository")
public class ParentescoRepositoryImpl extends AbstractRepository<Parentesco> implements ParentescoRepository{
	
	
	public List<Parentesco> obtenerParentesco() throws DAOException,BusinessException{
		
		List<Parentesco> parentescos=null;
		
		parentescos=entityManager.createQuery("SELECT p FROM Parentesco p  ORDER BY p.nombre").getResultList();
		return parentescos;
	}

}
