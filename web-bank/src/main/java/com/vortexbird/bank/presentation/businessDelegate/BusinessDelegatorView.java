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
import com.vortexbird.bank.model.dto.Response;
import com.vortexbird.bank.model.dto.TipoDocumentoDTO;
import com.vortexbird.bank.model.dto.TipoTransaccionDTO;
import com.vortexbird.bank.model.dto.TipoUsuarioDTO;
import com.vortexbird.bank.model.dto.TransaccionDTO;
import com.vortexbird.bank.model.dto.UsuarioDTO;
import com.vortexbird.bank.presentation.businessDelegate.IBusinessDelegatorView;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import java.sql.*;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* Use a Business Delegate to reduce coupling between presentation-tier clients and business services.
* The Business Delegate hides the underlying implementation details of the business service, such as lookup and access details of the EJB architecture.
*
* The Business Delegate acts as a client-side business abstraction; it provides an abstraction for, and thus hides,
* the implementation of the business services. Using a Business Delegate reduces the coupling between presentation-tier clients and
* the system's business services. Depending on the implementation strategy, the Business Delegate may shield clients from possible
* volatility in the implementation of the business service API. Potentially, this reduces the number of changes that must be made to the
* presentation-tier client code when the business service API or its underlying implementation changes.
*
* However, interface methods in the Business Delegate may still require modification if the underlying business service API changes.
* Admittedly, though, it is more likely that changes will be made to the business service rather than to the Business Delegate.
*
* Often, developers are skeptical when a design goal such as abstracting the business layer causes additional upfront work in return
* for future gains. However, using this pattern or its strategies results in only a small amount of additional upfront work and provides
* considerable benefits. The main benefit is hiding the details of the underlying service. For example, the client can become transparent
* to naming and lookup services. The Business Delegate also handles the exceptions from the business services, such as java.rmi.Remote
* exceptions, Java Messages Service (JMS) exceptions and so on. The Business Delegate may intercept such service level exceptions and
* generate application level exceptions instead. Application level exceptions are easier to handle by the clients, and may be user friendly.
* The Business Delegate may also transparently perform any retry or recovery operations necessary in the event of a service failure without
* exposing the client to the problem until it is determined that the problem is not resolvable. These gains present a compelling reason to
* use the pattern.
*
* Another benefit is that the delegate may cache results and references to remote business services. Caching can significantly improve performance,
* because it limits unnecessary and potentially costly round trips over the network.
*
* A Business Delegate uses a component called the Lookup Service. The Lookup Service is responsible for hiding the underlying implementation
* details of the business service lookup code. The Lookup Service may be written as part of the Delegate, but we recommend that it be
* implemented as a separate component, as outlined in the Service Locator pattern (See "Service Locator" on page 368.)
*
* When the Business Delegate is used with a Session Facade, typically there is a one-to-one relationship between the two.
* This one-to-one relationship exists because logic that might have been encapsulated in a Business Delegate relating to its interaction
* with multiple business services (creating a one-to-many relationship) will often be factored back into a Session Facade.
*
* Finally, it should be noted that this pattern could be used to reduce coupling between other tiers, not simply the presentation and the
* business tiers.
*
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service("BusinessDelegatorView")
public class BusinessDelegatorView implements IBusinessDelegatorView {
    private static final Logger log = LoggerFactory.getLogger(BusinessDelegatorView.class);
    @Autowired
    private ICuentaLogic cuentaLogic;
    @Autowired
    private ICuentaRegistradaLogic cuentaRegistradaLogic;
    @Autowired
    private ITransaccionLogic transaccionLogic;
    @Autowired
    private IClienteLogic clienteLogic;
    @Autowired
    private ITipoTransaccionLogic tipoTransaccionLogic;
    @Autowired
    private ITipoDocumentoLogic tipoDocumentoLogic;
    @Autowired
    private IUsuarioLogic usuarioLogic;
    @Autowired
    private ITipoUsuarioLogic tipoUsuarioLogic;

    public List<Cuenta> getCuenta() throws Exception {
        return cuentaLogic.getCuenta();
    }

    public void saveCuenta(Cuenta entity) throws Exception {
        cuentaLogic.saveCuenta(entity);
    }

    public void deleteCuenta(Cuenta entity) throws Exception {
        cuentaLogic.deleteCuenta(entity);
    }

    public void updateCuenta(Cuenta entity) throws Exception {
        cuentaLogic.updateCuenta(entity);
    }

    public Cuenta getCuenta(String cuenId) throws Exception {
        Cuenta cuenta = null;

        try {
            cuenta = cuentaLogic.getCuenta(cuenId);
        } catch (Exception e) {
            throw e;
        }

        return cuenta;
    }

    public List<Cuenta> findByCriteriaInCuenta(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return cuentaLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Cuenta> findPageCuenta(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return cuentaLogic.findPageCuenta(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberCuenta() throws Exception {
        return cuentaLogic.findTotalNumberCuenta();
    }

    public List<CuentaDTO> getDataCuenta() throws Exception {
        return cuentaLogic.getDataCuenta();
    }

    public void validateCuenta(Cuenta cuenta) throws Exception {
        cuentaLogic.validateCuenta(cuenta);
    }

    public List<CuentaRegistrada> getCuentaRegistrada()
        throws Exception {
        return cuentaRegistradaLogic.getCuentaRegistrada();
    }

    public void saveCuentaRegistrada(CuentaRegistrada entity)
        throws Exception {
        cuentaRegistradaLogic.saveCuentaRegistrada(entity);
    }

    public void deleteCuentaRegistrada(CuentaRegistrada entity)
        throws Exception {
        cuentaRegistradaLogic.deleteCuentaRegistrada(entity);
    }

    public void updateCuentaRegistrada(CuentaRegistrada entity)
        throws Exception {
        cuentaRegistradaLogic.updateCuentaRegistrada(entity);
    }

    public CuentaRegistrada getCuentaRegistrada(Long cureId)
        throws Exception {
        CuentaRegistrada cuentaRegistrada = null;

        try {
            cuentaRegistrada = cuentaRegistradaLogic.getCuentaRegistrada(cureId);
        } catch (Exception e) {
            throw e;
        }

        return cuentaRegistrada;
    }

    public List<CuentaRegistrada> findByCriteriaInCuentaRegistrada(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        return cuentaRegistradaLogic.findByCriteria(variables,
            variablesBetween, variablesBetweenDates);
    }

    public List<CuentaRegistrada> findPageCuentaRegistrada(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        return cuentaRegistradaLogic.findPageCuentaRegistrada(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberCuentaRegistrada() throws Exception {
        return cuentaRegistradaLogic.findTotalNumberCuentaRegistrada();
    }

    public List<CuentaRegistradaDTO> getDataCuentaRegistrada()
        throws Exception {
        return cuentaRegistradaLogic.getDataCuentaRegistrada();
    }

    public void validateCuentaRegistrada(CuentaRegistrada cuentaRegistrada)
        throws Exception {
        cuentaRegistradaLogic.validateCuentaRegistrada(cuentaRegistrada);
    }

    public List<Transaccion> getTransaccion() throws Exception {
        return transaccionLogic.getTransaccion();
    }

    public void saveTransaccion(Transaccion entity) throws Exception {
        transaccionLogic.saveTransaccion(entity);
    }

    public void deleteTransaccion(Transaccion entity) throws Exception {
        transaccionLogic.deleteTransaccion(entity);
    }

    public void updateTransaccion(Transaccion entity) throws Exception {
        transaccionLogic.updateTransaccion(entity);
    }

    public Transaccion getTransaccion(Long tranId) throws Exception {
        Transaccion transaccion = null;

        try {
            transaccion = transaccionLogic.getTransaccion(tranId);
        } catch (Exception e) {
            throw e;
        }

        return transaccion;
    }

    public List<Transaccion> findByCriteriaInTransaccion(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return transaccionLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Transaccion> findPageTransaccion(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return transaccionLogic.findPageTransaccion(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberTransaccion() throws Exception {
        return transaccionLogic.findTotalNumberTransaccion();
    }

    public List<TransaccionDTO> getDataTransaccion() throws Exception {
        return transaccionLogic.getDataTransaccion();
    }

    public void validateTransaccion(Transaccion transaccion)
        throws Exception {
        transaccionLogic.validateTransaccion(transaccion);
    }

    public List<Cliente> getCliente() throws Exception {
        return clienteLogic.getCliente();
    }

    public void saveCliente(Cliente entity) throws Exception {
        clienteLogic.saveCliente(entity);
    }

    public void deleteCliente(Cliente entity) throws Exception {
        clienteLogic.deleteCliente(entity);
    }

    public void updateCliente(Cliente entity) throws Exception {
        clienteLogic.updateCliente(entity);
    }

    public Cliente getCliente(Long clieId) throws Exception {
        Cliente cliente = null;

        try {
            cliente = clienteLogic.getCliente(clieId);
        } catch (Exception e) {
            throw e;
        }

        return cliente;
    }

    public List<Cliente> findByCriteriaInCliente(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return clienteLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Cliente> findPageCliente(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return clienteLogic.findPageCliente(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberCliente() throws Exception {
        return clienteLogic.findTotalNumberCliente();
    }

    public List<ClienteDTO> getDataCliente() throws Exception {
        return clienteLogic.getDataCliente();
    }

    public void validateCliente(Cliente cliente) throws Exception {
        clienteLogic.validateCliente(cliente);
    }

    public List<TipoTransaccion> getTipoTransaccion() throws Exception {
        return tipoTransaccionLogic.getTipoTransaccion();
    }

    public void saveTipoTransaccion(TipoTransaccion entity)
        throws Exception {
        tipoTransaccionLogic.saveTipoTransaccion(entity);
    }

    public void deleteTipoTransaccion(TipoTransaccion entity)
        throws Exception {
        tipoTransaccionLogic.deleteTipoTransaccion(entity);
    }

    public void updateTipoTransaccion(TipoTransaccion entity)
        throws Exception {
        tipoTransaccionLogic.updateTipoTransaccion(entity);
    }

    public TipoTransaccion getTipoTransaccion(Long titrId)
        throws Exception {
        TipoTransaccion tipoTransaccion = null;

        try {
            tipoTransaccion = tipoTransaccionLogic.getTipoTransaccion(titrId);
        } catch (Exception e) {
            throw e;
        }

        return tipoTransaccion;
    }

    public List<TipoTransaccion> findByCriteriaInTipoTransaccion(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        return tipoTransaccionLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<TipoTransaccion> findPageTipoTransaccion(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        return tipoTransaccionLogic.findPageTipoTransaccion(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberTipoTransaccion() throws Exception {
        return tipoTransaccionLogic.findTotalNumberTipoTransaccion();
    }

    public List<TipoTransaccionDTO> getDataTipoTransaccion()
        throws Exception {
        return tipoTransaccionLogic.getDataTipoTransaccion();
    }

    public void validateTipoTransaccion(TipoTransaccion tipoTransaccion)
        throws Exception {
        tipoTransaccionLogic.validateTipoTransaccion(tipoTransaccion);
    }

    public List<TipoDocumento> getTipoDocumento() throws Exception {
        return tipoDocumentoLogic.getTipoDocumento();
    }

    public void saveTipoDocumento(TipoDocumento entity)
        throws Exception {
        tipoDocumentoLogic.saveTipoDocumento(entity);
    }

    public void deleteTipoDocumento(TipoDocumento entity)
        throws Exception {
        tipoDocumentoLogic.deleteTipoDocumento(entity);
    }

    public void updateTipoDocumento(TipoDocumento entity)
        throws Exception {
        tipoDocumentoLogic.updateTipoDocumento(entity);
    }

    public TipoDocumento getTipoDocumento(Long tdocId)
        throws Exception {
        TipoDocumento tipoDocumento = null;

        try {
            tipoDocumento = tipoDocumentoLogic.getTipoDocumento(tdocId);
        } catch (Exception e) {
            throw e;
        }

        return tipoDocumento;
    }

    public List<TipoDocumento> findByCriteriaInTipoDocumento(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        return tipoDocumentoLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<TipoDocumento> findPageTipoDocumento(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return tipoDocumentoLogic.findPageTipoDocumento(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberTipoDocumento() throws Exception {
        return tipoDocumentoLogic.findTotalNumberTipoDocumento();
    }

    public List<TipoDocumentoDTO> getDataTipoDocumento()
        throws Exception {
        return tipoDocumentoLogic.getDataTipoDocumento();
    }

    public void validateTipoDocumento(TipoDocumento tipoDocumento)
        throws Exception {
        tipoDocumentoLogic.validateTipoDocumento(tipoDocumento);
    }

    public List<Usuario> getUsuario() throws Exception {
        return usuarioLogic.getUsuario();
    }

    public void saveUsuario(Usuario entity) throws Exception {
        usuarioLogic.saveUsuario(entity);
    }

    public void deleteUsuario(Usuario entity) throws Exception {
        usuarioLogic.deleteUsuario(entity);
    }

    public void updateUsuario(Usuario entity) throws Exception {
        usuarioLogic.updateUsuario(entity);
    }

    public Usuario getUsuario(String usuUsuario) throws Exception {
        Usuario usuario = null;

        try {
            usuario = usuarioLogic.getUsuario(usuUsuario);
        } catch (Exception e) {
            throw e;
        }

        return usuario;
    }

    public List<Usuario> findByCriteriaInUsuario(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return usuarioLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Usuario> findPageUsuario(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return usuarioLogic.findPageUsuario(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberUsuario() throws Exception {
        return usuarioLogic.findTotalNumberUsuario();
    }

    public List<UsuarioDTO> getDataUsuario() throws Exception {
        return usuarioLogic.getDataUsuario();
    }

    public void validateUsuario(Usuario usuario) throws Exception {
        usuarioLogic.validateUsuario(usuario);
    }

    public List<TipoUsuario> getTipoUsuario() throws Exception {
        return tipoUsuarioLogic.getTipoUsuario();
    }

    public void saveTipoUsuario(TipoUsuario entity) throws Exception {
        tipoUsuarioLogic.saveTipoUsuario(entity);
    }

    public void deleteTipoUsuario(TipoUsuario entity) throws Exception {
        tipoUsuarioLogic.deleteTipoUsuario(entity);
    }

    public void updateTipoUsuario(TipoUsuario entity) throws Exception {
        tipoUsuarioLogic.updateTipoUsuario(entity);
    }

    public TipoUsuario getTipoUsuario(Long tiusId) throws Exception {
        TipoUsuario tipoUsuario = null;

        try {
            tipoUsuario = tipoUsuarioLogic.getTipoUsuario(tiusId);
        } catch (Exception e) {
            throw e;
        }

        return tipoUsuario;
    }

    public List<TipoUsuario> findByCriteriaInTipoUsuario(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return tipoUsuarioLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<TipoUsuario> findPageTipoUsuario(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return tipoUsuarioLogic.findPageTipoUsuario(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberTipoUsuario() throws Exception {
        return tipoUsuarioLogic.findTotalNumberTipoUsuario();
    }

    public List<TipoUsuarioDTO> getDataTipoUsuario() throws Exception {
        return tipoUsuarioLogic.getDataTipoUsuario();
    }

    public void validateTipoUsuario(TipoUsuario tipoUsuario)
        throws Exception {
        tipoUsuarioLogic.validateTipoUsuario(tipoUsuario);
    }

	@Override
	public Response autenticar(String usuUsuario, String clave) {
		return usuarioLogic.autenticar(usuUsuario, clave);
	}
}
