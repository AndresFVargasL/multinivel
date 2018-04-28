package com.vortexbird.bank.model.control;

import com.vortexbird.bank.dataaccess.dao.*;
import com.vortexbird.bank.dto.mapper.ITransaccionMapper;
import com.vortexbird.bank.exceptions.*;
import com.vortexbird.bank.model.*;
import com.vortexbird.bank.model.dto.Response;
import com.vortexbird.bank.model.dto.TransaccionAngular;
import com.vortexbird.bank.model.dto.TransaccionDTO;
import com.vortexbird.bank.utilities.Constantes;
import com.vortexbird.bank.utilities.Utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service("TransaccionLogic")
public class TransaccionLogic implements ITransaccionLogic {
    private static final Logger log = LoggerFactory.getLogger(TransaccionLogic.class);

    /**
     * DAO injected by Spring that manages Transaccion entities
     *
     */
    @Autowired
    private ITransaccionDAO transaccionDAO;
    @Autowired
    private ITransaccionMapper transaccionMapper;
    @Autowired
    private Validator validator;

    /**
    * Logic injected by Spring that manages Cuenta entities
    *
    */
    @Autowired
    ICuentaLogic logicCuenta1;

    /**
    * Logic injected by Spring that manages TipoTransaccion entities
    *
    */
    @Autowired
    ITipoTransaccionLogic logicTipoTransaccion2;

    /**
    * Logic injected by Spring that manages Usuario entities
    *
    */
    @Autowired
    IUsuarioLogic logicUsuario3;
    
    @Autowired
    private IClienteLogic clienteLogic;

    public void validateTransaccion(Transaccion transaccion)
        throws Exception {
        try {
            Set<ConstraintViolation<Transaccion>> constraintViolations = validator.validate(transaccion);

            if (constraintViolations.size() > 0) {
                StringBuilder strMessage = new StringBuilder();

                for (ConstraintViolation<Transaccion> constraintViolation : constraintViolations) {
                    strMessage.append(constraintViolation.getPropertyPath()
                                                         .toString());
                    strMessage.append(" - ");
                    strMessage.append(constraintViolation.getMessage());
                    strMessage.append(". \n");
                }

                throw new Exception(strMessage.toString());
            }
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Transaccion> getTransaccion() throws Exception {
        log.debug("finding all Transaccion instances");

        List<Transaccion> list = new ArrayList<Transaccion>();

        try {
            list = transaccionDAO.findAll();
        } catch (Exception e) {
            log.error("finding all Transaccion failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "Transaccion");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveTransaccion(Transaccion entity) throws Exception {
        log.debug("saving Transaccion instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion("Transaccion");
            }

            validateTransaccion(entity);

            if (entity.getTranId() != null && getTransaccion(entity.getTranId()) != null) {
                throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
            }

            transaccionDAO.save(entity);

            log.debug("save Transaccion successful");
        } catch (Exception e) {
            log.error("save Transaccion failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteTransaccion(Transaccion entity) throws Exception {
        log.debug("deleting Transaccion instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion("Transaccion");
        }

        if (entity.getTranId() == null) {
            throw new ZMessManager().new EmptyFieldException("tranId");
        }

        try {
            transaccionDAO.delete(entity);

            log.debug("delete Transaccion successful");
        } catch (Exception e) {
            log.error("delete Transaccion failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateTransaccion(Transaccion entity) throws Exception {
        log.debug("updating Transaccion instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion("Transaccion");
            }

            validateTransaccion(entity);

            transaccionDAO.update(entity);

            log.debug("update Transaccion successful");
        } catch (Exception e) {
            log.error("update Transaccion failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<TransaccionDTO> getDataTransaccion() throws Exception {
        try {
            List<Transaccion> transaccion = transaccionDAO.findAll();

            List<TransaccionDTO> transaccionDTO = new ArrayList<TransaccionDTO>();

            for (Transaccion transaccionTmp : transaccion) {
                TransaccionDTO transaccionDTO2 = transaccionMapper.transaccionToTransaccionDTO(transaccionTmp);
                transaccionDTO.add(transaccionDTO2);
            }

            return transaccionDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Transaccion getTransaccion(Long tranId) throws Exception {
        log.debug("getting Transaccion instance");

        Transaccion entity = null;

        try {
            entity = transaccionDAO.findById(tranId);
        } catch (Exception e) {
            log.error("get Transaccion failed", e);
            throw new ZMessManager().new FindingException("Transaccion");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<Transaccion> findPageTransaccion(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        List<Transaccion> entity = null;

        try {
            entity = transaccionDAO.findPage(sortColumnName, sortAscending,
                    startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("Transaccion Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberTransaccion() throws Exception {
        Long entity = null;

        try {
            entity = transaccionDAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("Transaccion Count");
        } finally {
        }

        return entity;
    }

    /**
    *
    * @param varibles
    *            este arreglo debera tener:
    *
    * [0] = String variable = (String) varibles[i]; representa como se llama la
    * variable en el pojo
    *
    * [1] = Boolean booVariable = (Boolean) varibles[i + 1]; representa si el
    * valor necesita o no ''(comillas simples)usado para campos de tipo string
    *
    * [2] = Object value = varibles[i + 2]; representa el valor que se va a
    * buscar en la BD
    *
    * [3] = String comparator = (String) varibles[i + 3]; representa que tipo
    * de busqueda voy a hacer.., ejemplo: where nombre=william o where nombre<>william,
        * en este campo iria el tipo de comparador que quiero si es = o <>
            *
            * Se itera de 4 en 4..., entonces 4 registros del arreglo representan 1
            * busqueda en un campo, si se ponen mas pues el continuara buscando en lo
            * que se le ingresen en los otros 4
            *
            *
            * @param variablesBetween
            *
            * la diferencia son estas dos posiciones
            *
            * [0] = String variable = (String) varibles[j]; la variable ne la BD que va
            * a ser buscada en un rango
            *
            * [1] = Object value = varibles[j + 1]; valor 1 para buscar en un rango
            *
            * [2] = Object value2 = varibles[j + 2]; valor 2 para buscar en un rango
            * ejempolo: a > 1 and a < 5 --> 1 seria value y 5 seria value2
                *
                * [3] = String comparator1 = (String) varibles[j + 3]; comparador 1
                * ejemplo: a comparator1 1 and a < 5
                    *
                    * [4] = String comparator2 = (String) varibles[j + 4]; comparador 2
                    * ejemplo: a comparador1>1  and a comparador2<5  (el original: a > 1 and a <
                            * 5) *
                            * @param variablesBetweenDates(en
                            *            este caso solo para mysql)
                            *  [0] = String variable = (String) varibles[k]; el nombre de la variable que hace referencia a
                            *            una fecha
                            *
                            * [1] = Object object1 = varibles[k + 2]; fecha 1 a comparar(deben ser
                            * dates)
                            *
                            * [2] = Object object2 = varibles[k + 3]; fecha 2 a comparar(deben ser
                            * dates)
                            *
                            * esto hace un between entre las dos fechas.
                            *
                            * @return lista con los objetos que se necesiten
                            * @throws Exception
                            */
    @Transactional(readOnly = true)
    public List<Transaccion> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<Transaccion> list = new ArrayList<Transaccion>();
        String where = new String();
        String tempWhere = new String();

        if (variables != null) {
            for (int i = 0; i < variables.length; i++) {
                if ((variables[i] != null) && (variables[i + 1] != null) &&
                        (variables[i + 2] != null) &&
                        (variables[i + 3] != null)) {
                    String variable = (String) variables[i];
                    Boolean booVariable = (Boolean) variables[i + 1];
                    Object value = variables[i + 2];
                    String comparator = (String) variables[i + 3];

                    if (booVariable.booleanValue()) {
                        tempWhere = (tempWhere.length() == 0)
                            ? ("(model." + variable + " " + comparator + " \'" +
                            value + "\' )")
                            : (tempWhere + " AND (model." + variable + " " +
                            comparator + " \'" + value + "\' )");
                    } else {
                        tempWhere = (tempWhere.length() == 0)
                            ? ("(model." + variable + " " + comparator + " " +
                            value + " )")
                            : (tempWhere + " AND (model." + variable + " " +
                            comparator + " " + value + " )");
                    }
                }

                i = i + 3;
            }
        }

        if (variablesBetween != null) {
            for (int j = 0; j < variablesBetween.length; j++) {
                if ((variablesBetween[j] != null) &&
                        (variablesBetween[j + 1] != null) &&
                        (variablesBetween[j + 2] != null) &&
                        (variablesBetween[j + 3] != null) &&
                        (variablesBetween[j + 4] != null)) {
                    String variable = (String) variablesBetween[j];
                    Object value = variablesBetween[j + 1];
                    Object value2 = variablesBetween[j + 2];
                    String comparator1 = (String) variablesBetween[j + 3];
                    String comparator2 = (String) variablesBetween[j + 4];
                    tempWhere = (tempWhere.length() == 0)
                        ? ("(" + value + " " + comparator1 + " " + variable +
                        " and " + variable + " " + comparator2 + " " + value2 +
                        " )")
                        : (tempWhere + " AND (" + value + " " + comparator1 +
                        " " + variable + " and " + variable + " " +
                        comparator2 + " " + value2 + " )");
                }

                j = j + 4;
            }
        }

        if (variablesBetweenDates != null) {
            for (int k = 0; k < variablesBetweenDates.length; k++) {
                if ((variablesBetweenDates[k] != null) &&
                        (variablesBetweenDates[k + 1] != null) &&
                        (variablesBetweenDates[k + 2] != null)) {
                    String variable = (String) variablesBetweenDates[k];
                    Object object1 = variablesBetweenDates[k + 1];
                    Object object2 = variablesBetweenDates[k + 2];
                    String value = null;
                    String value2 = null;

                    try {
                        Date date1 = (Date) object1;
                        Date date2 = (Date) object2;
                        value = Utilities.formatDateWithoutTimeInAStringForBetweenWhere(date1);
                        value2 = Utilities.formatDateWithoutTimeInAStringForBetweenWhere(date2);
                    } catch (Exception e) {
                        list = null;
                        throw e;
                    }

                    tempWhere = (tempWhere.length() == 0)
                        ? ("(model." + variable + " between " + value +
                        " and " + value2 + ")")
                        : (tempWhere + " AND (model." + variable + " between " +
                        value + " and " + value2 + ")");
                }

                k = k + 2;
            }
        }

        if (tempWhere.length() == 0) {
            where = null;
        } else {
            where = "(" + tempWhere + ")";
        }

        try {
            list = transaccionDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
    
    
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
    public synchronized Response consignar(TransaccionAngular transaccion) throws Exception {
    	Response response = null;
    	
    	try {
    		
    		if (transaccion.getValor() == null) {
    			throw new Exception("Por favor ingrese el valor a consignar");
    		}
    		
    		if (transaccion.getValor() == 0D) {
    			throw new Exception("No se puede consignar un valor inferior a $1");
    		}
    		
    		if (transaccion.getValor() < 0D) {
    			throw new Exception("No se puede consignar un valor inferior a $1");
    		}
    		
    		Double valor = transaccion.getValor();
    		
    		if(transaccion.getCuenta() == null){
    			throw new Exception("Por favor digite la cuenta");
    		}
    		
    		if(transaccion.getCuenta().trim().equals("")){
    			throw new Exception("Por favor digite la cuenta");
    		}
    		
    		if(transaccion.getCuenta().length() != 16){
    			throw new Exception("El formato de cuenta es inválido");
    		}
    		
    		String numeroCuenta = Utilities.subStringCuenta(transaccion.getCuenta());
    		
    		List<Cuenta> consultaCuenta = logicCuenta1.findByCriteria(new Object[]{"cuenId", true, numeroCuenta, "="}, null, null);
    		if(consultaCuenta == null || consultaCuenta.isEmpty()){
    			throw new Exception("No se ha encontrado la cuenta activa o no existe");
    		}
    		Cuenta cuenta = consultaCuenta.get(0);
    		
    		if(transaccion.getTipoTransaccion() == null){
    			throw new Exception("No fué posible reconocer el tipo de transacción");
    		}else if (transaccion.getTipoTransaccion() == 0L){
    			throw new Exception("No fué posible reconocer el tipo de transacción");
    		}
    		
    		Long tipoTransaccionCuenta = transaccion.getTipoTransaccion();
    		
    		List<TipoTransaccion> consultaTipoTransaccion = logicTipoTransaccion2.findByCriteria(new Object[]{"titrId", false, tipoTransaccionCuenta, "=",
    																									      "activo", true, Constantes.ESTADO_ACTIVO, "="}, null, null);
    		if(consultaTipoTransaccion == null || consultaTipoTransaccion.isEmpty()){
    			throw new Exception("No ha sido parametrizado el tipo de transaccion");
    		}
    		TipoTransaccion tipoTransaccion = consultaTipoTransaccion.get(0);
    		
    		if(transaccion.getUsuario() == null){
    			throw new Exception("Por favor inicie sesión");
    		}
    		
    		if(transaccion.getUsuario().trim().equals("")){
    			throw new Exception("Por favor inicie sesión");
    		}
    		
    		String user = transaccion.getUsuario();
    		
    		
    		
    		List<Usuario> consultaUsuario = logicUsuario3.findByCriteria(new Object[]{"usuUsuario", true, user, "=",
    																				  "activo", true, Constantes.ESTADO_ACTIVO, "="}, null, null);
    		
    		if(consultaUsuario == null || consultaUsuario.isEmpty()){
    			throw new Exception("No existe el usuario "+user+" o no esta activo");
    		}
    		Usuario usuario = consultaUsuario.get(0);
    		
    		if(transaccion.getCedula() == null){
    			throw new Exception("Por favor digite la cedula del cliente");
    		}else if (transaccion.getCedula() == 0L){
    			throw new Exception("Por favor digite la cedula del cliente");
    		}
    		
    		Long cedulaCliente = transaccion.getCedula();
    		
    		List<Cliente> consultaCliente = clienteLogic.findByCriteria(new Object[]{"clieId", false, cedulaCliente, "=",
    																				 "activo", true, Constantes.ESTADO_ACTIVO, "="}, null, null);
    		if(consultaCliente == null || consultaCliente.isEmpty()){
    			throw new Exception("No existe el cliente con cedula "+cedulaCliente+" o no esta activo");
    		}
    		Cliente cliente = consultaCliente.get(0);
    		
    		if(!cliente.getClieId().equals(cuenta.getCliente().getClieId())){
    			throw new Exception("La cuenta no pertenece a la cédula indicada");
    		}
    		
    		Transaccion consignacion = new Transaccion();
    		consignacion.setTranId(null);
    		consignacion.setCuenta(cuenta);
    		consignacion.setTipoTransaccion(tipoTransaccion);
    		consignacion.setUsuario(usuario);
    		consignacion.setFecha(new Date());
    		consignacion.setValor(valor);
    		
    		this.saveTransaccion(consignacion);
    		
    		cuenta.setSaldo(cuenta.getSaldo() + valor);
    		cuenta.setActiva(Constantes.ESTADO_ACTIVO);
    		
    		logicCuenta1.updateCuenta(cuenta);
			
    		response = new Response();
			response.setCodigo("0");
			response.setMensaje("Consignación realizada exitosamente");
			response.setNombre("Consignación realizada exitosamente");
    		log.info("### Se ha realizado la transacción exitosamente ###");
		} catch (Exception e) {
			
			response = new Response();
			response.setCodigo("1");
			response.setMensaje(e.getMessage());
			response.setNombre(e.getMessage());
			log.error("#### Transaccion Fallida ####", e);
		}
    	
    	return response;
    	
    }
    
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
    public synchronized Response retirar(TransaccionAngular transaccion) throws Exception {
    	Response response = null;
    	
    	try {
    		
    		if (transaccion.getValor() == null) {
    			throw new Exception("Por favor ingrese el valor a retirar");
    		}
    		
    		if (transaccion.getValor() == 0D) {
    			throw new Exception("No se puede retirar un valor inferior a $1");
    		}
    		
    		if (transaccion.getValor() < 0D) {
    			throw new Exception("No se puede retirar un valor inferior a $1");
    		}
    		
    		Double valor = transaccion.getValor();
    		
    		if(transaccion.getCuenta() == null){
    			throw new Exception("Por favor digite la cuenta");
    		}
    		
    		if(transaccion.getCuenta().trim().equals("")){
    			throw new Exception("Por favor digite la cuenta");
    		}
    		
    		if(transaccion.getCuenta().length() != 16){
    			throw new Exception("El formato de cuenta es inválido");
    		}
    		
    		String numeroCuenta = Utilities.subStringCuenta(transaccion.getCuenta());
    		
    		List<Cuenta> consultaCuenta = logicCuenta1.findByCriteria(new Object[]{"cuenId", true, numeroCuenta, "=",
    																			   "activa", true, Constantes.ESTADO_ACTIVO, "="}, null, null);
    		if(consultaCuenta == null || consultaCuenta.isEmpty()){
    			throw new Exception("No se ha encontrado la cuenta activa o no existe");
    		}
    		Cuenta cuenta = consultaCuenta.get(0);
    		
    		if(transaccion.getTipoTransaccion() == null){
    			throw new Exception("No fué posible reconocer el tipo de transacción");
    		}else if (transaccion.getTipoTransaccion() == 0L){
    			throw new Exception("No fué posible reconocer el tipo de transacción");
    		}
    		
    		Long tipoTransaccionCuenta = transaccion.getTipoTransaccion();
    		
    		List<TipoTransaccion> consultaTipoTransaccion = logicTipoTransaccion2.findByCriteria(new Object[]{"titrId", false, tipoTransaccionCuenta, "=",
    																									      "activo", true, Constantes.ESTADO_ACTIVO, "="}, null, null);
    		if(consultaTipoTransaccion == null || consultaTipoTransaccion.isEmpty()){
    			throw new Exception("No ha sido parametrizado el tipo de transaccion");
    		}
    		TipoTransaccion tipoTransaccion = consultaTipoTransaccion.get(0);
    		
    		if(transaccion.getUsuario() == null){
    			throw new Exception("Por favor inicie sesión");
    		}
    		
    		if(transaccion.getUsuario().trim().equals("")){
    			throw new Exception("Por favor inicie sesión");
    		}
    		
    		String user = transaccion.getUsuario();
    		
    		
    		
    		List<Usuario> consultaUsuario = logicUsuario3.findByCriteria(new Object[]{"usuUsuario", true, user, "=",
    																				  "activo", true, Constantes.ESTADO_ACTIVO, "="}, null, null);
    		
    		if(consultaUsuario == null || consultaUsuario.isEmpty()){
    			throw new Exception("No existe el usuario "+user+" o no esta activo");
    		}
    		Usuario usuario = consultaUsuario.get(0);
    		
    		if(transaccion.getCedula() == null){
    			throw new Exception("Por favor digite la cedula del cliente");
    		}else if (transaccion.getCedula() == 0L){
    			throw new Exception("Por favor digite la cedula del cliente");
    		}
    		
    		Long cedulaCliente = transaccion.getCedula();
    		
    		List<Cliente> consultaCliente = clienteLogic.findByCriteria(new Object[]{"clieId", false, cedulaCliente, "=",
    																				 "activo", true, Constantes.ESTADO_ACTIVO, "="}, null, null);
    		if(consultaCliente == null || consultaCliente.isEmpty()){
    			throw new Exception("No existe el cliente con cedula "+cedulaCliente+" o no esta activo");
    		}
    		Cliente cliente = consultaCliente.get(0);
    		
    		if(!cliente.getClieId().equals(cuenta.getCliente().getClieId())){
    			throw new Exception("La cuenta no pertenece a la cédula indicada");
    		}
    		
    		if(transaccion.getCuenta() == null){
    			throw new Exception("Por favor digite la clave de la cuenta");
    		}
    		
    		if(transaccion.getCuenta().trim().equals("")){
    			throw new Exception("Por favor digite la clave de la cuenta");
    		}
    		if(!cuenta.getClave().trim().equals(transaccion.getClave().trim())){
    			throw new Exception("Las claves no coinciden");
    		}
    		
    		Double nuevoSaldo = cuenta.getSaldo() - transaccion.getValor();
    		
    		if(nuevoSaldo < 0){
    			throw new Exception("No hay suficiente saldo para retirar de la cuenta");
    		}
    		
    		Transaccion retiro = new Transaccion();
    		retiro.setTranId(null);
    		retiro.setCuenta(cuenta);
    		retiro.setTipoTransaccion(tipoTransaccion);
    		retiro.setUsuario(usuario);
    		retiro.setFecha(new Date());
    		retiro.setValor(valor);
    		
    		this.saveTransaccion(retiro);
    		
    		cuenta.setSaldo(nuevoSaldo);
    		
    		logicCuenta1.updateCuenta(cuenta);
			
    		response = new Response();
			response.setCodigo("0");
			response.setMensaje("Retiro realizado exitosamente");
			response.setNombre("Retiro realizado exitosamente");
			
    		log.info("### Se ha realizado la transacción exitosamente ###");
		} catch (Exception e) {
			
			response = new Response();
			response.setCodigo("1");
			response.setMensaje(e.getMessage());
			response.setNombre(e.getMessage());
			log.error("#### Transaccion Fallida ####", e);
		}
    	
    	return response;
    	
    }
    
}
