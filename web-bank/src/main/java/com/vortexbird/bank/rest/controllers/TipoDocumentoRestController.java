package com.vortexbird.bank.rest.controllers;

import com.vortexbird.bank.dto.mapper.ITipoDocumentoMapper;
import com.vortexbird.bank.model.*;
import com.vortexbird.bank.model.dto.TipoDocumentoDTO;
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
@RequestMapping("/tipoDocumento")
public class TipoDocumentoRestController {
    private static final Logger log = LoggerFactory.getLogger(TipoDocumentoRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private ITipoDocumentoMapper tipoDocumentoMapper;

    @PostMapping(value = "/saveTipoDocumento")
    public void saveTipoDocumento(@RequestBody
    TipoDocumentoDTO tipoDocumentoDTO) throws Exception {
        try {
            TipoDocumento tipoDocumento = tipoDocumentoMapper.tipoDocumentoDTOToTipoDocumento(tipoDocumentoDTO);

            businessDelegatorView.saveTipoDocumento(tipoDocumento);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteTipoDocumento/{tdocId}")
    public void deleteTipoDocumento(@PathVariable("tdocId")
    Long tdocId) throws Exception {
        try {
            TipoDocumento tipoDocumento = businessDelegatorView.getTipoDocumento(tdocId);

            businessDelegatorView.deleteTipoDocumento(tipoDocumento);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateTipoDocumento/")
    public void updateTipoDocumento(
        @RequestBody
    TipoDocumentoDTO tipoDocumentoDTO) throws Exception {
        try {
            TipoDocumento tipoDocumento = tipoDocumentoMapper.tipoDocumentoDTOToTipoDocumento(tipoDocumentoDTO);

            businessDelegatorView.updateTipoDocumento(tipoDocumento);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataTipoDocumento")
    public List<TipoDocumentoDTO> getDataTipoDocumento()
        throws Exception {
        try {
            return businessDelegatorView.getDataTipoDocumento();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getTipoDocumento/{tdocId}")
    public TipoDocumentoDTO getTipoDocumento(@PathVariable("tdocId")
    Long tdocId) throws Exception {
        try {
            TipoDocumento tipoDocumento = businessDelegatorView.getTipoDocumento(tdocId);

            return tipoDocumentoMapper.tipoDocumentoToTipoDocumentoDTO(tipoDocumento);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
