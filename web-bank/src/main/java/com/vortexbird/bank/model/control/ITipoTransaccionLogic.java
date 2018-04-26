package com.vortexbird.bank.model.control;

import com.vortexbird.bank.model.TipoTransaccion;
import com.vortexbird.bank.model.dto.TipoTransaccionDTO;

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
public interface ITipoTransaccionLogic {
    public List<TipoTransaccion> getTipoTransaccion() throws Exception;

    /**
         * Save an new TipoTransaccion entity
         */
    public void saveTipoTransaccion(TipoTransaccion entity)
        throws Exception;

    /**
         * Delete an existing TipoTransaccion entity
         *
         */
    public void deleteTipoTransaccion(TipoTransaccion entity)
        throws Exception;

    /**
        * Update an existing TipoTransaccion entity
        *
        */
    public void updateTipoTransaccion(TipoTransaccion entity)
        throws Exception;

    /**
         * Load an existing TipoTransaccion entity
         *
         */
    public TipoTransaccion getTipoTransaccion(Long titrId)
        throws Exception;

    public List<TipoTransaccion> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<TipoTransaccion> findPageTipoTransaccion(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberTipoTransaccion() throws Exception;

    public List<TipoTransaccionDTO> getDataTipoTransaccion()
        throws Exception;

    public void validateTipoTransaccion(TipoTransaccion tipoTransaccion)
        throws Exception;
}
