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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gja.gestionCasos.maestros.entities.Instancia;

/**
 *
 * @author DESARROLLADOR6
 */
@Entity
@Table(name = "radicados")
@NamedQueries({
    @NamedQuery(name = "Radicado.findAll", query = "SELECT r FROM Radicado r")})
public class Radicado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cdradicado")
    private String codigo;
    @Basic(optional = false)
    @Column(name = "isactivo")
    private String activo;
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
    @Column(name = "isacumulado")
    private String acumulado;
    @Column(name = "dscomentarioacumulado")
    private String comentarioAcumulado;
    @Column(name = "dsacumuladocon")
    private String acumuladoCon;
    @JoinColumn(name = "cdinstancia", referencedColumnName = "cdinstancia")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Instancia instancia;
    @JoinColumn(name = "cdcaso", referencedColumnName = "cdcaso")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Caso caso;
    @JsonIgnore
    @OneToMany(mappedBy = "radicadoAcumulado", fetch = FetchType.LAZY)
    private List<Radicado> radicadoSet;
    @JoinColumn(name = "cdradicadoacumulado", referencedColumnName = "cdradicado")
    @ManyToOne(fetch = FetchType.LAZY)
    private Radicado radicadoAcumulado;

    public Radicado() {
    }

    public Radicado(String codigo) {
        this.codigo = codigo;
    }

	public Radicado(String codigo, String activo, String usuarioCreacion,
			String usuarioUltimaModificacion, Date fechaCreacion,
			Date fechaUltimaModificacion) {
		this.codigo = codigo;
		this.activo = activo;
		this.usuarioCreacion = usuarioCreacion;
		this.usuarioUltimaModificacion = usuarioUltimaModificacion;
		this.fechaCreacion = fechaCreacion;
		this.fechaUltimaModificacion = fechaUltimaModificacion;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
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

	public String getAcumulado() {
		return acumulado;
	}

	public void setAcumulado(String acumulado) {
		this.acumulado = acumulado;
	}

	public String getComentarioAcumulado() {
		return comentarioAcumulado;
	}

	public void setComentarioAcumulado(String comentarioAcumulado) {
		this.comentarioAcumulado = comentarioAcumulado;
	}

	public Instancia getInstancia() {
		return instancia;
	}

	public void setInstancia(Instancia instancia) {
		this.instancia = instancia;
	}

	public Caso getCaso() {
		return caso;
	}

	public void setCaso(Caso caso) {
		this.caso = caso;
	}

	public List<Radicado> getRadicadoSet() {
		return radicadoSet;
	}

	public void setRadicadoSet(List<Radicado> radicadoSet) {
		this.radicadoSet = radicadoSet;
	}

	public Radicado getRadicadoAcumulado() {
		return radicadoAcumulado;
	}

	public void setRadicadoAcumulado(Radicado radicadoAcumulado) {
		this.radicadoAcumulado = radicadoAcumulado;
	}

	public String getAcumuladoCon() {
		return acumuladoCon;
	}

	public void setAcumuladoCon(String acumuladoCon) {
		this.acumuladoCon = acumuladoCon;
	}






    
}
