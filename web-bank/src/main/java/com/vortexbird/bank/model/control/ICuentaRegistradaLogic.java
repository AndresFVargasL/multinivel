package com.vortexbird.bank.model.control;

import com.vortexbird.bank.model.CuentaRegistrada;
import com.vortexbird.bank.model.dto.CuentaRegistradaDTO;

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
public interface ICuentaRegistradaLogic {
    public List<CuentaRegistrada> getCuentaRegistrada()
        throws Exception;

    /**
         * Save an new CuentaRegistrada entity
         */
    public void saveCuentaRegistrada(CuentaRegistrada entity)
        throws Exception;

    /**
         * Delete an existing CuentaRegistrada entity
         *
         */
    public void deleteCuentaRegistrada(CuentaRegistrada entity)
        throws Exception;

    /**
        * Update an existing CuentaRegistrada entity
        *
        */
    public void updateCuentaRegistrada(CuentaRegistrada entity)
        throws Exception;

    /**
         * Load an existing CuentaRegistrada entity
         *
         */
    public CuentaRegistrada getCuentaRegistrada(Long cureId)
        throws Exception;

    public List<CuentaRegistrada> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<CuentaRegistrada> findPageCuentaRegistrada(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberCuentaRegistrada() throws Exception;

    public List<CuentaRegistradaDTO> getDataCuentaRegistrada()
        throws Exception;

    public void validateCuentaRegistrada(CuentaRegistrada cuentaRegistrada)
        throws Exception;
}
