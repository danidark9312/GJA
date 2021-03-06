package com.gja.gestionCasos.casos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gja.gestionCasos.casos.entities.BienAfectado;
import com.gja.gestionCasos.casos.entities.BienAfectadoPK;
import com.gja.gestionCasos.casos.entities.Caso;
import com.gja.gestionCasos.casos.repository.BienAfectadoRepositoryImpl;
import com.sf.util.BusinessException;
import com.sf.util.DAOException;

@Service("bienAfectadoService")
@Transactional(readOnly = true)
public class BienAfectadoServiceImpl implements BienAfectadoService {
	
	@Autowired
	BienAfectadoRepositoryImpl bienAfectadoRepository;
	
	
	@Transactional
	public List<String> guardarBienAfectado(List<String> bienesAfectados) throws DAOException,BusinessException
	{
		return bienesAfectados;
	}
	
	public List<BienAfectado> asignarClavePrimaria(List<BienAfectado> bienesAfectados,Caso caso) throws DAOException,BusinessException{
		int i=1;
		for (BienAfectado bien:bienesAfectados) {
			BienAfectadoPK bienPK = new BienAfectadoPK();
			bienPK.setCodigoCaso(caso.getCodigo());
			bienPK.setCodigo(i++);
			bien.setBienAfectadoPK(bienPK);
		}
		return bienesAfectados;
	}

}
