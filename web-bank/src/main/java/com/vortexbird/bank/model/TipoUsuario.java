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
@Table(name = "tipoUsuario", schema = "public")
public class TipoUsuario implements java.io.Serializable {
    @Id
    private Long tiusId;
    @NotNull
    @NotEmpty
    @Size(max = 1)
    private String activo;
    @NotNull
    @NotEmpty
    @Size(max = 255)
    private String nombre;
    private Set<Usuario> usuarios = new HashSet<Usuario>(0);

    public TipoUsuario() {
    }

    public TipoUsuario(Long tiusId, String activo, String nombre,
        Set<Usuario> usuarios) {
        this.tiusId = tiusId;
        this.activo = activo;
        this.nombre = nombre;
        this.usuarios = usuarios;
    }

    public Long getTiusId() {
        return this.tiusId;
    }

    public void setTiusId(Long tiusId) {
        this.tiusId = tiusId;
    }

    public String getActivo() {
        return this.activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Usuario> getUsuarios() {
        return this.usuarios;
    }

    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
