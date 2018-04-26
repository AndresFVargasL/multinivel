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
@Table(name = "transaccion", schema = "public")
public class Transaccion implements java.io.Serializable {
    @Id
    private Long tranId;
    @NotNull
    private Cuenta cuenta;
    @NotNull
    private TipoTransaccion tipoTransaccion;
    @NotNull
    private Usuario usuario;
    @NotNull
    private Date fecha;
    @NotNull
    private Double valor;

    public Transaccion() {
    }

    public Transaccion(Long tranId, Cuenta cuenta, Date fecha,
        TipoTransaccion tipoTransaccion, Usuario usuario, Double valor) {
        this.tranId = tranId;
        this.cuenta = cuenta;
        this.tipoTransaccion = tipoTransaccion;
        this.usuario = usuario;
        this.fecha = fecha;
        this.valor = valor;
    }

    public Long getTranId() {
        return this.tranId;
    }

    public void setTranId(Long tranId) {
        this.tranId = tranId;
    }

    public Cuenta getCuenta() {
        return this.cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public TipoTransaccion getTipoTransaccion() {
        return this.tipoTransaccion;
    }

    public void setTipoTransaccion(TipoTransaccion tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getValor() {
        return this.valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
