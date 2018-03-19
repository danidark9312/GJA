package com.gja.gestionCasos.actividades.entities;
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author DESARROLLADOR6
 */
@Entity
@Table(name = "actividades_caso")
@NamedQueries({
    @NamedQuery(name = "ActividadCaso.findAll", query = "SELECT a FROM ActividadCaso a")})
public class ActividadCaso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cdactividadparticular")
    private Integer codigoActividadParticular;
    @Basic(optional = false)
    @Column(name = "dsactividad")
    private String nombreActividad;
    @Basic(optional = false)
    @Column(name = "felimite")
    @Temporal(TemporalType.DATE)
    private Date fechaLimite;
    @Basic(optional = false)
    @Column(name = "isfinalizada")
    private String finalizada;
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
    private Date fechaUltimaModificacion;
    @Column(name = "dsdetalle")
    private String detalle;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "actividadParticular", fetch = FetchType.EAGER)
    private List<TareaParticularCaso> tareaParticularCasoSet;

    public ActividadCaso() {
    }

    public ActividadCaso(Integer codigoActividadParticular) {
        this.codigoActividadParticular = codigoActividadParticular;
    }

	public ActividadCaso(Integer codigoActividadParticular,
			String nombreActividad, Date fechaLimite, String finalizada,
			String usuarioCreacion, String usuarioUltimaModificacion,
			Date fechaCreacion, Date fechaUltimaModificacion, String detalle) {
		super();
		this.codigoActividadParticular = codigoActividadParticular;
		this.nombreActividad = nombreActividad;
		this.fechaLimite = fechaLimite;
		this.finalizada = finalizada;
		this.usuarioCreacion = usuarioCreacion;
		this.usuarioUltimaModificacion = usuarioUltimaModificacion;
		this.fechaCreacion = fechaCreacion;
		this.fechaUltimaModificacion = fechaUltimaModificacion;
		this.detalle = detalle;
	}

	public Integer getCodigoActividadParticular() {
		return codigoActividadParticular;
	}

	public void setCodigoActividadParticular(Integer codigoActividadParticular) {
		this.codigoActividadParticular = codigoActividadParticular;
	}

	public String getNombreActividad() {
		return nombreActividad;
	}

	public void setNombreActividad(String nombreActividad) {
		this.nombreActividad = nombreActividad;
	}

	public Date getFechaLimite() {
		return fechaLimite;
	}

	public void setFechaLimite(Date fechaLimite) {
		this.fechaLimite = fechaLimite;
	}

	public String getFinalizada() {
		return finalizada;
	}

	public void setFinalizada(String finalizada) {
		this.finalizada = finalizada;
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

	public Date getFechaUltimaModificacion() {
		return fechaUltimaModificacion;
	}

	public void setFechaUltimaModificacion(Date fechaUltimaModificacion) {
		this.fechaUltimaModificacion = fechaUltimaModificacion;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public List<TareaParticularCaso> getTareaParticularCasoSet() {
		return tareaParticularCasoSet;
	}

	public void setTareaParticularCasoSet(
			List<TareaParticularCaso> tareaParticularCasoSet) {
		this.tareaParticularCasoSet = tareaParticularCasoSet;
	}

 
}
