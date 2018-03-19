package com.gja.gestionCasos.maestros.entities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
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
@Table(name = "usuario")
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")})
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CDUSUARIO")
    private String cdusuario;
    @Basic(optional = false)
    @Column(name = "DSNOMBRE")
    private String dsnombre;
    @Basic(optional = false)
    @Column(name = "DSAPELLIDO")
    private String dsapellido;
    @Column(name = "dstarjetaprofesional")
    private String dstarjetaprofesional;
    @Basic(optional = false)
    @Column(name = "nmidentificacion")
    private String nmidentificacion;
    @Basic(optional = false)
    @Column(name = "DSEMAIL")
    private String dsemail;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Column(name = "SNACTIVO")
    private String snactivo;
    @Basic(optional = false)
    @Column(name = "FECREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecreacion;
    @Basic(optional = false)
    @Column(name = "FEMODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date femodificacion;
    @Basic(optional = false)
    @Column(name = "DSROL")
    private String dsrol;
    @Column(name = "sign_in_provider")
    private String signInProvider;
    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private Set<CasoEquipoCaso> casoEquipoCasoSet;

    public Usuario() {
    }

    public Usuario(String cdusuario) {
        this.cdusuario = cdusuario;
    }

    public Usuario(String cdusuario, String dsnombre, String dsapellido, String nmidentificacion, String dsemail, String password, String snactivo, Date fecreacion, Date femodificacion, String dsrol) {
        this.cdusuario = cdusuario;
        this.dsnombre = dsnombre;
        this.dsapellido = dsapellido;
        this.nmidentificacion = nmidentificacion;
        this.dsemail = dsemail;
        this.password = password;
        this.snactivo = snactivo;
        this.fecreacion = fecreacion;
        this.femodificacion = femodificacion;
        this.dsrol = dsrol;
    }

    public String getCdusuario() {
        return cdusuario;
    }

    public void setCdusuario(String cdusuario) {
        this.cdusuario = cdusuario;
    }

    public String getDsnombre() {
        return dsnombre;
    }

    public void setDsnombre(String dsnombre) {
        this.dsnombre = dsnombre;
    }

    public String getDsapellido() {
        return dsapellido;
    }

    public void setDsapellido(String dsapellido) {
        this.dsapellido = dsapellido;
    }

    public String getDstarjetaprofesional() {
        return dstarjetaprofesional;
    }

    public void setDstarjetaprofesional(String dstarjetaprofesional) {
        this.dstarjetaprofesional = dstarjetaprofesional;
    }

    public String getNmidentificacion() {
        return nmidentificacion;
    }

    public void setNmidentificacion(String nmidentificacion) {
        this.nmidentificacion = nmidentificacion;
    }

    public String getDsemail() {
        return dsemail;
    }

    public void setDsemail(String dsemail) {
        this.dsemail = dsemail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSnactivo() {
        return snactivo;
    }

    public void setSnactivo(String snactivo) {
        this.snactivo = snactivo;
    }

    public Date getFecreacion() {
        return fecreacion;
    }

    public void setFecreacion(Date fecreacion) {
        this.fecreacion = fecreacion;
    }

    public Date getFemodificacion() {
        return femodificacion;
    }

    public void setFemodificacion(Date femodificacion) {
        this.femodificacion = femodificacion;
    }

    public String getDsrol() {
        return dsrol;
    }

    public void setDsrol(String dsrol) {
        this.dsrol = dsrol;
    }

    public String getSignInProvider() {
        return signInProvider;
    }

    public void setSignInProvider(String signInProvider) {
        this.signInProvider = signInProvider;
    }

    public Set<CasoEquipoCaso> getCasoEquipoCasoSet() {
        return casoEquipoCasoSet;
    }

    public void setCasoEquipoCasoSet(Set<CasoEquipoCaso> casoEquipoCasoSet) {
        this.casoEquipoCasoSet = casoEquipoCasoSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdusuario != null ? cdusuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.cdusuario == null && other.cdusuario != null) || (this.cdusuario != null && !this.cdusuario.equals(other.cdusuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Usuario[ cdusuario=" + cdusuario + " ]";
    }
    
}
