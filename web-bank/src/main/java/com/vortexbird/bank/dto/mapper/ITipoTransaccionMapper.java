package com.vortexbird.bank.dto.mapper;

import com.vortexbird.bank.model.TipoTransaccion;
import com.vortexbird.bank.model.dto.TipoTransaccionDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface ITipoTransaccionMapper {
    public TipoTransaccionDTO tipoTransaccionToTipoTransaccionDTO(
        TipoTransaccion tipoTransaccion) throws Exception;

    public TipoTransaccion tipoTransaccionDTOToTipoTransaccion(
        TipoTransaccionDTO tipoTransaccionDTO) throws Exception;

    public List<TipoTransaccionDTO> listTipoTransaccionToListTipoTransaccionDTO(
        List<TipoTransaccion> tipoTransaccions) throws Exception;

    public List<TipoTransaccion> listTipoTransaccionDTOToListTipoTransaccion(
        List<TipoTransaccionDTO> tipoTransaccionDTOs) throws Exception;
}
