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
public class CuentaRegistradaDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(CuentaRegistradaDTO.class);
    private Long cureId;
    private Long clieId_Cliente;
    private String cuenId_Cuenta;

    public Long getCureId() {
        return cureId;
    }

    public void setCureId(Long cureId) {
        this.cureId = cureId;
    }

    public Long getClieId_Cliente() {
        return clieId_Cliente;
    }

    public void setClieId_Cliente(Long clieId_Cliente) {
        this.clieId_Cliente = clieId_Cliente;
    }

    public String getCuenId_Cuenta() {
        return cuenId_Cuenta;
    }

    public void setCuenId_Cuenta(String cuenId_Cuenta) {
        this.cuenId_Cuenta = cuenId_Cuenta;
    }
}
