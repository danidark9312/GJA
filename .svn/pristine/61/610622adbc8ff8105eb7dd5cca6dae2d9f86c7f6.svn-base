package com.gja.gestionCasos.casos.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;

import com.gja.gestionCasos.casos.entities.BienAfectado;
import com.gja.gestionCasos.casos.entities.Caso;
import com.gja.gestionCasos.casos.entities.CasoEquipoCaso;
import com.gja.gestionCasos.casos.entities.Radicado;
import com.gja.gestionCasos.filters.CasoFiltro;
import com.sf.util.DAOException;
import com.sf.util.repository.AbstractRepository;



@Repository("casoRepository")
public class CasoRepositoryImpl extends AbstractRepository<Caso> implements CasoRepository {
	private static final Logger LOG = Logger
			.getLogger(CasoRepository.class);
	
	public Caso findByPK(Caso caso) throws DAOException {
		Caso casoReturn;
		try {
			casoReturn = entityManager.find(Caso.class, caso.getCodigo());
			inicializarListas(casoReturn);
			} catch (IllegalStateException e) {
			LOG.error("IllegalStateException: Error consultando el caso por PK " + caso.getCodigo() + ". El error es: "
							+ e.getMessage(), e);
			throw new DAOException(e.getMessage(), e);
		} catch (Exception e) {
			LOG.error("Exception: Error consultando el caso por PK " + caso.getCodigo() + ". El error es: "
							+ e.getMessage(), e);
			throw new DAOException(e.getMessage(), e);
		}
		return casoReturn;
	}

	public void inicializarListas(Caso casoReturn){
		Hibernate.initialize(casoReturn.getBienAfectadoSet());
		Hibernate.initialize(casoReturn.getCasoEquipoCasoSet());
		Hibernate.initialize(casoReturn.getRadicadoSet());
		if(casoReturn.getCiudadProceso()!=null){
			
			Hibernate.initialize(casoReturn.getCiudadProceso());
			Hibernate.initialize(casoReturn.getCiudadProceso().getDepartamento());
			Hibernate.initialize(casoReturn.getCiudadProceso().getDepartamento().getPais());
		}
		Hibernate.initialize(casoReturn.getCiudadHechos().getDepartamento().getPais());
		Hibernate.initialize(casoReturn.getCiudadHechos().getDepartamento());
		Hibernate.initialize(casoReturn.getCiudadHechos());
		Hibernate.initialize(casoReturn.getEstadoCaso());
		Hibernate.initialize(casoReturn.getTipoCaso());
		Hibernate.initialize(casoReturn.getRadicadoSet());
		List<BienAfectado> listBienAfectado = casoReturn.getBienAfectadoSet();
		for(BienAfectado objBienAfectado: listBienAfectado ){
			Hibernate.initialize(objBienAfectado.getClase());
		}
		List<Radicado> listRadicado = casoReturn.getRadicadoSet();
		for(Radicado objRadicado: listRadicado ){
			Hibernate.initialize(objRadicado.getInstancia());
		}
		List<CasoEquipoCaso> listCasoEquipoCaso = casoReturn.getCasoEquipoCasoSet();
		for(CasoEquipoCaso objCasoEquipoCaso: listCasoEquipoCaso ){
			Hibernate.initialize(objCasoEquipoCaso.getTipoMiembro());
			Hibernate.initialize(objCasoEquipoCaso.getEquipoCaso());
			Hibernate.initialize(objCasoEquipoCaso.getParentesco());
			Hibernate.initialize(objCasoEquipoCaso.getEquipoCaso().getCorreoList());
			Hibernate.initialize(objCasoEquipoCaso.getEquipoCaso().getCelularList());
			Hibernate.initialize(objCasoEquipoCaso.getEquipoCaso().getTelefonoList());	
			Hibernate.initialize(objCasoEquipoCaso.getTareaParticularCasoSet());	
		}
	}
	
	public Long getCountFilter(CasoFiltro caso)  {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> query = builder.createQuery(Long.class);
		Root<Caso> casoRoot = query.from(Caso.class);

		query.select(builder.count(casoRoot.<String> get("codigo")));

		List<Predicate> predicateList = getPredicateFiltro(caso, builder, casoRoot);

		Predicate[] predicates = new Predicate[predicateList.size()];
		predicateList.toArray(predicates);
		query.where(predicates);

		return entityManager.createQuery(query).getSingleResult();
	}
	
	
	
	public List<Caso> encontrarCasoPorFiltro(CasoFiltro casoFiltro) {
		
		
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Caso> query = builder.createQuery(Caso.class);
		Root<Caso> casoRoot = query.from(Caso.class);
		
		query.select(casoRoot);
		//query.orderBy(casoRoot.<Integer> get("codigo"));
		List<Predicate> listaPredicados = getPredicateFiltro(casoFiltro, builder, casoRoot);
		Predicate[] predicados = new Predicate[listaPredicados.size()];
		listaPredicados.toArray(predicados);
		query.where(predicados);
		query.orderBy(builder.desc(casoRoot.<String> get("codigo")));
				
		
		return entityManager.createQuery(query)
				.setMaxResults(casoFiltro.getiDisplayLength())
				.setFirstResult(casoFiltro.getiDisplayStart()).getResultList();
		
	}
	private List<Predicate> getPredicateFiltro(CasoFiltro casoFiltro, CriteriaBuilder builder, Root<Caso> casoRoot) {
			
		List<Predicate> listaPredicados = new ArrayList<Predicate>();
		Predicate codigoPredicado;
		Predicate estadoPredicate;
		
		if (casoFiltro != null && casoFiltro.getCodigoCaso() != null && !(casoFiltro.getCodigoCaso().isEmpty())) {
			codigoPredicado = builder.equal(builder.upper(casoRoot.<String> get("codigo")),	casoFiltro.getCodigoCaso());
			listaPredicados.add(codigoPredicado);
		}
		if (casoFiltro != null && casoFiltro.getEstadoCaso() != null  && !(casoFiltro.getEstadoCaso().isEmpty())) {
			estadoPredicate = builder.equal(casoRoot.get("estadoCaso").get("codigo"), casoFiltro.getEstadoCaso());
			listaPredicados.add(estadoPredicate);
		}
		if (casoFiltro != null && casoFiltro.getTipoCaso() != null  && !(casoFiltro.getTipoCaso().isEmpty())) {
			estadoPredicate = builder.equal(casoRoot.get("tipoCaso").get("codigo"), casoFiltro.getTipoCaso());
			listaPredicados.add(estadoPredicate);
		}
		
		
		return listaPredicados;
	}
	
	@SuppressWarnings("unchecked")
	public Long getCountByTipoCasoCaso(Integer codigoTipoCaso) throws DAOException {
		Long resultado;
		try {
			resultado = entityManager.createQuery("SELECT COUNT(c.codigo) FROM Caso c INNER JOIN c.tipoCaso tc WHERE tc.codigo = :pCodigoTipoCaso",Long.class)
					.setParameter("pCodigoTipoCaso", codigoTipoCaso)
					.getSingleResult();
		} catch (IllegalStateException e) {
			LOG.error(
					"IllegalStateException: Error consultando la cantidad de tipos de casos por caso. El error es: "
							+ e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e.getMessage());
		}
		return resultado;
	}
	
}
