package com.gja.gestionCasos.casos.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.gja.gestionCasos.casos.entities.Celular;
import com.gja.gestionCasos.casos.entities.Correo;
import com.gja.gestionCasos.casos.entities.EquipoCaso;
import com.gja.gestionCasos.casos.entities.Telefono;
import com.gja.gestionCasos.casos.repository.EquipoCasoRepository;
import com.sf.social.signinmvc.user.model.User;
import com.sf.util.BusinessException;
import com.sf.util.DAOException;

@Service("equipoCasoService")
@Transactional(readOnly = true)
public class EquipoCasoServiceImpl implements EquipoCasoService{

	@Autowired
	EquipoCasoRepository equipoCasoRepository; 
	public EquipoCaso guardarEquipoCaso(EquipoCaso equipoCaso)
			throws DAOException, BusinessException {
	
		
		List<Correo> correos=equipoCaso.getCorreoList();
		List<Telefono> telefonos=equipoCaso.getTelefonoList();
		List<Celular> celulares=equipoCaso.getCelularList();
		equipoCaso.setCorreoList(null);
		equipoCaso.setTelefonoList(null);
		equipoCaso.setCelularList(null);
		equipoCaso = equipoCasoRepository.guardarEquipoCaso(equipoCaso);
		if(correos!=null){
			for(Correo correo:correos ){
				correo.setCodigoEquipoCaso(equipoCaso);	
				
			}
			equipoCaso.setCorreoList(correos);
		}
		if(telefonos!=null){
			for(Telefono telefono:telefonos){
				telefono.setCodigoEquipoCaso(equipoCaso);
				}
			equipoCaso.setTelefonoList(telefonos);
		}
		if(celulares!=null){
			for(Celular celular:celulares){
				celular.setCodigoEquipoCaso(equipoCaso);
				
			}
			equipoCaso.setCelularList(celulares);
		}
//		equipoCaso.setCorreoList(correos);
//		equipoCaso.setTelefonoList(telefonos);
//		equipoCaso.setCelularList(celulares);
				
		equipoCaso = equipoCasoRepository.guardarEquipoCaso(equipoCaso);
		return equipoCaso;
	}


	public List<User> obtenerAbogados() throws DAOException,BusinessException{
		List<User> abogados=null;
		abogados=equipoCasoRepository.obtenerAbogado();
		return abogados;
		
	}
	
	public List<User> obtenerAbogadosSeleccionados(String codigoAbogadoSeleccionado) throws DAOException,BusinessException{
		List<User> abogados=null;
		abogados=equipoCasoRepository.obtenerAbogadosSeleccionados(codigoAbogadoSeleccionado);
		return abogados;
		
	}
}