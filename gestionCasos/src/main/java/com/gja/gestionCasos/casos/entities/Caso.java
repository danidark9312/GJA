package com.gja.gestionCasos.casos.entities;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.gja.gestionCasos.maestros.entities.Ciudad;
import com.gja.gestionCasos.maestros.entities.EstadoCaso;
import com.gja.gestionCasos.maestros.entities.TipoCaso;
import com.gja.gestionCasos.reportes.entities.Auditoria;

/**
 *
 * @author DESARROLLADOR6
 */
@Entity
@Table(name = "casos")
@NamedQueries({
    @NamedQuery(name = "Caso.findAll", query = "SELECT c FROM Caso c")})
@JsonIgnoreProperties(value = { "handler", "hibernateLazyInitializer" })
public class Caso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cdcaso")
    private Integer codigo;
    @Basic(optional = false)
    @Column(name = "dscaso")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "fehecho")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHecho;
    @Basic(optional = false)
    @Column(name = "feultimaactualizacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaUltimaActualizacion;
    @Basic(optional = false)
    @Column(name = "nmdespacho")
    private String numeroDespacho;
    @Basic(optional = false)
    @Column(name = "dsnombrefuncionario")
    private String nombreFuncionario;
    @Column(name = "dscomentario")
    private String comentario;
    @Column(name = "dsdireccionhechos")
    private String direccionHechos;
    @Column(name = "dsresumenhechos")
    private String resumenHechos;
    @Column(name = "fecaducidad")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCaducidad;
    @Column(name = "dsjustificacion")
    private String justificacion;
    @Basic(optional = false)
    @Column(name = "cdusuariocreacion")
    private String usuarioCreacion;
    @Basic(optional = false)
    @Column(name = "cdusuarioultimamodificacion")
    private String usuarioUltimaModificacion;
    @Basic(optional = false)
    @Column(name = "fecreacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Basic(optional = false)
    @Column(name = "feusuarioultimamodificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaUsuarioUltimaModificacion;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdcaso", fetch = FetchType.LAZY)
    private Set<Auditoria> auditoriaSet;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "caso", fetch = FetchType.LAZY)
    private List<BienAfectado> bienAfectadoSet;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "caso", fetch = FetchType.LAZY)
    private List<Radicado> radicadoSet;
    @JsonManagedReference
    @OneToMany(cascade={CascadeType.REMOVE, CascadeType.MERGE}, mappedBy = "caso", fetch = FetchType.LAZY)
    private List<CasoEquipoCaso> casoEquipoCasoSet;
    @JoinColumns({
    			@JoinColumn(name = "cdciudadproceso", referencedColumnName = "cdciudad"),
    			@JoinColumn(name = "cddepartamentoproceso", referencedColumnName = "cddepartamento")})
   // @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @ManyToOne(fetch = FetchType.EAGER)
    private Ciudad ciudadProceso;
    @JoinColumns({
    	@JoinColumn(name = "cdciudadhechos", referencedColumnName = "cdciudad"),
    	@JoinColumn(name = "cddepartamentohechos", referencedColumnName = "cddepartamento")})
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Ciudad ciudadHechos;
    @JoinColumn(name = "cdestadocaso", referencedColumnName = "cdestadocaso")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private EstadoCaso estadoCaso;
    @JoinColumn(name = "cdtipocaso", referencedColumnName = "cdtipocaso")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private TipoCaso tipoCaso;
    @Column(name = "dsdireccionproceso")
    private String direccionProceso;
    

    public Caso() {
    }

    public Caso(Integer codigo) {
        this.codigo = codigo;
    }

	public Caso(Integer codigo, String nombre, Date fechaHecho,
			Date fechaUltimaActualizacion, String numeroDespacho,
			String nombreFuncionario, String comentario,
			String direccionHechos, String resumenHechos, Date fechaCaducidad,
			String justificacion, String usuarioCreacion,
			String usuarioUltimaModificacion, Date fechaCreacion,
			Date fechaUsuarioUltimaModificacion,String direccionProceso) {
		
		this.codigo = codigo;
		this.nombre = nombre;
		this.fechaHecho = fechaHecho;
		this.fechaUltimaActualizacion = fechaUltimaActualizacion;
		this.numeroDespacho = numeroDespacho;
		this.nombreFuncionario = nombreFuncionario;
		this.comentario = comentario;
		this.direccionHechos = direccionHechos;
		this.resumenHechos = resumenHechos;
		this.fechaCaducidad = fechaCaducidad;
		this.justificacion = justificacion;
		this.usuarioCreacion = usuarioCreacion;
		this.usuarioUltimaModificacion = usuarioUltimaModificacion;
		this.fechaCreacion = fechaCreacion;
		this.fechaUsuarioUltimaModificacion = fechaUsuarioUltimaModificacion;
		this.direccionProceso=direccionProceso;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaHecho() {
		return fechaHecho;
	}

	public void setFechaHecho(Date fechaHecho) {
		this.fechaHecho = fechaHecho;
	}

	public Date getFechaUltimaActualizacion() {
		return fechaUltimaActualizacion;
	}

	public void setFechaUltimaActualizacion(Date fechaUltimaActualizacion) {
		this.fechaUltimaActualizacion = fechaUltimaActualizacion;
	}

	public String getNumeroDespacho() {
		return numeroDespacho;
	}

	public void setNumeroDespacho(String numeroDespacho) {
		this.numeroDespacho = numeroDespacho;
	}

	public String getNombreFuncionario() {
		return nombreFuncionario;
	}

	public void setNombreFuncionario(String nombreFuncionario) {
		this.nombreFuncionario = nombreFuncionario;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getDireccionHechos() {
		return direccionHechos;
	}

	public void setDireccionHechos(String direccionHechos) {
		this.direccionHechos = direccionHechos;
	}

	public String getResumenHechos() {
		return resumenHechos;
	}

	public void setResumenHechos(String resumenHechos) {
		this.resumenHechos = resumenHechos;
	}

	public Date getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(Date fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	public String getJustificacion() {
		return justificacion;
	}

	public void setJustificacion(String justificacion) {
		this.justificacion = justificacion;
	}

	public String getUsuarioCreacion() {
		return usuarioCreacion;
	}

	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	public String getUsuarioUltimaModificacion() {
		return usuarioUltimaModificacion;
	}

	public void setUsuarioUltimaModificacion(String usuarioUltimaModificacion) {
		this.usuarioUltimaModificacion = usuarioUltimaModificacion;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaUsuarioUltimaModificacion() {
		return fechaUsuarioUltimaModificacion;
	}

	public void setFechaUsuarioUltimaModificacion(
			Date fechaUsuarioUltimaModificacion) {
		this.fechaUsuarioUltimaModificacion = fechaUsuarioUltimaModificacion;
	}

	public Set<Auditoria> getAuditoriaSet() {
		return auditoriaSet;
	}

	public void setAuditoriaSet(Set<Auditoria> auditoriaSet) {
		this.auditoriaSet = auditoriaSet;
	}

	public List<BienAfectado> getBienAfectadoSet() {
		return bienAfectadoSet;
	}

	public void setBienAfectadoSet(List<BienAfectado> bienAfectadoSet) {
		this.bienAfectadoSet = bienAfectadoSet;
	}

	public List<Radicado> getRadicadoSet() {
		return radicadoSet;
	}

	public void setRadicadoSet(List<Radicado> radicadoSet) {
		this.radicadoSet = radicadoSet;
	}

	public List<CasoEquipoCaso> getCasoEquipoCasoSet() {
		return casoEquipoCasoSet;
	}

	public void setCasoEquipoCasoSet(List<CasoEquipoCaso> casoEquipoCasoSet) {
		this.casoEquipoCasoSet = casoEquipoCasoSet;
	}

	public Ciudad getCiudadProceso() {
		return ciudadProceso;
	}

	public void setCiudadProceso(Ciudad ciudadProceso) {
		this.ciudadProceso = ciudadProceso;
	}

	public Ciudad getCiudadHechos() {
		return ciudadHechos;
	}

	public void setCiudadHechos(Ciudad ciudadHechos) {
		this.ciudadHechos = ciudadHechos;
	}

	public EstadoCaso getEstadoCaso() {
		return estadoCaso;
	}

	public void setEstadoCaso(EstadoCaso estadoCaso) {
		this.estadoCaso = estadoCaso;
	}

	public TipoCaso getTipoCaso() {
		return tipoCaso;
	}

	public void setTipoCaso(TipoCaso tipoCaso) {
		this.tipoCaso = tipoCaso;
	}

	public String getDireccionProceso() {
		return direccionProceso;
	}

	public void setDireccionProceso(String direccionProceso) {
		this.direccionProceso = direccionProceso;
	}

    
}
