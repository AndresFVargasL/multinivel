package com.vortexbird.bank.model;

import org.hibernate.validator.constraints.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.*;
import javax.validation.constraints.NotEmpty;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
@Entity
@Table(name = "usuario", schema = "public")
public class Usuario implements java.io.Serializable {
    @Id
    private String usuUsuario;
    @NotNull
    private TipoUsuario tipoUsuario;
    @NotNull
    @NotEmpty
    @Size(max = 1)
    private String activo;
    @NotNull
    @NotEmpty
    @Size(max = 255)
    private String clave;
    @NotNull
    private Long identificacion;
    @NotNull
    @NotEmpty
    @Size(max = 255)
    private String nombre;
    private Set<Transaccion> transaccions = new HashSet<Transaccion>(0);

    public Usuario() {
    }

    public Usuario(String usuUsuario, String activo, String clave,
        Long identificacion, String nombre, TipoUsuario tipoUsuario,
        Set<Transaccion> transaccions) {
        this.usuUsuario = usuUsuario;
        this.tipoUsuario = tipoUsuario;
        this.activo = activo;
        this.clave = clave;
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.transaccions = transaccions;
    }

    public String getUsuUsuario() {
        return this.usuUsuario;
    }

    public void setUsuUsuario(String usuUsuario) {
        this.usuUsuario = usuUsuario;
    }

    public TipoUsuario getTipoUsuario() {
        return this.tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getActivo() {
        return this.activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public String getClave() {
        return this.clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Long getIdentificacion() {
        return this.identificacion;
    }

    public void setIdentificacion(Long identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Transaccion> getTransaccions() {
        return this.transaccions;
    }

    public void setTransaccions(Set<Transaccion> transaccions) {
        this.transaccions = transaccions;
    }
}
