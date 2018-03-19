package com.gja.gestionCasos.casos.repository;

import com.gja.gestionCasos.casos.entities.CasoEquipoCaso;
import com.sf.util.BusinessException;
import com.sf.util.DAOException;

public interface CasoEquipoCasoRepository {

	public CasoEquipoCaso guardarCasoEquipoCaso(CasoEquipoCaso casoEquipoCaso) throws DAOException,BusinessException;
	
}
