package com.gja.gestionCasos.casos.repository;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.gja.gestionCasos.casos.entities.EquipoCaso;
import com.sf.social.signinmvc.user.model.User;
import com.sf.util.BusinessException;
import com.sf.util.DAOException;
import com.sf.util.repository.AbstractRepository;

@Repository("equipoCasoRepository")
public class EquipoCasoRepositoryImpl extends AbstractRepository<EquipoCaso> implements EquipoCasoRepository {

	private static final Logger LOG = Logger
			.getLogger(EquipoCasoRepositoryImpl.class);
	
	public EquipoCaso guardarEquipoCaso(EquipoCaso equipoCaso)
			throws DAOException, BusinessException {
		equipoCaso = this.merge(equipoCaso);
		return equipoCaso;
	}

	public List<User> obtenerAbogado() throws DAOException,BusinessException{
		List<User> abogados=null;
		abogados =entityManager.createQuery("SELECT u FROM User u ORDER BY u.nombre").getResultList();
		return abogados;
		
	} 
	
	
	public List<User> obtenerAbogadosSeleccionados(String codigoAbogadoSeleccionado) throws DAOException,BusinessException{
		List<User> abogados=null;
		abogados =entityManager.createQuery("SELECT u FROM User u WHERE u.id=:uCodigoAbogado ORDER BY u.nombre").
				setParameter("uCodigoAbogado",codigoAbogadoSeleccionado).getResultList();
		return abogados;
		
	} 
	
	public EquipoCaso findByPK(EquipoCaso equipoCaso) throws DAOException {
		EquipoCaso equipoCasoReturn;
		try {
			equipoCasoReturn = entityManager.find(EquipoCaso.class, equipoCaso.getCodigoEquipoCaso());
			} catch (IllegalStateException e) {
			throw new DAOException(e.getMessage(), e);
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		}
		return equipoCasoReturn;
	}
	
	
	
	
	
	
	
}
