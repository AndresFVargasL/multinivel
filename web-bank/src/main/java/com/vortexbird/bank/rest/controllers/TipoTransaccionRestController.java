package com.vortexbird.bank.rest.controllers;

import com.vortexbird.bank.dto.mapper.ITipoTransaccionMapper;
import com.vortexbird.bank.model.*;
import com.vortexbird.bank.model.dto.TipoTransaccionDTO;
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
@RequestMapping("/tipoTransaccion")
public class TipoTransaccionRestController {
    private static final Logger log = LoggerFactory.getLogger(TipoTransaccionRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private ITipoTransaccionMapper tipoTransaccionMapper;

    @PostMapping(value = "/saveTipoTransaccion")
    public void saveTipoTransaccion(
        @RequestBody
    TipoTransaccionDTO tipoTransaccionDTO) throws Exception {
        try {
            TipoTransaccion tipoTransaccion = tipoTransaccionMapper.tipoTransaccionDTOToTipoTransaccion(tipoTransaccionDTO);

            businessDelegatorView.saveTipoTransaccion(tipoTransaccion);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteTipoTransaccion/{titrId}")
    public void deleteTipoTransaccion(@PathVariable("titrId")
    Long titrId) throws Exception {
        try {
            TipoTransaccion tipoTransaccion = businessDelegatorView.getTipoTransaccion(titrId);

            businessDelegatorView.deleteTipoTransaccion(tipoTransaccion);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateTipoTransaccion/")
    public void updateTipoTransaccion(
        @RequestBody
    TipoTransaccionDTO tipoTransaccionDTO) throws Exception {
        try {
            TipoTransaccion tipoTransaccion = tipoTransaccionMapper.tipoTransaccionDTOToTipoTransaccion(tipoTransaccionDTO);

            businessDelegatorView.updateTipoTransaccion(tipoTransaccion);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataTipoTransaccion")
    public List<TipoTransaccionDTO> getDataTipoTransaccion()
        throws Exception {
        try {
            return businessDelegatorView.getDataTipoTransaccion();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getTipoTransaccion/{titrId}")
    public TipoTransaccionDTO getTipoTransaccion(
        @PathVariable("titrId")
    Long titrId) throws Exception {
        try {
            TipoTransaccion tipoTransaccion = businessDelegatorView.getTipoTransaccion(titrId);

            return tipoTransaccionMapper.tipoTransaccionToTipoTransaccionDTO(tipoTransaccion);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
