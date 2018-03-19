package com.gja.gestionCasos.maestros.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gja.gestionCasos.actividades.entities.Actividad;
import com.gja.gestionCasos.actividades.entities.ActividadTipoCaso;
import com.gja.gestionCasos.actividades.entities.TareaActividad;
import com.gja.gestionCasos.filters.TipoCasoFiltro;
import com.gja.gestionCasos.maestros.entities.TipoCaso;
import com.gja.gestionCasos.maestros.repository.ActividadTipoCasoRepository;
import com.gja.gestionCasos.maestros.repository.ActividadTipoCasoRepositoryImpl;
import com.gja.gestionCasos.maestros.repository.TipoCasoRepository;
import com.gja.gestionCasos.maestros.repository.TipoCasoRepositoryImpl;
import com.sf.util.BusinessException;
import com.sf.util.DAOException;




@Service("tipoCasoService")
@Transactional(readOnly = true)

public class TipoCasoServiceImpl implements TipoCasoService {

	
	private static final Logger LOG = Logger
			.getLogger(PaisServiceImpl.class);
	@Autowired
	TipoCasoRepositoryImpl tipoCasoRepository;
	
	@Autowired
	ActividadTipoCasoRepositoryImpl actividadTipoCasoRepository;
	
	public List<TipoCaso> obtenerTipoCaso()throws DAOException, BusinessException
	{
		List<TipoCaso> tipoDeCaso=null;
		
		tipoDeCaso=tipoCasoRepository.obtenerTipoCaso();
		
		return tipoDeCaso;
		
	}
	
	public Long getCountFilter(TipoCasoFiltro tipoCaso) throws DAOException {
		Long cantidad=tipoCasoRepository.getCountFilter(tipoCaso);
		return cantidad;
	}
	
	public List<TipoCaso> getTipoCasoByFilter(TipoCasoFiltro tipoCaso)
			throws DAOException,BusinessException {
				List<TipoCaso> tipoCasoes = tipoCasoRepository.getTipoCasoByFilter(tipoCaso);
				return tipoCasoes;
	}
	
	@Transactional
	public TipoCaso guardarTipoCaso(TipoCaso tipoCaso)
			throws DAOException, BusinessException {
			List<ActividadTipoCaso> actividades=tipoCaso.getActividadTipoCasoList();
			tipoCaso.setActividadTipoCasoList(null);
			
			if (tipoCaso.getCodigo()!=null){
				actividadTipoCasoRepository.deleteByTipoCaso(tipoCaso.getCodigo());
			}
			
			tipoCaso=tipoCasoRepository.merge(tipoCaso);
			//actividad.setTareaActividadList(tareas);
			for (ActividadTipoCaso objActividadTipoCaso: actividades){
				objActividadTipoCaso.setCdtipocaso(tipoCaso);
				actividadTipoCasoRepository.merge(objActividadTipoCaso);
			}
		
			
			return tipoCaso;
	}
	
	@Transactional
	public int eliminarTipoCaso(TipoCaso tipoCaso)throws DAOException, BusinessException{
		tipoCaso=tipoCasoRepository.findByPK(tipoCaso);
		tipoCaso.setActivo("N");
		tipoCasoRepository.merge(tipoCaso);
		return 1;
	}

	public TipoCaso findByPK(TipoCaso tipoCaso) throws DAOException,
	BusinessException {
		TipoCaso tipoCasoByPK = tipoCasoRepository.findByPK(tipoCaso);
		return tipoCasoByPK;
	}
	
	public Long getCountByActividad(ActividadTipoCaso actividadTipoCaso) throws DAOException,
	BusinessException {
		Long cantidad = tipoCasoRepository.getCountByActividadTipoCasoActivo(actividadTipoCaso.getCdactividad().getCdactividad());
		return cantidad;
	}
	
	public boolean existNameTipoCaso(TipoCaso tipoCaso) throws DAOException,
	BusinessException {
		boolean existe = tipoCasoRepository.existNameTipoCaso(tipoCaso.getNombre());
		return existe;
	}
	
}
