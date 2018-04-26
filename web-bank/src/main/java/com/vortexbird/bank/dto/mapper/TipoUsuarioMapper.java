package com.vortexbird.bank.dto.mapper;

import com.vortexbird.bank.model.*;
import com.vortexbird.bank.model.TipoUsuario;
import com.vortexbird.bank.model.control.*;
import com.vortexbird.bank.model.dto.TipoUsuarioDTO;

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
public class TipoUsuarioMapper implements ITipoUsuarioMapper {
    private static final Logger log = LoggerFactory.getLogger(TipoUsuarioMapper.class);

    @Transactional(readOnly = true)
    public TipoUsuarioDTO tipoUsuarioToTipoUsuarioDTO(TipoUsuario tipoUsuario)
        throws Exception {
        try {
            TipoUsuarioDTO tipoUsuarioDTO = new TipoUsuarioDTO();

            tipoUsuarioDTO.setTiusId(tipoUsuario.getTiusId());
            tipoUsuarioDTO.setActivo((tipoUsuario.getActivo() != null)
                ? tipoUsuario.getActivo() : null);
            tipoUsuarioDTO.setNombre((tipoUsuario.getNombre() != null)
                ? tipoUsuario.getNombre() : null);

            return tipoUsuarioDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public TipoUsuario tipoUsuarioDTOToTipoUsuario(
        TipoUsuarioDTO tipoUsuarioDTO) throws Exception {
        try {
            TipoUsuario tipoUsuario = new TipoUsuario();

            tipoUsuario.setTiusId(tipoUsuarioDTO.getTiusId());
            tipoUsuario.setActivo((tipoUsuarioDTO.getActivo() != null)
                ? tipoUsuarioDTO.getActivo() : null);
            tipoUsuario.setNombre((tipoUsuarioDTO.getNombre() != null)
                ? tipoUsuarioDTO.getNombre() : null);

            return tipoUsuario;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<TipoUsuarioDTO> listTipoUsuarioToListTipoUsuarioDTO(
        List<TipoUsuario> listTipoUsuario) throws Exception {
        try {
            List<TipoUsuarioDTO> tipoUsuarioDTOs = new ArrayList<TipoUsuarioDTO>();

            for (TipoUsuario tipoUsuario : listTipoUsuario) {
                TipoUsuarioDTO tipoUsuarioDTO = tipoUsuarioToTipoUsuarioDTO(tipoUsuario);

                tipoUsuarioDTOs.add(tipoUsuarioDTO);
            }

            return tipoUsuarioDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<TipoUsuario> listTipoUsuarioDTOToListTipoUsuario(
        List<TipoUsuarioDTO> listTipoUsuarioDTO) throws Exception {
        try {
            List<TipoUsuario> listTipoUsuario = new ArrayList<TipoUsuario>();

            for (TipoUsuarioDTO tipoUsuarioDTO : listTipoUsuarioDTO) {
                TipoUsuario tipoUsuario = tipoUsuarioDTOToTipoUsuario(tipoUsuarioDTO);

                listTipoUsuario.add(tipoUsuario);
            }

            return listTipoUsuario;
        } catch (Exception e) {
            throw e;
        }
    }
}
