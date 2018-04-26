package com.vortexbird.bank.dto.mapper;

import com.vortexbird.bank.model.*;
import com.vortexbird.bank.model.TipoTransaccion;
import com.vortexbird.bank.model.control.*;
import com.vortexbird.bank.model.dto.TipoTransaccionDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Component;

import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
@Component
@Scope("singleton")
public class TipoTransaccionMapper implements ITipoTransaccionMapper {
    private static final Logger log = LoggerFactory.getLogger(TipoTransaccionMapper.class);

    @Transactional(readOnly = true)
    public TipoTransaccionDTO tipoTransaccionToTipoTransaccionDTO(
        TipoTransaccion tipoTransaccion) throws Exception {
        try {
            TipoTransaccionDTO tipoTransaccionDTO = new TipoTransaccionDTO();

            tipoTransaccionDTO.setTitrId(tipoTransaccion.getTitrId());
            tipoTransaccionDTO.setActivo((tipoTransaccion.getActivo() != null)
                ? tipoTransaccion.getActivo() : null);
            tipoTransaccionDTO.setNombre((tipoTransaccion.getNombre() != null)
                ? tipoTransaccion.getNombre() : null);

            return tipoTransaccionDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public TipoTransaccion tipoTransaccionDTOToTipoTransaccion(
        TipoTransaccionDTO tipoTransaccionDTO) throws Exception {
        try {
            TipoTransaccion tipoTransaccion = new TipoTransaccion();

            tipoTransaccion.setTitrId(tipoTransaccionDTO.getTitrId());
            tipoTransaccion.setActivo((tipoTransaccionDTO.getActivo() != null)
                ? tipoTransaccionDTO.getActivo() : null);
            tipoTransaccion.setNombre((tipoTransaccionDTO.getNombre() != null)
                ? tipoTransaccionDTO.getNombre() : null);

            return tipoTransaccion;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<TipoTransaccionDTO> listTipoTransaccionToListTipoTransaccionDTO(
        List<TipoTransaccion> listTipoTransaccion) throws Exception {
        try {
            List<TipoTransaccionDTO> tipoTransaccionDTOs = new ArrayList<TipoTransaccionDTO>();

            for (TipoTransaccion tipoTransaccion : listTipoTransaccion) {
                TipoTransaccionDTO tipoTransaccionDTO = tipoTransaccionToTipoTransaccionDTO(tipoTransaccion);

                tipoTransaccionDTOs.add(tipoTransaccionDTO);
            }

            return tipoTransaccionDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<TipoTransaccion> listTipoTransaccionDTOToListTipoTransaccion(
        List<TipoTransaccionDTO> listTipoTransaccionDTO)
        throws Exception {
        try {
            List<TipoTransaccion> listTipoTransaccion = new ArrayList<TipoTransaccion>();

            for (TipoTransaccionDTO tipoTransaccionDTO : listTipoTransaccionDTO) {
                TipoTransaccion tipoTransaccion = tipoTransaccionDTOToTipoTransaccion(tipoTransaccionDTO);

                listTipoTransaccion.add(tipoTransaccion);
            }

            return listTipoTransaccion;
        } catch (Exception e) {
            throw e;
        }
    }
}
