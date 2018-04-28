package com.vortexbird.bank.rest.controllers;

import com.vortexbird.bank.dto.mapper.ITransaccionMapper;
import com.vortexbird.bank.model.*;
import com.vortexbird.bank.model.dto.Response;
import com.vortexbird.bank.model.dto.TransaccionAngular;
import com.vortexbird.bank.model.dto.TransaccionDTO;
import com.vortexbird.bank.model.dto.UsuarioDTO;
import com.vortexbird.bank.presentation.businessDelegate.IBusinessDelegatorView;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@RequestMapping("/transaccion")
public class TransaccionRestController {
    private static final Logger log = LoggerFactory.getLogger(TransaccionRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private ITransaccionMapper transaccionMapper;

    @PostMapping(value = "/saveTransaccion")
    public void saveTransaccion(@RequestBody
    TransaccionDTO transaccionDTO) throws Exception {
        try {
            Transaccion transaccion = transaccionMapper.transaccionDTOToTransaccion(transaccionDTO);

            businessDelegatorView.saveTransaccion(transaccion);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteTransaccion/{tranId}")
    public void deleteTransaccion(@PathVariable("tranId")
    Long tranId) throws Exception {
        try {
            Transaccion transaccion = businessDelegatorView.getTransaccion(tranId);

            businessDelegatorView.deleteTransaccion(transaccion);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateTransaccion/")
    public void updateTransaccion(@RequestBody
    TransaccionDTO transaccionDTO) throws Exception {
        try {
            Transaccion transaccion = transaccionMapper.transaccionDTOToTransaccion(transaccionDTO);

            businessDelegatorView.updateTransaccion(transaccion);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataTransaccion")
    public List<TransaccionDTO> getDataTransaccion() throws Exception {
        try {
            return businessDelegatorView.getDataTransaccion();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getTransaccion/{tranId}")
    public TransaccionDTO getTransaccion(@PathVariable("tranId")
    Long tranId) throws Exception {
        try {
            Transaccion transaccion = businessDelegatorView.getTransaccion(tranId);

            return transaccionMapper.transaccionToTransaccionDTO(transaccion);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
    
    @CrossOrigin
    @PostMapping(value = "/consignar")
    public Response consignar(@RequestBody TransaccionAngular transaccion) throws Exception {
        try {
            
        	return this.businessDelegatorView.consignar(transaccion);
            
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }
    
    @CrossOrigin
    @PostMapping(value = "/retirar")
    public Response retirar(@RequestBody TransaccionAngular transaccion) throws Exception {
        try {
            
        	return this.businessDelegatorView.retirar(transaccion);
            
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }
}
