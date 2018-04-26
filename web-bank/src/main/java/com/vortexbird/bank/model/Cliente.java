package com.vortexbird.bank.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
@Entity
@Table(name = "cliente", schema = "public")
public class Cliente implements java.io.Serializable {
    @Id
    private Long clieId;
    @NotNull
    private TipoDocumento tipoDocumento;
    @NotNull
    @NotEmpty
    @Size(max = 1)
    private String activo;
    @NotNull
    @NotEmpty
    @Size(max = 255)
    private String direccion;
    private String email;
    @NotNull
    @NotEmpty
    @Size(max = 255)
    private String nombre;
    @NotNull
    @NotEmpty
    @Size(max = 255)
    private String telefono;
    private Set<CuentaRegistrada> cuentaRegistradas = new HashSet<CuentaRegistrada>(0);
    private Set<Cuenta> cuentas = new HashSet<Cuenta>(0);

    public Cliente() {
    }

    public Cliente(Long clieId, String activo,
        Set<CuentaRegistrada> cuentaRegistradas, Set<Cuenta> cuentas,
        String direccion, String email, String nombre, String telefono,
        TipoDocumento tipoDocumento) {
        this.clieId = clieId;
        this.tipoDocumento = tipoDocumento;
        this.activo = activo;
        this.direccion = direccion;
        this.email = email;
        this.nombre = nombre;
        this.telefono = telefono;
        this.cuentaRegistradas = cuentaRegistradas;
        this.cuentas = cuentas;
    }

    public Long getClieId() {
        return this.clieId;
    }

    public void setClieId(Long clieId) {
        this.clieId = clieId;
    }

    public TipoDocumento getTipoDocumento() {
        return this.tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getActivo() {
        return this.activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Set<CuentaRegistrada> getCuentaRegistradas() {
        return this.cuentaRegistradas;
    }

    public void setCuentaRegistradas(Set<CuentaRegistrada> cuentaRegistradas) {
        this.cuentaRegistradas = cuentaRegistradas;
    }

    public Set<Cuenta> getCuentas() {
        return this.cuentas;
    }

    public void setCuentas(Set<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }
}
