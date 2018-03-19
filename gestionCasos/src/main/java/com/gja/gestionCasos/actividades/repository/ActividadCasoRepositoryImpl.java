package com.gja.gestionCasos.actividades.repository;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.gja.gestionCasos.actividades.entities.ActividadCaso;
import com.gja.gestionCasos.maestros.repository.TipoCasoRepositoryImpl;
import com.sf.util.BusinessException;
import com.sf.util.DAOException;
import com.sf.util.repository.AbstractRepository;

@Repository("actividadCasoRepository")
public class ActividadCasoRepositoryImpl extends AbstractRepository<ActividadCaso> implements ActividadCasoRepository {

	private static final Logger LOG = Logger
			.getLogger(TipoCasoRepositoryImpl.class);
	
	public ActividadCaso guardarActividadCaso(ActividadCaso actividadCaso) throws DAOException,BusinessException {
		
		actividadCaso=this.merge(actividadCaso);
		return actividadCaso;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<ActividadCaso> getActividadByCaso(Integer codigoCaso) throws DAOException {
		List<ActividadCaso> actividades=null;
		try {
			actividades = entityManager.createQuery("SELECT distinct(ac) FROM ActividadCaso ac INNER JOIN ac.tareaParticularCasoSet tpc WHERE tpc.codigoCaso = :pCodigoCaso")
					.setParameter("pCodigoCaso", codigoCaso)
					.getResultList();
		} catch (IllegalStateException e) {
			LOG.error(
					"IllegalStateException: Error consultando la cantidad de actividades de los tipos de casos activos. El error es: "
							+ e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e.getMessage());
		}
		return actividades;
	}

}
