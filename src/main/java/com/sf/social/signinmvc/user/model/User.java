package com.sf.social.signinmvc.user.model;

import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.sf.social.signinmvc.common.model.BaseEntity;

/**
 * @author Petri Kainulainen
 */
@Entity
@Table(name = "usuarios")
public class User extends BaseEntity<String> {

	@Id
    @Basic(optional = false)
    @Column(name = "CDUSUARIO")
    private String id;

    @Column(name = "DSEMAIL", length = 100, nullable = false, unique = true)
    private String email;

    @Column(name = "DSNOMBRE", length = 100,nullable = false)
    private String nombre;

    @Column(name = "DSAPELLIDO", length = 100, nullable = false)
    private String apellido;

    @Column(name = "password", length = 255)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "DSROL", length = 20, nullable = false)
    private Role role;

    @Enumerated(EnumType.STRING)
    @Column(name = "sign_in_provider", length = 20)
    private SocialMediaService signInProvider;
    
    @Basic(optional = false)
    @Column(name = "SNACTIVO")
    private String activo;
    @Column(name = "DSFOTO")
    private String foto;
    
    // Número tarjeta profesional de los usuarios que son profesionales
    @Column(name = "NMTARJETAPROFESIONAL")
    private String numeroTarjetaProfesional;
    // Número de telefono de los usuarios
    @Column(name = "NMTELEFONO")
    private String numeroTelefono;
    
    @Column(name = "DSDIRECCION")
    private String direccion;
    

    public User() {

    }
    
    public User(String id) {
    	this.id = id;
    }
    
    

    public void setId(String id) {
        this.id = id;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    @Override
    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public SocialMediaService getSignInProvider() {
        return signInProvider;
    }
    
    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
    
    public String getNumeroTarjetaProfesional() {
		return numeroTarjetaProfesional;
	}

	public void setNumeroTarjetaProfesional(String numeroTarjetaProfesional) {
		this.numeroTarjetaProfesional = numeroTarjetaProfesional;
	}

	public String getNumeroTelefono() {
		return numeroTelefono;
	}

	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

		@Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("creationTime", this.getCreationTime())
                .append("email", email)
                .append("nombre", nombre)
                .append("apellido", apellido)
                .append("modificationTime", this.getModificationTime())
                .append("signInProvider", this.getSignInProvider())
                .append("version", this.getVersion())
                .append("activo", this.getActivo())
                .append("foto", this.getFoto())
                .append("numeroTarjetaProfesional", numeroTarjetaProfesional)
                .append("numeroTelefono", numeroTarjetaProfesional)
                .append("direccion", direccion)
                .toString();
    }

    public static class Builder {

        private User user;

        public Builder() {
            user = new User();
            user.role = Role.ROLE_USER;
        }

        public Builder email(String email) {
            user.email = email;
            return this;
        }

        public Builder nombre(String nombre) {
            user.nombre = nombre;
            return this;
        }

        public Builder apellido(String apellido) {
            user.apellido = apellido;
            return this;
        }

        public Builder password(String password) {
            user.password = password;
            return this;
        }

        public Builder signInProvider(SocialMediaService signInProvider) {
            user.signInProvider = signInProvider;
            return this;
        }
        
        public Builder activo(String activo) {
            user.activo = activo;
            return this;
        }
        
        public Builder foto(String foto) {
            user.foto = foto;
            return this;
        }
        
        public Builder numeroTarjetaProfesional(String numeroTarjetaProfesional) {
            user.numeroTarjetaProfesional = numeroTarjetaProfesional;
            return this;
        }
        
        public Builder numeroTelefono(String numeroTelefono) {
            user.numeroTelefono = numeroTelefono;
            return this;
        }
        public Builder direccion(String direccion) {
            user.direccion = direccion;
            return this;
        }
        
        public User build() {
            return user;
        }
        
        
    }
}
