package com.vortexbird.bank.dto.mapper;

import com.vortexbird.bank.model.TipoDocumento;
import com.vortexbird.bank.model.dto.TipoDocumentoDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface ITipoDocumentoMapper {
    public TipoDocumentoDTO tipoDocumentoToTipoDocumentoDTO(
        TipoDocumento tipoDocumento) throws Exception;

    public TipoDocumento tipoDocumentoDTOToTipoDocumento(
        TipoDocumentoDTO tipoDocumentoDTO) throws Exception;

    public List<TipoDocumentoDTO> listTipoDocumentoToListTipoDocumentoDTO(
        List<TipoDocumento> tipoDocumentos) throws Exception;

    public List<TipoDocumento> listTipoDocumentoDTOToListTipoDocumento(
        List<TipoDocumentoDTO> tipoDocumentoDTOs) throws Exception;
}
