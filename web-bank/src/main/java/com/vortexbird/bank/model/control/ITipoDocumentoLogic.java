package com.vortexbird.bank.model.control;

import com.vortexbird.bank.model.TipoDocumento;
import com.vortexbird.bank.model.dto.TipoDocumentoDTO;

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
public interface ITipoDocumentoLogic {
    public List<TipoDocumento> getTipoDocumento() throws Exception;

    /**
         * Save an new TipoDocumento entity
         */
    public void saveTipoDocumento(TipoDocumento entity)
        throws Exception;

    /**
         * Delete an existing TipoDocumento entity
         *
         */
    public void deleteTipoDocumento(TipoDocumento entity)
        throws Exception;

    /**
        * Update an existing TipoDocumento entity
        *
        */
    public void updateTipoDocumento(TipoDocumento entity)
        throws Exception;

    /**
         * Load an existing TipoDocumento entity
         *
         */
    public TipoDocumento getTipoDocumento(Long tdocId)
        throws Exception;

    public List<TipoDocumento> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<TipoDocumento> findPageTipoDocumento(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberTipoDocumento() throws Exception;

    public List<TipoDocumentoDTO> getDataTipoDocumento()
        throws Exception;

    public void validateTipoDocumento(TipoDocumento tipoDocumento)
        throws Exception;
}
