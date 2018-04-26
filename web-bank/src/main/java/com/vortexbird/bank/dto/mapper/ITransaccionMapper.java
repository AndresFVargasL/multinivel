package com.vortexbird.bank.dto.mapper;

import com.vortexbird.bank.model.Transaccion;
import com.vortexbird.bank.model.dto.TransaccionDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface ITransaccionMapper {
    public TransaccionDTO transaccionToTransaccionDTO(Transaccion transaccion)
        throws Exception;

    public Transaccion transaccionDTOToTransaccion(
        TransaccionDTO transaccionDTO) throws Exception;

    public List<TransaccionDTO> listTransaccionToListTransaccionDTO(
        List<Transaccion> transaccions) throws Exception;

    public List<Transaccion> listTransaccionDTOToListTransaccion(
        List<TransaccionDTO> transaccionDTOs) throws Exception;
}
