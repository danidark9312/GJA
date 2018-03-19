package com.gja.gestionCasos.maestros.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gja.gestionCasos.maestros.entities.Ciudad;
import com.gja.gestionCasos.maestros.entities.Departamento;
import com.sf.util.repository.AbstractRepository;


@Repository("ciudadRepository")

public class CiudadRepositoryImpl extends AbstractRepository<Ciudad> implements CiudadRepository{

	public List<Ciudad> ciudadPorDepartamento(Departamento departamento){
		
		List<Ciudad> ciudad=null;
		
		ciudad = entityManager.createQuery("SELECT c FROM Ciudad c  WHERE c.departamento.codigoDepartamento=:dDepartamento ORDER BY c.nombre").
				setParameter("dDepartamento",departamento.getCodigoDepartamento()).getResultList();
		
		
		return ciudad; 
	}
	
	
}
