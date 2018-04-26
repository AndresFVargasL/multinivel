package com.vortexbird.bank.model.control;

import com.vortexbird.bank.model.Cuenta;
import com.vortexbird.bank.model.dto.CuentaDTO;

import java.math.BigDecimal;

import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface ICuentaLogic {
    public List<Cuenta> getCuenta() throws Exception;

    /**
         * Save an new Cuenta entity
         */
    public void saveCuenta(Cuenta entity) throws Exception;

    /**
         * Delete an existing Cuenta entity
         *
         */
    public void deleteCuenta(Cuenta entity) throws Exception;

    /**
        * Update an existing Cuenta entity
        *
        */
    public void updateCuenta(Cuenta entity) throws Exception;

    /**
         * Load an existing Cuenta entity
         *
         */
    public Cuenta getCuenta(String cuenId) throws Exception;

    public List<Cuenta> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Cuenta> findPageCuenta(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberCuenta() throws Exception;

    public List<CuentaDTO> getDataCuenta() throws Exception;

    public void validateCuenta(Cuenta cuenta) throws Exception;
}
