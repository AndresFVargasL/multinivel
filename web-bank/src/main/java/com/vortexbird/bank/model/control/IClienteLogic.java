package com.vortexbird.bank.model.control;

import com.vortexbird.bank.model.Cliente;
import com.vortexbird.bank.model.dto.ClienteDTO;

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
public interface IClienteLogic {
    public List<Cliente> getCliente() throws Exception;

    /**
         * Save an new Cliente entity
         */
    public void saveCliente(Cliente entity) throws Exception;

    /**
         * Delete an existing Cliente entity
         *
         */
    public void deleteCliente(Cliente entity) throws Exception;

    /**
        * Update an existing Cliente entity
        *
        */
    public void updateCliente(Cliente entity) throws Exception;

    /**
         * Load an existing Cliente entity
         *
         */
    public Cliente getCliente(Long clieId) throws Exception;

    public List<Cliente> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Cliente> findPageCliente(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberCliente() throws Exception;

    public List<ClienteDTO> getDataCliente() throws Exception;

    public void validateCliente(Cliente cliente) throws Exception;
}
