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
public class CuentaDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(CuentaDTO.class);
    private String activa;
    private String clave;
    private String cuenId;
    private Double saldo;
    private Long clieId_Cliente;

    public String getActiva() {
        return activa;
    }

    public void setActiva(String activa) {
        this.activa = activa;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getCuenId() {
        return cuenId;
    }

    public void setCuenId(String cuenId) {
        this.cuenId = cuenId;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Long getClieId_Cliente() {
        return clieId_Cliente;
    }

    public void setClieId_Cliente(Long clieId_Cliente) {
        this.clieId_Cliente = clieId_Cliente;
    }
}
