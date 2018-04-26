package com.vortexbird.bank.model;

import org.hibernate.validator.constraints.*;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.*;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
@Entity
@Table(name = "cuentaRegistrada", schema = "public")
public class CuentaRegistrada implements java.io.Serializable {
    @Id
    private Long cureId;
    @NotNull
    private Cliente cliente;
    @NotNull
    private Cuenta cuenta;

    public CuentaRegistrada() {
    }

    public CuentaRegistrada(Long cureId, Cliente cliente, Cuenta cuenta) {
        this.cureId = cureId;
        this.cliente = cliente;
        this.cuenta = cuenta;
    }

    public Long getCureId() {
        return this.cureId;
    }

    public void setCureId(Long cureId) {
        this.cureId = cureId;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cuenta getCuenta() {
        return this.cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
}
