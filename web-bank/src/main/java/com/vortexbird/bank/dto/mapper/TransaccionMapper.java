package com.vortexbird.bank.dto.mapper;

import com.vortexbird.bank.model.*;
import com.vortexbird.bank.model.Transaccion;
import com.vortexbird.bank.model.control.*;
import com.vortexbird.bank.model.dto.TransaccionDTO;

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
public class TransaccionMapper implements ITransaccionMapper {
    private static final Logger log = LoggerFactory.getLogger(TransaccionMapper.class);

    /**
    * Logic injected by Spring that manages Cuenta entities
    *
    */
    @Autowired
    ICuentaLogic logicCuenta1;

    /**
    * Logic injected by Spring that manages TipoTransaccion entities
    *
    */
    @Autowired
    ITipoTransaccionLogic logicTipoTransaccion2;

    /**
    * Logic injected by Spring that manages Usuario entities
    *
    */
    @Autowired
    IUsuarioLogic logicUsuario3;

    @Transactional(readOnly = true)
    public TransaccionDTO transaccionToTransaccionDTO(Transaccion transaccion)
        throws Exception {
        try {
            TransaccionDTO transaccionDTO = new TransaccionDTO();

            transaccionDTO.setTranId(transaccion.getTranId());
            transaccionDTO.setFecha(transaccion.getFecha());
            transaccionDTO.setValor((transaccion.getValor() != null)
                ? transaccion.getValor() : null);

            if (transaccion.getCuenta() != null) {
                transaccionDTO.setCuenId_Cuenta(transaccion.getCuenta()
                                                           .getCuenId());
            } else {
                transaccionDTO.setCuenId_Cuenta(null);
            }

            transaccionDTO.setTitrId_TipoTransaccion((transaccion.getTipoTransaccion()
                                                                 .getTitrId() != null)
                ? transaccion.getTipoTransaccion().getTitrId() : null);

            if (transaccion.getUsuario() != null) {
                transaccionDTO.setUsuUsuario_Usuario(transaccion.getUsuario()
                                                                .getUsuUsuario());
            } else {
                transaccionDTO.setUsuUsuario_Usuario(null);
            }

            return transaccionDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Transaccion transaccionDTOToTransaccion(
        TransaccionDTO transaccionDTO) throws Exception {
        try {
            Transaccion transaccion = new Transaccion();

            transaccion.setTranId(transaccionDTO.getTranId());
            transaccion.setFecha(transaccionDTO.getFecha());
            transaccion.setValor((transaccionDTO.getValor() != null)
                ? transaccionDTO.getValor() : null);

            Cuenta cuenta = new Cuenta();

            if (transaccionDTO.getCuenId_Cuenta() != null) {
                cuenta = logicCuenta1.getCuenta(transaccionDTO.getCuenId_Cuenta());
            }

            if (cuenta != null) {
                transaccion.setCuenta(cuenta);
            }

            TipoTransaccion tipoTransaccion = new TipoTransaccion();

            if (transaccionDTO.getTitrId_TipoTransaccion() != null) {
                tipoTransaccion = logicTipoTransaccion2.getTipoTransaccion(transaccionDTO.getTitrId_TipoTransaccion());
            }

            if (tipoTransaccion != null) {
                transaccion.setTipoTransaccion(tipoTransaccion);
            }

            Usuario usuario = new Usuario();

            if (transaccionDTO.getUsuUsuario_Usuario() != null) {
                usuario = logicUsuario3.getUsuario(transaccionDTO.getUsuUsuario_Usuario());
            }

            if (usuario != null) {
                transaccion.setUsuario(usuario);
            }

            return transaccion;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<TransaccionDTO> listTransaccionToListTransaccionDTO(
        List<Transaccion> listTransaccion) throws Exception {
        try {
            List<TransaccionDTO> transaccionDTOs = new ArrayList<TransaccionDTO>();

            for (Transaccion transaccion : listTransaccion) {
                TransaccionDTO transaccionDTO = transaccionToTransaccionDTO(transaccion);

                transaccionDTOs.add(transaccionDTO);
            }

            return transaccionDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Transaccion> listTransaccionDTOToListTransaccion(
        List<TransaccionDTO> listTransaccionDTO) throws Exception {
        try {
            List<Transaccion> listTransaccion = new ArrayList<Transaccion>();

            for (TransaccionDTO transaccionDTO : listTransaccionDTO) {
                Transaccion transaccion = transaccionDTOToTransaccion(transaccionDTO);

                listTransaccion.add(transaccion);
            }

            return listTransaccion;
        } catch (Exception e) {
            throw e;
        }
    }
}
