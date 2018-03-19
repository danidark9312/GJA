package com.gja.gestionCasos.casos.repository;

import java.util.List;

import com.gja.gestionCasos.casos.entities.Caso;
import com.gja.gestionCasos.filters.CasoFiltro;
import com.sf.util.DAOException;

public interface CasoRepository {
	Caso findByPK(Caso caso) throws DAOException;
	Long getCountFilter(CasoFiltro caso);
	List<Caso> encontrarCasoPorFiltro(CasoFiltro codigoCaso);
	
}
