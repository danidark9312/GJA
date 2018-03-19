package com.gja.gestionCasos.casos.repository;

import org.springframework.stereotype.Repository;

import com.gja.gestionCasos.casos.entities.CasoEquipoCaso;
import com.sf.util.BusinessException;
import com.sf.util.DAOException;
import com.sf.util.repository.AbstractRepository;

@Repository("asoEquipoCasoRepository")
public class CasoEquipoCasoRepositoryImpl extends AbstractRepository<CasoEquipoCaso> implements CasoEquipoCasoRepository {

	public CasoEquipoCaso guardarCasoEquipoCaso(CasoEquipoCaso casoEquipoCaso)
			throws DAOException, BusinessException {
	
		casoEquipoCaso = this.merge(casoEquipoCaso);
		return casoEquipoCaso;
	}

}
