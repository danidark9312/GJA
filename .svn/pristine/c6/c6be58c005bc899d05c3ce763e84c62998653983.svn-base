package com.gja.gestionCasos.casos.service;

import java.util.List;

import net.minidev.json.JSONArray;

import com.gja.gestionCasos.actividades.entities.ActividadCaso;
import com.gja.gestionCasos.actividades.entities.TareaParticularCaso;
import com.gja.gestionCasos.casos.entities.Caso;
import com.gja.gestionCasos.casos.entities.Prestamo;
import com.gja.gestionCasos.casos.entities.ListaPrestamos;
import com.gja.gestionCasos.filters.CasoFiltro;
import com.gja.gestionCasos.maestros.entities.TipoCaso;
import com.sf.util.BusinessException;
import com.sf.util.DAOException;

public interface CasoService {
	Caso guardarCaso(Caso caso, ListaPrestamos prestamos) throws DAOException, BusinessException; 
    //Caso guardarCaso(Caso caso) throws DAOException, BusinessException;
	Caso findByPK(Caso caso)  throws DAOException, BusinessException;
	Long getCountFilter(CasoFiltro caso);
	List<Caso> encontrarCasoPorFiltro(CasoFiltro casoFiltro);
	//public void obtenerCodigoEquipo(Caso caso,List<TareaParticularCaso>tareas);
	public JSONArray obtenerCodigoEquipo(Caso caso);
	public Long getCountByTipoCasoCaso(TipoCaso tipoCaso) throws DAOException, BusinessException;
}
