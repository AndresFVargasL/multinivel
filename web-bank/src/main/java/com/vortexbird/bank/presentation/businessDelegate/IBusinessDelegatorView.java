package com.vortexbird.bank.presentation.businessDelegate;

import com.vortexbird.bank.model.Cliente;
import com.vortexbird.bank.model.Cuenta;
import com.vortexbird.bank.model.CuentaRegistrada;
import com.vortexbird.bank.model.TipoDocumento;
import com.vortexbird.bank.model.TipoTransaccion;
import com.vortexbird.bank.model.TipoUsuario;
import com.vortexbird.bank.model.Transaccion;
import com.vortexbird.bank.model.Usuario;
import com.vortexbird.bank.model.control.ClienteLogic;
import com.vortexbird.bank.model.control.CuentaLogic;
import com.vortexbird.bank.model.control.CuentaRegistradaLogic;
import com.vortexbird.bank.model.control.IClienteLogic;
import com.vortexbird.bank.model.control.ICuentaLogic;
import com.vortexbird.bank.model.control.ICuentaRegistradaLogic;
import com.vortexbird.bank.model.control.ITipoDocumentoLogic;
import com.vortexbird.bank.model.control.ITipoTransaccionLogic;
import com.vortexbird.bank.model.control.ITipoUsuarioLogic;
import com.vortexbird.bank.model.control.ITransaccionLogic;
import com.vortexbird.bank.model.control.IUsuarioLogic;
import com.vortexbird.bank.model.control.TipoDocumentoLogic;
import com.vortexbird.bank.model.control.TipoTransaccionLogic;
import com.vortexbird.bank.model.control.TipoUsuarioLogic;
import com.vortexbird.bank.model.control.TransaccionLogic;
import com.vortexbird.bank.model.control.UsuarioLogic;
import com.vortexbird.bank.model.dto.ClienteDTO;
import com.vortexbird.bank.model.dto.CuentaDTO;
import com.vortexbird.bank.model.dto.CuentaRegistradaDTO;
import com.vortexbird.bank.model.dto.TipoDocumentoDTO;
import com.vortexbird.bank.model.dto.TipoTransaccionDTO;
import com.vortexbird.bank.model.dto.TipoUsuarioDTO;
import com.vortexbird.bank.model.dto.TransaccionDTO;
import com.vortexbird.bank.model.dto.UsuarioDTO;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface IBusinessDelegatorView {
    public List<Cuenta> getCuenta() throws Exception;

    public void saveCuenta(Cuenta entity) throws Exception;

    public void deleteCuenta(Cuenta entity) throws Exception;

    public void updateCuenta(Cuenta entity) throws Exception;

    public Cuenta getCuenta(String cuenId) throws Exception;

    public List<Cuenta> findByCriteriaInCuenta(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Cuenta> findPageCuenta(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberCuenta() throws Exception;

    public List<CuentaDTO> getDataCuenta() throws Exception;

    public void validateCuenta(Cuenta cuenta) throws Exception;

    public List<CuentaRegistrada> getCuentaRegistrada()
        throws Exception;

    public void saveCuentaRegistrada(CuentaRegistrada entity)
        throws Exception;

    public void deleteCuentaRegistrada(CuentaRegistrada entity)
        throws Exception;

    public void updateCuentaRegistrada(CuentaRegistrada entity)
        throws Exception;

    public CuentaRegistrada getCuentaRegistrada(Long cureId)
        throws Exception;

    public List<CuentaRegistrada> findByCriteriaInCuentaRegistrada(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<CuentaRegistrada> findPageCuentaRegistrada(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberCuentaRegistrada() throws Exception;

    public List<CuentaRegistradaDTO> getDataCuentaRegistrada()
        throws Exception;

    public void validateCuentaRegistrada(CuentaRegistrada cuentaRegistrada)
        throws Exception;

    public List<Transaccion> getTransaccion() throws Exception;

    public void saveTransaccion(Transaccion entity) throws Exception;

    public void deleteTransaccion(Transaccion entity) throws Exception;

    public void updateTransaccion(Transaccion entity) throws Exception;

    public Transaccion getTransaccion(Long tranId) throws Exception;

    public List<Transaccion> findByCriteriaInTransaccion(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Transaccion> findPageTransaccion(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberTransaccion() throws Exception;

    public List<TransaccionDTO> getDataTransaccion() throws Exception;

    public void validateTransaccion(Transaccion transaccion)
        throws Exception;

    public List<Cliente> getCliente() throws Exception;

    public void saveCliente(Cliente entity) throws Exception;

    public void deleteCliente(Cliente entity) throws Exception;

    public void updateCliente(Cliente entity) throws Exception;

    public Cliente getCliente(Long clieId) throws Exception;

    public List<Cliente> findByCriteriaInCliente(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Cliente> findPageCliente(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberCliente() throws Exception;

    public List<ClienteDTO> getDataCliente() throws Exception;

    public void validateCliente(Cliente cliente) throws Exception;

    public List<TipoTransaccion> getTipoTransaccion() throws Exception;

    public void saveTipoTransaccion(TipoTransaccion entity)
        throws Exception;

    public void deleteTipoTransaccion(TipoTransaccion entity)
        throws Exception;

    public void updateTipoTransaccion(TipoTransaccion entity)
        throws Exception;

    public TipoTransaccion getTipoTransaccion(Long titrId)
        throws Exception;

    public List<TipoTransaccion> findByCriteriaInTipoTransaccion(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<TipoTransaccion> findPageTipoTransaccion(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberTipoTransaccion() throws Exception;

    public List<TipoTransaccionDTO> getDataTipoTransaccion()
        throws Exception;

    public void validateTipoTransaccion(TipoTransaccion tipoTransaccion)
        throws Exception;

    public List<TipoDocumento> getTipoDocumento() throws Exception;

    public void saveTipoDocumento(TipoDocumento entity)
        throws Exception;

    public void deleteTipoDocumento(TipoDocumento entity)
        throws Exception;

    public void updateTipoDocumento(TipoDocumento entity)
        throws Exception;

    public TipoDocumento getTipoDocumento(Long tdocId)
        throws Exception;

    public List<TipoDocumento> findByCriteriaInTipoDocumento(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<TipoDocumento> findPageTipoDocumento(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberTipoDocumento() throws Exception;

    public List<TipoDocumentoDTO> getDataTipoDocumento()
        throws Exception;

    public void validateTipoDocumento(TipoDocumento tipoDocumento)
        throws Exception;

    public List<Usuario> getUsuario() throws Exception;

    public void saveUsuario(Usuario entity) throws Exception;

    public void deleteUsuario(Usuario entity) throws Exception;

    public void updateUsuario(Usuario entity) throws Exception;

    public Usuario getUsuario(String usuUsuario) throws Exception;

    public List<Usuario> findByCriteriaInUsuario(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Usuario> findPageUsuario(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberUsuario() throws Exception;

    public List<UsuarioDTO> getDataUsuario() throws Exception;

    public void validateUsuario(Usuario usuario) throws Exception;

    public List<TipoUsuario> getTipoUsuario() throws Exception;

    public void saveTipoUsuario(TipoUsuario entity) throws Exception;

    public void deleteTipoUsuario(TipoUsuario entity) throws Exception;

    public void updateTipoUsuario(TipoUsuario entity) throws Exception;

    public TipoUsuario getTipoUsuario(Long tiusId) throws Exception;

    public List<TipoUsuario> findByCriteriaInTipoUsuario(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<TipoUsuario> findPageTipoUsuario(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberTipoUsuario() throws Exception;

    public List<TipoUsuarioDTO> getDataTipoUsuario() throws Exception;

    public void validateTipoUsuario(TipoUsuario tipoUsuario)
        throws Exception;
}
