package com.gja.gestionCasos.actividades.entities;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import java.util.Date;
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

import com.gja.gestionCasos.casos.entities.CasoEquipoCaso;

/**
 *
 * @author DESARROLLADOR6
 */
@Entity
@Table(name = "tareas_particulares_caso")
@NamedQueries({
    @NamedQuery(name = "TareaParticularCaso.findAll", query = "SELECT t FROM TareaParticularCaso t")})
public class TareaParticularCaso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cdtareaparticular")
    private Integer codigoTarea;
    @Basic(optional = false)
    @Column(name = "dstarea")
    private String tarea;
    @Basic(optional = false)
    @Column(name = "dsdetalle")
    private String detalle;
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
    @Basic(optional = false)
    @Column(name = "cdcaso", insertable=false, updatable = false)
    private Integer codigoCaso;
    @Basic(optional = false)
    @Column(name = "cdequipocaso", insertable=false, updatable = false)
    private Integer codigoEquipoCaso;
    @Basic(optional = false)
    @Column(name = "cdmiembro", insertable=false, updatable = false)
    private Integer codigoMiembro;
    @JoinColumns({
        @JoinColumn(name = "cdcaso", referencedColumnName = "cdcaso"),
        @JoinColumn(name = "cdequipocaso", referencedColumnName = "cdequipocaso"),
        @JoinColumn(name = "cdmiembro", referencedColumnName = "cdmiembro")})
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private CasoEquipoCaso casoEquipoCaso;
    @JoinColumn(name = "cdactividadparticular", referencedColumnName = "cdactividadparticular")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ActividadCaso actividadParticular;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdtareaparticular", fetch = FetchType.LAZY)
    private Set<Archivo> archivoSet;

    public TareaParticularCaso() {
    }

    public TareaParticularCaso(Integer codigoTarea) {
        this.codigoTarea = codigoTarea;
    }


	public TareaParticularCaso(Integer codigoTarea, String tarea,
			String detalle, Date fechaLimite, String finalizada,
			String usuarioCreacion, String usuarioUltimaModificacion,
			Date fechaCreacion, Date fechaUltimaModificacion) {
		super();
		this.codigoTarea = codigoTarea;
		this.tarea = tarea;
		this.detalle = detalle;
		this.fechaLimite = fechaLimite;
		this.finalizada = finalizada;
		this.usuarioCreacion = usuarioCreacion;
		this.usuarioUltimaModificacion = usuarioUltimaModificacion;
		this.fechaCreacion = fechaCreacion;
		this.fechaUltimaModificacion = fechaUltimaModificacion;
	}

	public Integer getCodigoTarea() {
		return codigoTarea;
	}

	public void setCodigoTarea(Integer codigoTarea) {
		this.codigoTarea = codigoTarea;
	}

	public String getTarea() {
		return tarea;
	}

	public void setTarea(String tarea) {
		this.tarea = tarea;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
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

	public CasoEquipoCaso getCasoEquipoCaso() {
		return casoEquipoCaso;
	}

	public void setCasoEquipoCaso(CasoEquipoCaso casoEquipoCaso) {
		this.casoEquipoCaso = casoEquipoCaso;
	}

	public ActividadCaso getActividadParticular() {
		return actividadParticular;
	}

	public void setActividadParticular(ActividadCaso actividadParticular) {
		this.actividadParticular = actividadParticular;
	}

	public Set<Archivo> getArchivoSet() {
		return archivoSet;
	}

	public void setArchivoSet(Set<Archivo> archivoSet) {
		this.archivoSet = archivoSet;
	}

	public Integer getCodigoCaso() {
		return codigoCaso;
	}

	public void setCodigoCaso(Integer codigoCaso) {
		this.codigoCaso = codigoCaso;
	}

	public Integer getCodigoEquipoCaso() {
		return codigoEquipoCaso;
	}

	public void setCodigoEquipoCaso(Integer codigoEquipoCaso) {
		this.codigoEquipoCaso = codigoEquipoCaso;
	}

	public Integer getCodigoMiembro() {
		return codigoMiembro;
	}

	public void setCodigoMiembro(Integer codigoMiembro) {
		this.codigoMiembro = codigoMiembro;
	}
	
	
	
	    
}
