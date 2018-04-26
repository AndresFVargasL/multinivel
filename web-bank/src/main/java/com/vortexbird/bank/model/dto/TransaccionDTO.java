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
public class TransaccionDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(TransaccionDTO.class);
    private Date fecha;
    private Long tranId;
    private Double valor;
    private String cuenId_Cuenta;
    private Long titrId_TipoTransaccion;
    private String usuUsuario_Usuario;

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Long getTranId() {
        return tranId;
    }

    public void setTranId(Long tranId) {
        this.tranId = tranId;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getCuenId_Cuenta() {
        return cuenId_Cuenta;
    }

    public void setCuenId_Cuenta(String cuenId_Cuenta) {
        this.cuenId_Cuenta = cuenId_Cuenta;
    }

    public Long getTitrId_TipoTransaccion() {
        return titrId_TipoTransaccion;
    }

    public void setTitrId_TipoTransaccion(Long titrId_TipoTransaccion) {
        this.titrId_TipoTransaccion = titrId_TipoTransaccion;
    }

    public String getUsuUsuario_Usuario() {
        return usuUsuario_Usuario;
    }

    public void setUsuUsuario_Usuario(String usuUsuario_Usuario) {
        this.usuUsuario_Usuario = usuUsuario_Usuario;
    }
}
