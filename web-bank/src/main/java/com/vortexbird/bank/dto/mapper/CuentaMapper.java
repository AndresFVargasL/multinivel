package com.vortexbird.bank.dto.mapper;

import com.vortexbird.bank.model.*;
import com.vortexbird.bank.model.Cuenta;
import com.vortexbird.bank.model.control.*;
import com.vortexbird.bank.model.dto.CuentaDTO;

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
public class CuentaMapper implements ICuentaMapper {
    private static final Logger log = LoggerFactory.getLogger(CuentaMapper.class);

    /**
    * Logic injected by Spring that manages Cliente entities
    *
    */
    @Autowired
    IClienteLogic logicCliente1;

    @Transactional(readOnly = true)
    public CuentaDTO cuentaToCuentaDTO(Cuenta cuenta) throws Exception {
        try {
            CuentaDTO cuentaDTO = new CuentaDTO();

            cuentaDTO.setCuenId(cuenta.getCuenId());
            cuentaDTO.setActiva((cuenta.getActiva() != null)
                ? cuenta.getActiva() : null);
            cuentaDTO.setClave((cuenta.getClave() != null) ? cuenta.getClave()
                                                           : null);
            cuentaDTO.setSaldo((cuenta.getSaldo() != null) ? cuenta.getSaldo()
                                                           : null);

            if (cuenta.getCliente() != null) {
                cuentaDTO.setClieId_Cliente(cuenta.getCliente().getClieId());
            } else {
                cuentaDTO.setClieId_Cliente(null);
            }

            return cuentaDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Cuenta cuentaDTOToCuenta(CuentaDTO cuentaDTO)
        throws Exception {
        try {
            Cuenta cuenta = new Cuenta();

            cuenta.setCuenId(cuentaDTO.getCuenId());
            cuenta.setActiva((cuentaDTO.getActiva() != null)
                ? cuentaDTO.getActiva() : null);
            cuenta.setClave((cuentaDTO.getClave() != null)
                ? cuentaDTO.getClave() : null);
            cuenta.setSaldo((cuentaDTO.getSaldo() != null)
                ? cuentaDTO.getSaldo() : null);

            Cliente cliente = new Cliente();

            if (cuentaDTO.getClieId_Cliente() != null) {
                cliente = logicCliente1.getCliente(cuentaDTO.getClieId_Cliente());
            }

            if (cliente != null) {
                cuenta.setCliente(cliente);
            }

            return cuenta;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<CuentaDTO> listCuentaToListCuentaDTO(List<Cuenta> listCuenta)
        throws Exception {
        try {
            List<CuentaDTO> cuentaDTOs = new ArrayList<CuentaDTO>();

            for (Cuenta cuenta : listCuenta) {
                CuentaDTO cuentaDTO = cuentaToCuentaDTO(cuenta);

                cuentaDTOs.add(cuentaDTO);
            }

            return cuentaDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Cuenta> listCuentaDTOToListCuenta(List<CuentaDTO> listCuentaDTO)
        throws Exception {
        try {
            List<Cuenta> listCuenta = new ArrayList<Cuenta>();

            for (CuentaDTO cuentaDTO : listCuentaDTO) {
                Cuenta cuenta = cuentaDTOToCuenta(cuentaDTO);

                listCuenta.add(cuenta);
            }

            return listCuenta;
        } catch (Exception e) {
            throw e;
        }
    }
}
