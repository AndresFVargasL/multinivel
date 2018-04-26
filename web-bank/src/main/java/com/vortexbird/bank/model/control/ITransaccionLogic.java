package com.vortexbird.bank.model.control;

import com.vortexbird.bank.model.Transaccion;
import com.vortexbird.bank.model.dto.TransaccionDTO;

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
public interface ITransaccionLogic {
    public List<Transaccion> getTransaccion() throws Exception;

    /**
         * Save an new Transaccion entity
         */
    public void saveTransaccion(Transaccion entity) throws Exception;

    /**
         * Delete an existing Transaccion entity
         *
         */
    public void deleteTransaccion(Transaccion entity) throws Exception;

    /**
        * Update an existing Transaccion entity
        *
        */
    public void updateTransaccion(Transaccion entity) throws Exception;

    /**
         * Load an existing Transaccion entity
         *
         */
    public Transaccion getTransaccion(Long tranId) throws Exception;

    public List<Transaccion> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Transaccion> findPageTransaccion(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberTransaccion() throws Exception;

    public List<TransaccionDTO> getDataTransaccion() throws Exception;

    public void validateTransaccion(Transaccion transaccion)
        throws Exception;
}
