package com.vortexbird.bank.dto.mapper;

import com.vortexbird.bank.model.*;
import com.vortexbird.bank.model.CuentaRegistrada;
import com.vortexbird.bank.model.control.*;
import com.vortexbird.bank.model.dto.CuentaRegistradaDTO;

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
public class CuentaRegistradaMapper implements ICuentaRegistradaMapper {
    private static final Logger log = LoggerFactory.getLogger(CuentaRegistradaMapper.class);

    /**
    * Logic injected by Spring that manages Cliente entities
    *
    */
    @Autowired
    IClienteLogic logicCliente1;

    /**
    * Logic injected by Spring that manages Cuenta entities
    *
    */
    @Autowired
    ICuentaLogic logicCuenta2;

    @Transactional(readOnly = true)
    public CuentaRegistradaDTO cuentaRegistradaToCuentaRegistradaDTO(
        CuentaRegistrada cuentaRegistrada) throws Exception {
        try {
            CuentaRegistradaDTO cuentaRegistradaDTO = new CuentaRegistradaDTO();

            cuentaRegistradaDTO.setCureId(cuentaRegistrada.getCureId());

            if (cuentaRegistrada.getCliente() != null) {
                cuentaRegistradaDTO.setClieId_Cliente(cuentaRegistrada.getCliente()
                                                                      .getClieId());
            } else {
                cuentaRegistradaDTO.setClieId_Cliente(null);
            }

            if (cuentaRegistrada.getCuenta() != null) {
                cuentaRegistradaDTO.setCuenId_Cuenta(cuentaRegistrada.getCuenta()
                                                                     .getCuenId());
            } else {
                cuentaRegistradaDTO.setCuenId_Cuenta(null);
            }

            return cuentaRegistradaDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public CuentaRegistrada cuentaRegistradaDTOToCuentaRegistrada(
        CuentaRegistradaDTO cuentaRegistradaDTO) throws Exception {
        try {
            CuentaRegistrada cuentaRegistrada = new CuentaRegistrada();

            cuentaRegistrada.setCureId(cuentaRegistradaDTO.getCureId());

            Cliente cliente = new Cliente();

            if (cuentaRegistradaDTO.getClieId_Cliente() != null) {
                cliente = logicCliente1.getCliente(cuentaRegistradaDTO.getClieId_Cliente());
            }

            if (cliente != null) {
                cuentaRegistrada.setCliente(cliente);
            }

            Cuenta cuenta = new Cuenta();

            if (cuentaRegistradaDTO.getCuenId_Cuenta() != null) {
                cuenta = logicCuenta2.getCuenta(cuentaRegistradaDTO.getCuenId_Cuenta());
            }

            if (cuenta != null) {
                cuentaRegistrada.setCuenta(cuenta);
            }

            return cuentaRegistrada;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<CuentaRegistradaDTO> listCuentaRegistradaToListCuentaRegistradaDTO(
        List<CuentaRegistrada> listCuentaRegistrada) throws Exception {
        try {
            List<CuentaRegistradaDTO> cuentaRegistradaDTOs = new ArrayList<CuentaRegistradaDTO>();

            for (CuentaRegistrada cuentaRegistrada : listCuentaRegistrada) {
                CuentaRegistradaDTO cuentaRegistradaDTO = cuentaRegistradaToCuentaRegistradaDTO(cuentaRegistrada);

                cuentaRegistradaDTOs.add(cuentaRegistradaDTO);
            }

            return cuentaRegistradaDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<CuentaRegistrada> listCuentaRegistradaDTOToListCuentaRegistrada(
        List<CuentaRegistradaDTO> listCuentaRegistradaDTO)
        throws Exception {
        try {
            List<CuentaRegistrada> listCuentaRegistrada = new ArrayList<CuentaRegistrada>();

            for (CuentaRegistradaDTO cuentaRegistradaDTO : listCuentaRegistradaDTO) {
                CuentaRegistrada cuentaRegistrada = cuentaRegistradaDTOToCuentaRegistrada(cuentaRegistradaDTO);

                listCuentaRegistrada.add(cuentaRegistrada);
            }

            return listCuentaRegistrada;
        } catch (Exception e) {
            throw e;
        }
    }
}
