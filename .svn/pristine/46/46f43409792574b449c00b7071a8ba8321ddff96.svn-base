package com.gja.gestionCasos.maestros.repository;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gja.gestionCasos.maestros.entities.Pais;
import com.sf.util.DAOException;
import com.sf.util.repository.AbstractRepository;





@Repository("paisRepository")
public class PaisRepositoryImpl extends AbstractRepository<Pais> implements PaisRepository{
	
	private static final Logger LOG = Logger
			.getLogger(PaisRepositoryImpl.class);
	
	public List<Pais> obtenerPaises() throws DAOException{
		List<Pais> paises = null; 
		try
		{
			paises =entityManager.createQuery("SELECT p FROM Pais p ORDER BY p.nombre").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return paises;
	}
}
