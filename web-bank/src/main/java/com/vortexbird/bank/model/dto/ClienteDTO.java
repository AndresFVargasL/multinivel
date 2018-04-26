package com.vortexbird.bank.model.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

import java.sql.*;

import java.util.Date;


/**
*
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public class ClienteDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(ClienteDTO.class);
    private String activo;
    private Long clieId;
    private String direccion;
    private String email;
    private String nombre;
    private String telefono;
    private Long tdocId_TipoDocumento;

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public Long getClieId() {
        return clieId;
    }

    public void setClieId(Long clieId) {
        this.clieId = clieId;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Long getTdocId_TipoDocumento() {
        return tdocId_TipoDocumento;
    }

    public void setTdocId_TipoDocumento(Long tdocId_TipoDocumento) {
        this.tdocId_TipoDocumento = tdocId_TipoDocumento;
    }
}
