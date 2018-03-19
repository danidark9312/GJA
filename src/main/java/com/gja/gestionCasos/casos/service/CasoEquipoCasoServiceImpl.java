package com.gja.gestionCasos.casos.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("CasoEquipoCasoService")
@Transactional(readOnly = true)
public class CasoEquipoCasoServiceImpl implements CasoEquipoCasoService{

}
