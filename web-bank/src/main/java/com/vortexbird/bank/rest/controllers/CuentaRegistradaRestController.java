package com.vortexbird.bank.rest.controllers;

import com.vortexbird.bank.dto.mapper.ICuentaRegistradaMapper;
import com.vortexbird.bank.model.*;
import com.vortexbird.bank.model.dto.CuentaRegistradaDTO;
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
@RequestMapping("/cuentaRegistrada")
public class CuentaRegistradaRestController {
    private static final Logger log = LoggerFactory.getLogger(CuentaRegistradaRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private ICuentaRegistradaMapper cuentaRegistradaMapper;

    @PostMapping(value = "/saveCuentaRegistrada")
    public void saveCuentaRegistrada(
        @RequestBody
    CuentaRegistradaDTO cuentaRegistradaDTO) throws Exception {
        try {
            CuentaRegistrada cuentaRegistrada = cuentaRegistradaMapper.cuentaRegistradaDTOToCuentaRegistrada(cuentaRegistradaDTO);

            businessDelegatorView.saveCuentaRegistrada(cuentaRegistrada);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteCuentaRegistrada/{cureId}")
    public void deleteCuentaRegistrada(@PathVariable("cureId")
    Long cureId) throws Exception {
        try {
            CuentaRegistrada cuentaRegistrada = businessDelegatorView.getCuentaRegistrada(cureId);

            businessDelegatorView.deleteCuentaRegistrada(cuentaRegistrada);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateCuentaRegistrada/")
    public void updateCuentaRegistrada(
        @RequestBody
    CuentaRegistradaDTO cuentaRegistradaDTO) throws Exception {
        try {
            CuentaRegistrada cuentaRegistrada = cuentaRegistradaMapper.cuentaRegistradaDTOToCuentaRegistrada(cuentaRegistradaDTO);

            businessDelegatorView.updateCuentaRegistrada(cuentaRegistrada);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataCuentaRegistrada")
    public List<CuentaRegistradaDTO> getDataCuentaRegistrada()
        throws Exception {
        try {
            return businessDelegatorView.getDataCuentaRegistrada();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getCuentaRegistrada/{cureId}")
    public CuentaRegistradaDTO getCuentaRegistrada(
        @PathVariable("cureId")
    Long cureId) throws Exception {
        try {
            CuentaRegistrada cuentaRegistrada = businessDelegatorView.getCuentaRegistrada(cureId);

            return cuentaRegistradaMapper.cuentaRegistradaToCuentaRegistradaDTO(cuentaRegistrada);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
