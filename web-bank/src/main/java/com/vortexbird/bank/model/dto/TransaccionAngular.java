package com.vortexbird.bank.model.dto;

public class TransaccionAngular {
	
	public Double valor;
	public String cuenta;
	public Long tipoTransaccion;
	public String usuario;
	public Long cedula;
	public String clave;
	
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public String getCuenta() {
		return cuenta;
	}
	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}
	public Long getTipoTransaccion() {
		return tipoTransaccion;
	}
	public void setTipoTransaccion(Long tipoTransaccion) {
		this.tipoTransaccion = tipoTransaccion;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public Long getCedula() {
		return cedula;
	}
	public void setCedula(Long cedula) {
		this.cedula = cedula;
	}
	
	

}
