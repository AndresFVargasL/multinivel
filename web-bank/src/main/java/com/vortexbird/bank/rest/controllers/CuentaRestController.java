package com.vortexbird.bank.rest.controllers;

import com.vortexbird.bank.dto.mapper.ICuentaMapper;
import com.vortexbird.bank.model.*;
import com.vortexbird.bank.model.dto.CuentaDTO;
import com.vortexbird.bank.presentation.businessDelegate.IBusinessDelegatorView;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/cuenta")
public class CuentaRestController {
    private static final Logger log = LoggerFactory.getLogger(CuentaRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private ICuentaMapper cuentaMapper;

    @PostMapping(value = "/saveCuenta")
    public void saveCuenta(@RequestBody
    CuentaDTO cuentaDTO) throws Exception {
        try {
            Cuenta cuenta = cuentaMapper.cuentaDTOToCuenta(cuentaDTO);

            businessDelegatorView.saveCuenta(cuenta);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteCuenta/{cuenId}")
    public void deleteCuenta(@PathVariable("cuenId")
    String cuenId) throws Exception {
        try {
            Cuenta cuenta = businessDelegatorView.getCuenta(cuenId);

            businessDelegatorView.deleteCuenta(cuenta);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateCuenta/")
    public void updateCuenta(@RequestBody
    CuentaDTO cuentaDTO) throws Exception {
        try {
            Cuenta cuenta = cuentaMapper.cuentaDTOToCuenta(cuentaDTO);

            businessDelegatorView.updateCuenta(cuenta);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataCuenta")
    public List<CuentaDTO> getDataCuenta() throws Exception {
        try {
            return businessDelegatorView.getDataCuenta();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getCuenta/{cuenId}")
    public CuentaDTO getCuenta(@PathVariable("cuenId")
    String cuenId) throws Exception {
        try {
            Cuenta cuenta = businessDelegatorView.getCuenta(cuenId);

            return cuentaMapper.cuentaToCuentaDTO(cuenta);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
