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
@Table(name = "cuenta", schema = "public")
public class Cuenta implements java.io.Serializable {
    @Id
    private String cuenId;
    @NotNull
    private Cliente cliente;
    @NotNull
    @NotEmpty
    @Size(max = 1)
    private String activa;
    @NotNull
    @NotEmpty
    @Size(max = 255)
    private String clave;
    @NotNull
    private Double saldo;
    private Set<CuentaRegistrada> cuentaRegistradas = new HashSet<CuentaRegistrada>(0);
    private Set<Transaccion> transaccions = new HashSet<Transaccion>(0);

    public Cuenta() {
    }

    public Cuenta(String cuenId, String activa, String clave, Cliente cliente,
        Set<CuentaRegistrada> cuentaRegistradas, Double saldo,
        Set<Transaccion> transaccions) {
        this.cuenId = cuenId;
        this.cliente = cliente;
        this.activa = activa;
        this.clave = clave;
        this.saldo = saldo;
        this.cuentaRegistradas = cuentaRegistradas;
        this.transaccions = transaccions;
    }

    public String getCuenId() {
        return this.cuenId;
    }

    public void setCuenId(String cuenId) {
        this.cuenId = cuenId;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getActiva() {
        return this.activa;
    }

    public void setActiva(String activa) {
        this.activa = activa;
    }

    public String getClave() {
        return this.clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Set<CuentaRegistrada> getCuentaRegistradas() {
        return this.cuentaRegistradas;
    }

    public void setCuentaRegistradas(Set<CuentaRegistrada> cuentaRegistradas) {
        this.cuentaRegistradas = cuentaRegistradas;
    }

    public Set<Transaccion> getTransaccions() {
        return this.transaccions;
    }

    public void setTransaccions(Set<Transaccion> transaccions) {
        this.transaccions = transaccions;
    }
}
